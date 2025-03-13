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

package com.splendo.kaluga.scientific.converter.undefined.dividing

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultUndefinedScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

fun <
	NumeratorNumeratorAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorAndDenominatorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftQuantity>,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorUnit : UndefinedDividedUnit<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorNumeratorAndDenominatorLeftUnit, NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
	DenominatorRightQuantity : UndefinedQuantityType,
	DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
	DenominatorUnit : UndefinedMultipliedUnit<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorNumeratorAndDenominatorLeftUnit, DenominatorRightQuantity, DenominatorRightUnit>,
	TargetReciprocalUnit : UndefinedMultipliedUnit<NumeratorDenominatorQuantity, NumeratorDenominatorUnit, DenominatorRightQuantity, DenominatorRightUnit>,
	TargetUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorDenominatorQuantity, DenominatorRightQuantity>, TargetReciprocalUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorDenominatorQuantity, DenominatorRightQuantity>>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorDenominatorQuantity>, NumeratorUnit>.dividedByMultiplyingUnitWithNumeratorAsLeft(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorNumeratorAndDenominatorLeftQuantity, DenominatorRightQuantity>, DenominatorUnit>,
	numeratorDenominatorUnitXDenominatorRightUnit: NumeratorDenominatorUnit.(DenominatorRightUnit) -> TargetReciprocalUnit,
	reciprocalTargetUnit: TargetReciprocalUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.denominator.numeratorDenominatorUnitXDenominatorRightUnit(right.unit.right).reciprocalTargetUnit().byDividing(this, right, factory)

@JvmName("metricAndImperialDividedByMetricAndImperialMultiplyingUnitWithNumeratorAsLeft")
infix operator fun <
	NumeratorNumeratorAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorAndDenominatorLeftUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorRightQuantity : UndefinedQuantityType,
	DenominatorRightUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorDenominatorQuantity>, NumeratorUnit>.div(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorNumeratorAndDenominatorLeftQuantity, DenominatorRightQuantity>, DenominatorUnit>,
) where
	NumeratorNumeratorAndDenominatorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftQuantity>,
	NumeratorNumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorNumeratorAndDenominatorLeftUnit, NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorNumeratorAndDenominatorLeftUnit, DenominatorRightQuantity, DenominatorRightUnit>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedByMultiplyingUnitWithNumeratorAsLeft(
		right,
		numeratorDenominatorUnitXDenominatorRightUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndImperial<
			UndefinedQuantityType.Multiplying<NumeratorDenominatorQuantity, DenominatorRightQuantity>,
							UndefinedMultipliedUnit.MetricAndImperial<
					NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorRightQuantity,
					DenominatorRightUnit
				>>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDividedByMetricMultiplyingUnitWithNumeratorAsLeft")
infix operator fun <
	NumeratorNumeratorAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorAndDenominatorLeftUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorRightQuantity : UndefinedQuantityType,
	DenominatorRightUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorDenominatorQuantity>, NumeratorUnit>.div(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorNumeratorAndDenominatorLeftQuantity, DenominatorRightQuantity>, DenominatorUnit>,
) where
	NumeratorNumeratorAndDenominatorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftQuantity>,
	NumeratorNumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedDividedUnit<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorNumeratorAndDenominatorLeftUnit, NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedMultipliedUnit<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorNumeratorAndDenominatorLeftUnit, DenominatorRightQuantity, DenominatorRightUnit>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedByMultiplyingUnitWithNumeratorAsLeft(
		right,
		numeratorDenominatorUnitXDenominatorRightUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Metric<
			UndefinedQuantityType.Multiplying<NumeratorDenominatorQuantity, DenominatorRightQuantity>,
							UndefinedMultipliedUnit.Metric<
					NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorRightQuantity,
					DenominatorRightUnit
				>>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDividedByImperialMultiplyingUnitWithNumeratorAsLeft")
infix operator fun <
	NumeratorNumeratorAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorAndDenominatorLeftUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorRightQuantity : UndefinedQuantityType,
	DenominatorRightUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorDenominatorQuantity>, NumeratorUnit>.div(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorNumeratorAndDenominatorLeftQuantity, DenominatorRightQuantity>, DenominatorUnit>,
) where
	NumeratorNumeratorAndDenominatorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftQuantity>,
	NumeratorNumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorNumeratorAndDenominatorLeftUnit, NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorNumeratorAndDenominatorLeftUnit, DenominatorRightQuantity, DenominatorRightUnit>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedByMultiplyingUnitWithNumeratorAsLeft(
		right,
		numeratorDenominatorUnitXDenominatorRightUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Imperial<
			UndefinedQuantityType.Multiplying<NumeratorDenominatorQuantity, DenominatorRightQuantity>,
							UndefinedMultipliedUnit.Imperial<
					NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorRightQuantity,
					DenominatorRightUnit
				>>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDividedByUKImperialMultiplyingUnitWithNumeratorAsLeft")
infix operator fun <
	NumeratorNumeratorAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorAndDenominatorLeftUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorRightQuantity : UndefinedQuantityType,
	DenominatorRightUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorDenominatorQuantity>, NumeratorUnit>.div(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorNumeratorAndDenominatorLeftQuantity, DenominatorRightQuantity>, DenominatorUnit>,
) where
	NumeratorNumeratorAndDenominatorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftQuantity>,
	NumeratorNumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorNumeratorAndDenominatorLeftUnit, NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorNumeratorAndDenominatorLeftUnit, DenominatorRightQuantity, DenominatorRightUnit>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedByMultiplyingUnitWithNumeratorAsLeft(
		right,
		numeratorDenominatorUnitXDenominatorRightUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.UKImperial<
			UndefinedQuantityType.Multiplying<NumeratorDenominatorQuantity, DenominatorRightQuantity>,
							UndefinedMultipliedUnit.UKImperial<
					NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorRightQuantity,
					DenominatorRightUnit
				>>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDividedByUSCustomaryMultiplyingUnitWithNumeratorAsLeft")
infix operator fun <
	NumeratorNumeratorAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorAndDenominatorLeftUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorRightQuantity : UndefinedQuantityType,
	DenominatorRightUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorDenominatorQuantity>, NumeratorUnit>.div(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorNumeratorAndDenominatorLeftQuantity, DenominatorRightQuantity>, DenominatorUnit>,
) where
	NumeratorNumeratorAndDenominatorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftQuantity>,
	NumeratorNumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorNumeratorAndDenominatorLeftUnit, NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorNumeratorAndDenominatorLeftUnit, DenominatorRightQuantity, DenominatorRightUnit>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedByMultiplyingUnitWithNumeratorAsLeft(
		right,
		numeratorDenominatorUnitXDenominatorRightUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.USCustomary<
			UndefinedQuantityType.Multiplying<NumeratorDenominatorQuantity, DenominatorRightQuantity>,
							UndefinedMultipliedUnit.USCustomary<
					NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorRightQuantity,
					DenominatorRightUnit
				>>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividedByMetricAndUKImperialMultiplyingUnitWithNumeratorAsLeft")
infix operator fun <
	NumeratorNumeratorAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorAndDenominatorLeftUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorRightQuantity : UndefinedQuantityType,
	DenominatorRightUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorDenominatorQuantity>, NumeratorUnit>.div(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorNumeratorAndDenominatorLeftQuantity, DenominatorRightQuantity>, DenominatorUnit>,
) where
	NumeratorNumeratorAndDenominatorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftQuantity>,
	NumeratorNumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorNumeratorAndDenominatorLeftUnit, NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorNumeratorAndDenominatorLeftUnit, DenominatorRightQuantity, DenominatorRightUnit>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedByMultiplyingUnitWithNumeratorAsLeft(
		right,
		numeratorDenominatorUnitXDenominatorRightUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUKImperial<
			UndefinedQuantityType.Multiplying<NumeratorDenominatorQuantity, DenominatorRightQuantity>,
							UndefinedMultipliedUnit.MetricAndUKImperial<
					NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorRightQuantity,
					DenominatorRightUnit
				>>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividedByMetricAndUSCustomaryMultiplyingUnitWithNumeratorAsLeft")
infix operator fun <
	NumeratorNumeratorAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorAndDenominatorLeftUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorRightQuantity : UndefinedQuantityType,
	DenominatorRightUnit,
	DenominatorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorDenominatorQuantity>, NumeratorUnit>.div(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorNumeratorAndDenominatorLeftQuantity, DenominatorRightQuantity>, DenominatorUnit>,
) where
	NumeratorNumeratorAndDenominatorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftQuantity>,
	NumeratorNumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorNumeratorAndDenominatorLeftUnit, NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorNumeratorAndDenominatorLeftUnit, DenominatorRightQuantity, DenominatorRightUnit>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedByMultiplyingUnitWithNumeratorAsLeft(
		right,
		numeratorDenominatorUnitXDenominatorRightUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
			UndefinedQuantityType.Multiplying<NumeratorDenominatorQuantity, DenominatorRightQuantity>,
							UndefinedMultipliedUnit.MetricAndUSCustomary<
					NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorRightQuantity,
					DenominatorRightUnit
				>>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

