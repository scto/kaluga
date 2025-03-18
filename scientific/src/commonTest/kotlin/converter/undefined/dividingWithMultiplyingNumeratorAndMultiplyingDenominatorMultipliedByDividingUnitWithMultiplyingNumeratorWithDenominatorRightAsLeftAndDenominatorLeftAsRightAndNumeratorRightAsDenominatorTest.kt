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

// Div<Mul<D, C>, Mul<B, A>> * Div<Mul<A, B>, C> -> D
class DividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndNumeratorRightAsDenominatorTest {

	@Test
	fun multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndNumeratorRightAsDenominator() {
		assertEquals(
			4(UndefinedConverterUnits.MetricAndImperial.undefinedD),
			2(((UndefinedConverterUnits.MetricAndImperial.undefinedD x UndefinedConverterUnits.MetricAndImperial.undefinedC) per (UndefinedConverterUnits.MetricAndImperial.undefinedB x UndefinedConverterUnits.MetricAndImperial.undefinedA))) metricAndImperialMultipliedByMetricAndImperial
				2(((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedB) per UndefinedConverterUnits.MetricAndImperial.undefinedC))
		)
		assertEquals(
			4(UndefinedConverterUnits.Metric.undefinedD),
			2(((UndefinedConverterUnits.Metric.undefinedD x UndefinedConverterUnits.Metric.undefinedC) per (UndefinedConverterUnits.Metric.undefinedB x UndefinedConverterUnits.Metric.undefinedA))) metricMultipliedByMetric
				2(((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedB) per UndefinedConverterUnits.Metric.undefinedC))
		)
		assertEquals(
			4(UndefinedConverterUnits.Imperial.undefinedD),
			2(((UndefinedConverterUnits.Imperial.undefinedD x UndefinedConverterUnits.Imperial.undefinedC) per (UndefinedConverterUnits.Imperial.undefinedB x UndefinedConverterUnits.Imperial.undefinedA))) imperialMultipliedByImperial
				2(((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedB) per UndefinedConverterUnits.Imperial.undefinedC))
		)
		assertEquals(
			4(UndefinedConverterUnits.UKImperial.undefinedD),
			2(((UndefinedConverterUnits.UKImperial.undefinedD x UndefinedConverterUnits.UKImperial.undefinedC) per (UndefinedConverterUnits.UKImperial.undefinedB x UndefinedConverterUnits.UKImperial.undefinedA))) ukImperialMultipliedByUKImperial
				2(((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedB) per UndefinedConverterUnits.UKImperial.undefinedC))
		)
		assertEquals(
			4(UndefinedConverterUnits.USCustomary.undefinedD),
			2(((UndefinedConverterUnits.USCustomary.undefinedD x UndefinedConverterUnits.USCustomary.undefinedC) per (UndefinedConverterUnits.USCustomary.undefinedB x UndefinedConverterUnits.USCustomary.undefinedA))) usCustomaryMultipliedByUSCustomary
				2(((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedB) per UndefinedConverterUnits.USCustomary.undefinedC))
		)
		assertEquals(
			4(UndefinedConverterUnits.MetricAndUKImperial.undefinedD),
			2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedD x UndefinedConverterUnits.MetricAndUKImperial.undefinedC) per (UndefinedConverterUnits.MetricAndUKImperial.undefinedB x UndefinedConverterUnits.MetricAndUKImperial.undefinedA))) metricAndUKImperialMultipliedByMetricAndUKImperial
				2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedB) per UndefinedConverterUnits.MetricAndUKImperial.undefinedC))
		)
		assertEquals(
			4(UndefinedConverterUnits.MetricAndUSCustomary.undefinedD),
			2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedD x UndefinedConverterUnits.MetricAndUSCustomary.undefinedC) per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedB x UndefinedConverterUnits.MetricAndUSCustomary.undefinedA))) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
				2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB) per UndefinedConverterUnits.MetricAndUSCustomary.undefinedC))
		)
	}
}
