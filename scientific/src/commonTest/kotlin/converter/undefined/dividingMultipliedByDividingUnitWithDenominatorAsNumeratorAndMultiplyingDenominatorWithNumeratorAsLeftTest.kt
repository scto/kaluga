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

// Div<A, B> * Div<B, Mul<A, D>> -> Inv<D>

class DividingMultipliedByDividingUnitWithDenominatorAsNumeratorAndMultiplyingDenominatorWithNumeratorAsLeftTest {

	@Test
	fun multipliedByDividingUnitWithDenominatorAsNumeratorAndMultiplyingDenominatorWithNumeratorAsLeft() {
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.MetricAndImperial.undefinedD.reciprocal()),
		// 	2((UndefinedConverterUnits.MetricAndImperial.undefinedA per UndefinedConverterUnits.MetricAndImperial.undefinedB)) metricAndImperialMultipliedByMetricAndImperial
		// 		2((UndefinedConverterUnits.MetricAndImperial.undefinedB per (UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedD)))
		// )
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.Metric.undefinedD.reciprocal()),
		// 	2((UndefinedConverterUnits.Metric.undefinedA per UndefinedConverterUnits.Metric.undefinedB)) metricMultipliedByMetric
		// 		2((UndefinedConverterUnits.Metric.undefinedB per (UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedD)))
		// )
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.Imperial.undefinedD.reciprocal()),
		// 	2((UndefinedConverterUnits.Imperial.undefinedA per UndefinedConverterUnits.Imperial.undefinedB)) imperialMultipliedByImperial
		// 		2((UndefinedConverterUnits.Imperial.undefinedB per (UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedD)))
		// )
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.UKImperial.undefinedD.reciprocal()),
		// 	2((UndefinedConverterUnits.UKImperial.undefinedA per UndefinedConverterUnits.UKImperial.undefinedB)) ukImperialMultipliedByUKImperial
		// 		2((UndefinedConverterUnits.UKImperial.undefinedB per (UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedD)))
		// )
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.USCustomary.undefinedD.reciprocal()),
		// 	2((UndefinedConverterUnits.USCustomary.undefinedA per UndefinedConverterUnits.USCustomary.undefinedB)) usCustomaryMultipliedByUSCustomary
		// 		2((UndefinedConverterUnits.USCustomary.undefinedB per (UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedD)))
		// )
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.MetricAndUKImperial.undefinedD.reciprocal()),
		// 	2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA per UndefinedConverterUnits.MetricAndUKImperial.undefinedB)) metricAndUKImperialMultipliedByMetricAndUKImperial
		// 		2((UndefinedConverterUnits.MetricAndUKImperial.undefinedB per (UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedD)))
		// )
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.MetricAndUSCustomary.undefinedD.reciprocal()),
		// 	2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA per UndefinedConverterUnits.MetricAndUSCustomary.undefinedB)) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
		// 		2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedB per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedD)))
		// )
	}
}
