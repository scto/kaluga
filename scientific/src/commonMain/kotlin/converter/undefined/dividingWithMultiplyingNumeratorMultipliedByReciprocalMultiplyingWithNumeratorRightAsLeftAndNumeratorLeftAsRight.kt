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
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// Div<Mul<A, B>, C> * Inv<Mul<B, A>> -> Inv<C>

@JvmName("dividingWithMultiplyingNumeratorMultipliedByReciprocalMultiplyingWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
fun <
    LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
    LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
    LeftNumeratorUnit : UndefinedMultipliedUnit<
        LeftNumeratorLeftAndRightReciprocalRightQuantity,
        LeftNumeratorLeftUnit,
        LeftNumeratorRightAndRightReciprocalLeftQuantity,
        LeftNumeratorRightUnit,
        >,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
    LeftUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            >,
        LeftNumeratorUnit,
        LeftDenominatorQuantity,
        LeftDenominatorUnit,
        >,
    RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
    RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
    RightReciprocalUnit : UndefinedMultipliedUnit<
        LeftNumeratorRightAndRightReciprocalLeftQuantity,
        RightReciprocalLeftUnit,
        LeftNumeratorLeftAndRightReciprocalRightQuantity,
        RightReciprocalRightUnit,
        >,
    RightUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            >,
        RightReciprocalUnit,
        >,
    TargetUnit : UndefinedReciprocalUnit<
        LeftDenominatorQuantity,
        LeftDenominatorUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftDenominatorQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            >,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
    reciprocalTargetUnit: LeftDenominatorUnit.() -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.denominator.reciprocalTargetUnit().byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingNumeratorMultipliedByMetricAndImperialReciprocalMultiplyingWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
    LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            >,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndImperial<
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDividingWithMultiplyingNumeratorMultipliedByMetricReciprocalMultiplyingWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
    LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            >,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Metric<
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDividingWithMultiplyingNumeratorMultipliedByImperialReciprocalMultiplyingWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
    LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            >,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Imperial<
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDividingWithMultiplyingNumeratorMultipliedByUKImperialReciprocalMultiplyingWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
    LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            >,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.UKImperial<
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingWithMultiplyingNumeratorMultipliedByUSCustomaryReciprocalMultiplyingWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
    LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            >,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.USCustomary<
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividingWithMultiplyingNumeratorMultipliedByMetricAndUKImperialReciprocalMultiplyingWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
    LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            >,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUKImperial<
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDividingWithMultiplyingNumeratorMultipliedByMetricAndUSCustomaryReciprocalMultiplyingWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
    LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            >,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftNumeratorRightAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftNumeratorLeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorRightAndRightReciprocalLeftQuantity,
                LeftNumeratorLeftAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
