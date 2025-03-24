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

// Div<A, Mul<B, B>> / Inv<Mul<B, B>> -> A

class DividingWithSquaredDenominatorDividedByReciprocalSquaredWithDenominatorRootAsRootTest {

	@Test
	fun dividedByReciprocalSquaredWithDenominatorRootAsRoot() {
		// assertEquals(
		// 	1.0(UndefinedConverterUnits.MetricAndImperial.undefinedA),
		// 	2((UndefinedConverterUnits.MetricAndImperial.undefinedA per (UndefinedConverterUnits.MetricAndImperial.undefinedB x UndefinedConverterUnits.MetricAndImperial.undefinedB))) metricAndImperialDividedByMetricAndImperial
		// 		2((UndefinedConverterUnits.MetricAndImperial.undefinedB x UndefinedConverterUnits.MetricAndImperial.undefinedB).reciprocal())
		// )
		// assertEquals(
		// 	1.0(UndefinedConverterUnits.Metric.undefinedA),
		// 	2((UndefinedConverterUnits.Metric.undefinedA per (UndefinedConverterUnits.Metric.undefinedB x UndefinedConverterUnits.Metric.undefinedB))) metricDividedByMetric
		// 		2((UndefinedConverterUnits.Metric.undefinedB x UndefinedConverterUnits.Metric.undefinedB).reciprocal())
		// )
		// assertEquals(
		// 	1.0(UndefinedConverterUnits.Imperial.undefinedA),
		// 	2((UndefinedConverterUnits.Imperial.undefinedA per (UndefinedConverterUnits.Imperial.undefinedB x UndefinedConverterUnits.Imperial.undefinedB))) imperialDividedByImperial
		// 		2((UndefinedConverterUnits.Imperial.undefinedB x UndefinedConverterUnits.Imperial.undefinedB).reciprocal())
		// )
		// assertEquals(
		// 	1.0(UndefinedConverterUnits.UKImperial.undefinedA),
		// 	2((UndefinedConverterUnits.UKImperial.undefinedA per (UndefinedConverterUnits.UKImperial.undefinedB x UndefinedConverterUnits.UKImperial.undefinedB))) ukImperialDividedByUKImperial
		// 		2((UndefinedConverterUnits.UKImperial.undefinedB x UndefinedConverterUnits.UKImperial.undefinedB).reciprocal())
		// )
		// assertEquals(
		// 	1.0(UndefinedConverterUnits.USCustomary.undefinedA),
		// 	2((UndefinedConverterUnits.USCustomary.undefinedA per (UndefinedConverterUnits.USCustomary.undefinedB x UndefinedConverterUnits.USCustomary.undefinedB))) usCustomaryDividedByUSCustomary
		// 		2((UndefinedConverterUnits.USCustomary.undefinedB x UndefinedConverterUnits.USCustomary.undefinedB).reciprocal())
		// )
		// assertEquals(
		// 	1.0(UndefinedConverterUnits.MetricAndUKImperial.undefinedA),
		// 	2((UndefinedConverterUnits.MetricAndUKImperial.undefinedA per (UndefinedConverterUnits.MetricAndUKImperial.undefinedB x UndefinedConverterUnits.MetricAndUKImperial.undefinedB))) metricAndUKImperialDividedByMetricAndUKImperial
		// 		2((UndefinedConverterUnits.MetricAndUKImperial.undefinedB x UndefinedConverterUnits.MetricAndUKImperial.undefinedB).reciprocal())
		// )
		// assertEquals(
		// 	1.0(UndefinedConverterUnits.MetricAndUSCustomary.undefinedA),
		// 	2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedA per (UndefinedConverterUnits.MetricAndUSCustomary.undefinedB x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB))) metricAndUSCustomaryDividedByMetricAndUSCustomary
		// 		2((UndefinedConverterUnits.MetricAndUSCustomary.undefinedB x UndefinedConverterUnits.MetricAndUSCustomary.undefinedB).reciprocal())
		// )
	}
}
