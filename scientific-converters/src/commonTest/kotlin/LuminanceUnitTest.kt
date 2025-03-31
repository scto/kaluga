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

package com.splendo.kaluga.scientific.converter

import com.splendo.kaluga.scientific.convert
import com.splendo.kaluga.scientific.converter.illuminance.div
import com.splendo.kaluga.scientific.converter.luminousIntensity.div
import com.splendo.kaluga.scientific.invoke
import com.splendo.kaluga.scientific.unit.*
import kotlin.math.PI
import kotlin.test.Test
import kotlin.test.assertEquals

class LuminanceUnitTest {

    @Test
    fun luminanceFromIlluminanceAndSolidAngleTest() {
        assertEquals(1(Stilb), 2(Phot) / 2(Steradian))
        assertEquals(1(Stilb), 20(Deciphot) / 2(Steradian))
        assertEquals(1(Nit), 2(Lux) / 2(Steradian))
        assertEqualScientificValue(PI(FootLambert), 2(FootCandle) / 2(Steradian), 8)
        assertEquals(1(Nit), 2(Lux).convert(FootCandle as Illuminance) / 2(Steradian))
    }

    @Test
    fun luminanceFromLuminousIntensityAndAreaTest() {
        assertEquals(1(Stilb), 2(Candela) / 2(SquareCentimeter))
        assertEquals(1(Nit), 2(Candela) / 2(SquareMeter))
        assertEqualScientificValue(PI(FootLambert), (2(Candela) / 2(SquareFoot)), 8)
        assertEquals(1(Nit), 2(Candela) / 2(SquareMeter).convert(SquareFoot as Area))
    }
}
