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

// A * Inv<Mul<B, A>> -> Inv<B>

class MultipliedByReciprocalMultiplyingWithSelfAsRightTest {

    @Test
    fun multipliedByReciprocalMultiplyingWithSelfAsRight() {
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.MetricAndImperial.undefinedB.reciprocal()),
        // 	2(UndefinedConverterUnits.MetricAndImperial.undefinedA) metricAndImperialMultipliedByMetricAndImperial
        // 		2((UndefinedConverterUnits.MetricAndImperial.undefinedB x UndefinedConverterUnits.MetricAndImperial.undefinedA).reciprocal())
        // )
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.Metric.undefinedB.reciprocal()),
        // 	2(UndefinedConverterUnits.Metric.undefinedA) metricMultipliedByMetric
        // 		2((UndefinedConverterUnits.Metric.undefinedB x UndefinedConverterUnits.Metric.undefinedA).reciprocal())
        // )
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.Imperial.undefinedB.reciprocal()),
        // 	2(UndefinedConverterUnits.Imperial.undefinedA) imperialMultipliedByImperial
        // 		2((UndefinedConverterUnits.Imperial.undefinedB x UndefinedConverterUnits.Imperial.undefinedA).reciprocal())
        // )
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.UKImperial.undefinedB.reciprocal()),
        // 	2(UndefinedConverterUnits.UKImperial.undefinedA) ukImperialMultipliedByUKImperial
        // 		2((UndefinedConverterUnits.UKImperial.undefinedB x UndefinedConverterUnits.UKImperial.undefinedA).reciprocal())
        // )
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.USCustomary.undefinedB.reciprocal()),
        // 	2(UndefinedConverterUnits.USCustomary.undefinedA) usCustomaryMultipliedByUSCustomary
        // 		2((UndefinedConverterUnits.USCustomary.undefinedB x UndefinedConverterUnits.USCustomary.undefinedA).reciprocal())
        // )
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.MetricAndUKImperial.undefinedB.reciprocal()),
        // 	2(UndefinedConverterUnits.MetricAndUKImperial.undefinedA) metricAndUKImperialMultipliedByMetricAndUKImperial
        // 		2((UndefinedConverterUnits.MetricAndUKImperial.undefinedB x UndefinedConverterUnits.MetricAndUKImperial.undefinedA).reciprocal())
        // )
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.MetricAndUSCustomary.undefinedB.reciprocal()),
        // 	2(UndefinedConverterUnits.MetricAndUSCustomary.undefinedA) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
        // 		2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedB x UndefinedConverterUnits.MetricAndUSCustomary.undefinedA).reciprocal())
        // )
    }
}
