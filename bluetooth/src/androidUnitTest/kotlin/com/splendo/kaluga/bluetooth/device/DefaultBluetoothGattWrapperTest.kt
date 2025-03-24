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
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import android.bluetooth.BluetoothGattService
import com.splendo.kaluga.bluetooth.ConsoleLogger
import com.splendo.kaluga.bluetooth.DefaultCharacteristicWrapper
import com.splendo.kaluga.bluetooth.DefaultDescriptorWrapper
import com.splendo.kaluga.bluetooth.DefaultGattServiceWrapper
import com.splendo.kaluga.bluetooth.MTU
import com.splendo.kaluga.bluetooth.RSSI
import com.splendo.kaluga.bluetooth.ServiceWrapper
import com.splendo.kaluga.bluetooth.UUID
import com.splendo.kaluga.test.base.mock.call
import com.splendo.kaluga.test.base.mock.on
import com.splendo.kaluga.test.base.mock.suspendVoidParametersMock
import com.splendo.kaluga.test.base.mock.verify
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.spy
import org.mockito.internal.verification.VerificationModeFactory
import org.mockito.Mockito.`when` as mockitoWhen
import org.mockito.Mockito.verify as mockitoVerify
import kotlin.coroutines.CoroutineContext
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.test.fail

@Suppress("DEPRECATION")
class DefaultBluetoothGattWrapperTest {
    private val receiver = MockBluetoothGattReceiver()
    private val gatt = spy<BluetoothGatt>()
    private val onConnected = suspendVoidParametersMock<Unit>().apply { on().doReturn(Unit) }
    private val onDisconnected = suspendVoidParametersMock<Unit>().apply { on().doReturn(Unit) }

    private fun wrapper(coroutineContext: CoroutineContext): BluetoothGattWrapper = DefaultBluetoothGattWrapper(
        deviceIdentifier = "device-id",
        logger = ConsoleLogger, // RestrictedLogger(RestrictedLogLevel.None),
        receiver = receiver,
        createGatt = { gatt },
        onConnected = onConnected::call,
        onDisconnected = onDisconnected::call,
        coroutineContext = coroutineContext,
    )

    @Test
    fun notifications() = runTest {
        // given
        val change1 = GattEvent.OnCharacteristicChanged(UUID.randomUUID(), byteArrayOf(0x01, 0x02, 0x03))
        val change2 = GattEvent.OnCharacteristicChanged(UUID.randomUUID(), byteArrayOf(0x04, 0x05, 0x06))

        val wrapper = wrapper(coroutineContext)
        val events = async(start = CoroutineStart.UNDISPATCHED) {
            wrapper.notifications.take(2).toList()
        }

        // when
        listOf(
            GattEvent.OnConnected(GattStatus(BluetoothGatt.GATT_SUCCESS)),
            GattEvent.OnMtuChanged(512, GattStatus(BluetoothGatt.GATT_SUCCESS)),
            change1,
            GattEvent.OnCharacteristicRead(uuid = UUID.randomUUID(), byteArrayOf(0x04, 0x05, 0x06), status = GattStatus(BluetoothGatt.GATT_SUCCESS)),
            change2,
            GattEvent.OnDisconnected(GattStatus(BluetoothGatt.GATT_SUCCESS)),
        ).forEach {
            receiver.events.emit(it)
        }

        // then
        assertEquals(listOf(change1, change2), events.await())
    }

    private fun <R> verifyWrapper(
        given: suspend (CoroutineContext) -> BluetoothGattWrapper,
        action: suspend BluetoothGattWrapper.() -> R,
        verify: suspend BluetoothGattWrapper.(R) -> Unit,
    ) = runTest {
        val job = coroutineContext + Job()
        val wrapper = given(job)
        val result = action(wrapper)
        wrapper.verify(result)
        job.cancel()
    }

    private fun verifyConnect(onCreateGatt: suspend () -> Unit, onGattConnectCall: CoroutineScope.() -> Boolean, verify: suspend BluetoothGattWrapper.(Unit) -> Unit) =
        verifyWrapper<Unit>(
            given = ::wrapper,
            action = {
                coroutineScope {
                    launch { onCreateGatt() }
                    mockitoWhen(gatt.connect()).thenAnswer { onGattConnectCall() }

                    connect()
                }
            },
            verify = verify,
        )

