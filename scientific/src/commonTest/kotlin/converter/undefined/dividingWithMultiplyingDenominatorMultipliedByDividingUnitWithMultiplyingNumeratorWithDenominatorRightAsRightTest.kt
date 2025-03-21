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

// Div<D, Mul<E, B>> * Div<Mul<A, B>, C> -> Div<Mul<D, A>, Mul<E, C>>

class DivWMulDenomMultipliedByDivUnitWMulNumWDenomRAsRTest {

    @Test
    fun multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsRight() {
        // assertEquals(
        // 	4.0(((UndefinedConverterUnits.MetricAndImperial.undefinedD x UndefinedConverterUnits.MetricAndImperial.undefinedA) per (UndefinedConverterUnits.MetricAndImperial.undefinedE x UndefinedConverterUnits.MetricAndImperial.undefinedC))),
        // 	2((UndefinedConverterUnits.MetricAndImperial.undefinedD per (UndefinedConverterUnits.MetricAndImperial.undefinedE x UndefinedConverterUnits.MetricAndImperial.undefinedB))) metricAndImperialMultipliedByMetricAndImperial
        // 		2(((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedB) per UndefinedConverterUnits.MetricAndImperial.undefinedC))
        // )
        // assertEquals(
        // 	4.0(((UndefinedConverterUnits.Metric.undefinedD x UndefinedConverterUnits.Metric.undefinedA) per (UndefinedConverterUnits.Metric.undefinedE x UndefinedConverterUnits.Metric.undefinedC))),
        // 	2((UndefinedConverterUnits.Metric.undefinedD per (UndefinedConverterUnits.Metric.undefinedE x UndefinedConverterUnits.Metric.undefinedB))) metricMultipliedByMetric
        // 		2(((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedB) per UndefinedConverterUnits.Metric.undefinedC))
        // )
        // assertEquals(
        // 	4.0(((UndefinedConverterUnits.Imperial.undefinedD x UndefinedConverterUnits.Imperial.undefinedA) per (UndefinedConverterUnits.Imperial.undefinedE x UndefinedConverterUnits.Imperial.undefinedC))),
        // 	2((UndefinedConverterUnits.Imperial.undefinedD per (UndefinedConverterUnits.Imperial.undefinedE x UndefinedConverterUnits.Imperial.undefinedB))) imperialMultipliedByImperial
        // 		2(((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedB) per UndefinedConverterUnits.Imperial.undefinedC))
        // )
        // assertEquals(
        // 	4.0(((UndefinedConverterUnits.UKImperial.undefinedD x UndefinedConverterUnits.UKImperial.undefinedA) per (UndefinedConverterUnits.UKImperial.undefinedE x UndefinedConverterUnits.UKImperial.undefinedC))),
        // 	2((UndefinedConverterUnits.UKImperial.undefinedD per (UndefinedConverterUnits.UKImperial.undefinedE x UndefinedConverterUnits.UKImperial.undefinedB))) ukImperialMultipliedByUKImperial
        // 		2(((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedB) per UndefinedConverterUnits.UKImperial.undefinedC))
        // )
        // assertEquals(
        // 	4.0(((UndefinedConverterUnits.USCustomary.undefinedD x UndefinedConverterUnits.USCustomary.undefinedA) per (UndefinedConverterUnits.USCustomary.undefinedE x UndefinedConverterUnits.USCustomary.undefinedC))),
        // 	2((UndefinedConverterUnits.USCustomary.undefinedD per (UndefinedConverterUnits.USCustomary.undefinedE x UndefinedConverterUnits.USCustomary.undefinedB))) usCustomaryMultipliedByUSCustomary
        // 		2(((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedB) per UndefinedConverterUnits.USCustomary.undefinedC))
        // )
        // assertEquals(
        // 	4.0(((UndefinedConverterUnits.MetricAndUKImperial.undefinedD x UndefinedConverterUnits.MetricAndUKImperial.undefinedA) per (UndefinedConverterUnits.MetricAndUKImperial.undefinedE x UndefinedConverterUnits.MetricAndUKImperial.undefinedC))),
        // 	2((UndefinedConverterUnits.MetricAndUKImperial.undefinedD per (UndefinedConverterUnits.MetricAndUKImperial.undefinedE x UndefinedConverterUnits.MetricAndUKImperial.undefinedB))) metricAndUKImperialMultipliedByMetricAndUKImperial
        // 		2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedB) per UndefinedConverterUnits.MetricAndUKImperial.undefinedC))
        // )
        // assertEquals(
        // 	4.0(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedD x UndefinedConverterUnits.MetricAndUSCustomary.undefinedA) per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedE x UndefinedConverterUnits.MetricAndUSCustomary.undefinedC))),
        // 	2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedD per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedE x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB))) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
        // 		2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB) per UndefinedConverterUnits.MetricAndUSCustomary.undefinedC))
        // )
    }
}
