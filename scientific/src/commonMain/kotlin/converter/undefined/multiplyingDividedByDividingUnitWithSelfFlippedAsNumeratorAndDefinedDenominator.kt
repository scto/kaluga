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
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.DefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Mul<A, B> / Div<Mul<B, A>, Wr<C>> -> C!

@JvmName("multiplyingDividedByDividingUnitWithSelfFlippedAsNumeratorAndDefinedDenominator")
fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorRightUnit,
		>,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit : ScientificUnit<DenominatorDenominatorQuantity>,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		WrappedDenominatorDenominatorUnit,
		>,
	DenominatorDenominatorValue : ScientificValue<DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
	factory: (Decimal, DenominatorDenominatorUnit) -> DenominatorDenominatorValue,
) = right.unit.denominator.wrapped.byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingDividedByMetricAndImperialDividingUnitWithSelfFlippedAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : DefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		WrappedDenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorDenominatorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricMultiplyingDividedByMetricDividingUnitWithSelfFlippedAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : DefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		WrappedDenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorDenominatorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialMultiplyingDividedByImperialDividingUnitWithSelfFlippedAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : DefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		WrappedDenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorDenominatorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialMultiplyingDividedByUKImperialDividingUnitWithSelfFlippedAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : DefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		WrappedDenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorDenominatorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryMultiplyingDividedByUSCustomaryDividingUnitWithSelfFlippedAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : DefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		WrappedDenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorDenominatorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultiplyingDividedByMetricAndUKImperialDividingUnitWithSelfFlippedAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : DefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		WrappedDenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorDenominatorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultiplyingDividedByMetricAndUSCustomaryDividingUnitWithSelfFlippedAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : DefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		WrappedDenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorDenominatorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericMultiplyingDividedByGenericDividingUnitWithSelfFlippedAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorRightUnit,
		>,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit : DefinedScientificUnit<DenominatorDenominatorQuantity>,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		WrappedDenominatorDenominatorUnit,
		>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		>,
NumeratorUnit,
	>.genericDividedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorDenominatorUnit,
		->
		DefaultScientificValue(value, unit)
	}
