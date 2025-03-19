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
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Inv<A> / Inv<Mul<Wr<B>, A>> -> B!

@JvmName("reciprocalDividedByReciprocalMultiplyingWithDefinedLeftAndSelfAsRight")
fun <
    NumeratorReciprocalAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
    NumeratorUnit : UndefinedReciprocalUnit<
        NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
        NumeratorReciprocalUnit,
        >,
    DenominatorReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorReciprocalLeftUnit : ScientificUnit<DenominatorReciprocalLeftQuantity>,
    WrappedDenominatorReciprocalLeftUnit : WrappedUndefinedExtendedUnit<
        DenominatorReciprocalLeftQuantity,
        DenominatorReciprocalLeftUnit,
        >,
    DenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
    DenominatorReciprocalUnit : UndefinedMultipliedUnit<
        UndefinedQuantityType.Extended<
            DenominatorReciprocalLeftQuantity,
            >,
        WrappedDenominatorReciprocalLeftUnit,
        NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
        DenominatorReciprocalRightUnit,
        >,
    DenominatorUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                DenominatorReciprocalLeftQuantity,
                >,
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            >,
        DenominatorReciprocalUnit,
        >,
    DenominatorReciprocalLeftValue : ScientificValue<DenominatorReciprocalLeftQuantity, DenominatorReciprocalLeftUnit>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    DenominatorReciprocalLeftQuantity,
                    >,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
    factory: (Decimal, DenominatorReciprocalLeftUnit) -> DenominatorReciprocalLeftValue,
) = right.unit.inverse.left.wrapped.byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalDividedByMetricAndImperialReciprocalMultiplyingWithDefinedLeftAndSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorReciprocalLeftUnit,
    WrappedDenominatorReciprocalLeftUnit,
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
                UndefinedQuantityType.Extended<
                    DenominatorReciprocalLeftQuantity,
                    >,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
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
        DenominatorReciprocalLeftUnit : AbstractScientificUnit<DenominatorReciprocalLeftQuantity>,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedDenominatorReciprocalLeftUnit : WrappedUndefinedExtendedUnit<
            DenominatorReciprocalLeftQuantity,
            DenominatorReciprocalLeftUnit,
            >,
        WrappedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                DenominatorReciprocalLeftQuantity,
                >,
            WrappedDenominatorReciprocalLeftUnit,
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            DenominatorReciprocalRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    DenominatorReciprocalLeftQuantity,
                    >,
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
        DefaultScientificValue(value, unit)
    }

