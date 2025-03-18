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

// Div<Mul<A, B>, Mul<C, D>> * Div<Mul<E, C>, Mul<F, B>> -> Div<Mul<A, E>, Mul<D, F>>
class DividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorRightAsRightTest {

	@Test
	fun multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorRightAsRight() {
		assertEquals(
			4(((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedE) per (UndefinedConverterUnits.MetricAndImperial.undefinedD x UndefinedConverterUnits.MetricAndImperial.undefinedF))),
			2(((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedB) per (UndefinedConverterUnits.MetricAndImperial.undefinedC x UndefinedConverterUnits.MetricAndImperial.undefinedD))) metricAndImperialMultipliedByMetricAndImperial
				2(((UndefinedConverterUnits.MetricAndImperial.undefinedE x UndefinedConverterUnits.MetricAndImperial.undefinedC) per (UndefinedConverterUnits.MetricAndImperial.undefinedF x UndefinedConverterUnits.MetricAndImperial.undefinedB)))
		)
		assertEquals(
			4(((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedE) per (UndefinedConverterUnits.Metric.undefinedD x UndefinedConverterUnits.Metric.undefinedF))),
			2(((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedB) per (UndefinedConverterUnits.Metric.undefinedC x UndefinedConverterUnits.Metric.undefinedD))) metricMultipliedByMetric
				2(((UndefinedConverterUnits.Metric.undefinedE x UndefinedConverterUnits.Metric.undefinedC) per (UndefinedConverterUnits.Metric.undefinedF x UndefinedConverterUnits.Metric.undefinedB)))
		)
		assertEquals(
			4(((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedE) per (UndefinedConverterUnits.Imperial.undefinedD x UndefinedConverterUnits.Imperial.undefinedF))),
			2(((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedB) per (UndefinedConverterUnits.Imperial.undefinedC x UndefinedConverterUnits.Imperial.undefinedD))) imperialMultipliedByImperial
				2(((UndefinedConverterUnits.Imperial.undefinedE x UndefinedConverterUnits.Imperial.undefinedC) per (UndefinedConverterUnits.Imperial.undefinedF x UndefinedConverterUnits.Imperial.undefinedB)))
		)
		assertEquals(
			4(((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedE) per (UndefinedConverterUnits.UKImperial.undefinedD x UndefinedConverterUnits.UKImperial.undefinedF))),
			2(((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedB) per (UndefinedConverterUnits.UKImperial.undefinedC x UndefinedConverterUnits.UKImperial.undefinedD))) ukImperialMultipliedByUKImperial
				2(((UndefinedConverterUnits.UKImperial.undefinedE x UndefinedConverterUnits.UKImperial.undefinedC) per (UndefinedConverterUnits.UKImperial.undefinedF x UndefinedConverterUnits.UKImperial.undefinedB)))
		)
		assertEquals(
			4(((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedE) per (UndefinedConverterUnits.USCustomary.undefinedD x UndefinedConverterUnits.USCustomary.undefinedF))),
			2(((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedB) per (UndefinedConverterUnits.USCustomary.undefinedC x UndefinedConverterUnits.USCustomary.undefinedD))) usCustomaryMultipliedByUSCustomary
				2(((UndefinedConverterUnits.USCustomary.undefinedE x UndefinedConverterUnits.USCustomary.undefinedC) per (UndefinedConverterUnits.USCustomary.undefinedF x UndefinedConverterUnits.USCustomary.undefinedB)))
		)
		assertEquals(
			4(((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedE) per (UndefinedConverterUnits.MetricAndUKImperial.undefinedD x UndefinedConverterUnits.MetricAndUKImperial.undefinedF))),
			2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedB) per (UndefinedConverterUnits.MetricAndUKImperial.undefinedC x UndefinedConverterUnits.MetricAndUKImperial.undefinedD))) metricAndUKImperialMultipliedByMetricAndUKImperial
				2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedE x UndefinedConverterUnits.MetricAndUKImperial.undefinedC) per (UndefinedConverterUnits.MetricAndUKImperial.undefinedF x UndefinedConverterUnits.MetricAndUKImperial.undefinedB)))
		)
		assertEquals(
			4(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedE) per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedD x UndefinedConverterUnits.MetricAndUSCustomary.undefinedF))),
			2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB) per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedC x UndefinedConverterUnits.MetricAndUSCustomary.undefinedD))) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
				2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedE x UndefinedConverterUnits.MetricAndUSCustomary.undefinedC) per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedF x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB)))
		)
	}
}
