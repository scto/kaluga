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
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Mul<Wr<A>, Wr<A>> / A! -> A!

@JvmName("multiplyingWithDefinedLeftAndDefinedRightDividedByLeft")
fun <
    NumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftAndRightUnit : ScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
    WrappedNumeratorLeftAndRightUnit : WrappedUndefinedExtendedUnit<
        NumeratorLeftAndRightAndDenominatorQuantity,
        NumeratorLeftAndRightUnit,
        >,
    NumeratorUnit : UndefinedMultipliedUnit<
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        WrappedNumeratorLeftAndRightUnit,
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        WrappedNumeratorLeftAndRightUnit,
        >,
    DenominatorUnit : ScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
    NumeratorLeftAndRightValue : ScientificValue<NumeratorLeftAndRightAndDenominatorQuantity, NumeratorLeftAndRightUnit>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: ScientificValue<NumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
    factory: (Decimal, NumeratorLeftAndRightUnit) -> NumeratorLeftAndRightValue,
) = unit.left.wrapped.byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingWithDefinedLeftAndDefinedRightDividedByMetricAndImperialLeft")
infix fun <
    NumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftAndRightUnit,
    WrappedNumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: ScientificValue<NumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
        NumeratorLeftAndRightUnit : AbstractScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorLeftAndRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorLeftAndRightAndDenominatorQuantity,
            NumeratorLeftAndRightUnit,
            >,
        WrappedNumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorLeftAndRightAndDenominatorQuantity,
                >,
            WrappedNumeratorLeftAndRightUnit,
            UndefinedQuantityType.Extended<
                NumeratorLeftAndRightAndDenominatorQuantity,
                >,
            WrappedNumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftAndRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricMultiplyingWithDefinedLeftAndDefinedRightDividedByMetricLeft")
infix fun <
    NumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftAndRightUnit,
    WrappedNumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: ScientificValue<NumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
        NumeratorLeftAndRightUnit : AbstractScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorLeftAndRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorLeftAndRightAndDenominatorQuantity,
            NumeratorLeftAndRightUnit,
            >,
        WrappedNumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorLeftAndRightAndDenominatorQuantity,
                >,
            WrappedNumeratorLeftAndRightUnit,
            UndefinedQuantityType.Extended<
                NumeratorLeftAndRightAndDenominatorQuantity,
                >,
            WrappedNumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftAndRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialMultiplyingWithDefinedLeftAndDefinedRightDividedByImperialLeft")
infix fun <
    NumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftAndRightUnit,
    WrappedNumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: ScientificValue<NumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
        NumeratorLeftAndRightUnit : AbstractScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorLeftAndRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorLeftAndRightAndDenominatorQuantity,
            NumeratorLeftAndRightUnit,
            >,
        WrappedNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorLeftAndRightAndDenominatorQuantity,
                >,
            WrappedNumeratorLeftAndRightUnit,
            UndefinedQuantityType.Extended<
                NumeratorLeftAndRightAndDenominatorQuantity,
                >,
            WrappedNumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftAndRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialMultiplyingWithDefinedLeftAndDefinedRightDividedByUKImperialLeft")
infix fun <
    NumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftAndRightUnit,
    WrappedNumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: ScientificValue<NumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
        NumeratorLeftAndRightUnit : AbstractScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorLeftAndRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorLeftAndRightAndDenominatorQuantity,
            NumeratorLeftAndRightUnit,
            >,
        WrappedNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorLeftAndRightAndDenominatorQuantity,
                >,
            WrappedNumeratorLeftAndRightUnit,
            UndefinedQuantityType.Extended<
                NumeratorLeftAndRightAndDenominatorQuantity,
                >,
            WrappedNumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftAndRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryMultiplyingWithDefinedLeftAndDefinedRightDividedByUSCustomaryLeft")
infix fun <
    NumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftAndRightUnit,
    WrappedNumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: ScientificValue<NumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
        NumeratorLeftAndRightUnit : AbstractScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorLeftAndRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorLeftAndRightAndDenominatorQuantity,
            NumeratorLeftAndRightUnit,
            >,
        WrappedNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorLeftAndRightAndDenominatorQuantity,
                >,
            WrappedNumeratorLeftAndRightUnit,
            UndefinedQuantityType.Extended<
                NumeratorLeftAndRightAndDenominatorQuantity,
                >,
            WrappedNumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftAndRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultiplyingWithDefinedLeftAndDefinedRightDividedByMetricAndUKImperialLeft")
infix fun <
    NumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftAndRightUnit,
    WrappedNumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: ScientificValue<NumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
        NumeratorLeftAndRightUnit : AbstractScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorLeftAndRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorLeftAndRightAndDenominatorQuantity,
            NumeratorLeftAndRightUnit,
            >,
        WrappedNumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorLeftAndRightAndDenominatorQuantity,
                >,
            WrappedNumeratorLeftAndRightUnit,
            UndefinedQuantityType.Extended<
                NumeratorLeftAndRightAndDenominatorQuantity,
                >,
            WrappedNumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftAndRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultiplyingWithDefinedLeftAndDefinedRightDividedByMetricAndUSCustomaryLeft")
infix fun <
    NumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftAndRightUnit,
    WrappedNumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: ScientificValue<NumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) where
        NumeratorLeftAndRightUnit : AbstractScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorLeftAndRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorLeftAndRightAndDenominatorQuantity,
            NumeratorLeftAndRightUnit,
            >,
        WrappedNumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorLeftAndRightAndDenominatorQuantity,
                >,
            WrappedNumeratorLeftAndRightUnit,
            UndefinedQuantityType.Extended<
                NumeratorLeftAndRightAndDenominatorQuantity,
                >,
            WrappedNumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftAndRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericMultiplyingWithDefinedLeftAndDefinedRightDividedByGenericLeft")
infix fun <
    NumeratorLeftAndRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftAndRightUnit : AbstractScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
    WrappedNumeratorLeftAndRightUnit : WrappedUndefinedExtendedUnit<
        NumeratorLeftAndRightAndDenominatorQuantity,
        NumeratorLeftAndRightUnit,
        >,
    NumeratorUnit : UndefinedMultipliedUnit<
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        WrappedNumeratorLeftAndRightUnit,
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        WrappedNumeratorLeftAndRightUnit,
        >,
    DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        UndefinedQuantityType.Extended<
            NumeratorLeftAndRightAndDenominatorQuantity,
            >,
        >,
    NumeratorUnit,
    >.genericDividedByGeneric(
    right: ScientificValue<NumeratorLeftAndRightAndDenominatorQuantity, DenominatorUnit>,
) = dividedBy(right) {
        value: Decimal,
        unit: NumeratorLeftAndRightUnit,
    ->
    DefaultScientificValue(value, unit)
}
