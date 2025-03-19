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
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// Div<Mul<A, B>, Mul<C, D>> / Div<B, C> -> Div<A, D>

@JvmName("dividingWithMultiplyingNumeratorAndMultiplyingDenominatorDividedByDividingUnitWithNumeratorRightAsNumeratorAndDenominatorLeftAsDenominator")
fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
    NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
    NumeratorNumeratorUnit : UndefinedMultipliedUnit<
        NumeratorNumeratorLeftQuantity,
        NumeratorNumeratorLeftUnit,
        NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
        NumeratorNumeratorRightUnit,
        >,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
    NumeratorDenominatorUnit : UndefinedMultipliedUnit<
        NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
        NumeratorDenominatorLeftUnit,
        NumeratorDenominatorRightQuantity,
        NumeratorDenominatorRightUnit,
        >,
    NumeratorUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftQuantity,
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            >,
        NumeratorNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            NumeratorDenominatorRightQuantity,
            >,
        NumeratorDenominatorUnit,
        >,
    DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
    DenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
    DenominatorUnit : UndefinedDividedUnit<
        NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
        DenominatorNumeratorUnit,
        NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
        DenominatorDenominatorUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        NumeratorNumeratorLeftQuantity,
        NumeratorNumeratorLeftUnit,
        NumeratorDenominatorRightQuantity,
        NumeratorDenominatorRightUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorNumeratorLeftQuantity,
            NumeratorDenominatorRightQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftQuantity,
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            NumeratorDenominatorRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
    numeratorNumeratorLeftUnitPerNumeratorDenominatorRightUnit: NumeratorNumeratorLeftUnit.(NumeratorDenominatorRightUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.left.numeratorNumeratorLeftUnitPerNumeratorDenominatorRightUnit(
    unit.denominator.right,
).byDividing(this, right, factory)

@JvmName(
    "metricAndImperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorDividedByMetricAndImperialDividingUnitWithNumeratorRightAsNumeratorAndDenominatorLeftAsDenominator",
)
infix fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftQuantity,
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            NumeratorDenominatorRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            NumeratorDenominatorLeftUnit,
            NumeratorDenominatorRightQuantity,
            NumeratorDenominatorRightUnit,
            >,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
                >,
            NumeratorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
                NumeratorDenominatorRightQuantity,
                >,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorNumeratorLeftUnitPerNumeratorDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                NumeratorDenominatorRightQuantity,
                NumeratorDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDividingWithMultiplyingNumeratorAndMultiplyingDenominatorDividedByMetricDividingUnitWithNumeratorRightAsNumeratorAndDenominatorLeftAsDenominator")
infix fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftQuantity,
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            NumeratorDenominatorRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            NumeratorDenominatorLeftUnit,
            NumeratorDenominatorRightQuantity,
            NumeratorDenominatorRightUnit,
            >,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
                >,
            NumeratorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
                NumeratorDenominatorRightQuantity,
                >,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(
        right,
        numeratorNumeratorLeftUnitPerNumeratorDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                NumeratorDenominatorRightQuantity,
                NumeratorDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorDividedByImperialDividingUnitWithNumeratorRightAsNumeratorAndDenominatorLeftAsDenominator")
infix fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftQuantity,
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            NumeratorDenominatorRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            NumeratorDenominatorLeftUnit,
            NumeratorDenominatorRightQuantity,
            NumeratorDenominatorRightUnit,
            >,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
                >,
            NumeratorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
                NumeratorDenominatorRightQuantity,
                >,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorNumeratorLeftUnitPerNumeratorDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                NumeratorDenominatorRightQuantity,
                NumeratorDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorDividedByUKImperialDividingUnitWithNumeratorRightAsNumeratorAndDenominatorLeftAsDenominator")
infix fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftQuantity,
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            NumeratorDenominatorRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            NumeratorDenominatorLeftUnit,
            NumeratorDenominatorRightQuantity,
            NumeratorDenominatorRightUnit,
            >,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
                >,
            NumeratorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
                NumeratorDenominatorRightQuantity,
                >,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorNumeratorLeftUnitPerNumeratorDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                NumeratorDenominatorRightQuantity,
                NumeratorDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingWithMultiplyingNumeratorAndMultiplyingDenominatorDividedByUSCustomaryDividingUnitWithNumeratorRightAsNumeratorAndDenominatorLeftAsDenominator")
infix fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftQuantity,
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            NumeratorDenominatorRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            NumeratorDenominatorLeftUnit,
            NumeratorDenominatorRightQuantity,
            NumeratorDenominatorRightUnit,
            >,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
                >,
            NumeratorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
                NumeratorDenominatorRightQuantity,
                >,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorNumeratorLeftUnitPerNumeratorDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                NumeratorDenominatorRightQuantity,
                NumeratorDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "metricAndUKImperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorDividedByMetricAndUKImperialDividingUnitWithNumeratorRightAsNumeratorAndDenominatorLeftAsDenominator",
)
infix fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftQuantity,
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            NumeratorDenominatorRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            NumeratorDenominatorLeftUnit,
            NumeratorDenominatorRightQuantity,
            NumeratorDenominatorRightUnit,
            >,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
                >,
            NumeratorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
                NumeratorDenominatorRightQuantity,
                >,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorNumeratorLeftUnitPerNumeratorDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                NumeratorDenominatorRightQuantity,
                NumeratorDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "metricAndUSCustomaryDividingWithMultiplyingNumeratorAndMultiplyingDenominatorDividedByMetricAndUSCustomaryDividingUnitWithNumeratorRightAsNumeratorAndDenominatorLeftAsDenominator",
)
infix fun <
    NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorLeftUnit,
    NumeratorDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorRightUnit,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftQuantity,
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            NumeratorDenominatorRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            NumeratorDenominatorLeftUnit,
            NumeratorDenominatorRightQuantity,
            NumeratorDenominatorRightUnit,
            >,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
                >,
            NumeratorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
                NumeratorDenominatorRightQuantity,
                >,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            NumeratorDenominatorLeftAndDenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorNumeratorLeftUnitPerNumeratorDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                NumeratorNumeratorLeftQuantity,
                NumeratorNumeratorLeftUnit,
                NumeratorDenominatorRightQuantity,
                NumeratorDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
