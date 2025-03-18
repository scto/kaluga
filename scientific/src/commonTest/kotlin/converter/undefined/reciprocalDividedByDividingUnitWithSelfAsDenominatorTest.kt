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

// Inv<A> / Div<B, A> -> Inv<B>
class ReciprocalDividedByDividingUnitWithSelfAsDenominatorTest {

	@Test
	fun dividedByDividingUnitWithSelfAsDenominator() {
		assertEquals(
			1(UndefinedConverterUnits.MetricAndImperial.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.MetricAndImperial.undefinedA.reciprocal()) metricAndImperialDividedByMetricAndImperial
				2((UndefinedConverterUnits.MetricAndImperial.undefinedB per UndefinedConverterUnits.MetricAndImperial.undefinedA))
		)
		assertEquals(
			1(UndefinedConverterUnits.Metric.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.Metric.undefinedA.reciprocal()) metricDividedByMetric
				2((UndefinedConverterUnits.Metric.undefinedB per UndefinedConverterUnits.Metric.undefinedA))
		)
		assertEquals(
			1(UndefinedConverterUnits.Imperial.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.Imperial.undefinedA.reciprocal()) imperialDividedByImperial
				2((UndefinedConverterUnits.Imperial.undefinedB per UndefinedConverterUnits.Imperial.undefinedA))
		)
		assertEquals(
			1(UndefinedConverterUnits.UKImperial.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.UKImperial.undefinedA.reciprocal()) ukImperialDividedByUKImperial
				2((UndefinedConverterUnits.UKImperial.undefinedB per UndefinedConverterUnits.UKImperial.undefinedA))
		)
		assertEquals(
			1(UndefinedConverterUnits.USCustomary.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.USCustomary.undefinedA.reciprocal()) usCustomaryDividedByUSCustomary
				2((UndefinedConverterUnits.USCustomary.undefinedB per UndefinedConverterUnits.USCustomary.undefinedA))
		)
		assertEquals(
			1(UndefinedConverterUnits.MetricAndUKImperial.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.MetricAndUKImperial.undefinedA.reciprocal()) metricAndUKImperialDividedByMetricAndUKImperial
				2((UndefinedConverterUnits.MetricAndUKImperial.undefinedB per UndefinedConverterUnits.MetricAndUKImperial.undefinedA))
		)
		assertEquals(
			1(UndefinedConverterUnits.MetricAndUSCustomary.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.MetricAndUSCustomary.undefinedA.reciprocal()) metricAndUSCustomaryDividedByMetricAndUSCustomary
				2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedB per UndefinedConverterUnits.MetricAndUSCustomary.undefinedA))
		)
	}
}
