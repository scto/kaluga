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

package com.splendo.kaluga.scientific.converter.undefined

import com.splendo.kaluga.scientific.invoke
import kotlin.test.Test

// Div<A, Mul<B, C>> * Div<C, Mul<A, D>> -> Inv<Mul<B, D>>

class DividingWithMultiplyingDenominatorMultipliedByDividingUnitWithDenominatorRightAsNumeratorAndMultiplyingDenominatorWithNumeratorAsLeftTest {

    @Test
    fun multipliedByDividingUnitWithDenominatorRightAsNumeratorAndMultiplyingDenominatorWithNumeratorAsLeft() {
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.MetricAndImperial.undefinedB x UndefinedConverterUnits.MetricAndImperial.undefinedD).reciprocal()),
        // 	2((UndefinedConverterUnits.MetricAndImperial.undefinedA per (UndefinedConverterUnits.MetricAndImperial.undefinedB x UndefinedConverterUnits.MetricAndImperial.undefinedC))) metricAndImperialMultipliedByMetricAndImperial
        // 		2((UndefinedConverterUnits.MetricAndImperial.undefinedC per (UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedD)))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.Metric.undefinedB x UndefinedConverterUnits.Metric.undefinedD).reciprocal()),
        // 	2((UndefinedConverterUnits.Metric.undefinedA per (UndefinedConverterUnits.Metric.undefinedB x UndefinedConverterUnits.Metric.undefinedC))) metricMultipliedByMetric
        // 		2((UndefinedConverterUnits.Metric.undefinedC per (UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedD)))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.Imperial.undefinedB x UndefinedConverterUnits.Imperial.undefinedD).reciprocal()),
        // 	2((UndefinedConverterUnits.Imperial.undefinedA per (UndefinedConverterUnits.Imperial.undefinedB x UndefinedConverterUnits.Imperial.undefinedC))) imperialMultipliedByImperial
        // 		2((UndefinedConverterUnits.Imperial.undefinedC per (UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedD)))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.UKImperial.undefinedB x UndefinedConverterUnits.UKImperial.undefinedD).reciprocal()),
        // 	2((UndefinedConverterUnits.UKImperial.undefinedA per (UndefinedConverterUnits.UKImperial.undefinedB x UndefinedConverterUnits.UKImperial.undefinedC))) ukImperialMultipliedByUKImperial
        // 		2((UndefinedConverterUnits.UKImperial.undefinedC per (UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedD)))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.USCustomary.undefinedB x UndefinedConverterUnits.USCustomary.undefinedD).reciprocal()),
        // 	2((UndefinedConverterUnits.USCustomary.undefinedA per (UndefinedConverterUnits.USCustomary.undefinedB x UndefinedConverterUnits.USCustomary.undefinedC))) usCustomaryMultipliedByUSCustomary
        // 		2((UndefinedConverterUnits.USCustomary.undefinedC per (UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedD)))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.MetricAndUKImperial.undefinedB x UndefinedConverterUnits.MetricAndUKImperial.undefinedD).reciprocal()),
        // 	2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA per (UndefinedConverterUnits.MetricAndUKImperial.undefinedB x UndefinedConverterUnits.MetricAndUKImperial.undefinedC))) metricAndUKImperialMultipliedByMetricAndUKImperial
        // 		2((UndefinedConverterUnits.MetricAndUKImperial.undefinedC per (UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedD)))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.MetricAndUSCustomary.undefinedB x UndefinedConverterUnits.MetricAndUSCustomary.undefinedD).reciprocal()),
        // 	2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedB x UndefinedConverterUnits.MetricAndUSCustomary.undefinedC))) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
        // 		2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedC per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedD)))
        // )
    }
}
