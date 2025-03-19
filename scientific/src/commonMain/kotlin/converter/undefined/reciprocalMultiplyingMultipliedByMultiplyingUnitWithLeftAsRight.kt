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

// Inv<Mul<A, B>> * Mul<C, A> -> Div<C, B>

@JvmName("reciprocalMultiplyingMultipliedByMultiplyingUnitWithLeftAsRight")
fun <
    LeftReciprocalLeftAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightRightQuantity>,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
    LeftReciprocalUnit : UndefinedMultipliedUnit<
        LeftReciprocalLeftAndRightRightQuantity,
        LeftReciprocalLeftUnit,
        LeftReciprocalRightQuantity,
        LeftReciprocalRightUnit,
        >,
    LeftUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightRightQuantity,
            LeftReciprocalRightQuantity,
            >,
        LeftReciprocalUnit,
        >,
    RightLeftQuantity : UndefinedQuantityType,
    RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
    RightRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightRightQuantity>,
    RightUnit : UndefinedMultipliedUnit<
        RightLeftQuantity,
        RightLeftUnit,
        LeftReciprocalLeftAndRightRightQuantity,
        RightRightUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        RightLeftQuantity,
        RightLeftUnit,
        LeftReciprocalRightQuantity,
        LeftReciprocalRightUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightLeftQuantity,
            LeftReciprocalRightQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightRightQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            RightLeftQuantity,
            LeftReciprocalLeftAndRightRightQuantity,
            >,
        RightUnit,
        >,
    rightLeftUnitPerLeftReciprocalRightUnit: RightLeftUnit.(LeftReciprocalRightUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.left.rightLeftUnitPerLeftReciprocalRightUnit(
    unit.inverse.right,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultiplyingMultipliedByMetricAndImperialMultiplyingUnitWithLeftAsRight")
infix fun <
    LeftReciprocalLeftAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftQuantity : UndefinedQuantityType,
    RightLeftUnit,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightRightQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            RightLeftQuantity,
            LeftReciprocalLeftAndRightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightRightQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightRightQuantity,
            LeftReciprocalLeftUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightRightQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInMetric,
        RightLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInMetric,
        RightRightUnit : MeasurementUsage.UsedInUKImperial,
        RightRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<
            RightLeftQuantity,
            RightLeftUnit,
            LeftReciprocalLeftAndRightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        rightLeftUnitPerLeftReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                RightLeftQuantity,
                RightLeftUnit,
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricReciprocalMultiplyingMultipliedByMetricMultiplyingUnitWithLeftAsRight")
infix fun <
    LeftReciprocalLeftAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftQuantity : UndefinedQuantityType,
    RightLeftUnit,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightRightQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            RightLeftQuantity,
            LeftReciprocalLeftAndRightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightRightQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightRightQuantity,
            LeftReciprocalLeftUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightRightQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInMetric,
        RightRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedMultipliedUnit<
            RightLeftQuantity,
            RightLeftUnit,
            LeftReciprocalLeftAndRightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(
        right,
        rightLeftUnitPerLeftReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                RightLeftQuantity,
                RightLeftUnit,
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialReciprocalMultiplyingMultipliedByImperialMultiplyingUnitWithLeftAsRight")
infix fun <
    LeftReciprocalLeftAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftQuantity : UndefinedQuantityType,
    RightLeftUnit,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightRightQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            RightLeftQuantity,
            LeftReciprocalLeftAndRightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightRightQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightRightQuantity,
            LeftReciprocalLeftUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightRightQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInUKImperial,
        RightRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<
            RightLeftQuantity,
            RightLeftUnit,
            LeftReciprocalLeftAndRightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        rightLeftUnitPerLeftReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                RightLeftQuantity,
                RightLeftUnit,
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialReciprocalMultiplyingMultipliedByUKImperialMultiplyingUnitWithLeftAsRight")
infix fun <
    LeftReciprocalLeftAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftQuantity : UndefinedQuantityType,
    RightLeftUnit,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightRightQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            RightLeftQuantity,
            LeftReciprocalLeftAndRightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightRightQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightRightQuantity,
            LeftReciprocalLeftUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightRightQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedMultipliedUnit<
            RightLeftQuantity,
            RightLeftUnit,
            LeftReciprocalLeftAndRightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        rightLeftUnitPerLeftReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                RightLeftQuantity,
                RightLeftUnit,
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryReciprocalMultiplyingMultipliedByUSCustomaryMultiplyingUnitWithLeftAsRight")
infix fun <
    LeftReciprocalLeftAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftQuantity : UndefinedQuantityType,
    RightLeftUnit,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightRightQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            RightLeftQuantity,
            LeftReciprocalLeftAndRightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightRightQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightRightQuantity,
            LeftReciprocalLeftUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightRightQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<
            RightLeftQuantity,
            RightLeftUnit,
            LeftReciprocalLeftAndRightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        rightLeftUnitPerLeftReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                RightLeftQuantity,
                RightLeftUnit,
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialReciprocalMultiplyingMultipliedByMetricAndUKImperialMultiplyingUnitWithLeftAsRight")
infix fun <
    LeftReciprocalLeftAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftQuantity : UndefinedQuantityType,
    RightLeftUnit,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightRightQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            RightLeftQuantity,
            LeftReciprocalLeftAndRightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightRightQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightRightQuantity,
            LeftReciprocalLeftUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightRightQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInMetric,
        RightLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInMetric,
        RightRightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedMultipliedUnit<
            RightLeftQuantity,
            RightLeftUnit,
            LeftReciprocalLeftAndRightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        rightLeftUnitPerLeftReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                RightLeftQuantity,
                RightLeftUnit,
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryReciprocalMultiplyingMultipliedByMetricAndUSCustomaryMultiplyingUnitWithLeftAsRight")
infix fun <
    LeftReciprocalLeftAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftQuantity : UndefinedQuantityType,
    RightLeftUnit,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightRightQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            RightLeftQuantity,
            LeftReciprocalLeftAndRightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightRightQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightRightQuantity,
            LeftReciprocalLeftUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightRightQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInMetric,
        RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInMetric,
        RightRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<
            RightLeftQuantity,
            RightLeftUnit,
            LeftReciprocalLeftAndRightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        rightLeftUnitPerLeftReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                RightLeftQuantity,
                RightLeftUnit,
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
