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
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// Inv<Mul<A, B>> * A -> Inv<B>

@JvmName("reciprocalMultiplyingMultipliedByLeft")
fun <
    LeftReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    LeftReciprocalLeftAndRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightQuantity>,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
    LeftReciprocalUnit : UndefinedMultipliedUnit<
        LeftReciprocalLeftAndRightQuantity,
        LeftReciprocalLeftAndRightUnit,
        LeftReciprocalRightQuantity,
        LeftReciprocalRightUnit,
        >,
    LeftUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalRightQuantity,
            >,
        LeftReciprocalUnit,
        >,
    TargetUnit : UndefinedReciprocalUnit<
        LeftReciprocalRightQuantity,
        LeftReciprocalRightUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftReciprocalRightQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByLeft(
    right: UndefinedScientificValue<
        LeftReciprocalLeftAndRightQuantity,
        LeftReciprocalLeftAndRightUnit,
        >,
    reciprocalTargetUnit: LeftReciprocalRightUnit.() -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.inverse.right.reciprocalTargetUnit().byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultiplyingMultipliedByMetricAndImperialLeft")
infix fun <
    LeftReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    LeftReciprocalLeftAndRightUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByLeft(
    right: UndefinedScientificValue<
        LeftReciprocalLeftAndRightQuantity,
        LeftReciprocalLeftAndRightUnit,
        >,
) where
        LeftReciprocalLeftAndRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightQuantity>,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalLeftAndRightUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByLeft(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndImperial<
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricReciprocalMultiplyingMultipliedByMetricLeft")
infix fun <
    LeftReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    LeftReciprocalLeftAndRightUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByLeft(
    right: UndefinedScientificValue<
        LeftReciprocalLeftAndRightQuantity,
        LeftReciprocalLeftAndRightUnit,
        >,
) where
        LeftReciprocalLeftAndRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightQuantity>,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalLeftAndRightUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric =
    multipliedByLeft(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Metric<
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialReciprocalMultiplyingMultipliedByImperialLeft")
infix fun <
    LeftReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    LeftReciprocalLeftAndRightUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByLeft(
    right: UndefinedScientificValue<
        LeftReciprocalLeftAndRightQuantity,
        LeftReciprocalLeftAndRightUnit,
        >,
) where
        LeftReciprocalLeftAndRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightQuantity>,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalLeftAndRightUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByLeft(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Imperial<
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialReciprocalMultiplyingMultipliedByUKImperialLeft")
infix fun <
    LeftReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    LeftReciprocalLeftAndRightUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByLeft(
    right: UndefinedScientificValue<
        LeftReciprocalLeftAndRightQuantity,
        LeftReciprocalLeftAndRightUnit,
        >,
) where
        LeftReciprocalLeftAndRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightQuantity>,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalLeftAndRightUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByLeft(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.UKImperial<
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryReciprocalMultiplyingMultipliedByUSCustomaryLeft")
infix fun <
    LeftReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    LeftReciprocalLeftAndRightUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByLeft(
    right: UndefinedScientificValue<
        LeftReciprocalLeftAndRightQuantity,
        LeftReciprocalLeftAndRightUnit,
        >,
) where
        LeftReciprocalLeftAndRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightQuantity>,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalLeftAndRightUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByLeft(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.USCustomary<
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialReciprocalMultiplyingMultipliedByMetricAndUKImperialLeft")
infix fun <
    LeftReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    LeftReciprocalLeftAndRightUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByLeft(
    right: UndefinedScientificValue<
        LeftReciprocalLeftAndRightQuantity,
        LeftReciprocalLeftAndRightUnit,
        >,
) where
        LeftReciprocalLeftAndRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightQuantity>,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalLeftAndRightUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByLeft(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUKImperial<
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryReciprocalMultiplyingMultipliedByMetricAndUSCustomaryLeft")
infix fun <
    LeftReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    LeftReciprocalLeftAndRightUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByLeft(
    right: UndefinedScientificValue<
        LeftReciprocalLeftAndRightQuantity,
        LeftReciprocalLeftAndRightUnit,
        >,
) where
        LeftReciprocalLeftAndRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightQuantity>,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalLeftAndRightUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftReciprocalLeftAndRightQuantity,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByLeft(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
