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
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.DefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import kotlin.jvm.JvmName

// A! / Div<Ex<A>, B> -> B

@JvmName("definedDividedByDividingUnitWithSelfAsNumerator")
fun <
    NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit : ScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
    ExtendedDenominatorNumeratorUnit : UndefinedExtendedUnit<
        NumeratorAndDenominatorNumeratorQuantity,
        >,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
    DenominatorUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Extended<
            NumeratorAndDenominatorNumeratorQuantity,
            >,
        ExtendedDenominatorNumeratorUnit,
        DenominatorDenominatorQuantity,
        DenominatorDenominatorUnit,
        >,
    DenominatorDenominatorValue : UndefinedScientificValue<
        DenominatorDenominatorQuantity,
        DenominatorDenominatorUnit,
        >,
    > ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorUnit>.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
    factory: (Decimal, DenominatorDenominatorUnit) -> DenominatorDenominatorValue,
) = right.unit.denominator.byDividing(this, right, factory)

@JvmName("metricAndImperialDefinedDividedByMetricAndImperialDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorUnit>.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedDenominatorNumeratorUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorQuantity,
            >,
        ExtendedDenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        ExtendedDenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedDenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorQuantity,
                >,
            ExtendedDenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDefinedDividedByMetricDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorUnit>.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        ExtendedDenominatorNumeratorUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorQuantity,
            >,
        ExtendedDenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorQuantity,
                >,
            ExtendedDenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDefinedDividedByImperialDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorUnit>.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedDenominatorNumeratorUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorQuantity,
            >,
        ExtendedDenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedDenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorQuantity,
                >,
            ExtendedDenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDefinedDividedByUKImperialDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorUnit>.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedDenominatorNumeratorUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorQuantity,
            >,
        ExtendedDenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorQuantity,
                >,
            ExtendedDenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDefinedDividedByUSCustomaryDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorUnit>.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedDenominatorNumeratorUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorQuantity,
            >,
        ExtendedDenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorQuantity,
                >,
            ExtendedDenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDefinedDividedByMetricAndUKImperialDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorUnit>.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedDenominatorNumeratorUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorQuantity,
            >,
        ExtendedDenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        ExtendedDenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorQuantity,
                >,
            ExtendedDenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDefinedDividedByMetricAndUSCustomaryDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorUnit>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedDenominatorNumeratorUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorQuantity,
            >,
        ExtendedDenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        ExtendedDenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorQuantity,
                >,
            ExtendedDenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("genericDefinedDividedByGenericDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
    ExtendedDenominatorNumeratorUnit : UndefinedExtendedUnit<
        NumeratorAndDenominatorNumeratorQuantity,
        >,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
    DenominatorUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Extended<
            NumeratorAndDenominatorNumeratorQuantity,
            >,
        ExtendedDenominatorNumeratorUnit,
        DenominatorDenominatorQuantity,
        DenominatorDenominatorUnit,
        >,
    > ScientificValue<NumeratorAndDenominatorNumeratorQuantity, NumeratorUnit>.genericDividedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) = dividedBy(right) {
        value: Decimal,
        unit: DenominatorDenominatorUnit,
    ->
    DefaultUndefinedScientificValue(value, unit)
}
