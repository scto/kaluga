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
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// A / Mul<A, B> -> Inv<B>

@JvmName("dividedByMultiplyingUnitWithSelfAsLeft")
fun <
    NumeratorAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorLeftUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
    DenominatorUnit : UndefinedMultipliedUnit<
        NumeratorAndDenominatorLeftQuantity,
        NumeratorAndDenominatorLeftUnit,
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
    > UndefinedScientificValue<
    NumeratorAndDenominatorLeftQuantity,
    NumeratorAndDenominatorLeftUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
    reciprocalTargetUnit: DenominatorRightUnit.() -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.right.reciprocalTargetUnit().byDividing(this, right, factory)

@JvmName("metricAndImperialDividedByMetricAndImperialMultiplyingUnitWithSelfAsLeft")
infix fun <
    NumeratorAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorLeftQuantity,
    NumeratorAndDenominatorLeftUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorAndDenominatorLeftUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorAndDenominatorLeftQuantity,
            NumeratorAndDenominatorLeftUnit,
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

@JvmName("metricDividedByMetricMultiplyingUnitWithSelfAsLeft")
infix fun <
    NumeratorAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorLeftQuantity,
    NumeratorAndDenominatorLeftUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorAndDenominatorLeftUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorAndDenominatorLeftQuantity,
            NumeratorAndDenominatorLeftUnit,
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

@JvmName("imperialDividedByImperialMultiplyingUnitWithSelfAsLeft")
infix fun <
    NumeratorAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorLeftQuantity,
    NumeratorAndDenominatorLeftUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorAndDenominatorLeftUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorAndDenominatorLeftQuantity,
            NumeratorAndDenominatorLeftUnit,
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

@JvmName("ukImperialDividedByUKImperialMultiplyingUnitWithSelfAsLeft")
infix fun <
    NumeratorAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorLeftQuantity,
    NumeratorAndDenominatorLeftUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorAndDenominatorLeftUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorAndDenominatorLeftQuantity,
            NumeratorAndDenominatorLeftUnit,
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

@JvmName("usCustomaryDividedByUSCustomaryMultiplyingUnitWithSelfAsLeft")
infix fun <
    NumeratorAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorLeftQuantity,
    NumeratorAndDenominatorLeftUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorAndDenominatorLeftUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorAndDenominatorLeftQuantity,
            NumeratorAndDenominatorLeftUnit,
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

@JvmName("metricAndUKImperialDividedByMetricAndUKImperialMultiplyingUnitWithSelfAsLeft")
infix fun <
    NumeratorAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorLeftQuantity,
    NumeratorAndDenominatorLeftUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorAndDenominatorLeftUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorAndDenominatorLeftQuantity,
            NumeratorAndDenominatorLeftUnit,
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

@JvmName("metricAndUSCustomaryDividedByMetricAndUSCustomaryMultiplyingUnitWithSelfAsLeft")
infix fun <
    NumeratorAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorLeftQuantity,
    NumeratorAndDenominatorLeftUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorAndDenominatorLeftUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorAndDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorAndDenominatorLeftQuantity,
            NumeratorAndDenominatorLeftUnit,
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
