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
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// A! / Mul<B, Wr<A>> -> Inv<B>

@JvmName("definedDividedByMultiplyingUnitWithSelfAsRight")
fun <
	NumeratorAndDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit : ScientificUnit<NumeratorAndDenominatorRightQuantity>,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorRightUnit : ScientificUnit<NumeratorAndDenominatorRightQuantity>,
	WrappedDenominatorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorRightQuantity,
	DenominatorRightUnit,
		>,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorRightQuantity,
			>,
		WrappedDenominatorRightUnit,
		>,
	TargetUnit : UndefinedReciprocalUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		DenominatorLeftQuantity,
		>,
TargetUnit,
	>,
	> ScientificValue<NumeratorAndDenominatorRightQuantity, NumeratorUnit>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
	reciprocalTargetUnit: DenominatorLeftUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.left.reciprocalTargetUnit().byDividing(this, right, factory)

@JvmName("metricAndImperialDefinedDividedByMetricAndImperialMultiplyingUnitWithSelfAsRight")
infix fun <
	NumeratorAndDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	WrappedDenominatorRightUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorRightQuantity, NumeratorUnit>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : DefinedScientificUnit<NumeratorAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorRightQuantity,
	DenominatorRightUnit,
		>,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorRightQuantity,
			>,
		WrappedDenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndImperial<
							DenominatorLeftQuantity,
							DenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDefinedDividedByMetricMultiplyingUnitWithSelfAsRight")
infix fun <
	NumeratorAndDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	WrappedDenominatorRightUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorRightQuantity, NumeratorUnit>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : DefinedScientificUnit<NumeratorAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorRightQuantity,
	DenominatorRightUnit,
		>,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorRightQuantity,
			>,
		WrappedDenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Metric<
							DenominatorLeftQuantity,
							DenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDefinedDividedByImperialMultiplyingUnitWithSelfAsRight")
infix fun <
	NumeratorAndDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	WrappedDenominatorRightUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorRightQuantity, NumeratorUnit>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : DefinedScientificUnit<NumeratorAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorRightQuantity,
	DenominatorRightUnit,
		>,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorRightQuantity,
			>,
		WrappedDenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Imperial<
							DenominatorLeftQuantity,
							DenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDefinedDividedByUKImperialMultiplyingUnitWithSelfAsRight")
infix fun <
	NumeratorAndDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	WrappedDenominatorRightUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorRightQuantity, NumeratorUnit>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : DefinedScientificUnit<NumeratorAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorRightQuantity,
	DenominatorRightUnit,
		>,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorRightQuantity,
			>,
		WrappedDenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.UKImperial<
							DenominatorLeftQuantity,
							DenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDefinedDividedByUSCustomaryMultiplyingUnitWithSelfAsRight")
infix fun <
	NumeratorAndDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	WrappedDenominatorRightUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorRightQuantity, NumeratorUnit>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : DefinedScientificUnit<NumeratorAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorRightQuantity,
	DenominatorRightUnit,
		>,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorRightQuantity,
			>,
		WrappedDenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.USCustomary<
							DenominatorLeftQuantity,
							DenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDefinedDividedByMetricAndUKImperialMultiplyingUnitWithSelfAsRight")
infix fun <
	NumeratorAndDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	WrappedDenominatorRightUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorRightQuantity, NumeratorUnit>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : DefinedScientificUnit<NumeratorAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorRightQuantity,
	DenominatorRightUnit,
		>,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorRightQuantity,
			>,
		WrappedDenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUKImperial<
							DenominatorLeftQuantity,
							DenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDefinedDividedByMetricAndUSCustomaryMultiplyingUnitWithSelfAsRight")
infix fun <
	NumeratorAndDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	WrappedDenominatorRightUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorRightQuantity, NumeratorUnit>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : DefinedScientificUnit<NumeratorAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorRightQuantity,
	DenominatorRightUnit,
		>,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorRightQuantity,
			>,
		WrappedDenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
							DenominatorLeftQuantity,
							DenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
