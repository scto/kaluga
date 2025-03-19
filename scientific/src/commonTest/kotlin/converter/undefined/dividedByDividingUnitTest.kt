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

// A / Div<B, C> -> Div<Mul<A, C>, B>

class DividedByDividingUnitTest {

    @Test
    fun dividedByDividingUnit() {
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedC) per UndefinedConverterUnits.MetricAndImperial.undefinedB)),
        // 	2(UndefinedConverterUnits.MetricAndImperial.undefinedA) metricAndImperialDividedByMetricAndImperial
        // 		2((UndefinedConverterUnits.MetricAndImperial.undefinedB per UndefinedConverterUnits.MetricAndImperial.undefinedC))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedC) per UndefinedConverterUnits.Metric.undefinedB)),
        // 	2(UndefinedConverterUnits.Metric.undefinedA) metricDividedByMetric
        // 		2((UndefinedConverterUnits.Metric.undefinedB per UndefinedConverterUnits.Metric.undefinedC))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedC) per UndefinedConverterUnits.Imperial.undefinedB)),
        // 	2(UndefinedConverterUnits.Imperial.undefinedA) imperialDividedByImperial
        // 		2((UndefinedConverterUnits.Imperial.undefinedB per UndefinedConverterUnits.Imperial.undefinedC))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedC) per UndefinedConverterUnits.UKImperial.undefinedB)),
        // 	2(UndefinedConverterUnits.UKImperial.undefinedA) ukImperialDividedByUKImperial
        // 		2((UndefinedConverterUnits.UKImperial.undefinedB per UndefinedConverterUnits.UKImperial.undefinedC))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedC) per UndefinedConverterUnits.USCustomary.undefinedB)),
        // 	2(UndefinedConverterUnits.USCustomary.undefinedA) usCustomaryDividedByUSCustomary
        // 		2((UndefinedConverterUnits.USCustomary.undefinedB per UndefinedConverterUnits.USCustomary.undefinedC))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedC) per UndefinedConverterUnits.MetricAndUKImperial.undefinedB)),
        // 	2(UndefinedConverterUnits.MetricAndUKImperial.undefinedA) metricAndUKImperialDividedByMetricAndUKImperial
        // 		2((UndefinedConverterUnits.MetricAndUKImperial.undefinedB per UndefinedConverterUnits.MetricAndUKImperial.undefinedC))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedC) per UndefinedConverterUnits.MetricAndUSCustomary.undefinedB)),
        // 	2(UndefinedConverterUnits.MetricAndUSCustomary.undefinedA) metricAndUSCustomaryDividedByMetricAndUSCustomary
        // 		2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedB per UndefinedConverterUnits.MetricAndUSCustomary.undefinedC))
        // )
    }
}
