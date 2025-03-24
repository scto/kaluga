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
import com.splendo.kaluga.scientific.unit.DefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Mul<Wr<A>, Wr<A>> / A! -> A!

@JvmName("squaredDefinedDividedByRoot")
fun <
	NumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit : ScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndRightAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	NumeratorRightUnit : ScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndRightAndDenominatorQuantity,
	NumeratorRightUnit,
		>,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	DenominatorUnit : ScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorLeftValue : ScientificValue<NumeratorLeftAndRightAndDenominatorQuantity, NumeratorLeftUnit>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.dividedBy(
	right: ScientificValue<NumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
	factory: (Decimal, NumeratorLeftUnit) -> NumeratorLeftValue,
) = unit.left.wrapped.byDividing(this, right, factory)

@JvmName("metricAndImperialSquaredDefinedDividedByMetricAndImperialRoot")
infix fun <
	NumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: ScientificValue<NumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndRightAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndRightAndDenominatorQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricSquaredDefinedDividedByMetricRoot")
infix fun <
	NumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: ScientificValue<NumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndRightAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndRightAndDenominatorQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialSquaredDefinedDividedByImperialRoot")
infix fun <
	NumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: ScientificValue<NumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndRightAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndRightAndDenominatorQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialSquaredDefinedDividedByUKImperialRoot")
infix fun <
	NumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: ScientificValue<NumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndRightAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndRightAndDenominatorQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomarySquaredDefinedDividedByUSCustomaryRoot")
infix fun <
	NumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: ScientificValue<NumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndRightAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndRightAndDenominatorQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialSquaredDefinedDividedByMetricAndUKImperialRoot")
infix fun <
	NumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: ScientificValue<NumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndRightAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndRightAndDenominatorQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomarySquaredDefinedDividedByMetricAndUSCustomaryRoot")
infix fun <
	NumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightUnit,
	WrappedNumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: ScientificValue<NumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndRightAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndRightAndDenominatorQuantity,
	NumeratorRightUnit,
		>,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericSquaredDefinedDividedByGenericRoot")
infix fun <
	NumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndRightAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	NumeratorRightUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndRightAndDenominatorQuantity,
	NumeratorRightUnit,
		>,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		WrappedNumeratorRightUnit,
		>,
	DenominatorUnit : DefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.genericDividedByGeneric(
	right: ScientificValue<NumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}
