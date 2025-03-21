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
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Inv<Mul<A, B>> * Div<Mul<C, B>, D> -> Div<C, Mul<A, D>>

@JvmName("reciprocalMultiplyingMultipliedByDividingUnitWithMultiplyingNumeratorWithRightAsRight")
fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
    LeftReciprocalRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorRightQuantity>,
    LeftReciprocalUnit : UndefinedMultipliedUnit<
        LeftReciprocalLeftQuantity,
        LeftReciprocalLeftUnit,
        LeftReciprocalRightAndRightNumeratorRightQuantity,
        LeftReciprocalRightUnit,
        >,
    LeftUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftQuantity,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            >,
        LeftReciprocalUnit,
        >,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit : AbstractUndefinedScientificUnit<RightNumeratorLeftQuantity>,
    RightNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorRightQuantity>,
    RightNumeratorUnit : UndefinedMultipliedUnit<
        RightNumeratorLeftQuantity,
        RightNumeratorLeftUnit,
        LeftReciprocalRightAndRightNumeratorRightQuantity,
        RightNumeratorRightUnit,
        >,
    RightDenominatorQuantity : UndefinedQuantityType,
    RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
    RightUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            RightNumeratorLeftQuantity,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            >,
        RightNumeratorUnit,
        RightDenominatorQuantity,
        RightDenominatorUnit,
        >,
    TargetDenominatorUnit : UndefinedMultipliedUnit<
        LeftReciprocalLeftQuantity,
        LeftReciprocalLeftUnit,
        RightDenominatorQuantity,
        RightDenominatorUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        RightNumeratorLeftQuantity,
        RightNumeratorLeftUnit,
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftQuantity,
            RightDenominatorQuantity,
            >,
        TargetDenominatorUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorLeftQuantity,
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftQuantity,
                RightDenominatorQuantity,
                >,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftQuantity,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            RightDenominatorQuantity,
            >,
        RightUnit,
        >,
    leftReciprocalLeftUnitXRightDenominatorUnit: LeftReciprocalLeftUnit.(RightDenominatorUnit) -> TargetDenominatorUnit,
    rightNumeratorLeftUnitPerTargetDenominatorUnit: RightNumeratorLeftUnit.(TargetDenominatorUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.numerator.left.rightNumeratorLeftUnitPerTargetDenominatorUnit(
    unit.inverse.left.leftReciprocalLeftUnitXRightDenominatorUnit(
        right.unit.denominator,
    ),
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultiplyingMultipliedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithRightAsRight")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorQuantity : UndefinedQuantityType,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftQuantity,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            RightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftQuantity,
            LeftReciprocalLeftUnit,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : AbstractUndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            RightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftReciprocalLeftUnitXRightDenominatorUnit = { x(it) },
        rightNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                RightNumeratorLeftQuantity,
                RightNumeratorLeftUnit,
                UndefinedQuantityType.Multiplying<
                    LeftReciprocalLeftQuantity,
                    RightDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndImperial<
                    LeftReciprocalLeftQuantity,
                    LeftReciprocalLeftUnit,
                    RightDenominatorQuantity,
                    RightDenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricReciprocalMultiplyingMultipliedByMetricDividingUnitWithMultiplyingNumeratorWithRightAsRight")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorQuantity : UndefinedQuantityType,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftQuantity,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            RightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftQuantity,
            LeftReciprocalLeftUnit,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : AbstractUndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            RightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(
        right,
        leftReciprocalLeftUnitXRightDenominatorUnit = { x(it) },
        rightNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                RightNumeratorLeftQuantity,
                RightNumeratorLeftUnit,
                UndefinedQuantityType.Multiplying<
                    LeftReciprocalLeftQuantity,
                    RightDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.Metric<
                    LeftReciprocalLeftQuantity,
                    LeftReciprocalLeftUnit,
                    RightDenominatorQuantity,
                    RightDenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialReciprocalMultiplyingMultipliedByImperialDividingUnitWithMultiplyingNumeratorWithRightAsRight")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorQuantity : UndefinedQuantityType,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftQuantity,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            >,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            RightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftQuantity,
            LeftReciprocalLeftUnit,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : AbstractUndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            RightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftReciprocalLeftUnitXRightDenominatorUnit = { x(it) },
        rightNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                RightNumeratorLeftQuantity,
                RightNumeratorLeftUnit,
                UndefinedQuantityType.Multiplying<
                    LeftReciprocalLeftQuantity,
                    RightDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.Imperial<
                    LeftReciprocalLeftQuantity,
                    LeftReciprocalLeftUnit,
                    RightDenominatorQuantity,
                    RightDenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialReciprocalMultiplyingMultipliedByUKImperialDividingUnitWithMultiplyingNumeratorWithRightAsRight")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorQuantity : UndefinedQuantityType,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftQuantity,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            >,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            RightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftQuantity,
            LeftReciprocalLeftUnit,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : AbstractUndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            RightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftReciprocalLeftUnitXRightDenominatorUnit = { x(it) },
        rightNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                RightNumeratorLeftQuantity,
                RightNumeratorLeftUnit,
                UndefinedQuantityType.Multiplying<
                    LeftReciprocalLeftQuantity,
                    RightDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.UKImperial<
                    LeftReciprocalLeftQuantity,
                    LeftReciprocalLeftUnit,
                    RightDenominatorQuantity,
                    RightDenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryReciprocalMultiplyingMultipliedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithRightAsRight")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorQuantity : UndefinedQuantityType,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftQuantity,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            >,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            RightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftQuantity,
            LeftReciprocalLeftUnit,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : AbstractUndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            RightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftReciprocalLeftUnitXRightDenominatorUnit = { x(it) },
        rightNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                RightNumeratorLeftQuantity,
                RightNumeratorLeftUnit,
                UndefinedQuantityType.Multiplying<
                    LeftReciprocalLeftQuantity,
                    RightDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.USCustomary<
                    LeftReciprocalLeftQuantity,
                    LeftReciprocalLeftUnit,
                    RightDenominatorQuantity,
                    RightDenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialReciprocalMultiplyingMultipliedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithRightAsRight")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorQuantity : UndefinedQuantityType,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftQuantity,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            RightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftQuantity,
            LeftReciprocalLeftUnit,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : AbstractUndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            RightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftReciprocalLeftUnitXRightDenominatorUnit = { x(it) },
        rightNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                RightNumeratorLeftQuantity,
                RightNumeratorLeftUnit,
                UndefinedQuantityType.Multiplying<
                    LeftReciprocalLeftQuantity,
                    RightDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUKImperial<
                    LeftReciprocalLeftQuantity,
                    LeftReciprocalLeftUnit,
                    RightDenominatorQuantity,
                    RightDenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryReciprocalMultiplyingMultipliedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithRightAsRight")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : UndefinedQuantityType,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorQuantity : UndefinedQuantityType,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftQuantity,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            RightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftQuantity,
            LeftReciprocalLeftUnit,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : AbstractUndefinedScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftReciprocalRightAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                RightNumeratorLeftQuantity,
                LeftReciprocalRightAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            RightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftReciprocalLeftUnitXRightDenominatorUnit = { x(it) },
        rightNumeratorLeftUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                RightNumeratorLeftQuantity,
                RightNumeratorLeftUnit,
                UndefinedQuantityType.Multiplying<
                    LeftReciprocalLeftQuantity,
                    RightDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUSCustomary<
                    LeftReciprocalLeftQuantity,
                    LeftReciprocalLeftUnit,
                    RightDenominatorQuantity,
                    RightDenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
