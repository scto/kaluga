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
import kotlin.jvm.JvmName

// Div<Mul<A, B>, C> * Div<Mul<D, C>, Mul<B, A>> -> D

@JvmName(
    "dividingWithMultiplyingNumeratorMultipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight",
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
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
    LeftUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        LeftNumeratorUnit,
        LeftDenominatorAndRightNumeratorRightQuantity,
        LeftDenominatorUnit,
        >,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
    RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
    RightNumeratorUnit : UndefinedMultipliedUnit<
        RightNumeratorLeftQuantity,
        RightNumeratorLeftUnit,
        LeftDenominatorAndRightNumeratorRightQuantity,
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
            LeftDenominatorAndRightNumeratorRightQuantity,
            >,
        RightNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            >,
        RightDenominatorUnit,
        >,
    RightNumeratorLeftValue : UndefinedScientificValue<
        RightNumeratorLeftQuantity,
        RightNumeratorLeftUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        LeftDenominatorAndRightNumeratorRightQuantity,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
    factory: (Decimal, RightNumeratorLeftUnit) -> RightNumeratorLeftValue,
) = right.unit.numerator.left.byMultiplying(this, right, factory)

@JvmName(
    "metricAndImperialDividingWithMultiplyingNumeratorMultipliedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
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
        LeftDenominatorAndRightNumeratorRightQuantity,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorAndRightNumeratorRightQuantity,
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
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
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
                LeftDenominatorAndRightNumeratorRightQuantity,
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
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "metricDividingWithMultiplyingNumeratorMultipliedByMetricDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
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
        LeftDenominatorAndRightNumeratorRightQuantity,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorAndRightNumeratorRightQuantity,
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
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
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
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "imperialDividingWithMultiplyingNumeratorMultipliedByImperialDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
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
        LeftDenominatorAndRightNumeratorRightQuantity,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorAndRightNumeratorRightQuantity,
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
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
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
                LeftDenominatorAndRightNumeratorRightQuantity,
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
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "ukImperialDividingWithMultiplyingNumeratorMultipliedByUKImperialDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
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
        LeftDenominatorAndRightNumeratorRightQuantity,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorAndRightNumeratorRightQuantity,
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
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
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
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "usCustomaryDividingWithMultiplyingNumeratorMultipliedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
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
        LeftDenominatorAndRightNumeratorRightQuantity,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorAndRightNumeratorRightQuantity,
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
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
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
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "metricAndUKImperialDividingWithMultiplyingNumeratorMultipliedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
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
        LeftDenominatorAndRightNumeratorRightQuantity,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorAndRightNumeratorRightQuantity,
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
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
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
                LeftDenominatorAndRightNumeratorRightQuantity,
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
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "metricAndUSCustomaryDividingWithMultiplyingNumeratorMultipliedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
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
        LeftDenominatorAndRightNumeratorRightQuantity,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorAndRightNumeratorRightQuantity,
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
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
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
                LeftDenominatorAndRightNumeratorRightQuantity,
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
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "genericDividingWithMultiplyingNumeratorMultipliedByGenericDividingUnitWithMultiplyingNumeratorWithDenominatorAsRightAndMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight",
)
infix fun <
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
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
    LeftUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        LeftNumeratorUnit,
        LeftDenominatorAndRightNumeratorRightQuantity,
        LeftDenominatorUnit,
        >,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
    RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
    RightNumeratorUnit : UndefinedMultipliedUnit<
        RightNumeratorLeftQuantity,
        RightNumeratorLeftUnit,
        LeftDenominatorAndRightNumeratorRightQuantity,
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
            LeftDenominatorAndRightNumeratorRightQuantity,
            >,
        RightNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            >,
        RightDenominatorUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightDenominatorRightQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        LeftDenominatorAndRightNumeratorRightQuantity,
        >,
    LeftUnit,
    >.genericMultipliedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                LeftNumeratorLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) = multipliedBy(right) {
        value: Decimal,
        unit: RightNumeratorLeftUnit,
    ->
    DefaultUndefinedScientificValue(value, unit)
}
