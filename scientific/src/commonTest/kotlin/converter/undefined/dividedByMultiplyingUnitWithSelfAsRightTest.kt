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

// A / Mul<B, A> -> Inv<B>
class DividedByMultiplyingUnitWithSelfAsRightTest {

	@Test
	fun dividedByMultiplyingUnitWithSelfAsRight() {
		assertEquals(
			4(UndefinedConverterUnits.MetricAndImperial.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.MetricAndImperial.undefinedA) metricAndImperialDividedByMetricAndImperial
				2((UndefinedConverterUnits.MetricAndImperial.undefinedB x UndefinedConverterUnits.MetricAndImperial.undefinedA))
		)
		assertEquals(
			4(UndefinedConverterUnits.Metric.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.Metric.undefinedA) metricDividedByMetric
				2((UndefinedConverterUnits.Metric.undefinedB x UndefinedConverterUnits.Metric.undefinedA))
		)
		assertEquals(
			4(UndefinedConverterUnits.Imperial.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.Imperial.undefinedA) imperialDividedByImperial
				2((UndefinedConverterUnits.Imperial.undefinedB x UndefinedConverterUnits.Imperial.undefinedA))
		)
		assertEquals(
			4(UndefinedConverterUnits.UKImperial.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.UKImperial.undefinedA) ukImperialDividedByUKImperial
				2((UndefinedConverterUnits.UKImperial.undefinedB x UndefinedConverterUnits.UKImperial.undefinedA))
		)
		assertEquals(
			4(UndefinedConverterUnits.USCustomary.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.USCustomary.undefinedA) usCustomaryDividedByUSCustomary
				2((UndefinedConverterUnits.USCustomary.undefinedB x UndefinedConverterUnits.USCustomary.undefinedA))
		)
		assertEquals(
			4(UndefinedConverterUnits.MetricAndUKImperial.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.MetricAndUKImperial.undefinedA) metricAndUKImperialDividedByMetricAndUKImperial
				2((UndefinedConverterUnits.MetricAndUKImperial.undefinedB x UndefinedConverterUnits.MetricAndUKImperial.undefinedA))
		)
		assertEquals(
			4(UndefinedConverterUnits.MetricAndUSCustomary.undefinedB.reciprocal()),
			2(UndefinedConverterUnits.MetricAndUSCustomary.undefinedA) metricAndUSCustomaryDividedByMetricAndUSCustomary
				2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedB x UndefinedConverterUnits.MetricAndUSCustomary.undefinedA))
		)
	}
}
