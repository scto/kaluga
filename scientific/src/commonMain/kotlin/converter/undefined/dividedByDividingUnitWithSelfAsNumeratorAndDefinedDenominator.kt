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
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// A / Div<A, Wr<B>> -> B!

@JvmName("dividedByDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
fun <
	NumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit : ScientificUnit<DenominatorDenominatorQuantity>,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		WrappedDenominatorDenominatorUnit,
		>,
	DenominatorDenominatorValue : ScientificValue<DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorQuantity,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
	factory: (Decimal, DenominatorDenominatorUnit) -> DenominatorDenominatorValue,
) = right.unit.denominator.wrapped.byDividing(this, right, factory)

@JvmName("metricAndImperialDividedByMetricAndImperialDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorQuantity,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
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
		NumeratorAndDenominatorNumeratorQuantity,
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

@JvmName("metricDividedByMetricDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorQuantity,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : DefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorAndDenominatorNumeratorQuantity,
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

@JvmName("imperialDividedByImperialDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorQuantity,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
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
		NumeratorAndDenominatorNumeratorQuantity,
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

@JvmName("ukImperialDividedByUKImperialDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorQuantity,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : DefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorAndDenominatorNumeratorQuantity,
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

@JvmName("usCustomaryDividedByUSCustomaryDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorQuantity,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : DefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorAndDenominatorNumeratorQuantity,
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

@JvmName("metricAndUKImperialDividedByMetricAndUKImperialDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorQuantity,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
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
		NumeratorAndDenominatorNumeratorQuantity,
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

@JvmName("metricAndUSCustomaryDividedByMetricAndUSCustomaryDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorQuantity,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
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
		NumeratorAndDenominatorNumeratorQuantity,
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

@JvmName("genericDividedByGenericDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit : DefinedScientificUnit<DenominatorDenominatorQuantity>,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		WrappedDenominatorDenominatorUnit,
		>,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorQuantity,
NumeratorUnit,
	>.genericDividedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorAndDenominatorNumeratorQuantity,
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
