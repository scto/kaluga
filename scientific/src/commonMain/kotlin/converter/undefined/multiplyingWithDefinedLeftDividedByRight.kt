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
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Mul<Wr<A>, B> / B -> A!

@JvmName("multiplyingWithDefinedLeftDividedByRight")
fun <
    NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftUnit : ScientificUnit<NumeratorLeftQuantity>,
    WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<NumeratorLeftQuantity, NumeratorLeftUnit>,
    NumeratorRightAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorQuantity>,
    NumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, WrappedNumeratorLeftUnit, NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
    NumeratorLeftValue : ScientificValue<NumeratorLeftQuantity, NumeratorLeftUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, NumeratorRightAndDenominatorQuantity>, NumeratorUnit>.dividedByRight(
    right: UndefinedScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
    factory: (Decimal, NumeratorLeftUnit) -> NumeratorLeftValue,
) = unit.left.wrapped.byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingWithDefinedLeftDividedByMetricAndImperialRight")
infix fun <
    NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftUnit,
    WrappedNumeratorLeftUnit,
    NumeratorRightAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorUnit,
    NumeratorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, NumeratorRightAndDenominatorQuantity>, NumeratorUnit>.dividedByRight(
    right: UndefinedScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
        NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<NumeratorLeftQuantity, NumeratorLeftUnit>,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightAndDenominatorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorQuantity>,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, WrappedNumeratorLeftUnit, NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByRight(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricMultiplyingWithDefinedLeftDividedByMetricRight")
infix fun <
    NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftUnit,
    WrappedNumeratorLeftUnit,
    NumeratorRightAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorUnit,
    NumeratorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, NumeratorRightAndDenominatorQuantity>, NumeratorUnit>.dividedByRight(
    right: UndefinedScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
        NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<NumeratorLeftQuantity, NumeratorLeftUnit>,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightAndDenominatorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorQuantity>,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, WrappedNumeratorLeftUnit, NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric =
    dividedByRight(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialMultiplyingWithDefinedLeftDividedByImperialRight")
infix fun <
    NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftUnit,
    WrappedNumeratorLeftUnit,
    NumeratorRightAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorUnit,
    NumeratorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, NumeratorRightAndDenominatorQuantity>, NumeratorUnit>.dividedByRight(
    right: UndefinedScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
        NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<NumeratorLeftQuantity, NumeratorLeftUnit>,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightAndDenominatorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorQuantity>,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, WrappedNumeratorLeftUnit, NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByRight(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialMultiplyingWithDefinedLeftDividedByUKImperialRight")
infix fun <
    NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftUnit,
    WrappedNumeratorLeftUnit,
    NumeratorRightAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorUnit,
    NumeratorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, NumeratorRightAndDenominatorQuantity>, NumeratorUnit>.dividedByRight(
    right: UndefinedScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
        NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<NumeratorLeftQuantity, NumeratorLeftUnit>,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightAndDenominatorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorQuantity>,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, WrappedNumeratorLeftUnit, NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial =
    dividedByRight(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryMultiplyingWithDefinedLeftDividedByUSCustomaryRight")
infix fun <
    NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftUnit,
    WrappedNumeratorLeftUnit,
    NumeratorRightAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorUnit,
    NumeratorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, NumeratorRightAndDenominatorQuantity>, NumeratorUnit>.dividedByRight(
    right: UndefinedScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
        NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<NumeratorLeftQuantity, NumeratorLeftUnit>,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightAndDenominatorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorQuantity>,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, WrappedNumeratorLeftUnit, NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByRight(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultiplyingWithDefinedLeftDividedByMetricAndUKImperialRight")
infix fun <
    NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftUnit,
    WrappedNumeratorLeftUnit,
    NumeratorRightAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorUnit,
    NumeratorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, NumeratorRightAndDenominatorQuantity>, NumeratorUnit>.dividedByRight(
    right: UndefinedScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
        NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<NumeratorLeftQuantity, NumeratorLeftUnit>,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightAndDenominatorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorQuantity>,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, WrappedNumeratorLeftUnit, NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial =
    dividedByRight(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultiplyingWithDefinedLeftDividedByMetricAndUSCustomaryRight")
infix fun <
    NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftUnit,
    WrappedNumeratorLeftUnit,
    NumeratorRightAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorUnit,
    NumeratorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, NumeratorRightAndDenominatorQuantity>, NumeratorUnit>.dividedByRight(
    right: UndefinedScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
        NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<NumeratorLeftQuantity, NumeratorLeftUnit>,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightAndDenominatorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorQuantity>,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, WrappedNumeratorLeftUnit, NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByRight(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericMultiplyingWithDefinedLeftDividedByGenericRight")
infix fun <
    NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
    WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<NumeratorLeftQuantity, NumeratorLeftUnit>,
    NumeratorRightAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorQuantity>,
    NumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, WrappedNumeratorLeftUnit, NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, NumeratorRightAndDenominatorQuantity>, NumeratorUnit>.dividedByRight(
    right: UndefinedScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) = dividedByRight(right) {
        value: Decimal,
        unit: NumeratorLeftUnit,
    ->
    DefaultScientificValue(value, unit)
}
