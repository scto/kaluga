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

import android.content.Context
import com.splendo.kaluga.base.collections.concurrentMutableListOf
import com.splendo.kaluga.bluetooth.device.BluetoothGattWrapper
import com.splendo.kaluga.bluetooth.device.DeviceWrapper
import com.splendo.kaluga.bluetooth.device.Identifier
import com.splendo.kaluga.logging.Logger
import com.splendo.kaluga.test.base.mock.call
import com.splendo.kaluga.test.base.mock.on
import com.splendo.kaluga.test.base.mock.parameters.mock

class MockDeviceWrapper(override val name: String?, override val identifier: Identifier, override val bondState: DeviceWrapper.BondState, setupMocks: Boolean = true) :
    DeviceWrapper {

    val gattWrappers = concurrentMutableListOf<MockBluetoothGattWrapper>()
    val connectGattMock = ::connectGatt.mock()
    val removeBondMock = ::removeBond.mock()
    val createBondMock = ::createBond.mock()

    init {
        if (setupMocks) {
            connectGattMock.on().doExecute {
                val wrapper = MockBluetoothGattWrapper(setupMocks)
                gattWrappers.add(wrapper)
                Result.success(wrapper)
            }
        }
    }

    override suspend fun connectGatt(context: Context, autoConnect: Boolean, dataLogger: Logger): Result<BluetoothGattWrapper> =
        connectGattMock.call(context, autoConnect, dataLogger)
    override fun removeBond(): Unit = removeBondMock.call()
    override fun createBond(): Unit = createBondMock.call()
}
