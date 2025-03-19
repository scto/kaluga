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
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// A! / Div<Mul<B, Ex<A>>, C> -> Div<C, B>

@JvmName("definedDividedByDividingUnitWithMultiplyingNumeratorWithSelfAsRight")
fun <
    NumeratorAndDenominatorNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit : ScientificUnit<NumeratorAndDenominatorNumeratorRightQuantity>,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
    ExtendedDenominatorNumeratorRightUnit : UndefinedExtendedUnit<
        NumeratorAndDenominatorNumeratorRightQuantity,
        >,
    DenominatorNumeratorUnit : UndefinedMultipliedUnit<
        DenominatorNumeratorLeftQuantity,
        DenominatorNumeratorLeftUnit,
        UndefinedQuantityType.Extended<
            NumeratorAndDenominatorNumeratorRightQuantity,
            >,
        ExtendedDenominatorNumeratorRightUnit,
        >,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
    DenominatorUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            DenominatorNumeratorLeftQuantity,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorRightQuantity,
                >,
            >,
        DenominatorNumeratorUnit,
        DenominatorDenominatorQuantity,
        DenominatorDenominatorUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        DenominatorDenominatorQuantity,
        DenominatorDenominatorUnit,
        DenominatorNumeratorLeftQuantity,
        DenominatorNumeratorLeftUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorDenominatorQuantity,
            DenominatorNumeratorLeftQuantity,
            >,
        TargetUnit,
        >,
    > ScientificValue<NumeratorAndDenominatorNumeratorRightQuantity, NumeratorUnit>.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                DenominatorNumeratorLeftQuantity,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorRightQuantity,
                    >,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
    denominatorDenominatorUnitPerDenominatorNumeratorLeftUnit: DenominatorDenominatorUnit.(DenominatorNumeratorLeftUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.denominator.denominatorDenominatorUnitPerDenominatorNumeratorLeftUnit(
    right.unit.numerator.left,
).byDividing(this, right, factory)

@JvmName("metricAndImperialDefinedDividedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    ExtendedDenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorRightQuantity, NumeratorUnit>.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                DenominatorNumeratorLeftQuantity,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorRightQuantity,
                    >,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorRightQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedDenominatorNumeratorRightUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorRightQuantity,
            >,
        ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            DenominatorNumeratorLeftQuantity,
            DenominatorNumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorRightQuantity,
                >,
            ExtendedDenominatorNumeratorRightUnit,
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
                DenominatorNumeratorLeftQuantity,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorRightQuantity,
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
        denominatorDenominatorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDefinedDividedByMetricDividingUnitWithMultiplyingNumeratorWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    ExtendedDenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorRightQuantity, NumeratorUnit>.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                DenominatorNumeratorLeftQuantity,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorRightQuantity,
                    >,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorRightQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        ExtendedDenominatorNumeratorRightUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorRightQuantity,
            >,
        ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            DenominatorNumeratorLeftQuantity,
            DenominatorNumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorRightQuantity,
                >,
            ExtendedDenominatorNumeratorRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                DenominatorNumeratorLeftQuantity,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorRightQuantity,
                    >,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(
        right,
        denominatorDenominatorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDefinedDividedByImperialDividingUnitWithMultiplyingNumeratorWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    ExtendedDenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorRightQuantity, NumeratorUnit>.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                DenominatorNumeratorLeftQuantity,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorRightQuantity,
                    >,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorRightQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedDenominatorNumeratorRightUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorRightQuantity,
            >,
        ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            DenominatorNumeratorLeftQuantity,
            DenominatorNumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorRightQuantity,
                >,
            ExtendedDenominatorNumeratorRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                DenominatorNumeratorLeftQuantity,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorRightQuantity,
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
        denominatorDenominatorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDefinedDividedByUKImperialDividingUnitWithMultiplyingNumeratorWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    ExtendedDenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorRightQuantity, NumeratorUnit>.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                DenominatorNumeratorLeftQuantity,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorRightQuantity,
                    >,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorRightQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedDenominatorNumeratorRightUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorRightQuantity,
            >,
        ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            DenominatorNumeratorLeftQuantity,
            DenominatorNumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorRightQuantity,
                >,
            ExtendedDenominatorNumeratorRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                DenominatorNumeratorLeftQuantity,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorRightQuantity,
                    >,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        denominatorDenominatorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDefinedDividedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    ExtendedDenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorRightQuantity, NumeratorUnit>.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                DenominatorNumeratorLeftQuantity,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorRightQuantity,
                    >,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorRightQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedDenominatorNumeratorRightUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorRightQuantity,
            >,
        ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            DenominatorNumeratorLeftQuantity,
            DenominatorNumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorRightQuantity,
                >,
            ExtendedDenominatorNumeratorRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                DenominatorNumeratorLeftQuantity,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorRightQuantity,
                    >,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        denominatorDenominatorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDefinedDividedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    ExtendedDenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorRightQuantity, NumeratorUnit>.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                DenominatorNumeratorLeftQuantity,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorRightQuantity,
                    >,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorRightQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedDenominatorNumeratorRightUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorRightQuantity,
            >,
        ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            DenominatorNumeratorLeftQuantity,
            DenominatorNumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorRightQuantity,
                >,
            ExtendedDenominatorNumeratorRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                DenominatorNumeratorLeftQuantity,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorRightQuantity,
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
        denominatorDenominatorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDefinedDividedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    ExtendedDenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorNumeratorRightQuantity, NumeratorUnit>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                DenominatorNumeratorLeftQuantity,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorRightQuantity,
                    >,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorNumeratorRightQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedDenominatorNumeratorRightUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorNumeratorRightQuantity,
            >,
        ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        ExtendedDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            DenominatorNumeratorLeftQuantity,
            DenominatorNumeratorLeftUnit,
            UndefinedQuantityType.Extended<
                NumeratorAndDenominatorNumeratorRightQuantity,
                >,
            ExtendedDenominatorNumeratorRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                DenominatorNumeratorLeftQuantity,
                UndefinedQuantityType.Extended<
                    NumeratorAndDenominatorNumeratorRightQuantity,
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
        denominatorDenominatorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
