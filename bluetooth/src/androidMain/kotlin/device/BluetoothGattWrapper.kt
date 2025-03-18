/*
 Copyright (c) 2020. Splendo Consulting B.V. The Netherlands

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

 */

package com.splendo.kaluga.bluetooth.device

import android.annotation.SuppressLint
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.bluetooth.BluetoothStatusCodes
import com.splendo.kaluga.bluetooth.CharacteristicWrapper
import com.splendo.kaluga.bluetooth.DefaultGattServiceWrapper
import com.splendo.kaluga.bluetooth.DescriptorWrapper
import com.splendo.kaluga.bluetooth.MTU
import com.splendo.kaluga.bluetooth.RSSI
import com.splendo.kaluga.bluetooth.ServiceWrapper
import com.splendo.kaluga.logging.logger
import com.splendo.kaluga.logging.warn
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withTimeout
import java.util.concurrent.TimeoutException
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * A wrapper to access a [BluetoothGatt]
 */
interface BluetoothGattWrapper {

    /** Device connection state. */
    val state: DeviceConnectionManager.State

    /** Characteristics notifications. */
    val notifications: Flow<GattEvent.OnCharacteristicChanged>

    /**
     * Connect to the Bluetooth device
     * @return a result indicating whether the connection attempt was successful
     */
    suspend fun connect(): Result<Unit>

    /**
     * Discovers services offered by a remote device as well as their characteristics and descriptors.
     * @return a result indicating whether the discovery attempt was successful
     */
    suspend fun discoverServices(): Result<List<ServiceWrapper>>

    /**
     * Disconnects the current connection or cancels the current attempt if it is in progress
     */
    suspend fun disconnect()

    /**
     * Close connection to the Bluetooth Gatt server
     */
    fun close()

    /**
     * Reads the RSSI value
     * @return an RSSI value
     */
    suspend fun readRemoteRssi(): Result<RSSI>

    /**
     * Request a [MTU] size
     * @param mtu the [MTU] size
     * @return a negotiated MTU
     */
    suspend fun requestMtu(mtu: MTU): Result<MTU>

    /**
     * Reads the value of the [CharacteristicWrapper] from the device
     * @param wrapper the [CharacteristicWrapper] to read from
     * @return a characteristic value
     */
    suspend fun readCharacteristic(wrapper: CharacteristicWrapper): Result<ByteArray>

    /**
     * Reads the value of the [DeviceWrapper] from the device
     * @param wrapper the [DeviceWrapper] to read from
     * @return a descriptor value
     */
    suspend fun readDescriptor(wrapper: DescriptorWrapper): Result<ByteArray>

    /**
     * Writes a value to the [CharacteristicWrapper] from the device
     * @param wrapper the [CharacteristicWrapper] to write to
     * @param value the [ByteArray] to write
     * @return a result indicating whether  the write operation was successful
     */
    suspend fun writeCharacteristic(wrapper: CharacteristicWrapper, value: ByteArray): Result<Unit>

    /**
     * Writes a value to the [DescriptorWrapper] from the device
     * @param wrapper the [DescriptorWrapper] to write to
     * @param value the [ByteArray] to write
     * @return a result indicating whether the write operation was successful
     */
    suspend fun writeDescriptor(wrapper: DescriptorWrapper, value: ByteArray): Result<Unit>

    /**
     * Enable or disable notifications for a given [CharacteristicWrapper]
     * @param wrapper the [CharacteristicWrapper] to enable/disable notifications for
     * @param enable if `true` notifications should be enabled
     * @return a result indicating whether the requested notification status was set successfully
     */
    suspend fun setCharacteristicNotification(wrapper: CharacteristicWrapper, enable: Boolean): Result<Unit>
}

class GattCallFailedException : Exception("Gatt call failed!")

/**
 * Default implementation of [BluetoothGattWrapper]
 * @param gatt the [BluetoothGatt] being wrapped
 */
