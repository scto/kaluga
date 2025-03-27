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
import com.splendo.kaluga.scientific.converter.amountOfSubstance.div
import com.splendo.kaluga.scientific.converter.amountOfSubstance.times
import com.splendo.kaluga.scientific.converter.area.times
import com.splendo.kaluga.scientific.converter.energy.div
import com.splendo.kaluga.scientific.converter.length.times
import com.splendo.kaluga.scientific.converter.molarVolume.times
import com.splendo.kaluga.scientific.converter.specificVolume.times
import com.splendo.kaluga.scientific.converter.time.times
import com.splendo.kaluga.scientific.converter.volumetricFlow.times
import com.splendo.kaluga.scientific.converter.weight.div
import com.splendo.kaluga.scientific.converter.weight.times
import com.splendo.kaluga.scientific.invoke
import com.splendo.kaluga.scientific.unit.*
import kotlin.test.Test
import kotlin.test.assertEquals

class VolumeUnitTest {

    @Test
    fun volumeFromAmountOfSubstanceDivMolarityTest() {
        assertEqualScientificValue(1(CubicMeter), 2(Decimole) / 2(Decimole per CubicMeter))
        assertEqualScientificValue(1(CubicFoot), 2(Decimole) / 2(Decimole per CubicFoot))
        assertEqualScientificValue(1(ImperialGallon), 2(Decimole) / 2(Decimole per ImperialGallon))
        assertEqualScientificValue(1(UsLiquidGallon), 2(Decimole) / 2(Decimole per UsLiquidGallon))
        assertEqualScientificValue(
            1(CubicMeter),
            2(Decimole) / 2(Decimole per CubicMeter).convert((Decimole per CubicFoot) as Molarity),
        )
    }

    @Test
    fun volumeFromAreaAndLengthTest() {
        assertEquals(4(CubicMeter), 2(Meter) * 2(SquareMeter))
        assertEquals(4(CubicMeter), 2(SquareMeter) * 2(Meter))
        assertEquals(4(CubicNanometer), 2(Nanometer) * 2(SquareNanometer))
        assertEquals(4(CubicNanometer), 2(SquareNanometer) * 2(Nanometer))
        assertEquals(4(CubicMicrometer), 2(Micrometer) * 2(SquareMicrometer))
        assertEquals(4(CubicMicrometer), 2(SquareMicrometer) * 2(Micrometer))
        assertEquals(4(CubicMillimeter), 2(Millimeter) * 2(SquareMillimeter))
        assertEquals(4(CubicMillimeter), 2(SquareMillimeter) * 2(Millimeter))
        assertEquals(4(CubicCentimeter), 2(Centimeter) * 2(SquareCentimeter))
        assertEquals(4(CubicCentimeter), 2(SquareCentimeter) * 2(Centimeter))
        assertEquals(4(CubicDecimeter), 2(Decimeter) * 2(SquareDecimeter))
        assertEquals(4(CubicDecimeter), 2(SquareDecimeter) * 2(Decimeter))
        assertEquals(4(CubicDecameter), 2(Decameter) * 2(SquareDecameter))
        assertEquals(4(CubicDecameter), 2(SquareDecameter) * 2(Decameter))
        assertEquals(4(CubicHectometer), 2(Hectometer) * 2(SquareHectometer))
        assertEquals(4(CubicHectometer), 2(SquareHectometer) * 2(Hectometer))
        assertEquals(4(CubicKilometer), 2(Kilometer) * 2(SquareKilometer))
        assertEquals(4(CubicKilometer), 2(SquareKilometer) * 2(Kilometer))
        assertEquals(4(CubicMegameter), 2(Megameter) * 2(SquareMegameter))
        assertEquals(4(CubicMegameter), 2(SquareMegameter) * 2(Megameter))
        assertEquals(4(CubicGigameter), 2(Gigameter) * 2(SquareGigameter))
        assertEquals(4(CubicGigameter), 2(SquareGigameter) * 2(Gigameter))
        assertEquals(4(CubicMeter), 200(Centimeter) * 2(SquareMeter))
        assertEquals(4(CubicMeter), 2(SquareMeter) * 200(Centimeter))

        assertEquals(4(CubicInch), 2(Inch) * 2(SquareInch))
        assertEquals(4(CubicInch), 2(SquareInch) * 2(Inch))
        assertEquals(4(CubicFoot), 2(Foot) * 2(SquareFoot))
        assertEquals(4(CubicFoot), 2(SquareFoot) * 2(Foot))
        assertEquals(4(CubicYard), 2(Yard) * 2(SquareYard))
        assertEquals(4(CubicYard), 2(SquareYard) * 2(Yard))
        assertEquals(4(CubicMile), 2(Mile) * 2(SquareMile))
        assertEquals(4(CubicMile), 2(SquareMile) * 2(Mile))

        assertEquals(4(AcreInch), 2(Inch) * 2(Acre))
        assertEquals(4(AcreInch), 2(Acre) * 2(Inch))
        assertEquals(4(AcreFoot), 2(Foot) * 2(Acre))
        assertEquals(4(AcreFoot), 2(Acre) * 2(Foot))
        assertEquals(4(CubicFoot), 24(Inch) * 2(SquareFoot))
        assertEquals(4(CubicFoot), 2(SquareFoot) * 24(Inch))

        assertEquals(4(CubicMeter), 2(Meter).convert(Foot) * 2(SquareMeter))
        assertEquals(4(CubicMeter), 2(SquareMeter) * 2(Meter).convert(Foot))
    }

