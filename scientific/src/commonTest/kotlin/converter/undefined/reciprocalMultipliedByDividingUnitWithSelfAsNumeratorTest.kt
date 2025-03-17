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
import kotlin.test.Test
import kotlin.test.assertEquals

// Inv<A> * Div<A, B> -> Inv<B>
class MultipliedByDividingUnitWithSelfAsNumeratorTest {

	@Test
	fun multipliedByDividingUnitWithSelfAsNumerator() {
		assertEquals(
			4(UndefinedConverterUnits.MetricAndImperial.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.MetricAndImperial.undefinedA.reciprocal()) metricAndImperialMultipliedByMetricAndImperial
				2((UndefinedConverterUnits.MetricAndImperial.undefinedA per UndefinedConverterUnits.MetricAndImperial.undefinedB))
		)
		assertEquals(
			4(UndefinedConverterUnits.Metric.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.Metric.undefinedA.reciprocal()) metricMultipliedByMetric
				2((UndefinedConverterUnits.Metric.undefinedA per UndefinedConverterUnits.Metric.undefinedB))
		)
		assertEquals(
			4(UndefinedConverterUnits.Imperial.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.Imperial.undefinedA.reciprocal()) imperialMultipliedByImperial
				2((UndefinedConverterUnits.Imperial.undefinedA per UndefinedConverterUnits.Imperial.undefinedB))
		)
		assertEquals(
			4(UndefinedConverterUnits.UKImperial.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.UKImperial.undefinedA.reciprocal()) ukImperialMultipliedByUKImperial
				2((UndefinedConverterUnits.UKImperial.undefinedA per UndefinedConverterUnits.UKImperial.undefinedB))
		)
		assertEquals(
			4(UndefinedConverterUnits.USCustomary.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.USCustomary.undefinedA.reciprocal()) usCustomaryMultipliedByUSCustomary
				2((UndefinedConverterUnits.USCustomary.undefinedA per UndefinedConverterUnits.USCustomary.undefinedB))
		)
		assertEquals(
			4(UndefinedConverterUnits.MetricAndUKImperial.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.MetricAndUKImperial.undefinedA.reciprocal()) metricAndUKImperialMultipliedByMetricAndUKImperial
				2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA per UndefinedConverterUnits.MetricAndUKImperial.undefinedB))
		)
		assertEquals(
			4(UndefinedConverterUnits.MetricAndUSCustomary.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.MetricAndUSCustomary.undefinedA.reciprocal()) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
				2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA per UndefinedConverterUnits.MetricAndUSCustomary.undefinedB))
		)
	}
}
