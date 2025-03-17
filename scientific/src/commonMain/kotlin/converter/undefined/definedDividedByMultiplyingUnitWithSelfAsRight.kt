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
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// A! / Mul<B, Wr<A>> -> Inv<B>

@JvmName("definedDividedByMultiplyingUnitWithSelfAsRight")
fun <
    NumeratorAndDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorAndDenominatorRightUnit : ScientificUnit<NumeratorAndDenominatorRightQuantity>,
    DenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorLeftUnit : UndefinedScientificUnit<DenominatorLeftQuantity>,
    WrappedNumeratorAndDenominatorRightUnit : WrappedUndefinedExtendedUnit<
        NumeratorAndDenominatorRightQuantity,
        NumeratorAndDenominatorRightUnit,
        >,
    DenominatorUnit : UndefinedMultipliedUnit<
        DenominatorLeftQuantity,
        DenominatorLeftUnit,
        UndefinedQuantityType.Extended<
            NumeratorAndDenominatorRightQuantity,
            >,
        WrappedNumeratorAndDenominatorRightUnit,
        >,
    TargetUnit : UndefinedReciprocalUnit<
        DenominatorLeftQuantity,
        DenominatorLeftUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            DenominatorLeftQuantity,
            >,
        TargetUnit,
        >,
    > ScientificValue<NumeratorAndDenominatorRightQuantity, NumeratorAndDenominatorRightUnit>.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            DenominatorLeftQuantity,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
    reciprocalTargetUnit: DenominatorLeftUnit.() -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.left.reciprocalTargetUnit().byDividing(this, right, factory)

@JvmName("metricAndImperialDefinedDividedByMetricAndImperialMultiplyingUnitWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorAndDenominatorRightUnit,
    DenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorLeftUnit,
    WrappedNumeratorAndDenominatorRightUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorRightQuantity, NumeratorAndDenominatorRightUnit>.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            DenominatorLeftQuantity,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorAndDenominatorRightUnit : AbstractScientificUnit<NumeratorAndDenominatorRightQuantity>,
        NumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftUnit : UndefinedScientificUnit<DenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorAndDenominatorRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorAndDenominatorRightQuantity,
            NumeratorAndDenominatorRightUnit,
            >,
        WrappedNumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            DenominatorLeftQuantity,
            DenominatorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorRightQuantity,
                >,
            WrappedNumeratorAndDenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndImperial<
                DenominatorLeftQuantity,
                DenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDefinedDividedByMetricMultiplyingUnitWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorAndDenominatorRightUnit,
    DenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorLeftUnit,
    WrappedNumeratorAndDenominatorRightUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorRightQuantity, NumeratorAndDenominatorRightUnit>.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            DenominatorLeftQuantity,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorAndDenominatorRightUnit : AbstractScientificUnit<NumeratorAndDenominatorRightQuantity>,
        NumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftUnit : UndefinedScientificUnit<DenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorAndDenominatorRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorAndDenominatorRightQuantity,
            NumeratorAndDenominatorRightUnit,
            >,
        WrappedNumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedMultipliedUnit<
            DenominatorLeftQuantity,
            DenominatorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorRightQuantity,
                >,
            WrappedNumeratorAndDenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Metric<
                DenominatorLeftQuantity,
                DenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDefinedDividedByImperialMultiplyingUnitWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorAndDenominatorRightUnit,
    DenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorLeftUnit,
    WrappedNumeratorAndDenominatorRightUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorRightQuantity, NumeratorAndDenominatorRightUnit>.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            DenominatorLeftQuantity,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorAndDenominatorRightUnit : AbstractScientificUnit<NumeratorAndDenominatorRightQuantity>,
        NumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftUnit : UndefinedScientificUnit<DenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorAndDenominatorRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorAndDenominatorRightQuantity,
            NumeratorAndDenominatorRightUnit,
            >,
        WrappedNumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            DenominatorLeftQuantity,
            DenominatorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorRightQuantity,
                >,
            WrappedNumeratorAndDenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Imperial<
                DenominatorLeftQuantity,
                DenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDefinedDividedByUKImperialMultiplyingUnitWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorAndDenominatorRightUnit,
    DenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorLeftUnit,
    WrappedNumeratorAndDenominatorRightUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorRightQuantity, NumeratorAndDenominatorRightUnit>.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            DenominatorLeftQuantity,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorAndDenominatorRightUnit : AbstractScientificUnit<NumeratorAndDenominatorRightQuantity>,
        NumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftUnit : UndefinedScientificUnit<DenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorAndDenominatorRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorAndDenominatorRightQuantity,
            NumeratorAndDenominatorRightUnit,
            >,
        WrappedNumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedMultipliedUnit<
            DenominatorLeftQuantity,
            DenominatorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorRightQuantity,
                >,
            WrappedNumeratorAndDenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.UKImperial<
                DenominatorLeftQuantity,
                DenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDefinedDividedByUSCustomaryMultiplyingUnitWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorAndDenominatorRightUnit,
    DenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorLeftUnit,
    WrappedNumeratorAndDenominatorRightUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorRightQuantity, NumeratorAndDenominatorRightUnit>.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            DenominatorLeftQuantity,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorAndDenominatorRightUnit : AbstractScientificUnit<NumeratorAndDenominatorRightQuantity>,
        NumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftUnit : UndefinedScientificUnit<DenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorAndDenominatorRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorAndDenominatorRightQuantity,
            NumeratorAndDenominatorRightUnit,
            >,
        WrappedNumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            DenominatorLeftQuantity,
            DenominatorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorRightQuantity,
                >,
            WrappedNumeratorAndDenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.USCustomary<
                DenominatorLeftQuantity,
                DenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDefinedDividedByMetricAndUKImperialMultiplyingUnitWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorAndDenominatorRightUnit,
    DenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorLeftUnit,
    WrappedNumeratorAndDenominatorRightUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorRightQuantity, NumeratorAndDenominatorRightUnit>.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            DenominatorLeftQuantity,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorAndDenominatorRightUnit : AbstractScientificUnit<NumeratorAndDenominatorRightQuantity>,
        NumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftUnit : UndefinedScientificUnit<DenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedNumeratorAndDenominatorRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorAndDenominatorRightQuantity,
            NumeratorAndDenominatorRightUnit,
            >,
        WrappedNumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedMultipliedUnit<
            DenominatorLeftQuantity,
            DenominatorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorRightQuantity,
                >,
            WrappedNumeratorAndDenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUKImperial<
                DenominatorLeftQuantity,
                DenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDefinedDividedByMetricAndUSCustomaryMultiplyingUnitWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorAndDenominatorRightUnit,
    DenominatorLeftQuantity : UndefinedQuantityType,
    DenominatorLeftUnit,
    WrappedNumeratorAndDenominatorRightUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorRightQuantity, NumeratorAndDenominatorRightUnit>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            DenominatorLeftQuantity,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorAndDenominatorRightUnit : AbstractScientificUnit<NumeratorAndDenominatorRightQuantity>,
        NumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftUnit : UndefinedScientificUnit<DenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedNumeratorAndDenominatorRightUnit : WrappedUndefinedExtendedUnit<
            NumeratorAndDenominatorRightQuantity,
            NumeratorAndDenominatorRightUnit,
            >,
        WrappedNumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        WrappedNumeratorAndDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            DenominatorLeftQuantity,
            DenominatorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorRightQuantity,
                >,
            WrappedNumeratorAndDenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
                DenominatorLeftQuantity,
                DenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
