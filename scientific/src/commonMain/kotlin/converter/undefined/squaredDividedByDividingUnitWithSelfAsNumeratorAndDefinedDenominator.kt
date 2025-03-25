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

// Mul<A, A> / Div<Mul<A, A>, Wr<B>> -> B!

@JvmName("squaredDividedByDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
fun <
	NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorRightUnit,
		>,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
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
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
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
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
	factory: (Decimal, DenominatorDenominatorUnit) -> DenominatorDenominatorValue,
) = right.unit.denominator.wrapped.byDividing(this, right, factory)

@JvmName("metricAndImperialSquaredDividedByMetricAndImperialDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
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
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
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
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
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

@JvmName("metricSquaredDividedByMetricDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
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
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
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
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
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

@JvmName("imperialSquaredDividedByImperialDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
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
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
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
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
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

@JvmName("ukImperialSquaredDividedByUKImperialDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
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
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
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
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
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

@JvmName("usCustomarySquaredDividedByUSCustomaryDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
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
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
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
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
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

@JvmName("metricAndUKImperialSquaredDividedByMetricAndUKImperialDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
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
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
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
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
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

@JvmName("metricAndUSCustomarySquaredDividedByMetricAndUSCustomaryDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
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
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
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
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
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

@JvmName("genericSquaredDividedByGenericDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorRightUnit,
		>,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
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
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		WrappedDenominatorDenominatorUnit,
		>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.genericDividedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
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
