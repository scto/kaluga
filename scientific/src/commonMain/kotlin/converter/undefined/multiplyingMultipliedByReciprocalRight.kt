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
import kotlin.jvm.JvmName

// Mul<A, B> * Inv<B> -> A

@JvmName("multiplyingMultipliedByReciprocalRight")
fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
    LeftRightAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
    LeftUnit : UndefinedMultipliedUnit<
        LeftLeftQuantity,
        LeftLeftUnit,
        LeftRightAndRightReciprocalQuantity,
        LeftRightUnit,
        >,
    RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
    RightUnit : UndefinedReciprocalUnit<
        LeftRightAndRightReciprocalQuantity,
        RightReciprocalUnit,
        >,
    LeftLeftValue : UndefinedScientificValue<
        LeftLeftQuantity,
        LeftLeftUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalQuantity,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftRightAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
    factory: (Decimal, LeftLeftUnit) -> LeftLeftValue,
) = unit.left.byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultiplyingMultipliedByMetricAndImperialReciprocalRight")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalQuantity,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftRightAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            LeftRightAndRightReciprocalQuantity,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricMultiplyingMultipliedByMetricReciprocalRight")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalQuantity,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftRightAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedReciprocalUnit<
            LeftRightAndRightReciprocalQuantity,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialMultiplyingMultipliedByImperialReciprocalRight")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalQuantity,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftRightAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            LeftRightAndRightReciprocalQuantity,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialMultiplyingMultipliedByUKImperialReciprocalRight")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalQuantity,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftRightAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            LeftRightAndRightReciprocalQuantity,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryMultiplyingMultipliedByUSCustomaryReciprocalRight")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalQuantity,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftRightAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            LeftRightAndRightReciprocalQuantity,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultiplyingMultipliedByMetricAndUKImperialReciprocalRight")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalQuantity,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftRightAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            LeftRightAndRightReciprocalQuantity,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultiplyingMultipliedByMetricAndUSCustomaryReciprocalRight")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalQuantity,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftRightAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            LeftRightAndRightReciprocalQuantity,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("genericMultiplyingMultipliedByGenericReciprocalRight")
infix fun <
    LeftLeftQuantity : UndefinedQuantityType,
    LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
    LeftRightAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
    LeftUnit : UndefinedMultipliedUnit<
        LeftLeftQuantity,
        LeftLeftUnit,
        LeftRightAndRightReciprocalQuantity,
        LeftRightUnit,
        >,
    RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
    RightUnit : UndefinedReciprocalUnit<
        LeftRightAndRightReciprocalQuantity,
        RightReciprocalUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftQuantity,
        LeftRightAndRightReciprocalQuantity,
        >,
    LeftUnit,
    >.genericMultipliedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftRightAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) = multipliedBy(right) {
        value: Decimal,
        unit: LeftLeftUnit,
    ->
    DefaultUndefinedScientificValue(value, unit)
}
