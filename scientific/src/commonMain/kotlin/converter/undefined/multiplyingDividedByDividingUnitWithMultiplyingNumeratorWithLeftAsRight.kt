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
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Mul<A, B> / Div<Mul<C, A>, D> -> Div<Mul<B, D>, C>

@JvmName("multiplyingDividedByDividingUnitWithMultiplyingNumeratorWithLeftAsRight")
fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorLeftAndDenominatorNumeratorRightUnit, NumeratorRightQuantity, NumeratorRightUnit>,
	DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorLeftAndDenominatorNumeratorRightUnit>,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
	TargetNumeratorUnit : UndefinedMultipliedUnit<NumeratorRightQuantity, NumeratorRightUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
	TargetUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorRightQuantity, DenominatorDenominatorQuantity>, TargetNumeratorUnit, DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorRightQuantity, DenominatorDenominatorQuantity>, DenominatorNumeratorLeftQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithLeftAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
	numeratorRightUnitXDenominatorDenominatorUnit: NumeratorRightUnit.(DenominatorDenominatorUnit) -> TargetNumeratorUnit,
	targetNumeratorUnitPerDenominatorNumeratorLeftUnit: TargetNumeratorUnit.(DenominatorNumeratorLeftUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.right.numeratorRightUnitXDenominatorDenominatorUnit(right.unit.denominator).targetNumeratorUnitPerDenominatorNumeratorLeftUnit(right.unit.numerator.left).byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingDividedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftAndDenominatorNumeratorRightUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithLeftAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
	NumeratorLeftAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorLeftAndDenominatorNumeratorRightUnit, NumeratorRightQuantity, NumeratorRightUnit>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorLeftAndDenominatorNumeratorRightUnit>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedByDividingUnitWithMultiplyingNumeratorWithLeftAsRight(
		right,
		numeratorRightUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				UndefinedQuantityType.Multiplying<NumeratorRightQuantity, DenominatorDenominatorQuantity>,
				UndefinedMultipliedUnit.MetricAndImperial<
					NumeratorRightQuantity,
					NumeratorRightUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit
				>,
				DenominatorNumeratorLeftQuantity,
				DenominatorNumeratorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricMultiplyingDividedByMetricDividingUnitWithMultiplyingNumeratorWithLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftAndDenominatorNumeratorRightUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithLeftAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
	NumeratorLeftAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorLeftAndDenominatorNumeratorRightUnit, NumeratorRightQuantity, NumeratorRightUnit>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorLeftAndDenominatorNumeratorRightUnit>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedByDividingUnitWithMultiplyingNumeratorWithLeftAsRight(
		right,
		numeratorRightUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				UndefinedQuantityType.Multiplying<NumeratorRightQuantity, DenominatorDenominatorQuantity>,
				UndefinedMultipliedUnit.Metric<
					NumeratorRightQuantity,
					NumeratorRightUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit
				>,
				DenominatorNumeratorLeftQuantity,
				DenominatorNumeratorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialMultiplyingDividedByImperialDividingUnitWithMultiplyingNumeratorWithLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftAndDenominatorNumeratorRightUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithLeftAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
	NumeratorLeftAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorLeftAndDenominatorNumeratorRightUnit, NumeratorRightQuantity, NumeratorRightUnit>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorLeftAndDenominatorNumeratorRightUnit>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedByDividingUnitWithMultiplyingNumeratorWithLeftAsRight(
		right,
		numeratorRightUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				UndefinedQuantityType.Multiplying<NumeratorRightQuantity, DenominatorDenominatorQuantity>,
				UndefinedMultipliedUnit.Imperial<
					NumeratorRightQuantity,
					NumeratorRightUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit
				>,
				DenominatorNumeratorLeftQuantity,
				DenominatorNumeratorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialMultiplyingDividedByUKImperialDividingUnitWithMultiplyingNumeratorWithLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftAndDenominatorNumeratorRightUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithLeftAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
	NumeratorLeftAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorLeftAndDenominatorNumeratorRightUnit, NumeratorRightQuantity, NumeratorRightUnit>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorLeftAndDenominatorNumeratorRightUnit>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedByDividingUnitWithMultiplyingNumeratorWithLeftAsRight(
		right,
		numeratorRightUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				UndefinedQuantityType.Multiplying<NumeratorRightQuantity, DenominatorDenominatorQuantity>,
				UndefinedMultipliedUnit.UKImperial<
					NumeratorRightQuantity,
					NumeratorRightUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit
				>,
				DenominatorNumeratorLeftQuantity,
				DenominatorNumeratorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryMultiplyingDividedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftAndDenominatorNumeratorRightUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithLeftAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
	NumeratorLeftAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorLeftAndDenominatorNumeratorRightUnit, NumeratorRightQuantity, NumeratorRightUnit>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorLeftAndDenominatorNumeratorRightUnit>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedByDividingUnitWithMultiplyingNumeratorWithLeftAsRight(
		right,
		numeratorRightUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				UndefinedQuantityType.Multiplying<NumeratorRightQuantity, DenominatorDenominatorQuantity>,
				UndefinedMultipliedUnit.USCustomary<
					NumeratorRightQuantity,
					NumeratorRightUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit
				>,
				DenominatorNumeratorLeftQuantity,
				DenominatorNumeratorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultiplyingDividedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftAndDenominatorNumeratorRightUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithLeftAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
	NumeratorLeftAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorLeftAndDenominatorNumeratorRightUnit, NumeratorRightQuantity, NumeratorRightUnit>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorLeftAndDenominatorNumeratorRightUnit>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedByDividingUnitWithMultiplyingNumeratorWithLeftAsRight(
		right,
		numeratorRightUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				UndefinedQuantityType.Multiplying<NumeratorRightQuantity, DenominatorDenominatorQuantity>,
				UndefinedMultipliedUnit.MetricAndUKImperial<
					NumeratorRightQuantity,
					NumeratorRightUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit
				>,
				DenominatorNumeratorLeftQuantity,
				DenominatorNumeratorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultiplyingDividedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftAndDenominatorNumeratorRightUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithLeftAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
	NumeratorLeftAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorLeftAndDenominatorNumeratorRightUnit, NumeratorRightQuantity, NumeratorRightUnit>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorLeftAndDenominatorNumeratorRightUnit>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedByDividingUnitWithMultiplyingNumeratorWithLeftAsRight(
		right,
		numeratorRightUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				UndefinedQuantityType.Multiplying<NumeratorRightQuantity, DenominatorDenominatorQuantity>,
				UndefinedMultipliedUnit.MetricAndUSCustomary<
					NumeratorRightQuantity,
					NumeratorRightUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit
				>,
				DenominatorNumeratorLeftQuantity,
				DenominatorNumeratorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

