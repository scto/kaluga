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

// Mul<A, B> * Inv<Mul<C, B>> -> Div<A, C>

class MultiplyingMultipliedByReciprocalMultiplyingWithRightAsRightTest {

    @Test
    fun multipliedByReciprocalMultiplyingWithRightAsRight() {
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.MetricAndImperial.undefinedA per UndefinedConverterUnits.MetricAndImperial.undefinedC)),
        // 	2((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedB)) metricAndImperialMultipliedByMetricAndImperial
        // 		2((UndefinedConverterUnits.MetricAndImperial.undefinedC x UndefinedConverterUnits.MetricAndImperial.undefinedB).reciprocal())
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.Metric.undefinedA per UndefinedConverterUnits.Metric.undefinedC)),
        // 	2((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedB)) metricMultipliedByMetric
        // 		2((UndefinedConverterUnits.Metric.undefinedC x UndefinedConverterUnits.Metric.undefinedB).reciprocal())
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.Imperial.undefinedA per UndefinedConverterUnits.Imperial.undefinedC)),
        // 	2((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedB)) imperialMultipliedByImperial
        // 		2((UndefinedConverterUnits.Imperial.undefinedC x UndefinedConverterUnits.Imperial.undefinedB).reciprocal())
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.UKImperial.undefinedA per UndefinedConverterUnits.UKImperial.undefinedC)),
        // 	2((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedB)) ukImperialMultipliedByUKImperial
        // 		2((UndefinedConverterUnits.UKImperial.undefinedC x UndefinedConverterUnits.UKImperial.undefinedB).reciprocal())
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.USCustomary.undefinedA per UndefinedConverterUnits.USCustomary.undefinedC)),
        // 	2((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedB)) usCustomaryMultipliedByUSCustomary
        // 		2((UndefinedConverterUnits.USCustomary.undefinedC x UndefinedConverterUnits.USCustomary.undefinedB).reciprocal())
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.MetricAndUKImperial.undefinedA per UndefinedConverterUnits.MetricAndUKImperial.undefinedC)),
        // 	2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedB)) metricAndUKImperialMultipliedByMetricAndUKImperial
        // 		2((UndefinedConverterUnits.MetricAndUKImperial.undefinedC x UndefinedConverterUnits.MetricAndUKImperial.undefinedB).reciprocal())
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA per UndefinedConverterUnits.MetricAndUSCustomary.undefinedC)),
        // 	2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB)) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
        // 		2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedC x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB).reciprocal())
        // )
    }
}
