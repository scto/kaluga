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
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// A! / Div<Wr<A>, Wr<B>> -> B!

@JvmName("definedDividedByDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
fun <
	NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit : ScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : ScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	WrappedDenominatorNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorNumeratorQuantity,
	DenominatorNumeratorUnit,
		>,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit : ScientificUnit<DenominatorDenominatorQuantity>,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorQuantity,
			>,
		WrappedDenominatorNumeratorUnit,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		WrappedDenominatorDenominatorUnit,
		>,
	DenominatorDenominatorValue : ScientificValue<DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
	> ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorUnit>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
	factory: (Decimal, DenominatorDenominatorUnit) -> DenominatorDenominatorValue,
) = right.unit.denominator.wrapped.byDividing(this, right, factory)

@JvmName("metricAndImperialDefinedDividedByMetricAndImperialDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	WrappedDenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorUnit>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorNumeratorQuantity,
	DenominatorNumeratorUnit,
		>,
	WrappedDenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractScientificUnit<DenominatorDenominatorQuantity>,
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
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorQuantity,
			>,
		WrappedDenominatorNumeratorUnit,
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

@JvmName("metricDefinedDividedByMetricDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	WrappedDenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorUnit>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorNumeratorQuantity,
	DenominatorNumeratorUnit,
		>,
	WrappedDenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : AbstractScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorQuantity,
			>,
		WrappedDenominatorNumeratorUnit,
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

@JvmName("imperialDefinedDividedByImperialDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	WrappedDenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorUnit>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorNumeratorQuantity,
	DenominatorNumeratorUnit,
		>,
	WrappedDenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorQuantity,
			>,
		WrappedDenominatorNumeratorUnit,
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

@JvmName("ukImperialDefinedDividedByUKImperialDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	WrappedDenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorUnit>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorNumeratorQuantity,
	DenominatorNumeratorUnit,
		>,
	WrappedDenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorQuantity,
			>,
		WrappedDenominatorNumeratorUnit,
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

@JvmName("usCustomaryDefinedDividedByUSCustomaryDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	WrappedDenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorUnit>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorNumeratorQuantity,
	DenominatorNumeratorUnit,
		>,
	WrappedDenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorQuantity,
			>,
		WrappedDenominatorNumeratorUnit,
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

@JvmName("metricAndUKImperialDefinedDividedByMetricAndUKImperialDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	WrappedDenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorUnit>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorNumeratorQuantity,
	DenominatorNumeratorUnit,
		>,
	WrappedDenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorQuantity,
			>,
		WrappedDenominatorNumeratorUnit,
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

@JvmName("metricAndUSCustomaryDefinedDividedByMetricAndUSCustomaryDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	WrappedDenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit,
	WrappedDenominatorDenominatorUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorUnit>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorQuantity,
			>,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorNumeratorQuantity,
	DenominatorNumeratorUnit,
		>,
	WrappedDenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorQuantity,
			>,
		WrappedDenominatorNumeratorUnit,
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

@JvmName("genericDefinedDividedByGenericDividingUnitWithSelfAsNumeratorAndDefinedDenominator")
infix fun <
	NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
	WrappedDenominatorNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorNumeratorQuantity,
	DenominatorNumeratorUnit,
		>,
	DenominatorDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorDenominatorUnit : AbstractScientificUnit<DenominatorDenominatorQuantity>,
	WrappedDenominatorDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorDenominatorQuantity,
	DenominatorDenominatorUnit,
		>,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorQuantity,
			>,
		WrappedDenominatorNumeratorUnit,
		UndefinedQuantityType.Extended<
			DenominatorDenominatorQuantity,
			>,
		WrappedDenominatorDenominatorUnit,
		>,
	> ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorUnit>.genericDividedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorQuantity,
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
