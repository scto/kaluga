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
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// Div<A, B> * Div<Mul<C, B>, Mul<D, A>> -> Div<C, D>

@JvmName("dividingMultipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndMultiplyingDenominatorWithNumeratorAsRight")
fun <
	LeftNumeratorAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorRightQuantity>,
	LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorRightQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightNumeratorRightQuantity,
		LeftDenominatorUnit,
		>,
	RightNumeratorLeftQuantity : UndefinedQuantityType,
	RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		RightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorRightQuantity>,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftNumeratorAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftNumeratorAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		RightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorLeftQuantity,
		RightDenominatorLeftQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorRightQuantity,
		LeftDenominatorAndRightNumeratorRightQuantity,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftNumeratorAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
	rightNumeratorLeftUnitPerRightDenominatorLeftUnit: RightNumeratorLeftUnit.(RightDenominatorLeftUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.numerator.left.rightNumeratorLeftUnitPerRightDenominatorLeftUnit(
	right.unit.denominator.left,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingMultipliedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndMultiplyingDenominatorWithNumeratorAsRight")
infix fun <
	LeftNumeratorAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftQuantity : UndefinedQuantityType,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorRightQuantity,
		LeftDenominatorAndRightNumeratorRightQuantity,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftNumeratorAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorRightQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorRightQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightNumeratorRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		RightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftNumeratorAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftNumeratorAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightNumeratorLeftUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				RightNumeratorLeftQuantity,
				RightNumeratorLeftUnit,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDividingMultipliedByMetricDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndMultiplyingDenominatorWithNumeratorAsRight")
infix fun <
	LeftNumeratorAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftQuantity : UndefinedQuantityType,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorRightQuantity,
		LeftDenominatorAndRightNumeratorRightQuantity,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftNumeratorAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorRightQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorRightQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightNumeratorRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		RightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftNumeratorAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftNumeratorAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		rightNumeratorLeftUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				RightNumeratorLeftQuantity,
				RightNumeratorLeftUnit,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDividingMultipliedByImperialDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndMultiplyingDenominatorWithNumeratorAsRight")
infix fun <
	LeftNumeratorAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftQuantity : UndefinedQuantityType,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorRightQuantity,
		LeftDenominatorAndRightNumeratorRightQuantity,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftNumeratorAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorRightQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorRightQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightNumeratorRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		RightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftNumeratorAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftNumeratorAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightNumeratorLeftUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				RightNumeratorLeftQuantity,
				RightNumeratorLeftUnit,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDividingMultipliedByUKImperialDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndMultiplyingDenominatorWithNumeratorAsRight")
infix fun <
	LeftNumeratorAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftQuantity : UndefinedQuantityType,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorRightQuantity,
		LeftDenominatorAndRightNumeratorRightQuantity,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftNumeratorAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorRightQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorRightQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightNumeratorRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		RightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftNumeratorAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftNumeratorAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		rightNumeratorLeftUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				RightNumeratorLeftQuantity,
				RightNumeratorLeftUnit,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingMultipliedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndMultiplyingDenominatorWithNumeratorAsRight")
infix fun <
	LeftNumeratorAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftQuantity : UndefinedQuantityType,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorRightQuantity,
		LeftDenominatorAndRightNumeratorRightQuantity,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftNumeratorAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorRightQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorRightQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightNumeratorRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		RightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftNumeratorAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftNumeratorAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightNumeratorLeftUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				RightNumeratorLeftQuantity,
				RightNumeratorLeftUnit,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingMultipliedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndMultiplyingDenominatorWithNumeratorAsRight")
infix fun <
	LeftNumeratorAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftQuantity : UndefinedQuantityType,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorRightQuantity,
		LeftDenominatorAndRightNumeratorRightQuantity,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftNumeratorAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorRightQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorRightQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightNumeratorRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		RightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftNumeratorAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftNumeratorAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		rightNumeratorLeftUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				RightNumeratorLeftQuantity,
				RightNumeratorLeftUnit,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingMultipliedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndMultiplyingDenominatorWithNumeratorAsRight")
infix fun <
	LeftNumeratorAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftQuantity : UndefinedQuantityType,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorRightQuantity,
		LeftDenominatorAndRightNumeratorRightQuantity,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorAndRightNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftNumeratorAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorRightQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorRightQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightNumeratorRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		RightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftDenominatorAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftNumeratorAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			RightNumeratorLeftQuantity,
			LeftDenominatorAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftNumeratorAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightNumeratorLeftUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				RightNumeratorLeftQuantity,
				RightNumeratorLeftUnit,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
