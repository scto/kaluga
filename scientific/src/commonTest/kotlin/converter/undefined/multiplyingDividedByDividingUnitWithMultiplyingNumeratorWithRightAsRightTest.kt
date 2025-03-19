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

// Mul<A, B> / Div<Mul<C, B>, D> -> Div<Mul<A, D>, C>

class MultiplyingDividedByDividingUnitWithMultiplyingNumeratorWithRightAsRightTest {

    @Test
    fun dividedByDividingUnitWithMultiplyingNumeratorWithRightAsRight() {
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedD) per UndefinedConverterUnits.MetricAndImperial.undefinedC)),
        // 	2((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedB)) metricAndImperialDividedByMetricAndImperial
        // 		2(((UndefinedConverterUnits.MetricAndImperial.undefinedC x UndefinedConverterUnits.MetricAndImperial.undefinedB) per UndefinedConverterUnits.MetricAndImperial.undefinedD))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedD) per UndefinedConverterUnits.Metric.undefinedC)),
        // 	2((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedB)) metricDividedByMetric
        // 		2(((UndefinedConverterUnits.Metric.undefinedC x UndefinedConverterUnits.Metric.undefinedB) per UndefinedConverterUnits.Metric.undefinedD))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedD) per UndefinedConverterUnits.Imperial.undefinedC)),
        // 	2((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedB)) imperialDividedByImperial
        // 		2(((UndefinedConverterUnits.Imperial.undefinedC x UndefinedConverterUnits.Imperial.undefinedB) per UndefinedConverterUnits.Imperial.undefinedD))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedD) per UndefinedConverterUnits.UKImperial.undefinedC)),
        // 	2((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedB)) ukImperialDividedByUKImperial
        // 		2(((UndefinedConverterUnits.UKImperial.undefinedC x UndefinedConverterUnits.UKImperial.undefinedB) per UndefinedConverterUnits.UKImperial.undefinedD))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedD) per UndefinedConverterUnits.USCustomary.undefinedC)),
        // 	2((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedB)) usCustomaryDividedByUSCustomary
        // 		2(((UndefinedConverterUnits.USCustomary.undefinedC x UndefinedConverterUnits.USCustomary.undefinedB) per UndefinedConverterUnits.USCustomary.undefinedD))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedD) per UndefinedConverterUnits.MetricAndUKImperial.undefinedC)),
        // 	2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedB)) metricAndUKImperialDividedByMetricAndUKImperial
        // 		2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedC x UndefinedConverterUnits.MetricAndUKImperial.undefinedB) per UndefinedConverterUnits.MetricAndUKImperial.undefinedD))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedD) per UndefinedConverterUnits.MetricAndUSCustomary.undefinedC)),
        // 	2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB)) metricAndUSCustomaryDividedByMetricAndUSCustomary
        // 		2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedC x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB) per UndefinedConverterUnits.MetricAndUSCustomary.undefinedD))
        // )
    }
}
