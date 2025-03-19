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
import com.splendo.kaluga.scientific.DefaultUndefinedScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Div<Mul<A, B>, Mul<C, D>> * Div<Mul<D, E>, Mul<A, F>> -> Div<Mul<B, E>, Mul<C, F>>

@JvmName(
    "dividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndMultiplyingDenominatorWithNumeratorLeftAsLeft",
)
fun <
    LeftNumeratorLeftAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorLeftQuantity>,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
    LeftNumeratorUnit : UndefinedMultipliedUnit<
        LeftNumeratorLeftAndRightDenominatorLeftQuantity,
        LeftNumeratorLeftUnit,
        LeftNumeratorRightQuantity,
        LeftNumeratorRightUnit,
        >,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
    LeftDenominatorUnit : UndefinedMultipliedUnit<
        LeftDenominatorLeftQuantity,
        LeftDenominatorLeftUnit,
        LeftDenominatorRightAndRightNumeratorLeftQuantity,
        LeftDenominatorRightUnit,
        >,
    LeftUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            LeftNumeratorRightQuantity,
            >,
        LeftNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            >,
        LeftDenominatorUnit,
        >,
    RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
    RightNumeratorRightQuantity : UndefinedQuantityType,
    RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
    RightNumeratorUnit : UndefinedMultipliedUnit<
        LeftDenominatorRightAndRightNumeratorLeftQuantity,
        RightNumeratorLeftUnit,
        RightNumeratorRightQuantity,
        RightNumeratorRightUnit,
        >,
    RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorLeftQuantity>,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
    RightDenominatorUnit : UndefinedMultipliedUnit<
        LeftNumeratorLeftAndRightDenominatorLeftQuantity,
        RightDenominatorLeftUnit,
        RightDenominatorRightQuantity,
        RightDenominatorRightUnit,
        >,
    RightUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            RightNumeratorRightQuantity,
            >,
        RightNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            RightDenominatorRightQuantity,
            >,
        RightDenominatorUnit,
        >,
    TargetNumeratorUnit : UndefinedMultipliedUnit<
        LeftNumeratorRightQuantity,
        LeftNumeratorRightUnit,
        RightNumeratorRightQuantity,
        RightNumeratorRightUnit,
        >,
    TargetDenominatorUnit : UndefinedMultipliedUnit<
        LeftDenominatorLeftQuantity,
        LeftDenominatorLeftUnit,
        RightDenominatorRightQuantity,
        RightDenominatorRightUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorRightQuantity,
            RightNumeratorRightQuantity,
            >,
        TargetNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            RightDenominatorRightQuantity,
            >,
        TargetDenominatorUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightQuantity,
                RightNumeratorRightQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            LeftNumeratorRightQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                RightNumeratorRightQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
    leftNumeratorRightUnitXRightNumeratorRightUnit: LeftNumeratorRightUnit.(RightNumeratorRightUnit) -> TargetNumeratorUnit,
    leftDenominatorLeftUnitXRightDenominatorRightUnit: LeftDenominatorLeftUnit.(RightDenominatorRightUnit) -> TargetDenominatorUnit,
    targetNumeratorUnitPerTargetDenominatorUnit: TargetNumeratorUnit.(TargetDenominatorUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.right.leftNumeratorRightUnitXRightNumeratorRightUnit(
    right.unit.numerator.right,
).targetNumeratorUnitPerTargetDenominatorUnit(
    unit.denominator.left.leftDenominatorLeftUnitXRightDenominatorRightUnit(
        right.unit.denominator.right,
    ),
).byMultiplying(this, right, factory)

@JvmName(
    "metricAndImperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndMultiplyingDenominatorWithNumeratorLeftAsLeft",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftUnit,
    RightNumeratorRightQuantity : UndefinedQuantityType,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            LeftNumeratorRightQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                RightNumeratorRightQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                LeftNumeratorRightQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            RightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                RightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftNumeratorRightUnitXRightNumeratorRightUnit = { x(it) },
        leftDenominatorLeftUnitXRightDenominatorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                UndefinedQuantityType.Multiplying<
                    LeftNumeratorRightQuantity,
                    RightNumeratorRightQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndImperial<
                    LeftNumeratorRightQuantity,
                    LeftNumeratorRightUnit,
                    RightNumeratorRightQuantity,
                    RightNumeratorRightUnit,
                    >,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorLeftQuantity,
                    RightDenominatorRightQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndImperial<
                    LeftDenominatorLeftQuantity,
                    LeftDenominatorLeftUnit,
                    RightDenominatorRightQuantity,
                    RightDenominatorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "metricDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByMetricDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndMultiplyingDenominatorWithNumeratorLeftAsLeft",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftUnit,
    RightNumeratorRightQuantity : UndefinedQuantityType,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            LeftNumeratorRightQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            >,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                RightNumeratorRightQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                LeftNumeratorRightQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            RightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                RightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(
        right,
        leftNumeratorRightUnitXRightNumeratorRightUnit = { x(it) },
        leftDenominatorLeftUnitXRightDenominatorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                UndefinedQuantityType.Multiplying<
                    LeftNumeratorRightQuantity,
                    RightNumeratorRightQuantity,
                    >,
                UndefinedMultipliedUnit.Metric<
                    LeftNumeratorRightQuantity,
                    LeftNumeratorRightUnit,
                    RightNumeratorRightQuantity,
                    RightNumeratorRightUnit,
                    >,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorLeftQuantity,
                    RightDenominatorRightQuantity,
                    >,
                UndefinedMultipliedUnit.Metric<
                    LeftDenominatorLeftQuantity,
                    LeftDenominatorLeftUnit,
                    RightDenominatorRightQuantity,
                    RightDenominatorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "imperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByImperialDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndMultiplyingDenominatorWithNumeratorLeftAsLeft",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftUnit,
    RightNumeratorRightQuantity : UndefinedQuantityType,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            LeftNumeratorRightQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            >,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                RightNumeratorRightQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                LeftNumeratorRightQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            RightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                RightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftNumeratorRightUnitXRightNumeratorRightUnit = { x(it) },
        leftDenominatorLeftUnitXRightDenominatorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                UndefinedQuantityType.Multiplying<
                    LeftNumeratorRightQuantity,
                    RightNumeratorRightQuantity,
                    >,
                UndefinedMultipliedUnit.Imperial<
                    LeftNumeratorRightQuantity,
                    LeftNumeratorRightUnit,
                    RightNumeratorRightQuantity,
                    RightNumeratorRightUnit,
                    >,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorLeftQuantity,
                    RightDenominatorRightQuantity,
                    >,
                UndefinedMultipliedUnit.Imperial<
                    LeftDenominatorLeftQuantity,
                    LeftDenominatorLeftUnit,
                    RightDenominatorRightQuantity,
                    RightDenominatorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "ukImperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByUKImperialDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndMultiplyingDenominatorWithNumeratorLeftAsLeft",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftUnit,
    RightNumeratorRightQuantity : UndefinedQuantityType,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            LeftNumeratorRightQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            >,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                RightNumeratorRightQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                LeftNumeratorRightQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            RightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                RightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftNumeratorRightUnitXRightNumeratorRightUnit = { x(it) },
        leftDenominatorLeftUnitXRightDenominatorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                UndefinedQuantityType.Multiplying<
                    LeftNumeratorRightQuantity,
                    RightNumeratorRightQuantity,
                    >,
                UndefinedMultipliedUnit.UKImperial<
                    LeftNumeratorRightQuantity,
                    LeftNumeratorRightUnit,
                    RightNumeratorRightQuantity,
                    RightNumeratorRightUnit,
                    >,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorLeftQuantity,
                    RightDenominatorRightQuantity,
                    >,
                UndefinedMultipliedUnit.UKImperial<
                    LeftDenominatorLeftQuantity,
                    LeftDenominatorLeftUnit,
                    RightDenominatorRightQuantity,
                    RightDenominatorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "usCustomaryDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndMultiplyingDenominatorWithNumeratorLeftAsLeft",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftUnit,
    RightNumeratorRightQuantity : UndefinedQuantityType,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            LeftNumeratorRightQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            >,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                RightNumeratorRightQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                LeftNumeratorRightQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            RightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                RightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftNumeratorRightUnitXRightNumeratorRightUnit = { x(it) },
        leftDenominatorLeftUnitXRightDenominatorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                UndefinedQuantityType.Multiplying<
                    LeftNumeratorRightQuantity,
                    RightNumeratorRightQuantity,
                    >,
                UndefinedMultipliedUnit.USCustomary<
                    LeftNumeratorRightQuantity,
                    LeftNumeratorRightUnit,
                    RightNumeratorRightQuantity,
                    RightNumeratorRightUnit,
                    >,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorLeftQuantity,
                    RightDenominatorRightQuantity,
                    >,
                UndefinedMultipliedUnit.USCustomary<
                    LeftDenominatorLeftQuantity,
                    LeftDenominatorLeftUnit,
                    RightDenominatorRightQuantity,
                    RightDenominatorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "metricAndUKImperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndMultiplyingDenominatorWithNumeratorLeftAsLeft",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftUnit,
    RightNumeratorRightQuantity : UndefinedQuantityType,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            LeftNumeratorRightQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                RightNumeratorRightQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                LeftNumeratorRightQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            RightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                RightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftNumeratorRightUnitXRightNumeratorRightUnit = { x(it) },
        leftDenominatorLeftUnitXRightDenominatorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                UndefinedQuantityType.Multiplying<
                    LeftNumeratorRightQuantity,
                    RightNumeratorRightQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUKImperial<
                    LeftNumeratorRightQuantity,
                    LeftNumeratorRightUnit,
                    RightNumeratorRightQuantity,
                    RightNumeratorRightUnit,
                    >,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorLeftQuantity,
                    RightDenominatorRightQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUKImperial<
                    LeftDenominatorLeftQuantity,
                    LeftDenominatorLeftUnit,
                    RightDenominatorRightQuantity,
                    RightDenominatorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "metricAndUSCustomaryDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndMultiplyingDenominatorWithNumeratorLeftAsLeft",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftUnit,
    RightNumeratorRightQuantity : UndefinedQuantityType,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            LeftNumeratorRightQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                RightNumeratorRightQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                LeftNumeratorRightQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            RightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                RightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftNumeratorRightUnitXRightNumeratorRightUnit = { x(it) },
        leftDenominatorLeftUnitXRightDenominatorRightUnit = { x(it) },
        targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                UndefinedQuantityType.Multiplying<
                    LeftNumeratorRightQuantity,
                    RightNumeratorRightQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUSCustomary<
                    LeftNumeratorRightQuantity,
                    LeftNumeratorRightUnit,
                    RightNumeratorRightQuantity,
                    RightNumeratorRightUnit,
                    >,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorLeftQuantity,
                    RightDenominatorRightQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUSCustomary<
                    LeftDenominatorLeftQuantity,
                    LeftDenominatorLeftUnit,
                    RightDenominatorRightQuantity,
                    RightDenominatorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
