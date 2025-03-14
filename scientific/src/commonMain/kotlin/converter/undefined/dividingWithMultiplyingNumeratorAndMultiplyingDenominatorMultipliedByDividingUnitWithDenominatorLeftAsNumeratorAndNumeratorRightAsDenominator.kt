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
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// Div<Mul<C, B>, Mul<A, D>> * Div<A, B> -> Div<C, D>

@JvmName("dividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorRightAsDenominator")
fun <
	LeftNumeratorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
	LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
	LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
	LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
	LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
	LeftDenominatorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
	LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
	LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
	RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
	TargetUnit : UndefinedDividedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorLeftQuantity, LeftDenominatorRightQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
	leftNumeratorLeftUnitPerLeftDenominatorRightUnit: LeftNumeratorLeftUnit.(LeftDenominatorRightUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.numerator.left.leftNumeratorLeftUnitPerLeftDenominatorRightUnit(unit.denominator.right).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByMetricAndImperialDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorRightAsDenominator")
infix operator fun <
	LeftNumeratorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorRightAndRightDenominatorUnit,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
	LeftDenominatorLeftAndRightNumeratorUnit,
	LeftDenominatorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
	LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
	LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	times(
		right,
		leftNumeratorLeftUnitPerLeftDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				LeftNumeratorLeftQuantity,
				LeftNumeratorLeftUnit,
				LeftDenominatorRightQuantity,
				LeftDenominatorRightUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByMetricDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorRightAsDenominator")
infix operator fun <
	LeftNumeratorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorRightAndRightDenominatorUnit,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
	LeftDenominatorLeftAndRightNumeratorUnit,
	LeftDenominatorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
	LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
	LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
	RightUnit : MeasurementUsage.UsedInMetric =
	times(
		right,
		leftNumeratorLeftUnitPerLeftDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				LeftNumeratorLeftQuantity,
				LeftNumeratorLeftUnit,
				LeftDenominatorRightQuantity,
				LeftDenominatorRightUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByImperialDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorRightAsDenominator")
infix operator fun <
	LeftNumeratorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorRightAndRightDenominatorUnit,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
	LeftDenominatorLeftAndRightNumeratorUnit,
	LeftDenominatorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
	LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
	LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	times(
		right,
		leftNumeratorLeftUnitPerLeftDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				LeftNumeratorLeftQuantity,
				LeftNumeratorLeftUnit,
				LeftDenominatorRightQuantity,
				LeftDenominatorRightUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByUKImperialDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorRightAsDenominator")
infix operator fun <
	LeftNumeratorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorRightAndRightDenominatorUnit,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
	LeftDenominatorLeftAndRightNumeratorUnit,
	LeftDenominatorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
	LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
	LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	times(
		right,
		leftNumeratorLeftUnitPerLeftDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				LeftNumeratorLeftQuantity,
				LeftNumeratorLeftUnit,
				LeftDenominatorRightQuantity,
				LeftDenominatorRightUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByUSCustomaryDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorRightAsDenominator")
infix operator fun <
	LeftNumeratorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorRightAndRightDenominatorUnit,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
	LeftDenominatorLeftAndRightNumeratorUnit,
	LeftDenominatorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
	LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
	LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	times(
		right,
		leftNumeratorLeftUnitPerLeftDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				LeftNumeratorLeftQuantity,
				LeftNumeratorLeftUnit,
				LeftDenominatorRightQuantity,
				LeftDenominatorRightUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByMetricAndUKImperialDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorRightAsDenominator")
infix operator fun <
	LeftNumeratorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorRightAndRightDenominatorUnit,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
	LeftDenominatorLeftAndRightNumeratorUnit,
	LeftDenominatorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
	LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
	LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	times(
		right,
		leftNumeratorLeftUnitPerLeftDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				LeftNumeratorLeftQuantity,
				LeftNumeratorLeftUnit,
				LeftDenominatorRightQuantity,
				LeftDenominatorRightUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByMetricAndUSCustomaryDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorRightAsDenominator")
infix operator fun <
	LeftNumeratorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorRightAndRightDenominatorUnit,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
	LeftDenominatorLeftAndRightNumeratorUnit,
	LeftDenominatorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
	LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
	LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	times(
		right,
		leftNumeratorLeftUnitPerLeftDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				LeftNumeratorLeftQuantity,
				LeftNumeratorLeftUnit,
				LeftDenominatorRightQuantity,
				LeftDenominatorRightUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

