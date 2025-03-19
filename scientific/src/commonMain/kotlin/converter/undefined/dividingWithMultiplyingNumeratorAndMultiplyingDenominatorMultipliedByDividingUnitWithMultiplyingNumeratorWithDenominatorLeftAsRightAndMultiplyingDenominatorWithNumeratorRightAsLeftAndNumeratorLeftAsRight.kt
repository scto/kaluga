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
import kotlin.jvm.JvmName

// Div<Mul<A, B>, Mul<C, D>> * Div<Mul<E, C>, Mul<B, A>> -> Div<E, D>

@JvmName(
    "dividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight",
)
fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
    LeftNumeratorUnit : UndefinedMultipliedUnit<
        LeftNumeratorLeftAndRightDenominatorRightQuantity,
        LeftNumeratorLeftUnit,
        LeftNumeratorRightAndRightDenominatorLeftQuantity,
        LeftNumeratorRightUnit,
        >,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
    LeftDenominatorUnit : UndefinedMultipliedUnit<
        LeftDenominatorLeftAndRightNumeratorRightQuantity,
        LeftDenominatorLeftUnit,
        LeftDenominatorRightQuantity,
        LeftDenominatorRightUnit,
        >,
    LeftUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        LeftNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorRightQuantity,
            >,
        LeftDenominatorUnit,
        >,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
    RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
    RightNumeratorUnit : UndefinedMultipliedUnit<
        RightNumeratorLeftQuantity,
        RightNumeratorLeftUnit,
        LeftDenominatorLeftAndRightNumeratorRightQuantity,
        RightNumeratorRightUnit,
        >,
    RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
    RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
    RightDenominatorUnit : UndefinedMultipliedUnit<
        LeftNumeratorRightAndRightDenominatorLeftQuantity,
        RightDenominatorLeftUnit,
        LeftNumeratorLeftAndRightDenominatorRightQuantity,
        RightDenominatorRightUnit,
        >,
    RightUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            RightNumeratorLeftQuantity,
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            >,
        RightNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            >,
        RightDenominatorUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        RightNumeratorLeftQuantity,
        RightNumeratorLeftUnit,
        LeftDenominatorRightQuantity,
        LeftDenominatorRightUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorLeftQuantity,
            LeftDenominatorRightQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
    rightNumeratorLeftUnitPerLeftDenominatorRightUnit: RightNumeratorLeftUnit.(LeftDenominatorRightUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.numerator.left.rightNumeratorLeftUnitPerLeftDenominatorRightUnit(
    unit.denominator.right,
).byMultiplying(this, right, factory)

@JvmName(
    "metricAndImperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                LeftDenominatorRightQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        rightNumeratorLeftUnitPerLeftDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                RightNumeratorLeftQuantity,
                RightNumeratorLeftUnit,
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "metricDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByMetricDividingUnitWithMultiplyingNumeratorWithDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                LeftDenominatorRightQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(
        right,
        rightNumeratorLeftUnitPerLeftDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                RightNumeratorLeftQuantity,
                RightNumeratorLeftUnit,
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "imperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByImperialDividingUnitWithMultiplyingNumeratorWithDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorRightQuantity,
            >,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                LeftDenominatorRightQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        rightNumeratorLeftUnitPerLeftDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                RightNumeratorLeftQuantity,
                RightNumeratorLeftUnit,
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "ukImperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByUKImperialDividingUnitWithMultiplyingNumeratorWithDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorRightQuantity,
            >,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                LeftDenominatorRightQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        rightNumeratorLeftUnitPerLeftDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                RightNumeratorLeftQuantity,
                RightNumeratorLeftUnit,
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "usCustomaryDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorRightQuantity,
            >,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                LeftDenominatorRightQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        rightNumeratorLeftUnitPerLeftDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                RightNumeratorLeftQuantity,
                RightNumeratorLeftUnit,
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "metricAndUKImperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                LeftDenominatorRightQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        rightNumeratorLeftUnitPerLeftDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                RightNumeratorLeftQuantity,
                RightNumeratorLeftUnit,
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "metricAndUSCustomaryDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                LeftDenominatorRightQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        rightNumeratorLeftUnitPerLeftDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                RightNumeratorLeftQuantity,
                RightNumeratorLeftUnit,
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
