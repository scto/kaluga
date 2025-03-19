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

// Inv<Mul<A, B>> * Div<Mul<C, B>, D> -> Div<C, Mul<A, D>>

class ReciprocalMultiplyingMultipliedByDividingUnitWithMultiplyingNumeratorWithRightAsRightTest {

    @Test
    fun multipliedByDividingUnitWithMultiplyingNumeratorWithRightAsRight() {
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.MetricAndImperial.undefinedC per (UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedD))),
        // 	2((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedB).reciprocal()) metricAndImperialMultipliedByMetricAndImperial
        // 		2(((UndefinedConverterUnits.MetricAndImperial.undefinedC x UndefinedConverterUnits.MetricAndImperial.undefinedB) per UndefinedConverterUnits.MetricAndImperial.undefinedD))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.Metric.undefinedC per (UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedD))),
        // 	2((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedB).reciprocal()) metricMultipliedByMetric
        // 		2(((UndefinedConverterUnits.Metric.undefinedC x UndefinedConverterUnits.Metric.undefinedB) per UndefinedConverterUnits.Metric.undefinedD))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.Imperial.undefinedC per (UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedD))),
        // 	2((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedB).reciprocal()) imperialMultipliedByImperial
        // 		2(((UndefinedConverterUnits.Imperial.undefinedC x UndefinedConverterUnits.Imperial.undefinedB) per UndefinedConverterUnits.Imperial.undefinedD))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.UKImperial.undefinedC per (UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedD))),
        // 	2((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedB).reciprocal()) ukImperialMultipliedByUKImperial
        // 		2(((UndefinedConverterUnits.UKImperial.undefinedC x UndefinedConverterUnits.UKImperial.undefinedB) per UndefinedConverterUnits.UKImperial.undefinedD))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.USCustomary.undefinedC per (UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedD))),
        // 	2((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedB).reciprocal()) usCustomaryMultipliedByUSCustomary
        // 		2(((UndefinedConverterUnits.USCustomary.undefinedC x UndefinedConverterUnits.USCustomary.undefinedB) per UndefinedConverterUnits.USCustomary.undefinedD))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.MetricAndUKImperial.undefinedC per (UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedD))),
        // 	2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedB).reciprocal()) metricAndUKImperialMultipliedByMetricAndUKImperial
        // 		2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedC x UndefinedConverterUnits.MetricAndUKImperial.undefinedB) per UndefinedConverterUnits.MetricAndUKImperial.undefinedD))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.MetricAndUSCustomary.undefinedC per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedD))),
        // 	2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB).reciprocal()) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
        // 		2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedC x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB) per UndefinedConverterUnits.MetricAndUSCustomary.undefinedD))
        // )
    }
}
