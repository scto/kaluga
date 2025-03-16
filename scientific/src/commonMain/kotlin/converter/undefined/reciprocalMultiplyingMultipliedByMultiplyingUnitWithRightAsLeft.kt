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

// Inv<Mul<A, B>> * Mul<B, C> -> Div<C, A>

@JvmName("reciprocalMultiplyingMultipliedByMultiplyingUnitWithRightAsLeft")
fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
    LeftReciprocalRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalRightAndRightLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
    LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, LeftReciprocalRightAndRightLeftQuantity, LeftReciprocalRightAndRightLeftUnit>,
    LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightLeftQuantity>, LeftReciprocalUnit>,
    RightRightQuantity : UndefinedQuantityType,
    RightRightUnit : UndefinedScientificUnit<RightRightQuantity>,
    RightUnit : UndefinedMultipliedUnit<LeftReciprocalRightAndRightLeftQuantity, LeftReciprocalRightAndRightLeftUnit, RightRightQuantity, RightRightUnit>,
    TargetUnit : UndefinedDividedUnit<RightRightQuantity, RightRightUnit, LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit>,
    TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<RightRightQuantity, LeftReciprocalLeftQuantity>, TargetUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightLeftQuantity>>, LeftUnit>.multipliedByMultiplyingUnitWithRightAsLeft(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<LeftReciprocalRightAndRightLeftQuantity, RightRightQuantity>, RightUnit>,
    rightRightUnitPerLeftReciprocalLeftUnit: RightRightUnit.(LeftReciprocalLeftUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.right.rightRightUnitPerLeftReciprocalLeftUnit(unit.inverse.left).byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultiplyingMultipliedByMetricAndImperialMultiplyingUnitWithRightAsLeft")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalRightAndRightLeftUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightRightQuantity : UndefinedQuantityType,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightLeftQuantity>>, LeftUnit>.multipliedByMultiplyingUnitWithRightAsLeft(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<LeftReciprocalRightAndRightLeftQuantity, RightRightQuantity>, RightUnit>,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightAndRightLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
        LeftReciprocalRightAndRightLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightAndRightLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightAndRightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, LeftReciprocalRightAndRightLeftQuantity, LeftReciprocalRightAndRightLeftUnit>,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightLeftQuantity>, LeftReciprocalUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightRightUnit : UndefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInMetric,
        RightRightUnit : MeasurementUsage.UsedInUKImperial,
        RightRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<LeftReciprocalRightAndRightLeftQuantity, LeftReciprocalRightAndRightLeftUnit, RightRightQuantity, RightRightUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByMultiplyingUnitWithRightAsLeft(
        right,
        rightRightUnitPerLeftReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                RightRightQuantity,
                RightRightUnit,
                LeftReciprocalLeftQuantity,
                LeftReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricReciprocalMultiplyingMultipliedByMetricMultiplyingUnitWithRightAsLeft")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalRightAndRightLeftUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightRightQuantity : UndefinedQuantityType,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightLeftQuantity>>, LeftUnit>.multipliedByMultiplyingUnitWithRightAsLeft(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<LeftReciprocalRightAndRightLeftQuantity, RightRightQuantity>, RightUnit>,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightAndRightLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
        LeftReciprocalRightAndRightLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, LeftReciprocalRightAndRightLeftQuantity, LeftReciprocalRightAndRightLeftUnit>,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightLeftQuantity>, LeftReciprocalUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightRightUnit : UndefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedMultipliedUnit<LeftReciprocalRightAndRightLeftQuantity, LeftReciprocalRightAndRightLeftUnit, RightRightQuantity, RightRightUnit>,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedByMultiplyingUnitWithRightAsLeft(
        right,
        rightRightUnitPerLeftReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                RightRightQuantity,
                RightRightUnit,
                LeftReciprocalLeftQuantity,
                LeftReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialReciprocalMultiplyingMultipliedByImperialMultiplyingUnitWithRightAsLeft")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalRightAndRightLeftUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightRightQuantity : UndefinedQuantityType,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightLeftQuantity>>, LeftUnit>.multipliedByMultiplyingUnitWithRightAsLeft(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<LeftReciprocalRightAndRightLeftQuantity, RightRightQuantity>, RightUnit>,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightAndRightLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
        LeftReciprocalRightAndRightLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightAndRightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, LeftReciprocalRightAndRightLeftQuantity, LeftReciprocalRightAndRightLeftUnit>,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightLeftQuantity>, LeftReciprocalUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightRightUnit : UndefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInUKImperial,
        RightRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<LeftReciprocalRightAndRightLeftQuantity, LeftReciprocalRightAndRightLeftUnit, RightRightQuantity, RightRightUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByMultiplyingUnitWithRightAsLeft(
        right,
        rightRightUnitPerLeftReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                RightRightQuantity,
                RightRightUnit,
                LeftReciprocalLeftQuantity,
                LeftReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialReciprocalMultiplyingMultipliedByUKImperialMultiplyingUnitWithRightAsLeft")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalRightAndRightLeftUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightRightQuantity : UndefinedQuantityType,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightLeftQuantity>>, LeftUnit>.multipliedByMultiplyingUnitWithRightAsLeft(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<LeftReciprocalRightAndRightLeftQuantity, RightRightQuantity>, RightUnit>,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightAndRightLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
        LeftReciprocalRightAndRightLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, LeftReciprocalRightAndRightLeftQuantity, LeftReciprocalRightAndRightLeftUnit>,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightLeftQuantity>, LeftReciprocalUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightRightUnit : UndefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedMultipliedUnit<LeftReciprocalRightAndRightLeftQuantity, LeftReciprocalRightAndRightLeftUnit, RightRightQuantity, RightRightUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByMultiplyingUnitWithRightAsLeft(
        right,
        rightRightUnitPerLeftReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                RightRightQuantity,
                RightRightUnit,
                LeftReciprocalLeftQuantity,
                LeftReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryReciprocalMultiplyingMultipliedByUSCustomaryMultiplyingUnitWithRightAsLeft")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalRightAndRightLeftUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightRightQuantity : UndefinedQuantityType,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightLeftQuantity>>, LeftUnit>.multipliedByMultiplyingUnitWithRightAsLeft(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<LeftReciprocalRightAndRightLeftQuantity, RightRightQuantity>, RightUnit>,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightAndRightLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
        LeftReciprocalRightAndRightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, LeftReciprocalRightAndRightLeftQuantity, LeftReciprocalRightAndRightLeftUnit>,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightLeftQuantity>, LeftReciprocalUnit>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightRightUnit : UndefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<LeftReciprocalRightAndRightLeftQuantity, LeftReciprocalRightAndRightLeftUnit, RightRightQuantity, RightRightUnit>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByMultiplyingUnitWithRightAsLeft(
        right,
        rightRightUnitPerLeftReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                RightRightQuantity,
                RightRightUnit,
                LeftReciprocalLeftQuantity,
                LeftReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialReciprocalMultiplyingMultipliedByMetricAndUKImperialMultiplyingUnitWithRightAsLeft")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalRightAndRightLeftUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightRightQuantity : UndefinedQuantityType,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightLeftQuantity>>, LeftUnit>.multipliedByMultiplyingUnitWithRightAsLeft(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<LeftReciprocalRightAndRightLeftQuantity, RightRightQuantity>, RightUnit>,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightAndRightLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
        LeftReciprocalRightAndRightLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightAndRightLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, LeftReciprocalRightAndRightLeftQuantity, LeftReciprocalRightAndRightLeftUnit>,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightLeftQuantity>, LeftReciprocalUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightRightUnit : UndefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInMetric,
        RightRightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedMultipliedUnit<LeftReciprocalRightAndRightLeftQuantity, LeftReciprocalRightAndRightLeftUnit, RightRightQuantity, RightRightUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByMultiplyingUnitWithRightAsLeft(
        right,
        rightRightUnitPerLeftReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                RightRightQuantity,
                RightRightUnit,
                LeftReciprocalLeftQuantity,
                LeftReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryReciprocalMultiplyingMultipliedByMetricAndUSCustomaryMultiplyingUnitWithRightAsLeft")
infix fun <
    LeftReciprocalLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftUnit,
    LeftReciprocalRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalRightAndRightLeftUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightRightQuantity : UndefinedQuantityType,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightLeftQuantity>>, LeftUnit>.multipliedByMultiplyingUnitWithRightAsLeft(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<LeftReciprocalRightAndRightLeftQuantity, RightRightQuantity>, RightUnit>,
) where
        LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightAndRightLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
        LeftReciprocalRightAndRightLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightAndRightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, LeftReciprocalRightAndRightLeftQuantity, LeftReciprocalRightAndRightLeftUnit>,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, LeftReciprocalRightAndRightLeftQuantity>, LeftReciprocalUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightRightUnit : UndefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInMetric,
        RightRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<LeftReciprocalRightAndRightLeftQuantity, LeftReciprocalRightAndRightLeftUnit, RightRightQuantity, RightRightUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByMultiplyingUnitWithRightAsLeft(
        right,
        rightRightUnitPerLeftReciprocalLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                RightRightQuantity,
                RightRightUnit,
                LeftReciprocalLeftQuantity,
                LeftReciprocalLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