    @Test
    fun connectFromCreateGatt() = verifyConnect(
        onCreateGatt = { receiver.events.emit(GattEvent.OnConnected(GattStatus(BluetoothGatt.GATT_SUCCESS))) },
        onGattConnectCall = { fail("Unexpected call") },
        verify = {
            assertEquals(DeviceConnectionManager.State.CONNECTED, state)
            onConnected.verify()
        },
    )

    @Test
    fun connectFailedNoEventFromCreateGattRetrySuccess() = verifyConnect(
        onCreateGatt = {
            // no event sent after `createGatt`
        },
        onGattConnectCall = {
            launch { receiver.events.emit(GattEvent.OnConnected(GattStatus(BluetoothGatt.GATT_SUCCESS))) }
            true
        },
        verify = {
            assertEquals(DeviceConnectionManager.State.CONNECTED, state)
            onConnected.verify()
            mockitoVerify(gatt).connect()
        },
    )

    @Test
    fun connectFailedFailedEventFromCreateGattRetrySuccess() = verifyConnect(
        onCreateGatt = {
            receiver.events.emit(GattEvent.OnConnected(GattStatus(BluetoothGatt.GATT_FAILURE)))
        },
        onGattConnectCall = {
            launch { receiver.events.emit(GattEvent.OnConnected(GattStatus(BluetoothGatt.GATT_SUCCESS))) }
            true
        },
        verify = {
            assertEquals(DeviceConnectionManager.State.CONNECTED, state)
            onConnected.verify()
            mockitoVerify(gatt).connect()
        },
    )

    @Test
    fun connectFailedNoEventFromCreateGattFailedRetryFailedGattCall() = verifyConnect(
        onCreateGatt = {
            receiver.events.emit(GattEvent.OnConnected(GattStatus(BluetoothGatt.GATT_FAILURE)))
        },
        onGattConnectCall = {
            // event shall never be emitted in reality, emitting here to check that failed call indication is handled correctly
            launch { receiver.events.emit(GattEvent.OnConnected(GattStatus(BluetoothGatt.GATT_SUCCESS))) }
            // call failed
            false
        },
        verify = {
            assertEquals(DeviceConnectionManager.State.DISCONNECTED, state)
            onDisconnected.verify()
            mockitoVerify(gatt).connect()
            mockitoVerify(gatt).close()
        },
    )

    @Test
    fun connectFailedNoEventFromCreateGattFailedRetryFailedEvent() = verifyConnect(
        onCreateGatt = {
            receiver.events.emit(GattEvent.OnConnected(GattStatus(BluetoothGatt.GATT_FAILURE)))
        },
        onGattConnectCall = {
            launch { receiver.events.emit(GattEvent.OnConnected(GattStatus(BluetoothGatt.GATT_FAILURE))) }
            true
        },
        verify = {
            assertEquals(DeviceConnectionManager.State.DISCONNECTED, state)
            onDisconnected.verify()
            mockitoVerify(gatt).connect()
            mockitoVerify(gatt).close()
        },
    )

    private suspend fun connectedWrapper(coroutineContext: CoroutineContext): BluetoothGattWrapper = coroutineScope {
        val wrapper = wrapper(coroutineContext)
        launch { receiver.events.emit(GattEvent.OnConnected(GattStatus(BluetoothGatt.GATT_SUCCESS))) }
        wrapper.connect()
        assertEquals(DeviceConnectionManager.State.CONNECTED, wrapper.state)
        wrapper
    }

    @Test
    fun disconnectConnected() = runTest {
        // given
        val wrapper = connectedWrapper(coroutineContext)

        // when
        wrapper.disconnect()

        // then
        mockitoVerify(gatt).disconnect()
        mockitoVerify(gatt).close()
        // coroutineContext release verified by non hanging test
    }

    @Test
    fun disconnectNotConnected() = runTest {
        // given
        val wrapper = wrapper(coroutineContext)

        // when
        wrapper.disconnect()

        // then
        mockitoVerify(gatt, VerificationModeFactory.times(0)).disconnect()
        mockitoVerify(gatt, VerificationModeFactory.times(0)).close()
        // coroutineContext release verified by non hanging test
    }

    // === readRemoteRssi ===
    @Test
    fun readRemoteRssiFailsOnUnconnectedGatt() = verifyWrapper(
        given = ::wrapper,
        action = {
            readRemoteRssi()
        },
        verify = { result ->
            assertFalse(result.isSuccess)
            mockitoVerify(gatt, VerificationModeFactory.times(0)).readRemoteRssi()
        },
    )

