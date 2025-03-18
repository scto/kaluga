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

// Div<A, B> / Mul<A, C> -> Inv<Mul<B, C>>
class DividingDividedByMultiplyingUnitWithNumeratorAsLeftTest {

	@Test
	fun dividedByMultiplyingUnitWithNumeratorAsLeft() {
		assertEquals(
			1((UndefinedConverterUnits.MetricAndImperial.undefinedB x UndefinedConverterUnits.MetricAndImperial.undefinedC).reciprocal()),
			2((UndefinedConverterUnits.MetricAndImperial.undefinedA per UndefinedConverterUnits.MetricAndImperial.undefinedB)) metricAndImperialDividedByMetricAndImperial
				2((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedC))
		)
		assertEquals(
			1((UndefinedConverterUnits.Metric.undefinedB x UndefinedConverterUnits.Metric.undefinedC).reciprocal()),
			2((UndefinedConverterUnits.Metric.undefinedA per UndefinedConverterUnits.Metric.undefinedB)) metricDividedByMetric
				2((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedC))
		)
		assertEquals(
			1((UndefinedConverterUnits.Imperial.undefinedB x UndefinedConverterUnits.Imperial.undefinedC).reciprocal()),
			2((UndefinedConverterUnits.Imperial.undefinedA per UndefinedConverterUnits.Imperial.undefinedB)) imperialDividedByImperial
				2((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedC))
		)
		assertEquals(
			1((UndefinedConverterUnits.UKImperial.undefinedB x UndefinedConverterUnits.UKImperial.undefinedC).reciprocal()),
			2((UndefinedConverterUnits.UKImperial.undefinedA per UndefinedConverterUnits.UKImperial.undefinedB)) ukImperialDividedByUKImperial
				2((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedC))
		)
		assertEquals(
			1((UndefinedConverterUnits.USCustomary.undefinedB x UndefinedConverterUnits.USCustomary.undefinedC).reciprocal()),
			2((UndefinedConverterUnits.USCustomary.undefinedA per UndefinedConverterUnits.USCustomary.undefinedB)) usCustomaryDividedByUSCustomary
				2((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedC))
		)
		assertEquals(
			1((UndefinedConverterUnits.MetricAndUKImperial.undefinedB x UndefinedConverterUnits.MetricAndUKImperial.undefinedC).reciprocal()),
			2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA per UndefinedConverterUnits.MetricAndUKImperial.undefinedB)) metricAndUKImperialDividedByMetricAndUKImperial
				2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedC))
		)
		assertEquals(
			1((UndefinedConverterUnits.MetricAndUSCustomary.undefinedB x UndefinedConverterUnits.MetricAndUSCustomary.undefinedC).reciprocal()),
			2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA per UndefinedConverterUnits.MetricAndUSCustomary.undefinedB)) metricAndUSCustomaryDividedByMetricAndUSCustomary
				2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedC))
		)
	}
}
