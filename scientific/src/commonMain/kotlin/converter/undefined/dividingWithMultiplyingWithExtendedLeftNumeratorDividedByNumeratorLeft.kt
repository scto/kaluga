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

// Div<Mul<Ex<A>, B>, C> / A! -> Div<B, C>

@JvmName("dividingWithMultiplyingWithExtendedLeftNumeratorDividedByNumeratorLeft")
fun <
	ExtendedNumeratorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndDenominatorQuantity,
		>,
	NumeratorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndDenominatorQuantity,
				>,
			NumeratorNumeratorRightQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorNumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit : ScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
	TargetUnit : UndefinedDividedUnit<
		NumeratorNumeratorRightQuantity,
		NumeratorNumeratorRightUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorRightQuantity,
		NumeratorDenominatorQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndDenominatorQuantity,
				>,
			NumeratorNumeratorRightQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: ScientificValue<NumeratorNumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
	numeratorNumeratorRightUnitPerNumeratorDenominatorUnit: NumeratorNumeratorRightUnit.(NumeratorDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.right.numeratorNumeratorRightUnitPerNumeratorDenominatorUnit(
	unit.denominator,
).byDividing(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingWithExtendedLeftNumeratorDividedByMetricAndImperialNumeratorLeft")
infix fun <
	ExtendedNumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	NumeratorNumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndDenominatorQuantity,
				>,
			NumeratorNumeratorRightQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: ScientificValue<NumeratorNumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightQuantity,
		NumeratorNumeratorRightUnit,
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
				NumeratorNumeratorLeftAndDenominatorQuantity,
				>,
			NumeratorNumeratorRightQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : DefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorRightUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				NumeratorNumeratorRightQuantity,
				NumeratorNumeratorRightUnit,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingWithMultiplyingWithExtendedLeftNumeratorDividedByMetricNumeratorLeft")
infix fun <
	ExtendedNumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	NumeratorNumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndDenominatorQuantity,
				>,
			NumeratorNumeratorRightQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: ScientificValue<NumeratorNumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndDenominatorQuantity,
				>,
			NumeratorNumeratorRightQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : DefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		numeratorNumeratorRightUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				NumeratorNumeratorRightQuantity,
				NumeratorNumeratorRightUnit,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingWithMultiplyingWithExtendedLeftNumeratorDividedByImperialNumeratorLeft")
infix fun <
	ExtendedNumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	NumeratorNumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndDenominatorQuantity,
				>,
			NumeratorNumeratorRightQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: ScientificValue<NumeratorNumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndDenominatorQuantity,
				>,
			NumeratorNumeratorRightQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : DefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorRightUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				NumeratorNumeratorRightQuantity,
				NumeratorNumeratorRightUnit,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithMultiplyingWithExtendedLeftNumeratorDividedByUKImperialNumeratorLeft")
infix fun <
	ExtendedNumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	NumeratorNumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndDenominatorQuantity,
				>,
			NumeratorNumeratorRightQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: ScientificValue<NumeratorNumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndDenominatorQuantity,
				>,
			NumeratorNumeratorRightQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : DefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorNumeratorRightUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				NumeratorNumeratorRightQuantity,
				NumeratorNumeratorRightUnit,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithMultiplyingWithExtendedLeftNumeratorDividedByUSCustomaryNumeratorLeft")
infix fun <
	ExtendedNumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	NumeratorNumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndDenominatorQuantity,
				>,
			NumeratorNumeratorRightQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: ScientificValue<NumeratorNumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndDenominatorQuantity,
				>,
			NumeratorNumeratorRightQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : DefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorRightUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				NumeratorNumeratorRightQuantity,
				NumeratorNumeratorRightUnit,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithMultiplyingWithExtendedLeftNumeratorDividedByMetricAndUKImperialNumeratorLeft")
infix fun <
	ExtendedNumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	NumeratorNumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndDenominatorQuantity,
				>,
			NumeratorNumeratorRightQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: ScientificValue<NumeratorNumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndDenominatorQuantity,
				>,
			NumeratorNumeratorRightQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : DefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorNumeratorRightUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				NumeratorNumeratorRightQuantity,
				NumeratorNumeratorRightUnit,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithMultiplyingWithExtendedLeftNumeratorDividedByMetricAndUSCustomaryNumeratorLeft")
infix fun <
	ExtendedNumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	NumeratorNumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndDenominatorQuantity,
				>,
			NumeratorNumeratorRightQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: ScientificValue<NumeratorNumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorNumeratorLeftAndDenominatorQuantity,
		>,
	ExtendedNumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedNumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorLeftAndDenominatorQuantity,
			>,
		ExtendedNumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorNumeratorLeftAndDenominatorQuantity,
				>,
			NumeratorNumeratorRightQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : DefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorRightUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				NumeratorNumeratorRightQuantity,
				NumeratorNumeratorRightUnit,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
