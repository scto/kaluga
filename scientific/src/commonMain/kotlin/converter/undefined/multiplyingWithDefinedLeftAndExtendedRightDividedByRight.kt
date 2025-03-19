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
import com.splendo.kaluga.scientific.unit.UndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Mul<Wr<A>, Ex<B>> / B! -> A!

@JvmName("multiplyingWithDefinedLeftAndExtendedRightDividedByRight")
fun <
    NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftUnit : ScientificUnit<NumeratorLeftQuantity>,
    WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
        NumeratorLeftQuantity,
        NumeratorLeftUnit,
        >,
    ExtendedNumeratorRightUnit : UndefinedExtendedUnit<
        NumeratorRightAndDenominatorQuantity,
        >,
    NumeratorUnit : UndefinedMultipliedUnit<
        UndefinedQuantityType.Extended<
            NumeratorLeftQuantity,
            >,
        WrappedNumeratorLeftUnit,
        UndefinedQuantityType.Extended<
            NumeratorRightAndDenominatorQuantity,
            >,
        ExtendedNumeratorRightUnit,
        >,
    NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorUnit : ScientificUnit<NumeratorRightAndDenominatorQuantity>,
    NumeratorLeftValue : ScientificValue<NumeratorLeftQuantity, NumeratorLeftUnit>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        UndefinedQuantityType.Extended<
            NumeratorLeftQuantity,
            >,
        UndefinedQuantityType.Extended<
            NumeratorRightAndDenominatorQuantity,
            >,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: ScientificValue<NumeratorRightAndDenominatorQuantity, DenominatorUnit>,
    factory: (Decimal, NumeratorLeftUnit) -> NumeratorLeftValue,
) = unit.left.wrapped.byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingWithDefinedLeftAndExtendedRightDividedByMetricAndImperialRight")
infix fun <
    NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftUnit,
    WrappedNumeratorLeftUnit,
    ExtendedNumeratorRightUnit,
    NumeratorUnit,
    NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        UndefinedQuantityType.Extended<
            NumeratorLeftQuantity,
            >,
        UndefinedQuantityType.Extended<
            NumeratorRightAndDenominatorQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: ScientificValue<NumeratorRightAndDenominatorQuantity, DenominatorUnit>,
) where
        NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            >,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedNumeratorRightUnit : UndefinedExtendedUnit<
            NumeratorRightAndDenominatorQuantity,
            >,
        ExtendedNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        ExtendedNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorLeftQuantity,
                >,
            WrappedNumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorRightAndDenominatorQuantity,
                >,
            ExtendedNumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricMultiplyingWithDefinedLeftAndExtendedRightDividedByMetricRight")
infix fun <
    NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftUnit,
    WrappedNumeratorLeftUnit,
    ExtendedNumeratorRightUnit,
    NumeratorUnit,
    NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        UndefinedQuantityType.Extended<
            NumeratorLeftQuantity,
            >,
        UndefinedQuantityType.Extended<
            NumeratorRightAndDenominatorQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: ScientificValue<NumeratorRightAndDenominatorQuantity, DenominatorUnit>,
) where
        NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            >,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        ExtendedNumeratorRightUnit : UndefinedExtendedUnit<
            NumeratorRightAndDenominatorQuantity,
            >,
        ExtendedNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorLeftQuantity,
                >,
            WrappedNumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorRightAndDenominatorQuantity,
                >,
            ExtendedNumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialMultiplyingWithDefinedLeftAndExtendedRightDividedByImperialRight")
infix fun <
    NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftUnit,
    WrappedNumeratorLeftUnit,
    ExtendedNumeratorRightUnit,
    NumeratorUnit,
    NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        UndefinedQuantityType.Extended<
            NumeratorLeftQuantity,
            >,
        UndefinedQuantityType.Extended<
            NumeratorRightAndDenominatorQuantity,
            >,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: ScientificValue<NumeratorRightAndDenominatorQuantity, DenominatorUnit>,
) where
        NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            >,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedNumeratorRightUnit : UndefinedExtendedUnit<
            NumeratorRightAndDenominatorQuantity,
            >,
        ExtendedNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorLeftQuantity,
                >,
            WrappedNumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorRightAndDenominatorQuantity,
                >,
            ExtendedNumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialMultiplyingWithDefinedLeftAndExtendedRightDividedByUKImperialRight")
