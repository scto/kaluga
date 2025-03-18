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
import com.splendo.kaluga.scientific.unit.One
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.test.Test
import kotlin.test.assertEquals

// One / A -> Inv<A>
class DimensionlessDividedByUndefinedUnitTest {

	@Test
	fun dividedByUndefinedUnit() {
		assertEquals(
			1(UndefinedConverterUnits.MetricAndImperial.undefinedA.reciprocal()),
			2(One) metricAndImperialDividedByMetricAndImperial
				2(UndefinedConverterUnits.MetricAndImperial.undefinedA)
		)
		assertEquals(
			1(UndefinedConverterUnits.Metric.undefinedA.reciprocal()),
			2(One) metricDividedByMetric
				2(UndefinedConverterUnits.Metric.undefinedA)
		)
		assertEquals(
			1(UndefinedConverterUnits.Imperial.undefinedA.reciprocal()),
			2(One) imperialDividedByImperial
				2(UndefinedConverterUnits.Imperial.undefinedA)
		)
		assertEquals(
			1(UndefinedConverterUnits.UKImperial.undefinedA.reciprocal()),
			2(One) ukImperialDividedByUKImperial
				2(UndefinedConverterUnits.UKImperial.undefinedA)
		)
		assertEquals(
			1(UndefinedConverterUnits.USCustomary.undefinedA.reciprocal()),
			2(One) usCustomaryDividedByUSCustomary
				2(UndefinedConverterUnits.USCustomary.undefinedA)
		)
		assertEquals(
			1(UndefinedConverterUnits.MetricAndUKImperial.undefinedA.reciprocal()),
			2(One) metricAndUKImperialDividedByMetricAndUKImperial
				2(UndefinedConverterUnits.MetricAndUKImperial.undefinedA)
		)
		assertEquals(
			1(UndefinedConverterUnits.MetricAndUSCustomary.undefinedA.reciprocal()),
			2(One) metricAndUSCustomaryDividedByMetricAndUSCustomary
				2(UndefinedConverterUnits.MetricAndUSCustomary.undefinedA)
		)
	}
}
