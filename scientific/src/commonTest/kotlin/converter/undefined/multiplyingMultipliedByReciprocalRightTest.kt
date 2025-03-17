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

// Mul<A, B> * Inv<B> -> A
class MultipliedByReciprocalRightTest {

	@Test
	fun multipliedByReciprocalRight() {
		assertEquals(
			4(UndefinedConverterUnits.MetricAndImperial.undefinedA),
			2((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedB)) metricAndImperialMultipliedByMetricAndImperial
				2(UndefinedConverterUnits.MetricAndImperial.undefinedB.reciprocal())
		)
		assertEquals(
			4(UndefinedConverterUnits.Metric.undefinedA),
			2((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedB)) metricMultipliedByMetric
				2(UndefinedConverterUnits.Metric.undefinedB.reciprocal())
		)
		assertEquals(
			4(UndefinedConverterUnits.Imperial.undefinedA),
			2((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedB)) imperialMultipliedByImperial
				2(UndefinedConverterUnits.Imperial.undefinedB.reciprocal())
		)
		assertEquals(
			4(UndefinedConverterUnits.UKImperial.undefinedA),
			2((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedB)) ukImperialMultipliedByUKImperial
				2(UndefinedConverterUnits.UKImperial.undefinedB.reciprocal())
		)
		assertEquals(
			4(UndefinedConverterUnits.USCustomary.undefinedA),
			2((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedB)) usCustomaryMultipliedByUSCustomary
				2(UndefinedConverterUnits.USCustomary.undefinedB.reciprocal())
		)
		assertEquals(
			4(UndefinedConverterUnits.MetricAndUKImperial.undefinedA),
			2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedB)) metricAndUKImperialMultipliedByMetricAndUKImperial
				2(UndefinedConverterUnits.MetricAndUKImperial.undefinedB.reciprocal())
		)
		assertEquals(
			4(UndefinedConverterUnits.MetricAndUSCustomary.undefinedA),
			2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB)) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
				2(UndefinedConverterUnits.MetricAndUSCustomary.undefinedB.reciprocal())
		)
	}
}
