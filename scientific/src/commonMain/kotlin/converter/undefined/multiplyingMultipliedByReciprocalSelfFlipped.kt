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
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.One
import kotlin.jvm.JvmName

// Mul<A, B> * Inv<Mul<B, A>> -> One

@JvmName("multiplyingMultipliedByReciprocalSelfFlipped")
fun <
    LeftLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
    LeftRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftRightUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
    LeftUnit : UndefinedMultipliedUnit<
        LeftLeftAndRightReciprocalRightQuantity,
        LeftLeftUnit,
        LeftRightAndRightReciprocalLeftQuantity,
        LeftRightUnit,
        >,
    RightReciprocalLeftUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
    RightReciprocalRightUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
    RightReciprocalUnit : UndefinedMultipliedUnit<
        LeftRightAndRightReciprocalLeftQuantity,
        RightReciprocalLeftUnit,
        LeftLeftAndRightReciprocalRightQuantity,
        RightReciprocalRightUnit,
        >,
    RightUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            LeftRightAndRightReciprocalLeftQuantity,
            LeftLeftAndRightReciprocalRightQuantity,
            >,
        RightReciprocalUnit,
        >,
    TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
    TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightReciprocalRightQuantity,
        LeftRightAndRightReciprocalLeftQuantity,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                LeftLeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
    getDimensionless: () -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = getDimensionless().byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultiplyingMultipliedByMetricAndImperialReciprocalSelfFlipped")
infix fun <
    LeftLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightReciprocalRightQuantity,
        LeftRightAndRightReciprocalLeftQuantity,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                LeftLeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightReciprocalRightQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftRightAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftLeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                LeftLeftAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
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

@JvmName("metricMultiplyingMultipliedByMetricReciprocalSelfFlipped")
infix fun <
    LeftLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightReciprocalRightQuantity,
        LeftRightAndRightReciprocalLeftQuantity,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                LeftLeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightReciprocalRightQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftRightAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftLeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                LeftLeftAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
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

@JvmName("imperialMultiplyingMultipliedByImperialReciprocalSelfFlipped")
infix fun <
    LeftLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightReciprocalRightQuantity,
        LeftRightAndRightReciprocalLeftQuantity,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                LeftLeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightReciprocalRightQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftRightAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftLeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                LeftLeftAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
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

@JvmName("ukImperialMultiplyingMultipliedByUKImperialReciprocalSelfFlipped")
infix fun <
    LeftLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightReciprocalRightQuantity,
        LeftRightAndRightReciprocalLeftQuantity,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                LeftLeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightReciprocalRightQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftRightAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftLeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                LeftLeftAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
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

@JvmName("usCustomaryMultiplyingMultipliedByUSCustomaryReciprocalSelfFlipped")
infix fun <
    LeftLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightReciprocalRightQuantity,
        LeftRightAndRightReciprocalLeftQuantity,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                LeftLeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightReciprocalRightQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftRightAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftLeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                LeftLeftAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
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

@JvmName("metricAndUKImperialMultiplyingMultipliedByMetricAndUKImperialReciprocalSelfFlipped")
infix fun <
    LeftLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightReciprocalRightQuantity,
        LeftRightAndRightReciprocalLeftQuantity,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                LeftLeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightReciprocalRightQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftRightAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftLeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                LeftLeftAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
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

@JvmName("metricAndUSCustomaryMultiplyingMultipliedByMetricAndUSCustomaryReciprocalSelfFlipped")
infix fun <
    LeftLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightReciprocalRightQuantity,
        LeftRightAndRightReciprocalLeftQuantity,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                LeftLeftAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightReciprocalRightQuantity,
            LeftLeftUnit,
            LeftRightAndRightReciprocalLeftQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftRightAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftLeftAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                LeftLeftAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
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

@JvmName("genericMultiplyingMultipliedByGenericReciprocalSelfFlipped")
infix fun <
    LeftLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
    LeftRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftRightUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
    LeftUnit : UndefinedMultipliedUnit<
        LeftLeftAndRightReciprocalRightQuantity,
        LeftLeftUnit,
        LeftRightAndRightReciprocalLeftQuantity,
        LeftRightUnit,
        >,
    RightReciprocalLeftUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
    RightReciprocalRightUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
    RightReciprocalUnit : UndefinedMultipliedUnit<
        LeftRightAndRightReciprocalLeftQuantity,
        RightReciprocalLeftUnit,
        LeftLeftAndRightReciprocalRightQuantity,
        RightReciprocalRightUnit,
        >,
    RightUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            LeftRightAndRightReciprocalLeftQuantity,
            LeftLeftAndRightReciprocalRightQuantity,
            >,
        RightReciprocalUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightReciprocalRightQuantity,
        LeftRightAndRightReciprocalLeftQuantity,
        >,
    LeftUnit,
    >.genericMultipliedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightReciprocalLeftQuantity,
                LeftLeftAndRightReciprocalRightQuantity,
                >,
            >,
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
