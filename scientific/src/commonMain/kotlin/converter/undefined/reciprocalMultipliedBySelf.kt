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
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.Dimensionless
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.One
import kotlin.jvm.JvmName

// Inv<A> * A -> One

@JvmName("reciprocalMultipliedBySelf")
fun <
    LeftReciprocalAndRightQuantity : UndefinedQuantityType,
    LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
    LeftUnit : UndefinedReciprocalUnit<
        LeftReciprocalAndRightQuantity,
        LeftReciprocalUnit,
        >,
    RightUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
    TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
    TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        LeftReciprocalAndRightQuantity,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        LeftReciprocalAndRightQuantity,
        RightUnit,
        >,
    getDimensionless: () -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = getDimensionless().byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultipliedByMetricAndImperialSelf")
infix fun <
    LeftReciprocalAndRightQuantity : UndefinedQuantityType,
    LeftReciprocalUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        LeftReciprocalAndRightQuantity,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        LeftReciprocalAndRightQuantity,
        RightUnit,
        >,
) where
        LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            LeftReciprocalAndRightQuantity,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricReciprocalMultipliedByMetricSelf")
infix fun <
    LeftReciprocalAndRightQuantity : UndefinedQuantityType,
    LeftReciprocalUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        LeftReciprocalAndRightQuantity,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        LeftReciprocalAndRightQuantity,
        RightUnit,
        >,
) where
        LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedReciprocalUnit<
            LeftReciprocalAndRightQuantity,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialReciprocalMultipliedByImperialSelf")
infix fun <
    LeftReciprocalAndRightQuantity : UndefinedQuantityType,
    LeftReciprocalUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        LeftReciprocalAndRightQuantity,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        LeftReciprocalAndRightQuantity,
        RightUnit,
        >,
) where
        LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            LeftReciprocalAndRightQuantity,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialReciprocalMultipliedByUKImperialSelf")
infix fun <
    LeftReciprocalAndRightQuantity : UndefinedQuantityType,
    LeftReciprocalUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        LeftReciprocalAndRightQuantity,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        LeftReciprocalAndRightQuantity,
        RightUnit,
        >,
) where
        LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<
            LeftReciprocalAndRightQuantity,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryReciprocalMultipliedByUSCustomarySelf")
infix fun <
    LeftReciprocalAndRightQuantity : UndefinedQuantityType,
    LeftReciprocalUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        LeftReciprocalAndRightQuantity,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        LeftReciprocalAndRightQuantity,
        RightUnit,
        >,
) where
        LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            LeftReciprocalAndRightQuantity,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialReciprocalMultipliedByMetricAndUKImperialSelf")
infix fun <
    LeftReciprocalAndRightQuantity : UndefinedQuantityType,
    LeftReciprocalUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        LeftReciprocalAndRightQuantity,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        LeftReciprocalAndRightQuantity,
        RightUnit,
        >,
) where
        LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<
            LeftReciprocalAndRightQuantity,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryReciprocalMultipliedByMetricAndUSCustomarySelf")
infix fun <
    LeftReciprocalAndRightQuantity : UndefinedQuantityType,
    LeftReciprocalUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        LeftReciprocalAndRightQuantity,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        LeftReciprocalAndRightQuantity,
        RightUnit,
        >,
) where
        LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            LeftReciprocalAndRightQuantity,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericReciprocalMultipliedByGenericSelf")
infix fun <
    LeftReciprocalAndRightQuantity : UndefinedQuantityType,
    LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
    LeftUnit : UndefinedReciprocalUnit<
        LeftReciprocalAndRightQuantity,
        LeftReciprocalUnit,
        >,
    RightUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        LeftReciprocalAndRightQuantity,
        >,
    LeftUnit,
    >.genericMultipliedByGeneric(
    right: UndefinedScientificValue<
        LeftReciprocalAndRightQuantity,
        RightUnit,
        >,
) = multipliedBy(
    right,
    getDimensionless = { One },
) {
        value: Decimal,
        unit: One,
    ->
    DefaultScientificValue(value, unit)
}
