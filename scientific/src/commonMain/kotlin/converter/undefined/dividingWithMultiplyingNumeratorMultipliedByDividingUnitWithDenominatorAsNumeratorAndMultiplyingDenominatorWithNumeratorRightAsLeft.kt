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

// Div<Mul<A, B>, C> * Div<C, Mul<B, D>> -> Div<A, D>

@JvmName("dividingWithMultiplyingNumeratorMultipliedByDividingUnitWithDenominatorAsNumeratorAndMultiplyingDenominatorWithNumeratorRightAsLeft")
fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
    LeftNumeratorUnit : UndefinedMultipliedUnit<
        LeftNumeratorLeftQuantity,
        LeftNumeratorLeftUnit,
        LeftNumeratorRightAndRightDenominatorLeftQuantity,
        LeftNumeratorRightUnit,
        >,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
    LeftUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        LeftNumeratorUnit,
        LeftDenominatorAndRightNumeratorQuantity,
        LeftDenominatorUnit,
        >,
    RightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
    RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
    RightDenominatorUnit : UndefinedMultipliedUnit<
        LeftNumeratorRightAndRightDenominatorLeftQuantity,
        RightDenominatorLeftUnit,
        RightDenominatorRightQuantity,
        RightDenominatorRightUnit,
        >,
    RightUnit : UndefinedDividedUnit<
        LeftDenominatorAndRightNumeratorQuantity,
        RightNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            RightDenominatorRightQuantity,
            >,
        RightDenominatorUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        LeftNumeratorLeftQuantity,
        LeftNumeratorLeftUnit,
        RightDenominatorRightQuantity,
        RightDenominatorRightUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftNumeratorLeftQuantity,
            RightDenominatorRightQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        LeftDenominatorAndRightNumeratorQuantity,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftDenominatorAndRightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
    leftNumeratorLeftUnitPerRightDenominatorRightUnit: LeftNumeratorLeftUnit.(RightDenominatorRightUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.left.leftNumeratorLeftUnitPerRightDenominatorRightUnit(
    right.unit.denominator.right,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingNumeratorMultipliedByMetricAndImperialDividingUnitWithDenominatorAsNumeratorAndMultiplyingDenominatorWithNumeratorRightAsLeft")
infix fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        LeftDenominatorAndRightNumeratorQuantity,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftDenominatorAndRightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            LeftDenominatorAndRightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftNumeratorLeftUnitPerRightDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                LeftNumeratorLeftQuantity,
                LeftNumeratorLeftUnit,
                RightDenominatorRightQuantity,
                RightDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDividingWithMultiplyingNumeratorMultipliedByMetricDividingUnitWithDenominatorAsNumeratorAndMultiplyingDenominatorWithNumeratorRightAsLeft")
infix fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        LeftDenominatorAndRightNumeratorQuantity,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftDenominatorAndRightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<
            LeftDenominatorAndRightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(
        right,
        leftNumeratorLeftUnitPerRightDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                LeftNumeratorLeftQuantity,
                LeftNumeratorLeftUnit,
                RightDenominatorRightQuantity,
                RightDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDividingWithMultiplyingNumeratorMultipliedByImperialDividingUnitWithDenominatorAsNumeratorAndMultiplyingDenominatorWithNumeratorRightAsLeft")
infix fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        LeftDenominatorAndRightNumeratorQuantity,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftDenominatorAndRightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            LeftDenominatorAndRightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftNumeratorLeftUnitPerRightDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                LeftNumeratorLeftQuantity,
                LeftNumeratorLeftUnit,
                RightDenominatorRightQuantity,
                RightDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDividingWithMultiplyingNumeratorMultipliedByUKImperialDividingUnitWithDenominatorAsNumeratorAndMultiplyingDenominatorWithNumeratorRightAsLeft")
infix fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        LeftDenominatorAndRightNumeratorQuantity,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftDenominatorAndRightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            LeftDenominatorAndRightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftNumeratorLeftUnitPerRightDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                LeftNumeratorLeftQuantity,
                LeftNumeratorLeftUnit,
                RightDenominatorRightQuantity,
                RightDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingWithMultiplyingNumeratorMultipliedByUSCustomaryDividingUnitWithDenominatorAsNumeratorAndMultiplyingDenominatorWithNumeratorRightAsLeft")
infix fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        LeftDenominatorAndRightNumeratorQuantity,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftDenominatorAndRightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            LeftDenominatorAndRightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftNumeratorLeftUnitPerRightDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                LeftNumeratorLeftQuantity,
                LeftNumeratorLeftUnit,
                RightDenominatorRightQuantity,
                RightDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "metricAndUKImperialDividingWithMultiplyingNumeratorMultipliedByMetricAndUKImperialDividingUnitWithDenominatorAsNumeratorAndMultiplyingDenominatorWithNumeratorRightAsLeft",
)
infix fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        LeftDenominatorAndRightNumeratorQuantity,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftDenominatorAndRightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            LeftDenominatorAndRightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftNumeratorLeftUnitPerRightDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                LeftNumeratorLeftQuantity,
                LeftNumeratorLeftUnit,
                RightDenominatorRightQuantity,
                RightDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "metricAndUSCustomaryDividingWithMultiplyingNumeratorMultipliedByMetricAndUSCustomaryDividingUnitWithDenominatorAsNumeratorAndMultiplyingDenominatorWithNumeratorRightAsLeft",
)
infix fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftQuantity,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            >,
        LeftDenominatorAndRightNumeratorQuantity,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftDenominatorAndRightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftQuantity,
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            LeftDenominatorAndRightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftNumeratorLeftUnitPerRightDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                LeftNumeratorLeftQuantity,
                LeftNumeratorLeftUnit,
                RightDenominatorRightQuantity,
                RightDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
