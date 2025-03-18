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
import com.splendo.kaluga.scientific.unit.x
import kotlin.test.Test
import kotlin.test.assertEquals

// Div<A, B> * Div<Mul<C, B>, A> -> C
class DividingMultipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndNumeratorAsDenominatorTest {

	@Test
	fun multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndNumeratorAsDenominator() {
		assertEquals(
			4(UndefinedConverterUnits.MetricAndImperial.undefinedC),
			2((UndefinedConverterUnits.MetricAndImperial.undefinedA per UndefinedConverterUnits.MetricAndImperial.undefinedB)) metricAndImperialMultipliedByMetricAndImperial
				2(((UndefinedConverterUnits.MetricAndImperial.undefinedC x UndefinedConverterUnits.MetricAndImperial.undefinedB) per UndefinedConverterUnits.MetricAndImperial.undefinedA))
		)
		assertEquals(
			4(UndefinedConverterUnits.Metric.undefinedC),
			2((UndefinedConverterUnits.Metric.undefinedA per UndefinedConverterUnits.Metric.undefinedB)) metricMultipliedByMetric
				2(((UndefinedConverterUnits.Metric.undefinedC x UndefinedConverterUnits.Metric.undefinedB) per UndefinedConverterUnits.Metric.undefinedA))
		)
		assertEquals(
			4(UndefinedConverterUnits.Imperial.undefinedC),
			2((UndefinedConverterUnits.Imperial.undefinedA per UndefinedConverterUnits.Imperial.undefinedB)) imperialMultipliedByImperial
				2(((UndefinedConverterUnits.Imperial.undefinedC x UndefinedConverterUnits.Imperial.undefinedB) per UndefinedConverterUnits.Imperial.undefinedA))
		)
		assertEquals(
			4(UndefinedConverterUnits.UKImperial.undefinedC),
			2((UndefinedConverterUnits.UKImperial.undefinedA per UndefinedConverterUnits.UKImperial.undefinedB)) ukImperialMultipliedByUKImperial
				2(((UndefinedConverterUnits.UKImperial.undefinedC x UndefinedConverterUnits.UKImperial.undefinedB) per UndefinedConverterUnits.UKImperial.undefinedA))
		)
		assertEquals(
			4(UndefinedConverterUnits.USCustomary.undefinedC),
			2((UndefinedConverterUnits.USCustomary.undefinedA per UndefinedConverterUnits.USCustomary.undefinedB)) usCustomaryMultipliedByUSCustomary
				2(((UndefinedConverterUnits.USCustomary.undefinedC x UndefinedConverterUnits.USCustomary.undefinedB) per UndefinedConverterUnits.USCustomary.undefinedA))
		)
		assertEquals(
			4(UndefinedConverterUnits.MetricAndUKImperial.undefinedC),
			2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA per UndefinedConverterUnits.MetricAndUKImperial.undefinedB)) metricAndUKImperialMultipliedByMetricAndUKImperial
				2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedC x UndefinedConverterUnits.MetricAndUKImperial.undefinedB) per UndefinedConverterUnits.MetricAndUKImperial.undefinedA))
		)
		assertEquals(
			4(UndefinedConverterUnits.MetricAndUSCustomary.undefinedC),
			2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA per UndefinedConverterUnits.MetricAndUSCustomary.undefinedB)) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
				2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedC x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB) per UndefinedConverterUnits.MetricAndUSCustomary.undefinedA))
		)
	}
}
