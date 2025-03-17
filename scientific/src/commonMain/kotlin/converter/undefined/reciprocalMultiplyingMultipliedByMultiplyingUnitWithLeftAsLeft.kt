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

// Inv<Mul<A, B>> * Mul<A, C> -> Div<C, B>

@JvmName("reciprocalMultiplyingMultipliedByMultiplyingUnitWithLeftAsLeft")
fun <
    LeftReciprocalLeftAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftAndRightLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightLeftQuantity>,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
    LeftReciprocalUnit : UndefinedMultipliedUnit<
        LeftReciprocalLeftAndRightLeftQuantity,
        LeftReciprocalLeftAndRightLeftUnit,
        LeftReciprocalRightQuantity,
        LeftReciprocalRightUnit,
        >,
    LeftUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalRightQuantity,
            >,
        LeftReciprocalUnit,
        >,
    RightRightQuantity : UndefinedQuantityType,
    RightRightUnit : UndefinedScientificUnit<RightRightQuantity>,
    RightUnit : UndefinedMultipliedUnit<
        LeftReciprocalLeftAndRightLeftQuantity,
        LeftReciprocalLeftAndRightLeftUnit,
        RightRightQuantity,
        RightRightUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        RightRightQuantity,
        RightRightUnit,
        LeftReciprocalRightQuantity,
        LeftReciprocalRightUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightRightQuantity,
            LeftReciprocalRightQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByMultiplyingUnitWithLeftAsLeft(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightLeftQuantity,
            RightRightQuantity,
            >,
        RightUnit,
        >,
    rightRightUnitPerLeftReciprocalRightUnit: RightRightUnit.(LeftReciprocalRightUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.right.rightRightUnitPerLeftReciprocalRightUnit(
    unit.inverse.right,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultiplyingMultipliedByMetricAndImperialMultiplyingUnitWithLeftAsLeft")
infix fun <
    LeftReciprocalLeftAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftAndRightLeftUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightRightQuantity : UndefinedQuantityType,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByMultiplyingUnitWithLeftAsLeft(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightLeftQuantity,
            RightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftAndRightLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightLeftQuantity>,
        LeftReciprocalLeftAndRightLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftAndRightLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalLeftAndRightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalLeftAndRightLeftUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightLeftQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightRightUnit : UndefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInMetric,
        RightRightUnit : MeasurementUsage.UsedInUKImperial,
        RightRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalLeftAndRightLeftUnit,
            RightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByMultiplyingUnitWithLeftAsLeft(
        right,
        rightRightUnitPerLeftReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                RightRightQuantity,
                RightRightUnit,
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricReciprocalMultiplyingMultipliedByMetricMultiplyingUnitWithLeftAsLeft")
infix fun <
    LeftReciprocalLeftAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftAndRightLeftUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightRightQuantity : UndefinedQuantityType,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByMultiplyingUnitWithLeftAsLeft(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightLeftQuantity,
            RightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftAndRightLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightLeftQuantity>,
        LeftReciprocalLeftAndRightLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalLeftAndRightLeftUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightLeftQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightRightUnit : UndefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalLeftAndRightLeftUnit,
            RightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedByMultiplyingUnitWithLeftAsLeft(
        right,
        rightRightUnitPerLeftReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                RightRightQuantity,
                RightRightUnit,
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialReciprocalMultiplyingMultipliedByImperialMultiplyingUnitWithLeftAsLeft")
infix fun <
    LeftReciprocalLeftAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftAndRightLeftUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightRightQuantity : UndefinedQuantityType,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByMultiplyingUnitWithLeftAsLeft(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightLeftQuantity,
            RightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftAndRightLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightLeftQuantity>,
        LeftReciprocalLeftAndRightLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalLeftAndRightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalLeftAndRightLeftUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightLeftQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightRightUnit : UndefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInUKImperial,
        RightRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalLeftAndRightLeftUnit,
            RightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByMultiplyingUnitWithLeftAsLeft(
        right,
        rightRightUnitPerLeftReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                RightRightQuantity,
                RightRightUnit,
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialReciprocalMultiplyingMultipliedByUKImperialMultiplyingUnitWithLeftAsLeft")
infix fun <
    LeftReciprocalLeftAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftAndRightLeftUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightRightQuantity : UndefinedQuantityType,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByMultiplyingUnitWithLeftAsLeft(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightLeftQuantity,
            RightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftAndRightLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightLeftQuantity>,
        LeftReciprocalLeftAndRightLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalLeftAndRightLeftUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightLeftQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightRightUnit : UndefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalLeftAndRightLeftUnit,
            RightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByMultiplyingUnitWithLeftAsLeft(
        right,
        rightRightUnitPerLeftReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                RightRightQuantity,
                RightRightUnit,
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryReciprocalMultiplyingMultipliedByUSCustomaryMultiplyingUnitWithLeftAsLeft")
infix fun <
    LeftReciprocalLeftAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftAndRightLeftUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightRightQuantity : UndefinedQuantityType,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByMultiplyingUnitWithLeftAsLeft(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightLeftQuantity,
            RightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftAndRightLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightLeftQuantity>,
        LeftReciprocalLeftAndRightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalLeftAndRightLeftUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightLeftQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightRightUnit : UndefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalLeftAndRightLeftUnit,
            RightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByMultiplyingUnitWithLeftAsLeft(
        right,
        rightRightUnitPerLeftReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                RightRightQuantity,
                RightRightUnit,
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialReciprocalMultiplyingMultipliedByMetricAndUKImperialMultiplyingUnitWithLeftAsLeft")
infix fun <
    LeftReciprocalLeftAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftAndRightLeftUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightRightQuantity : UndefinedQuantityType,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByMultiplyingUnitWithLeftAsLeft(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightLeftQuantity,
            RightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftAndRightLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightLeftQuantity>,
        LeftReciprocalLeftAndRightLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftAndRightLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalLeftAndRightLeftUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightLeftQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightRightUnit : UndefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInMetric,
        RightRightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalLeftAndRightLeftUnit,
            RightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByMultiplyingUnitWithLeftAsLeft(
        right,
        rightRightUnitPerLeftReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                RightRightQuantity,
                RightRightUnit,
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryReciprocalMultiplyingMultipliedByMetricAndUSCustomaryMultiplyingUnitWithLeftAsLeft")
infix fun <
    LeftReciprocalLeftAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalLeftAndRightLeftUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    RightRightQuantity : UndefinedQuantityType,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByMultiplyingUnitWithLeftAsLeft(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightLeftQuantity,
            RightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalLeftAndRightLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightLeftQuantity>,
        LeftReciprocalLeftAndRightLeftUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftAndRightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalLeftAndRightLeftUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightLeftQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightRightUnit : UndefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInMetric,
        RightRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightLeftQuantity,
            LeftReciprocalLeftAndRightLeftUnit,
            RightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByMultiplyingUnitWithLeftAsLeft(
        right,
        rightRightUnitPerLeftReciprocalRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                RightRightQuantity,
                RightRightUnit,
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
