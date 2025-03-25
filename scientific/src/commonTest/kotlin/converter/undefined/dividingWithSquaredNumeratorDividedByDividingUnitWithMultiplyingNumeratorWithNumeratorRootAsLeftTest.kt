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

// Div<Mul<A, A>, B> / Div<Mul<A, C>, D> -> Div<Mul<A, D>, Mul<B, C>>

class DividingWithSquaredNumeratorDividedByDividingUnitWithMultiplyingNumeratorWithNumeratorRootAsLeftTest {

	@Test
	fun dividedByDividingUnitWithMultiplyingNumeratorWithNumeratorRootAsLeft() {
		// assertEquals(
		// 	1.0(((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedD) per (UndefinedConverterUnits.MetricAndImperial.undefinedB x UndefinedConverterUnits.MetricAndImperial.undefinedC))),
		// 	2(((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedA) per UndefinedConverterUnits.MetricAndImperial.undefinedB)) metricAndImperialDividedByMetricAndImperial
		// 		2(((UndefinedConverterUnits.MetricAndImperial.undefinedA x UndefinedConverterUnits.MetricAndImperial.undefinedC) per UndefinedConverterUnits.MetricAndImperial.undefinedD))
		// )
		// assertEquals(
		// 	1.0(((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedD) per (UndefinedConverterUnits.Metric.undefinedB x UndefinedConverterUnits.Metric.undefinedC))),
		// 	2(((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedA) per UndefinedConverterUnits.Metric.undefinedB)) metricDividedByMetric
		// 		2(((UndefinedConverterUnits.Metric.undefinedA x UndefinedConverterUnits.Metric.undefinedC) per UndefinedConverterUnits.Metric.undefinedD))
		// )
		// assertEquals(
		// 	1.0(((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedD) per (UndefinedConverterUnits.Imperial.undefinedB x UndefinedConverterUnits.Imperial.undefinedC))),
		// 	2(((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedA) per UndefinedConverterUnits.Imperial.undefinedB)) imperialDividedByImperial
		// 		2(((UndefinedConverterUnits.Imperial.undefinedA x UndefinedConverterUnits.Imperial.undefinedC) per UndefinedConverterUnits.Imperial.undefinedD))
		// )
		// assertEquals(
		// 	1.0(((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedD) per (UndefinedConverterUnits.UKImperial.undefinedB x UndefinedConverterUnits.UKImperial.undefinedC))),
		// 	2(((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedA) per UndefinedConverterUnits.UKImperial.undefinedB)) ukImperialDividedByUKImperial
		// 		2(((UndefinedConverterUnits.UKImperial.undefinedA x UndefinedConverterUnits.UKImperial.undefinedC) per UndefinedConverterUnits.UKImperial.undefinedD))
		// )
		// assertEquals(
		// 	1.0(((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedD) per (UndefinedConverterUnits.USCustomary.undefinedB x UndefinedConverterUnits.USCustomary.undefinedC))),
		// 	2(((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedA) per UndefinedConverterUnits.USCustomary.undefinedB)) usCustomaryDividedByUSCustomary
		// 		2(((UndefinedConverterUnits.USCustomary.undefinedA x UndefinedConverterUnits.USCustomary.undefinedC) per UndefinedConverterUnits.USCustomary.undefinedD))
		// )
		// assertEquals(
		// 	1.0(((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedD) per (UndefinedConverterUnits.MetricAndUKImperial.undefinedB x UndefinedConverterUnits.MetricAndUKImperial.undefinedC))),
		// 	2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedA) per UndefinedConverterUnits.MetricAndUKImperial.undefinedB)) metricAndUKImperialDividedByMetricAndUKImperial
		// 		2(((UndefinedConverterUnits.MetricAndUKImperial.undefinedA x UndefinedConverterUnits.MetricAndUKImperial.undefinedC) per UndefinedConverterUnits.MetricAndUKImperial.undefinedD))
		// )
		// assertEquals(
		// 	1.0(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedD) per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedB x UndefinedConverterUnits.MetricAndUSCustomary.undefinedC))),
		// 	2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedA) per UndefinedConverterUnits.MetricAndUSCustomary.undefinedB)) metricAndUSCustomaryDividedByMetricAndUSCustomary
		// 		2(((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA x UndefinedConverterUnits.MetricAndUSCustomary.undefinedC) per UndefinedConverterUnits.MetricAndUSCustomary.undefinedD))
		// )
	}
}
