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
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// A * Inv<Mul<B, A>> -> Inv<B>

@JvmName("multipliedByReciprocalMultiplyingWithSelfAsRight")
fun <
    LeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftUnit : AbstractUndefinedScientificUnit<LeftAndRightReciprocalRightQuantity>,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
    RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftAndRightReciprocalRightQuantity>,
    RightReciprocalUnit : UndefinedMultipliedUnit<
        RightReciprocalLeftQuantity,
        RightReciprocalLeftUnit,
        LeftAndRightReciprocalRightQuantity,
        RightReciprocalRightUnit,
        >,
    RightUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            RightReciprocalLeftQuantity,
            LeftAndRightReciprocalRightQuantity,
            >,
        RightReciprocalUnit,
        >,
    TargetUnit : UndefinedReciprocalUnit<
        RightReciprocalLeftQuantity,
        RightReciprocalLeftUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            RightReciprocalLeftQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    LeftAndRightReciprocalRightQuantity,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
    reciprocalTargetUnit: RightReciprocalLeftUnit.() -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.inverse.left.reciprocalTargetUnit().byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultipliedByMetricAndImperialReciprocalMultiplyingWithSelfAsRight")
infix fun <
    LeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightReciprocalRightQuantity,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractUndefinedScientificUnit<LeftAndRightReciprocalRightQuantity>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftAndRightReciprocalRightQuantity,
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
                RightReciprocalLeftQuantity,
                RightReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricMultipliedByMetricReciprocalMultiplyingWithSelfAsRight")
infix fun <
    LeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightReciprocalRightQuantity,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractUndefinedScientificUnit<LeftAndRightReciprocalRightQuantity>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftAndRightReciprocalRightQuantity,
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
                RightReciprocalLeftQuantity,
                RightReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialMultipliedByImperialReciprocalMultiplyingWithSelfAsRight")
infix fun <
    LeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightReciprocalRightQuantity,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractUndefinedScientificUnit<LeftAndRightReciprocalRightQuantity>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftAndRightReciprocalRightQuantity,
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
                RightReciprocalLeftQuantity,
                RightReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialMultipliedByUKImperialReciprocalMultiplyingWithSelfAsRight")
infix fun <
    LeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightReciprocalRightQuantity,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractUndefinedScientificUnit<LeftAndRightReciprocalRightQuantity>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftAndRightReciprocalRightQuantity,
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
                RightReciprocalLeftQuantity,
                RightReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryMultipliedByUSCustomaryReciprocalMultiplyingWithSelfAsRight")
infix fun <
    LeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightReciprocalRightQuantity,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractUndefinedScientificUnit<LeftAndRightReciprocalRightQuantity>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftAndRightReciprocalRightQuantity,
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
                RightReciprocalLeftQuantity,
                RightReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultipliedByMetricAndUKImperialReciprocalMultiplyingWithSelfAsRight")
infix fun <
    LeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightReciprocalRightQuantity,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractUndefinedScientificUnit<LeftAndRightReciprocalRightQuantity>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftAndRightReciprocalRightQuantity,
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
                RightReciprocalLeftQuantity,
                RightReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultipliedByMetricAndUSCustomaryReciprocalMultiplyingWithSelfAsRight")
infix fun <
    LeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightReciprocalRightQuantity,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractUndefinedScientificUnit<LeftAndRightReciprocalRightQuantity>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftAndRightReciprocalRightQuantity,
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
                RightReciprocalLeftQuantity,
                RightReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
