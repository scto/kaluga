/*
 Copyright 2025 Splendo Consulting B.V. The Netherlands

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

import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGatt.GATT_CONNECTION_CONGESTED
import android.bluetooth.BluetoothGatt.GATT_CONNECTION_TIMEOUT
import android.bluetooth.BluetoothGatt.GATT_FAILURE
import android.bluetooth.BluetoothGatt.GATT_INSUFFICIENT_AUTHENTICATION
import android.bluetooth.BluetoothGatt.GATT_INSUFFICIENT_AUTHORIZATION
import android.bluetooth.BluetoothGatt.GATT_INSUFFICIENT_ENCRYPTION
import android.bluetooth.BluetoothGatt.GATT_INVALID_ATTRIBUTE_LENGTH
import android.bluetooth.BluetoothGatt.GATT_INVALID_OFFSET
import android.bluetooth.BluetoothGatt.GATT_READ_NOT_PERMITTED
import android.bluetooth.BluetoothGatt.GATT_REQUEST_NOT_SUPPORTED
import android.bluetooth.BluetoothGatt.GATT_SUCCESS
import android.bluetooth.BluetoothGatt.GATT_WRITE_NOT_PERMITTED
import android.bluetooth.BluetoothGattCallback
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.bluetooth.BluetoothProfile
import com.splendo.kaluga.bluetooth.DefaultGattServiceWrapper
import com.splendo.kaluga.bluetooth.MTU
import com.splendo.kaluga.bluetooth.RSSI
import com.splendo.kaluga.bluetooth.extensions.printableString
import com.splendo.kaluga.logging.Logger
import com.splendo.kaluga.logging.info
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import java.util.UUID

interface BluetoothGattReceiver {
    val events: Flow<GattEvent>
    val state: DeviceConnectionManager.State
}

/** Gatt callback events. */
sealed interface GattEvent {
    /** Event containing status. */
    interface WithStatus {
        val status: GattStatus
    }

    /** An event triggered by the device change, and not as a command response. */
    interface Update

    /** GATT client has connected to a remote GATT server. */
    @JvmInline
    value class OnConnected(override val status: GattStatus) :
        GattEvent,
        WithStatus,
        Update

    /** GATT client has disconnected from a remote GATT server. */
    @JvmInline
    value class OnDisconnected(override val status: GattStatus) :
        GattEvent,
        WithStatus,
        Update

    /**
     * The list of remote services, characteristics and descriptors for the
     * remote device have been updated, ie new services have been discovered.
     */
    data class OnServicesDiscovered(val services: List<DefaultGattServiceWrapper>, override val status: GattStatus) :
        GattEvent,
        WithStatus

    /** The result of a characteristic read operation. */
    data class OnCharacteristicRead(val uuid: UUID, val value: ByteArray, override val status: GattStatus) :
        GattEvent,
        WithStatus {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as OnCharacteristicRead

            if (uuid != other.uuid) return false
            if (!value.contentEquals(other.value)) return false
            if (status != other.status) return false

            return true
        }

        override fun hashCode(): Int {
            var result = uuid.hashCode()
            result = 31 * result + value.contentHashCode()
            result = 31 * result + status.hashCode()
            return result
        }
    }

    /** The result of a characteristic write operation. */
    data class OnCharacteristicWrite(val uuid: UUID, override val status: GattStatus) :
        GattEvent,
        WithStatus

    /** A remote characteristic notification. */
    data class OnCharacteristicChanged(val uuid: UUID, val value: ByteArray) :
        GattEvent,
        Update {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as OnCharacteristicChanged

            if (uuid != other.uuid) return false
            if (!value.contentEquals(other.value)) return false

            return true
        }

        override fun hashCode(): Int = 31 * uuid.hashCode() + value.contentHashCode()
    }

    /** The result of a descriptor read operation. */
    data class OnDescriptorRead(val uuid: UUID, val value: ByteArray, override val status: GattStatus) :
        GattEvent,
        WithStatus {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as OnDescriptorRead

            if (uuid != other.uuid) return false
            if (!value.contentEquals(other.value)) return false
            if (status != other.status) return false

            return true
        }

        override fun hashCode(): Int {
            var result = uuid.hashCode()
            result = 31 * result + value.contentHashCode()
            result = 31 * result + status.hashCode()
            return result
        }
    }

    /** The result of a descriptor write operation. */
    data class OnDescriptorWrite(val uuid: UUID, override val status: GattStatus) :
        GattEvent,
        WithStatus

    /** The RSSI for a remote device connection. */
    data class OnReadRemoteRssi(val rssi: RSSI, override val status: GattStatus) :
        GattEvent,
        WithStatus

    /** The MTU for a given device connection has changed. */
    data class OnMtuChanged(val mtu: MTU, override val status: GattStatus) :
        GattEvent,
        WithStatus

    /**
     * The service changed event is received
     * <p>Receiving this event means that the GATT database is out of sync with the remote device.
     * {@link BluetoothGatt#discoverServices} should be called to re-discover the services.
     */
    data object OnServiceChanged : GattEvent
}

