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
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Mul<A, B> * Div<C, A> -> Mul<B, C>

@JvmName("multiplyingMultipliedByDividingUnitWithLeftAsDenominator")
fun <
	LeftLeftAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorQuantity>,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightDenominatorQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorQuantity>,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftLeftAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	TargetUnit : UndefinedMultipliedUnit<
		LeftRightQuantity,
		LeftRightUnit,
		RightNumeratorQuantity,
		RightNumeratorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftRightQuantity,
		RightNumeratorQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightDenominatorQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftLeftAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
	leftRightUnitXRightNumeratorUnit: LeftRightUnit.(RightNumeratorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.right.leftRightUnitXRightNumeratorUnit(
	right.unit.numerator,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultiplyingMultipliedByMetricAndImperialDividingUnitWithLeftAsDenominator")
infix fun <
	LeftLeftAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightDenominatorQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftLeftAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightDenominatorQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftLeftAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftRightUnitXRightNumeratorUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndImperial<
			LeftRightQuantity,
				LeftRightUnit,
				RightNumeratorQuantity,
				RightNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricMultiplyingMultipliedByMetricDividingUnitWithLeftAsDenominator")
infix fun <
	LeftLeftAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightDenominatorQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftLeftAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightDenominatorQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftLeftAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		leftRightUnitXRightNumeratorUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.Metric<
			LeftRightQuantity,
				LeftRightUnit,
				RightNumeratorQuantity,
				RightNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialMultiplyingMultipliedByImperialDividingUnitWithLeftAsDenominator")
infix fun <
	LeftLeftAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightDenominatorQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftLeftAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightDenominatorQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftLeftAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftRightUnitXRightNumeratorUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.Imperial<
			LeftRightQuantity,
				LeftRightUnit,
				RightNumeratorQuantity,
				RightNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialMultiplyingMultipliedByUKImperialDividingUnitWithLeftAsDenominator")
infix fun <
	LeftLeftAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightDenominatorQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftLeftAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightDenominatorQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftLeftAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftRightUnitXRightNumeratorUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.UKImperial<
			LeftRightQuantity,
				LeftRightUnit,
				RightNumeratorQuantity,
				RightNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryMultiplyingMultipliedByUSCustomaryDividingUnitWithLeftAsDenominator")
infix fun <
	LeftLeftAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightDenominatorQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftLeftAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightDenominatorQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftLeftAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftRightUnitXRightNumeratorUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.USCustomary<
			LeftRightQuantity,
				LeftRightUnit,
				RightNumeratorQuantity,
				RightNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultiplyingMultipliedByMetricAndUKImperialDividingUnitWithLeftAsDenominator")
infix fun <
	LeftLeftAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightDenominatorQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftLeftAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightDenominatorQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftLeftAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftRightUnitXRightNumeratorUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndUKImperial<
			LeftRightQuantity,
				LeftRightUnit,
				RightNumeratorQuantity,
				RightNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultiplyingMultipliedByMetricAndUSCustomaryDividingUnitWithLeftAsDenominator")
infix fun <
	LeftLeftAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightDenominatorQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftLeftAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightDenominatorQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftLeftAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftRightUnitXRightNumeratorUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndUSCustomary<
			LeftRightQuantity,
				LeftRightUnit,
				RightNumeratorQuantity,
				RightNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