    private fun verifyReadRemoteRssi(onGattCall: CoroutineScope.() -> Boolean, verifyResult: (Result<RSSI>) -> Unit) = verifyWrapper(
        given = ::connectedWrapper,
        action = {
            coroutineScope {
                mockitoWhen(gatt.readRemoteRssi()).thenAnswer { onGattCall() }
                readRemoteRssi()
            }
        },
        verify = { result ->
            verifyResult(result)
            mockitoVerify(gatt).readRemoteRssi()
        },
    )

    @Test
    fun readRemoteRssiFailsOnGattCommandFail() = verifyReadRemoteRssi(
        onGattCall = {
            // event shall never be emitted in reality, emitting here to check that failed call indication is handled correctly
            launch { receiver.events.emit(GattEvent.OnReadRemoteRssi(123, GattStatus(BluetoothGatt.GATT_SUCCESS))) }
            // call failed
            false
        },
        verifyResult = { result -> assertFalse(result.isSuccess) },
    )

    @Test
    fun readRemoteRssiFailsOnTimeout() = verifyReadRemoteRssi(
        onGattCall = { true },
        verifyResult = { result -> assertFalse(result.isSuccess) },
    )

    @Test
    fun readRemoteRssiFailsOnFailStatus() = verifyReadRemoteRssi(
        onGattCall = {
            launch { receiver.events.emit(GattEvent.OnReadRemoteRssi(0, GattStatus(BluetoothGatt.GATT_FAILURE))) }
            true
        },
        verifyResult = { result -> assertFalse(result.isSuccess) },
    )

    @Test
    fun readRemoteRssiSuccess() = verifyReadRemoteRssi(
        onGattCall = {
            launch { receiver.events.emit(GattEvent.OnReadRemoteRssi(123, GattStatus(BluetoothGatt.GATT_SUCCESS))) }
            true
        },
        verifyResult = { result -> assertEquals(Result.success(123), result) },
    )

    // === requestMtu ===

    @Test
    fun requestMtuFailsOnUnconnectedGatt() = verifyWrapper(
        given = ::wrapper,
        action = {
            requestMtu(512)
        },
        verify = { result ->
            assertFalse(result.isSuccess)
            mockitoVerify(gatt, VerificationModeFactory.times(0)).readRemoteRssi()
        },
    )

    private fun verifyRequestMtu(onGattCall: CoroutineScope.() -> Boolean, verifyResult: (Result<MTU>) -> Unit) = verifyWrapper(
        given = ::connectedWrapper,
        action = {
            coroutineScope {
                mockitoWhen(gatt.requestMtu(512)).thenAnswer { onGattCall() }
                requestMtu(512)
            }
        },
        verify = { result ->
            verifyResult(result)
            mockitoVerify(gatt).requestMtu(512)
        },
    )

    @Test
    fun requestMtuFailsOnGattCommandFail() = verifyRequestMtu(
        onGattCall = {
            // event shall never be emitted in reality, emitting here to check that failed call indication is handled correctly
            launch { receiver.events.emit(GattEvent.OnMtuChanged(185, GattStatus(BluetoothGatt.GATT_SUCCESS))) }
            // call failed
            false
        },
        verifyResult = { result -> assertFalse(result.isSuccess) },
    )

    @Test
    fun requestMtuFailsOnTimeout() = verifyRequestMtu(
        onGattCall = { true },
        verifyResult = { result -> assertFalse(result.isSuccess) },
    )

    @Test
    fun requestMtuFailsOnFailStatus() = verifyRequestMtu(
        onGattCall = {
            launch { receiver.events.emit(GattEvent.OnMtuChanged(0, GattStatus(BluetoothGatt.GATT_FAILURE))) }
            true
        },
        verifyResult = { result -> assertFalse(result.isSuccess) },
    )

    @Test
    fun requestMtuSuccess() = verifyRequestMtu(
        onGattCall = {
            launch { receiver.events.emit(GattEvent.OnMtuChanged(185, GattStatus(BluetoothGatt.GATT_SUCCESS))) }
            true
        },
        verifyResult = { result -> assertEquals(Result.success(185), result) },
    )

    // === discoverServices ===

    @Test
    fun discoverServicesFailsOnUnconnectedGatt() = verifyWrapper(
        given = ::wrapper,
        action = {
            discoverServices()
        },
        verify = { result ->
            assertFalse(result.isSuccess)
            mockitoVerify(gatt, VerificationModeFactory.times(0)).discoverServices()
        },
    )

