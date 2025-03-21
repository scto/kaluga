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
import kotlin.jvm.JvmName

// Mul<A, B> * Inv<Mul<C, B>> -> Div<A, C>

@JvmName("multiplyingMultipliedByReciprocalMultiplyingWithRightAsRight")
fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
    LeftRightAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalRightQuantity>,
    LeftUnit : UndefinedMultipliedUnit<
        LeftLeftQuantity,
        LeftLeftUnit,
        LeftRightAndRightReciprocalRightQuantity,
        LeftRightUnit,
        >,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
    RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalRightQuantity>,
    RightReciprocalUnit : UndefinedMultipliedUnit<
        RightReciprocalLeftQuantity,
        RightReciprocalLeftUnit,
        LeftRightAndRightReciprocalRightQuantity,
        RightReciprocalRightUnit,
        >,
    RightUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            RightReciprocalLeftQuantity,
            LeftRightAndRightReciprocalRightQuantity,
            >,
        RightReciprocalUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        LeftLeftQuantity,
        LeftLeftUnit,
        RightReciprocalLeftQuantity,
        RightReciprocalLeftUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftLeftQuantity,
            RightReciprocalLeftQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalRightQuantity,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftRightAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
    leftLeftUnitPerRightReciprocalLeftUnit: LeftLeftUnit.(RightReciprocalLeftUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.left.leftLeftUnitPerRightReciprocalLeftUnit(
    right.unit.inverse.left,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultiplyingMultipliedByMetricAndImperialReciprocalMultiplyingWithRightAsRight")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalRightQuantity,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftRightAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalRightQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftRightAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftRightAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftLeftUnitPerRightReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                LeftLeftQuantity,
                LeftLeftUnit,
                RightReciprocalLeftQuantity,
                RightReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricMultiplyingMultipliedByMetricReciprocalMultiplyingWithRightAsRight")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalRightQuantity,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftRightAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalRightQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftRightAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftRightAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(
        right,
        leftLeftUnitPerRightReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                LeftLeftQuantity,
                LeftLeftUnit,
                RightReciprocalLeftQuantity,
                RightReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialMultiplyingMultipliedByImperialReciprocalMultiplyingWithRightAsRight")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalRightQuantity,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftRightAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalRightQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftRightAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftRightAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftLeftUnitPerRightReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                LeftLeftQuantity,
                LeftLeftUnit,
                RightReciprocalLeftQuantity,
                RightReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialMultiplyingMultipliedByUKImperialReciprocalMultiplyingWithRightAsRight")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalRightQuantity,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftRightAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalRightQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftRightAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftRightAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftLeftUnitPerRightReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                LeftLeftQuantity,
                LeftLeftUnit,
                RightReciprocalLeftQuantity,
                RightReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryMultiplyingMultipliedByUSCustomaryReciprocalMultiplyingWithRightAsRight")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalRightQuantity,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftRightAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalRightQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftRightAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftRightAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftLeftUnitPerRightReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                LeftLeftQuantity,
                LeftLeftUnit,
                RightReciprocalLeftQuantity,
                RightReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultiplyingMultipliedByMetricAndUKImperialReciprocalMultiplyingWithRightAsRight")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalRightQuantity,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftRightAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalRightQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftRightAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftRightAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftLeftUnitPerRightReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                LeftLeftQuantity,
                LeftLeftUnit,
                RightReciprocalLeftQuantity,
                RightReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultiplyingMultipliedByMetricAndUSCustomaryReciprocalMultiplyingWithRightAsRight")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalRightQuantity,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftRightAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalRightQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftRightAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftRightAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftLeftUnitPerRightReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                LeftLeftQuantity,
                LeftLeftUnit,
                RightReciprocalLeftQuantity,
                RightReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
