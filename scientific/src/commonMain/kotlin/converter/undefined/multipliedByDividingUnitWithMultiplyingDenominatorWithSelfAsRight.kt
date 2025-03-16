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

// A * Div<B, Mul<C, A>> -> Div<B, C>

@JvmName("multipliedByDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
fun <
    LeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftAndRightDenominatorRightQuantity>,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
    RightDenominatorUnit : UndefinedMultipliedUnit<RightDenominatorLeftQuantity, RightDenominatorLeftUnit, LeftAndRightDenominatorRightQuantity, LeftAndRightDenominatorRightUnit>,
    RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
    TargetUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, RightDenominatorLeftQuantity, RightDenominatorLeftUnit>,
    TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, RightDenominatorLeftQuantity>, TargetUnit>,
    > UndefinedScientificValue<LeftAndRightDenominatorRightQuantity, LeftAndRightDenominatorRightUnit>.multipliedByDividingUnitWithMultiplyingDenominatorWithSelfAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftAndRightDenominatorRightQuantity>>, RightUnit>,
    rightNumeratorUnitPerRightDenominatorLeftUnit: RightNumeratorUnit.(RightDenominatorLeftUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.numerator.rightNumeratorUnitPerRightDenominatorLeftUnit(right.unit.denominator.left).byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultipliedByMetricAndImperialDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
    LeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftAndRightDenominatorRightUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<LeftAndRightDenominatorRightQuantity, LeftAndRightDenominatorRightUnit>.multipliedByDividingUnitWithMultiplyingDenominatorWithSelfAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftAndRightDenominatorRightQuantity>,
        LeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<RightDenominatorLeftQuantity, RightDenominatorLeftUnit, LeftAndRightDenominatorRightQuantity, LeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDividingUnitWithMultiplyingDenominatorWithSelfAsRight(
        right,
        rightNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricMultipliedByMetricDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
    LeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftAndRightDenominatorRightUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<LeftAndRightDenominatorRightQuantity, LeftAndRightDenominatorRightUnit>.multipliedByDividingUnitWithMultiplyingDenominatorWithSelfAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftAndRightDenominatorRightQuantity>,
        LeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : UndefinedMultipliedUnit<RightDenominatorLeftQuantity, RightDenominatorLeftUnit, LeftAndRightDenominatorRightQuantity, LeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedByDividingUnitWithMultiplyingDenominatorWithSelfAsRight(
        right,
        rightNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialMultipliedByImperialDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
    LeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftAndRightDenominatorRightUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<LeftAndRightDenominatorRightQuantity, LeftAndRightDenominatorRightUnit>.multipliedByDividingUnitWithMultiplyingDenominatorWithSelfAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftAndRightDenominatorRightQuantity>,
        LeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<RightDenominatorLeftQuantity, RightDenominatorLeftUnit, LeftAndRightDenominatorRightQuantity, LeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDividingUnitWithMultiplyingDenominatorWithSelfAsRight(
        right,
        rightNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialMultipliedByUKImperialDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
    LeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftAndRightDenominatorRightUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<LeftAndRightDenominatorRightQuantity, LeftAndRightDenominatorRightUnit>.multipliedByDividingUnitWithMultiplyingDenominatorWithSelfAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftAndRightDenominatorRightQuantity>,
        LeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedMultipliedUnit<RightDenominatorLeftQuantity, RightDenominatorLeftUnit, LeftAndRightDenominatorRightQuantity, LeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByDividingUnitWithMultiplyingDenominatorWithSelfAsRight(
        right,
        rightNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryMultipliedByUSCustomaryDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
    LeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftAndRightDenominatorRightUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<LeftAndRightDenominatorRightQuantity, LeftAndRightDenominatorRightUnit>.multipliedByDividingUnitWithMultiplyingDenominatorWithSelfAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftAndRightDenominatorRightQuantity>,
        LeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<RightDenominatorLeftQuantity, RightDenominatorLeftUnit, LeftAndRightDenominatorRightQuantity, LeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDividingUnitWithMultiplyingDenominatorWithSelfAsRight(
        right,
        rightNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultipliedByMetricAndUKImperialDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
    LeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftAndRightDenominatorRightUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<LeftAndRightDenominatorRightQuantity, LeftAndRightDenominatorRightUnit>.multipliedByDividingUnitWithMultiplyingDenominatorWithSelfAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftAndRightDenominatorRightQuantity>,
        LeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedMultipliedUnit<RightDenominatorLeftQuantity, RightDenominatorLeftUnit, LeftAndRightDenominatorRightQuantity, LeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByDividingUnitWithMultiplyingDenominatorWithSelfAsRight(
        right,
        rightNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultipliedByMetricAndUSCustomaryDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
    LeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftAndRightDenominatorRightUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<LeftAndRightDenominatorRightQuantity, LeftAndRightDenominatorRightUnit>.multipliedByDividingUnitWithMultiplyingDenominatorWithSelfAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftAndRightDenominatorRightQuantity>,
        LeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<RightDenominatorLeftQuantity, RightDenominatorLeftUnit, LeftAndRightDenominatorRightQuantity, LeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDividingUnitWithMultiplyingDenominatorWithSelfAsRight(
        right,
        rightNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