class GattException(val status: GattStatus) : Exception(status.toString())

@JvmInline
value class GattStatus(val code: Int) {
    val isSuccess get() = code == GATT_SUCCESS

    override fun toString(): String = code.gattStatusAsString
}

class DefaultBluetoothGattReceiver(deviceIdentifier: Identifier, private val logger: Logger) :
    BluetoothGattCallback(),
    BluetoothGattReceiver {

    private val deviceIdentifier = deviceIdentifier.stringValue
    private val _events = MutableSharedFlow<GattEvent>(extraBufferCapacity = Int.MAX_VALUE)

    override val events: Flow<GattEvent> by ::_events

    override var state: DeviceConnectionManager.State = DeviceConnectionManager.State.DISCONNECTED
        private set

    private fun sendEvent(event: GattEvent) {
        require(_events.tryEmit(event))
    }

    private fun log(message: () -> String) {
        logger.info("BluetoothGattCallback $deviceIdentifier", message = message)
    }

    override fun onConnectionStateChange(gatt: BluetoothGatt?, status: Int, newState: Int) {
        val gattStatus = GattStatus(status)
        log { "onConnectionStateChange status $gattStatus newState ${newState.connectionStateAsString}" }

        when (newState) {
            BluetoothProfile.STATE_DISCONNECTED -> {
                state = DeviceConnectionManager.State.DISCONNECTED
                sendEvent(GattEvent.OnDisconnected(gattStatus))
            }
            BluetoothProfile.STATE_CONNECTED -> {
                state = DeviceConnectionManager.State.CONNECTED
                sendEvent(GattEvent.OnConnected(gattStatus))
            }
            BluetoothProfile.STATE_CONNECTING -> {
                state = DeviceConnectionManager.State.CONNECTING
            }
            BluetoothProfile.STATE_DISCONNECTING -> {
                state = DeviceConnectionManager.State.DISCONNECTING
            }
            else -> {
                state = DeviceConnectionManager.State.DISCONNECTED
            }
        }
    }

    override fun onServicesDiscovered(gatt: BluetoothGatt?, status: Int) {
        val gattStatus = GattStatus(status)
        log { "onServicesDiscovered status $gattStatus" }

        val services = gatt?.services?.map { DefaultGattServiceWrapper(it) } ?: emptyList()
        sendEvent(GattEvent.OnServicesDiscovered(services, gattStatus))
    }

    @Suppress("OVERRIDE_DEPRECATION")
    override fun onCharacteristicRead(gatt: BluetoothGatt?, characteristic: BluetoothGattCharacteristic?, status: Int) {
        val uuid = characteristic?.uuid ?: return
        val gattStatus = GattStatus(status)

        @Suppress("DEPRECATION")
        val value = characteristic.value.clone()
        log { "onCharacteristicRead[DEP] characteristic $uuid value ${value.printableString} status $gattStatus" }

        sendEvent(GattEvent.OnCharacteristicRead(uuid, value, gattStatus))
    }

    override fun onCharacteristicRead(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, value: ByteArray, status: Int) {
        val gattStatus = GattStatus(status)
        log { "onCharacteristicRead characteristic ${characteristic.uuid} value ${value.printableString} status $gattStatus" }

        sendEvent(GattEvent.OnCharacteristicRead(characteristic.uuid, value.clone(), gattStatus))
    }

    override fun onCharacteristicWrite(gatt: BluetoothGatt?, characteristic: BluetoothGattCharacteristic?, status: Int) {
        val uuid = characteristic?.uuid ?: return
        val gattStatus = GattStatus(status)
        log { "onCharacteristicWrite characteristic $uuid status $gattStatus" }

        sendEvent(GattEvent.OnCharacteristicWrite(uuid, gattStatus))
    }

    @Suppress("OVERRIDE_DEPRECATION")
    override fun onCharacteristicChanged(gatt: BluetoothGatt?, characteristic: BluetoothGattCharacteristic?) {
        val uuid = characteristic?.uuid ?: return

        @Suppress("DEPRECATION")
        val value = characteristic.value.clone()
        log { "onCharacteristicChanged[DEP] characteristic $uuid value ${value.printableString}" }

        sendEvent(GattEvent.OnCharacteristicChanged(uuid, value))
    }

    override fun onCharacteristicChanged(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic, value: ByteArray) {
        log { "onCharacteristicChanged characteristic ${characteristic.uuid} value ${value.printableString}" }
        sendEvent(GattEvent.OnCharacteristicChanged(characteristic.uuid, value.clone()))
    }

    @Suppress("OVERRIDE_DEPRECATION")
    override fun onDescriptorRead(gatt: BluetoothGatt?, descriptor: BluetoothGattDescriptor?, status: Int) {
        val uuid = descriptor?.uuid ?: return
        val gattStatus = GattStatus(status)

        @Suppress("DEPRECATION")
        val value = descriptor.value.clone()
        log { "onDescriptorRead[DEP] descriptor $uuid value ${value.printableString} status $gattStatus" }
        sendEvent(GattEvent.OnDescriptorRead(uuid, value, gattStatus))
    }

    override fun onDescriptorRead(gatt: BluetoothGatt, descriptor: BluetoothGattDescriptor, status: Int, value: ByteArray) {
        val gattStatus = GattStatus(status)
        log { "onDescriptorRead descriptor ${descriptor.uuid} value ${value.printableString} status $gattStatus" }
        sendEvent(GattEvent.OnDescriptorRead(descriptor.uuid, value.clone(), gattStatus))
    }

    override fun onDescriptorWrite(gatt: BluetoothGatt?, descriptor: BluetoothGattDescriptor?, status: Int) {
        val uuid = descriptor?.uuid ?: return
        val gattStatus = GattStatus(status)
        log { "onDescriptorWrite descriptor $uuid status $gattStatus" }
        sendEvent(GattEvent.OnDescriptorWrite(descriptor.uuid, gattStatus))
    }

    override fun onReadRemoteRssi(gatt: BluetoothGatt?, rssi: Int, status: Int) {
        val gattStatus = GattStatus(status)
        log { "onReadRemoteRssi rssi $rssi status $gattStatus" }

        sendEvent(GattEvent.OnReadRemoteRssi(rssi, gattStatus))
    }

    override fun onMtuChanged(gatt: BluetoothGatt?, mtu: Int, status: Int) {
        val gattStatus = GattStatus(status)
        log { "onMtuChanged mtu $mtu status $gattStatus" }

        sendEvent(GattEvent.OnMtuChanged(mtu, gattStatus))
    }

    override fun onServiceChanged(gatt: BluetoothGatt) {
        sendEvent(GattEvent.OnServiceChanged)
    }
}

