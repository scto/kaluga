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
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import kotlin.jvm.JvmName

// Inv<A> / Inv<Mul<B, A>> -> B

@JvmName("reciprocalDividedByReciprocalMultiplyingWithSelfAsRight")
fun <
    NumeratorReciprocalAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
    NumeratorUnit : UndefinedReciprocalUnit<
        NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
        NumeratorReciprocalUnit,
        >,
    DenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<DenominatorReciprocalLeftQuantity>,
    DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
    DenominatorReciprocalUnit : UndefinedMultipliedUnit<
        DenominatorReciprocalLeftQuantity,
        DenominatorReciprocalLeftUnit,
        NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
        DenominatorReciprocalRightUnit,
        >,
    DenominatorUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            DenominatorReciprocalLeftQuantity,
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            >,
        DenominatorReciprocalUnit,
        >,
    DenominatorReciprocalLeftValue : UndefinedScientificValue<
        DenominatorReciprocalLeftQuantity,
        DenominatorReciprocalLeftUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                DenominatorReciprocalLeftQuantity,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
    factory: (Decimal, DenominatorReciprocalLeftUnit) -> DenominatorReciprocalLeftValue,
) = right.unit.inverse.left.byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalDividedByMetricAndImperialReciprocalMultiplyingWithSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    DenominatorReciprocalLeftUnit,
    DenominatorReciprocalRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                DenominatorReciprocalLeftQuantity,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<DenominatorReciprocalLeftQuantity>,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            DenominatorReciprocalLeftQuantity,
            DenominatorReciprocalLeftUnit,
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            DenominatorReciprocalRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                DenominatorReciprocalLeftQuantity,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorReciprocalLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricReciprocalDividedByMetricReciprocalMultiplyingWithSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    DenominatorReciprocalLeftUnit,
    DenominatorReciprocalRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                DenominatorReciprocalLeftQuantity,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<DenominatorReciprocalLeftQuantity>,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            DenominatorReciprocalLeftQuantity,
            DenominatorReciprocalLeftUnit,
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            DenominatorReciprocalRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                DenominatorReciprocalLeftQuantity,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorReciprocalLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialReciprocalDividedByImperialReciprocalMultiplyingWithSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    DenominatorReciprocalLeftUnit,
    DenominatorReciprocalRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                DenominatorReciprocalLeftQuantity,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<DenominatorReciprocalLeftQuantity>,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            DenominatorReciprocalLeftQuantity,
            DenominatorReciprocalLeftUnit,
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            DenominatorReciprocalRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                DenominatorReciprocalLeftQuantity,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorReciprocalLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialReciprocalDividedByUKImperialReciprocalMultiplyingWithSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    DenominatorReciprocalLeftUnit,
    DenominatorReciprocalRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                DenominatorReciprocalLeftQuantity,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<DenominatorReciprocalLeftQuantity>,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            DenominatorReciprocalLeftQuantity,
            DenominatorReciprocalLeftUnit,
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            DenominatorReciprocalRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                DenominatorReciprocalLeftQuantity,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorReciprocalLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryReciprocalDividedByUSCustomaryReciprocalMultiplyingWithSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    DenominatorReciprocalLeftUnit,
    DenominatorReciprocalRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                DenominatorReciprocalLeftQuantity,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<DenominatorReciprocalLeftQuantity>,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            DenominatorReciprocalLeftQuantity,
            DenominatorReciprocalLeftUnit,
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            DenominatorReciprocalRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                DenominatorReciprocalLeftQuantity,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorReciprocalLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialReciprocalDividedByMetricAndUKImperialReciprocalMultiplyingWithSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    DenominatorReciprocalLeftUnit,
    DenominatorReciprocalRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                DenominatorReciprocalLeftQuantity,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<DenominatorReciprocalLeftQuantity>,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            DenominatorReciprocalLeftQuantity,
            DenominatorReciprocalLeftUnit,
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            DenominatorReciprocalRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                DenominatorReciprocalLeftQuantity,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorReciprocalLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryReciprocalDividedByMetricAndUSCustomaryReciprocalMultiplyingWithSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    DenominatorReciprocalLeftUnit,
    DenominatorReciprocalRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                DenominatorReciprocalLeftQuantity,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<DenominatorReciprocalLeftQuantity>,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            DenominatorReciprocalLeftQuantity,
            DenominatorReciprocalLeftUnit,
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            DenominatorReciprocalRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                DenominatorReciprocalLeftQuantity,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorReciprocalLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("genericReciprocalDividedByGenericReciprocalMultiplyingWithSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
    NumeratorUnit : UndefinedReciprocalUnit<
        NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
        NumeratorReciprocalUnit,
        >,
    DenominatorReciprocalLeftQuantity : UndefinedQuantityType,
    DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<DenominatorReciprocalLeftQuantity>,
    DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
    DenominatorReciprocalUnit : UndefinedMultipliedUnit<
        DenominatorReciprocalLeftQuantity,
        DenominatorReciprocalLeftUnit,
        NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
        DenominatorReciprocalRightUnit,
        >,
    DenominatorUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            DenominatorReciprocalLeftQuantity,
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            >,
        DenominatorReciprocalUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
        >,
    NumeratorUnit,
    >.genericDividedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                DenominatorReciprocalLeftQuantity,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) = dividedBy(right) {
        value: Decimal,
        unit: DenominatorReciprocalLeftUnit,
    ->
    DefaultUndefinedScientificValue(value, unit)
}
