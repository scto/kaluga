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

// Div<A, Mul<B, C>> * C -> Div<A, B>

@JvmName("dividingWithMultiplyingDenominatorMultipliedByDenominatorRight")
fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorRightAndRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightAndRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightQuantity>,
	LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftQuantity, LeftDenominatorLeftUnit, LeftDenominatorRightAndRightQuantity, LeftDenominatorRightAndRightUnit>,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightQuantity>, LeftDenominatorUnit>,
	TargetUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, LeftDenominatorLeftQuantity, LeftDenominatorLeftUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, LeftDenominatorLeftQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightQuantity>>, LeftUnit>.multipliedByDenominatorRight(
	right: UndefinedScientificValue<LeftDenominatorRightAndRightQuantity, LeftDenominatorRightAndRightUnit>,
	leftNumeratorUnitPerLeftDenominatorLeftUnit: LeftNumeratorUnit.(LeftDenominatorLeftUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.numerator.leftNumeratorUnitPerLeftDenominatorLeftUnit(unit.denominator.left).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingDenominatorMultipliedByMetricAndImperialDenominatorRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightAndRightUnit,
	LeftDenominatorUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightQuantity>>, LeftUnit>.multipliedByDenominatorRight(
	right: UndefinedScientificValue<LeftDenominatorRightAndRightQuantity, LeftDenominatorRightAndRightUnit>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightAndRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightQuantity>,
	LeftDenominatorRightAndRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightAndRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftQuantity, LeftDenominatorLeftUnit, LeftDenominatorRightAndRightQuantity, LeftDenominatorRightAndRightUnit>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightQuantity>, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByDenominatorRight(
		right,
		leftNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				LeftNumeratorQuantity,
				LeftNumeratorUnit,
				LeftDenominatorLeftQuantity,
				LeftDenominatorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDividingWithMultiplyingDenominatorMultipliedByMetricDenominatorRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightAndRightUnit,
	LeftDenominatorUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightQuantity>>, LeftUnit>.multipliedByDenominatorRight(
	right: UndefinedScientificValue<LeftDenominatorRightAndRightQuantity, LeftDenominatorRightAndRightUnit>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightAndRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightQuantity>,
	LeftDenominatorRightAndRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftQuantity, LeftDenominatorLeftUnit, LeftDenominatorRightAndRightQuantity, LeftDenominatorRightAndRightUnit>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightQuantity>, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric =
	multipliedByDenominatorRight(
		right,
		leftNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				LeftNumeratorQuantity,
				LeftNumeratorUnit,
				LeftDenominatorLeftQuantity,
				LeftDenominatorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDividingWithMultiplyingDenominatorMultipliedByImperialDenominatorRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightAndRightUnit,
	LeftDenominatorUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightQuantity>>, LeftUnit>.multipliedByDenominatorRight(
	right: UndefinedScientificValue<LeftDenominatorRightAndRightQuantity, LeftDenominatorRightAndRightUnit>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightAndRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightQuantity>,
	LeftDenominatorRightAndRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftQuantity, LeftDenominatorLeftUnit, LeftDenominatorRightAndRightQuantity, LeftDenominatorRightAndRightUnit>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightQuantity>, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByDenominatorRight(
		right,
		leftNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				LeftNumeratorQuantity,
				LeftNumeratorUnit,
				LeftDenominatorLeftQuantity,
				LeftDenominatorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithMultiplyingDenominatorMultipliedByUKImperialDenominatorRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightAndRightUnit,
	LeftDenominatorUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightQuantity>>, LeftUnit>.multipliedByDenominatorRight(
	right: UndefinedScientificValue<LeftDenominatorRightAndRightQuantity, LeftDenominatorRightAndRightUnit>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightAndRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightQuantity>,
	LeftDenominatorRightAndRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftQuantity, LeftDenominatorLeftUnit, LeftDenominatorRightAndRightQuantity, LeftDenominatorRightAndRightUnit>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightQuantity>, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial =
	multipliedByDenominatorRight(
		right,
		leftNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				LeftNumeratorQuantity,
				LeftNumeratorUnit,
				LeftDenominatorLeftQuantity,
				LeftDenominatorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithMultiplyingDenominatorMultipliedByUSCustomaryDenominatorRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightAndRightUnit,
	LeftDenominatorUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightQuantity>>, LeftUnit>.multipliedByDenominatorRight(
	right: UndefinedScientificValue<LeftDenominatorRightAndRightQuantity, LeftDenominatorRightAndRightUnit>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightAndRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightQuantity>,
	LeftDenominatorRightAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftQuantity, LeftDenominatorLeftUnit, LeftDenominatorRightAndRightQuantity, LeftDenominatorRightAndRightUnit>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightQuantity>, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByDenominatorRight(
		right,
		leftNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				LeftNumeratorQuantity,
				LeftNumeratorUnit,
				LeftDenominatorLeftQuantity,
				LeftDenominatorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithMultiplyingDenominatorMultipliedByMetricAndUKImperialDenominatorRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightAndRightUnit,
	LeftDenominatorUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightQuantity>>, LeftUnit>.multipliedByDenominatorRight(
	right: UndefinedScientificValue<LeftDenominatorRightAndRightQuantity, LeftDenominatorRightAndRightUnit>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightAndRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightQuantity>,
	LeftDenominatorRightAndRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightAndRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftQuantity, LeftDenominatorLeftUnit, LeftDenominatorRightAndRightQuantity, LeftDenominatorRightAndRightUnit>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightQuantity>, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial =
	multipliedByDenominatorRight(
		right,
		leftNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				LeftNumeratorQuantity,
				LeftNumeratorUnit,
				LeftDenominatorLeftQuantity,
				LeftDenominatorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithMultiplyingDenominatorMultipliedByMetricAndUSCustomaryDenominatorRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightAndRightUnit,
	LeftDenominatorUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightQuantity>>, LeftUnit>.multipliedByDenominatorRight(
	right: UndefinedScientificValue<LeftDenominatorRightAndRightQuantity, LeftDenominatorRightAndRightUnit>,
) where
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightAndRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightQuantity>,
	LeftDenominatorRightAndRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftQuantity, LeftDenominatorLeftUnit, LeftDenominatorRightAndRightQuantity, LeftDenominatorRightAndRightUnit>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftQuantity, LeftDenominatorRightAndRightQuantity>, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByDenominatorRight(
		right,
		leftNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				LeftNumeratorQuantity,
				LeftNumeratorUnit,
				LeftDenominatorLeftQuantity,
				LeftDenominatorLeftUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

