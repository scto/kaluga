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

// Div<A, Mul<B, C>> / Inv<Mul<C, B>> -> A

class DivWMulDenomDividedByReciprocalMulWDenomRAsLAndDenomLAsRTest {

    @Test
    fun dividedByReciprocalMultiplyingWithDenominatorRightAsLeftAndDenominatorLeftAsRight() {
        // assertEquals(
        // 	1.0(UndefinedConverterUnits.MetricAndImperial.undefinedA),
        // 	2((UndefinedConverterUnits.MetricAndImperial.undefinedA per (UndefinedConverterUnits.MetricAndImperial.undefinedB x UndefinedConverterUnits.MetricAndImperial.undefinedC))) metricAndImperialDividedByMetricAndImperial
        // 		2((UndefinedConverterUnits.MetricAndImperial.undefinedC x UndefinedConverterUnits.MetricAndImperial.undefinedB).reciprocal())
        // )
        // assertEquals(
        // 	1.0(UndefinedConverterUnits.Metric.undefinedA),
        // 	2((UndefinedConverterUnits.Metric.undefinedA per (UndefinedConverterUnits.Metric.undefinedB x UndefinedConverterUnits.Metric.undefinedC))) metricDividedByMetric
        // 		2((UndefinedConverterUnits.Metric.undefinedC x UndefinedConverterUnits.Metric.undefinedB).reciprocal())
        // )
        // assertEquals(
        // 	1.0(UndefinedConverterUnits.Imperial.undefinedA),
        // 	2((UndefinedConverterUnits.Imperial.undefinedA per (UndefinedConverterUnits.Imperial.undefinedB x UndefinedConverterUnits.Imperial.undefinedC))) imperialDividedByImperial
        // 		2((UndefinedConverterUnits.Imperial.undefinedC x UndefinedConverterUnits.Imperial.undefinedB).reciprocal())
        // )
        // assertEquals(
        // 	1.0(UndefinedConverterUnits.UKImperial.undefinedA),
        // 	2((UndefinedConverterUnits.UKImperial.undefinedA per (UndefinedConverterUnits.UKImperial.undefinedB x UndefinedConverterUnits.UKImperial.undefinedC))) ukImperialDividedByUKImperial
        // 		2((UndefinedConverterUnits.UKImperial.undefinedC x UndefinedConverterUnits.UKImperial.undefinedB).reciprocal())
        // )
        // assertEquals(
        // 	1.0(UndefinedConverterUnits.USCustomary.undefinedA),
        // 	2((UndefinedConverterUnits.USCustomary.undefinedA per (UndefinedConverterUnits.USCustomary.undefinedB x UndefinedConverterUnits.USCustomary.undefinedC))) usCustomaryDividedByUSCustomary
        // 		2((UndefinedConverterUnits.USCustomary.undefinedC x UndefinedConverterUnits.USCustomary.undefinedB).reciprocal())
        // )
        // assertEquals(
        // 	1.0(UndefinedConverterUnits.MetricAndUKImperial.undefinedA),
        // 	2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA per (UndefinedConverterUnits.MetricAndUKImperial.undefinedB x UndefinedConverterUnits.MetricAndUKImperial.undefinedC))) metricAndUKImperialDividedByMetricAndUKImperial
        // 		2((UndefinedConverterUnits.MetricAndUKImperial.undefinedC x UndefinedConverterUnits.MetricAndUKImperial.undefinedB).reciprocal())
        // )
        // assertEquals(
        // 	1.0(UndefinedConverterUnits.MetricAndUSCustomary.undefinedA),
        // 	2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedB x UndefinedConverterUnits.MetricAndUSCustomary.undefinedC))) metricAndUSCustomaryDividedByMetricAndUSCustomary
        // 		2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedC x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB).reciprocal())
        // )
    }
}
