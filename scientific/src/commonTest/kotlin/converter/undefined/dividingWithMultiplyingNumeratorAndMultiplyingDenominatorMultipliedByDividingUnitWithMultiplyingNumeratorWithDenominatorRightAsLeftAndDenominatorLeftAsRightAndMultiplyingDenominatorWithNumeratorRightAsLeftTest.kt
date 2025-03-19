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

// Div<Mul<E, C>, Mul<B, A>> * Div<Mul<A, B>, Mul<C, D>> -> Div<E, D>

class DividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorRightAsLeftTest {

    @Test
    fun multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorRightAsLeft() {
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.MetricAndImperial.undefinedE per UndefinedConverterUnits.MetricAndImperial.undefinedD)),
        // 	2(((UndefinedConverterUnits.MetricAndImperial.undefinedE x UndefinedConverterUnits.MetricAndImperial.undefinedC) per (UndefinedConverterUnits.MetricAndImperial.undefinedB x UndefinedConverterUnits.MetricAndImperial.undefinedA))) metricAndImperialMultipliedByMetricAndImperial
        // 		2(((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedB) per (UndefinedConverterUnits.MetricAndImperial.undefinedC x UndefinedConverterUnits.MetricAndImperial.undefinedD)))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.Metric.undefinedE per UndefinedConverterUnits.Metric.undefinedD)),
        // 	2(((UndefinedConverterUnits.Metric.undefinedE x UndefinedConverterUnits.Metric.undefinedC) per (UndefinedConverterUnits.Metric.undefinedB x UndefinedConverterUnits.Metric.undefinedA))) metricMultipliedByMetric
        // 		2(((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedB) per (UndefinedConverterUnits.Metric.undefinedC x UndefinedConverterUnits.Metric.undefinedD)))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.Imperial.undefinedE per UndefinedConverterUnits.Imperial.undefinedD)),
        // 	2(((UndefinedConverterUnits.Imperial.undefinedE x UndefinedConverterUnits.Imperial.undefinedC) per (UndefinedConverterUnits.Imperial.undefinedB x UndefinedConverterUnits.Imperial.undefinedA))) imperialMultipliedByImperial
        // 		2(((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedB) per (UndefinedConverterUnits.Imperial.undefinedC x UndefinedConverterUnits.Imperial.undefinedD)))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.UKImperial.undefinedE per UndefinedConverterUnits.UKImperial.undefinedD)),
        // 	2(((UndefinedConverterUnits.UKImperial.undefinedE x UndefinedConverterUnits.UKImperial.undefinedC) per (UndefinedConverterUnits.UKImperial.undefinedB x UndefinedConverterUnits.UKImperial.undefinedA))) ukImperialMultipliedByUKImperial
        // 		2(((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedB) per (UndefinedConverterUnits.UKImperial.undefinedC x UndefinedConverterUnits.UKImperial.undefinedD)))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.USCustomary.undefinedE per UndefinedConverterUnits.USCustomary.undefinedD)),
        // 	2(((UndefinedConverterUnits.USCustomary.undefinedE x UndefinedConverterUnits.USCustomary.undefinedC) per (UndefinedConverterUnits.USCustomary.undefinedB x UndefinedConverterUnits.USCustomary.undefinedA))) usCustomaryMultipliedByUSCustomary
        // 		2(((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedB) per (UndefinedConverterUnits.USCustomary.undefinedC x UndefinedConverterUnits.USCustomary.undefinedD)))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.MetricAndUKImperial.undefinedE per UndefinedConverterUnits.MetricAndUKImperial.undefinedD)),
        // 	2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedE x UndefinedConverterUnits.MetricAndUKImperial.undefinedC) per (UndefinedConverterUnits.MetricAndUKImperial.undefinedB x UndefinedConverterUnits.MetricAndUKImperial.undefinedA))) metricAndUKImperialMultipliedByMetricAndUKImperial
        // 		2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedB) per (UndefinedConverterUnits.MetricAndUKImperial.undefinedC x UndefinedConverterUnits.MetricAndUKImperial.undefinedD)))
        // )
        // assertEquals(
        // 	4.0((UndefinedConverterUnits.MetricAndUSCustomary.undefinedE per UndefinedConverterUnits.MetricAndUSCustomary.undefinedD)),
        // 	2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedE x UndefinedConverterUnits.MetricAndUSCustomary.undefinedC) per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedB x UndefinedConverterUnits.MetricAndUSCustomary.undefinedA))) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
        // 		2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB) per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedC x UndefinedConverterUnits.MetricAndUSCustomary.undefinedD)))
        // )
    }
}
