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

// Mul<Wr<A>, Wr<B>> / A! -> B!

@JvmName("multiplyingWithDefinedLeftAndDefinedRightDividedByLeft")
fun <
	NumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit : ScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	NumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightUnit : ScientificUnit<NumeratorRightQuantity>,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorRightQuantity,
	NumeratorRightUnit,
		>,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorRightQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	DenominatorUnit : ScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	NumeratorRightValue : ScientificValue<NumeratorRightQuantity, NumeratorRightUnit>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorRightQuantity,
			>,
		>,
NumeratorUnit,
	>.dividedBy(
	right: ScientificValue<NumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
	factory: (Decimal, NumeratorRightUnit) -> NumeratorRightValue,
) = unit.right.wrapped.byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingWithDefinedLeftAndDefinedRightDividedByMetricAndImperialLeft")
infix fun <
	NumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorRightQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: ScientificValue<NumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorRightQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorRightQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricMultiplyingWithDefinedLeftAndDefinedRightDividedByMetricLeft")
infix fun <
	NumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorRightQuantity,
			>,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: ScientificValue<NumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : AbstractScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorRightQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorRightQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialMultiplyingWithDefinedLeftAndDefinedRightDividedByImperialLeft")
infix fun <
	NumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorRightQuantity,
			>,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: ScientificValue<NumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorRightQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorRightQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialMultiplyingWithDefinedLeftAndDefinedRightDividedByUKImperialLeft")
infix fun <
	NumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorRightQuantity,
			>,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: ScientificValue<NumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorRightQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorRightQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryMultiplyingWithDefinedLeftAndDefinedRightDividedByUSCustomaryLeft")
infix fun <
	NumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorRightQuantity,
			>,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: ScientificValue<NumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorRightQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorRightQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultiplyingWithDefinedLeftAndDefinedRightDividedByMetricAndUKImperialLeft")
infix fun <
	NumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorRightQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: ScientificValue<NumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorRightQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorRightQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultiplyingWithDefinedLeftAndDefinedRightDividedByMetricAndUSCustomaryLeft")
infix fun <
	NumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorRightQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: ScientificValue<NumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorRightQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorRightQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericMultiplyingWithDefinedLeftAndDefinedRightDividedByGenericLeft")
infix fun <
	NumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	NumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightUnit : AbstractScientificUnit<NumeratorRightQuantity>,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorRightQuantity,
	NumeratorRightUnit,
		>,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorRightQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorRightQuantity,
			>,
		>,
NumeratorUnit,
	>.genericDividedByGeneric(
	right: ScientificValue<NumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorRightUnit,
		->
		DefaultScientificValue(value, unit)
	}
