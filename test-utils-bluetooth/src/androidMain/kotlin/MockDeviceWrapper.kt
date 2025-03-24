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

import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import android.content.Context
import com.splendo.kaluga.bluetooth.device.DeviceWrapper
import com.splendo.kaluga.bluetooth.device.Identifier
import com.splendo.kaluga.test.base.mock.call
import com.splendo.kaluga.test.base.mock.parameters.mock

class MockDeviceWrapper(override val name: String?, override val identifier: Identifier, override val bondState: DeviceWrapper.BondState) : DeviceWrapper {

    val connectGattMock = ::connectGatt.mock()
    val removeBondMock = ::removeBond.mock()
    val createBondMock = ::createBond.mock()

    override fun connectGatt(context: Context, autoConnect: Boolean, callback: BluetoothGattCallback): BluetoothGatt = connectGattMock.call(context, autoConnect, callback)
    override fun removeBond(): Unit = removeBondMock.call()
    override fun createBond(): Unit = createBondMock.call()
}
