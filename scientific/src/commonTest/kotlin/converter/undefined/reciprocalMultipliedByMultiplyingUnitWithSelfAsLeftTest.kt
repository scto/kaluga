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

// Inv<A> * Mul<A, B> -> B

class ReciprocalMultipliedByMultiplyingUnitWithSelfAsLeftTest {

    @Test
    fun multipliedByMultiplyingUnitWithSelfAsLeft() {
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.MetricAndImperial.undefinedB),
        // 	2(UndefinedConverterUnits.MetricAndImperial.undefinedA.reciprocal()) metricAndImperialMultipliedByMetricAndImperial
        // 		2((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedB))
        // )
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.Metric.undefinedB),
        // 	2(UndefinedConverterUnits.Metric.undefinedA.reciprocal()) metricMultipliedByMetric
        // 		2((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedB))
        // )
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.Imperial.undefinedB),
        // 	2(UndefinedConverterUnits.Imperial.undefinedA.reciprocal()) imperialMultipliedByImperial
        // 		2((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedB))
        // )
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.UKImperial.undefinedB),
        // 	2(UndefinedConverterUnits.UKImperial.undefinedA.reciprocal()) ukImperialMultipliedByUKImperial
        // 		2((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedB))
        // )
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.USCustomary.undefinedB),
        // 	2(UndefinedConverterUnits.USCustomary.undefinedA.reciprocal()) usCustomaryMultipliedByUSCustomary
        // 		2((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedB))
        // )
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.MetricAndUKImperial.undefinedB),
        // 	2(UndefinedConverterUnits.MetricAndUKImperial.undefinedA.reciprocal()) metricAndUKImperialMultipliedByMetricAndUKImperial
        // 		2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedB))
        // )
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.MetricAndUSCustomary.undefinedB),
        // 	2(UndefinedConverterUnits.MetricAndUSCustomary.undefinedA.reciprocal()) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
        // 		2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB))
        // )
    }
}
