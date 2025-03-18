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
import kotlin.test.Test
import kotlin.test.assertEquals

// Div<A, B> / Div<C, B> -> Div<A, C>
class DividingDividedByDividingUnitWithDenominatorAsDenominatorTest {

	@Test
	fun dividedByDividingUnitWithDenominatorAsDenominator() {
		assertEquals(
			1((UndefinedConverterUnits.MetricAndImperial.undefinedA per UndefinedConverterUnits.MetricAndImperial.undefinedC)),
			2((UndefinedConverterUnits.MetricAndImperial.undefinedA per UndefinedConverterUnits.MetricAndImperial.undefinedB)) metricAndImperialDividedByMetricAndImperial
				2((UndefinedConverterUnits.MetricAndImperial.undefinedC per UndefinedConverterUnits.MetricAndImperial.undefinedB))
		)
		assertEquals(
			1((UndefinedConverterUnits.Metric.undefinedA per UndefinedConverterUnits.Metric.undefinedC)),
			2((UndefinedConverterUnits.Metric.undefinedA per UndefinedConverterUnits.Metric.undefinedB)) metricDividedByMetric
				2((UndefinedConverterUnits.Metric.undefinedC per UndefinedConverterUnits.Metric.undefinedB))
		)
		assertEquals(
			1((UndefinedConverterUnits.Imperial.undefinedA per UndefinedConverterUnits.Imperial.undefinedC)),
			2((UndefinedConverterUnits.Imperial.undefinedA per UndefinedConverterUnits.Imperial.undefinedB)) imperialDividedByImperial
				2((UndefinedConverterUnits.Imperial.undefinedC per UndefinedConverterUnits.Imperial.undefinedB))
		)
		assertEquals(
			1((UndefinedConverterUnits.UKImperial.undefinedA per UndefinedConverterUnits.UKImperial.undefinedC)),
			2((UndefinedConverterUnits.UKImperial.undefinedA per UndefinedConverterUnits.UKImperial.undefinedB)) ukImperialDividedByUKImperial
				2((UndefinedConverterUnits.UKImperial.undefinedC per UndefinedConverterUnits.UKImperial.undefinedB))
		)
		assertEquals(
			1((UndefinedConverterUnits.USCustomary.undefinedA per UndefinedConverterUnits.USCustomary.undefinedC)),
			2((UndefinedConverterUnits.USCustomary.undefinedA per UndefinedConverterUnits.USCustomary.undefinedB)) usCustomaryDividedByUSCustomary
				2((UndefinedConverterUnits.USCustomary.undefinedC per UndefinedConverterUnits.USCustomary.undefinedB))
		)
		assertEquals(
			1((UndefinedConverterUnits.MetricAndUKImperial.undefinedA per UndefinedConverterUnits.MetricAndUKImperial.undefinedC)),
			2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA per UndefinedConverterUnits.MetricAndUKImperial.undefinedB)) metricAndUKImperialDividedByMetricAndUKImperial
				2((UndefinedConverterUnits.MetricAndUKImperial.undefinedC per UndefinedConverterUnits.MetricAndUKImperial.undefinedB))
		)
		assertEquals(
			1((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA per UndefinedConverterUnits.MetricAndUSCustomary.undefinedC)),
			2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA per UndefinedConverterUnits.MetricAndUSCustomary.undefinedB)) metricAndUSCustomaryDividedByMetricAndUSCustomary
				2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedC per UndefinedConverterUnits.MetricAndUSCustomary.undefinedB))
		)
	}
}
