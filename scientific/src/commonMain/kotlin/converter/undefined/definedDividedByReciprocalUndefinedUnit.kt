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
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.asUndefined
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// A! / Inv<B> -> Mul<Wr<A>, B>

@JvmName("definedDividedByReciprocalUndefinedUnit")
fun <
    NumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit : ScientificUnit<NumeratorQuantity>,
    DenominatorReciprocalQuantity : UndefinedQuantityType,
    DenominatorReciprocalUnit : UndefinedScientificUnit<DenominatorReciprocalQuantity>,
    DenominatorUnit : UndefinedReciprocalUnit<
        DenominatorReciprocalQuantity,
        DenominatorReciprocalUnit,
        >,
    WrappedNumeratorUnit : WrappedUndefinedExtendedUnit<
        NumeratorQuantity,
        NumeratorUnit,
        >,
    TargetUnit : UndefinedMultipliedUnit<
        UndefinedQuantityType.Extended<
            NumeratorQuantity,
            >,
        WrappedNumeratorUnit,
        DenominatorReciprocalQuantity,
        DenominatorReciprocalUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                NumeratorQuantity,
                >,
            DenominatorReciprocalQuantity,
            >,
        TargetUnit,
        >,
    > ScientificValue<NumeratorQuantity, NumeratorUnit>.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            DenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
    numeratorAsUndefined: NumeratorUnit.() -> WrappedNumeratorUnit,
    wrappedNumeratorUnitXDenominatorReciprocalUnit: WrappedNumeratorUnit.(DenominatorReciprocalUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numeratorAsUndefined().wrappedNumeratorUnitXDenominatorReciprocalUnit(
    right.unit.inverse,
).byDividing(this, right, factory)

@JvmName("metricAndImperialDefinedDividedByMetricAndImperialReciprocalUndefinedUnit")
infix fun <
    NumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorReciprocalQuantity : UndefinedQuantityType,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorQuantity, NumeratorUnit>.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            DenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedScientificUnit<DenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            DenominatorReciprocalQuantity,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorAsUndefined = { asUndefined() },
        wrappedNumeratorUnitXDenominatorReciprocalUnit = { x(it) },
    ) {
            value: Decimal,
            unit: UndefinedMultipliedUnit.MetricAndImperial<
                UndefinedQuantityType.Extended<
                    NumeratorQuantity,
                    >,
                WrappedUndefinedExtendedUnit.MetricAndImperial<
                    NumeratorQuantity,
                    NumeratorUnit,
                    >,
                DenominatorReciprocalQuantity,
                DenominatorReciprocalUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDefinedDividedByMetricReciprocalUndefinedUnit")
infix fun <
    NumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorReciprocalQuantity : UndefinedQuantityType,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorQuantity, NumeratorUnit>.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            DenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : UndefinedScientificUnit<DenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedReciprocalUnit<
            DenominatorReciprocalQuantity,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(
        right,
        numeratorAsUndefined = { asUndefined() },
        wrappedNumeratorUnitXDenominatorReciprocalUnit = { x(it) },
    ) {
            value: Decimal,
            unit: UndefinedMultipliedUnit.Metric<
                UndefinedQuantityType.Extended<
                    NumeratorQuantity,
                    >,
                WrappedUndefinedExtendedUnit.Metric<
                    NumeratorQuantity,
                    NumeratorUnit,
                    >,
                DenominatorReciprocalQuantity,
                DenominatorReciprocalUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDefinedDividedByImperialReciprocalUndefinedUnit")
infix fun <
    NumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorReciprocalQuantity : UndefinedQuantityType,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorQuantity, NumeratorUnit>.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            DenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedScientificUnit<DenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            DenominatorReciprocalQuantity,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorAsUndefined = { asUndefined() },
        wrappedNumeratorUnitXDenominatorReciprocalUnit = { x(it) },
    ) {
            value: Decimal,
            unit: UndefinedMultipliedUnit.Imperial<
                UndefinedQuantityType.Extended<
                    NumeratorQuantity,
                    >,
                WrappedUndefinedExtendedUnit.Imperial<
                    NumeratorQuantity,
                    NumeratorUnit,
                    >,
                DenominatorReciprocalQuantity,
                DenominatorReciprocalUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDefinedDividedByUKImperialReciprocalUndefinedUnit")
infix fun <
    NumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorReciprocalQuantity : UndefinedQuantityType,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorQuantity, NumeratorUnit>.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            DenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : UndefinedScientificUnit<DenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedReciprocalUnit<
            DenominatorReciprocalQuantity,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorAsUndefined = { asUndefined() },
        wrappedNumeratorUnitXDenominatorReciprocalUnit = { x(it) },
    ) {
            value: Decimal,
            unit: UndefinedMultipliedUnit.UKImperial<
                UndefinedQuantityType.Extended<
                    NumeratorQuantity,
                    >,
                WrappedUndefinedExtendedUnit.UKImperial<
                    NumeratorQuantity,
                    NumeratorUnit,
                    >,
                DenominatorReciprocalQuantity,
                DenominatorReciprocalUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDefinedDividedByUSCustomaryReciprocalUndefinedUnit")
infix fun <
    NumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorReciprocalQuantity : UndefinedQuantityType,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorQuantity, NumeratorUnit>.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            DenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedScientificUnit<DenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            DenominatorReciprocalQuantity,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorAsUndefined = { asUndefined() },
        wrappedNumeratorUnitXDenominatorReciprocalUnit = { x(it) },
    ) {
            value: Decimal,
            unit: UndefinedMultipliedUnit.USCustomary<
                UndefinedQuantityType.Extended<
                    NumeratorQuantity,
                    >,
                WrappedUndefinedExtendedUnit.USCustomary<
                    NumeratorQuantity,
                    NumeratorUnit,
                    >,
                DenominatorReciprocalQuantity,
                DenominatorReciprocalUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDefinedDividedByMetricAndUKImperialReciprocalUndefinedUnit")
infix fun <
    NumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorReciprocalQuantity : UndefinedQuantityType,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorQuantity, NumeratorUnit>.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            DenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : UndefinedScientificUnit<DenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedReciprocalUnit<
            DenominatorReciprocalQuantity,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorAsUndefined = { asUndefined() },
        wrappedNumeratorUnitXDenominatorReciprocalUnit = { x(it) },
    ) {
            value: Decimal,
            unit: UndefinedMultipliedUnit.MetricAndUKImperial<
                UndefinedQuantityType.Extended<
                    NumeratorQuantity,
                    >,
                WrappedUndefinedExtendedUnit.MetricAndUKImperial<
                    NumeratorQuantity,
                    NumeratorUnit,
                    >,
                DenominatorReciprocalQuantity,
                DenominatorReciprocalUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDefinedDividedByMetricAndUSCustomaryReciprocalUndefinedUnit")
infix fun <
    NumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorReciprocalQuantity : UndefinedQuantityType,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorQuantity, NumeratorUnit>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            DenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedScientificUnit<DenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            DenominatorReciprocalQuantity,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorAsUndefined = { asUndefined() },
        wrappedNumeratorUnitXDenominatorReciprocalUnit = { x(it) },
    ) {
            value: Decimal,
            unit: UndefinedMultipliedUnit.MetricAndUSCustomary<
                UndefinedQuantityType.Extended<
                    NumeratorQuantity,
                    >,
                WrappedUndefinedExtendedUnit.MetricAndUSCustomary<
                    NumeratorQuantity,
                    NumeratorUnit,
                    >,
                DenominatorReciprocalQuantity,
                DenominatorReciprocalUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