    @Test
    fun volumeFromEnergyAndPressureTest() {
        assertEquals(1(CubicCentimeter), 2(Erg) / 2(Barye))
        assertEquals(1(CubicCentimeter), 20(Decierg) / 2(Barye))
        assertEquals(1(CubicCentimeter), 2(Erg) / 20(Decibarye))
        assertEquals(1(CubicCentimeter), 20(Decierg) / 20(Decibarye))
        assertEquals(1(CubicMeter), 2(Joule) / 2(Pascal))

        assertEqualScientificValue(
            1(CubicFoot),
            (2 * ImperialStandardGravityAcceleration.value)(FootPoundal) / 2(PoundSquareFoot),
            8,
        )
        assertEquals(1(CubicInch), 2(InchPoundForce) / 2(PoundSquareInch))
        assertEquals(1(CubicInch), 32(InchOunceForce) / 2(PoundSquareInch))
        assertEquals(1(CubicFoot), 2(FootPoundForce) / 2(PoundSquareFoot))
        assertEqualScientificValue(
            1(CubicFoot),
            2(FootPoundForce).convert(WattHour) / 2(PoundSquareFoot),
            8,
        )
        assertEquals(1(CubicFoot.ukImperial), 2(FootPoundForce) / 2(PoundSquareFoot.ukImperial))
        assertEqualScientificValue(
            1(CubicFoot.ukImperial),
            2(FootPoundForce).convert(WattHour) / 2(PoundSquareFoot.ukImperial),
            8,
        )
        assertEquals(1(CubicFoot.usCustomary), 2(FootPoundForce) / 2(PoundSquareFoot.usCustomary))
        assertEqualScientificValue(
            1(CubicFoot.usCustomary),
            2(FootPoundForce).convert(WattHour) / 2(PoundSquareFoot.usCustomary),
            8,
        )
        assertEqualScientificValue(1(CubicMeter), 2(Joule) / 2(Pascal).convert(PoundSquareFoot), 8)
    }

    @Test
    fun volumeFromMolarVolumeAndAmountOfSubstanceTest() {
        assertEqualScientificValue(4(CubicMeter), 2(Decimole) * 2(CubicMeter per Decimole))
        assertEqualScientificValue(4(CubicMeter), 2(CubicMeter per Decimole) * 2(Decimole))
        assertEqualScientificValue(4(CubicFoot), 2(Decimole) * 2(CubicFoot per Decimole))
        assertEqualScientificValue(4(CubicFoot), 2(CubicFoot per Decimole) * 2(Decimole))
        assertEqualScientificValue(4(ImperialGallon), 2(Decimole) * 2(ImperialGallon per Decimole))
        assertEqualScientificValue(4(ImperialGallon), 2(ImperialGallon per Decimole) * 2(Decimole))
        assertEqualScientificValue(4(UsLiquidGallon), 2(Decimole) * 2(UsLiquidGallon per Decimole))
        assertEqualScientificValue(4(UsLiquidGallon), 2(UsLiquidGallon per Decimole) * 2(Decimole))
        assertEqualScientificValue(
            4(CubicMeter),
            2(Decimole) * 2(CubicMeter per Decimole).convert((CubicFoot per Decimole) as MolarVolume),
        )
        assertEqualScientificValue(
            4(CubicMeter),
            2(CubicMeter per Decimole).convert((CubicFoot per Decimole) as MolarVolume) * 2(Decimole),
        )
    }

