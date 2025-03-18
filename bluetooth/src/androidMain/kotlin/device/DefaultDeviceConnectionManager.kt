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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapConcat
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

    private val gatt = MutableStateFlow<BluetoothGattWrapper?>(null)

    init {
        coroutineScope.launch {
            gatt.flatMapConcat { it?.notifications ?: emptyFlow() }
                .collect { notification ->
                    updateCharacteristic(notification.uuid, notification.value, true)
                }
        }
    }

    actual override fun getCurrentState(): DeviceConnectionManager.State = gatt.value?.state ?: DeviceConnectionManager.State.DISCONNECTED

    private suspend fun readyGatt() = gatt.filterNotNull().first()

    @SuppressLint("MissingPermission")
    actual override suspend fun connect() {
        val readyGatt = gatt.value
        when {
            readyGatt == null -> {
                val result = deviceWrapper.connectGatt(context, false, connectionSettings.dataLogger)
                if (result.isSuccess) {
                    gatt.value = result.getOrThrow()
                    handleConnect()
                } else {
                    logger.error(logTag, result.exceptionOrNull()) { "Gatt can't be connected" }
                }
            }
            readyGatt.state == DeviceConnectionManager.State.CONNECTED || readyGatt.connect().isSuccess -> handleConnect()
            else -> handleDisconnect { closeGatt() }
        }
    }

    actual override suspend fun discoverServices() {
        readyGatt().discoverServices().getOrNull()
            ?.let(::handleDiscoverCompleted)
    }

    actual override suspend fun disconnect() {
        val readyGatt = gatt.value
        if (readyGatt != null && readyGatt.state != DeviceConnectionManager.State.DISCONNECTED) {
            readyGatt.disconnect()
        } else {
            handleDisconnect {
                closeGatt()
            }
        }
    }

    private fun closeGatt() {
        gatt.value?.close()
        gatt.value = null
    }

    override suspend fun readRssi() {
        readyGatt().readRemoteRssi().getOrNull()
            ?.let(::handleNewRssi)
    }

    actual override suspend fun requestMtu(mtu: MTU): Boolean {
        val result = readyGatt().requestMtu(mtu)
        result.getOrNull()?.let(::handleNewMtu)
        return result.isSuccess
    }

    actual override suspend fun didStartPerformingAction(action: DeviceAction) {
        currentAction = action
        when (action) {
            is DeviceAction.Read.Characteristic -> {
                val result = readyGatt().readCharacteristic(action.characteristic.wrapper)
                updateCharacteristic(action.characteristic.wrapper.uuid, result.getOrDefault(byteArrayOf()), result.isSuccess)
            }
            is DeviceAction.Read.Descriptor -> {
                val result = readyGatt().readDescriptor(action.descriptor.wrapper)
                updateDescriptor(action.descriptor.wrapper.uuid, result.getOrDefault(byteArrayOf()), result.isSuccess)
            }
            is DeviceAction.Write.Characteristic -> {
                val succeeded = readyGatt().writeCharacteristic(action.characteristic, action.newValue)
                handleUpdatedCharacteristic(action.characteristic.uuid, succeeded)
            }
            is DeviceAction.Write.Descriptor -> {
                val succeeded = readyGatt().writeDescriptor(action.descriptor, action.newValue)
                handleUpdatedDescriptor(action.descriptor.uuid, succeeded)
            }
            is DeviceAction.Notification.Enable -> readyGatt().setNotification(action.characteristic, true)
            is DeviceAction.Notification.Disable -> readyGatt().setNotification(action.characteristic, false)
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
