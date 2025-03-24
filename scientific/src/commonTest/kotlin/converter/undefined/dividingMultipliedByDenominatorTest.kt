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

// Div<A, B> * B -> A

class DividingMultipliedByDenominatorTest {

	@Test
	fun multipliedByDenominator() {
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.MetricAndImperial.undefinedA),
		// 	2((UndefinedConverterUnits.MetricAndImperial.undefinedA per UndefinedConverterUnits.MetricAndImperial.undefinedB)) metricAndImperialMultipliedByMetricAndImperial
		// 		2(UndefinedConverterUnits.MetricAndImperial.undefinedB)
		// )
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.Metric.undefinedA),
		// 	2((UndefinedConverterUnits.Metric.undefinedA per UndefinedConverterUnits.Metric.undefinedB)) metricMultipliedByMetric
		// 		2(UndefinedConverterUnits.Metric.undefinedB)
		// )
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.Imperial.undefinedA),
		// 	2((UndefinedConverterUnits.Imperial.undefinedA per UndefinedConverterUnits.Imperial.undefinedB)) imperialMultipliedByImperial
		// 		2(UndefinedConverterUnits.Imperial.undefinedB)
		// )
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.UKImperial.undefinedA),
		// 	2((UndefinedConverterUnits.UKImperial.undefinedA per UndefinedConverterUnits.UKImperial.undefinedB)) ukImperialMultipliedByUKImperial
		// 		2(UndefinedConverterUnits.UKImperial.undefinedB)
		// )
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.USCustomary.undefinedA),
		// 	2((UndefinedConverterUnits.USCustomary.undefinedA per UndefinedConverterUnits.USCustomary.undefinedB)) usCustomaryMultipliedByUSCustomary
		// 		2(UndefinedConverterUnits.USCustomary.undefinedB)
		// )
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.MetricAndUKImperial.undefinedA),
		// 	2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA per UndefinedConverterUnits.MetricAndUKImperial.undefinedB)) metricAndUKImperialMultipliedByMetricAndUKImperial
		// 		2(UndefinedConverterUnits.MetricAndUKImperial.undefinedB)
		// )
		// assertEquals(
		// 	4.0(UndefinedConverterUnits.MetricAndUSCustomary.undefinedA),
		// 	2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA per UndefinedConverterUnits.MetricAndUSCustomary.undefinedB)) metricAndUSCustomaryMultipliedByMetricAndUSCustomary
		// 		2(UndefinedConverterUnits.MetricAndUSCustomary.undefinedB)
		// )
	}
}
