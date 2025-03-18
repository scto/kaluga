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
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Div<A, B> * Div<Mul<B, Wr<C>>, A> -> C!

@JvmName("dividingMultipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorAsLeftAndDefinedRightAndNumeratorAsDenominator")
fun <
	LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
	LeftDenominatorAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightNumeratorLeftQuantity,
		LeftDenominatorUnit,
		>,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
	RightNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightNumeratorRightUnit : ScientificUnit<RightNumeratorRightQuantity>,
	WrappedRightNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	RightNumeratorRightQuantity,
	RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftDenominatorAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			RightNumeratorRightQuantity,
			>,
		WrappedRightNumeratorRightUnit,
		>,
	RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorAndRightNumeratorLeftQuantity,
			UndefinedQuantityType.Extended<
				RightNumeratorRightQuantity,
				>,
			>,
		RightNumeratorUnit,
		LeftNumeratorAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightNumeratorRightValue : ScientificValue<RightNumeratorRightQuantity, RightNumeratorRightUnit>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorQuantity,
		LeftDenominatorAndRightNumeratorLeftQuantity,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorAndRightNumeratorLeftQuantity,
			UndefinedQuantityType.Extended<
				RightNumeratorRightQuantity,
				>,
			>,
		LeftNumeratorAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
	factory: (Decimal, RightNumeratorRightUnit) -> RightNumeratorRightValue,
) = right.unit.numerator.right.wrapped.byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingMultipliedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithDenominatorAsLeftAndDefinedRightAndNumeratorAsDenominator")
infix fun <
	LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightNumeratorRightUnit,
	WrappedRightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorQuantity,
		LeftDenominatorAndRightNumeratorLeftQuantity,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorAndRightNumeratorLeftQuantity,
			UndefinedQuantityType.Extended<
				RightNumeratorRightQuantity,
				>,
			>,
		LeftNumeratorAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightNumeratorLeftQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : AbstractScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedRightNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	RightNumeratorRightQuantity,
	RightNumeratorRightUnit,
		>,
	WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftDenominatorAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			RightNumeratorRightQuantity,
			>,
		WrappedRightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorAndRightNumeratorLeftQuantity,
			UndefinedQuantityType.Extended<
				RightNumeratorRightQuantity,
				>,
			>,
		RightNumeratorUnit,
		LeftNumeratorAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: RightNumeratorRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingMultipliedByMetricDividingUnitWithMultiplyingNumeratorWithDenominatorAsLeftAndDefinedRightAndNumeratorAsDenominator")
