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

// A / Inv<B> -> Mul<A, B>
class DividedByReciprocalUndefinedUnitTest {

	@Test
	fun dividedByReciprocalUndefinedUnit() {
		assertEquals(
			1((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedB)),
			2(UndefinedConverterUnits.MetricAndImperial.undefinedA) metricAndImperialDividedByMetricAndImperial
				2(UndefinedConverterUnits.MetricAndImperial.undefinedB.reciprocal())
		)
		assertEquals(
			1((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedB)),
			2(UndefinedConverterUnits.Metric.undefinedA) metricDividedByMetric
				2(UndefinedConverterUnits.Metric.undefinedB.reciprocal())
		)
		assertEquals(
			1((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedB)),
			2(UndefinedConverterUnits.Imperial.undefinedA) imperialDividedByImperial
				2(UndefinedConverterUnits.Imperial.undefinedB.reciprocal())
		)
		assertEquals(
			1((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedB)),
			2(UndefinedConverterUnits.UKImperial.undefinedA) ukImperialDividedByUKImperial
				2(UndefinedConverterUnits.UKImperial.undefinedB.reciprocal())
		)
		assertEquals(
			1((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedB)),
			2(UndefinedConverterUnits.USCustomary.undefinedA) usCustomaryDividedByUSCustomary
				2(UndefinedConverterUnits.USCustomary.undefinedB.reciprocal())
		)
		assertEquals(
			1((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedB)),
			2(UndefinedConverterUnits.MetricAndUKImperial.undefinedA) metricAndUKImperialDividedByMetricAndUKImperial
				2(UndefinedConverterUnits.MetricAndUKImperial.undefinedB.reciprocal())
		)
		assertEquals(
			1((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB)),
			2(UndefinedConverterUnits.MetricAndUSCustomary.undefinedA) metricAndUSCustomaryDividedByMetricAndUSCustomary
				2(UndefinedConverterUnits.MetricAndUSCustomary.undefinedB.reciprocal())
		)
	}
}
