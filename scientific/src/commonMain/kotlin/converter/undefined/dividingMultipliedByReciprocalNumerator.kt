@file:Suppress("ktlint:standard:wrapping")
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

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// Div<A, B> * Inv<A> -> Inv<B>

@JvmName("dividingMultipliedByReciprocalNumerator")
fun <
	LeftNumeratorAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightReciprocalQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	RightUnit : UndefinedReciprocalUnit<
		LeftNumeratorAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	TargetUnit : UndefinedReciprocalUnit<
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftDenominatorQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightReciprocalQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftNumeratorAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
	reciprocalTargetUnit: LeftDenominatorUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.denominator.reciprocalTargetUnit().byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingMultipliedByMetricAndImperialReciprocalNumerator")
infix fun <
	LeftNumeratorAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightReciprocalQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftNumeratorAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightReciprocalQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		LeftNumeratorAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndImperial<
							LeftDenominatorQuantity,
							LeftDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingMultipliedByMetricReciprocalNumerator")
infix fun <
	LeftNumeratorAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightReciprocalQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftNumeratorAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightReciprocalQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedReciprocalUnit<
		LeftNumeratorAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Metric<
							LeftDenominatorQuantity,
							LeftDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingMultipliedByImperialReciprocalNumerator")
infix fun <
	LeftNumeratorAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightReciprocalQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftNumeratorAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightReciprocalQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		LeftNumeratorAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Imperial<
							LeftDenominatorQuantity,
							LeftDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingMultipliedByUKImperialReciprocalNumerator")
infix fun <
	LeftNumeratorAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightReciprocalQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftNumeratorAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightReciprocalQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<
		LeftNumeratorAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.UKImperial<
							LeftDenominatorQuantity,
							LeftDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingMultipliedByUSCustomaryReciprocalNumerator")
infix fun <
	LeftNumeratorAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightReciprocalQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftNumeratorAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightReciprocalQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		LeftNumeratorAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.USCustomary<
							LeftDenominatorQuantity,
							LeftDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingMultipliedByMetricAndUKImperialReciprocalNumerator")
infix fun <
	LeftNumeratorAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightReciprocalQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftNumeratorAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightReciprocalQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<
		LeftNumeratorAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUKImperial<
							LeftDenominatorQuantity,
							LeftDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingMultipliedByMetricAndUSCustomaryReciprocalNumerator")
infix fun <
	LeftNumeratorAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightReciprocalQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftNumeratorAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightReciprocalQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		LeftNumeratorAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
							LeftDenominatorQuantity,
							LeftDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