@JvmName("metricReciprocalDividedByMetricReciprocalMultiplyingWithDefinedLeftAndSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorReciprocalLeftUnit,
    WrappedDenominatorReciprocalLeftUnit,
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
                UndefinedQuantityType.Extended<
                    DenominatorReciprocalLeftQuantity,
                    >,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalLeftUnit : AbstractScientificUnit<DenominatorReciprocalLeftQuantity>,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedDenominatorReciprocalLeftUnit : WrappedUndefinedExtendedUnit<
            DenominatorReciprocalLeftQuantity,
            DenominatorReciprocalLeftUnit,
            >,
        WrappedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                DenominatorReciprocalLeftQuantity,
                >,
            WrappedDenominatorReciprocalLeftUnit,
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            DenominatorReciprocalRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    DenominatorReciprocalLeftQuantity,
                    >,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorReciprocalLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialReciprocalDividedByImperialReciprocalMultiplyingWithDefinedLeftAndSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorReciprocalLeftUnit,
    WrappedDenominatorReciprocalLeftUnit,
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
                UndefinedQuantityType.Extended<
                    DenominatorReciprocalLeftQuantity,
                    >,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalLeftUnit : AbstractScientificUnit<DenominatorReciprocalLeftQuantity>,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedDenominatorReciprocalLeftUnit : WrappedUndefinedExtendedUnit<
            DenominatorReciprocalLeftQuantity,
            DenominatorReciprocalLeftUnit,
            >,
        WrappedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                DenominatorReciprocalLeftQuantity,
                >,
            WrappedDenominatorReciprocalLeftUnit,
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            DenominatorReciprocalRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    DenominatorReciprocalLeftQuantity,
                    >,
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
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialReciprocalDividedByUKImperialReciprocalMultiplyingWithDefinedLeftAndSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorReciprocalLeftUnit,
    WrappedDenominatorReciprocalLeftUnit,
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
                UndefinedQuantityType.Extended<
                    DenominatorReciprocalLeftQuantity,
                    >,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalLeftUnit : AbstractScientificUnit<DenominatorReciprocalLeftQuantity>,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedDenominatorReciprocalLeftUnit : WrappedUndefinedExtendedUnit<
            DenominatorReciprocalLeftQuantity,
            DenominatorReciprocalLeftUnit,
            >,
        WrappedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                DenominatorReciprocalLeftQuantity,
                >,
            WrappedDenominatorReciprocalLeftUnit,
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            DenominatorReciprocalRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    DenominatorReciprocalLeftQuantity,
                    >,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorReciprocalLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryReciprocalDividedByUSCustomaryReciprocalMultiplyingWithDefinedLeftAndSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorReciprocalLeftUnit,
    WrappedDenominatorReciprocalLeftUnit,
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
                UndefinedQuantityType.Extended<
                    DenominatorReciprocalLeftQuantity,
                    >,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalLeftUnit : AbstractScientificUnit<DenominatorReciprocalLeftQuantity>,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedDenominatorReciprocalLeftUnit : WrappedUndefinedExtendedUnit<
            DenominatorReciprocalLeftQuantity,
            DenominatorReciprocalLeftUnit,
            >,
        WrappedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                DenominatorReciprocalLeftQuantity,
                >,
            WrappedDenominatorReciprocalLeftUnit,
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            DenominatorReciprocalRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    DenominatorReciprocalLeftQuantity,
                    >,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorReciprocalLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialReciprocalDividedByMetricAndUKImperialReciprocalMultiplyingWithDefinedLeftAndSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorReciprocalLeftUnit,
    WrappedDenominatorReciprocalLeftUnit,
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
                UndefinedQuantityType.Extended<
                    DenominatorReciprocalLeftQuantity,
                    >,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalLeftUnit : AbstractScientificUnit<DenominatorReciprocalLeftQuantity>,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedDenominatorReciprocalLeftUnit : WrappedUndefinedExtendedUnit<
            DenominatorReciprocalLeftQuantity,
            DenominatorReciprocalLeftUnit,
            >,
        WrappedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                DenominatorReciprocalLeftQuantity,
                >,
            WrappedDenominatorReciprocalLeftUnit,
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            DenominatorReciprocalRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    DenominatorReciprocalLeftQuantity,
                    >,
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
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryReciprocalDividedByMetricAndUSCustomaryReciprocalMultiplyingWithDefinedLeftAndSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorReciprocalLeftUnit,
    WrappedDenominatorReciprocalLeftUnit,
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
                UndefinedQuantityType.Extended<
                    DenominatorReciprocalLeftQuantity,
                    >,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalLeftUnit : AbstractScientificUnit<DenominatorReciprocalLeftQuantity>,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedDenominatorReciprocalLeftUnit : WrappedUndefinedExtendedUnit<
            DenominatorReciprocalLeftQuantity,
            DenominatorReciprocalLeftUnit,
            >,
        WrappedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                DenominatorReciprocalLeftQuantity,
                >,
            WrappedDenominatorReciprocalLeftUnit,
            NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
            DenominatorReciprocalRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    DenominatorReciprocalLeftQuantity,
                    >,
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
        DefaultScientificValue(value, unit)
    }

@JvmName("genericReciprocalDividedByGenericReciprocalMultiplyingWithDefinedLeftAndSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
    NumeratorUnit : UndefinedReciprocalUnit<
        NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
        NumeratorReciprocalUnit,
        >,
    DenominatorReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorReciprocalLeftUnit : AbstractScientificUnit<DenominatorReciprocalLeftQuantity>,
    WrappedDenominatorReciprocalLeftUnit : WrappedUndefinedExtendedUnit<
        DenominatorReciprocalLeftQuantity,
        DenominatorReciprocalLeftUnit,
        >,
    DenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
    DenominatorReciprocalUnit : UndefinedMultipliedUnit<
        UndefinedQuantityType.Extended<
            DenominatorReciprocalLeftQuantity,
            >,
        WrappedDenominatorReciprocalLeftUnit,
        NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
        DenominatorReciprocalRightUnit,
        >,
    DenominatorUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                DenominatorReciprocalLeftQuantity,
                >,
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
                UndefinedQuantityType.Extended<
                    DenominatorReciprocalLeftQuantity,
                    >,
                NumeratorReciprocalAndDenominatorReciprocalRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) = dividedBy(right) {
        value: Decimal,
        unit: DenominatorReciprocalLeftUnit,
    ->
    DefaultScientificValue(value, unit)
}
