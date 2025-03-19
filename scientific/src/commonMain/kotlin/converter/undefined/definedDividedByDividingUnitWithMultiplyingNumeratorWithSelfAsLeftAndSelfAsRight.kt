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
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.asUndefined
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// A! / Div<Mul<Ex<A>, Ex<A>>, B> -> Div<B, Ex<A>>

@JvmName("definedDividedByDividingUnitWithMultiplyingNumeratorWithSelfAsLeftAndSelfAsRight")
fun <
    NumeratorAndDenominatorNumeratorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit : ScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
    ExtendedDenominatorNumeratorLeftAndRightUnit : UndefinedExtendedUnit<
        NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
        >,
    DenominatorNumeratorUnit : UndefinedMultipliedUnit<
        UndefinedQuantityType.Extended<
            NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
            >,
        ExtendedDenominatorNumeratorLeftAndRightUnit,
        UndefinedQuantityType.Extended<
            NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
            >,
        ExtendedDenominatorNumeratorLeftAndRightUnit,
        >,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
    DenominatorUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            >,
        DenominatorNumeratorUnit,
        DenominatorDenominatorQuantity,
        DenominatorDenominatorUnit,
        >,
    ExtendedNumeratorUnit : UndefinedExtendedUnit<
        NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
        >,
    TargetUnit : UndefinedDividedUnit<
        DenominatorDenominatorQuantity,
        DenominatorDenominatorUnit,
        UndefinedQuantityType.Extended<
            NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
            >,
        ExtendedNumeratorUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorDenominatorQuantity,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            >,
        TargetUnit,
        >,
    > ScientificValue<NumeratorAndDenominatorNumeratorLeftAndRightQuantity, NumeratorUnit>.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
    numeratorAsUndefined: NumeratorUnit.() -> ExtendedNumeratorUnit,
    denominatorDenominatorUnitPerExtendedNumeratorUnit: DenominatorDenominatorUnit.(ExtendedNumeratorUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.denominator.denominatorDenominatorUnitPerExtendedNumeratorUnit(
    unit.numeratorAsUndefined(),
).byDividing(this, right, factory)

@JvmName("metricAndImperialDefinedDividedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithSelfAsLeftAndSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorNumeratorLeftAndRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorLeftAndRightQuantity, NumeratorUnit>.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedDenominatorNumeratorLeftAndRightUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
            >,
        ExtendedDenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        ExtendedDenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedDenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            ExtendedDenominatorNumeratorLeftAndRightUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            ExtendedDenominatorNumeratorLeftAndRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorAsUndefined = { asUndefined() },
        denominatorDenominatorUnitPerExtendedNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedExtendedUnit.MetricAndImperial<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDefinedDividedByMetricDividingUnitWithMultiplyingNumeratorWithSelfAsLeftAndSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorNumeratorLeftAndRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorLeftAndRightQuantity, NumeratorUnit>.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        ExtendedDenominatorNumeratorLeftAndRightUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
            >,
        ExtendedDenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            ExtendedDenominatorNumeratorLeftAndRightUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            ExtendedDenominatorNumeratorLeftAndRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(
        right,
        numeratorAsUndefined = { asUndefined() },
        denominatorDenominatorUnitPerExtendedNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedExtendedUnit.Metric<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDefinedDividedByImperialDividingUnitWithMultiplyingNumeratorWithSelfAsLeftAndSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorNumeratorLeftAndRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorLeftAndRightQuantity, NumeratorUnit>.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedDenominatorNumeratorLeftAndRightUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
            >,
        ExtendedDenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedDenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            ExtendedDenominatorNumeratorLeftAndRightUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            ExtendedDenominatorNumeratorLeftAndRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorAsUndefined = { asUndefined() },
        denominatorDenominatorUnitPerExtendedNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedExtendedUnit.Imperial<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDefinedDividedByUKImperialDividingUnitWithMultiplyingNumeratorWithSelfAsLeftAndSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorNumeratorLeftAndRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorLeftAndRightQuantity, NumeratorUnit>.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedDenominatorNumeratorLeftAndRightUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
            >,
        ExtendedDenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            ExtendedDenominatorNumeratorLeftAndRightUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            ExtendedDenominatorNumeratorLeftAndRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorAsUndefined = { asUndefined() },
        denominatorDenominatorUnitPerExtendedNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedExtendedUnit.UKImperial<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDefinedDividedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithSelfAsLeftAndSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorNumeratorLeftAndRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorLeftAndRightQuantity, NumeratorUnit>.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedDenominatorNumeratorLeftAndRightUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
            >,
        ExtendedDenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            ExtendedDenominatorNumeratorLeftAndRightUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            ExtendedDenominatorNumeratorLeftAndRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorAsUndefined = { asUndefined() },
        denominatorDenominatorUnitPerExtendedNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedExtendedUnit.USCustomary<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDefinedDividedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithSelfAsLeftAndSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorNumeratorLeftAndRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorLeftAndRightQuantity, NumeratorUnit>.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedDenominatorNumeratorLeftAndRightUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
            >,
        ExtendedDenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        ExtendedDenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            ExtendedDenominatorNumeratorLeftAndRightUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            ExtendedDenominatorNumeratorLeftAndRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorAsUndefined = { asUndefined() },
        denominatorDenominatorUnitPerExtendedNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedExtendedUnit.MetricAndUKImperial<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDefinedDividedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithSelfAsLeftAndSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorNumeratorLeftAndRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorLeftAndRightQuantity, NumeratorUnit>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedDenominatorNumeratorLeftAndRightUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
            >,
        ExtendedDenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        ExtendedDenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            ExtendedDenominatorNumeratorLeftAndRightUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            ExtendedDenominatorNumeratorLeftAndRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorAsUndefined = { asUndefined() },
        denominatorDenominatorUnitPerExtendedNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                UndefinedExtendedUnit.MetricAndUSCustomary<
                    NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