    private fun verifyDiscoverServices(onGattCall: CoroutineScope.() -> Boolean, verifyResult: (Result<List<ServiceWrapper>>) -> Unit) = verifyWrapper(
        given = ::connectedWrapper,
        action = {
            coroutineScope {
                mockitoWhen(gatt.discoverServices()).thenAnswer { onGattCall() }
                discoverServices()
            }
        },
        verify = { result ->
            verifyResult(result)
            mockitoVerify(gatt).discoverServices()
        },
    )

    @Test
    fun discoverServicesFailsOnGattCommandFail() = verifyDiscoverServices(
        onGattCall = {
            // event shall never be emitted in reality, emitting here to check that failed call indication is handled correctly
            launch { receiver.events.emit(GattEvent.OnServicesDiscovered(emptyList(), GattStatus(BluetoothGatt.GATT_SUCCESS))) }
            // call failed
            false
        },
        verifyResult = { result -> assertFalse(result.isSuccess) },
    )

    @Test
    fun discoverServicesFailsOnTimeout() = verifyDiscoverServices(
        onGattCall = { true },
        verifyResult = { result -> assertFalse(result.isSuccess) },
    )

    @Test
    fun discoverServicesFailsOnFailStatus() = verifyDiscoverServices(
        onGattCall = {
            launch { receiver.events.emit(GattEvent.OnServicesDiscovered(emptyList(), GattStatus(BluetoothGatt.GATT_FAILURE))) }
            true
        },
        verifyResult = { result -> assertFalse(result.isSuccess) },
    )

    @Test
    fun discoverServicesSuccess() {
        val services = listOf(DefaultGattServiceWrapper(BluetoothGattService(UUID.randomUUID(), 0)))

        verifyDiscoverServices(
            onGattCall = {
                launch { receiver.events.emit(GattEvent.OnServicesDiscovered(services, GattStatus(BluetoothGatt.GATT_SUCCESS))) }
                true
            },
            verifyResult = { result -> assertEquals(Result.success(services), result) },
        )
    }

    // === readCharacteristic ===

    private val serviceUuid = UUID.randomUUID()
    private val service = spy(BluetoothGattService(serviceUuid, 0)).apply {
        mockitoWhen(uuid).thenReturn(serviceUuid)
    }

    private val characteristicUuid = UUID.randomUUID()
    private val characteristic = spy(BluetoothGattCharacteristic(characteristicUuid, 0, 0)).also {
        mockitoWhen(it.uuid).thenReturn(characteristicUuid)
        mockitoWhen(it.service).thenReturn(service)
    }

    private val descriptorUuid = UUID.randomUUID()
    private val descriptor = spy(BluetoothGattDescriptor(descriptorUuid, 0)).also {
        mockitoWhen(it.uuid).thenReturn(descriptorUuid)
        mockitoWhen(it.characteristic).thenReturn(characteristic)
    }

    @Test
    fun readCharacteristicFailsOnUnconnectedGatt() = verifyWrapper(
        given = ::wrapper,
        action = {
            readCharacteristic(DefaultCharacteristicWrapper(characteristic))
        },
        verify = { result ->
            assertFalse(result.isSuccess)
            mockitoVerify(gatt, VerificationModeFactory.times(0)).readCharacteristic(Mockito.any<BluetoothGattCharacteristic>())
        },
    )

    private fun verifyReadCharacteristic(onGattCall: CoroutineScope.() -> Boolean, verifyResult: (Result<ByteArray>) -> Unit) = verifyWrapper(
        given = ::connectedWrapper,
        action = {
            coroutineScope {
                mockitoWhen(gatt.getService(serviceUuid)).thenReturn(service)
                mockitoWhen(service.getCharacteristic(characteristicUuid)).thenReturn(characteristic)
                mockitoWhen(gatt.readCharacteristic(characteristic)).thenAnswer { onGattCall() }
                readCharacteristic(DefaultCharacteristicWrapper(characteristic))
            }
        },
        verify = { result ->
            verifyResult(result)
            mockitoVerify(gatt).readCharacteristic(characteristic)
        },
    )

