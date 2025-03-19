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
import com.splendo.kaluga.scientific.unit.UndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// A! / Mul<Ex<A>, B> -> Inv<B>

@JvmName("definedDividedByMultiplyingUnitWithSelfAsLeft")
fun <
    NumeratorAndDenominatorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit : ScientificUnit<NumeratorAndDenominatorLeftQuantity>,
    ExtendedDenominatorLeftUnit : UndefinedExtendedUnit<
        NumeratorAndDenominatorLeftQuantity,
        >,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
    DenominatorUnit : UndefinedMultipliedUnit<
        UndefinedQuantityType.Extended<
            NumeratorAndDenominatorLeftQuantity,
            >,
        ExtendedDenominatorLeftUnit,
        DenominatorRightQuantity,
        DenominatorRightUnit,
        >,
    TargetUnit : UndefinedReciprocalUnit<
        DenominatorRightQuantity,
        DenominatorRightUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            DenominatorRightQuantity,
            >,
        TargetUnit,
        >,
    > ScientificValue<NumeratorAndDenominatorLeftQuantity, NumeratorUnit>.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorLeftQuantity,
                >,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
    reciprocalTargetUnit: DenominatorRightUnit.() -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.right.reciprocalTargetUnit().byDividing(this, right, factory)

@JvmName("metricAndImperialDefinedDividedByMetricAndImperialMultiplyingUnitWithSelfAsLeft")
infix fun <
    NumeratorAndDenominatorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorLeftQuantity, NumeratorUnit>.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorLeftQuantity,
                >,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedDenominatorLeftUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorLeftQuantity,
            >,
        ExtendedDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        ExtendedDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorLeftQuantity,
                >,
            ExtendedDenominatorLeftUnit,
            DenominatorRightQuantity,
            DenominatorRightUnit,
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
                DenominatorRightQuantity,
                DenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDefinedDividedByMetricMultiplyingUnitWithSelfAsLeft")
infix fun <
    NumeratorAndDenominatorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorLeftQuantity, NumeratorUnit>.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorLeftQuantity,
                >,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        ExtendedDenominatorLeftUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorLeftQuantity,
            >,
        ExtendedDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorLeftQuantity,
                >,
            ExtendedDenominatorLeftUnit,
            DenominatorRightQuantity,
            DenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Metric<
                DenominatorRightQuantity,
                DenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDefinedDividedByImperialMultiplyingUnitWithSelfAsLeft")
infix fun <
    NumeratorAndDenominatorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorLeftQuantity, NumeratorUnit>.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorLeftQuantity,
                >,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedDenominatorLeftUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorLeftQuantity,
            >,
        ExtendedDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorLeftQuantity,
                >,
            ExtendedDenominatorLeftUnit,
            DenominatorRightQuantity,
            DenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Imperial<
                DenominatorRightQuantity,
                DenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDefinedDividedByUKImperialMultiplyingUnitWithSelfAsLeft")
infix fun <
    NumeratorAndDenominatorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorLeftQuantity, NumeratorUnit>.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorLeftQuantity,
                >,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedDenominatorLeftUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorLeftQuantity,
            >,
        ExtendedDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorLeftQuantity,
                >,
            ExtendedDenominatorLeftUnit,
            DenominatorRightQuantity,
            DenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.UKImperial<
                DenominatorRightQuantity,
                DenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDefinedDividedByUSCustomaryMultiplyingUnitWithSelfAsLeft")
infix fun <
    NumeratorAndDenominatorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorLeftQuantity, NumeratorUnit>.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorLeftQuantity,
                >,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedDenominatorLeftUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorLeftQuantity,
            >,
        ExtendedDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorLeftQuantity,
                >,
            ExtendedDenominatorLeftUnit,
            DenominatorRightQuantity,
            DenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.USCustomary<
                DenominatorRightQuantity,
                DenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDefinedDividedByMetricAndUKImperialMultiplyingUnitWithSelfAsLeft")
infix fun <
    NumeratorAndDenominatorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorLeftQuantity, NumeratorUnit>.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorLeftQuantity,
                >,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedDenominatorLeftUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorLeftQuantity,
            >,
        ExtendedDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        ExtendedDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorLeftQuantity,
                >,
            ExtendedDenominatorLeftUnit,
            DenominatorRightQuantity,
            DenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUKImperial<
                DenominatorRightQuantity,
                DenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDefinedDividedByMetricAndUSCustomaryMultiplyingUnitWithSelfAsLeft")
infix fun <
    NumeratorAndDenominatorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorLeftQuantity, NumeratorUnit>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorLeftQuantity,
                >,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedDenominatorLeftUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorLeftQuantity,
            >,
        ExtendedDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        ExtendedDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorLeftQuantity,
                >,
            ExtendedDenominatorLeftUnit,
            DenominatorRightQuantity,
            DenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
                DenominatorRightQuantity,
                DenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
