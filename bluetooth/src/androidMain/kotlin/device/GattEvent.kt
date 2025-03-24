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

import com.splendo.kaluga.bluetooth.DefaultGattServiceWrapper
import com.splendo.kaluga.bluetooth.MTU
import com.splendo.kaluga.bluetooth.RSSI
import java.util.UUID

/** Gatt callback events. */
internal sealed interface GattEvent {
    /** Event containing status. */
    sealed interface WithStatus : GattEvent {
        val status: GattStatus
    }

    /** An event triggered by the device change, and not as a command response. */
    sealed interface Update : GattEvent

    /** Event containing data payload. */
    sealed interface WithPayload : GattEvent {
        val uuid: UUID
        val value: ByteArray
    }

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
    data class OnCharacteristicRead(override val uuid: UUID, override val value: ByteArray, override val status: GattStatus) :
        GattEvent,
        WithStatus,
        WithPayload {

        override fun equals(other: Any?): Boolean = equals(this, other)
        override fun hashCode(): Int = 31 * hashCode(this) + status.hashCode()
    }

    /** The result of a characteristic write operation. */
    data class OnCharacteristicWrite(val uuid: UUID, override val status: GattStatus) :
        GattEvent,
        WithStatus

    /** A remote characteristic notification. */
    data class OnCharacteristicChanged(override val uuid: UUID, override val value: ByteArray) :
        GattEvent,
        Update,
        WithPayload {

        override fun equals(other: Any?): Boolean = equals(this, other)
        override fun hashCode(): Int = hashCode(this)
    }

    /** The result of a descriptor read operation. */
    data class OnDescriptorRead(override val uuid: UUID, override val value: ByteArray, override val status: GattStatus) :
        GattEvent,
        WithStatus,
        WithPayload {
        override fun equals(other: Any?): Boolean = equals(this, other)
        override fun hashCode(): Int = 31 * hashCode(this) + status.hashCode()
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

private inline fun <reified T : GattEvent.WithPayload> equals(one: T, other: Any?, extraCheck: (T, T) -> Boolean = { _, _ -> true }): Boolean {
    if (one === other) return true
    if (one.javaClass != other?.javaClass) return false

    other as T

    if (one.uuid != other.uuid) return false
    if (!one.value.contentEquals(other.value)) return false
    return extraCheck(one, other)
}

private inline fun <reified T> equals(one: T, other: Any?): Boolean where T : GattEvent.WithPayload, T : GattEvent.WithStatus =
    equals(one, other) { one, other -> one.status == other.status }

private inline fun <reified T : GattEvent.WithPayload> hashCode(event: T): Int = 31 * event.uuid.hashCode() + event.value.contentHashCode()
