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

// Div<Mul<A, B>, Mul<C, D>> * Div<Mul<D, E>, Mul<B, A>> -> Div<E, C>
class DividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRightTest {

	@Test
	fun multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight() {
		assertEquals(
			4((UndefinedConverterUnits.MetricAndImperial.undefinedE per UndefinedConverterUnits.MetricAndImperial.undefinedC)),
			2(((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedB) per (UndefinedConverterUnits.MetricAndImperial.undefinedC x UndefinedConverterUnits.MetricAndImperial.undefinedD))) metricAndImperialMultipliedByMetricAndImperial
				2(((UndefinedConverterUnits.MetricAndImperial.undefinedD x UndefinedConverterUnits.MetricAndImperial.undefinedE) per (UndefinedConverterUnits.MetricAndImperial.undefinedB x UndefinedConverterUnits.MetricAndImperial.undefinedA)))
		)
		assertEquals(
			4((UndefinedConverterUnits.Metric.undefinedE per UndefinedConverterUnits.Metric.undefinedC)),
			2(((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedB) per (UndefinedConverterUnits.Metric.undefinedC x UndefinedConverterUnits.Metric.undefinedD))) metricMultipliedByMetric
				2(((UndefinedConverterUnits.Metric.undefinedD x UndefinedConverterUnits.Metric.undefinedE) per (UndefinedConverterUnits.Metric.undefinedB x UndefinedConverterUnits.Metric.undefinedA)))
		)
		assertEquals(
			4((UndefinedConverterUnits.Imperial.undefinedE per UndefinedConverterUnits.Imperial.undefinedC)),
			2(((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedB) per (UndefinedConverterUnits.Imperial.undefinedC x UndefinedConverterUnits.Imperial.undefinedD))) imperialMultipliedByImperial
				2(((UndefinedConverterUnits.Imperial.undefinedD x UndefinedConverterUnits.Imperial.undefinedE) per (UndefinedConverterUnits.Imperial.undefinedB x UndefinedConverterUnits.Imperial.undefinedA)))
		)
		assertEquals(
			4((UndefinedConverterUnits.UKImperial.undefinedE per UndefinedConverterUnits.UKImperial.undefinedC)),
			2(((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedB) per (UndefinedConverterUnits.UKImperial.undefinedC x UndefinedConverterUnits.UKImperial.undefinedD))) ukImperialMultipliedByUKImperial
				2(((UndefinedConverterUnits.UKImperial.undefinedD x UndefinedConverterUnits.UKImperial.undefinedE) per (UndefinedConverterUnits.UKImperial.undefinedB x UndefinedConverterUnits.UKImperial.undefinedA)))
		)
		assertEquals(
			4((UndefinedConverterUnits.USCustomary.undefinedE per UndefinedConverterUnits.USCustomary.undefinedC)),
			2(((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedB) per (UndefinedConverterUnits.USCustomary.undefinedC x UndefinedConverterUnits.USCustomary.undefinedD))) usCustomaryMultipliedByUSCustomary
				2(((UndefinedConverterUnits.USCustomary.undefinedD x UndefinedConverterUnits.USCustomary.undefinedE) per (UndefinedConverterUnits.USCustomary.undefinedB x UndefinedConverterUnits.USCustomary.undefinedA)))
		)
		assertEquals(
			4((UndefinedConverterUnits.MetricAndUKImperial.undefinedE per UndefinedConverterUnits.MetricAndUKImperial.undefinedC)),
			2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedB) per (UndefinedConverterUnits.MetricAndUKImperial.undefinedC x UndefinedConverterUnits.MetricAndUKImperial.undefinedD))) metricAndUKImperialMultipliedByMetricAndUKImperial
				2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedD x UndefinedConverterUnits.MetricAndUKImperial.undefinedE) per (UndefinedConverterUnits.MetricAndUKImperial.undefinedB x UndefinedConverterUnits.MetricAndUKImperial.undefinedA)))
		)
		assertEquals(
			4((UndefinedConverterUnits.MetricAndUSCustomary.undefinedE per UndefinedConverterUnits.MetricAndUSCustomary.undefinedC)),
			2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB) per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedC x UndefinedConverterUnits.MetricAndUSCustomary.undefinedD))) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
				2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedD x UndefinedConverterUnits.MetricAndUSCustomary.undefinedE) per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedB x UndefinedConverterUnits.MetricAndUSCustomary.undefinedA)))
		)
	}
}
