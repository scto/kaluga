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
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// Inv<A> * Div<Mul<A, B>, C> -> Div<B, C>

@JvmName("reciprocalMultipliedByDividingUnitWithMultiplyingNumeratorWithSelfAsLeft")
fun <
	LeftReciprocalAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalAndRightNumeratorLeftQuantity>,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightNumeratorLeftQuantity, LeftReciprocalAndRightNumeratorLeftUnit>,
	RightNumeratorRightQuantity : UndefinedQuantityType,
	RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorUnit : UndefinedMultipliedUnit<LeftReciprocalAndRightNumeratorLeftQuantity, LeftReciprocalAndRightNumeratorLeftUnit, RightNumeratorRightQuantity, RightNumeratorRightUnit>,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
	RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftReciprocalAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightNumeratorUnit, RightDenominatorQuantity, RightDenominatorUnit>,
	TargetUnit : UndefinedDividedUnit<RightNumeratorRightQuantity, RightNumeratorRightUnit, RightDenominatorQuantity, RightDenominatorUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorRightQuantity, RightDenominatorQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightNumeratorLeftQuantity>, LeftUnit>.multipliedByDividingUnitWithMultiplyingNumeratorWithSelfAsLeft(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftReciprocalAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightDenominatorQuantity>, RightUnit>,
	rightNumeratorRightUnitPerRightDenominatorUnit: RightNumeratorRightUnit.(RightDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = right.unit.numerator.right.rightNumeratorRightUnitPerRightDenominatorUnit(right.unit.denominator).byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultipliedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithSelfAsLeft")
infix fun <
	LeftReciprocalAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightNumeratorLeftUnit,
	LeftUnit,
	RightNumeratorRightQuantity : UndefinedQuantityType,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightNumeratorLeftQuantity>, LeftUnit>.multipliedByDividingUnitWithMultiplyingNumeratorWithSelfAsLeft(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftReciprocalAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightDenominatorQuantity>, RightUnit>,
) where
	LeftReciprocalAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalAndRightNumeratorLeftQuantity>,
	LeftReciprocalAndRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightNumeratorLeftQuantity, LeftReciprocalAndRightNumeratorLeftUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<LeftReciprocalAndRightNumeratorLeftQuantity, LeftReciprocalAndRightNumeratorLeftUnit, RightNumeratorRightQuantity, RightNumeratorRightUnit>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftReciprocalAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightNumeratorUnit, RightDenominatorQuantity, RightDenominatorUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByDividingUnitWithMultiplyingNumeratorWithSelfAsLeft(
		right,
		rightNumeratorRightUnitPerRightDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				RightNumeratorRightQuantity,
				RightNumeratorRightUnit,
				RightDenominatorQuantity,
				RightDenominatorUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricReciprocalMultipliedByMetricDividingUnitWithMultiplyingNumeratorWithSelfAsLeft")
infix fun <
	LeftReciprocalAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightNumeratorLeftUnit,
	LeftUnit,
	RightNumeratorRightQuantity : UndefinedQuantityType,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightNumeratorLeftQuantity>, LeftUnit>.multipliedByDividingUnitWithMultiplyingNumeratorWithSelfAsLeft(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftReciprocalAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightDenominatorQuantity>, RightUnit>,
) where
	LeftReciprocalAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalAndRightNumeratorLeftQuantity>,
	LeftReciprocalAndRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightNumeratorLeftQuantity, LeftReciprocalAndRightNumeratorLeftUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : UndefinedMultipliedUnit<LeftReciprocalAndRightNumeratorLeftQuantity, LeftReciprocalAndRightNumeratorLeftUnit, RightNumeratorRightQuantity, RightNumeratorRightUnit>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftReciprocalAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightNumeratorUnit, RightDenominatorQuantity, RightDenominatorUnit>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedByDividingUnitWithMultiplyingNumeratorWithSelfAsLeft(
		right,
		rightNumeratorRightUnitPerRightDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				RightNumeratorRightQuantity,
				RightNumeratorRightUnit,
				RightDenominatorQuantity,
				RightDenominatorUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialReciprocalMultipliedByImperialDividingUnitWithMultiplyingNumeratorWithSelfAsLeft")
infix fun <
	LeftReciprocalAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightNumeratorLeftUnit,
	LeftUnit,
	RightNumeratorRightQuantity : UndefinedQuantityType,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightNumeratorLeftQuantity>, LeftUnit>.multipliedByDividingUnitWithMultiplyingNumeratorWithSelfAsLeft(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftReciprocalAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightDenominatorQuantity>, RightUnit>,
) where
	LeftReciprocalAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalAndRightNumeratorLeftQuantity>,
	LeftReciprocalAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightNumeratorLeftQuantity, LeftReciprocalAndRightNumeratorLeftUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<LeftReciprocalAndRightNumeratorLeftQuantity, LeftReciprocalAndRightNumeratorLeftUnit, RightNumeratorRightQuantity, RightNumeratorRightUnit>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftReciprocalAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightNumeratorUnit, RightDenominatorQuantity, RightDenominatorUnit>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByDividingUnitWithMultiplyingNumeratorWithSelfAsLeft(
		right,
		rightNumeratorRightUnitPerRightDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				RightNumeratorRightQuantity,
				RightNumeratorRightUnit,
				RightDenominatorQuantity,
				RightDenominatorUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalMultipliedByUKImperialDividingUnitWithMultiplyingNumeratorWithSelfAsLeft")
infix fun <
	LeftReciprocalAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightNumeratorLeftUnit,
	LeftUnit,
	RightNumeratorRightQuantity : UndefinedQuantityType,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightNumeratorLeftQuantity>, LeftUnit>.multipliedByDividingUnitWithMultiplyingNumeratorWithSelfAsLeft(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftReciprocalAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightDenominatorQuantity>, RightUnit>,
) where
	LeftReciprocalAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalAndRightNumeratorLeftQuantity>,
	LeftReciprocalAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightNumeratorLeftQuantity, LeftReciprocalAndRightNumeratorLeftUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : UndefinedMultipliedUnit<LeftReciprocalAndRightNumeratorLeftQuantity, LeftReciprocalAndRightNumeratorLeftUnit, RightNumeratorRightQuantity, RightNumeratorRightUnit>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftReciprocalAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightNumeratorUnit, RightDenominatorQuantity, RightDenominatorUnit>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedByDividingUnitWithMultiplyingNumeratorWithSelfAsLeft(
		right,
		rightNumeratorRightUnitPerRightDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				RightNumeratorRightQuantity,
				RightNumeratorRightUnit,
				RightDenominatorQuantity,
				RightDenominatorUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalMultipliedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithSelfAsLeft")
infix fun <
	LeftReciprocalAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightNumeratorLeftUnit,
	LeftUnit,
	RightNumeratorRightQuantity : UndefinedQuantityType,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightNumeratorLeftQuantity>, LeftUnit>.multipliedByDividingUnitWithMultiplyingNumeratorWithSelfAsLeft(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftReciprocalAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightDenominatorQuantity>, RightUnit>,
) where
	LeftReciprocalAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalAndRightNumeratorLeftQuantity>,
	LeftReciprocalAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightNumeratorLeftQuantity, LeftReciprocalAndRightNumeratorLeftUnit>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<LeftReciprocalAndRightNumeratorLeftQuantity, LeftReciprocalAndRightNumeratorLeftUnit, RightNumeratorRightQuantity, RightNumeratorRightUnit>,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftReciprocalAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightNumeratorUnit, RightDenominatorQuantity, RightDenominatorUnit>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByDividingUnitWithMultiplyingNumeratorWithSelfAsLeft(
		right,
		rightNumeratorRightUnitPerRightDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				RightNumeratorRightQuantity,
				RightNumeratorRightUnit,
				RightDenominatorQuantity,
				RightDenominatorUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalMultipliedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithSelfAsLeft")
infix fun <
	LeftReciprocalAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightNumeratorLeftUnit,
	LeftUnit,
	RightNumeratorRightQuantity : UndefinedQuantityType,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightNumeratorLeftQuantity>, LeftUnit>.multipliedByDividingUnitWithMultiplyingNumeratorWithSelfAsLeft(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftReciprocalAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightDenominatorQuantity>, RightUnit>,
) where
	LeftReciprocalAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalAndRightNumeratorLeftQuantity>,
	LeftReciprocalAndRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightNumeratorLeftQuantity, LeftReciprocalAndRightNumeratorLeftUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : UndefinedMultipliedUnit<LeftReciprocalAndRightNumeratorLeftQuantity, LeftReciprocalAndRightNumeratorLeftUnit, RightNumeratorRightQuantity, RightNumeratorRightUnit>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftReciprocalAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightNumeratorUnit, RightDenominatorQuantity, RightDenominatorUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedByDividingUnitWithMultiplyingNumeratorWithSelfAsLeft(
		right,
		rightNumeratorRightUnitPerRightDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				RightNumeratorRightQuantity,
				RightNumeratorRightUnit,
				RightDenominatorQuantity,
				RightDenominatorUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalMultipliedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithSelfAsLeft")
infix fun <
	LeftReciprocalAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightNumeratorLeftUnit,
	LeftUnit,
	RightNumeratorRightQuantity : UndefinedQuantityType,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightNumeratorLeftQuantity>, LeftUnit>.multipliedByDividingUnitWithMultiplyingNumeratorWithSelfAsLeft(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftReciprocalAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightDenominatorQuantity>, RightUnit>,
) where
	LeftReciprocalAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalAndRightNumeratorLeftQuantity>,
	LeftReciprocalAndRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightNumeratorLeftQuantity, LeftReciprocalAndRightNumeratorLeftUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<LeftReciprocalAndRightNumeratorLeftQuantity, LeftReciprocalAndRightNumeratorLeftUnit, RightNumeratorRightQuantity, RightNumeratorRightUnit>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftReciprocalAndRightNumeratorLeftQuantity, RightNumeratorRightQuantity>, RightNumeratorUnit, RightDenominatorQuantity, RightDenominatorUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByDividingUnitWithMultiplyingNumeratorWithSelfAsLeft(
		right,
		rightNumeratorRightUnitPerRightDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				RightNumeratorRightQuantity,
				RightNumeratorRightUnit,
				RightDenominatorQuantity,
				RightDenominatorUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

