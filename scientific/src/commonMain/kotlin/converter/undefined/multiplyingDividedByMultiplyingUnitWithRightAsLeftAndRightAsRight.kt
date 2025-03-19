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

// Mul<A, B> / Mul<B, B> -> Div<A, B>

@JvmName("multiplyingDividedByMultiplyingUnitWithRightAsLeftAndRightAsRight")
fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
    NumeratorRightAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorLeftAndRightQuantity>,
    NumeratorUnit : UndefinedMultipliedUnit<
        NumeratorLeftQuantity,
        NumeratorLeftUnit,
        NumeratorRightAndDenominatorLeftAndRightQuantity,
        NumeratorRightUnit,
        >,
    DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorLeftAndRightQuantity>,
    DenominatorUnit : UndefinedMultipliedUnit<
        NumeratorRightAndDenominatorLeftAndRightQuantity,
        DenominatorLeftAndRightUnit,
        NumeratorRightAndDenominatorLeftAndRightQuantity,
        DenominatorLeftAndRightUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        NumeratorLeftQuantity,
        NumeratorLeftUnit,
        NumeratorRightAndDenominatorLeftAndRightQuantity,
        NumeratorRightUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorLeftQuantity,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
    numeratorLeftUnitPerNumeratorRightUnit: NumeratorLeftUnit.(NumeratorRightUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.left.numeratorLeftUnitPerNumeratorRightUnit(
    unit.right,
).byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingDividedByMetricAndImperialMultiplyingUnitWithRightAsLeftAndRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorLeftAndRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorLeftUnitPerNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                NumeratorLeftQuantity,
                NumeratorLeftUnit,
                NumeratorRightAndDenominatorLeftAndRightQuantity,
                NumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricMultiplyingDividedByMetricMultiplyingUnitWithRightAsLeftAndRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorLeftAndRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(
        right,
        numeratorLeftUnitPerNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                NumeratorLeftQuantity,
                NumeratorLeftUnit,
                NumeratorRightAndDenominatorLeftAndRightQuantity,
                NumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialMultiplyingDividedByImperialMultiplyingUnitWithRightAsLeftAndRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorLeftAndRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorLeftUnitPerNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                NumeratorLeftQuantity,
                NumeratorLeftUnit,
                NumeratorRightAndDenominatorLeftAndRightQuantity,
                NumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialMultiplyingDividedByUKImperialMultiplyingUnitWithRightAsLeftAndRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorLeftAndRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorLeftUnitPerNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                NumeratorLeftQuantity,
                NumeratorLeftUnit,
                NumeratorRightAndDenominatorLeftAndRightQuantity,
                NumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryMultiplyingDividedByUSCustomaryMultiplyingUnitWithRightAsLeftAndRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorLeftAndRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorLeftUnitPerNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                NumeratorLeftQuantity,
                NumeratorLeftUnit,
                NumeratorRightAndDenominatorLeftAndRightQuantity,
                NumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultiplyingDividedByMetricAndUKImperialMultiplyingUnitWithRightAsLeftAndRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorLeftAndRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorLeftUnitPerNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                NumeratorLeftQuantity,
                NumeratorLeftUnit,
                NumeratorRightAndDenominatorLeftAndRightQuantity,
                NumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultiplyingDividedByMetricAndUSCustomaryMultiplyingUnitWithRightAsLeftAndRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorLeftAndRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorLeftUnitPerNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                NumeratorLeftQuantity,
                NumeratorLeftUnit,
                NumeratorRightAndDenominatorLeftAndRightQuantity,
                NumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
