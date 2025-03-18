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
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Mul<Wr<A>, Wr<B>> / B! -> A!

@JvmName("multiplyingWithDefinedLeftAndDefinedRightDividedByRight")
fun <
	NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit : ScientificUnit<NumeratorLeftQuantity>,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftQuantity,
	NumeratorLeftUnit,
		>,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightUnit : ScientificUnit<NumeratorRightAndDenominatorQuantity>,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorRightAndDenominatorQuantity,
	NumeratorRightUnit,
		>,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorRightAndDenominatorQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	DenominatorUnit : ScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorLeftValue : ScientificValue<NumeratorLeftQuantity, NumeratorLeftUnit>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorRightAndDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.dividedBy(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, DenominatorUnit>,
	factory: (Decimal, NumeratorLeftUnit) -> NumeratorLeftValue,
) = unit.left.wrapped.byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingWithDefinedLeftAndDefinedRightDividedByMetricAndImperialRight")
infix fun <
	NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorRightAndDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorRightAndDenominatorQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorRightAndDenominatorQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricMultiplyingWithDefinedLeftAndDefinedRightDividedByMetricRight")
infix fun <
	NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorRightAndDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorRightAndDenominatorQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorRightAndDenominatorQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialMultiplyingWithDefinedLeftAndDefinedRightDividedByImperialRight")
infix fun <
	NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorRightAndDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorRightAndDenominatorQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorRightAndDenominatorQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialMultiplyingWithDefinedLeftAndDefinedRightDividedByUKImperialRight")
infix fun <
	NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorRightAndDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorRightAndDenominatorQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorRightAndDenominatorQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryMultiplyingWithDefinedLeftAndDefinedRightDividedByUSCustomaryRight")
infix fun <
	NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorRightAndDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorRightAndDenominatorQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorRightAndDenominatorQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultiplyingWithDefinedLeftAndDefinedRightDividedByMetricAndUKImperialRight")
infix fun <
	NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorRightAndDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorRightAndDenominatorQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorRightAndDenominatorQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultiplyingWithDefinedLeftAndDefinedRightDividedByMetricAndUSCustomaryRight")
infix fun <
	NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorRightAndDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorRightAndDenominatorQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorRightAndDenominatorQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericMultiplyingWithDefinedLeftAndDefinedRightDividedByGenericRight")
infix fun <
	NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftQuantity,
	NumeratorLeftUnit,
		>,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorRightAndDenominatorQuantity,
	NumeratorRightUnit,
		>,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorRightAndDenominatorQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	DenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorRightAndDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.genericDividedByGeneric(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, DenominatorUnit>,
) =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}
