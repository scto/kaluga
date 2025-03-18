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
import com.splendo.kaluga.scientific.unit.reciprocal
import com.splendo.kaluga.scientific.unit.x
import kotlin.test.Test
import kotlin.test.assertEquals

// Inv<Mul<A, B>> * A -> Inv<B>

class ReciprocalMultiplyingMultipliedByLeftTest {

	@Test
	fun multipliedByLeft() {
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.MetricAndImperial.undefinedB.reciprocal()),
		// 	2((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedB).reciprocal()) metricAndImperialMultipliedByMetricAndImperial
		// 		2(UndefinedConverterUnits.MetricAndImperial.undefinedA)
		// )
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.Metric.undefinedB.reciprocal()),
		// 	2((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedB).reciprocal()) metricMultipliedByMetric
		// 		2(UndefinedConverterUnits.Metric.undefinedA)
		// )
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.Imperial.undefinedB.reciprocal()),
		// 	2((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedB).reciprocal()) imperialMultipliedByImperial
		// 		2(UndefinedConverterUnits.Imperial.undefinedA)
		// )
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.UKImperial.undefinedB.reciprocal()),
		// 	2((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedB).reciprocal()) ukImperialMultipliedByUKImperial
		// 		2(UndefinedConverterUnits.UKImperial.undefinedA)
		// )
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.USCustomary.undefinedB.reciprocal()),
		// 	2((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedB).reciprocal()) usCustomaryMultipliedByUSCustomary
		// 		2(UndefinedConverterUnits.USCustomary.undefinedA)
		// )
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.MetricAndUKImperial.undefinedB.reciprocal()),
		// 	2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedB).reciprocal()) metricAndUKImperialMultipliedByMetricAndUKImperial
		// 		2(UndefinedConverterUnits.MetricAndUKImperial.undefinedA)
		// )
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.MetricAndUSCustomary.undefinedB.reciprocal()),
		// 	2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB).reciprocal()) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
		// 		2(UndefinedConverterUnits.MetricAndUSCustomary.undefinedA)
		// )
	}
}
