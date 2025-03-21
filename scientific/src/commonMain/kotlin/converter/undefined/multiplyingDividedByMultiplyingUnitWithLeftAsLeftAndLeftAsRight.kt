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
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// Mul<A, B> / Mul<A, A> -> Div<B, A>

@JvmName("multiplyingDividedByMultiplyingUnitWithLeftAsLeftAndLeftAsRight")
fun <
    NumeratorLeftAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftAndRightQuantity>,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightQuantity>,
    NumeratorUnit : UndefinedMultipliedUnit<
        NumeratorLeftAndDenominatorLeftAndRightQuantity,
        NumeratorLeftUnit,
        NumeratorRightQuantity,
        NumeratorRightUnit,
        >,
    DenominatorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftAndRightQuantity>,
    DenominatorUnit : UndefinedMultipliedUnit<
        NumeratorLeftAndDenominatorLeftAndRightQuantity,
        DenominatorLeftAndRightUnit,
        NumeratorLeftAndDenominatorLeftAndRightQuantity,
        DenominatorLeftAndRightUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        NumeratorRightQuantity,
        NumeratorRightUnit,
        NumeratorLeftAndDenominatorLeftAndRightQuantity,
        NumeratorLeftUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorRightQuantity,
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorLeftAndRightQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
    numeratorRightUnitPerNumeratorLeftUnit: NumeratorRightUnit.(NumeratorLeftUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.right.numeratorRightUnitPerNumeratorLeftUnit(
    unit.left,
).byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingDividedByMetricAndImperialMultiplyingUnitWithLeftAsLeftAndLeftAsRight")
infix fun <
    NumeratorLeftAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorLeftAndRightQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftAndRightQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorRightUnitPerNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                NumeratorRightQuantity,
                NumeratorRightUnit,
                NumeratorLeftAndDenominatorLeftAndRightQuantity,
                NumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricMultiplyingDividedByMetricMultiplyingUnitWithLeftAsLeftAndLeftAsRight")
infix fun <
    NumeratorLeftAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorLeftAndRightQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftAndRightQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(
        right,
        numeratorRightUnitPerNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                NumeratorRightQuantity,
                NumeratorRightUnit,
                NumeratorLeftAndDenominatorLeftAndRightQuantity,
                NumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialMultiplyingDividedByImperialMultiplyingUnitWithLeftAsLeftAndLeftAsRight")
infix fun <
    NumeratorLeftAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorLeftAndRightQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftAndRightQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorRightUnitPerNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                NumeratorRightQuantity,
                NumeratorRightUnit,
                NumeratorLeftAndDenominatorLeftAndRightQuantity,
                NumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialMultiplyingDividedByUKImperialMultiplyingUnitWithLeftAsLeftAndLeftAsRight")
infix fun <
    NumeratorLeftAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorLeftAndRightQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftAndRightQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorRightUnitPerNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                NumeratorRightQuantity,
                NumeratorRightUnit,
                NumeratorLeftAndDenominatorLeftAndRightQuantity,
                NumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryMultiplyingDividedByUSCustomaryMultiplyingUnitWithLeftAsLeftAndLeftAsRight")
infix fun <
    NumeratorLeftAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorLeftAndRightQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftAndRightQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorRightUnitPerNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                NumeratorRightQuantity,
                NumeratorRightUnit,
                NumeratorLeftAndDenominatorLeftAndRightQuantity,
                NumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultiplyingDividedByMetricAndUKImperialMultiplyingUnitWithLeftAsLeftAndLeftAsRight")
infix fun <
    NumeratorLeftAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorLeftAndRightQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftAndRightQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorRightUnitPerNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                NumeratorRightQuantity,
                NumeratorRightUnit,
                NumeratorLeftAndDenominatorLeftAndRightQuantity,
                NumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultiplyingDividedByMetricAndUSCustomaryMultiplyingUnitWithLeftAsLeftAndLeftAsRight")
infix fun <
    NumeratorLeftAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorLeftAndRightQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftAndRightQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorLeftAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorRightUnitPerNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                NumeratorRightQuantity,
                NumeratorRightUnit,
                NumeratorLeftAndDenominatorLeftAndRightQuantity,
                NumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
