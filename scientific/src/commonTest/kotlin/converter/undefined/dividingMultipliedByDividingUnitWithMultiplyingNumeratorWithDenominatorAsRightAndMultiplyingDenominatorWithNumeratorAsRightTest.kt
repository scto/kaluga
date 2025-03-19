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

// Div<A, B> * Div<Mul<C, B>, Mul<D, A>> -> Div<C, D>

class DividingMultipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndMultiplyingDenominatorWithNumeratorAsRightTest {

    @Test
    fun multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndMultiplyingDenominatorWithNumeratorAsRight() {
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.MetricAndImperial.undefinedC per UndefinedConverterUnits.MetricAndImperial.undefinedD)),
        // 	2((UndefinedConverterUnits.MetricAndImperial.undefinedA per UndefinedConverterUnits.MetricAndImperial.undefinedB)) metricAndImperialMultipliedByMetricAndImperial
        // 		2(((UndefinedConverterUnits.MetricAndImperial.undefinedC x UndefinedConverterUnits.MetricAndImperial.undefinedB) per (UndefinedConverterUnits.MetricAndImperial.undefinedD x UndefinedConverterUnits.MetricAndImperial.undefinedA)))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.Metric.undefinedC per UndefinedConverterUnits.Metric.undefinedD)),
        // 	2((UndefinedConverterUnits.Metric.undefinedA per UndefinedConverterUnits.Metric.undefinedB)) metricMultipliedByMetric
        // 		2(((UndefinedConverterUnits.Metric.undefinedC x UndefinedConverterUnits.Metric.undefinedB) per (UndefinedConverterUnits.Metric.undefinedD x UndefinedConverterUnits.Metric.undefinedA)))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.Imperial.undefinedC per UndefinedConverterUnits.Imperial.undefinedD)),
        // 	2((UndefinedConverterUnits.Imperial.undefinedA per UndefinedConverterUnits.Imperial.undefinedB)) imperialMultipliedByImperial
        // 		2(((UndefinedConverterUnits.Imperial.undefinedC x UndefinedConverterUnits.Imperial.undefinedB) per (UndefinedConverterUnits.Imperial.undefinedD x UndefinedConverterUnits.Imperial.undefinedA)))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.UKImperial.undefinedC per UndefinedConverterUnits.UKImperial.undefinedD)),
        // 	2((UndefinedConverterUnits.UKImperial.undefinedA per UndefinedConverterUnits.UKImperial.undefinedB)) ukImperialMultipliedByUKImperial
        // 		2(((UndefinedConverterUnits.UKImperial.undefinedC x UndefinedConverterUnits.UKImperial.undefinedB) per (UndefinedConverterUnits.UKImperial.undefinedD x UndefinedConverterUnits.UKImperial.undefinedA)))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.USCustomary.undefinedC per UndefinedConverterUnits.USCustomary.undefinedD)),
        // 	2((UndefinedConverterUnits.USCustomary.undefinedA per UndefinedConverterUnits.USCustomary.undefinedB)) usCustomaryMultipliedByUSCustomary
        // 		2(((UndefinedConverterUnits.USCustomary.undefinedC x UndefinedConverterUnits.USCustomary.undefinedB) per (UndefinedConverterUnits.USCustomary.undefinedD x UndefinedConverterUnits.USCustomary.undefinedA)))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.MetricAndUKImperial.undefinedC per UndefinedConverterUnits.MetricAndUKImperial.undefinedD)),
        // 	2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA per UndefinedConverterUnits.MetricAndUKImperial.undefinedB)) metricAndUKImperialMultipliedByMetricAndUKImperial
        // 		2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedC x UndefinedConverterUnits.MetricAndUKImperial.undefinedB) per (UndefinedConverterUnits.MetricAndUKImperial.undefinedD x UndefinedConverterUnits.MetricAndUKImperial.undefinedA)))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.MetricAndUSCustomary.undefinedC per UndefinedConverterUnits.MetricAndUSCustomary.undefinedD)),
        // 	2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA per UndefinedConverterUnits.MetricAndUSCustomary.undefinedB)) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
        // 		2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedC x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB) per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedD x UndefinedConverterUnits.MetricAndUSCustomary.undefinedA)))
        // )
    }
}
