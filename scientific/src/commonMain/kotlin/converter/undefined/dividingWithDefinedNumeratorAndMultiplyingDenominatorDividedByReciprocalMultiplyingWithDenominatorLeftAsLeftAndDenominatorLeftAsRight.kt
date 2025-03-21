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
import com.splendo.kaluga.scientific.unit.DefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Div<Wr<A>, Mul<B, B>> / Inv<Mul<B, B>> -> A!

@JvmName("dividingWithDefinedNumeratorAndMultiplyingDenominatorDividedByReciprocalMultiplyingWithDenominatorLeftAsLeftAndDenominatorLeftAsRight")
fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit : ScientificUnit<NumeratorNumeratorQuantity>,
    WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
        NumeratorNumeratorQuantity,
        NumeratorNumeratorUnit,
        >,
    NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
    NumeratorDenominatorUnit : UndefinedMultipliedUnit<
        NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
        NumeratorDenominatorLeftAndRightUnit,
        NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
        NumeratorDenominatorLeftAndRightUnit,
        >,
    NumeratorUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        WrappedNumeratorNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            >,
        NumeratorDenominatorUnit,
        >,
    DenominatorReciprocalLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
    DenominatorReciprocalUnit : UndefinedMultipliedUnit<
        NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
        DenominatorReciprocalLeftAndRightUnit,
        NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
        DenominatorReciprocalLeftAndRightUnit,
        >,
    DenominatorUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            >,
        DenominatorReciprocalUnit,
        >,
    NumeratorNumeratorValue : ScientificValue<NumeratorNumeratorQuantity, NumeratorNumeratorUnit>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
    factory: (Decimal, NumeratorNumeratorUnit) -> NumeratorNumeratorValue,
) = unit.numerator.wrapped.byDividing(this, right, factory)

@JvmName("metricAndImperialDividingWithDefinedNumeratorAndMultiplyingDenominatorDividedByMetricAndImperialReciprocalMultiplyingWithDenominatorLeftAsLeftAndDenominatorLeftAsRight")
infix fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftAndRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : DefinedScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
            NumeratorNumeratorQuantity,
            NumeratorNumeratorUnit,
            >,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
        NumeratorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightUnit,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightUnit,
            >,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorNumeratorQuantity,
                >,
            WrappedNumeratorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricDividingWithDefinedNumeratorAndMultiplyingDenominatorDividedByMetricReciprocalMultiplyingWithDenominatorLeftAsLeftAndDenominatorLeftAsRight")
infix fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftAndRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : DefinedScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
            NumeratorNumeratorQuantity,
            NumeratorNumeratorUnit,
            >,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
        NumeratorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightUnit,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightUnit,
            >,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorNumeratorQuantity,
                >,
            WrappedNumeratorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialDividingWithDefinedNumeratorAndMultiplyingDenominatorDividedByImperialReciprocalMultiplyingWithDenominatorLeftAsLeftAndDenominatorLeftAsRight")
infix fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftAndRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : DefinedScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
            NumeratorNumeratorQuantity,
            NumeratorNumeratorUnit,
            >,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
        NumeratorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightUnit,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightUnit,
            >,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorNumeratorQuantity,
                >,
            WrappedNumeratorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialDividingWithDefinedNumeratorAndMultiplyingDenominatorDividedByUKImperialReciprocalMultiplyingWithDenominatorLeftAsLeftAndDenominatorLeftAsRight")
infix fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftAndRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : DefinedScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
            NumeratorNumeratorQuantity,
            NumeratorNumeratorUnit,
            >,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
        NumeratorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightUnit,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightUnit,
            >,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorNumeratorQuantity,
                >,
            WrappedNumeratorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingWithDefinedNumeratorAndMultiplyingDenominatorDividedByUSCustomaryReciprocalMultiplyingWithDenominatorLeftAsLeftAndDenominatorLeftAsRight")
infix fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftAndRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : DefinedScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
            NumeratorNumeratorQuantity,
            NumeratorNumeratorUnit,
            >,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
        NumeratorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightUnit,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightUnit,
            >,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorNumeratorQuantity,
                >,
            WrappedNumeratorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName(
    "metricAndUKImperialDividingWithDefinedNumeratorAndMultiplyingDenominatorDividedByMetricAndUKImperialReciprocalMultiplyingWithDenominatorLeftAsLeftAndDenominatorLeftAsRight",
)
infix fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftAndRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : DefinedScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
            NumeratorNumeratorQuantity,
            NumeratorNumeratorUnit,
            >,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
        NumeratorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightUnit,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightUnit,
            >,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorNumeratorQuantity,
                >,
            WrappedNumeratorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName(
    "metricAndUSCustomaryDividingWithDefinedNumeratorAndMultiplyingDenominatorDividedByMetricAndUSCustomaryReciprocalMultiplyingWithDenominatorLeftAsLeftAndDenominatorLeftAsRight",
)
infix fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftAndRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : DefinedScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
            NumeratorNumeratorQuantity,
            NumeratorNumeratorUnit,
            >,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
        NumeratorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightUnit,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightUnit,
            >,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorNumeratorQuantity,
                >,
            WrappedNumeratorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericDividingWithDefinedNumeratorAndMultiplyingDenominatorDividedByGenericReciprocalMultiplyingWithDenominatorLeftAsLeftAndDenominatorLeftAsRight")
infix fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit : DefinedScientificUnit<NumeratorNumeratorQuantity>,
    WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
        NumeratorNumeratorQuantity,
        NumeratorNumeratorUnit,
        >,
    NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
    NumeratorDenominatorUnit : UndefinedMultipliedUnit<
        NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
        NumeratorDenominatorLeftAndRightUnit,
        NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
        NumeratorDenominatorLeftAndRightUnit,
        >,
    NumeratorUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        WrappedNumeratorNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            >,
        NumeratorDenominatorUnit,
        >,
    DenominatorReciprocalLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
    DenominatorReciprocalUnit : UndefinedMultipliedUnit<
        NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
        DenominatorReciprocalLeftAndRightUnit,
        NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
        DenominatorReciprocalLeftAndRightUnit,
        >,
    DenominatorUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            >,
        DenominatorReciprocalUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.genericDividedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) = dividedBy(right) {
        value: Decimal,
        unit: NumeratorNumeratorUnit,
    ->
    DefaultScientificValue(value, unit)
}