infix fun <
	LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightNumeratorRightUnit,
	WrappedRightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorQuantity,
		LeftDenominatorAndRightNumeratorLeftQuantity,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorAndRightNumeratorLeftQuantity,
			UndefinedQuantityType.Extended<
				RightNumeratorRightQuantity,
				>,
			>,
		LeftNumeratorAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightNumeratorLeftQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : AbstractScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedRightNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	RightNumeratorRightQuantity,
	RightNumeratorRightUnit,
		>,
	WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftDenominatorAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			RightNumeratorRightQuantity,
			>,
		WrappedRightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorAndRightNumeratorLeftQuantity,
			UndefinedQuantityType.Extended<
				RightNumeratorRightQuantity,
				>,
			>,
		RightNumeratorUnit,
		LeftNumeratorAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(right) {
		value: Decimal,
		unit: RightNumeratorRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingMultipliedByImperialDividingUnitWithMultiplyingNumeratorWithDenominatorAsLeftAndDefinedRightAndNumeratorAsDenominator")
infix fun <
	LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightNumeratorRightUnit,
	WrappedRightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorQuantity,
		LeftDenominatorAndRightNumeratorLeftQuantity,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorAndRightNumeratorLeftQuantity,
			UndefinedQuantityType.Extended<
				RightNumeratorRightQuantity,
				>,
			>,
		LeftNumeratorAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightNumeratorLeftQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : AbstractScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedRightNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	RightNumeratorRightQuantity,
	RightNumeratorRightUnit,
		>,
	WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftDenominatorAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			RightNumeratorRightQuantity,
			>,
		WrappedRightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorAndRightNumeratorLeftQuantity,
			UndefinedQuantityType.Extended<
				RightNumeratorRightQuantity,
				>,
			>,
		RightNumeratorUnit,
		LeftNumeratorAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: RightNumeratorRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingMultipliedByUKImperialDividingUnitWithMultiplyingNumeratorWithDenominatorAsLeftAndDefinedRightAndNumeratorAsDenominator")
infix fun <
	LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightNumeratorRightUnit,
	WrappedRightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorQuantity,
		LeftDenominatorAndRightNumeratorLeftQuantity,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorAndRightNumeratorLeftQuantity,
			UndefinedQuantityType.Extended<
				RightNumeratorRightQuantity,
				>,
			>,
		LeftNumeratorAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightNumeratorLeftQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : AbstractScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedRightNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	RightNumeratorRightQuantity,
	RightNumeratorRightUnit,
		>,
	WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftDenominatorAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			RightNumeratorRightQuantity,
			>,
		WrappedRightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorAndRightNumeratorLeftQuantity,
			UndefinedQuantityType.Extended<
				RightNumeratorRightQuantity,
				>,
			>,
		RightNumeratorUnit,
		LeftNumeratorAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(right) {
		value: Decimal,
		unit: RightNumeratorRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingMultipliedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithDenominatorAsLeftAndDefinedRightAndNumeratorAsDenominator")
infix fun <
	LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightNumeratorRightUnit,
	WrappedRightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorQuantity,
		LeftDenominatorAndRightNumeratorLeftQuantity,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorAndRightNumeratorLeftQuantity,
			UndefinedQuantityType.Extended<
				RightNumeratorRightQuantity,
				>,
			>,
		LeftNumeratorAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightNumeratorLeftQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : AbstractScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedRightNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	RightNumeratorRightQuantity,
	RightNumeratorRightUnit,
		>,
	WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftDenominatorAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			RightNumeratorRightQuantity,
			>,
		WrappedRightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorAndRightNumeratorLeftQuantity,
			UndefinedQuantityType.Extended<
				RightNumeratorRightQuantity,
				>,
			>,
		RightNumeratorUnit,
		LeftNumeratorAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: RightNumeratorRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingMultipliedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithDenominatorAsLeftAndDefinedRightAndNumeratorAsDenominator")
infix fun <
	LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightNumeratorRightUnit,
	WrappedRightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorQuantity,
		LeftDenominatorAndRightNumeratorLeftQuantity,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorAndRightNumeratorLeftQuantity,
			UndefinedQuantityType.Extended<
				RightNumeratorRightQuantity,
				>,
			>,
		LeftNumeratorAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightNumeratorLeftQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : AbstractScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedRightNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	RightNumeratorRightQuantity,
	RightNumeratorRightUnit,
		>,
	WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftDenominatorAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			RightNumeratorRightQuantity,
			>,
		WrappedRightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorAndRightNumeratorLeftQuantity,
			UndefinedQuantityType.Extended<
				RightNumeratorRightQuantity,
				>,
			>,
		RightNumeratorUnit,
		LeftNumeratorAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(right) {
		value: Decimal,
		unit: RightNumeratorRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingMultipliedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithDenominatorAsLeftAndDefinedRightAndNumeratorAsDenominator")
infix fun <
	LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightNumeratorRightUnit,
	WrappedRightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorQuantity,
		LeftDenominatorAndRightNumeratorLeftQuantity,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorAndRightNumeratorLeftQuantity,
			UndefinedQuantityType.Extended<
				RightNumeratorRightQuantity,
				>,
			>,
		LeftNumeratorAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightNumeratorLeftQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : AbstractScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedRightNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	RightNumeratorRightQuantity,
	RightNumeratorRightUnit,
		>,
	WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedRightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftDenominatorAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			RightNumeratorRightQuantity,
			>,
		WrappedRightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorAndRightNumeratorLeftQuantity,
			UndefinedQuantityType.Extended<
				RightNumeratorRightQuantity,
				>,
			>,
		RightNumeratorUnit,
		LeftNumeratorAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: RightNumeratorRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericDividingMultipliedByGenericDividingUnitWithMultiplyingNumeratorWithDenominatorAsLeftAndDefinedRightAndNumeratorAsDenominator")
infix fun <
	LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
	LeftDenominatorAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorAndRightDenominatorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightNumeratorLeftQuantity,
		LeftDenominatorUnit,
		>,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorLeftQuantity>,
	RightNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightNumeratorRightUnit : AbstractScientificUnit<RightNumeratorRightQuantity>,
	WrappedRightNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	RightNumeratorRightQuantity,
	RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftDenominatorAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			RightNumeratorRightQuantity,
			>,
		WrappedRightNumeratorRightUnit,
		>,
	RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorAndRightNumeratorLeftQuantity,
			UndefinedQuantityType.Extended<
				RightNumeratorRightQuantity,
				>,
			>,
		RightNumeratorUnit,
		LeftNumeratorAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorAndRightDenominatorQuantity,
		LeftDenominatorAndRightNumeratorLeftQuantity,
		>,
LeftUnit,
	>.genericMultipliedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftDenominatorAndRightNumeratorLeftQuantity,
			UndefinedQuantityType.Extended<
				RightNumeratorRightQuantity,
				>,
			>,
		LeftNumeratorAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) =
	multipliedBy(right) {
		value: Decimal,
		unit: RightNumeratorRightUnit,
		->
		DefaultScientificValue(value, unit)
	}
