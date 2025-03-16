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
import kotlin.jvm.JvmName

// Mul<A, B> / Mul<C, A> -> Div<B, C>

@JvmName("multiplyingDividedByMultiplyingUnitWithLeftAsRight")
fun <
	NumeratorLeftAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorLeftAndDenominatorRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorRightQuantity>,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorRightQuantity, NumeratorLeftAndDenominatorRightUnit, NumeratorRightQuantity, NumeratorRightUnit>,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit : UndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorUnit : UndefinedMultipliedUnit<DenominatorLeftQuantity, DenominatorLeftUnit, NumeratorLeftAndDenominatorRightQuantity, NumeratorLeftAndDenominatorRightUnit>,
	TargetUnit : UndefinedDividedUnit<NumeratorRightQuantity, NumeratorRightUnit, DenominatorLeftQuantity, DenominatorLeftUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorRightQuantity, DenominatorLeftQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorRightQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByMultiplyingUnitWithLeftAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<DenominatorLeftQuantity, NumeratorLeftAndDenominatorRightQuantity>, DenominatorUnit>,
	numeratorRightUnitPerDenominatorLeftUnit: NumeratorRightUnit.(DenominatorLeftUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.right.numeratorRightUnitPerDenominatorLeftUnit(right.unit.left).byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingDividedByMetricAndImperialMultiplyingUnitWithLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorLeftAndDenominatorRightUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorRightQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByMultiplyingUnitWithLeftAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<DenominatorLeftQuantity, NumeratorLeftAndDenominatorRightQuantity>, DenominatorUnit>,
) where
	NumeratorLeftAndDenominatorRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorRightQuantity>,
	NumeratorLeftAndDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftAndDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftAndDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorRightQuantity, NumeratorLeftAndDenominatorRightUnit, NumeratorRightQuantity, NumeratorRightUnit>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : UndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<DenominatorLeftQuantity, DenominatorLeftUnit, NumeratorLeftAndDenominatorRightQuantity, NumeratorLeftAndDenominatorRightUnit>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedByMultiplyingUnitWithLeftAsRight(
		right,
		numeratorRightUnitPerDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				NumeratorRightQuantity,
				NumeratorRightUnit,
				DenominatorLeftQuantity,
				DenominatorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricMultiplyingDividedByMetricMultiplyingUnitWithLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorLeftAndDenominatorRightUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorRightQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByMultiplyingUnitWithLeftAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<DenominatorLeftQuantity, NumeratorLeftAndDenominatorRightQuantity>, DenominatorUnit>,
) where
	NumeratorLeftAndDenominatorRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorRightQuantity>,
	NumeratorLeftAndDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorRightQuantity, NumeratorLeftAndDenominatorRightUnit, NumeratorRightQuantity, NumeratorRightUnit>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : UndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedMultipliedUnit<DenominatorLeftQuantity, DenominatorLeftUnit, NumeratorLeftAndDenominatorRightQuantity, NumeratorLeftAndDenominatorRightUnit>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedByMultiplyingUnitWithLeftAsRight(
		right,
		numeratorRightUnitPerDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				NumeratorRightQuantity,
				NumeratorRightUnit,
				DenominatorLeftQuantity,
				DenominatorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialMultiplyingDividedByImperialMultiplyingUnitWithLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorLeftAndDenominatorRightUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorRightQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByMultiplyingUnitWithLeftAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<DenominatorLeftQuantity, NumeratorLeftAndDenominatorRightQuantity>, DenominatorUnit>,
) where
	NumeratorLeftAndDenominatorRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorRightQuantity>,
	NumeratorLeftAndDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftAndDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorRightQuantity, NumeratorLeftAndDenominatorRightUnit, NumeratorRightQuantity, NumeratorRightUnit>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : UndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<DenominatorLeftQuantity, DenominatorLeftUnit, NumeratorLeftAndDenominatorRightQuantity, NumeratorLeftAndDenominatorRightUnit>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedByMultiplyingUnitWithLeftAsRight(
		right,
		numeratorRightUnitPerDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				NumeratorRightQuantity,
				NumeratorRightUnit,
				DenominatorLeftQuantity,
				DenominatorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialMultiplyingDividedByUKImperialMultiplyingUnitWithLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorLeftAndDenominatorRightUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorRightQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByMultiplyingUnitWithLeftAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<DenominatorLeftQuantity, NumeratorLeftAndDenominatorRightQuantity>, DenominatorUnit>,
) where
	NumeratorLeftAndDenominatorRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorRightQuantity>,
	NumeratorLeftAndDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorRightQuantity, NumeratorLeftAndDenominatorRightUnit, NumeratorRightQuantity, NumeratorRightUnit>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : UndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<DenominatorLeftQuantity, DenominatorLeftUnit, NumeratorLeftAndDenominatorRightQuantity, NumeratorLeftAndDenominatorRightUnit>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedByMultiplyingUnitWithLeftAsRight(
		right,
		numeratorRightUnitPerDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				NumeratorRightQuantity,
				NumeratorRightUnit,
				DenominatorLeftQuantity,
				DenominatorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryMultiplyingDividedByUSCustomaryMultiplyingUnitWithLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorLeftAndDenominatorRightUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorRightQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByMultiplyingUnitWithLeftAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<DenominatorLeftQuantity, NumeratorLeftAndDenominatorRightQuantity>, DenominatorUnit>,
) where
	NumeratorLeftAndDenominatorRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorRightQuantity>,
	NumeratorLeftAndDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorRightQuantity, NumeratorLeftAndDenominatorRightUnit, NumeratorRightQuantity, NumeratorRightUnit>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : UndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<DenominatorLeftQuantity, DenominatorLeftUnit, NumeratorLeftAndDenominatorRightQuantity, NumeratorLeftAndDenominatorRightUnit>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedByMultiplyingUnitWithLeftAsRight(
		right,
		numeratorRightUnitPerDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				NumeratorRightQuantity,
				NumeratorRightUnit,
				DenominatorLeftQuantity,
				DenominatorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultiplyingDividedByMetricAndUKImperialMultiplyingUnitWithLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorLeftAndDenominatorRightUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorRightQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByMultiplyingUnitWithLeftAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<DenominatorLeftQuantity, NumeratorLeftAndDenominatorRightQuantity>, DenominatorUnit>,
) where
	NumeratorLeftAndDenominatorRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorRightQuantity>,
	NumeratorLeftAndDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftAndDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorRightQuantity, NumeratorLeftAndDenominatorRightUnit, NumeratorRightQuantity, NumeratorRightUnit>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : UndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<DenominatorLeftQuantity, DenominatorLeftUnit, NumeratorLeftAndDenominatorRightQuantity, NumeratorLeftAndDenominatorRightUnit>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedByMultiplyingUnitWithLeftAsRight(
		right,
		numeratorRightUnitPerDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				NumeratorRightQuantity,
				NumeratorRightUnit,
				DenominatorLeftQuantity,
				DenominatorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultiplyingDividedByMetricAndUSCustomaryMultiplyingUnitWithLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorLeftAndDenominatorRightUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorRightQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByMultiplyingUnitWithLeftAsRight(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<DenominatorLeftQuantity, NumeratorLeftAndDenominatorRightQuantity>, DenominatorUnit>,
) where
	NumeratorLeftAndDenominatorRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorRightQuantity>,
	NumeratorLeftAndDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftAndDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorRightQuantity, NumeratorLeftAndDenominatorRightUnit, NumeratorRightQuantity, NumeratorRightUnit>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : UndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<DenominatorLeftQuantity, DenominatorLeftUnit, NumeratorLeftAndDenominatorRightQuantity, NumeratorLeftAndDenominatorRightUnit>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedByMultiplyingUnitWithLeftAsRight(
		right,
		numeratorRightUnitPerDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				NumeratorRightQuantity,
				NumeratorRightUnit,
				DenominatorLeftQuantity,
				DenominatorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

