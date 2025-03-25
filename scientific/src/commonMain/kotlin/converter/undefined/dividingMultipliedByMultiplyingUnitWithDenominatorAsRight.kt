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

// Div<A, B> * Mul<C, B> -> Mul<A, C>

@JvmName("dividingMultipliedByMultiplyingUnitWithDenominatorAsRight")
fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftDenominatorAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightRightQuantity,
		LeftDenominatorUnit,
		>,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftDenominatorAndRightRightQuantity,
		RightRightUnit,
		>,
	TargetUnit : UndefinedMultipliedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		RightLeftQuantity,
		RightLeftUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftNumeratorQuantity,
		RightLeftQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		LeftDenominatorAndRightRightQuantity,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftDenominatorAndRightRightQuantity,
		>,
RightUnit,
	>,
	leftNumeratorUnitXRightLeftUnit: LeftNumeratorUnit.(RightLeftUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.leftNumeratorUnitXRightLeftUnit(
	right.unit.left,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingMultipliedByMetricAndImperialMultiplyingUnitWithDenominatorAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		LeftDenominatorAndRightRightQuantity,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftDenominatorAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftDenominatorAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndImperial<
			LeftNumeratorQuantity,
				LeftNumeratorUnit,
				RightLeftQuantity,
				RightLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingMultipliedByMetricMultiplyingUnitWithDenominatorAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		LeftDenominatorAndRightRightQuantity,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftDenominatorAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftDenominatorAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.Metric<
			LeftNumeratorQuantity,
				LeftNumeratorUnit,
				RightLeftQuantity,
				RightLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingMultipliedByImperialMultiplyingUnitWithDenominatorAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		LeftDenominatorAndRightRightQuantity,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftDenominatorAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftDenominatorAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.Imperial<
			LeftNumeratorQuantity,
				LeftNumeratorUnit,
				RightLeftQuantity,
				RightLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingMultipliedByUKImperialMultiplyingUnitWithDenominatorAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		LeftDenominatorAndRightRightQuantity,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftDenominatorAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftDenominatorAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.UKImperial<
			LeftNumeratorQuantity,
				LeftNumeratorUnit,
				RightLeftQuantity,
				RightLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingMultipliedByUSCustomaryMultiplyingUnitWithDenominatorAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		LeftDenominatorAndRightRightQuantity,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftDenominatorAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftDenominatorAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.USCustomary<
			LeftNumeratorQuantity,
				LeftNumeratorUnit,
				RightLeftQuantity,
				RightLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingMultipliedByMetricAndUKImperialMultiplyingUnitWithDenominatorAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		LeftDenominatorAndRightRightQuantity,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftDenominatorAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftDenominatorAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndUKImperial<
			LeftNumeratorQuantity,
				LeftNumeratorUnit,
				RightLeftQuantity,
				RightLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingMultipliedByMetricAndUSCustomaryMultiplyingUnitWithDenominatorAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		LeftDenominatorAndRightRightQuantity,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftDenominatorAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorAndRightRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftDenominatorAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndUSCustomary<
			LeftNumeratorQuantity,
				LeftNumeratorUnit,
				RightLeftQuantity,
				RightLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
