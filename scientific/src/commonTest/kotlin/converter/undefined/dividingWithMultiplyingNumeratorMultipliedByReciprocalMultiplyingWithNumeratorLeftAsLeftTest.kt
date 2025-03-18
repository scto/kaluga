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

// Div<Mul<A, B>, C> * Inv<Mul<A, D>> -> Div<B, Mul<C, D>>
class DividingWithMultiplyingNumeratorMultipliedByReciprocalMultiplyingWithNumeratorLeftAsLeftTest {

	@Test
	fun multipliedByReciprocalMultiplyingWithNumeratorLeftAsLeft() {
		assertEquals(
			1((UndefinedConverterUnits.MetricAndImperial.undefinedB per (UndefinedConverterUnits.MetricAndImperial.undefinedC x UndefinedConverterUnits.MetricAndImperial.undefinedD))),
			2(((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedB) per UndefinedConverterUnits.MetricAndImperial.undefinedC)) metricAndImperialMultipliedByMetricAndImperial
				2((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedD).reciprocal())
		)
		assertEquals(
			1((UndefinedConverterUnits.Metric.undefinedB per (UndefinedConverterUnits.Metric.undefinedC x UndefinedConverterUnits.Metric.undefinedD))),
			2(((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedB) per UndefinedConverterUnits.Metric.undefinedC)) metricMultipliedByMetric
				2((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedD).reciprocal())
		)
		assertEquals(
			1((UndefinedConverterUnits.Imperial.undefinedB per (UndefinedConverterUnits.Imperial.undefinedC x UndefinedConverterUnits.Imperial.undefinedD))),
			2(((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedB) per UndefinedConverterUnits.Imperial.undefinedC)) imperialMultipliedByImperial
				2((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedD).reciprocal())
		)
		assertEquals(
			1((UndefinedConverterUnits.UKImperial.undefinedB per (UndefinedConverterUnits.UKImperial.undefinedC x UndefinedConverterUnits.UKImperial.undefinedD))),
			2(((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedB) per UndefinedConverterUnits.UKImperial.undefinedC)) ukImperialMultipliedByUKImperial
				2((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedD).reciprocal())
		)
		assertEquals(
			1((UndefinedConverterUnits.USCustomary.undefinedB per (UndefinedConverterUnits.USCustomary.undefinedC x UndefinedConverterUnits.USCustomary.undefinedD))),
			2(((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedB) per UndefinedConverterUnits.USCustomary.undefinedC)) usCustomaryMultipliedByUSCustomary
				2((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedD).reciprocal())
		)
		assertEquals(
			1((UndefinedConverterUnits.MetricAndUKImperial.undefinedB per (UndefinedConverterUnits.MetricAndUKImperial.undefinedC x UndefinedConverterUnits.MetricAndUKImperial.undefinedD))),
			2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedB) per UndefinedConverterUnits.MetricAndUKImperial.undefinedC)) metricAndUKImperialMultipliedByMetricAndUKImperial
				2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedD).reciprocal())
		)
		assertEquals(
			1((UndefinedConverterUnits.MetricAndUSCustomary.undefinedB per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedC x UndefinedConverterUnits.MetricAndUSCustomary.undefinedD))),
			2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB) per UndefinedConverterUnits.MetricAndUSCustomary.undefinedC)) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
				2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedD).reciprocal())
		)
	}
}
