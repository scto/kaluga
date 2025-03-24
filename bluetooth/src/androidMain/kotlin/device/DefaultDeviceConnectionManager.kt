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
import android.bluetooth.BluetoothGattCharacteristic.PROPERTY_INDICATE
import android.bluetooth.BluetoothGattCharacteristic.PROPERTY_NOTIFY
import android.bluetooth.BluetoothGattDescriptor
import android.content.Context
import com.splendo.kaluga.base.ApplicationHolder
import com.splendo.kaluga.bluetooth.Characteristic
import com.splendo.kaluga.bluetooth.Descriptor
import com.splendo.kaluga.bluetooth.MTU
import com.splendo.kaluga.bluetooth.UUID
import com.splendo.kaluga.bluetooth.containsAnyOf
import com.splendo.kaluga.bluetooth.uuidString
import com.splendo.kaluga.logging.error
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

internal actual class DefaultDeviceConnectionManager(
    private val context: Context,
    deviceWrapper: DeviceWrapper,
    private val connectionSettings: ConnectionSettings = ConnectionSettings(),
    coroutineScope: CoroutineScope,
) : BaseDeviceConnectionManager(deviceWrapper, connectionSettings, coroutineScope) {

    private companion object {
        val CLIENT_CONFIGURATION: UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb")
    }

    class Builder(private val context: Context = ApplicationHolder.applicationContext) : DeviceConnectionManager.Builder {
        override fun create(deviceWrapper: DeviceWrapper, settings: ConnectionSettings, coroutineScope: CoroutineScope): BaseDeviceConnectionManager =
            DefaultDeviceConnectionManager(context, deviceWrapper, settings, coroutineScope = coroutineScope)
    }

    override val coroutineContext: CoroutineContext = coroutineScope.coroutineContext

    private val gatt: BluetoothGattWrapper = DefaultBluetoothGattWrapper(
        deviceIdentifier = deviceWrapper.identifier,
        logger = dataLogger,
        createGatt = { callback -> deviceWrapper.connectGatt(context, false, callback) },
        onConnected = ::handleConnect,
        onDisconnected = ::handleDisconnect,
        coroutineContext = coroutineContext,
    )

    init {
        coroutineScope.launch {
            launch {
                gatt.notifications.collect { notification ->
                    updateCharacteristic(notification.uuid, notification.value, true)
                }
            }
        }
    }

    actual override fun getCurrentState(): DeviceConnectionManager.State = gatt.state

    actual override suspend fun connect() = gatt.connect()

    actual override suspend fun discoverServices() {
        gatt.discoverServices().getOrNull()?.let(::handleDiscoverCompleted)
    }

    actual override suspend fun disconnect() = gatt.disconnect()

    override suspend fun readRssi() {
        gatt.readRemoteRssi().getOrNull()?.let(::handleNewRssi)
    }

    actual override suspend fun requestMtu(mtu: MTU): Boolean {
        val result = gatt.requestMtu(mtu)
        result.getOrNull()?.let(::handleNewMtu)
        return result.isSuccess
    }

    actual override suspend fun didStartPerformingAction(action: DeviceAction) {
        currentAction = action
        when (action) {
            is DeviceAction.Read.Characteristic -> {
                val result = gatt.readCharacteristic(action.characteristic.wrapper)
                updateCharacteristic(action.characteristic.wrapper.uuid, result.getOrDefault(byteArrayOf()), result.isSuccess)
            }
            is DeviceAction.Read.Descriptor -> {
                val result = gatt.readDescriptor(action.descriptor.wrapper)
                updateDescriptor(action.descriptor.wrapper.uuid, result.getOrDefault(byteArrayOf()), result.isSuccess)
            }
            is DeviceAction.Write.Characteristic -> {
                val succeeded = gatt.writeCharacteristic(action.characteristic, action.newValue)
                handleUpdatedCharacteristic(action.characteristic.uuid, succeeded)
            }
            is DeviceAction.Write.Descriptor -> {
                val succeeded = gatt.writeDescriptor(action.descriptor, action.newValue)
                handleUpdatedDescriptor(action.descriptor.uuid, succeeded)
            }
            is DeviceAction.Notification.Enable -> gatt.setNotification(action.characteristic, true)
            is DeviceAction.Notification.Disable -> gatt.setNotification(action.characteristic, false)
        }
    }

    @SuppressLint("MissingPermission")
    actual override suspend fun requestStartPairing() {
        if (deviceWrapper.bondState == DeviceWrapper.BondState.NONE) {
            deviceWrapper.createBond()
        }
    }

    @SuppressLint("MissingPermission")
    actual override suspend fun requestStartUnpairing() {
        if (deviceWrapper.bondState != DeviceWrapper.BondState.NONE) {
            deviceWrapper.removeBond()
        }
    }

    private suspend fun BluetoothGattWrapper.writeCharacteristic(characteristic: Characteristic, value: ByteArray): Boolean =
        writeCharacteristic(characteristic.wrapper, value).isSuccess

    private suspend fun BluetoothGattWrapper.writeDescriptor(descriptor: Descriptor, value: ByteArray): Boolean {
        descriptor.wrapper.updateValue(value)
        return writeDescriptor(descriptor.wrapper, value).isSuccess
    }

    private suspend fun BluetoothGattWrapper.setNotification(characteristic: Characteristic, enable: Boolean): Boolean {
        val uuid = characteristic.uuid.uuidString
        if (enable) {
            notifyingCharacteristics[uuid] = characteristic
        } else {
            notifyingCharacteristics.remove(uuid)
        }
        if (!setCharacteristicNotification(characteristic.wrapper, enable).isSuccess) {
            return false
        }

        val writeValue = when {
            enable && characteristic.wrapper.containsAnyOf(PROPERTY_NOTIFY) ->
                BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
            enable && characteristic.wrapper.containsAnyOf(PROPERTY_INDICATE) ->
                BluetoothGattDescriptor.ENABLE_INDICATION_VALUE
            !enable && characteristic.wrapper.containsAnyOf(PROPERTY_INDICATE, PROPERTY_NOTIFY) ->
                BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
            else -> null
        }

        return if (writeValue != null) {
            characteristic.descriptors.firstOrNull { it.uuid == CLIENT_CONFIGURATION }?.let { descriptor ->
                descriptor.wrapper.updateValue(writeValue)
                writeDescriptor(descriptor.wrapper, writeValue).isSuccess
                    .also { succeeded -> handleCurrentActionCompleted(succeeded) }
            } == true
        } else {
            connectionSettings.logger.error {
                "(${characteristic.uuid.uuidString}) Failed attempt to perform set notification action. " +
                    "neither NOTIFICATION nor INDICATION is supported. " +
                    "Supported properties: ${characteristic.wrapper.properties}"
            }
            false
        }
    }

    private fun updateCharacteristic(uuid: UUID, value: ByteArray, succeeded: Boolean) {
        handleUpdatedCharacteristic(uuid, succeeded) {
            it.wrapper.updateValue(value)
        }
    }

    private fun updateDescriptor(uuid: UUID, value: ByteArray, succeeded: Boolean) {
        handleUpdatedDescriptor(uuid, succeeded) {
            it.wrapper.updateValue(value)
        }
    }
}
