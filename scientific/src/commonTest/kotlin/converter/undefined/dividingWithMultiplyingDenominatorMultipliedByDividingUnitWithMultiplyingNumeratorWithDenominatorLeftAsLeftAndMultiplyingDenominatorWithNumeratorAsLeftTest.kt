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

// Div<A, Mul<B, C>> * Div<Mul<B, D>, Mul<A, E>> -> Div<D, Mul<C, E>>
class DividingWithMultiplyingDenominatorMultipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorLeftAsLeftAndMultiplyingDenominatorWithNumeratorAsLeftTest {

	@Test
	fun multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorLeftAsLeftAndMultiplyingDenominatorWithNumeratorAsLeft() {
		assertEquals(
			4((UndefinedConverterUnits.MetricAndImperial.undefinedD per (UndefinedConverterUnits.MetricAndImperial.undefinedC x UndefinedConverterUnits.MetricAndImperial.undefinedE))),
			2((UndefinedConverterUnits.MetricAndImperial.undefinedA per (UndefinedConverterUnits.MetricAndImperial.undefinedB x UndefinedConverterUnits.MetricAndImperial.undefinedC))) metricAndImperialMultipliedByMetricAndImperial
				2(((UndefinedConverterUnits.MetricAndImperial.undefinedB x UndefinedConverterUnits.MetricAndImperial.undefinedD) per (UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedE)))
		)
		assertEquals(
			4((UndefinedConverterUnits.Metric.undefinedD per (UndefinedConverterUnits.Metric.undefinedC x UndefinedConverterUnits.Metric.undefinedE))),
			2((UndefinedConverterUnits.Metric.undefinedA per (UndefinedConverterUnits.Metric.undefinedB x UndefinedConverterUnits.Metric.undefinedC))) metricMultipliedByMetric
				2(((UndefinedConverterUnits.Metric.undefinedB x UndefinedConverterUnits.Metric.undefinedD) per (UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedE)))
		)
		assertEquals(
			4((UndefinedConverterUnits.Imperial.undefinedD per (UndefinedConverterUnits.Imperial.undefinedC x UndefinedConverterUnits.Imperial.undefinedE))),
			2((UndefinedConverterUnits.Imperial.undefinedA per (UndefinedConverterUnits.Imperial.undefinedB x UndefinedConverterUnits.Imperial.undefinedC))) imperialMultipliedByImperial
				2(((UndefinedConverterUnits.Imperial.undefinedB x UndefinedConverterUnits.Imperial.undefinedD) per (UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedE)))
		)
		assertEquals(
			4((UndefinedConverterUnits.UKImperial.undefinedD per (UndefinedConverterUnits.UKImperial.undefinedC x UndefinedConverterUnits.UKImperial.undefinedE))),
			2((UndefinedConverterUnits.UKImperial.undefinedA per (UndefinedConverterUnits.UKImperial.undefinedB x UndefinedConverterUnits.UKImperial.undefinedC))) ukImperialMultipliedByUKImperial
				2(((UndefinedConverterUnits.UKImperial.undefinedB x UndefinedConverterUnits.UKImperial.undefinedD) per (UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedE)))
		)
		assertEquals(
			4((UndefinedConverterUnits.USCustomary.undefinedD per (UndefinedConverterUnits.USCustomary.undefinedC x UndefinedConverterUnits.USCustomary.undefinedE))),
			2((UndefinedConverterUnits.USCustomary.undefinedA per (UndefinedConverterUnits.USCustomary.undefinedB x UndefinedConverterUnits.USCustomary.undefinedC))) usCustomaryMultipliedByUSCustomary
				2(((UndefinedConverterUnits.USCustomary.undefinedB x UndefinedConverterUnits.USCustomary.undefinedD) per (UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedE)))
		)
		assertEquals(
			4((UndefinedConverterUnits.MetricAndUKImperial.undefinedD per (UndefinedConverterUnits.MetricAndUKImperial.undefinedC x UndefinedConverterUnits.MetricAndUKImperial.undefinedE))),
			2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA per (UndefinedConverterUnits.MetricAndUKImperial.undefinedB x UndefinedConverterUnits.MetricAndUKImperial.undefinedC))) metricAndUKImperialMultipliedByMetricAndUKImperial
				2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedB x UndefinedConverterUnits.MetricAndUKImperial.undefinedD) per (UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedE)))
		)
		assertEquals(
			4((UndefinedConverterUnits.MetricAndUSCustomary.undefinedD per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedC x UndefinedConverterUnits.MetricAndUSCustomary.undefinedE))),
			2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedB x UndefinedConverterUnits.MetricAndUSCustomary.undefinedC))) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
				2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedB x UndefinedConverterUnits.MetricAndUSCustomary.undefinedD) per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedE)))
		)
	}
}