@SuppressLint("MissingPermission")
class DefaultBluetoothGattWrapper(
    private val gatt: BluetoothGatt,
    private val gattEvents: Flow<GattEvent>,
    private val gattStateProvider: () -> DeviceConnectionManager.State,
    private val operationTimeout: Duration = 5.seconds,
) : BluetoothGattWrapper {

    private suspend inline fun <reified T : GattEvent.WithStatus, R> callAndAwaitEvent(
        crossinline call: () -> Boolean,
        crossinline eventCondition: (T) -> Boolean = { true },
        crossinline getSuccessValue: (T) -> R,
    ): Result<R> = coroutineScope {
        val eventResult = async(start = CoroutineStart.UNDISPATCHED) {
            logger.warn { "Registered for ${T::class}" }
            try {
                val event = withTimeout(operationTimeout) {
                    gattEvents.onEach { logger.warn { "Incoming event $it" } }
                        .filterIsInstance<T>().first { eventCondition(it) }
                }
                logger.warn { "Event received $event" }
                if (event.status.isSuccess) {
                    Result.success(getSuccessValue(event))
                } else {
                    Result.failure(GattException(event.status.code))
                }
            } catch (e: TimeoutException) {
                Result.failure(e)
            }
        }

        logger.warn { "Call for ${T::class}" }
        if (call()) {
            eventResult.await()
        } else {
            eventResult.cancel()
            Result.failure(GattCallFailedException())
        }
    }

    private suspend inline fun <reified T : GattEvent.WithStatus> callAndAwaitEvent(crossinline call: () -> Boolean): Result<Unit> = callAndAwaitEvent<T, Unit>(call) { }

    override val state: DeviceConnectionManager.State get() = gattStateProvider()

    override val notifications: Flow<GattEvent.OnCharacteristicChanged> = gattEvents.filterIsInstance<GattEvent.OnCharacteristicChanged>()

    override suspend fun connect(): Result<Unit> = callAndAwaitEvent<GattEvent.OnConnected>(gatt::connect)

    override suspend fun discoverServices(): Result<List<ServiceWrapper>> =
        callAndAwaitEvent<GattEvent.OnServicesDiscovered, List<DefaultGattServiceWrapper>>(gatt::discoverServices) { it.services }

    override suspend fun disconnect() {
        callAndAwaitEvent<GattEvent.OnDisconnected>(call = {
            gatt.disconnect()
            true
        })
    }

    override fun close() {
        gatt.close()
    }

    override suspend fun readRemoteRssi(): Result<RSSI> = callAndAwaitEvent<GattEvent.OnReadRemoteRssi, RSSI>(gatt::readRemoteRssi) { it.rssi }

    override suspend fun requestMtu(mtu: MTU): Result<MTU> = callAndAwaitEvent<GattEvent.OnMtuChanged, MTU>(
        call = { gatt.requestMtu(mtu) },
        getSuccessValue = { it.mtu },
    )

    override suspend fun readCharacteristic(wrapper: CharacteristicWrapper): Result<ByteArray> = callAndAwaitEvent<GattEvent.OnCharacteristicRead, ByteArray>(
        call = { getCharacteristic(wrapper)?.let(gatt::readCharacteristic) == true },
        eventCondition = { it.uuid == wrapper.uuid },
        getSuccessValue = { it.value },
    )

    override suspend fun readDescriptor(wrapper: DescriptorWrapper): Result<ByteArray> = callAndAwaitEvent<GattEvent.OnDescriptorRead, ByteArray>(
        call = { getDescriptor(wrapper)?.let(gatt::readDescriptor) == true },
        eventCondition = { it.uuid == wrapper.uuid },
        getSuccessValue = { it.value },
    )

    override suspend fun writeCharacteristic(wrapper: CharacteristicWrapper, value: ByteArray): Result<Unit> = callAndAwaitEvent<GattEvent.OnCharacteristicWrite> {
        val characteristic = getCharacteristic(wrapper) ?: return@callAndAwaitEvent false
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            gatt.writeCharacteristic(characteristic, value, characteristic.writeType) == BluetoothStatusCodes.SUCCESS
        } else {
            @Suppress("DEPRECATION")
            characteristic.value = value
            @Suppress("DEPRECATION")
            gatt.writeCharacteristic(characteristic)
        }
    }

    override suspend fun writeDescriptor(wrapper: DescriptorWrapper, value: ByteArray): Result<Unit> = callAndAwaitEvent<GattEvent.OnDescriptorWrite> {
        val descriptor = getDescriptor(wrapper) ?: return@callAndAwaitEvent false
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            gatt.writeDescriptor(descriptor, value) == BluetoothStatusCodes.SUCCESS
        } else {
            @Suppress("DEPRECATION")
            descriptor.value = value
            @Suppress("DEPRECATION")
            gatt.writeDescriptor(descriptor)
        }
    }

    override suspend fun setCharacteristicNotification(wrapper: CharacteristicWrapper, enable: Boolean): Result<Unit> =
        if (getCharacteristic(wrapper)?.let { gatt.setCharacteristicNotification(it, enable) } == true) {
            Result.success(Unit)
        } else {
            Result.failure(GattCallFailedException())
        }

    private fun getCharacteristic(wrapper: CharacteristicWrapper): BluetoothGattCharacteristic? = gatt.getService(wrapper.service.uuid)?.getCharacteristic(wrapper.uuid)

    private fun getDescriptor(wrapper: DescriptorWrapper): BluetoothGattDescriptor? = getCharacteristic(wrapper.characteristic)?.getDescriptor(wrapper.uuid)
}
