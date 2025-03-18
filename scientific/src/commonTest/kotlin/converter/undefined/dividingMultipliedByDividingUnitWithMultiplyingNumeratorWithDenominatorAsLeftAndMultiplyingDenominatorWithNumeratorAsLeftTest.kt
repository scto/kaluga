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

// Div<A, B> * Div<Mul<B, C>, Mul<A, D>> -> Div<C, D>
class DividingMultipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorAsLeftAndMultiplyingDenominatorWithNumeratorAsLeftTest {

	@Test
	fun multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorAsLeftAndMultiplyingDenominatorWithNumeratorAsLeft() {
		assertEquals(
			4((UndefinedConverterUnits.MetricAndImperial.undefinedC per UndefinedConverterUnits.MetricAndImperial.undefinedD)),
			2((UndefinedConverterUnits.MetricAndImperial.undefinedA per UndefinedConverterUnits.MetricAndImperial.undefinedB)) metricAndImperialMultipliedByMetricAndImperial
				2(((UndefinedConverterUnits.MetricAndImperial.undefinedB x UndefinedConverterUnits.MetricAndImperial.undefinedC) per (UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedD)))
		)
		assertEquals(
			4((UndefinedConverterUnits.Metric.undefinedC per UndefinedConverterUnits.Metric.undefinedD)),
			2((UndefinedConverterUnits.Metric.undefinedA per UndefinedConverterUnits.Metric.undefinedB)) metricMultipliedByMetric
				2(((UndefinedConverterUnits.Metric.undefinedB x UndefinedConverterUnits.Metric.undefinedC) per (UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedD)))
		)
		assertEquals(
			4((UndefinedConverterUnits.Imperial.undefinedC per UndefinedConverterUnits.Imperial.undefinedD)),
			2((UndefinedConverterUnits.Imperial.undefinedA per UndefinedConverterUnits.Imperial.undefinedB)) imperialMultipliedByImperial
				2(((UndefinedConverterUnits.Imperial.undefinedB x UndefinedConverterUnits.Imperial.undefinedC) per (UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedD)))
		)
		assertEquals(
			4((UndefinedConverterUnits.UKImperial.undefinedC per UndefinedConverterUnits.UKImperial.undefinedD)),
			2((UndefinedConverterUnits.UKImperial.undefinedA per UndefinedConverterUnits.UKImperial.undefinedB)) ukImperialMultipliedByUKImperial
				2(((UndefinedConverterUnits.UKImperial.undefinedB x UndefinedConverterUnits.UKImperial.undefinedC) per (UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedD)))
		)
		assertEquals(
			4((UndefinedConverterUnits.USCustomary.undefinedC per UndefinedConverterUnits.USCustomary.undefinedD)),
			2((UndefinedConverterUnits.USCustomary.undefinedA per UndefinedConverterUnits.USCustomary.undefinedB)) usCustomaryMultipliedByUSCustomary
				2(((UndefinedConverterUnits.USCustomary.undefinedB x UndefinedConverterUnits.USCustomary.undefinedC) per (UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedD)))
		)
		assertEquals(
			4((UndefinedConverterUnits.MetricAndUKImperial.undefinedC per UndefinedConverterUnits.MetricAndUKImperial.undefinedD)),
			2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA per UndefinedConverterUnits.MetricAndUKImperial.undefinedB)) metricAndUKImperialMultipliedByMetricAndUKImperial
				2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedB x UndefinedConverterUnits.MetricAndUKImperial.undefinedC) per (UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedD)))
		)
		assertEquals(
			4((UndefinedConverterUnits.MetricAndUSCustomary.undefinedC per UndefinedConverterUnits.MetricAndUSCustomary.undefinedD)),
			2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA per UndefinedConverterUnits.MetricAndUSCustomary.undefinedB)) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
				2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedB x UndefinedConverterUnits.MetricAndUSCustomary.undefinedC) per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedD)))
		)
	}
}
