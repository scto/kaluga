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
import android.bluetooth.BluetoothGatt.GATT_SUCCESS
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.bluetooth.BluetoothGattService
import android.bluetooth.BluetoothProfile
import com.splendo.kaluga.bluetooth.UUID
import com.splendo.kaluga.logging.defaultLogger
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withTimeout
import org.mockito.Mockito.spy
import org.mockito.Mockito.`when`
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.seconds

class DefaultBluetoothGattReceiverTest {

    private suspend inline fun <reified T> DefaultBluetoothGattReceiver.callAndVerify(
        crossinline call: DefaultBluetoothGattReceiver.() -> Unit,
        crossinline eventVerifier: (T) -> Unit = { },
    ) = coroutineScope {
        val deferred = async(start = CoroutineStart.UNDISPATCHED) { events.filterIsInstance<T>().first() }
        call()

        val event = withTimeout(5.seconds) { deferred.await() }

        eventVerifier(event)
    }

    private fun createReceiver() = DefaultBluetoothGattReceiver("id", defaultLogger)

    @Test
    fun onConnectionStateChangeConnected() = runTest {
        val receiver = createReceiver()

        receiver.callAndVerify<GattEvent.OnConnected>(
            call = { onConnectionStateChange(null, GATT_SUCCESS, BluetoothProfile.STATE_CONNECTED) },
            eventVerifier = { assertEquals(GattStatus(GATT_SUCCESS), it.status) },
        )
    }

    @Test
    fun onConnectionStateChangeDisconnected() = runTest {
        val receiver = createReceiver()

        receiver.callAndVerify<GattEvent.OnDisconnected>(
            call = { onConnectionStateChange(null, GATT_SUCCESS, BluetoothProfile.STATE_DISCONNECTED) },
            eventVerifier = { assertEquals(GattStatus(GATT_SUCCESS), it.status) },
        )
    }

    @Test
    fun onServicesDiscovered() = runTest {
        val receiver = createReceiver()

        val gatt = spy<BluetoothGatt>()
        `when`(gatt.services).thenReturn(listOf(BluetoothGattService(UUID.randomUUID(), BluetoothGattService.SERVICE_TYPE_PRIMARY)))

        receiver.callAndVerify<GattEvent.OnServicesDiscovered>(
            call = { onServicesDiscovered(gatt, GATT_SUCCESS) },
            eventVerifier = {
                assertEquals(1, it.services.size)
                assertEquals(GattStatus(GATT_SUCCESS), it.status)
            },
        )
    }

    @Test
    fun onCharacteristicReadDeprecated() = runTest {
        val receiver = createReceiver()

        val uuid = UUID.randomUUID()
        val payload = byteArrayOf(1, 2, 3)
        val characteristic = spy(BluetoothGattCharacteristic(uuid, 0, 0))
        `when`(characteristic.uuid).thenReturn(uuid)
        `when`(characteristic.value).thenReturn(payload)

        receiver.callAndVerify<GattEvent.OnCharacteristicRead>(
            call = { onCharacteristicRead(null, characteristic, GATT_SUCCESS) },
            eventVerifier = {
                payload[0] = 0 // mutate payload
                assertEquals(uuid, it.uuid)
                assertContentEquals(byteArrayOf(1, 2, 3), it.value)
                assertEquals(GattStatus(GATT_SUCCESS), it.status)
            },
        )
    }

    @Test
    fun onCharacteristicRead() = runTest {
        val receiver = createReceiver()

        val uuid = UUID.randomUUID()
        val characteristic = spy(BluetoothGattCharacteristic(uuid, 0, 0))
        `when`(characteristic.uuid).thenReturn(uuid)

        receiver.callAndVerify<GattEvent.OnCharacteristicRead>(
            call = { onCharacteristicRead(spy<BluetoothGatt>(), characteristic, byteArrayOf(1, 2, 3), GATT_SUCCESS) },
            eventVerifier = {
                assertEquals(uuid, it.uuid)
                assertContentEquals(byteArrayOf(1, 2, 3), it.value)
                assertEquals(GattStatus(GATT_SUCCESS), it.status)
            },
        )
    }

    @Test
    fun onCharacteristicWrite() = runTest {
        val receiver = createReceiver()

        val uuid = UUID.randomUUID()
        val characteristic = spy(BluetoothGattCharacteristic(uuid, 0, 0))
        `when`(characteristic.uuid).thenReturn(uuid)

        receiver.callAndVerify<GattEvent.OnCharacteristicWrite>(
            call = { onCharacteristicWrite(null, characteristic, GATT_SUCCESS) },
            eventVerifier = {
                assertEquals(uuid, it.uuid)
                assertEquals(GattStatus(GATT_SUCCESS), it.status)
            },
        )
    }

