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

// Div<Mul<A, B>, C> * Div<D, Mul<B, A>> -> Div<D, C>

@JvmName("dividingWithMultiplyingNumeratorMultipliedByDividingUnitWithMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
fun <
	LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
	LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftAndRightDenominatorRightQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightAndRightDenominatorLeftQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
	RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		LeftNumeratorRightAndRightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftNumeratorLeftAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftDenominatorQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
	rightNumeratorUnitPerLeftDenominatorUnit: RightNumeratorUnit.(LeftDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.numerator.rightNumeratorUnitPerLeftDenominatorUnit(
	unit.denominator,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingNumeratorMultipliedByMetricAndImperialDividingUnitWithMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
	LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftAndRightDenominatorRightQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightAndRightDenominatorLeftQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		LeftNumeratorRightAndRightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftNumeratorLeftAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightNumeratorUnitPerLeftDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				LeftDenominatorQuantity,
				LeftDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDividingWithMultiplyingNumeratorMultipliedByMetricDividingUnitWithMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
	LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftAndRightDenominatorRightQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightAndRightDenominatorLeftQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		LeftNumeratorRightAndRightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftNumeratorLeftAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		rightNumeratorUnitPerLeftDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				LeftDenominatorQuantity,
				LeftDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDividingWithMultiplyingNumeratorMultipliedByImperialDividingUnitWithMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
	LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftAndRightDenominatorRightQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightAndRightDenominatorLeftQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		LeftNumeratorRightAndRightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftNumeratorLeftAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightNumeratorUnitPerLeftDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				LeftDenominatorQuantity,
				LeftDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithMultiplyingNumeratorMultipliedByUKImperialDividingUnitWithMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
	LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftAndRightDenominatorRightQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightAndRightDenominatorLeftQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		LeftNumeratorRightAndRightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftNumeratorLeftAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		rightNumeratorUnitPerLeftDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				LeftDenominatorQuantity,
				LeftDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithMultiplyingNumeratorMultipliedByUSCustomaryDividingUnitWithMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
	LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftAndRightDenominatorRightQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightAndRightDenominatorLeftQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		LeftNumeratorRightAndRightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftNumeratorLeftAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightNumeratorUnitPerLeftDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				LeftDenominatorQuantity,
				LeftDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithMultiplyingNumeratorMultipliedByMetricAndUKImperialDividingUnitWithMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
	LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftAndRightDenominatorRightQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightAndRightDenominatorLeftQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		LeftNumeratorRightAndRightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftNumeratorLeftAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		rightNumeratorUnitPerLeftDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				LeftDenominatorQuantity,
				LeftDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithMultiplyingNumeratorMultipliedByMetricAndUSCustomaryDividingUnitWithMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
	LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftAndRightDenominatorRightQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightAndRightDenominatorLeftQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		LeftNumeratorRightAndRightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftNumeratorLeftAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightAndRightDenominatorLeftQuantity,
			LeftNumeratorLeftAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightNumeratorUnitPerLeftDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				LeftDenominatorQuantity,
				LeftDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
