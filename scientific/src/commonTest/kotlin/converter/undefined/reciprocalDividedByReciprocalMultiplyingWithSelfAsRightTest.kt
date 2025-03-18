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

// Inv<A> / Inv<Mul<B, A>> -> B
class ReciprocalDividedByReciprocalMultiplyingWithSelfAsRightTest {

	@Test
	fun dividedByReciprocalMultiplyingWithSelfAsRight() {
		assertEquals(
			1(UndefinedConverterUnits.MetricAndImperial.undefinedB),
			2(UndefinedConverterUnits.MetricAndImperial.undefinedA.reciprocal()) metricAndImperialDividedByMetricAndImperial
				2((UndefinedConverterUnits.MetricAndImperial.undefinedB x UndefinedConverterUnits.MetricAndImperial.undefinedA).reciprocal())
		)
		assertEquals(
			1(UndefinedConverterUnits.Metric.undefinedB),
			2(UndefinedConverterUnits.Metric.undefinedA.reciprocal()) metricDividedByMetric
				2((UndefinedConverterUnits.Metric.undefinedB x UndefinedConverterUnits.Metric.undefinedA).reciprocal())
		)
		assertEquals(
			1(UndefinedConverterUnits.Imperial.undefinedB),
			2(UndefinedConverterUnits.Imperial.undefinedA.reciprocal()) imperialDividedByImperial
				2((UndefinedConverterUnits.Imperial.undefinedB x UndefinedConverterUnits.Imperial.undefinedA).reciprocal())
		)
		assertEquals(
			1(UndefinedConverterUnits.UKImperial.undefinedB),
			2(UndefinedConverterUnits.UKImperial.undefinedA.reciprocal()) ukImperialDividedByUKImperial
				2((UndefinedConverterUnits.UKImperial.undefinedB x UndefinedConverterUnits.UKImperial.undefinedA).reciprocal())
		)
		assertEquals(
			1(UndefinedConverterUnits.USCustomary.undefinedB),
			2(UndefinedConverterUnits.USCustomary.undefinedA.reciprocal()) usCustomaryDividedByUSCustomary
				2((UndefinedConverterUnits.USCustomary.undefinedB x UndefinedConverterUnits.USCustomary.undefinedA).reciprocal())
		)
		assertEquals(
			1(UndefinedConverterUnits.MetricAndUKImperial.undefinedB),
			2(UndefinedConverterUnits.MetricAndUKImperial.undefinedA.reciprocal()) metricAndUKImperialDividedByMetricAndUKImperial
				2((UndefinedConverterUnits.MetricAndUKImperial.undefinedB x UndefinedConverterUnits.MetricAndUKImperial.undefinedA).reciprocal())
		)
		assertEquals(
			1(UndefinedConverterUnits.MetricAndUSCustomary.undefinedB),
			2(UndefinedConverterUnits.MetricAndUSCustomary.undefinedA.reciprocal()) metricAndUSCustomaryDividedByMetricAndUSCustomary
				2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedB x UndefinedConverterUnits.MetricAndUSCustomary.undefinedA).reciprocal())
		)
	}
}
