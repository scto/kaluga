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
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.bluetooth.BluetoothStatusCodes
import com.splendo.kaluga.bluetooth.CharacteristicWrapper
import com.splendo.kaluga.bluetooth.DefaultGattServiceWrapper
import com.splendo.kaluga.bluetooth.DescriptorWrapper
import com.splendo.kaluga.bluetooth.MTU
import com.splendo.kaluga.bluetooth.RSSI
import com.splendo.kaluga.bluetooth.ServiceWrapper
import com.splendo.kaluga.logging.Logger
import com.splendo.kaluga.logging.info
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withTimeout
import kotlin.coroutines.CoroutineContext
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * A wrapper to access a [BluetoothGatt]
 */
interface BluetoothGattWrapper {
    /** Device connection state. */
    val state: DeviceConnectionManager.State

    /** Characteristic notifications. */
    val notifications: Flow<GattEvent.OnCharacteristicChanged>

    /**
     * Connects to the Bluetooth device
     */
    suspend fun connect()

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
class GattStatusException(val status: GattStatus) : Exception("Gatt call finished with status $status!")

/**
 * Default implementation of [BluetoothGattWrapper]
 * @param gatt the [BluetoothGatt] being wrapped
 */
@SuppressLint("MissingPermission")
class DefaultBluetoothGattWrapper(
    private val deviceIdentifier: Identifier,
    private val logger: Logger,
    private val receiver: BluetoothGattReceiver = DefaultBluetoothGattReceiver(deviceIdentifier, logger),
    private val createGatt: (BluetoothGattCallback) -> BluetoothGatt,
    private val onConnected: suspend () -> Unit,
    private val onDisconnected: suspend () -> Unit,
    private val operationTimeout: Duration = 5.seconds,
    coroutineContext: CoroutineContext,
) : BluetoothGattWrapper {
    private var gatt: BluetoothGatt? = null
    private val gattMutex = Mutex()
    private var gattDisconnectionObserver: Job? = null

    private val coroutineScope = CoroutineScope(coroutineContext)

    override val notifications: Flow<GattEvent.OnCharacteristicChanged> = receiver.events.filterIsInstance<GattEvent.OnCharacteristicChanged>()

    override var state: DeviceConnectionManager.State = DeviceConnectionManager.State.DISCONNECTED
        private set

    private fun log(message: () -> String) {
        logger.info("BluetoothGattWrapper", message = message)
    }

    private fun CoroutineScope.observeDisconnects(): Job = launch {
        receiver.events.filterIsInstance<GattEvent.OnDisconnected>().collect {
            setDisconnectedAndCloseGatt()
        }
    }

    private suspend fun Result<GattEvent.OnConnected>.handleOr(onError: suspend () -> Unit) {
        if (isSuccess && getOrThrow().status.isSuccess) {
            state = DeviceConnectionManager.State.CONNECTED
            onConnected()
        } else {
            onError()
        }
    }

    private suspend fun setDisconnectedAndCloseGatt() {
        state = DeviceConnectionManager.State.DISCONNECTED
        gattMutex.withLock {
            if (gatt != null) {
                log { "Closing Gatt.." }
                gattDisconnectionObserver?.cancel()
                gatt?.close()
                gatt = null
                log { "Gatt closed" }
            }
        }
        onDisconnected()
    }

    override suspend fun connect() = coroutineScope {
        val gatt = gattMutex.withLock {
            if (gatt == null) {
                log { "Initializing Gatt.." }
                val connected = awaitEventAsync<GattEvent.OnConnected>()
                gatt = createGatt(receiver.gattCallback)
                gattDisconnectionObserver = coroutineScope.observeDisconnects()
                val result = connected.await()
                log { "Gatt initialization result $result" }
                result.handleOr { }
            } else {
                log { "Reusing existing Gatt.." }
            }
            gatt!!
        }

        if (state != DeviceConnectionManager.State.CONNECTED) {
            log { "Attempting to connect" }
            val result = callAndAwaitEvent<GattEvent.OnConnected, GattEvent.OnConnected>(gatt::connect) { it }
            log { "Connection result $result" }
            result.handleOr {
                log { "Connection failed closing Gatt" }
                setDisconnectedAndCloseGatt()
            }
        }
    }

    override suspend fun disconnect() {
        log { "Disconnecting.." }
        val gatt = gatt
        if (gatt == null) {
            log { "Gatt is not initialized, no need to disconnect" }
        } else {
            if (state != DeviceConnectionManager.State.DISCONNECTED) {
                log { "Attempting to disconnect.." }
                val result = callAndAwaitEvent<GattEvent.OnDisconnected>(call = {
                    gatt.disconnect()
                    true
                })
                log { "Disconnection result $result" }
            }
            setDisconnectedAndCloseGatt()
        }
    }

    override suspend fun discoverServices(): Result<List<ServiceWrapper>> = withGatt("discoverServices") {
        callAndAwaitEvent<GattEvent.OnServicesDiscovered, List<DefaultGattServiceWrapper>>(::discoverServices) { it.services }
    }

    override suspend fun readRemoteRssi(): Result<RSSI> = withGatt("readRemoteRssi") {
        callAndAwaitEvent<GattEvent.OnReadRemoteRssi, RSSI>(::readRemoteRssi) { it.rssi }
    }

    override suspend fun requestMtu(mtu: MTU): Result<MTU> = withGatt("requestMtu") {
        callAndAwaitEvent<GattEvent.OnMtuChanged, MTU>(
            call = { requestMtu(mtu) },
            getSuccessValue = { it.mtu },
        )
    }

    override suspend fun readCharacteristic(wrapper: CharacteristicWrapper): Result<ByteArray> = withGatt("readCharacteristic ${wrapper.uuid}") {
        callAndAwaitEvent<GattEvent.OnCharacteristicRead, ByteArray>(
            call = { getCharacteristic(wrapper)?.let(::readCharacteristic) == true },
            eventCondition = { it.uuid == wrapper.uuid },
            getSuccessValue = { it.value },
        )
    }

    override suspend fun readDescriptor(wrapper: DescriptorWrapper): Result<ByteArray> = withGatt("readDescriptor ${wrapper.uuid}") {
        callAndAwaitEvent<GattEvent.OnDescriptorRead, ByteArray>(
            call = { getDescriptor(wrapper)?.let(::readDescriptor) == true },
            eventCondition = { it.uuid == wrapper.uuid },
            getSuccessValue = { it.value },
        )
    }

    override suspend fun writeCharacteristic(wrapper: CharacteristicWrapper, value: ByteArray): Result<Unit> = withGatt("writeCharacteristic ${wrapper.uuid}") {
        callAndAwaitEvent<GattEvent.OnCharacteristicWrite> {
            val characteristic = getCharacteristic(wrapper) ?: return@callAndAwaitEvent false
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                writeCharacteristic(characteristic, value, characteristic.writeType) == BluetoothStatusCodes.SUCCESS
            } else {
                @Suppress("DEPRECATION")
                characteristic.value = value
                @Suppress("DEPRECATION")
                writeCharacteristic(characteristic)
            }
        }
    }

