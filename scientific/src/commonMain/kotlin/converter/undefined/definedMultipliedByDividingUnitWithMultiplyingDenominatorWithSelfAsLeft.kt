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

// A! * Div<B, Mul<Ex<A>, C>> -> Div<B, C>

@JvmName("definedMultipliedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
fun <
	LeftAndRightDenominatorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit : ScientificUnit<LeftAndRightDenominatorLeftQuantity>,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	ExtendedRightDenominatorLeftUnit : UndefinedExtendedUnit<
		LeftAndRightDenominatorLeftQuantity,
		>,
	RightDenominatorRightQuantity : UndefinedQuantityType,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<RightDenominatorRightQuantity>,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorLeftQuantity,
			>,
		ExtendedRightDenominatorLeftUnit,
		RightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorLeftQuantity,
				>,
			RightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		RightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		RightDenominatorRightQuantity,
		>,
TargetUnit,
	>,
	> ScientificValue<LeftAndRightDenominatorLeftQuantity, LeftUnit>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorLeftQuantity,
				>,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
	rightNumeratorUnitPerRightDenominatorRightUnit: RightNumeratorUnit.(RightDenominatorRightUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.numerator.rightNumeratorUnitPerRightDenominatorRightUnit(
	right.unit.denominator.right,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDefinedMultipliedByMetricAndImperialDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
	LeftAndRightDenominatorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	ExtendedRightDenominatorLeftUnit,
	RightDenominatorRightQuantity : UndefinedQuantityType,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorLeftQuantity, LeftUnit>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorLeftQuantity,
				>,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorLeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedRightDenominatorLeftUnit : UndefinedExtendedUnit<
		LeftAndRightDenominatorLeftQuantity,
		>,
	ExtendedRightDenominatorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorLeftQuantity,
			>,
		>,
	ExtendedRightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedRightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedRightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<RightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorLeftQuantity,
			>,
		ExtendedRightDenominatorLeftUnit,
		RightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorLeftQuantity,
				>,
			RightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightNumeratorUnitPerRightDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				RightDenominatorRightQuantity,
				RightDenominatorRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDefinedMultipliedByMetricDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
	LeftAndRightDenominatorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	ExtendedRightDenominatorLeftUnit,
	RightDenominatorRightQuantity : UndefinedQuantityType,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorLeftQuantity, LeftUnit>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorLeftQuantity,
				>,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorLeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	ExtendedRightDenominatorLeftUnit : UndefinedExtendedUnit<
		LeftAndRightDenominatorLeftQuantity,
		>,
	ExtendedRightDenominatorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorLeftQuantity,
			>,
		>,
	ExtendedRightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<RightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorLeftQuantity,
			>,
		ExtendedRightDenominatorLeftUnit,
		RightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorLeftQuantity,
				>,
			RightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		rightNumeratorUnitPerRightDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				RightDenominatorRightQuantity,
				RightDenominatorRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDefinedMultipliedByImperialDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
	LeftAndRightDenominatorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	ExtendedRightDenominatorLeftUnit,
	RightDenominatorRightQuantity : UndefinedQuantityType,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorLeftQuantity, LeftUnit>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorLeftQuantity,
				>,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorLeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedRightDenominatorLeftUnit : UndefinedExtendedUnit<
		LeftAndRightDenominatorLeftQuantity,
		>,
	ExtendedRightDenominatorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorLeftQuantity,
			>,
		>,
	ExtendedRightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedRightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<RightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorLeftQuantity,
			>,
		ExtendedRightDenominatorLeftUnit,
		RightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorLeftQuantity,
				>,
			RightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightNumeratorUnitPerRightDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				RightDenominatorRightQuantity,
				RightDenominatorRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDefinedMultipliedByUKImperialDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
	LeftAndRightDenominatorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	ExtendedRightDenominatorLeftUnit,
	RightDenominatorRightQuantity : UndefinedQuantityType,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorLeftQuantity, LeftUnit>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorLeftQuantity,
				>,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorLeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedRightDenominatorLeftUnit : UndefinedExtendedUnit<
		LeftAndRightDenominatorLeftQuantity,
		>,
	ExtendedRightDenominatorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorLeftQuantity,
			>,
		>,
	ExtendedRightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<RightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorLeftQuantity,
			>,
		ExtendedRightDenominatorLeftUnit,
		RightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorLeftQuantity,
				>,
			RightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		rightNumeratorUnitPerRightDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				RightDenominatorRightQuantity,
				RightDenominatorRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDefinedMultipliedByUSCustomaryDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
	LeftAndRightDenominatorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	ExtendedRightDenominatorLeftUnit,
	RightDenominatorRightQuantity : UndefinedQuantityType,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorLeftQuantity, LeftUnit>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorLeftQuantity,
				>,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorLeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedRightDenominatorLeftUnit : UndefinedExtendedUnit<
		LeftAndRightDenominatorLeftQuantity,
		>,
	ExtendedRightDenominatorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorLeftQuantity,
			>,
		>,
	ExtendedRightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<RightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorLeftQuantity,
			>,
		ExtendedRightDenominatorLeftUnit,
		RightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorLeftQuantity,
				>,
			RightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightNumeratorUnitPerRightDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				RightDenominatorRightQuantity,
				RightDenominatorRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDefinedMultipliedByMetricAndUKImperialDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
	LeftAndRightDenominatorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	ExtendedRightDenominatorLeftUnit,
	RightDenominatorRightQuantity : UndefinedQuantityType,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorLeftQuantity, LeftUnit>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorLeftQuantity,
				>,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorLeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedRightDenominatorLeftUnit : UndefinedExtendedUnit<
		LeftAndRightDenominatorLeftQuantity,
		>,
	ExtendedRightDenominatorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorLeftQuantity,
			>,
		>,
	ExtendedRightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedRightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<RightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorLeftQuantity,
			>,
		ExtendedRightDenominatorLeftUnit,
		RightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorLeftQuantity,
				>,
			RightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		rightNumeratorUnitPerRightDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				RightDenominatorRightQuantity,
				RightDenominatorRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDefinedMultipliedByMetricAndUSCustomaryDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
	LeftAndRightDenominatorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	ExtendedRightDenominatorLeftUnit,
	RightDenominatorRightQuantity : UndefinedQuantityType,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorLeftQuantity, LeftUnit>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorLeftQuantity,
				>,
			RightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorLeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedRightDenominatorLeftUnit : UndefinedExtendedUnit<
		LeftAndRightDenominatorLeftQuantity,
		>,
	ExtendedRightDenominatorLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorLeftQuantity,
			>,
		>,
	ExtendedRightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedRightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<RightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorLeftQuantity,
			>,
		ExtendedRightDenominatorLeftUnit,
		RightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightDenominatorLeftQuantity,
				>,
			RightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightNumeratorUnitPerRightDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				RightNumeratorQuantity,
				RightNumeratorUnit,
				RightDenominatorRightQuantity,
				RightDenominatorRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
