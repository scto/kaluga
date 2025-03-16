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
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// A! / Div<Wr<A>, B> -> B

@JvmName("definedDividedByDividingUnitWithSelfAsNumerator")
fun <
    NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorAndDenominatorNumeratorUnit : ScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
    WrappedNumeratorAndDenominatorNumeratorUnit : WrappedUndefinedExtendedUnit<NumeratorAndDenominatorNumeratorQuantity, NumeratorAndDenominatorNumeratorUnit>,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
    DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<NumeratorAndDenominatorNumeratorQuantity>, WrappedNumeratorAndDenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
    DenominatorDenominatorValue : UndefinedScientificValue<DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
    > ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorAndDenominatorNumeratorUnit>.dividedByDividingUnitWithSelfAsNumerator(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<NumeratorAndDenominatorNumeratorQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
    factory: (Decimal, DenominatorDenominatorUnit) -> DenominatorDenominatorValue,
) = right.unit.denominator.byDividing(this, right, factory)

@JvmName("metricAndImperialDefinedDividedByMetricAndImperialDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorAndDenominatorNumeratorUnit,
    WrappedNumeratorAndDenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorAndDenominatorNumeratorUnit>.dividedByDividingUnitWithSelfAsNumerator(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<NumeratorAndDenominatorNumeratorQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorAndDenominatorNumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorAndDenominatorNumeratorUnit : WrappedUndefinedExtendedUnit<NumeratorAndDenominatorNumeratorQuantity, NumeratorAndDenominatorNumeratorUnit>,
        WrappedNumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<NumeratorAndDenominatorNumeratorQuantity>, WrappedNumeratorAndDenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByDividingUnitWithSelfAsNumerator(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDefinedDividedByMetricDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorAndDenominatorNumeratorUnit,
    WrappedNumeratorAndDenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorAndDenominatorNumeratorUnit>.dividedByDividingUnitWithSelfAsNumerator(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<NumeratorAndDenominatorNumeratorQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorAndDenominatorNumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorAndDenominatorNumeratorUnit : WrappedUndefinedExtendedUnit<NumeratorAndDenominatorNumeratorQuantity, NumeratorAndDenominatorNumeratorUnit>,
        WrappedNumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<NumeratorAndDenominatorNumeratorQuantity>, WrappedNumeratorAndDenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedByDividingUnitWithSelfAsNumerator(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDefinedDividedByImperialDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorAndDenominatorNumeratorUnit,
    WrappedNumeratorAndDenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorAndDenominatorNumeratorUnit>.dividedByDividingUnitWithSelfAsNumerator(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<NumeratorAndDenominatorNumeratorQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorAndDenominatorNumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorAndDenominatorNumeratorUnit : WrappedUndefinedExtendedUnit<NumeratorAndDenominatorNumeratorQuantity, NumeratorAndDenominatorNumeratorUnit>,
        WrappedNumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<NumeratorAndDenominatorNumeratorQuantity>, WrappedNumeratorAndDenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByDividingUnitWithSelfAsNumerator(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDefinedDividedByUKImperialDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorAndDenominatorNumeratorUnit,
    WrappedNumeratorAndDenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorAndDenominatorNumeratorUnit>.dividedByDividingUnitWithSelfAsNumerator(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<NumeratorAndDenominatorNumeratorQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorAndDenominatorNumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorAndDenominatorNumeratorUnit : WrappedUndefinedExtendedUnit<NumeratorAndDenominatorNumeratorQuantity, NumeratorAndDenominatorNumeratorUnit>,
        WrappedNumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<NumeratorAndDenominatorNumeratorQuantity>, WrappedNumeratorAndDenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedByDividingUnitWithSelfAsNumerator(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDefinedDividedByUSCustomaryDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorAndDenominatorNumeratorUnit,
    WrappedNumeratorAndDenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorAndDenominatorNumeratorUnit>.dividedByDividingUnitWithSelfAsNumerator(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<NumeratorAndDenominatorNumeratorQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorAndDenominatorNumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorAndDenominatorNumeratorUnit : WrappedUndefinedExtendedUnit<NumeratorAndDenominatorNumeratorQuantity, NumeratorAndDenominatorNumeratorUnit>,
        WrappedNumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<NumeratorAndDenominatorNumeratorQuantity>, WrappedNumeratorAndDenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByDividingUnitWithSelfAsNumerator(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDefinedDividedByMetricAndUKImperialDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorAndDenominatorNumeratorUnit,
    WrappedNumeratorAndDenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorAndDenominatorNumeratorUnit>.dividedByDividingUnitWithSelfAsNumerator(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<NumeratorAndDenominatorNumeratorQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorAndDenominatorNumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorAndDenominatorNumeratorUnit : WrappedUndefinedExtendedUnit<NumeratorAndDenominatorNumeratorQuantity, NumeratorAndDenominatorNumeratorUnit>,
        WrappedNumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<NumeratorAndDenominatorNumeratorQuantity>, WrappedNumeratorAndDenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedByDividingUnitWithSelfAsNumerator(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDefinedDividedByMetricAndUSCustomaryDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorAndDenominatorNumeratorUnit,
    WrappedNumeratorAndDenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorAndDenominatorNumeratorUnit>.dividedByDividingUnitWithSelfAsNumerator(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<NumeratorAndDenominatorNumeratorQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorAndDenominatorNumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorAndDenominatorNumeratorUnit : WrappedUndefinedExtendedUnit<NumeratorAndDenominatorNumeratorQuantity, NumeratorAndDenominatorNumeratorUnit>,
        WrappedNumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorAndDenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<NumeratorAndDenominatorNumeratorQuantity>, WrappedNumeratorAndDenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByDividingUnitWithSelfAsNumerator(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("genericDefinedDividedByGenericDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorAndDenominatorNumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
    WrappedNumeratorAndDenominatorNumeratorUnit : WrappedUndefinedExtendedUnit<NumeratorAndDenominatorNumeratorQuantity, NumeratorAndDenominatorNumeratorUnit>,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
    DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<NumeratorAndDenominatorNumeratorQuantity>, WrappedNumeratorAndDenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
    > ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorAndDenominatorNumeratorUnit>.dividedByDividingUnitWithSelfAsNumerator(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<NumeratorAndDenominatorNumeratorQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) = dividedByDividingUnitWithSelfAsNumerator(right) {
        value: Decimal,
        unit: DenominatorDenominatorUnit,
    ->
    DefaultUndefinedScientificValue(value, unit)
}
