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
import com.splendo.kaluga.scientific.DefaultUndefinedScientificValue
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

// A! / Div<Mul<Ex<A>, Ex<A>>, B> -> Div<B, Ex<A>>

@JvmName("definedDividedByDividingUnitWithSquaredNumeratorWithSelfAsRoot")
fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit : ScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	ExtendedDenominatorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		>,
	ExtendedDenominatorNumeratorRightUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		ExtendedDenominatorNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		ExtendedDenominatorNumeratorRightUnit,
		>,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		ExtendedDenominatorNumeratorLeftUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorDenominatorQuantity,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		>,
TargetUnit,
	>,
	> ScientificValue<NumeratorAndDenominatorNumeratorLeftAndRightQuantity, NumeratorUnit>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
	denominatorDenominatorUnitPerExtendedDenominatorNumeratorLeftUnit: DenominatorDenominatorUnit.(ExtendedDenominatorNumeratorLeftUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.denominator.denominatorDenominatorUnitPerExtendedDenominatorNumeratorLeftUnit(
	right.unit.numerator.left,
).byDividing(this, right, factory)

@JvmName("metricAndImperialDefinedDividedByMetricAndImperialDividingUnitWithSquaredNumeratorWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	ExtendedDenominatorNumeratorLeftUnit,
	ExtendedDenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorNumeratorLeftAndRightQuantity, NumeratorUnit>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedDenominatorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		>,
	ExtendedDenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedDenominatorNumeratorRightUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		>,
	ExtendedDenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		ExtendedDenominatorNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		ExtendedDenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorUnitPerExtendedDenominatorNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				UndefinedQuantityType.Extended<
					NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
					>,
				ExtendedDenominatorNumeratorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDefinedDividedByMetricDividingUnitWithSquaredNumeratorWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	ExtendedDenominatorNumeratorLeftUnit,
	ExtendedDenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorNumeratorLeftAndRightQuantity, NumeratorUnit>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	ExtendedDenominatorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		>,
	ExtendedDenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedDenominatorNumeratorRightUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		>,
	ExtendedDenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		ExtendedDenominatorNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		ExtendedDenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		denominatorDenominatorUnitPerExtendedDenominatorNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				UndefinedQuantityType.Extended<
					NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
					>,
				ExtendedDenominatorNumeratorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDefinedDividedByImperialDividingUnitWithSquaredNumeratorWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	ExtendedDenominatorNumeratorLeftUnit,
	ExtendedDenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorNumeratorLeftAndRightQuantity, NumeratorUnit>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedDenominatorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		>,
	ExtendedDenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedDenominatorNumeratorRightUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		>,
	ExtendedDenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		ExtendedDenominatorNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		ExtendedDenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorUnitPerExtendedDenominatorNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				UndefinedQuantityType.Extended<
					NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
					>,
				ExtendedDenominatorNumeratorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDefinedDividedByUKImperialDividingUnitWithSquaredNumeratorWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	ExtendedDenominatorNumeratorLeftUnit,
	ExtendedDenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorNumeratorLeftAndRightQuantity, NumeratorUnit>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedDenominatorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		>,
	ExtendedDenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedDenominatorNumeratorRightUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		>,
	ExtendedDenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		ExtendedDenominatorNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		ExtendedDenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		denominatorDenominatorUnitPerExtendedDenominatorNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				UndefinedQuantityType.Extended<
					NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
					>,
				ExtendedDenominatorNumeratorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDefinedDividedByUSCustomaryDividingUnitWithSquaredNumeratorWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	ExtendedDenominatorNumeratorLeftUnit,
	ExtendedDenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorNumeratorLeftAndRightQuantity, NumeratorUnit>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedDenominatorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		>,
	ExtendedDenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedDenominatorNumeratorRightUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		>,
	ExtendedDenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		ExtendedDenominatorNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		ExtendedDenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorUnitPerExtendedDenominatorNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				UndefinedQuantityType.Extended<
					NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
					>,
				ExtendedDenominatorNumeratorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDefinedDividedByMetricAndUKImperialDividingUnitWithSquaredNumeratorWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	ExtendedDenominatorNumeratorLeftUnit,
	ExtendedDenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorNumeratorLeftAndRightQuantity, NumeratorUnit>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedDenominatorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		>,
	ExtendedDenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedDenominatorNumeratorRightUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		>,
	ExtendedDenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		ExtendedDenominatorNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		ExtendedDenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		denominatorDenominatorUnitPerExtendedDenominatorNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				UndefinedQuantityType.Extended<
					NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
					>,
				ExtendedDenominatorNumeratorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDefinedDividedByMetricAndUSCustomaryDividingUnitWithSquaredNumeratorWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	ExtendedDenominatorNumeratorLeftUnit,
	ExtendedDenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorNumeratorLeftAndRightQuantity, NumeratorUnit>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedDenominatorNumeratorLeftUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		>,
	ExtendedDenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedDenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedDenominatorNumeratorRightUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		>,
	ExtendedDenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		ExtendedDenominatorNumeratorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		ExtendedDenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				>,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorUnitPerExtendedDenominatorNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				UndefinedQuantityType.Extended<
					NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
					>,
				ExtendedDenominatorNumeratorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