    @Test
    fun volumeFromSpecificVolumeAndWeightTest() {
        assertEqualScientificValue(4(CubicMeter), 2(Kilogram) * 2(CubicMeter per Kilogram))
        assertEqualScientificValue(4(CubicMeter), 2(CubicMeter per Kilogram) * 2(Kilogram))
        assertEqualScientificValue(4(CubicFoot), 2(Pound) * 2(CubicFoot per Pound))
        assertEqualScientificValue(4(CubicFoot), 2(CubicFoot per Pound) * 2(Pound))
        assertEqualScientificValue(4(CubicFoot), 2(Pound.ukImperial) * 2(CubicFoot per Pound))
        assertEqualScientificValue(4(CubicFoot), 2(CubicFoot per Pound) * 2(Pound.ukImperial))
        assertEqualScientificValue(4(CubicFoot), 2(Pound.usCustomary) * 2(CubicFoot per Pound))
        assertEqualScientificValue(4(CubicFoot), 2(CubicFoot per Pound) * 2(Pound.usCustomary))
        assertEqualScientificValue(4(ImperialGallon), 2(Pound) * 2(ImperialGallon per Pound))
        assertEqualScientificValue(4(ImperialGallon), 2(ImperialGallon per Pound) * 2(Pound))
        assertEqualScientificValue(
            4(ImperialGallon),
            2(ImperialTon) * 2(ImperialGallon per ImperialTon),
        )
        assertEqualScientificValue(
            4(ImperialGallon),
            2(ImperialGallon per ImperialTon) * 2(ImperialTon),
        )
        assertEqualScientificValue(4(UsLiquidGallon), 2(Pound) * 2(UsLiquidGallon per Pound))
        assertEqualScientificValue(4(UsLiquidGallon), 2(UsLiquidGallon per Pound) * 2(Pound))
        assertEqualScientificValue(4(UsLiquidGallon), 2(UsTon) * 2(UsLiquidGallon per UsTon))
        assertEqualScientificValue(4(UsLiquidGallon), 2(UsLiquidGallon per UsTon) * 2(UsTon))
        assertEqualScientificValue(
            4(CubicMeter),
            2(Kilogram).convert(Pound) * 2(CubicMeter per Kilogram),
            8,
        )
        assertEqualScientificValue(
            4(CubicMeter),
            2(CubicMeter per Kilogram) * 2(Kilogram).convert(Pound),
            8,
        )
    }

    @Test
    fun volumeFromVolumetricFlowAndTimeTest() {
        assertEqualScientificValue(4(CubicMeter), 2(CubicMeter per Hour) * 2(Hour))
        assertEqualScientificValue(4(CubicMeter), 2(Hour) * 2(CubicMeter per Hour))
        assertEqualScientificValue(4(CubicFoot), 2(CubicFoot per Hour) * 2(Hour))
        assertEqualScientificValue(4(CubicFoot), 2(Hour) * 2(CubicFoot per Hour))
        assertEqualScientificValue(4(ImperialGallon), 2(ImperialGallon per Hour) * 2(Hour))
        assertEqualScientificValue(4(ImperialGallon), 2(Hour) * 2(ImperialGallon per Hour))
        assertEqualScientificValue(4(UsLiquidGallon), 2(UsLiquidGallon per Hour) * 2(Hour))
        assertEqualScientificValue(4(UsLiquidGallon), 2(Hour) * 2(UsLiquidGallon per Hour))
        assertEqualScientificValue(
            4(CubicMeter),
            2((CubicMeter per Hour) as VolumetricFlow) * 2(Hour),
        )
        assertEqualScientificValue(
            4(CubicMeter),
            2(Hour) * 2((CubicMeter per Hour) as VolumetricFlow),
        )
    }

    @Test
    fun volumeFromWeightAndDensityTest() {
        assertEqualScientificValue(1(CubicMeter), 2(Kilogram) / 2(Kilogram per CubicMeter))
        assertEqualScientificValue(1(CubicFoot), 2(Pound) / 2(Pound per CubicFoot))
        assertEqualScientificValue(1(CubicFoot), 2(Pound.ukImperial) / 2(Pound per CubicFoot))
        assertEqualScientificValue(1(CubicFoot), 2(Pound.usCustomary) / 2(Pound per CubicFoot))
        assertEqualScientificValue(1(ImperialGallon), 2(Pound) / 2(Pound per ImperialGallon))
        assertEqualScientificValue(
            1(ImperialGallon),
            2(ImperialTon) / 2(ImperialTon per ImperialGallon),
        )
        assertEqualScientificValue(1(UsLiquidGallon), 2(Pound) / 2(Pound per UsLiquidGallon))
        assertEqualScientificValue(1(UsLiquidGallon), 2(UsTon) / 2(UsTon per UsLiquidGallon))
        assertEqualScientificValue(
            1(CubicMeter),
            2(Kilogram).convert(Pound) / 2(Kilogram per CubicMeter),
            8,
        )
    }
}
