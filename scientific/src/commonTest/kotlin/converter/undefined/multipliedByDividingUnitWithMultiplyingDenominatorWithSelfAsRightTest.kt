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

// A * Div<B, Mul<C, A>> -> Div<B, C>
class MultipliedByDividingUnitWithMultiplyingDenominatorWithSelfAsRightTest {

	@Test
	fun multipliedByDividingUnitWithMultiplyingDenominatorWithSelfAsRight() {
		assertEquals(
			4((UndefinedConverterUnits.MetricAndImperial.undefinedB per UndefinedConverterUnits.MetricAndImperial.undefinedC)),
			2(UndefinedConverterUnits.MetricAndImperial.undefinedA) metricAndImperialMultipliedByMetricAndImperial
				2((UndefinedConverterUnits.MetricAndImperial.undefinedB per (UndefinedConverterUnits.MetricAndImperial.undefinedC x UndefinedConverterUnits.MetricAndImperial.undefinedA)))
		)
		assertEquals(
			4((UndefinedConverterUnits.Metric.undefinedB per UndefinedConverterUnits.Metric.undefinedC)),
			2(UndefinedConverterUnits.Metric.undefinedA) metricMultipliedByMetric
				2((UndefinedConverterUnits.Metric.undefinedB per (UndefinedConverterUnits.Metric.undefinedC x UndefinedConverterUnits.Metric.undefinedA)))
		)
		assertEquals(
			4((UndefinedConverterUnits.Imperial.undefinedB per UndefinedConverterUnits.Imperial.undefinedC)),
			2(UndefinedConverterUnits.Imperial.undefinedA) imperialMultipliedByImperial
				2((UndefinedConverterUnits.Imperial.undefinedB per (UndefinedConverterUnits.Imperial.undefinedC x UndefinedConverterUnits.Imperial.undefinedA)))
		)
		assertEquals(
			4((UndefinedConverterUnits.UKImperial.undefinedB per UndefinedConverterUnits.UKImperial.undefinedC)),
			2(UndefinedConverterUnits.UKImperial.undefinedA) ukImperialMultipliedByUKImperial
				2((UndefinedConverterUnits.UKImperial.undefinedB per (UndefinedConverterUnits.UKImperial.undefinedC x UndefinedConverterUnits.UKImperial.undefinedA)))
		)
		assertEquals(
			4((UndefinedConverterUnits.USCustomary.undefinedB per UndefinedConverterUnits.USCustomary.undefinedC)),
			2(UndefinedConverterUnits.USCustomary.undefinedA) usCustomaryMultipliedByUSCustomary
				2((UndefinedConverterUnits.USCustomary.undefinedB per (UndefinedConverterUnits.USCustomary.undefinedC x UndefinedConverterUnits.USCustomary.undefinedA)))
		)
		assertEquals(
			4((UndefinedConverterUnits.MetricAndUKImperial.undefinedB per UndefinedConverterUnits.MetricAndUKImperial.undefinedC)),
			2(UndefinedConverterUnits.MetricAndUKImperial.undefinedA) metricAndUKImperialMultipliedByMetricAndUKImperial
				2((UndefinedConverterUnits.MetricAndUKImperial.undefinedB per (UndefinedConverterUnits.MetricAndUKImperial.undefinedC x UndefinedConverterUnits.MetricAndUKImperial.undefinedA)))
		)
		assertEquals(
			4((UndefinedConverterUnits.MetricAndUSCustomary.undefinedB per UndefinedConverterUnits.MetricAndUSCustomary.undefinedC)),
			2(UndefinedConverterUnits.MetricAndUSCustomary.undefinedA) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
				2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedB per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedC x UndefinedConverterUnits.MetricAndUSCustomary.undefinedA)))
		)
	}
}
