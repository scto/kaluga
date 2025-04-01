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
import com.splendo.kaluga.scientific.converter.energy.div
import com.splendo.kaluga.scientific.converter.power.times
import com.splendo.kaluga.scientific.converter.specificEnergy.div
import com.splendo.kaluga.scientific.converter.thermalResistance.times
import com.splendo.kaluga.scientific.invoke
import com.splendo.kaluga.scientific.unit.*
import kotlin.test.Test

class TemperatureUnitTest {

    @Test
    fun temperatureFromEnergyAndHeatCapacityTest() {
        assertEqualScientificValue(1(Celsius), 2(WattHour) / 2(WattHour per Celsius))
        assertEqualScientificValue(1(Celsius), 2(WattHour) / 2(WattHour.metric per Celsius))
        assertEqualScientificValue(1(Celsius), 2(WattHour) / 2(WattHour.imperial per Celsius))
        assertEqualScientificValue(1(Fahrenheit), 2(WattHour) / 2(WattHour per Fahrenheit))
        assertEqualScientificValue(1(Celsius), 2(WattHour.imperial) / 2(WattHour per Celsius))
        assertEqualScientificValue(
            1(Celsius),
            2(BritishThermalUnit) / 2(BritishThermalUnit per Celsius),
        )
        assertEqualScientificValue(
            1(Fahrenheit),
            2(BritishThermalUnit) / 2(BritishThermalUnit per Fahrenheit),
        )
        assertEqualScientificValue(
            1(Kelvin),
            2(Joule).convert(BritishThermalUnit) / 2(Joule per Kelvin),
        )
    }

    @Test
    fun temperatureFromSpecificEnergyAndSpecificHeatCapacityTest() {
        assertEqualScientificValue(
            1(Celsius),
            2(Joule per Kilogram) / 2(Joule per Celsius per Kilogram),
        )
        assertEqualScientificValue(
            1(Celsius),
            2(WattHour per Pound) / 2(WattHour per Celsius per Pound),
        )
        assertEqualScientificValue(
            1(Fahrenheit),
            2(WattHour per Pound) / 2(WattHour per Fahrenheit per Pound),
        )
        assertEqualScientificValue(
            1(Celsius),
            2(WattHour per ImperialTon) / 2(WattHour per Celsius per ImperialTon),
        )
        assertEqualScientificValue(
            1(Fahrenheit),
            2(WattHour per UsTon) / 2(WattHour per Fahrenheit per UsTon),
        )
        assertEqualScientificValue(
            1(Kelvin),
            2(Joule per Kilogram).convert(WattHour per Pound) / 2(Joule per Celsius per Kilogram),
        )
    }

    @Test
    fun temperatureFromThermalResistanceAndPowerTest() {
        assertEqualScientificValue(4(Celsius), 2(Celsius per Watt) * 2(Watt))
        assertEqualScientificValue(4(Celsius), 2(Watt) * 2(Celsius per Watt))
        assertEqualScientificValue(4(Celsius), 2(Celsius per Watt.metric) * 2(Watt))
        assertEqualScientificValue(4(Celsius), 2(Watt) * 2(Celsius per Watt.metric))
        assertEqualScientificValue(4(Celsius), 2(Celsius per (Erg per Second)) * 2(Erg per Second))
        assertEqualScientificValue(4(Celsius), 2(Erg per Second) * 2(Celsius per (Erg per Second)))
        assertEqualScientificValue(4(Celsius), 2(Celsius per Watt.imperial) * 2(Watt))
        assertEqualScientificValue(4(Celsius), 2(Watt) * 2(Celsius per Watt.imperial))
        assertEqualScientificValue(
            4(Celsius),
            2(Celsius per (BritishThermalUnit per Second)) * 2(BritishThermalUnit per Second),
        )
        assertEqualScientificValue(
            4(Celsius),
            2(BritishThermalUnit per Second) * 2(Celsius per (BritishThermalUnit per Second)),
        )
        assertEqualScientificValue(4(Fahrenheit), 2(Fahrenheit per Watt) * 2(Watt))
        assertEqualScientificValue(4(Fahrenheit), 2(Watt) * 2(Fahrenheit per Watt))
        assertEqualScientificValue(
            4(Fahrenheit),
            2(Fahrenheit per (BritishThermalUnit per Second)) * 2(BritishThermalUnit per Second),
        )
        assertEqualScientificValue(
            4(Fahrenheit),
            2(BritishThermalUnit per Second) * 2(Fahrenheit per (BritishThermalUnit per Second)),
        )
        assertEqualScientificValue(
            4(Kelvin),
            2(Celsius per Watt).convert(Fahrenheit per Watt) * 2(Watt.metric),
        )
        assertEqualScientificValue(
            4(Kelvin),
            2(Watt.metric) * 2(Celsius per Watt).convert(Fahrenheit per Watt),
        )
    }
}
