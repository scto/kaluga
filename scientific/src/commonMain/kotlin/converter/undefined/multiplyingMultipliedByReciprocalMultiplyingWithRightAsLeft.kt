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
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// Mul<A, B> * Inv<Mul<B, C>> -> Div<A, C>

@JvmName("multiplyingMultipliedByReciprocalMultiplyingWithRightAsLeft")
fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit : UndefinedScientificUnit<LeftLeftQuantity>,
    LeftRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
    LeftUnit : UndefinedMultipliedUnit<
        LeftLeftQuantity,
        LeftLeftUnit,
        LeftRightAndRightReciprocalLeftQuantity,
        LeftRightAndRightReciprocalLeftUnit,
        >,
    RightReciprocalRightQuantity : UndefinedQuantityType,
    RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
    RightReciprocalUnit : UndefinedMultipliedUnit<
        LeftRightAndRightReciprocalLeftQuantity,
        LeftRightAndRightReciprocalLeftUnit,
        RightReciprocalRightQuantity,
        RightReciprocalRightUnit,
        >,
    RightUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            LeftRightAndRightReciprocalLeftQuantity,
            RightReciprocalRightQuantity,
            >,
        RightReciprocalUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        LeftLeftQuantity,
        LeftLeftUnit,
        RightReciprocalRightQuantity,
        RightReciprocalRightUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftLeftQuantity,
            RightReciprocalRightQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalLeftQuantity,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
    leftLeftUnitPerRightReciprocalRightUnit: LeftLeftUnit.(RightReciprocalRightUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.left.leftLeftUnitPerRightReciprocalRightUnit(
    right.unit.inverse.right,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultiplyingMultipliedByMetricAndImperialReciprocalMultiplyingWithRightAsLeft")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftRightAndRightReciprocalLeftUnit,
    LeftUnit,
    RightReciprocalRightQuantity : UndefinedQuantityType,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalLeftQuantity,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        LeftRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightAndRightReciprocalLeftUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightAndRightReciprocalLeftUnit,
            RightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftLeftUnitPerRightReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                LeftLeftQuantity,
                LeftLeftUnit,
                RightReciprocalRightQuantity,
                RightReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricMultiplyingMultipliedByMetricReciprocalMultiplyingWithRightAsLeft")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftRightAndRightReciprocalLeftUnit,
    LeftUnit,
    RightReciprocalRightQuantity : UndefinedQuantityType,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalLeftQuantity,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        LeftRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightAndRightReciprocalLeftUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightAndRightReciprocalLeftUnit,
            RightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(
        right,
        leftLeftUnitPerRightReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                LeftLeftQuantity,
                LeftLeftUnit,
                RightReciprocalRightQuantity,
                RightReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialMultiplyingMultipliedByImperialReciprocalMultiplyingWithRightAsLeft")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftRightAndRightReciprocalLeftUnit,
    LeftUnit,
    RightReciprocalRightQuantity : UndefinedQuantityType,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalLeftQuantity,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        LeftRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightAndRightReciprocalLeftUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightAndRightReciprocalLeftUnit,
            RightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftLeftUnitPerRightReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                LeftLeftQuantity,
                LeftLeftUnit,
                RightReciprocalRightQuantity,
                RightReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialMultiplyingMultipliedByUKImperialReciprocalMultiplyingWithRightAsLeft")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftRightAndRightReciprocalLeftUnit,
    LeftUnit,
    RightReciprocalRightQuantity : UndefinedQuantityType,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalLeftQuantity,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        LeftRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightAndRightReciprocalLeftUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightAndRightReciprocalLeftUnit,
            RightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftLeftUnitPerRightReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                LeftLeftQuantity,
                LeftLeftUnit,
                RightReciprocalRightQuantity,
                RightReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryMultiplyingMultipliedByUSCustomaryReciprocalMultiplyingWithRightAsLeft")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftRightAndRightReciprocalLeftUnit,
    LeftUnit,
    RightReciprocalRightQuantity : UndefinedQuantityType,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalLeftQuantity,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        LeftRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightAndRightReciprocalLeftUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightAndRightReciprocalLeftUnit,
            RightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftLeftUnitPerRightReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                LeftLeftQuantity,
                LeftLeftUnit,
                RightReciprocalRightQuantity,
                RightReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultiplyingMultipliedByMetricAndUKImperialReciprocalMultiplyingWithRightAsLeft")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftRightAndRightReciprocalLeftUnit,
    LeftUnit,
    RightReciprocalRightQuantity : UndefinedQuantityType,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalLeftQuantity,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        LeftRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightAndRightReciprocalLeftUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightAndRightReciprocalLeftUnit,
            RightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftLeftUnitPerRightReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                LeftLeftQuantity,
                LeftLeftUnit,
                RightReciprocalRightQuantity,
                RightReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultiplyingMultipliedByMetricAndUSCustomaryReciprocalMultiplyingWithRightAsLeft")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftRightAndRightReciprocalLeftUnit,
    LeftUnit,
    RightReciprocalRightQuantity : UndefinedQuantityType,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalLeftQuantity,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        LeftRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightAndRightReciprocalLeftUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightAndRightReciprocalLeftUnit,
            RightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftLeftUnitPerRightReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                LeftLeftQuantity,
                LeftLeftUnit,
                RightReciprocalRightQuantity,
                RightReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
