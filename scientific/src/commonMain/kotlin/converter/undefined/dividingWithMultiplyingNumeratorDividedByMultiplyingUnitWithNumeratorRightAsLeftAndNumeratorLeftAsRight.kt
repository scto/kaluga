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
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// Div<Mul<A, B>, C> / Mul<B, A> -> Inv<C>

@JvmName("dividingWithMultiplyingNumeratorDividedByMultiplyingUnitWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
fun <
    NumeratorNumeratorLeftAndDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorRightQuantity>,
    NumeratorNumeratorRightAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorLeftQuantity>,
    NumeratorNumeratorUnit : UndefinedMultipliedUnit<
        NumeratorNumeratorLeftAndDenominatorRightQuantity,
        NumeratorNumeratorLeftUnit,
        NumeratorNumeratorRightAndDenominatorLeftQuantity,
        NumeratorNumeratorRightUnit,
        >,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
    NumeratorUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            >,
        NumeratorNumeratorUnit,
        NumeratorDenominatorQuantity,
        NumeratorDenominatorUnit,
        >,
    DenominatorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorLeftQuantity>,
    DenominatorRightUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorRightQuantity>,
    DenominatorUnit : UndefinedMultipliedUnit<
        NumeratorNumeratorRightAndDenominatorLeftQuantity,
        DenominatorLeftUnit,
        NumeratorNumeratorLeftAndDenominatorRightQuantity,
        DenominatorRightUnit,
        >,
    TargetUnit : UndefinedReciprocalUnit<
        NumeratorDenominatorQuantity,
        NumeratorDenominatorUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            NumeratorDenominatorQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            >,
        NumeratorDenominatorQuantity,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
    reciprocalTargetUnit: NumeratorDenominatorUnit.() -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.denominator.reciprocalTargetUnit().byDividing(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingNumeratorDividedByMetricAndImperialMultiplyingUnitWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
    NumeratorNumeratorLeftAndDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            >,
        NumeratorDenominatorQuantity,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorRightQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorLeftQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftAndDenominatorRightQuantity,
                NumeratorNumeratorRightAndDenominatorLeftQuantity,
                >,
            NumeratorNumeratorUnit,
            NumeratorDenominatorQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorRightUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
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
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDividingWithMultiplyingNumeratorDividedByMetricMultiplyingUnitWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
    NumeratorNumeratorLeftAndDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            >,
        NumeratorDenominatorQuantity,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorRightQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorLeftQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftAndDenominatorRightQuantity,
                NumeratorNumeratorRightAndDenominatorLeftQuantity,
                >,
            NumeratorNumeratorUnit,
            NumeratorDenominatorQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorRightUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            DenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Metric<
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDividingWithMultiplyingNumeratorDividedByImperialMultiplyingUnitWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
    NumeratorNumeratorLeftAndDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            >,
        NumeratorDenominatorQuantity,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorRightQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorLeftQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftAndDenominatorRightQuantity,
                NumeratorNumeratorRightAndDenominatorLeftQuantity,
                >,
            NumeratorNumeratorUnit,
            NumeratorDenominatorQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorRightUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
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
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDividingWithMultiplyingNumeratorDividedByUKImperialMultiplyingUnitWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
    NumeratorNumeratorLeftAndDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            >,
        NumeratorDenominatorQuantity,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorRightQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorLeftQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftAndDenominatorRightQuantity,
                NumeratorNumeratorRightAndDenominatorLeftQuantity,
                >,
            NumeratorNumeratorUnit,
            NumeratorDenominatorQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorRightUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            DenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.UKImperial<
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingWithMultiplyingNumeratorDividedByUSCustomaryMultiplyingUnitWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
    NumeratorNumeratorLeftAndDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            >,
        NumeratorDenominatorQuantity,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorRightQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorLeftQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftAndDenominatorRightQuantity,
                NumeratorNumeratorRightAndDenominatorLeftQuantity,
                >,
            NumeratorNumeratorUnit,
            NumeratorDenominatorQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorRightUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            DenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.USCustomary<
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividingWithMultiplyingNumeratorDividedByMetricAndUKImperialMultiplyingUnitWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
    NumeratorNumeratorLeftAndDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            >,
        NumeratorDenominatorQuantity,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorRightQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorLeftQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftAndDenominatorRightQuantity,
                NumeratorNumeratorRightAndDenominatorLeftQuantity,
                >,
            NumeratorNumeratorUnit,
            NumeratorDenominatorQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorRightUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
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
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDividingWithMultiplyingNumeratorDividedByMetricAndUSCustomaryMultiplyingUnitWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix fun <
    NumeratorNumeratorLeftAndDenominatorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            >,
        NumeratorDenominatorQuantity,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorRightQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorLeftQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftAndDenominatorRightQuantity,
                NumeratorNumeratorRightAndDenominatorLeftQuantity,
                >,
            NumeratorNumeratorUnit,
            NumeratorDenominatorQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorRightUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorRightAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
            NumeratorNumeratorLeftAndDenominatorRightQuantity,
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
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
