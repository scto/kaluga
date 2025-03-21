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
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Mul<A, Wr<B>> / A -> B!

@JvmName("multiplyingWithDefinedRightDividedByLeft")
fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
    NumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorRightUnit : ScientificUnit<NumeratorRightQuantity>,
    WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
        NumeratorRightQuantity,
        NumeratorRightUnit,
        >,
    NumeratorUnit : UndefinedMultipliedUnit<
        NumeratorLeftAndDenominatorQuantity,
        NumeratorLeftUnit,
        UndefinedQuantityType.Extended<
            NumeratorRightQuantity,
            >,
        WrappedNumeratorRightUnit,
        >,
    DenominatorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
    NumeratorRightValue : ScientificValue<NumeratorRightQuantity, NumeratorRightUnit>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorQuantity,
        UndefinedQuantityType.Extended<
            NumeratorRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        NumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
    factory: (Decimal, NumeratorRightUnit) -> NumeratorRightValue,
) = unit.right.wrapped.byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingWithDefinedRightDividedByMetricAndImperialLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorRightUnit,
    WrappedNumeratorRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorQuantity,
        UndefinedQuantityType.Extended<
            NumeratorRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        NumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : DefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        WrappedNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorQuantity,
            NumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorRightQuantity,
                >,
            WrappedNumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricMultiplyingWithDefinedRightDividedByMetricLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorRightUnit,
    WrappedNumeratorRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorQuantity,
        UndefinedQuantityType.Extended<
            NumeratorRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        NumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : DefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        WrappedNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorQuantity,
            NumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorRightQuantity,
                >,
            WrappedNumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialMultiplyingWithDefinedRightDividedByImperialLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorRightUnit,
    WrappedNumeratorRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorQuantity,
        UndefinedQuantityType.Extended<
            NumeratorRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        NumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : DefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        WrappedNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorQuantity,
            NumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorRightQuantity,
                >,
            WrappedNumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialMultiplyingWithDefinedRightDividedByUKImperialLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorRightUnit,
    WrappedNumeratorRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorQuantity,
        UndefinedQuantityType.Extended<
            NumeratorRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        NumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : DefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        WrappedNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorQuantity,
            NumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorRightQuantity,
                >,
            WrappedNumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryMultiplyingWithDefinedRightDividedByUSCustomaryLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorRightUnit,
    WrappedNumeratorRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorQuantity,
        UndefinedQuantityType.Extended<
            NumeratorRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        NumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : DefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        WrappedNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorQuantity,
            NumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorRightQuantity,
                >,
            WrappedNumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultiplyingWithDefinedRightDividedByMetricAndUKImperialLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorRightUnit,
    WrappedNumeratorRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorQuantity,
        UndefinedQuantityType.Extended<
            NumeratorRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        NumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : DefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        WrappedNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorQuantity,
            NumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorRightQuantity,
                >,
            WrappedNumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultiplyingWithDefinedRightDividedByMetricAndUSCustomaryLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorRightUnit,
    WrappedNumeratorRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorQuantity,
        UndefinedQuantityType.Extended<
            NumeratorRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        NumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : DefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        WrappedNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorQuantity,
            NumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorRightQuantity,
                >,
            WrappedNumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericMultiplyingWithDefinedRightDividedByGenericLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
    NumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorRightUnit : DefinedScientificUnit<NumeratorRightQuantity>,
    WrappedNumeratorRightUnit : WrappedUndefinedExtendedUnit<
        NumeratorRightQuantity,
        NumeratorRightUnit,
        >,
    NumeratorUnit : UndefinedMultipliedUnit<
        NumeratorLeftAndDenominatorQuantity,
        NumeratorLeftUnit,
        UndefinedQuantityType.Extended<
            NumeratorRightQuantity,
            >,
        WrappedNumeratorRightUnit,
        >,
    DenominatorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorQuantity,
        UndefinedQuantityType.Extended<
            NumeratorRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.genericDividedByGeneric(
    right: UndefinedScientificValue<
        NumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) = dividedBy(right) {
        value: Decimal,
        unit: NumeratorRightUnit,
    ->
    DefaultScientificValue(value, unit)
}
