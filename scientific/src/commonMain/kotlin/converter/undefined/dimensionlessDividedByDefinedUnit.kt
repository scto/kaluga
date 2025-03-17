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
import com.splendo.kaluga.scientific.unit.Dimensionless
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.asUndefined
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// One / A! -> Inv<Wr<A>>

@JvmName("dimensionlessDividedByDefinedUnit")
fun <
    NumeratorUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
    DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorUnit : ScientificUnit<DenominatorQuantity>,
    WrappedDenominatorUnit : WrappedUndefinedExtendedUnit<
        DenominatorQuantity,
        DenominatorUnit,
        >,
    TargetUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Extended<
            DenominatorQuantity,
            >,
        WrappedDenominatorUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Extended<
                DenominatorQuantity,
                >,
            >,
        TargetUnit,
        >,
    > ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.dividedByDefinedUnit(
    right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
    denominatorAsUndefined: DenominatorUnit.() -> WrappedDenominatorUnit,
    reciprocalTargetUnit: WrappedDenominatorUnit.() -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.denominatorAsUndefined().reciprocalTargetUnit().byDividing(this, right, factory)

@JvmName("metricAndImperialDimensionlessDividedByMetricAndImperialDefinedUnit")
infix fun <
    NumeratorUnit,
    DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorUnit,
    > ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.dividedByDefinedUnit(
    right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
        NumeratorUnit : Dimensionless,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : AbstractScientificUnit<DenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByDefinedUnit(
        right,
        denominatorAsUndefined = { asUndefined() },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndImperial<
                UndefinedQuantityType.Extended<
                    DenominatorQuantity,
                    >,
                WrappedUndefinedExtendedUnit.MetricAndImperial<
                    DenominatorQuantity,
                    DenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDimensionlessDividedByMetricDefinedUnit")
infix fun <
    NumeratorUnit,
    DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorUnit,
    > ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.dividedByDefinedUnit(
    right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
        NumeratorUnit : Dimensionless,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : AbstractScientificUnit<DenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedByDefinedUnit(
        right,
        denominatorAsUndefined = { asUndefined() },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Metric<
                UndefinedQuantityType.Extended<
                    DenominatorQuantity,
                    >,
                WrappedUndefinedExtendedUnit.Metric<
                    DenominatorQuantity,
                    DenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDimensionlessDividedByImperialDefinedUnit")
infix fun <
    NumeratorUnit,
    DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorUnit,
    > ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.dividedByDefinedUnit(
    right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
        NumeratorUnit : Dimensionless,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : AbstractScientificUnit<DenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByDefinedUnit(
        right,
        denominatorAsUndefined = { asUndefined() },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Imperial<
                UndefinedQuantityType.Extended<
                    DenominatorQuantity,
                    >,
                WrappedUndefinedExtendedUnit.Imperial<
                    DenominatorQuantity,
                    DenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDimensionlessDividedByUKImperialDefinedUnit")
infix fun <
    NumeratorUnit,
    DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorUnit,
    > ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.dividedByDefinedUnit(
    right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
        NumeratorUnit : Dimensionless,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : AbstractScientificUnit<DenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedByDefinedUnit(
        right,
        denominatorAsUndefined = { asUndefined() },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.UKImperial<
                UndefinedQuantityType.Extended<
                    DenominatorQuantity,
                    >,
                WrappedUndefinedExtendedUnit.UKImperial<
                    DenominatorQuantity,
                    DenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDimensionlessDividedByUSCustomaryDefinedUnit")
infix fun <
    NumeratorUnit,
    DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorUnit,
    > ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.dividedByDefinedUnit(
    right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
        NumeratorUnit : Dimensionless,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : AbstractScientificUnit<DenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByDefinedUnit(
        right,
        denominatorAsUndefined = { asUndefined() },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.USCustomary<
                UndefinedQuantityType.Extended<
                    DenominatorQuantity,
                    >,
                WrappedUndefinedExtendedUnit.USCustomary<
                    DenominatorQuantity,
                    DenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDimensionlessDividedByMetricAndUKImperialDefinedUnit")
infix fun <
    NumeratorUnit,
    DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorUnit,
    > ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.dividedByDefinedUnit(
    right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
        NumeratorUnit : Dimensionless,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : AbstractScientificUnit<DenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedByDefinedUnit(
        right,
        denominatorAsUndefined = { asUndefined() },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUKImperial<
                UndefinedQuantityType.Extended<
                    DenominatorQuantity,
                    >,
                WrappedUndefinedExtendedUnit.MetricAndUKImperial<
                    DenominatorQuantity,
                    DenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDimensionlessDividedByMetricAndUSCustomaryDefinedUnit")
infix fun <
    NumeratorUnit,
    DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    DenominatorUnit,
    > ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.dividedByDefinedUnit(
    right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
        NumeratorUnit : Dimensionless,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : AbstractScientificUnit<DenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByDefinedUnit(
        right,
        denominatorAsUndefined = { asUndefined() },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
                UndefinedQuantityType.Extended<
                    DenominatorQuantity,
                    >,
                WrappedUndefinedExtendedUnit.MetricAndUSCustomary<
                    DenominatorQuantity,
                    DenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
