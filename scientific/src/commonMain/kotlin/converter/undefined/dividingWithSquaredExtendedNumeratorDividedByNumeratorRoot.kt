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
import com.splendo.kaluga.scientific.unit.UndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// Div<Mul<Ex<A>, Ex<A>>, B> / A! -> Div<Ex<A>, B>

@JvmName("dividingWithSquaredExtendedNumeratorDividedByNumeratorRoot")
fun <
	ExtendedNumeratorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorRightUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
		>,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorRightUnit,
		>,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorNumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit : ScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorQuantity>,
	TargetUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorLeftUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: ScientificValue<NumeratorNumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
	extendedNumeratorNumeratorLeftUnitPerNumeratorDenominatorUnit: ExtendedNumeratorNumeratorLeftUnit.(NumeratorDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.left.extendedNumeratorNumeratorLeftUnitPerNumeratorDenominatorUnit(
	unit.denominator,
).byDividing(this, right, factory)

@JvmName("metricAndImperialDividingWithSquaredExtendedNumeratorDividedByMetricAndImperialNumeratorRoot")
infix fun <
	ExtendedNumeratorNumeratorLeftUnit,
	ExtendedNumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	NumeratorNumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: ScientificValue<NumeratorNumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedNumeratorNumeratorRightUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	ExtendedNumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedNumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : DefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		extendedNumeratorNumeratorLeftUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				UndefinedQuantityType.Extended<
					NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
					>,
				ExtendedNumeratorNumeratorLeftUnit,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingWithSquaredExtendedNumeratorDividedByMetricNumeratorRoot")
infix fun <
	ExtendedNumeratorNumeratorLeftUnit,
	ExtendedNumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	NumeratorNumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: ScientificValue<NumeratorNumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedNumeratorNumeratorRightUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : DefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		extendedNumeratorNumeratorLeftUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				UndefinedQuantityType.Extended<
					NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
					>,
				ExtendedNumeratorNumeratorLeftUnit,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingWithSquaredExtendedNumeratorDividedByImperialNumeratorRoot")
infix fun <
	ExtendedNumeratorNumeratorLeftUnit,
	ExtendedNumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	NumeratorNumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: ScientificValue<NumeratorNumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedNumeratorNumeratorRightUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedNumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : DefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		extendedNumeratorNumeratorLeftUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				UndefinedQuantityType.Extended<
					NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
					>,
				ExtendedNumeratorNumeratorLeftUnit,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithSquaredExtendedNumeratorDividedByUKImperialNumeratorRoot")
infix fun <
	ExtendedNumeratorNumeratorLeftUnit,
	ExtendedNumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	NumeratorNumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: ScientificValue<NumeratorNumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedNumeratorNumeratorRightUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : DefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		extendedNumeratorNumeratorLeftUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				UndefinedQuantityType.Extended<
					NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
					>,
				ExtendedNumeratorNumeratorLeftUnit,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithSquaredExtendedNumeratorDividedByUSCustomaryNumeratorRoot")
infix fun <
	ExtendedNumeratorNumeratorLeftUnit,
	ExtendedNumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	NumeratorNumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: ScientificValue<NumeratorNumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedNumeratorNumeratorRightUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : DefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		extendedNumeratorNumeratorLeftUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				UndefinedQuantityType.Extended<
					NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
					>,
				ExtendedNumeratorNumeratorLeftUnit,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithSquaredExtendedNumeratorDividedByMetricAndUKImperialNumeratorRoot")
infix fun <
	ExtendedNumeratorNumeratorLeftUnit,
	ExtendedNumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	NumeratorNumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: ScientificValue<NumeratorNumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedNumeratorNumeratorRightUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	ExtendedNumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : DefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		extendedNumeratorNumeratorLeftUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				UndefinedQuantityType.Extended<
					NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
					>,
				ExtendedNumeratorNumeratorLeftUnit,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithSquaredExtendedNumeratorDividedByMetricAndUSCustomaryNumeratorRoot")
infix fun <
	ExtendedNumeratorNumeratorLeftUnit,
	ExtendedNumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	NumeratorNumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: ScientificValue<NumeratorNumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedNumeratorNumeratorRightUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	ExtendedNumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
				>,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : DefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		extendedNumeratorNumeratorLeftUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				UndefinedQuantityType.Extended<
					NumeratorNumeratorLeftAndRightAndDenominatorQuantity,
					>,
				ExtendedNumeratorNumeratorLeftUnit,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