infix fun <
    NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftUnit,
    WrappedNumeratorLeftUnit,
    ExtendedNumeratorRightUnit,
    NumeratorUnit,
    NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        UndefinedQuantityType.Extended<
            NumeratorLeftQuantity,
            >,
        UndefinedQuantityType.Extended<
            NumeratorRightAndDenominatorQuantity,
            >,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: ScientificValue<NumeratorRightAndDenominatorQuantity, DenominatorUnit>,
) where
        NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            >,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedNumeratorRightUnit : UndefinedExtendedUnit<
            NumeratorRightAndDenominatorQuantity,
            >,
        ExtendedNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorLeftQuantity,
                >,
            WrappedNumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorRightAndDenominatorQuantity,
                >,
            ExtendedNumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryMultiplyingWithDefinedLeftAndExtendedRightDividedByUSCustomaryRight")
infix fun <
    NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftUnit,
    WrappedNumeratorLeftUnit,
    ExtendedNumeratorRightUnit,
    NumeratorUnit,
    NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        UndefinedQuantityType.Extended<
            NumeratorLeftQuantity,
            >,
        UndefinedQuantityType.Extended<
            NumeratorRightAndDenominatorQuantity,
            >,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: ScientificValue<NumeratorRightAndDenominatorQuantity, DenominatorUnit>,
) where
        NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            >,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedNumeratorRightUnit : UndefinedExtendedUnit<
            NumeratorRightAndDenominatorQuantity,
            >,
        ExtendedNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorLeftQuantity,
                >,
            WrappedNumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorRightAndDenominatorQuantity,
                >,
            ExtendedNumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultiplyingWithDefinedLeftAndExtendedRightDividedByMetricAndUKImperialRight")
infix fun <
    NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftUnit,
    WrappedNumeratorLeftUnit,
    ExtendedNumeratorRightUnit,
    NumeratorUnit,
    NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        UndefinedQuantityType.Extended<
            NumeratorLeftQuantity,
            >,
        UndefinedQuantityType.Extended<
            NumeratorRightAndDenominatorQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: ScientificValue<NumeratorRightAndDenominatorQuantity, DenominatorUnit>,
) where
        NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            >,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedNumeratorRightUnit : UndefinedExtendedUnit<
            NumeratorRightAndDenominatorQuantity,
            >,
        ExtendedNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        ExtendedNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorLeftQuantity,
                >,
            WrappedNumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorRightAndDenominatorQuantity,
                >,
            ExtendedNumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultiplyingWithDefinedLeftAndExtendedRightDividedByMetricAndUSCustomaryRight")
infix fun <
    NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftUnit,
    WrappedNumeratorLeftUnit,
    ExtendedNumeratorRightUnit,
    NumeratorUnit,
    NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        UndefinedQuantityType.Extended<
            NumeratorLeftQuantity,
            >,
        UndefinedQuantityType.Extended<
            NumeratorRightAndDenominatorQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: ScientificValue<NumeratorRightAndDenominatorQuantity, DenominatorUnit>,
) where
        NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            >,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedNumeratorRightUnit : UndefinedExtendedUnit<
            NumeratorRightAndDenominatorQuantity,
            >,
        ExtendedNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        ExtendedNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorLeftQuantity,
                >,
            WrappedNumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorRightAndDenominatorQuantity,
                >,
            ExtendedNumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericMultiplyingWithDefinedLeftAndExtendedRightDividedByGenericRight")
infix fun <
    NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
    WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
        NumeratorLeftQuantity,
        NumeratorLeftUnit,
        >,
    ExtendedNumeratorRightUnit : UndefinedExtendedUnit<
        NumeratorRightAndDenominatorQuantity,
        >,
    NumeratorUnit : UndefinedMultipliedUnit<
        UndefinedQuantityType.Extended<
            NumeratorLeftQuantity,
            >,
        WrappedNumeratorLeftUnit,
        UndefinedQuantityType.Extended<
            NumeratorRightAndDenominatorQuantity,
            >,
        ExtendedNumeratorRightUnit,
        >,
    NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        UndefinedQuantityType.Extended<
            NumeratorLeftQuantity,
            >,
        UndefinedQuantityType.Extended<
            NumeratorRightAndDenominatorQuantity,
            >,
        >,
    NumeratorUnit,
    >.genericDividedByGeneric(
    right: ScientificValue<NumeratorRightAndDenominatorQuantity, DenominatorUnit>,
) = dividedBy(right) {
        value: Decimal,
        unit: NumeratorLeftUnit,
    ->
    DefaultScientificValue(value, unit)
}
