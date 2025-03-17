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

// Inv<Mul<A, B>> * Mul<C, B> -> Div<C, A>
class MultipliedByMultiplyingUnitWithRightAsRightTest {

	@Test
	fun multipliedByMultiplyingUnitWithRightAsRight() {
		assertEquals(
			4((UndefinedConverterUnits.MetricAndImperial.undefinedC per UndefinedConverterUnits.MetricAndImperial.undefinedA)),
			2((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedB).reciprocal()) metricAndImperialMultipliedByMetricAndImperial
				2((UndefinedConverterUnits.MetricAndImperial.undefinedC x UndefinedConverterUnits.MetricAndImperial.undefinedB))
		)
		assertEquals(
			4((UndefinedConverterUnits.Metric.undefinedC per UndefinedConverterUnits.Metric.undefinedA)),
			2((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedB).reciprocal()) metricMultipliedByMetric
				2((UndefinedConverterUnits.Metric.undefinedC x UndefinedConverterUnits.Metric.undefinedB))
		)
		assertEquals(
			4((UndefinedConverterUnits.Imperial.undefinedC per UndefinedConverterUnits.Imperial.undefinedA)),
			2((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedB).reciprocal()) imperialMultipliedByImperial
				2((UndefinedConverterUnits.Imperial.undefinedC x UndefinedConverterUnits.Imperial.undefinedB))
		)
		assertEquals(
			4((UndefinedConverterUnits.UKImperial.undefinedC per UndefinedConverterUnits.UKImperial.undefinedA)),
			2((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedB).reciprocal()) ukImperialMultipliedByUKImperial
				2((UndefinedConverterUnits.UKImperial.undefinedC x UndefinedConverterUnits.UKImperial.undefinedB))
		)
		assertEquals(
			4((UndefinedConverterUnits.USCustomary.undefinedC per UndefinedConverterUnits.USCustomary.undefinedA)),
			2((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedB).reciprocal()) usCustomaryMultipliedByUSCustomary
				2((UndefinedConverterUnits.USCustomary.undefinedC x UndefinedConverterUnits.USCustomary.undefinedB))
		)
		assertEquals(
			4((UndefinedConverterUnits.MetricAndUKImperial.undefinedC per UndefinedConverterUnits.MetricAndUKImperial.undefinedA)),
			2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedB).reciprocal()) metricAndUKImperialMultipliedByMetricAndUKImperial
				2((UndefinedConverterUnits.MetricAndUKImperial.undefinedC x UndefinedConverterUnits.MetricAndUKImperial.undefinedB))
		)
		assertEquals(
			4((UndefinedConverterUnits.MetricAndUSCustomary.undefinedC per UndefinedConverterUnits.MetricAndUSCustomary.undefinedA)),
			2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB).reciprocal()) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
				2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedC x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB))
		)
	}
}
