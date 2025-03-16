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
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Div<A, B> * Mul<C, B> -> Mul<A, C>

@JvmName("dividingMultipliedByMultiplyingUnitWithDenominatorAsRight")
fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftDenominatorAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorAndRightRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, LeftDenominatorAndRightRightQuantity, LeftDenominatorAndRightRightUnit>,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
	RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftDenominatorAndRightRightQuantity, LeftDenominatorAndRightRightUnit>,
	TargetUnit : UndefinedMultipliedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, RightLeftQuantity, RightLeftUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Multiplying<LeftNumeratorQuantity, RightLeftQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, LeftDenominatorAndRightRightQuantity>, LeftUnit>.multipliedByMultiplyingUnitWithDenominatorAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftDenominatorAndRightRightQuantity>, RightUnit>,
	leftNumeratorUnitXRightLeftUnit: LeftNumeratorUnit.(RightLeftUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.numerator.leftNumeratorUnitXRightLeftUnit(right.unit.left).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingMultipliedByMetricAndImperialMultiplyingUnitWithDenominatorAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorAndRightRightUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, LeftDenominatorAndRightRightQuantity>, LeftUnit>.multipliedByMultiplyingUnitWithDenominatorAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftDenominatorAndRightRightQuantity>, RightUnit>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorAndRightRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	LeftDenominatorAndRightRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorAndRightRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorAndRightRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, LeftDenominatorAndRightRightQuantity, LeftDenominatorAndRightRightUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftDenominatorAndRightRightQuantity, LeftDenominatorAndRightRightUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByMultiplyingUnitWithDenominatorAsRight(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndImperial<
				LeftNumeratorQuantity,
				LeftNumeratorUnit,
				RightLeftQuantity,
				RightLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDividingMultipliedByMetricMultiplyingUnitWithDenominatorAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorAndRightRightUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, LeftDenominatorAndRightRightQuantity>, LeftUnit>.multipliedByMultiplyingUnitWithDenominatorAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftDenominatorAndRightRightQuantity>, RightUnit>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorAndRightRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	LeftDenominatorAndRightRightUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, LeftDenominatorAndRightRightQuantity, LeftDenominatorAndRightRightUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftDenominatorAndRightRightQuantity, LeftDenominatorAndRightRightUnit>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedByMultiplyingUnitWithDenominatorAsRight(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.Metric<
				LeftNumeratorQuantity,
				LeftNumeratorUnit,
				RightLeftQuantity,
				RightLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDividingMultipliedByImperialMultiplyingUnitWithDenominatorAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorAndRightRightUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, LeftDenominatorAndRightRightQuantity>, LeftUnit>.multipliedByMultiplyingUnitWithDenominatorAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftDenominatorAndRightRightQuantity>, RightUnit>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorAndRightRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	LeftDenominatorAndRightRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorAndRightRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, LeftDenominatorAndRightRightQuantity, LeftDenominatorAndRightRightUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftDenominatorAndRightRightQuantity, LeftDenominatorAndRightRightUnit>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByMultiplyingUnitWithDenominatorAsRight(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.Imperial<
				LeftNumeratorQuantity,
				LeftNumeratorUnit,
				RightLeftQuantity,
				RightLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDividingMultipliedByUKImperialMultiplyingUnitWithDenominatorAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorAndRightRightUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, LeftDenominatorAndRightRightQuantity>, LeftUnit>.multipliedByMultiplyingUnitWithDenominatorAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftDenominatorAndRightRightQuantity>, RightUnit>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorAndRightRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	LeftDenominatorAndRightRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, LeftDenominatorAndRightRightQuantity, LeftDenominatorAndRightRightUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftDenominatorAndRightRightQuantity, LeftDenominatorAndRightRightUnit>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedByMultiplyingUnitWithDenominatorAsRight(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.UKImperial<
				LeftNumeratorQuantity,
				LeftNumeratorUnit,
				RightLeftQuantity,
				RightLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingMultipliedByUSCustomaryMultiplyingUnitWithDenominatorAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorAndRightRightUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, LeftDenominatorAndRightRightQuantity>, LeftUnit>.multipliedByMultiplyingUnitWithDenominatorAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftDenominatorAndRightRightQuantity>, RightUnit>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorAndRightRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	LeftDenominatorAndRightRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, LeftDenominatorAndRightRightQuantity, LeftDenominatorAndRightRightUnit>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftDenominatorAndRightRightQuantity, LeftDenominatorAndRightRightUnit>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByMultiplyingUnitWithDenominatorAsRight(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.USCustomary<
				LeftNumeratorQuantity,
				LeftNumeratorUnit,
				RightLeftQuantity,
				RightLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingMultipliedByMetricAndUKImperialMultiplyingUnitWithDenominatorAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorAndRightRightUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, LeftDenominatorAndRightRightQuantity>, LeftUnit>.multipliedByMultiplyingUnitWithDenominatorAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftDenominatorAndRightRightQuantity>, RightUnit>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorAndRightRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	LeftDenominatorAndRightRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorAndRightRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, LeftDenominatorAndRightRightQuantity, LeftDenominatorAndRightRightUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftDenominatorAndRightRightQuantity, LeftDenominatorAndRightRightUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedByMultiplyingUnitWithDenominatorAsRight(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndUKImperial<
				LeftNumeratorQuantity,
				LeftNumeratorUnit,
				RightLeftQuantity,
				RightLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingMultipliedByMetricAndUSCustomaryMultiplyingUnitWithDenominatorAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorAndRightRightUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, LeftDenominatorAndRightRightQuantity>, LeftUnit>.multipliedByMultiplyingUnitWithDenominatorAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftDenominatorAndRightRightQuantity>, RightUnit>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorAndRightRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightRightQuantity>,
	LeftDenominatorAndRightRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorAndRightRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, LeftDenominatorAndRightRightQuantity, LeftDenominatorAndRightRightUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftDenominatorAndRightRightQuantity, LeftDenominatorAndRightRightUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByMultiplyingUnitWithDenominatorAsRight(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndUSCustomary<
				LeftNumeratorQuantity,
				LeftNumeratorUnit,
				RightLeftQuantity,
				RightLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