    @Test
    fun readCharacteristicFailsOnGattCommandFail() = verifyReadCharacteristic(
        onGattCall = {
            // event shall never be emitted in reality, emitting here to check that failed call indication is handled correctly
            launch { receiver.events.emit(GattEvent.OnCharacteristicRead(characteristic.uuid, byteArrayOf(), GattStatus(BluetoothGatt.GATT_SUCCESS))) }
            // call failed
            false
        },
        verifyResult = { result -> assertFalse(result.isSuccess) },
    )

    @Test
    fun readCharacteristicFailsOnTimeout() = verifyReadCharacteristic(
        onGattCall = { true },
        verifyResult = { result -> assertFalse(result.isSuccess) },
    )

    @Test
    fun readCharacteristicFailsOnFailStatus() = verifyReadCharacteristic(
        onGattCall = {
            launch { receiver.events.emit(GattEvent.OnCharacteristicRead(characteristic.uuid, byteArrayOf(), GattStatus(BluetoothGatt.GATT_FAILURE))) }
            true
        },
        verifyResult = { result -> assertFalse(result.isSuccess) },
    )

    @Test
    fun readCharacteristicSuccess() = verifyReadCharacteristic(
        onGattCall = {
            launch { receiver.events.emit(GattEvent.OnCharacteristicRead(characteristic.uuid, byteArrayOf(0x01, 0x02, 0x03), GattStatus(BluetoothGatt.GATT_SUCCESS))) }
            true
        },
        verifyResult = { result ->
            assertTrue { result.isSuccess }
            assertContentEquals(byteArrayOf(0x01, 0x02, 0x03), result.getOrThrow())
        },
    )

    // === readDescriptor ===

    @Test
    fun readDescriptorFailsOnUnconnectedGatt() = verifyWrapper(
        given = ::wrapper,
        action = {
            readDescriptor(DefaultDescriptorWrapper(descriptor))
        },
        verify = { result ->
            assertFalse(result.isSuccess)
            mockitoVerify(gatt, VerificationModeFactory.times(0)).readDescriptor(Mockito.any<BluetoothGattDescriptor>())
        },
    )

    private fun verifyReadDescriptor(onGattCall: CoroutineScope.() -> Boolean, verifyResult: (Result<ByteArray>) -> Unit) = verifyWrapper(
        given = ::connectedWrapper,
        action = {
            coroutineScope {
                mockitoWhen(gatt.getService(serviceUuid)).thenReturn(service)
                mockitoWhen(service.getCharacteristic(characteristicUuid)).thenReturn(characteristic)
                mockitoWhen(characteristic.getDescriptor(descriptorUuid)).thenReturn(descriptor)
                mockitoWhen(gatt.readDescriptor(descriptor)).thenAnswer { onGattCall() }
                readDescriptor(DefaultDescriptorWrapper(descriptor))
            }
        },
        verify = { result ->
            verifyResult(result)
            mockitoVerify(gatt).readDescriptor(descriptor)
        },
    )

    @Test
    fun readDescriptorFailsOnGattCommandFail() = verifyReadDescriptor(
        onGattCall = {
            // event shall never be emitted in reality, emitting here to check that failed call indication is handled correctly
            launch { receiver.events.emit(GattEvent.OnDescriptorRead(descriptor.uuid, byteArrayOf(), GattStatus(BluetoothGatt.GATT_SUCCESS))) }
            // call failed
            false
        },
        verifyResult = { result -> assertFalse(result.isSuccess) },
    )

    @Test
    fun readDescriptorFailsOnTimeout() = verifyReadDescriptor(
        onGattCall = { true },
        verifyResult = { result -> assertFalse(result.isSuccess) },
    )

    @Test
    fun readDescriptorFailsOnFailStatus() = verifyReadDescriptor(
        onGattCall = {
            launch { receiver.events.emit(GattEvent.OnDescriptorRead(descriptor.uuid, byteArrayOf(), GattStatus(BluetoothGatt.GATT_FAILURE))) }
            true
        },
        verifyResult = { result -> assertFalse(result.isSuccess) },
    )

    @Test
    fun readDescriptorSuccess() = verifyReadDescriptor(
        onGattCall = {
            launch { receiver.events.emit(GattEvent.OnDescriptorRead(descriptor.uuid, byteArrayOf(0x01, 0x02, 0x03), GattStatus(BluetoothGatt.GATT_SUCCESS))) }
            true
        },
        verifyResult = { result ->
            assertTrue { result.isSuccess }
            assertContentEquals(byteArrayOf(0x01, 0x02, 0x03), result.getOrThrow())
        },
    )

