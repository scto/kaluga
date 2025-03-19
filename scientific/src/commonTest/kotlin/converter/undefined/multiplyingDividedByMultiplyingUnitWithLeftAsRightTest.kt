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

// Mul<A, B> / Mul<C, A> -> Div<B, C>

class MultiplyingDividedByMultiplyingUnitWithLeftAsRightTest {

    @Test
    fun dividedByMultiplyingUnitWithLeftAsRight() {
        // assertEquals(
        // 	1.0((UndefinedConverterUnits.MetricAndImperial.undefinedB per UndefinedConverterUnits.MetricAndImperial.undefinedC)),
        // 	2((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedB)) metricAndImperialDividedByMetricAndImperial
        // 		2((UndefinedConverterUnits.MetricAndImperial.undefinedC x UndefinedConverterUnits.MetricAndImperial.undefinedA))
        // )
        // assertEquals(
        // 	1.0((UndefinedConverterUnits.Metric.undefinedB per UndefinedConverterUnits.Metric.undefinedC)),
        // 	2((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedB)) metricDividedByMetric
        // 		2((UndefinedConverterUnits.Metric.undefinedC x UndefinedConverterUnits.Metric.undefinedA))
        // )
        // assertEquals(
        // 	1.0((UndefinedConverterUnits.Imperial.undefinedB per UndefinedConverterUnits.Imperial.undefinedC)),
        // 	2((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedB)) imperialDividedByImperial
        // 		2((UndefinedConverterUnits.Imperial.undefinedC x UndefinedConverterUnits.Imperial.undefinedA))
        // )
        // assertEquals(
        // 	1.0((UndefinedConverterUnits.UKImperial.undefinedB per UndefinedConverterUnits.UKImperial.undefinedC)),
        // 	2((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedB)) ukImperialDividedByUKImperial
        // 		2((UndefinedConverterUnits.UKImperial.undefinedC x UndefinedConverterUnits.UKImperial.undefinedA))
        // )
        // assertEquals(
        // 	1.0((UndefinedConverterUnits.USCustomary.undefinedB per UndefinedConverterUnits.USCustomary.undefinedC)),
        // 	2((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedB)) usCustomaryDividedByUSCustomary
        // 		2((UndefinedConverterUnits.USCustomary.undefinedC x UndefinedConverterUnits.USCustomary.undefinedA))
        // )
        // assertEquals(
        // 	1.0((UndefinedConverterUnits.MetricAndUKImperial.undefinedB per UndefinedConverterUnits.MetricAndUKImperial.undefinedC)),
        // 	2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedB)) metricAndUKImperialDividedByMetricAndUKImperial
        // 		2((UndefinedConverterUnits.MetricAndUKImperial.undefinedC x UndefinedConverterUnits.MetricAndUKImperial.undefinedA))
        // )
        // assertEquals(
        // 	1.0((UndefinedConverterUnits.MetricAndUSCustomary.undefinedB per UndefinedConverterUnits.MetricAndUSCustomary.undefinedC)),
        // 	2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB)) metricAndUSCustomaryDividedByMetricAndUSCustomary
        // 		2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedC x UndefinedConverterUnits.MetricAndUSCustomary.undefinedA))
        // )
    }
}
