/*
 Copyright 2022 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.test.bluetooth

import com.splendo.kaluga.bluetooth.CharacteristicWrapper
import com.splendo.kaluga.bluetooth.DescriptorWrapper
import com.splendo.kaluga.bluetooth.MTU
import com.splendo.kaluga.bluetooth.RSSI
import com.splendo.kaluga.bluetooth.ServiceWrapper
import com.splendo.kaluga.bluetooth.device.BluetoothGattWrapper
import com.splendo.kaluga.bluetooth.device.DeviceConnectionManager
import com.splendo.kaluga.bluetooth.device.GattEvent
import com.splendo.kaluga.test.base.mock.call
import com.splendo.kaluga.test.base.mock.on
import com.splendo.kaluga.test.base.mock.parameters.mock
import kotlinx.coroutines.flow.MutableSharedFlow

class MockBluetoothGattWrapper(
    setupMocks: Boolean = true,
    override var state: DeviceConnectionManager.State = DeviceConnectionManager.State.DISCONNECTED,
    override val updates: MutableSharedFlow<GattEvent.Update> = MutableSharedFlow(replay = Int.MAX_VALUE),
) : BluetoothGattWrapper {

    val connectMock = ::connect.mock()
    val discoverServicesMock = ::discoverServices.mock()
    val disconnectMock = ::disconnect.mock()
    val closeMock = ::close.mock()
    val readRemoteRssiMock = ::readRemoteRssi.mock()
    val requestMtuMock = ::requestMtu.mock()
    val readCharacteristicMock = ::readCharacteristic.mock()
    val readDescriptorMock = ::readDescriptor.mock()
    val writeCharacteristicMock = ::writeCharacteristic.mock()
    val writeDescriptorMock = ::writeDescriptor.mock()
    val setCharacteristicNotificationMock = ::setCharacteristicNotification.mock()

    init {
        if (setupMocks) {
            connectMock.on().doReturn(Result.success(Unit))
            discoverServicesMock.on().doReturn(Result.success(emptyList()))
            readRemoteRssiMock.on().doReturn(Result.success(-70))
            requestMtuMock.on().doExecute { Result.success(it.value) }
            readCharacteristicMock.on().doReturn(Result.success(ByteArray(0)))
            readDescriptorMock.on().doReturn(Result.success(ByteArray(0)))
            writeCharacteristicMock.on().doReturn(Result.success(Unit))
            writeDescriptorMock.on().doReturn(Result.success(Unit))
            setCharacteristicNotificationMock.on().doReturn(Result.success(Unit))
        }
    }

    override suspend fun connect(): Result<Unit> = connectMock.call()

    override suspend fun discoverServices(): Result<List<ServiceWrapper>> = discoverServicesMock.call()

    override suspend fun disconnect(): Unit = disconnectMock.call()

    override fun close(): Unit = closeMock.call()

    override suspend fun readRemoteRssi(): Result<RSSI> = readRemoteRssiMock.call()

    override suspend fun requestMtu(mtu: MTU): Result<MTU> = requestMtuMock.call(mtu)

    override suspend fun readCharacteristic(wrapper: CharacteristicWrapper): Result<ByteArray> = readCharacteristicMock.call(wrapper)

    override suspend fun readDescriptor(wrapper: DescriptorWrapper): Result<ByteArray> = readDescriptorMock.call(wrapper)

    override suspend fun writeCharacteristic(wrapper: CharacteristicWrapper, value: ByteArray): Result<Unit> = writeCharacteristicMock.call(wrapper, value)

    override suspend fun writeDescriptor(wrapper: DescriptorWrapper, value: ByteArray): Result<Unit> = writeDescriptorMock.call(wrapper, value)

    override suspend fun setCharacteristicNotification(wrapper: CharacteristicWrapper, enable: Boolean): Result<Unit> = setCharacteristicNotificationMock.call(wrapper, enable)
}
