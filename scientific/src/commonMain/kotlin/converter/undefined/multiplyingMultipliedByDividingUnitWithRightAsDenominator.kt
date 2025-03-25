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

// Mul<A, B> * Div<C, B> -> Mul<B, C>

@JvmName("multiplyingMultipliedByDividingUnitWithRightAsDenominator")
fun <
	LeftLeftQuantity : UndefinedQuantityType,
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
	LeftRightAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorQuantity>,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftQuantity,
		LeftLeftUnit,
		LeftRightAndRightDenominatorQuantity,
		LeftRightUnit,
		>,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorQuantity>,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftRightAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	TargetUnit : UndefinedMultipliedUnit<
		LeftRightAndRightDenominatorQuantity,
		LeftRightUnit,
		RightNumeratorQuantity,
		RightNumeratorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftRightAndRightDenominatorQuantity,
		RightNumeratorQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftQuantity,
		LeftRightAndRightDenominatorQuantity,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftRightAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
	leftRightUnitXRightNumeratorUnit: LeftRightUnit.(RightNumeratorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.right.leftRightUnitXRightNumeratorUnit(
	right.unit.numerator,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultiplyingMultipliedByMetricAndImperialDividingUnitWithRightAsDenominator")
infix fun <
	LeftLeftQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftQuantity,
		LeftRightAndRightDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftRightAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftQuantity,
		LeftLeftUnit,
		LeftRightAndRightDenominatorQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftRightAndRightDenominatorQuantity,
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
			LeftRightAndRightDenominatorQuantity,
				LeftRightUnit,
				RightNumeratorQuantity,
				RightNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricMultiplyingMultipliedByMetricDividingUnitWithRightAsDenominator")
infix fun <
	LeftLeftQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftQuantity,
		LeftRightAndRightDenominatorQuantity,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftRightAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftQuantity,
		LeftLeftUnit,
		LeftRightAndRightDenominatorQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftRightAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		leftRightUnitXRightNumeratorUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.Metric<
			LeftRightAndRightDenominatorQuantity,
				LeftRightUnit,
				RightNumeratorQuantity,
				RightNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialMultiplyingMultipliedByImperialDividingUnitWithRightAsDenominator")
infix fun <
	LeftLeftQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftQuantity,
		LeftRightAndRightDenominatorQuantity,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftRightAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftQuantity,
		LeftLeftUnit,
		LeftRightAndRightDenominatorQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftRightAndRightDenominatorQuantity,
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
			LeftRightAndRightDenominatorQuantity,
				LeftRightUnit,
				RightNumeratorQuantity,
				RightNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialMultiplyingMultipliedByUKImperialDividingUnitWithRightAsDenominator")
infix fun <
	LeftLeftQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftQuantity,
		LeftRightAndRightDenominatorQuantity,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftRightAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftQuantity,
		LeftLeftUnit,
		LeftRightAndRightDenominatorQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftRightAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftRightUnitXRightNumeratorUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.UKImperial<
			LeftRightAndRightDenominatorQuantity,
				LeftRightUnit,
				RightNumeratorQuantity,
				RightNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryMultiplyingMultipliedByUSCustomaryDividingUnitWithRightAsDenominator")
infix fun <
	LeftLeftQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftQuantity,
		LeftRightAndRightDenominatorQuantity,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftRightAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftQuantity,
		LeftLeftUnit,
		LeftRightAndRightDenominatorQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftRightAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftRightUnitXRightNumeratorUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.USCustomary<
			LeftRightAndRightDenominatorQuantity,
				LeftRightUnit,
				RightNumeratorQuantity,
				RightNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultiplyingMultipliedByMetricAndUKImperialDividingUnitWithRightAsDenominator")
infix fun <
	LeftLeftQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftQuantity,
		LeftRightAndRightDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftRightAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftQuantity,
		LeftLeftUnit,
		LeftRightAndRightDenominatorQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftRightAndRightDenominatorQuantity,
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
			LeftRightAndRightDenominatorQuantity,
				LeftRightUnit,
				RightNumeratorQuantity,
				RightNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultiplyingMultipliedByMetricAndUSCustomaryDividingUnitWithRightAsDenominator")
infix fun <
	LeftLeftQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftQuantity,
		LeftRightAndRightDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftRightAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftQuantity,
		LeftLeftUnit,
		LeftRightAndRightDenominatorQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftRightAndRightDenominatorQuantity,
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
			LeftRightAndRightDenominatorQuantity,
				LeftRightUnit,
				RightNumeratorQuantity,
				RightNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