private val Int.gattStatusAsString get() = when (this) {
    GATT_SUCCESS -> "SUCCESS"
    GATT_READ_NOT_PERMITTED -> "ERROR_READ_NOT_PERMITTED"
    GATT_WRITE_NOT_PERMITTED -> "ERROR_WRITE_NOT_PERMITTED"
    GATT_INSUFFICIENT_AUTHENTICATION -> "ERROR_INSUFFICIENT_AUTHENTICATION"
    GATT_REQUEST_NOT_SUPPORTED -> "ERROR_REQUEST_NOT_SUPPORTED"
    GATT_INSUFFICIENT_ENCRYPTION -> "ERROR_INSUFFICIENT_ENCRYPTION"
    GATT_INVALID_OFFSET -> "ERROR_INVALID_OFFSET"
    GATT_INSUFFICIENT_AUTHORIZATION -> "ERROR_INSUFFICIENT_AUTHORIZATION"
    GATT_INVALID_ATTRIBUTE_LENGTH -> "ERROR_INVALID_ATTRIBUTE_LENGTH"
    GATT_CONNECTION_CONGESTED -> "ERROR_CONNECTION_CONGESTED"
    GATT_CONNECTION_TIMEOUT -> "ERROR_CONNECTION_TIMEOUT"
    GATT_FAILURE -> "ERROR_FAILURE"
    19 -> "REMOTE_USER_TERMINATED_CONNECTION"
    133 -> "DEVICE_NOT_FOUND"
    else -> "ERROR_OTHER($this)"
}

private val Int.connectionStateAsString get() = when (this) {
    BluetoothProfile.STATE_CONNECTED -> "CONNECTED"
    BluetoothProfile.STATE_CONNECTING -> "CONNECTING"
    BluetoothProfile.STATE_DISCONNECTED -> "DISCONNECTED"
    BluetoothProfile.STATE_DISCONNECTING -> "DISCONNECTING"
    else -> "OTHER($this)"
}
