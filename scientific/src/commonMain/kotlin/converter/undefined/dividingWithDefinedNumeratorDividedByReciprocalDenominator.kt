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
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Div<Wr<A>, B> / Inv<B> -> A!

@JvmName("dividingWithDefinedNumeratorDividedByReciprocalDenominator")
fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit : ScientificUnit<NumeratorNumeratorQuantity>,
    WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
        NumeratorNumeratorQuantity,
        NumeratorNumeratorUnit,
        >,
    NumeratorDenominatorAndDenominatorReciprocalQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalQuantity>,
    NumeratorUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        WrappedNumeratorNumeratorUnit,
        NumeratorDenominatorAndDenominatorReciprocalQuantity,
        NumeratorDenominatorUnit,
        >,
    DenominatorReciprocalUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalQuantity>,
    DenominatorUnit : UndefinedReciprocalUnit<
        NumeratorDenominatorAndDenominatorReciprocalQuantity,
        DenominatorReciprocalUnit,
        >,
    NumeratorNumeratorValue : ScientificValue<NumeratorNumeratorQuantity, NumeratorNumeratorUnit>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        NumeratorDenominatorAndDenominatorReciprocalQuantity,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
    factory: (Decimal, NumeratorNumeratorUnit) -> NumeratorNumeratorValue,
) = unit.numerator.wrapped.byDividing(this, right, factory)

@JvmName("metricAndImperialDividingWithDefinedNumeratorDividedByMetricAndImperialReciprocalDenominator")
infix fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorAndDenominatorReciprocalQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        NumeratorDenominatorAndDenominatorReciprocalQuantity,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorQuantity>,
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
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorNumeratorQuantity,
                >,
            WrappedNumeratorNumeratorUnit,
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
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

@JvmName("metricDividingWithDefinedNumeratorDividedByMetricReciprocalDenominator")
infix fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorAndDenominatorReciprocalQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        NumeratorDenominatorAndDenominatorReciprocalQuantity,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
            NumeratorNumeratorQuantity,
            NumeratorNumeratorUnit,
            >,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorNumeratorQuantity,
                >,
            WrappedNumeratorNumeratorUnit,
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedReciprocalUnit<
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialDividingWithDefinedNumeratorDividedByImperialReciprocalDenominator")
infix fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorAndDenominatorReciprocalQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        NumeratorDenominatorAndDenominatorReciprocalQuantity,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
            NumeratorNumeratorQuantity,
            NumeratorNumeratorUnit,
            >,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorNumeratorQuantity,
                >,
            WrappedNumeratorNumeratorUnit,
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
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

@JvmName("ukImperialDividingWithDefinedNumeratorDividedByUKImperialReciprocalDenominator")
infix fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorAndDenominatorReciprocalQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        NumeratorDenominatorAndDenominatorReciprocalQuantity,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
            NumeratorNumeratorQuantity,
            NumeratorNumeratorUnit,
            >,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorNumeratorQuantity,
                >,
            WrappedNumeratorNumeratorUnit,
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedReciprocalUnit<
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingWithDefinedNumeratorDividedByUSCustomaryReciprocalDenominator")
infix fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorAndDenominatorReciprocalQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        NumeratorDenominatorAndDenominatorReciprocalQuantity,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
            NumeratorNumeratorQuantity,
            NumeratorNumeratorUnit,
            >,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorNumeratorQuantity,
                >,
            WrappedNumeratorNumeratorUnit,
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividingWithDefinedNumeratorDividedByMetricAndUKImperialReciprocalDenominator")
infix fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorAndDenominatorReciprocalQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        NumeratorDenominatorAndDenominatorReciprocalQuantity,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
            NumeratorNumeratorQuantity,
            NumeratorNumeratorUnit,
            >,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorNumeratorQuantity,
                >,
            WrappedNumeratorNumeratorUnit,
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedReciprocalUnit<
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
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

@JvmName("metricAndUSCustomaryDividingWithDefinedNumeratorDividedByMetricAndUSCustomaryReciprocalDenominator")
infix fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit,
    WrappedNumeratorNumeratorUnit,
    NumeratorDenominatorAndDenominatorReciprocalQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        NumeratorDenominatorAndDenominatorReciprocalQuantity,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
            NumeratorNumeratorQuantity,
            NumeratorNumeratorUnit,
            >,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorNumeratorQuantity,
                >,
            WrappedNumeratorNumeratorUnit,
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
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

@JvmName("genericDividingWithDefinedNumeratorDividedByGenericReciprocalDenominator")
infix fun <
    NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorQuantity>,
    WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
        NumeratorNumeratorQuantity,
        NumeratorNumeratorUnit,
        >,
    NumeratorDenominatorAndDenominatorReciprocalQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalQuantity>,
    NumeratorUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        WrappedNumeratorNumeratorUnit,
        NumeratorDenominatorAndDenominatorReciprocalQuantity,
        NumeratorDenominatorUnit,
        >,
    DenominatorReciprocalUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalQuantity>,
    DenominatorUnit : UndefinedReciprocalUnit<
        NumeratorDenominatorAndDenominatorReciprocalQuantity,
        DenominatorReciprocalUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            NumeratorNumeratorQuantity,
            >,
        NumeratorDenominatorAndDenominatorReciprocalQuantity,
        >,
    NumeratorUnit,
    >.genericDividedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            NumeratorDenominatorAndDenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) = dividedBy(right) {
        value: Decimal,
        unit: NumeratorNumeratorUnit,
    ->
    DefaultScientificValue(value, unit)
}
