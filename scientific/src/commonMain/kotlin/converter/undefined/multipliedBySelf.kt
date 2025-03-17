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
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.One
import kotlin.jvm.JvmName

// A * Inv<A> -> One

@JvmName("multipliedBySelf")
fun <
    LeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftAndRightReciprocalUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
    RightUnit : UndefinedReciprocalUnit<
        LeftAndRightReciprocalQuantity,
        LeftAndRightReciprocalUnit,
        >,
    TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
    TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>,
    > UndefinedScientificValue<
    LeftAndRightReciprocalQuantity,
    LeftAndRightReciprocalUnit,
    >.multipliedBySelf(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
    getDimensionless: () -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = getDimensionless().byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultipliedByMetricAndImperialSelf")
infix fun <
    LeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftAndRightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightReciprocalQuantity,
    LeftAndRightReciprocalUnit,
    >.multipliedBySelf(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftAndRightReciprocalUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
        LeftAndRightReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftAndRightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftAndRightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            LeftAndRightReciprocalQuantity,
            LeftAndRightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBySelf(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricMultipliedByMetricSelf")
infix fun <
    LeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftAndRightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightReciprocalQuantity,
    LeftAndRightReciprocalUnit,
    >.multipliedBySelf(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftAndRightReciprocalUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
        LeftAndRightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedReciprocalUnit<
            LeftAndRightReciprocalQuantity,
            LeftAndRightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBySelf(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialMultipliedByImperialSelf")
infix fun <
    LeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftAndRightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightReciprocalQuantity,
    LeftAndRightReciprocalUnit,
    >.multipliedBySelf(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftAndRightReciprocalUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
        LeftAndRightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftAndRightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            LeftAndRightReciprocalQuantity,
            LeftAndRightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBySelf(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialMultipliedByUKImperialSelf")
infix fun <
    LeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftAndRightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightReciprocalQuantity,
    LeftAndRightReciprocalUnit,
    >.multipliedBySelf(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftAndRightReciprocalUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
        LeftAndRightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            LeftAndRightReciprocalQuantity,
            LeftAndRightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBySelf(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryMultipliedByUSCustomarySelf")
infix fun <
    LeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftAndRightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightReciprocalQuantity,
    LeftAndRightReciprocalUnit,
    >.multipliedBySelf(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftAndRightReciprocalUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
        LeftAndRightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            LeftAndRightReciprocalQuantity,
            LeftAndRightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBySelf(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultipliedByMetricAndUKImperialSelf")
infix fun <
    LeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftAndRightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightReciprocalQuantity,
    LeftAndRightReciprocalUnit,
    >.multipliedBySelf(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftAndRightReciprocalUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
        LeftAndRightReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftAndRightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            LeftAndRightReciprocalQuantity,
            LeftAndRightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBySelf(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultipliedByMetricAndUSCustomarySelf")
infix fun <
    LeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftAndRightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightReciprocalQuantity,
    LeftAndRightReciprocalUnit,
    >.multipliedBySelf(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftAndRightReciprocalUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
        LeftAndRightReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftAndRightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            LeftAndRightReciprocalQuantity,
            LeftAndRightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBySelf(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericMultipliedByGenericSelf")
infix fun <
    LeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftAndRightReciprocalUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
    RightUnit : UndefinedReciprocalUnit<
        LeftAndRightReciprocalQuantity,
        LeftAndRightReciprocalUnit,
        >,
    > UndefinedScientificValue<
    LeftAndRightReciprocalQuantity,
    LeftAndRightReciprocalUnit,
    >.multipliedBySelf(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) = multipliedBySelf(
    right,
    getDimensionless = { One },
) {
        value: Decimal,
        unit: One,
    ->
    DefaultScientificValue(value, unit)
}