    @Test
    fun onCharacteristicChangedDeprecated() = runTest {
        val receiver = createReceiver()

        val uuid = UUID.randomUUID()
        val payload = byteArrayOf(1, 2, 3)
        val characteristic = spy(BluetoothGattCharacteristic(uuid, 0, 0))
        `when`(characteristic.uuid).thenReturn(uuid)
        `when`(characteristic.value).thenReturn(payload)

        receiver.callAndVerify<GattEvent.OnCharacteristicChanged>(
            call = { onCharacteristicChanged(null, characteristic) },
            eventVerifier = {
                payload[0] = 0 // mutate payload
                assertEquals(uuid, it.uuid)
                assertContentEquals(byteArrayOf(1, 2, 3), it.value)
            },
        )
    }

    @Test
    fun onCharacteristicChanged() = runTest {
        val receiver = createReceiver()

        val uuid = UUID.randomUUID()
        val characteristic = spy(BluetoothGattCharacteristic(uuid, 0, 0))
        `when`(characteristic.uuid).thenReturn(uuid)

        receiver.callAndVerify<GattEvent.OnCharacteristicChanged>(
            call = { onCharacteristicChanged(spy<BluetoothGatt>(), characteristic, byteArrayOf(1, 2, 3)) },
            eventVerifier = {
                assertEquals(uuid, it.uuid)
                assertContentEquals(byteArrayOf(1, 2, 3), it.value)
            },
        )
    }

    @Test
    fun onDescriptorReadDeprecated() = runTest {
        val receiver = createReceiver()

        val uuid = UUID.randomUUID()
        val payload = byteArrayOf(1, 2, 3)
        val descriptor = spy(BluetoothGattDescriptor(uuid, 0))
        `when`(descriptor.uuid).thenReturn(uuid)
        `when`(descriptor.value).thenReturn(payload)

        receiver.callAndVerify<GattEvent.OnDescriptorRead>(
            call = { onDescriptorRead(null, descriptor, GATT_SUCCESS) },
            eventVerifier = {
                payload[0] = 0 // mutate payload
                assertEquals(uuid, it.uuid)
                assertContentEquals(byteArrayOf(1, 2, 3), it.value)
                assertEquals(GattStatus(GATT_SUCCESS), it.status)
            },
        )
    }

    @Test
    fun onDescriptorRead() = runTest {
        val receiver = createReceiver()

        val uuid = UUID.randomUUID()
        val descriptor = spy(BluetoothGattDescriptor(uuid, 0))
        `when`(descriptor.uuid).thenReturn(uuid)

        receiver.callAndVerify<GattEvent.OnDescriptorRead>(
            call = { onDescriptorRead(spy<BluetoothGatt>(), descriptor, GATT_SUCCESS, byteArrayOf(1, 2, 3)) },
            eventVerifier = {
                assertEquals(uuid, it.uuid)
                assertContentEquals(byteArrayOf(1, 2, 3), it.value)
                assertEquals(GattStatus(GATT_SUCCESS), it.status)
            },
        )
    }

    @Test
    fun onDescriptorWrite() = runTest {
        val receiver = createReceiver()

        val uuid = UUID.randomUUID()
        val descriptor = spy(BluetoothGattDescriptor(uuid, 0))
        `when`(descriptor.uuid).thenReturn(uuid)

        receiver.callAndVerify<GattEvent.OnDescriptorWrite>(
            call = { onDescriptorWrite(null, descriptor, GATT_SUCCESS) },
            eventVerifier = {
                assertEquals(uuid, it.uuid)
                assertEquals(GattStatus(GATT_SUCCESS), it.status)
            },
        )
    }

    @Test
    fun onReadRemoteRssi() = runTest {
        val receiver = createReceiver()
        val rssi = -70
        receiver.callAndVerify<GattEvent.OnReadRemoteRssi>(
            call = { onReadRemoteRssi(null, rssi, GATT_SUCCESS) },
            eventVerifier = {
                assertEquals(rssi, it.rssi)
                assertEquals(GattStatus(GATT_SUCCESS), it.status)
            },
        )
    }

    @Test
    fun onMtuChanged() = runTest {
        val receiver = createReceiver()
        val mtu = 512
        receiver.callAndVerify<GattEvent.OnMtuChanged>(
            call = { onMtuChanged(null, mtu, GATT_SUCCESS) },
            eventVerifier = {
                assertEquals(mtu, it.mtu)
                assertEquals(GattStatus(GATT_SUCCESS), it.status)
            },
        )
    }

    @Test
    fun onServiceChanged() = runTest {
        val receiver = createReceiver()
        receiver.callAndVerify<GattEvent.OnServiceChanged>(
            call = { onServiceChanged(spy<BluetoothGatt>()) },
        )
    }
}
