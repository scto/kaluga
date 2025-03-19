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

// Div<Mul<A, B>, Mul<C, D>> / Div<Mul<E, A>, Mul<C, F>> -> Div<Mul<B, F>, Mul<D, E>>

class DividingWithMultiplyingNumeratorAndMultiplyingDenominatorDividedByDividingUnitWithMultiplyingNumeratorWithNumeratorLeftAsRightAndMultiplyingDenominatorWithDenominatorLeftAsLeftTest {

    @Test
    fun dividedByDividingUnitWithMultiplyingNumeratorWithNumeratorLeftAsRightAndMultiplyingDenominatorWithDenominatorLeftAsLeft() {
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.MetricAndImperial.undefinedB x UndefinedConverterUnits.MetricAndImperial.undefinedF) per (UndefinedConverterUnits.MetricAndImperial.undefinedD x UndefinedConverterUnits.MetricAndImperial.undefinedE))),
        // 	2(((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedB) per (UndefinedConverterUnits.MetricAndImperial.undefinedC x UndefinedConverterUnits.MetricAndImperial.undefinedD))) metricAndImperialDividedByMetricAndImperial
        // 		2(((UndefinedConverterUnits.MetricAndImperial.undefinedE x UndefinedConverterUnits.MetricAndImperial.undefinedA) per (UndefinedConverterUnits.MetricAndImperial.undefinedC x UndefinedConverterUnits.MetricAndImperial.undefinedF)))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.Metric.undefinedB x UndefinedConverterUnits.Metric.undefinedF) per (UndefinedConverterUnits.Metric.undefinedD x UndefinedConverterUnits.Metric.undefinedE))),
        // 	2(((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedB) per (UndefinedConverterUnits.Metric.undefinedC x UndefinedConverterUnits.Metric.undefinedD))) metricDividedByMetric
        // 		2(((UndefinedConverterUnits.Metric.undefinedE x UndefinedConverterUnits.Metric.undefinedA) per (UndefinedConverterUnits.Metric.undefinedC x UndefinedConverterUnits.Metric.undefinedF)))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.Imperial.undefinedB x UndefinedConverterUnits.Imperial.undefinedF) per (UndefinedConverterUnits.Imperial.undefinedD x UndefinedConverterUnits.Imperial.undefinedE))),
        // 	2(((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedB) per (UndefinedConverterUnits.Imperial.undefinedC x UndefinedConverterUnits.Imperial.undefinedD))) imperialDividedByImperial
        // 		2(((UndefinedConverterUnits.Imperial.undefinedE x UndefinedConverterUnits.Imperial.undefinedA) per (UndefinedConverterUnits.Imperial.undefinedC x UndefinedConverterUnits.Imperial.undefinedF)))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.UKImperial.undefinedB x UndefinedConverterUnits.UKImperial.undefinedF) per (UndefinedConverterUnits.UKImperial.undefinedD x UndefinedConverterUnits.UKImperial.undefinedE))),
        // 	2(((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedB) per (UndefinedConverterUnits.UKImperial.undefinedC x UndefinedConverterUnits.UKImperial.undefinedD))) ukImperialDividedByUKImperial
        // 		2(((UndefinedConverterUnits.UKImperial.undefinedE x UndefinedConverterUnits.UKImperial.undefinedA) per (UndefinedConverterUnits.UKImperial.undefinedC x UndefinedConverterUnits.UKImperial.undefinedF)))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.USCustomary.undefinedB x UndefinedConverterUnits.USCustomary.undefinedF) per (UndefinedConverterUnits.USCustomary.undefinedD x UndefinedConverterUnits.USCustomary.undefinedE))),
        // 	2(((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedB) per (UndefinedConverterUnits.USCustomary.undefinedC x UndefinedConverterUnits.USCustomary.undefinedD))) usCustomaryDividedByUSCustomary
        // 		2(((UndefinedConverterUnits.USCustomary.undefinedE x UndefinedConverterUnits.USCustomary.undefinedA) per (UndefinedConverterUnits.USCustomary.undefinedC x UndefinedConverterUnits.USCustomary.undefinedF)))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.MetricAndUKImperial.undefinedB x UndefinedConverterUnits.MetricAndUKImperial.undefinedF) per (UndefinedConverterUnits.MetricAndUKImperial.undefinedD x UndefinedConverterUnits.MetricAndUKImperial.undefinedE))),
        // 	2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedB) per (UndefinedConverterUnits.MetricAndUKImperial.undefinedC x UndefinedConverterUnits.MetricAndUKImperial.undefinedD))) metricAndUKImperialDividedByMetricAndUKImperial
        // 		2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedE x UndefinedConverterUnits.MetricAndUKImperial.undefinedA) per (UndefinedConverterUnits.MetricAndUKImperial.undefinedC x UndefinedConverterUnits.MetricAndUKImperial.undefinedF)))
        // )
        // assertEquals(
        // 	1.0(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedB x UndefinedConverterUnits.MetricAndUSCustomary.undefinedF) per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedD x UndefinedConverterUnits.MetricAndUSCustomary.undefinedE))),
        // 	2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB) per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedC x UndefinedConverterUnits.MetricAndUSCustomary.undefinedD))) metricAndUSCustomaryDividedByMetricAndUSCustomary
        // 		2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedE x UndefinedConverterUnits.MetricAndUSCustomary.undefinedA) per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedC x UndefinedConverterUnits.MetricAndUSCustomary.undefinedF)))
        // )
    }
}