    // === writeCharacteristic ===

    @Test
    fun writeCharacteristicFailsOnUnconnectedGatt() = verifyWrapper(
        given = ::wrapper,
        action = {
            writeCharacteristic(DefaultCharacteristicWrapper(characteristic), byteArrayOf())
        },
        verify = { result ->
            assertFalse(result.isSuccess)
            mockitoVerify(gatt, VerificationModeFactory.times(0)).writeCharacteristic(Mockito.any<BluetoothGattCharacteristic>())
            mockitoVerify(gatt, VerificationModeFactory.times(0)).writeCharacteristic(Mockito.any<BluetoothGattCharacteristic>(), Mockito.any<ByteArray>(), Mockito.anyInt())
        },
    )

    private fun verifyWriteCharacteristic(onGattCall: CoroutineScope.() -> Boolean, expectSuccess: Boolean) {
        val data = byteArrayOf(0x01, 0x02, 0x03)
        verifyWrapper(
            given = ::connectedWrapper,
            action = {
                coroutineScope {
                    mockitoWhen(gatt.getService(serviceUuid)).thenReturn(service)
                    mockitoWhen(service.getCharacteristic(characteristicUuid)).thenReturn(characteristic)
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                        mockitoWhen(characteristic.writeType).thenReturn(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT)
                        mockitoWhen(gatt.writeCharacteristic(characteristic, data, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT))
                            .thenAnswer { if (onGattCall()) BluetoothGatt.GATT_SUCCESS else BluetoothGatt.GATT_FAILURE }
                    } else {
                        mockitoWhen(gatt.writeCharacteristic(characteristic)).thenAnswer { onGattCall() }
                    }
                    writeCharacteristic(DefaultCharacteristicWrapper(characteristic), data)
                }
            },
            verify = { result ->
                assertEquals(expectSuccess, result.isSuccess)
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                    mockitoVerify(gatt).writeCharacteristic(characteristic, data, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT)
                } else {
                    mockitoVerify(characteristic).setValue(data)
                    mockitoVerify(gatt).writeCharacteristic(characteristic)
                }
            },
        )
    }

    @Test
    fun writeCharacteristicFailsOnGattCommandFail() = verifyWriteCharacteristic(
        onGattCall = {
            // event shall never be emitted in reality, emitting here to check that failed call indication is handled correctly
            launch { receiver.events.emit(GattEvent.OnCharacteristicWrite(characteristic.uuid, GattStatus(BluetoothGatt.GATT_SUCCESS))) }
            // call failed
            false
        },
        expectSuccess = false,
    )

    @Test
    fun writeCharacteristicFailsOnTimeout() = verifyWriteCharacteristic(
        onGattCall = { true },
        expectSuccess = false,
    )

    @Test
    fun writeCharacteristicFailsOnFailStatus() = verifyWriteCharacteristic(
        onGattCall = {
            launch { receiver.events.emit(GattEvent.OnCharacteristicWrite(characteristic.uuid, GattStatus(BluetoothGatt.GATT_FAILURE))) }
            true
        },
        expectSuccess = false,
    )

    @Test
    fun writeCharacteristicSuccess() = verifyWriteCharacteristic(
        onGattCall = {
            launch { receiver.events.emit(GattEvent.OnCharacteristicWrite(characteristic.uuid, GattStatus(BluetoothGatt.GATT_SUCCESS))) }
            true
        },
        expectSuccess = true,
    )

    // === writeDescriptor ===

    @Test
    fun writeDescriptorFailsOnUnconnectedGatt() = verifyWrapper(
        given = ::wrapper,
        action = {
            writeDescriptor(DefaultDescriptorWrapper(descriptor), byteArrayOf())
        },
        verify = { result ->
            assertFalse(result.isSuccess)
            mockitoVerify(gatt, VerificationModeFactory.times(0)).writeDescriptor(Mockito.any<BluetoothGattDescriptor>())
            mockitoVerify(gatt, VerificationModeFactory.times(0)).writeDescriptor(Mockito.any<BluetoothGattDescriptor>(), Mockito.any<ByteArray>())
        },
    )

    private fun verifyWriteDescriptor(onGattCall: CoroutineScope.() -> Boolean, expectSuccess: Boolean) {
        val data = byteArrayOf(0x01, 0x02, 0x03)
        verifyWrapper(
            given = ::connectedWrapper,
            action = {
                coroutineScope {
                    mockitoWhen(gatt.getService(serviceUuid)).thenReturn(service)
                    mockitoWhen(service.getCharacteristic(characteristicUuid)).thenReturn(characteristic)
                    mockitoWhen(characteristic.getDescriptor(descriptorUuid)).thenReturn(descriptor)
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                        mockitoWhen(gatt.writeDescriptor(descriptor, data))
                            .thenAnswer { if (onGattCall()) BluetoothGatt.GATT_SUCCESS else BluetoothGatt.GATT_FAILURE }
                    } else {
                        mockitoWhen(gatt.writeDescriptor(descriptor)).thenAnswer { onGattCall() }
                    }

                    mockitoWhen(gatt.readDescriptor(descriptor)).thenAnswer { onGattCall() }
                    writeDescriptor(DefaultDescriptorWrapper(descriptor), data)
                }
            },
            verify = { result ->
                assertEquals(expectSuccess, result.isSuccess)
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                    mockitoVerify(gatt).writeDescriptor(descriptor, data)
                } else {
                    mockitoVerify(descriptor).setValue(data)
                    mockitoVerify(gatt).writeDescriptor(descriptor)
                }
            },
        )
    }

    @Test
    fun writeDescriptorFailsOnGattCommandFail() = verifyWriteDescriptor(
        onGattCall = {
            // event shall never be emitted in reality, emitting here to check that failed call indication is handled correctly
            launch { receiver.events.emit(GattEvent.OnDescriptorWrite(descriptor.uuid, GattStatus(BluetoothGatt.GATT_SUCCESS))) }
            // call failed
            false
        },
        expectSuccess = false,
    )

    @Test
    fun writeDescriptorFailsOnTimeout() = verifyWriteDescriptor(
        onGattCall = { true },
        expectSuccess = false,
    )

    @Test
    fun writeDescriptorFailsOnFailStatus() = verifyWriteDescriptor(
        onGattCall = {
            launch { receiver.events.emit(GattEvent.OnDescriptorRead(descriptor.uuid, byteArrayOf(), GattStatus(BluetoothGatt.GATT_FAILURE))) }
            true
        },
        expectSuccess = false,
    )

    @Test
    fun writeDescriptorSuccess() = verifyWriteDescriptor(
        onGattCall = {
            launch { receiver.events.emit(GattEvent.OnDescriptorWrite(descriptor.uuid, GattStatus(BluetoothGatt.GATT_SUCCESS))) }
            true
        },
        expectSuccess = true,
    )

    // === setCharacteristicNotification ===

    @Test
    fun setCharacteristicNotificationFailsOnUnconnectedGatt() = verifyWrapper(
        given = ::wrapper,
        action = {
            setCharacteristicNotification(DefaultCharacteristicWrapper(characteristic), true)
        },
        verify = { result ->
            assertFalse(result.isSuccess)
            mockitoVerify(gatt, VerificationModeFactory.times(0)).setCharacteristicNotification(Mockito.any<BluetoothGattCharacteristic>(), Mockito.anyBoolean())
        },
    )

    private fun verifySetCharacteristicNotification(enable: Boolean = true, gattCallResult: Boolean, expectSuccess: Boolean) {
        verifyWrapper(
            given = ::connectedWrapper,
            action = {
                coroutineScope {
                    mockitoWhen(gatt.getService(serviceUuid)).thenReturn(service)
                    mockitoWhen(service.getCharacteristic(characteristicUuid)).thenReturn(characteristic)
                    mockitoWhen(gatt.setCharacteristicNotification(characteristic, enable)).thenReturn(gattCallResult)
                    setCharacteristicNotification(DefaultCharacteristicWrapper(characteristic), enable)
                }
            },
            verify = { result ->
                assertEquals(expectSuccess, result.isSuccess)
                mockitoVerify(gatt).setCharacteristicNotification(characteristic, enable)
            },
        )
    }

    @Test
    fun setCharacteristicNotificationFailsOnGattCommandFail() = verifySetCharacteristicNotification(
        gattCallResult = false,
        expectSuccess = false,
    )

    @Test
    fun setCharacteristicNotificationOnSuccess() = verifySetCharacteristicNotification(
        enable = true,
        gattCallResult = true,
        expectSuccess = true,
    )

    @Test
    fun setCharacteristicNotificationOffSuccess() = verifySetCharacteristicNotification(
        enable = false,
        gattCallResult = true,
        expectSuccess = true,
    )
}
