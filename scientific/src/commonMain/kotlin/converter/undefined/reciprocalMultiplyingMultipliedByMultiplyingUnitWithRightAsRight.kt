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

// Inv<Mul<A, B>> * Mul<C, B> -> Div<C, A>

@JvmName("reciprocalMultiplyingMultipliedByMultiplyingUnitWithRightAsRight")
fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
    LeftReciprocalRightAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightRightQuantity>,
    LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, LeftReciprocalRightAndRightRightQuantity, LeftReciprocalRightAndRightRightUnit>,
    LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightRightQuantity>, LeftReciprocalUnit>,
    RightLeftQuantity : UndefinedQuantityType,
    RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
    RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftReciprocalRightAndRightRightQuantity, LeftReciprocalRightAndRightRightUnit>,
    TargetUnit : UndefinedDividedUnit<RightLeftQuantity, RightLeftUnit, LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit>,
    TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<RightLeftQuantity, LeftReciprocalLeftQuantity>, TargetUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightRightQuantity>>, LeftUnit>.multipliedByMultiplyingUnitWithRightAsRight(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftReciprocalRightAndRightRightQuantity>, RightUnit>,
    rightLeftUnitPerLeftReciprocalLeftUnit: RightLeftUnit.(LeftReciprocalLeftUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.left.rightLeftUnitPerLeftReciprocalLeftUnit(unit.inverse.left).byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultiplyingMultipliedByMetricAndImperialMultiplyingUnitWithRightAsRight")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightAndRightRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftQuantity : UndefinedQuantityType,
    RightLeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightRightQuantity>>, LeftUnit>.multipliedByMultiplyingUnitWithRightAsRight(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftReciprocalRightAndRightRightQuantity>, RightUnit>,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightRightQuantity>,
        LeftReciprocalRightAndRightRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightAndRightRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightAndRightRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, LeftReciprocalRightAndRightRightQuantity, LeftReciprocalRightAndRightRightUnit>,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightRightQuantity>, LeftReciprocalUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInMetric,
        RightLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftReciprocalRightAndRightRightQuantity, LeftReciprocalRightAndRightRightUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByMultiplyingUnitWithRightAsRight(
        right,
        rightLeftUnitPerLeftReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                RightLeftQuantity,
                RightLeftUnit,
                LeftReciprocalLeftQuantity,
                LeftReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricReciprocalMultiplyingMultipliedByMetricMultiplyingUnitWithRightAsRight")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightAndRightRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftQuantity : UndefinedQuantityType,
    RightLeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightRightQuantity>>, LeftUnit>.multipliedByMultiplyingUnitWithRightAsRight(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftReciprocalRightAndRightRightQuantity>, RightUnit>,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightRightQuantity>,
        LeftReciprocalRightAndRightRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, LeftReciprocalRightAndRightRightQuantity, LeftReciprocalRightAndRightRightUnit>,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightRightQuantity>, LeftReciprocalUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftReciprocalRightAndRightRightQuantity, LeftReciprocalRightAndRightRightUnit>,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedByMultiplyingUnitWithRightAsRight(
        right,
        rightLeftUnitPerLeftReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                RightLeftQuantity,
                RightLeftUnit,
                LeftReciprocalLeftQuantity,
                LeftReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialReciprocalMultiplyingMultipliedByImperialMultiplyingUnitWithRightAsRight")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightAndRightRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftQuantity : UndefinedQuantityType,
    RightLeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightRightQuantity>>, LeftUnit>.multipliedByMultiplyingUnitWithRightAsRight(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftReciprocalRightAndRightRightQuantity>, RightUnit>,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightRightQuantity>,
        LeftReciprocalRightAndRightRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightAndRightRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, LeftReciprocalRightAndRightRightQuantity, LeftReciprocalRightAndRightRightUnit>,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightRightQuantity>, LeftReciprocalUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftReciprocalRightAndRightRightQuantity, LeftReciprocalRightAndRightRightUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByMultiplyingUnitWithRightAsRight(
        right,
        rightLeftUnitPerLeftReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                RightLeftQuantity,
                RightLeftUnit,
                LeftReciprocalLeftQuantity,
                LeftReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialReciprocalMultiplyingMultipliedByUKImperialMultiplyingUnitWithRightAsRight")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightAndRightRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftQuantity : UndefinedQuantityType,
    RightLeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightRightQuantity>>, LeftUnit>.multipliedByMultiplyingUnitWithRightAsRight(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftReciprocalRightAndRightRightQuantity>, RightUnit>,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightRightQuantity>,
        LeftReciprocalRightAndRightRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, LeftReciprocalRightAndRightRightQuantity, LeftReciprocalRightAndRightRightUnit>,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightRightQuantity>, LeftReciprocalUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftReciprocalRightAndRightRightQuantity, LeftReciprocalRightAndRightRightUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByMultiplyingUnitWithRightAsRight(
        right,
        rightLeftUnitPerLeftReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                RightLeftQuantity,
                RightLeftUnit,
                LeftReciprocalLeftQuantity,
                LeftReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryReciprocalMultiplyingMultipliedByUSCustomaryMultiplyingUnitWithRightAsRight")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightAndRightRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftQuantity : UndefinedQuantityType,
    RightLeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightRightQuantity>>, LeftUnit>.multipliedByMultiplyingUnitWithRightAsRight(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftReciprocalRightAndRightRightQuantity>, RightUnit>,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightRightQuantity>,
        LeftReciprocalRightAndRightRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, LeftReciprocalRightAndRightRightQuantity, LeftReciprocalRightAndRightRightUnit>,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightRightQuantity>, LeftReciprocalUnit>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftReciprocalRightAndRightRightQuantity, LeftReciprocalRightAndRightRightUnit>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByMultiplyingUnitWithRightAsRight(
        right,
        rightLeftUnitPerLeftReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                RightLeftQuantity,
                RightLeftUnit,
                LeftReciprocalLeftQuantity,
                LeftReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialReciprocalMultiplyingMultipliedByMetricAndUKImperialMultiplyingUnitWithRightAsRight")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightAndRightRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftQuantity : UndefinedQuantityType,
    RightLeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightRightQuantity>>, LeftUnit>.multipliedByMultiplyingUnitWithRightAsRight(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftReciprocalRightAndRightRightQuantity>, RightUnit>,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightRightQuantity>,
        LeftReciprocalRightAndRightRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightAndRightRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, LeftReciprocalRightAndRightRightQuantity, LeftReciprocalRightAndRightRightUnit>,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightRightQuantity>, LeftReciprocalUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInMetric,
        RightLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftReciprocalRightAndRightRightQuantity, LeftReciprocalRightAndRightRightUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByMultiplyingUnitWithRightAsRight(
        right,
        rightLeftUnitPerLeftReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                RightLeftQuantity,
                RightLeftUnit,
                LeftReciprocalLeftQuantity,
                LeftReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryReciprocalMultiplyingMultipliedByMetricAndUSCustomaryMultiplyingUnitWithRightAsRight")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightAndRightRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftQuantity : UndefinedQuantityType,
    RightLeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightRightQuantity>>, LeftUnit>.multipliedByMultiplyingUnitWithRightAsRight(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftReciprocalRightAndRightRightQuantity>, RightUnit>,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightRightQuantity>,
        LeftReciprocalRightAndRightRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightAndRightRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, LeftReciprocalRightAndRightRightQuantity, LeftReciprocalRightAndRightRightUnit>,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightRightQuantity>, LeftReciprocalUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInMetric,
        RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftReciprocalRightAndRightRightQuantity, LeftReciprocalRightAndRightRightUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByMultiplyingUnitWithRightAsRight(
        right,
        rightLeftUnitPerLeftReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                RightLeftQuantity,
                RightLeftUnit,
                LeftReciprocalLeftQuantity,
                LeftReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
