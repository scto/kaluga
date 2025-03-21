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
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// Inv<Mul<A, B>> / Div<C, Mul<B, A>> -> Inv<C>

@JvmName("reciprocalMultiplyingDividedByDividingUnitWithSelfFlippedAsDenominator")
fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
    NumeratorReciprocalUnit : UndefinedMultipliedUnit<
        NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
        NumeratorReciprocalLeftUnit,
        NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
        NumeratorReciprocalRightUnit,
        >,
    NumeratorUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            >,
        NumeratorReciprocalUnit,
        >,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
    DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
    DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
    DenominatorDenominatorUnit : UndefinedMultipliedUnit<
        NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
        DenominatorDenominatorLeftUnit,
        NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
        DenominatorDenominatorRightUnit,
        >,
    DenominatorUnit : UndefinedDividedUnit<
        DenominatorNumeratorQuantity,
        DenominatorNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            >,
        DenominatorDenominatorUnit,
        >,
    TargetUnit : UndefinedReciprocalUnit<
        DenominatorNumeratorQuantity,
        DenominatorNumeratorUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            DenominatorNumeratorQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            >,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
    reciprocalTargetUnit: DenominatorNumeratorUnit.() -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.numerator.reciprocalTargetUnit().byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalMultiplyingDividedByMetricAndImperialDividingUnitWithSelfFlippedAsDenominator")
infix fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftUnit,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            NumeratorReciprocalLeftUnit,
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalRightUnit,
            >,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                >,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            DenominatorDenominatorLeftUnit,
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            DenominatorDenominatorRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                >,
            DenominatorDenominatorUnit,
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
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricReciprocalMultiplyingDividedByMetricDividingUnitWithSelfFlippedAsDenominator")
infix fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftUnit,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            NumeratorReciprocalLeftUnit,
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalRightUnit,
            >,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                >,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            DenominatorDenominatorLeftUnit,
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            DenominatorDenominatorRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                >,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Metric<
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialReciprocalMultiplyingDividedByImperialDividingUnitWithSelfFlippedAsDenominator")
infix fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftUnit,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            >,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            NumeratorReciprocalLeftUnit,
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalRightUnit,
            >,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                >,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            DenominatorDenominatorLeftUnit,
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            DenominatorDenominatorRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                >,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Imperial<
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialReciprocalMultiplyingDividedByUKImperialDividingUnitWithSelfFlippedAsDenominator")
infix fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftUnit,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            >,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            NumeratorReciprocalLeftUnit,
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalRightUnit,
            >,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                >,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            DenominatorDenominatorLeftUnit,
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            DenominatorDenominatorRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                >,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.UKImperial<
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryReciprocalMultiplyingDividedByUSCustomaryDividingUnitWithSelfFlippedAsDenominator")
infix fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftUnit,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            >,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            NumeratorReciprocalLeftUnit,
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalRightUnit,
            >,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                >,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            DenominatorDenominatorLeftUnit,
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            DenominatorDenominatorRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                >,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.USCustomary<
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialReciprocalMultiplyingDividedByMetricAndUKImperialDividingUnitWithSelfFlippedAsDenominator")
infix fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftUnit,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            NumeratorReciprocalLeftUnit,
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalRightUnit,
            >,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                >,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            DenominatorDenominatorLeftUnit,
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            DenominatorDenominatorRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                >,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUKImperial<
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryReciprocalMultiplyingDividedByMetricAndUSCustomaryDividingUnitWithSelfFlippedAsDenominator")
infix fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftUnit,
    NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftUnit,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            NumeratorReciprocalLeftUnit,
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalRightUnit,
            >,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                >,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
            DenominatorDenominatorLeftUnit,
            NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
            DenominatorDenominatorRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity,
                NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity,
                >,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
