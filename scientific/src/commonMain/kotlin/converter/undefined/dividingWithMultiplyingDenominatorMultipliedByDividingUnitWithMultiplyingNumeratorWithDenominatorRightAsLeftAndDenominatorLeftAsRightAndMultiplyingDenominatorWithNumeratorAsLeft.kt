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
import kotlin.jvm.JvmName

// Div<A, Mul<B, C>> * Div<Mul<C, B>, Mul<A, D>> -> Inv<D>

@JvmName("dividingWithMultiplyingDenominatorMultipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorAsLeft")
fun <
	LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
	LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftAndRightNumeratorRightQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightNumeratorLeftQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			>,
		LeftDenominatorUnit,
		>,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftDenominatorRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorLeftAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	RightDenominatorRightQuantity : UndefinedQuantityType,
	RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		RightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	TargetUnit : UndefinedReciprocalUnit<
		RightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		RightDenominatorRightQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
	reciprocalTargetUnit: RightDenominatorRightUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.denominator.right.reciprocalTargetUnit().byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingDenominatorMultipliedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
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
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftAndRightNumeratorRightQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightNumeratorLeftQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftDenominatorRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorLeftAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
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
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
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
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndImperial<
							RightDenominatorRightQuantity,
							RightDenominatorRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDividingWithMultiplyingDenominatorMultipliedByMetricDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
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
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftAndRightNumeratorRightQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightNumeratorLeftQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftDenominatorRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorLeftAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
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
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
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
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Metric<
							RightDenominatorRightQuantity,
							RightDenominatorRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDividingWithMultiplyingDenominatorMultipliedByImperialDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
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
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftAndRightNumeratorRightQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightNumeratorLeftQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftDenominatorRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorLeftAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
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
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
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
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Imperial<
							RightDenominatorRightQuantity,
							RightDenominatorRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithMultiplyingDenominatorMultipliedByUKImperialDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
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
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftAndRightNumeratorRightQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightNumeratorLeftQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftDenominatorRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorLeftAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
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
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
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
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.UKImperial<
							RightDenominatorRightQuantity,
							RightDenominatorRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithMultiplyingDenominatorMultipliedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
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
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftAndRightNumeratorRightQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightNumeratorLeftQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftDenominatorRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorLeftAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
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
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
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
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.USCustomary<
							RightDenominatorRightQuantity,
							RightDenominatorRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithMultiplyingDenominatorMultipliedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
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
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftAndRightNumeratorRightQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightNumeratorLeftQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftDenominatorRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorLeftAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
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
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
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
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUKImperial<
							RightDenominatorRightQuantity,
							RightDenominatorRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithMultiplyingDenominatorMultipliedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
	LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
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
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorAndRightDenominatorLeftQuantity,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftAndRightNumeratorRightQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightNumeratorLeftQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorLeftQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftDenominatorRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorLeftAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
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
			LeftDenominatorRightAndRightNumeratorLeftQuantity,
			LeftDenominatorLeftAndRightNumeratorRightQuantity,
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
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
							RightDenominatorRightQuantity,
							RightDenominatorRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
