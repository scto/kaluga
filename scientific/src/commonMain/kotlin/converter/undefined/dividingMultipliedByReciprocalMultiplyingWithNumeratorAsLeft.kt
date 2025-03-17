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
import com.splendo.kaluga.scientific.DefaultUndefinedScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Div<A, B> * Inv<Mul<A, C>> -> Inv<Mul<B, C>>

@JvmName("dividingMultipliedByReciprocalMultiplyingWithNumeratorAsLeft")
fun <
	LeftNumeratorAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalLeftQuantity>,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	RightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalLeftQuantity>,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	TargetReciprocalUnit : UndefinedMultipliedUnit<
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	TargetUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorQuantity,
			RightReciprocalRightQuantity,
			>,
		TargetReciprocalUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorQuantity,
			RightReciprocalRightQuantity,
			>,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
	leftDenominatorUnitXRightReciprocalRightUnit: LeftDenominatorUnit.(RightReciprocalRightUnit) -> TargetReciprocalUnit,
	reciprocalTargetUnit: TargetReciprocalUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.denominator.leftDenominatorUnitXRightReciprocalRightUnit(
	right.unit.inverse.right,
).reciprocalTargetUnit().byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingMultipliedByMetricAndImperialReciprocalMultiplyingWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftDenominatorUnitXRightReciprocalRightUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndImperial<
							UndefinedQuantityType.Multiplying<
					LeftDenominatorQuantity,
					RightReciprocalRightQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndImperial<
				LeftDenominatorQuantity,
					LeftDenominatorUnit,
					RightReciprocalRightQuantity,
					RightReciprocalRightUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDividingMultipliedByMetricReciprocalMultiplyingWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		leftDenominatorUnitXRightReciprocalRightUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Metric<
							UndefinedQuantityType.Multiplying<
					LeftDenominatorQuantity,
					RightReciprocalRightQuantity,
					>,
							UndefinedMultipliedUnit.Metric<
				LeftDenominatorQuantity,
					LeftDenominatorUnit,
					RightReciprocalRightQuantity,
					RightReciprocalRightUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDividingMultipliedByImperialReciprocalMultiplyingWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftDenominatorUnitXRightReciprocalRightUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Imperial<
							UndefinedQuantityType.Multiplying<
					LeftDenominatorQuantity,
					RightReciprocalRightQuantity,
					>,
							UndefinedMultipliedUnit.Imperial<
				LeftDenominatorQuantity,
					LeftDenominatorUnit,
					RightReciprocalRightQuantity,
					RightReciprocalRightUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDividingMultipliedByUKImperialReciprocalMultiplyingWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftDenominatorUnitXRightReciprocalRightUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.UKImperial<
							UndefinedQuantityType.Multiplying<
					LeftDenominatorQuantity,
					RightReciprocalRightQuantity,
					>,
							UndefinedMultipliedUnit.UKImperial<
				LeftDenominatorQuantity,
					LeftDenominatorUnit,
					RightReciprocalRightQuantity,
					RightReciprocalRightUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingMultipliedByUSCustomaryReciprocalMultiplyingWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftDenominatorUnitXRightReciprocalRightUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.USCustomary<
							UndefinedQuantityType.Multiplying<
					LeftDenominatorQuantity,
					RightReciprocalRightQuantity,
					>,
							UndefinedMultipliedUnit.USCustomary<
				LeftDenominatorQuantity,
					LeftDenominatorUnit,
					RightReciprocalRightQuantity,
					RightReciprocalRightUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingMultipliedByMetricAndUKImperialReciprocalMultiplyingWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftDenominatorUnitXRightReciprocalRightUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUKImperial<
							UndefinedQuantityType.Multiplying<
					LeftDenominatorQuantity,
					RightReciprocalRightQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndUKImperial<
				LeftDenominatorQuantity,
					LeftDenominatorUnit,
					RightReciprocalRightQuantity,
					RightReciprocalRightUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingMultipliedByMetricAndUSCustomaryReciprocalMultiplyingWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		LeftNumeratorAndRightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftDenominatorUnitXRightReciprocalRightUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
							UndefinedQuantityType.Multiplying<
					LeftDenominatorQuantity,
					RightReciprocalRightQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndUSCustomary<
				LeftDenominatorQuantity,
					LeftDenominatorUnit,
					RightReciprocalRightQuantity,
					RightReciprocalRightUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
