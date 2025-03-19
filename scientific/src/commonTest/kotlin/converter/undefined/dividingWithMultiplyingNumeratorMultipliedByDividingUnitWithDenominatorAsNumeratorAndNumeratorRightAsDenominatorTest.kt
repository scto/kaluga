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

// Div<Mul<C, B>, A> * Div<A, B> -> C

class DividingWithMultiplyingNumeratorMultipliedByDividingUnitWithDenominatorAsNumeratorAndNumeratorRightAsDenominatorTest {

    @Test
    fun multipliedByDividingUnitWithDenominatorAsNumeratorAndNumeratorRightAsDenominator() {
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.MetricAndImperial.undefinedC),
        // 	2(((UndefinedConverterUnits.MetricAndImperial.undefinedC x UndefinedConverterUnits.MetricAndImperial.undefinedB) per UndefinedConverterUnits.MetricAndImperial.undefinedA)) metricAndImperialMultipliedByMetricAndImperial
        // 		2((UndefinedConverterUnits.MetricAndImperial.undefinedA per UndefinedConverterUnits.MetricAndImperial.undefinedB))
        // )
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.Metric.undefinedC),
        // 	2(((UndefinedConverterUnits.Metric.undefinedC x UndefinedConverterUnits.Metric.undefinedB) per UndefinedConverterUnits.Metric.undefinedA)) metricMultipliedByMetric
        // 		2((UndefinedConverterUnits.Metric.undefinedA per UndefinedConverterUnits.Metric.undefinedB))
        // )
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.Imperial.undefinedC),
        // 	2(((UndefinedConverterUnits.Imperial.undefinedC x UndefinedConverterUnits.Imperial.undefinedB) per UndefinedConverterUnits.Imperial.undefinedA)) imperialMultipliedByImperial
        // 		2((UndefinedConverterUnits.Imperial.undefinedA per UndefinedConverterUnits.Imperial.undefinedB))
        // )
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.UKImperial.undefinedC),
        // 	2(((UndefinedConverterUnits.UKImperial.undefinedC x UndefinedConverterUnits.UKImperial.undefinedB) per UndefinedConverterUnits.UKImperial.undefinedA)) ukImperialMultipliedByUKImperial
        // 		2((UndefinedConverterUnits.UKImperial.undefinedA per UndefinedConverterUnits.UKImperial.undefinedB))
        // )
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.USCustomary.undefinedC),
        // 	2(((UndefinedConverterUnits.USCustomary.undefinedC x UndefinedConverterUnits.USCustomary.undefinedB) per UndefinedConverterUnits.USCustomary.undefinedA)) usCustomaryMultipliedByUSCustomary
        // 		2((UndefinedConverterUnits.USCustomary.undefinedA per UndefinedConverterUnits.USCustomary.undefinedB))
        // )
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.MetricAndUKImperial.undefinedC),
        // 	2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedC x UndefinedConverterUnits.MetricAndUKImperial.undefinedB) per UndefinedConverterUnits.MetricAndUKImperial.undefinedA)) metricAndUKImperialMultipliedByMetricAndUKImperial
        // 		2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA per UndefinedConverterUnits.MetricAndUKImperial.undefinedB))
        // )
        // assertEquals(
        // 	4.0(UndefinedConverterUnits.MetricAndUSCustomary.undefinedC),
        // 	2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedC x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB) per UndefinedConverterUnits.MetricAndUSCustomary.undefinedA)) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
        // 		2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA per UndefinedConverterUnits.MetricAndUSCustomary.undefinedB))
        // )
    }
}
