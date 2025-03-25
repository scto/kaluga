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
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.per
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Div<Mul<A, B>, C> * Inv<Mul<B, D>> -> Div<A, Mul<C, D>>

@JvmName("dividingWithMultiplyingNumeratorMultipliedByReciprocalMultiplyingWithNumeratorRightAsLeft")
fun <
	LeftNumeratorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftQuantity>,
	LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightAndRightReciprocalLeftQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftQuantity,
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		LeftNumeratorRightAndRightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	TargetDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		LeftNumeratorLeftQuantity,
		LeftNumeratorLeftUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorQuantity,
			RightReciprocalRightQuantity,
			>,
		TargetDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorLeftQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorQuantity,
			RightReciprocalRightQuantity,
			>,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftQuantity,
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
	leftDenominatorUnitXRightReciprocalRightUnit: LeftDenominatorUnit.(RightReciprocalRightUnit) -> TargetDenominatorUnit,
	leftNumeratorLeftUnitPerTargetDenominatorUnit: LeftNumeratorLeftUnit.(TargetDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.left.leftNumeratorLeftUnitPerTargetDenominatorUnit(
	unit.denominator.leftDenominatorUnitXRightReciprocalRightUnit(
	right.unit.inverse.right,
),
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingNumeratorMultipliedByMetricAndImperialReciprocalMultiplyingWithNumeratorRightAsLeft")
infix fun <
	LeftNumeratorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
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
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftQuantity,
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightAndRightReciprocalLeftQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftQuantity,
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		LeftNumeratorRightAndRightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
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
		leftNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				LeftNumeratorLeftQuantity,
				LeftNumeratorLeftUnit,
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
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingWithMultiplyingNumeratorMultipliedByMetricReciprocalMultiplyingWithNumeratorRightAsLeft")
infix fun <
	LeftNumeratorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
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
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftQuantity,
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightAndRightReciprocalLeftQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftQuantity,
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		LeftNumeratorRightAndRightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		leftDenominatorUnitXRightReciprocalRightUnit = { x(it) },
		leftNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				LeftNumeratorLeftQuantity,
				LeftNumeratorLeftUnit,
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
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingWithMultiplyingNumeratorMultipliedByImperialReciprocalMultiplyingWithNumeratorRightAsLeft")
infix fun <
	LeftNumeratorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
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
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftQuantity,
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightAndRightReciprocalLeftQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftQuantity,
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		LeftNumeratorRightAndRightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftDenominatorUnitXRightReciprocalRightUnit = { x(it) },
		leftNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				LeftNumeratorLeftQuantity,
				LeftNumeratorLeftUnit,
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
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithMultiplyingNumeratorMultipliedByUKImperialReciprocalMultiplyingWithNumeratorRightAsLeft")
infix fun <
	LeftNumeratorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
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
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftQuantity,
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightAndRightReciprocalLeftQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftQuantity,
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		LeftNumeratorRightAndRightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftDenominatorUnitXRightReciprocalRightUnit = { x(it) },
		leftNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				LeftNumeratorLeftQuantity,
				LeftNumeratorLeftUnit,
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
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithMultiplyingNumeratorMultipliedByUSCustomaryReciprocalMultiplyingWithNumeratorRightAsLeft")
infix fun <
	LeftNumeratorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
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
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftQuantity,
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightAndRightReciprocalLeftQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftQuantity,
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		LeftNumeratorRightAndRightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftDenominatorUnitXRightReciprocalRightUnit = { x(it) },
		leftNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				LeftNumeratorLeftQuantity,
				LeftNumeratorLeftUnit,
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
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithMultiplyingNumeratorMultipliedByMetricAndUKImperialReciprocalMultiplyingWithNumeratorRightAsLeft")
infix fun <
	LeftNumeratorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
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
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftQuantity,
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightAndRightReciprocalLeftQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftQuantity,
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		LeftNumeratorRightAndRightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftDenominatorUnitXRightReciprocalRightUnit = { x(it) },
		leftNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				LeftNumeratorLeftQuantity,
				LeftNumeratorLeftUnit,
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
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithMultiplyingNumeratorMultipliedByMetricAndUSCustomaryReciprocalMultiplyingWithNumeratorRightAsLeft")
infix fun <
	LeftNumeratorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
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
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftQuantity,
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightAndRightReciprocalLeftQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftQuantity,
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		LeftNumeratorRightAndRightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightReciprocalLeftQuantity,
			RightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftDenominatorUnitXRightReciprocalRightUnit = { x(it) },
		leftNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				LeftNumeratorLeftQuantity,
				LeftNumeratorLeftUnit,
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
		DefaultScientificValue(value, unit)
	}
