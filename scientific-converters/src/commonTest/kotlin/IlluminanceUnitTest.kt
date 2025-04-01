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
import com.splendo.kaluga.scientific.converter.luminance.times
import com.splendo.kaluga.scientific.converter.luminousExposure.div
import com.splendo.kaluga.scientific.converter.luminousFlux.div
import com.splendo.kaluga.scientific.converter.solidAngle.times
import com.splendo.kaluga.scientific.invoke
import com.splendo.kaluga.scientific.unit.*
import kotlin.math.PI
import kotlin.test.Test
import kotlin.test.assertEquals

class IlluminanceUnitTest {

    @Test
    fun illuminanceFromLuminanceAndSolidAngleTest() {
        assertEquals(4(Lux), 2(Nit) * 2(Steradian))
        assertEquals(4(Lux), 2(Steradian) * 2(Nit))
        assertEquals(4(Phot), 2(Stilb) * 2(Steradian))
        assertEquals(4(Phot), 2(Steradian) * 2(Stilb))
        assertEquals((4 / PI)(Phot), 2(Lambert) * 2(Steradian))
        assertEquals((4 / PI)(Phot), 2(Steradian) * 2(Lambert))
        assertEquals((4 / PI)(FootCandle), 2(FootLambert) * 2(Steradian))
        assertEquals((4 / PI)(FootCandle), 2(Steradian) * 2(FootLambert))
        assertEquals(4(Lux), 2(Nit).convert(FootLambert as Luminance) * 2(Steradian))
        assertEquals(4(Lux), 2(Steradian) * 2(Nit).convert(FootLambert as Luminance))
    }

    @Test
    fun illuminanceFromLuminousExposureAndTimeTest() {
        assertEqualScientificValue(1(Lux), 2(Lux x Second) / 2(Second))
        assertEqualScientificValue(1(FootCandle), 2(FootCandle x Second) / 2(Second))
        assertEqualScientificValue(1(Lux), 2((Lux x Second) as LuminousExposure) / 2(Second))
    }

    @Test
    fun illuminanceFromLuminousFluxAndAreaTest() {
        assertEquals(1(Phot), 2(Lumen) / 2(SquareCentimeter))
        assertEquals(1(Lux), 2(Lumen) / 2(SquareMeter))
        assertEquals(1(FootCandle), 2(Lumen) / 2(SquareFoot))
        assertEquals(1(Lux), 2(Lumen) / 2(SquareMeter).convert(SquareFoot as Area))
    }
}
