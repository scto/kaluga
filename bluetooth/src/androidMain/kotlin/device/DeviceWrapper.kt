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
import android.bluetooth.BluetoothDevice
import android.content.Context
import com.splendo.kaluga.logging.Logger
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * Accessor to the [BluetoothDevice]
 */
actual interface DeviceWrapper {
    actual val name: String?
    actual val identifier: Identifier

    /**
     * Bond state of the Device
     */
    enum class BondState {
        /**
         * Indicates the device is not bonded
         */
        NONE,

        /**
         * Indicates the device is in the process of bonding
         */
        BONDING,

        /**
         * Indicates the device s bonded
         */
        BONDED,
    }

    /**
     * The [BondState] of the device
     */
    val bondState: BondState

    /**
     * Connects to the GATT Server hosted by the [BluetoothDevice]
     * @param context the [Context] used for connecting to the GATT server
     * @param autoConnect if `true` the device will connect as soon as it becomes available, otherwise connects directly
     * @param dataLogger logger for bluetooth data
     */
    suspend fun connectGatt(context: Context, autoConnect: Boolean, dataLogger: Logger): Result<BluetoothGattWrapper>

    /**
     * Removes the bond from the device (unpair)
     */
    fun removeBond()

    /**
     * Creates a bond with the device (pair)
     */
    fun createBond()
}

/**
 * Default implementation of [DeviceWrapper]
 * @param device the [BluetoothDevice] being wrapped
 */
@SuppressLint("MissingPermission")
class DefaultDeviceWrapper(private val device: BluetoothDevice) : DeviceWrapper {

    private companion object {
        val OPERATION_TIMEOUT: Duration = 5.seconds
    }

    override val name: String?
        get() = device.name
    override val identifier: Identifier
        get() = device.address
    override val bondState: DeviceWrapper.BondState
        get() = when (device.bondState) {
            BluetoothDevice.BOND_BONDED -> DeviceWrapper.BondState.BONDED
            BluetoothDevice.BOND_BONDING -> DeviceWrapper.BondState.BONDING
            else -> DeviceWrapper.BondState.NONE
        }

    override suspend fun connectGatt(context: Context, autoConnect: Boolean, dataLogger: Logger): Result<BluetoothGattWrapper> = coroutineScope {
        val receiver = DefaultBluetoothGattReceiver(identifier, dataLogger)
        val isConnected = async(start = CoroutineStart.UNDISPATCHED) {
            withTimeoutOrNull(OPERATION_TIMEOUT) {
                receiver.events.filterIsInstance<GattEvent.OnConnected>().first()
            } != null
        }
        val gatt = device.connectGatt(context, autoConnect, receiver, BluetoothDevice.TRANSPORT_LE)

        if (isConnected.await()) {
            Result.success(DefaultBluetoothGattWrapper(gatt, receiver.events, { receiver.state }))
        } else {
            Result.failure(IllegalStateException("Gatt not connected"))
        }
    }

    override fun removeBond() {
        try {
            device.javaClass.getMethod("removeBond").invoke(device)
        } catch (localException: Exception) {
        }
    }

    override fun createBond() {
        try {
            device.createBond()
        } catch (localException: Exception) {
        }
    }
}
