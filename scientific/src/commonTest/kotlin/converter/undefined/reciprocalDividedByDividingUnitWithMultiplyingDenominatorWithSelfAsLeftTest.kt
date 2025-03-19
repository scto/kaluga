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

// Inv<A> / Div<C, Mul<A, B>> -> Div<B, C>

class ReciprocalDividedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeftTest {

    @Test
    fun dividedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeft() {
        // assertEquals(
        // 	1.0((UndefinedConverterUnits.MetricAndImperial.undefinedB per UndefinedConverterUnits.MetricAndImperial.undefinedC)),
        // 	2(UndefinedConverterUnits.MetricAndImperial.undefinedA.reciprocal()) metricAndImperialDividedByMetricAndImperial
        // 		2((UndefinedConverterUnits.MetricAndImperial.undefinedC per (UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedB)))
        // )
        // assertEquals(
        // 	1.0((UndefinedConverterUnits.Metric.undefinedB per UndefinedConverterUnits.Metric.undefinedC)),
        // 	2(UndefinedConverterUnits.Metric.undefinedA.reciprocal()) metricDividedByMetric
        // 		2((UndefinedConverterUnits.Metric.undefinedC per (UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedB)))
        // )
        // assertEquals(
        // 	1.0((UndefinedConverterUnits.Imperial.undefinedB per UndefinedConverterUnits.Imperial.undefinedC)),
        // 	2(UndefinedConverterUnits.Imperial.undefinedA.reciprocal()) imperialDividedByImperial
        // 		2((UndefinedConverterUnits.Imperial.undefinedC per (UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedB)))
        // )
        // assertEquals(
        // 	1.0((UndefinedConverterUnits.UKImperial.undefinedB per UndefinedConverterUnits.UKImperial.undefinedC)),
        // 	2(UndefinedConverterUnits.UKImperial.undefinedA.reciprocal()) ukImperialDividedByUKImperial
        // 		2((UndefinedConverterUnits.UKImperial.undefinedC per (UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedB)))
        // )
        // assertEquals(
        // 	1.0((UndefinedConverterUnits.USCustomary.undefinedB per UndefinedConverterUnits.USCustomary.undefinedC)),
        // 	2(UndefinedConverterUnits.USCustomary.undefinedA.reciprocal()) usCustomaryDividedByUSCustomary
        // 		2((UndefinedConverterUnits.USCustomary.undefinedC per (UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedB)))
        // )
        // assertEquals(
        // 	1.0((UndefinedConverterUnits.MetricAndUKImperial.undefinedB per UndefinedConverterUnits.MetricAndUKImperial.undefinedC)),
        // 	2(UndefinedConverterUnits.MetricAndUKImperial.undefinedA.reciprocal()) metricAndUKImperialDividedByMetricAndUKImperial
        // 		2((UndefinedConverterUnits.MetricAndUKImperial.undefinedC per (UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedB)))
        // )
        // assertEquals(
        // 	1.0((UndefinedConverterUnits.MetricAndUSCustomary.undefinedB per UndefinedConverterUnits.MetricAndUSCustomary.undefinedC)),
        // 	2(UndefinedConverterUnits.MetricAndUSCustomary.undefinedA.reciprocal()) metricAndUSCustomaryDividedByMetricAndUSCustomary
        // 		2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedC per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB)))
        // )
    }
}
