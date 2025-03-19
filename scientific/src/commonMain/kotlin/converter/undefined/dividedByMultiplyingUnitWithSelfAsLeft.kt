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
    NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
    DenominatorLeftUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
    DenominatorUnit : UndefinedMultipliedUnit<
        NumeratorAndDenominatorLeftQuantity,
        DenominatorLeftUnit,
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
    NumeratorUnit,
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
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorLeftQuantity,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
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
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorLeftQuantity,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
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
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorLeftQuantity,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
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
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorLeftQuantity,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
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
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorLeftQuantity,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
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
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorLeftQuantity,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
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
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorLeftQuantity,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
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
