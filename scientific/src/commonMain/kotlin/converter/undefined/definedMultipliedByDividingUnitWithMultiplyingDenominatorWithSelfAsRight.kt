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
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.DefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// A! * Div<B, Mul<C, Ex<A>>> -> Div<B, C>

@JvmName("definedMultipliedByDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
fun <
	LeftAndRightDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit : ScientificUnit<LeftAndRightDenominatorRightQuantity>,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
	ExtendedRightDenominatorRightUnit : UndefinedExtendedUnit<
		LeftAndRightDenominatorRightQuantity,
		>,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorRightQuantity,
			>,
		ExtendedRightDenominatorRightUnit,
		>,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorRightQuantity,
				>,
			>,
		RightDenominatorUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		RightDenominatorLeftQuantity,
		>,
TargetUnit,
	>,
	> ScientificValue<LeftAndRightDenominatorRightQuantity, LeftUnit>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorRightQuantity,
				>,
			>,
		>,
RightUnit,
	>,
	rightNumeratorUnitPerRightDenominatorLeftUnit: RightNumeratorUnit.(RightDenominatorLeftUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.numerator.rightNumeratorUnitPerRightDenominatorLeftUnit(
	right.unit.denominator.left,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDefinedMultipliedByMetricAndImperialDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
	LeftAndRightDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	ExtendedRightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorRightQuantity, LeftUnit>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorRightQuantity,
				>,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorRightQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedRightDenominatorRightUnit : UndefinedExtendedUnit<
		LeftAndRightDenominatorRightQuantity,
		>,
	ExtendedRightDenominatorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorRightQuantity,
			>,
		>,
	ExtendedRightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	ExtendedRightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedRightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorRightQuantity,
			>,
		ExtendedRightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorRightQuantity,
				>,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDefinedMultipliedByMetricDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
	LeftAndRightDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	ExtendedRightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorRightQuantity, LeftUnit>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorRightQuantity,
				>,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorRightQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedRightDenominatorRightUnit : UndefinedExtendedUnit<
		LeftAndRightDenominatorRightQuantity,
		>,
	ExtendedRightDenominatorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorRightQuantity,
			>,
		>,
	ExtendedRightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorRightQuantity,
			>,
		ExtendedRightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorRightQuantity,
				>,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		rightNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDefinedMultipliedByImperialDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
	LeftAndRightDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	ExtendedRightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorRightQuantity, LeftUnit>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorRightQuantity,
				>,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorRightQuantity>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedRightDenominatorRightUnit : UndefinedExtendedUnit<
		LeftAndRightDenominatorRightQuantity,
		>,
	ExtendedRightDenominatorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorRightQuantity,
			>,
		>,
	ExtendedRightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedRightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorRightQuantity,
			>,
		ExtendedRightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorRightQuantity,
				>,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDefinedMultipliedByUKImperialDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
	LeftAndRightDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	ExtendedRightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorRightQuantity, LeftUnit>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorRightQuantity,
				>,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorRightQuantity>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedRightDenominatorRightUnit : UndefinedExtendedUnit<
		LeftAndRightDenominatorRightQuantity,
		>,
	ExtendedRightDenominatorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorRightQuantity,
			>,
		>,
	ExtendedRightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorRightQuantity,
			>,
		ExtendedRightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorRightQuantity,
				>,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		rightNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDefinedMultipliedByUSCustomaryDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
	LeftAndRightDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	ExtendedRightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorRightQuantity, LeftUnit>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorRightQuantity,
				>,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorRightQuantity>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedRightDenominatorRightUnit : UndefinedExtendedUnit<
		LeftAndRightDenominatorRightQuantity,
		>,
	ExtendedRightDenominatorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorRightQuantity,
			>,
		>,
	ExtendedRightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorRightQuantity,
			>,
		ExtendedRightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorRightQuantity,
				>,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDefinedMultipliedByMetricAndUKImperialDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
	LeftAndRightDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	ExtendedRightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorRightQuantity, LeftUnit>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorRightQuantity,
				>,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorRightQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedRightDenominatorRightUnit : UndefinedExtendedUnit<
		LeftAndRightDenominatorRightQuantity,
		>,
	ExtendedRightDenominatorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorRightQuantity,
			>,
		>,
	ExtendedRightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	ExtendedRightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorRightQuantity,
			>,
		ExtendedRightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorRightQuantity,
				>,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		rightNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDefinedMultipliedByMetricAndUSCustomaryDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
	LeftAndRightDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	ExtendedRightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorRightQuantity, LeftUnit>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorRightQuantity,
				>,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorRightQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedRightDenominatorRightUnit : UndefinedExtendedUnit<
		LeftAndRightDenominatorRightQuantity,
		>,
	ExtendedRightDenominatorRightUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorRightQuantity,
			>,
		>,
	ExtendedRightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	ExtendedRightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorRightQuantity,
			>,
		ExtendedRightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorRightQuantity,
				>,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
