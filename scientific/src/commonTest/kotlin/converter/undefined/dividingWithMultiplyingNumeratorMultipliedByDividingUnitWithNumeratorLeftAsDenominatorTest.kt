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

// Div<Mul<B, C>, D> * Div<A, B> -> Div<Mul<C, A>, D>

class DividingWithMultiplyingNumeratorMultipliedByDividingUnitWithNumeratorLeftAsDenominatorTest {

    @Test
    fun multipliedByDividingUnitWithNumeratorLeftAsDenominator() {
        // assertEquals(
        // 	4.0(((UndefinedConverterUnits.MetricAndImperial.undefinedC x UndefinedConverterUnits.MetricAndImperial.undefinedA) per UndefinedConverterUnits.MetricAndImperial.undefinedD)),
        // 	2(((UndefinedConverterUnits.MetricAndImperial.undefinedB x UndefinedConverterUnits.MetricAndImperial.undefinedC) per UndefinedConverterUnits.MetricAndImperial.undefinedD)) metricAndImperialMultipliedByMetricAndImperial
        // 		2((UndefinedConverterUnits.MetricAndImperial.undefinedA per UndefinedConverterUnits.MetricAndImperial.undefinedB))
        // )
        // assertEquals(
        // 	4.0(((UndefinedConverterUnits.Metric.undefinedC x UndefinedConverterUnits.Metric.undefinedA) per UndefinedConverterUnits.Metric.undefinedD)),
        // 	2(((UndefinedConverterUnits.Metric.undefinedB x UndefinedConverterUnits.Metric.undefinedC) per UndefinedConverterUnits.Metric.undefinedD)) metricMultipliedByMetric
        // 		2((UndefinedConverterUnits.Metric.undefinedA per UndefinedConverterUnits.Metric.undefinedB))
        // )
        // assertEquals(
        // 	4.0(((UndefinedConverterUnits.Imperial.undefinedC x UndefinedConverterUnits.Imperial.undefinedA) per UndefinedConverterUnits.Imperial.undefinedD)),
        // 	2(((UndefinedConverterUnits.Imperial.undefinedB x UndefinedConverterUnits.Imperial.undefinedC) per UndefinedConverterUnits.Imperial.undefinedD)) imperialMultipliedByImperial
        // 		2((UndefinedConverterUnits.Imperial.undefinedA per UndefinedConverterUnits.Imperial.undefinedB))
        // )
        // assertEquals(
        // 	4.0(((UndefinedConverterUnits.UKImperial.undefinedC x UndefinedConverterUnits.UKImperial.undefinedA) per UndefinedConverterUnits.UKImperial.undefinedD)),
        // 	2(((UndefinedConverterUnits.UKImperial.undefinedB x UndefinedConverterUnits.UKImperial.undefinedC) per UndefinedConverterUnits.UKImperial.undefinedD)) ukImperialMultipliedByUKImperial
        // 		2((UndefinedConverterUnits.UKImperial.undefinedA per UndefinedConverterUnits.UKImperial.undefinedB))
        // )
        // assertEquals(
        // 	4.0(((UndefinedConverterUnits.USCustomary.undefinedC x UndefinedConverterUnits.USCustomary.undefinedA) per UndefinedConverterUnits.USCustomary.undefinedD)),
        // 	2(((UndefinedConverterUnits.USCustomary.undefinedB x UndefinedConverterUnits.USCustomary.undefinedC) per UndefinedConverterUnits.USCustomary.undefinedD)) usCustomaryMultipliedByUSCustomary
        // 		2((UndefinedConverterUnits.USCustomary.undefinedA per UndefinedConverterUnits.USCustomary.undefinedB))
        // )
        // assertEquals(
        // 	4.0(((UndefinedConverterUnits.MetricAndUKImperial.undefinedC x UndefinedConverterUnits.MetricAndUKImperial.undefinedA) per UndefinedConverterUnits.MetricAndUKImperial.undefinedD)),
        // 	2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedB x UndefinedConverterUnits.MetricAndUKImperial.undefinedC) per UndefinedConverterUnits.MetricAndUKImperial.undefinedD)) metricAndUKImperialMultipliedByMetricAndUKImperial
        // 		2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA per UndefinedConverterUnits.MetricAndUKImperial.undefinedB))
        // )
        // assertEquals(
        // 	4.0(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedC x UndefinedConverterUnits.MetricAndUSCustomary.undefinedA) per UndefinedConverterUnits.MetricAndUSCustomary.undefinedD)),
        // 	2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedB x UndefinedConverterUnits.MetricAndUSCustomary.undefinedC) per UndefinedConverterUnits.MetricAndUSCustomary.undefinedD)) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
        // 		2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA per UndefinedConverterUnits.MetricAndUSCustomary.undefinedB))
        // )
    }
}
