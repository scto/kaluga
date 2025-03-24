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
import com.splendo.kaluga.scientific.unit.per
import com.splendo.kaluga.scientific.unit.reciprocal
import com.splendo.kaluga.scientific.unit.x
import kotlin.test.Test
import kotlin.test.assertEquals

// Inv<Mul<A, A>> / Div<B, Mul<A, A>> -> Inv<B>

class ReciprocalSquaredDividedByDividingUnitWithSelfAsDenominatorTest {

	@Test
	fun dividedByDividingUnitWithSelfAsDenominator() {
		// assertEquals(
		// 	1.0(UndefinedConverterUnits.MetricAndImperial.undefinedB.reciprocal()),
		// 	2((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedA).reciprocal()) metricAndImperialDividedByMetricAndImperial
		// 		2((UndefinedConverterUnits.MetricAndImperial.undefinedB per (UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedA)))
		// )
		// assertEquals(
		// 	1.0(UndefinedConverterUnits.Metric.undefinedB.reciprocal()),
		// 	2((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedA).reciprocal()) metricDividedByMetric
		// 		2((UndefinedConverterUnits.Metric.undefinedB per (UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedA)))
		// )
		// assertEquals(
		// 	1.0(UndefinedConverterUnits.Imperial.undefinedB.reciprocal()),
		// 	2((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedA).reciprocal()) imperialDividedByImperial
		// 		2((UndefinedConverterUnits.Imperial.undefinedB per (UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedA)))
		// )
		// assertEquals(
		// 	1.0(UndefinedConverterUnits.UKImperial.undefinedB.reciprocal()),
		// 	2((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedA).reciprocal()) ukImperialDividedByUKImperial
		// 		2((UndefinedConverterUnits.UKImperial.undefinedB per (UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedA)))
		// )
		// assertEquals(
		// 	1.0(UndefinedConverterUnits.USCustomary.undefinedB.reciprocal()),
		// 	2((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedA).reciprocal()) usCustomaryDividedByUSCustomary
		// 		2((UndefinedConverterUnits.USCustomary.undefinedB per (UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedA)))
		// )
		// assertEquals(
		// 	1.0(UndefinedConverterUnits.MetricAndUKImperial.undefinedB.reciprocal()),
		// 	2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedA).reciprocal()) metricAndUKImperialDividedByMetricAndUKImperial
		// 		2((UndefinedConverterUnits.MetricAndUKImperial.undefinedB per (UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedA)))
		// )
		// assertEquals(
		// 	1.0(UndefinedConverterUnits.MetricAndUSCustomary.undefinedB.reciprocal()),
		// 	2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedA).reciprocal()) metricAndUSCustomaryDividedByMetricAndUSCustomary
		// 		2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedB per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedA)))
		// )
	}
}
