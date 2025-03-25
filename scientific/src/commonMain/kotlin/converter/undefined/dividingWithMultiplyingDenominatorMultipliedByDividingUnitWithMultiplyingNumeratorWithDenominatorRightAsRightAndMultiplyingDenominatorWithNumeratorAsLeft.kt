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
import com.splendo.kaluga.scientific.unit.per
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Div<A, Mul<B, C>> * Div<Mul<D, C>, Mul<A, E>> -> Div<D, Mul<B, E>>

@JvmName("dividingWithMultiplyingDenominatorMultipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsRightAndMultiplyingDenominatorWithNumeratorAsLeft")
fun <
	LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightNumeratorRightQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		LeftDenominatorUnit,
		>,
	RightNumeratorLeftQuantity : UndefinedQuantityType,
	RightNumeratorLeftUnit : AbstractUndefinedScientificUnit<RightNumeratorLeftQuantity>,
	RightNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		RightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorRightAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	RightDenominatorRightQuantity : UndefinedQuantityType,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<RightDenominatorRightQuantity>,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		RightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	TargetDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftQuantity,
		LeftDenominatorLeftUnit,
		RightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		RightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		TargetDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorLeftQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
	leftDenominatorLeftUnitXRightDenominatorRightUnit: LeftDenominatorLeftUnit.(RightDenominatorRightUnit) -> TargetDenominatorUnit,
	rightNumeratorLeftUnitPerTargetDenominatorUnit: RightNumeratorLeftUnit.(TargetDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.numerator.left.rightNumeratorLeftUnitPerTargetDenominatorUnit(
	unit.denominator.left.leftDenominatorLeftUnitXRightDenominatorRightUnit(
	right.unit.denominator.right,
),
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingDenominatorMultipliedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsRightAndMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftQuantity : UndefinedQuantityType,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorLeftUnit,
	RightDenominatorRightQuantity : UndefinedQuantityType,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightNumeratorRightQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : AbstractUndefinedScientificUnit<RightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		RightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorRightAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<RightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		RightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftDenominatorLeftUnitXRightDenominatorRightUnit = { x(it) },
		rightNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				RightNumeratorLeftQuantity,
				RightNumeratorLeftUnit,
				UndefinedQuantityType.Multiplying<
					LeftDenominatorLeftQuantity,
					RightDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndImperial<
				LeftDenominatorLeftQuantity,
					LeftDenominatorLeftUnit,
					RightDenominatorRightQuantity,
					RightDenominatorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingWithMultiplyingDenominatorMultipliedByMetricDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsRightAndMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftQuantity : UndefinedQuantityType,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorLeftUnit,
	RightDenominatorRightQuantity : UndefinedQuantityType,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightNumeratorRightQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : AbstractUndefinedScientificUnit<RightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		RightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorRightAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<RightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		RightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		leftDenominatorLeftUnitXRightDenominatorRightUnit = { x(it) },
		rightNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				RightNumeratorLeftQuantity,
				RightNumeratorLeftUnit,
				UndefinedQuantityType.Multiplying<
					LeftDenominatorLeftQuantity,
					RightDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.Metric<
				LeftDenominatorLeftQuantity,
					LeftDenominatorLeftUnit,
					RightDenominatorRightQuantity,
					RightDenominatorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingWithMultiplyingDenominatorMultipliedByImperialDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsRightAndMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftQuantity : UndefinedQuantityType,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorLeftUnit,
	RightDenominatorRightQuantity : UndefinedQuantityType,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightNumeratorRightQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : AbstractUndefinedScientificUnit<RightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		RightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorRightAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<RightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		RightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftDenominatorLeftUnitXRightDenominatorRightUnit = { x(it) },
		rightNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				RightNumeratorLeftQuantity,
				RightNumeratorLeftUnit,
				UndefinedQuantityType.Multiplying<
					LeftDenominatorLeftQuantity,
					RightDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.Imperial<
				LeftDenominatorLeftQuantity,
					LeftDenominatorLeftUnit,
					RightDenominatorRightQuantity,
					RightDenominatorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithMultiplyingDenominatorMultipliedByUKImperialDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsRightAndMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftQuantity : UndefinedQuantityType,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorLeftUnit,
	RightDenominatorRightQuantity : UndefinedQuantityType,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightNumeratorRightQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : AbstractUndefinedScientificUnit<RightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		RightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorRightAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<RightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		RightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftDenominatorLeftUnitXRightDenominatorRightUnit = { x(it) },
		rightNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				RightNumeratorLeftQuantity,
				RightNumeratorLeftUnit,
				UndefinedQuantityType.Multiplying<
					LeftDenominatorLeftQuantity,
					RightDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.UKImperial<
				LeftDenominatorLeftQuantity,
					LeftDenominatorLeftUnit,
					RightDenominatorRightQuantity,
					RightDenominatorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithMultiplyingDenominatorMultipliedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsRightAndMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftQuantity : UndefinedQuantityType,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorLeftUnit,
	RightDenominatorRightQuantity : UndefinedQuantityType,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightNumeratorRightQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : AbstractUndefinedScientificUnit<RightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		RightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorRightAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<RightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		RightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftDenominatorLeftUnitXRightDenominatorRightUnit = { x(it) },
		rightNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				RightNumeratorLeftQuantity,
				RightNumeratorLeftUnit,
				UndefinedQuantityType.Multiplying<
					LeftDenominatorLeftQuantity,
					RightDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.USCustomary<
				LeftDenominatorLeftQuantity,
					LeftDenominatorLeftUnit,
					RightDenominatorRightQuantity,
					RightDenominatorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithMultiplyingDenominatorMultipliedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsRightAndMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftQuantity : UndefinedQuantityType,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorLeftUnit,
	RightDenominatorRightQuantity : UndefinedQuantityType,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightNumeratorRightQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : AbstractUndefinedScientificUnit<RightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		RightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorRightAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<RightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		RightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftDenominatorLeftUnitXRightDenominatorRightUnit = { x(it) },
		rightNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				RightNumeratorLeftQuantity,
				RightNumeratorLeftUnit,
				UndefinedQuantityType.Multiplying<
					LeftDenominatorLeftQuantity,
					RightDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUKImperial<
				LeftDenominatorLeftQuantity,
					LeftDenominatorLeftUnit,
					RightDenominatorRightQuantity,
					RightDenominatorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithMultiplyingDenominatorMultipliedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsRightAndMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftQuantity : UndefinedQuantityType,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorLeftUnit,
	RightDenominatorRightQuantity : UndefinedQuantityType,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightNumeratorRightQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : AbstractUndefinedScientificUnit<RightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		RightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorRightAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<RightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		RightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorRightAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftDenominatorLeftUnitXRightDenominatorRightUnit = { x(it) },
		rightNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				RightNumeratorLeftQuantity,
				RightNumeratorLeftUnit,
				UndefinedQuantityType.Multiplying<
					LeftDenominatorLeftQuantity,
					RightDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUSCustomary<
				LeftDenominatorLeftQuantity,
					LeftDenominatorLeftUnit,
					RightDenominatorRightQuantity,
					RightDenominatorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}