    override suspend fun writeDescriptor(wrapper: DescriptorWrapper, value: ByteArray): Result<Unit> = withGatt("writeDescriptor ${wrapper.uuid}") {
        callAndAwaitEvent<GattEvent.OnDescriptorWrite> {
            val descriptor = getDescriptor(wrapper) ?: return@callAndAwaitEvent false
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                writeDescriptor(descriptor, value) == BluetoothStatusCodes.SUCCESS
            } else {
                @Suppress("DEPRECATION")
                descriptor.value = value
                @Suppress("DEPRECATION")
                writeDescriptor(descriptor)
            }
        }
    }

    override suspend fun setCharacteristicNotification(wrapper: CharacteristicWrapper, enable: Boolean): Result<Unit> = withGatt("setCharacteristicNotification ${wrapper.uuid}") {
        if (getCharacteristic(wrapper)?.let { setCharacteristicNotification(it, enable) } == true) {
            Result.success(Unit)
        } else {
            Result.failure(GattCallFailedException())
        }
    }

    private suspend fun <R> withGatt(operation: String, block: suspend BluetoothGatt.() -> Result<R>): Result<R> {
        log { "$operation: start" }
        val result = gatt?.block() ?: Result.failure(IllegalStateException("$operation: Gatt is not initialized"))
        log { "$operation: successful ${result.isSuccess}" }
        return result
    }

    private fun getCharacteristic(wrapper: CharacteristicWrapper): BluetoothGattCharacteristic? = gatt?.getService(wrapper.service.uuid)?.getCharacteristic(wrapper.uuid)

    private fun getDescriptor(wrapper: DescriptorWrapper): BluetoothGattDescriptor? = getCharacteristic(wrapper.characteristic)?.getDescriptor(wrapper.uuid)

    private inline fun <reified T : GattEvent.WithStatus> CoroutineScope.awaitEventAsync(crossinline condition: (T) -> Boolean = { true }): Deferred<Result<T>> =
        async(start = CoroutineStart.UNDISPATCHED) {
            // ensures flow observation is done in order
            try {
                withTimeout(operationTimeout) {
                    Result.success(receiver.events.filterIsInstance<T>().first { condition(it) })
                }
            } catch (e: TimeoutCancellationException) {
                Result.failure(e)
            }
        }

    private fun <T : GattEvent.WithStatus, R> Result<T>.map(successMapper: (T) -> R): Result<R> = if (isSuccess) {
        val value = getOrThrow()
        if (value.status.isSuccess) {
            Result.success(successMapper(value))
        } else {
            Result.failure(GattStatusException(value.status))
        }
    } else {
        Result.failure(exceptionOrNull()!!)
    }

    private suspend inline fun <reified T : GattEvent.WithStatus, R> callAndAwaitEvent(
        crossinline call: () -> Boolean,
        crossinline eventCondition: (T) -> Boolean = { true },
        noinline getSuccessValue: (T) -> R,
    ): Result<R> = coroutineScope {
        val asyncEvent = awaitEventAsync<T>(eventCondition)
        if (call()) {
            asyncEvent.await().map(getSuccessValue)
        } else {
            asyncEvent.cancel()
            Result.failure(GattCallFailedException())
        }
    }

    private suspend inline fun <reified T : GattEvent.WithStatus> callAndAwaitEvent(crossinline call: () -> Boolean): Result<Unit> = callAndAwaitEvent<T, Unit>(call) { it }
}
