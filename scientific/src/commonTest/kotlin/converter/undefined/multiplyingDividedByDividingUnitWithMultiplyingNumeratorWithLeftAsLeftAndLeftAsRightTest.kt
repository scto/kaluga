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

// Mul<A, B> / Div<Mul<A, A>, C> -> Div<Mul<B, C>, A>

class MultiplyingDividedByDividingUnitWithMultiplyingNumeratorWithLeftAsLeftAndLeftAsRightTest {

    @Test
    fun dividedByDividingUnitWithMultiplyingNumeratorWithLeftAsLeftAndLeftAsRight() {
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.MetricAndImperial.undefinedB x UndefinedConverterUnits.MetricAndImperial.undefinedC) per UndefinedConverterUnits.MetricAndImperial.undefinedA)),
        // 	2((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedB)) metricAndImperialDividedByMetricAndImperial
        // 		2(((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedA) per UndefinedConverterUnits.MetricAndImperial.undefinedC))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.Metric.undefinedB x UndefinedConverterUnits.Metric.undefinedC) per UndefinedConverterUnits.Metric.undefinedA)),
        // 	2((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedB)) metricDividedByMetric
        // 		2(((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedA) per UndefinedConverterUnits.Metric.undefinedC))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.Imperial.undefinedB x UndefinedConverterUnits.Imperial.undefinedC) per UndefinedConverterUnits.Imperial.undefinedA)),
        // 	2((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedB)) imperialDividedByImperial
        // 		2(((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedA) per UndefinedConverterUnits.Imperial.undefinedC))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.UKImperial.undefinedB x UndefinedConverterUnits.UKImperial.undefinedC) per UndefinedConverterUnits.UKImperial.undefinedA)),
        // 	2((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedB)) ukImperialDividedByUKImperial
        // 		2(((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedA) per UndefinedConverterUnits.UKImperial.undefinedC))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.USCustomary.undefinedB x UndefinedConverterUnits.USCustomary.undefinedC) per UndefinedConverterUnits.USCustomary.undefinedA)),
        // 	2((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedB)) usCustomaryDividedByUSCustomary
        // 		2(((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedA) per UndefinedConverterUnits.USCustomary.undefinedC))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.MetricAndUKImperial.undefinedB x UndefinedConverterUnits.MetricAndUKImperial.undefinedC) per UndefinedConverterUnits.MetricAndUKImperial.undefinedA)),
        // 	2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedB)) metricAndUKImperialDividedByMetricAndUKImperial
        // 		2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedA) per UndefinedConverterUnits.MetricAndUKImperial.undefinedC))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedB x UndefinedConverterUnits.MetricAndUSCustomary.undefinedC) per UndefinedConverterUnits.MetricAndUSCustomary.undefinedA)),
        // 	2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB)) metricAndUSCustomaryDividedByMetricAndUSCustomary
        // 		2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedA) per UndefinedConverterUnits.MetricAndUSCustomary.undefinedC))
        // )
    }
}
