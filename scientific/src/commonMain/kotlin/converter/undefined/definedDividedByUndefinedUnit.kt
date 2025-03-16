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
import com.splendo.kaluga.scientific.unit.asUndefined
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// A! / B -> Div<Wr<A>, B>

@JvmName("definedDividedByUndefinedUnit")
fun <
    NumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit : ScientificUnit<NumeratorQuantity>,
    DenominatorQuantity : UndefinedQuantityType,
    DenominatorUnit : UndefinedScientificUnit<DenominatorQuantity>,
    WrappedNumeratorUnit : WrappedUndefinedExtendedUnit<NumeratorQuantity, NumeratorUnit>,
    TargetUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<NumeratorQuantity>, WrappedNumeratorUnit, DenominatorQuantity, DenominatorUnit>,
    TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<NumeratorQuantity>, DenominatorQuantity>, TargetUnit>,
    > ScientificValue<NumeratorQuantity, NumeratorUnit>.dividedByUndefinedUnit(
    right: UndefinedScientificValue<DenominatorQuantity, DenominatorUnit>,
    numeratorAsUndefined: NumeratorUnit.() -> WrappedNumeratorUnit,
    wrappedNumeratorUnitPerDenominatorUnit: WrappedNumeratorUnit.(DenominatorUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numeratorAsUndefined().wrappedNumeratorUnitPerDenominatorUnit(right.unit).byDividing(this, right, factory)

@JvmName("metricAndImperialDefinedDividedByMetricAndImperialUndefinedUnit")
infix fun <
    NumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorQuantity : UndefinedQuantityType,
    DenominatorUnit,
    > ScientificValue<NumeratorQuantity, NumeratorUnit>.dividedByUndefinedUnit(
    right: UndefinedScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedScientificUnit<DenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByUndefinedUnit(
        right,
        numeratorAsUndefined = { asUndefined() },
        wrappedNumeratorUnitPerDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                UndefinedQuantityType.Extended<NumeratorQuantity>,
                WrappedUndefinedExtendedUnit.MetricAndImperial<NumeratorQuantity, NumeratorUnit>,
                DenominatorQuantity,
                DenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDefinedDividedByMetricUndefinedUnit")
infix fun <
    NumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorQuantity : UndefinedQuantityType,
    DenominatorUnit,
    > ScientificValue<NumeratorQuantity, NumeratorUnit>.dividedByUndefinedUnit(
    right: UndefinedScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedScientificUnit<DenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedByUndefinedUnit(
        right,
        numeratorAsUndefined = { asUndefined() },
        wrappedNumeratorUnitPerDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                UndefinedQuantityType.Extended<NumeratorQuantity>,
                WrappedUndefinedExtendedUnit.Metric<NumeratorQuantity, NumeratorUnit>,
                DenominatorQuantity,
                DenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDefinedDividedByImperialUndefinedUnit")
infix fun <
    NumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorQuantity : UndefinedQuantityType,
    DenominatorUnit,
    > ScientificValue<NumeratorQuantity, NumeratorUnit>.dividedByUndefinedUnit(
    right: UndefinedScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedScientificUnit<DenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByUndefinedUnit(
        right,
        numeratorAsUndefined = { asUndefined() },
        wrappedNumeratorUnitPerDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                UndefinedQuantityType.Extended<NumeratorQuantity>,
                WrappedUndefinedExtendedUnit.Imperial<NumeratorQuantity, NumeratorUnit>,
                DenominatorQuantity,
                DenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDefinedDividedByUKImperialUndefinedUnit")
infix fun <
    NumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorQuantity : UndefinedQuantityType,
    DenominatorUnit,
    > ScientificValue<NumeratorQuantity, NumeratorUnit>.dividedByUndefinedUnit(
    right: UndefinedScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedScientificUnit<DenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedByUndefinedUnit(
        right,
        numeratorAsUndefined = { asUndefined() },
        wrappedNumeratorUnitPerDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                UndefinedQuantityType.Extended<NumeratorQuantity>,
                WrappedUndefinedExtendedUnit.UKImperial<NumeratorQuantity, NumeratorUnit>,
                DenominatorQuantity,
                DenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDefinedDividedByUSCustomaryUndefinedUnit")
infix fun <
    NumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorQuantity : UndefinedQuantityType,
    DenominatorUnit,
    > ScientificValue<NumeratorQuantity, NumeratorUnit>.dividedByUndefinedUnit(
    right: UndefinedScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedScientificUnit<DenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByUndefinedUnit(
        right,
        numeratorAsUndefined = { asUndefined() },
        wrappedNumeratorUnitPerDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                UndefinedQuantityType.Extended<NumeratorQuantity>,
                WrappedUndefinedExtendedUnit.USCustomary<NumeratorQuantity, NumeratorUnit>,
                DenominatorQuantity,
                DenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDefinedDividedByMetricAndUKImperialUndefinedUnit")
infix fun <
    NumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorQuantity : UndefinedQuantityType,
    DenominatorUnit,
    > ScientificValue<NumeratorQuantity, NumeratorUnit>.dividedByUndefinedUnit(
    right: UndefinedScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedScientificUnit<DenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedByUndefinedUnit(
        right,
        numeratorAsUndefined = { asUndefined() },
        wrappedNumeratorUnitPerDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                UndefinedQuantityType.Extended<NumeratorQuantity>,
                WrappedUndefinedExtendedUnit.MetricAndUKImperial<NumeratorQuantity, NumeratorUnit>,
                DenominatorQuantity,
                DenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDefinedDividedByMetricAndUSCustomaryUndefinedUnit")
infix fun <
    NumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorQuantity : UndefinedQuantityType,
    DenominatorUnit,
    > ScientificValue<NumeratorQuantity, NumeratorUnit>.dividedByUndefinedUnit(
    right: UndefinedScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedScientificUnit<DenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByUndefinedUnit(
        right,
        numeratorAsUndefined = { asUndefined() },
        wrappedNumeratorUnitPerDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                UndefinedQuantityType.Extended<NumeratorQuantity>,
                WrappedUndefinedExtendedUnit.MetricAndUSCustomary<NumeratorQuantity, NumeratorUnit>,
                DenominatorQuantity,
                DenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
