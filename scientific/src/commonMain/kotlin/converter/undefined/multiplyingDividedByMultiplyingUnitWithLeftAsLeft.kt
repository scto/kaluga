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

// Mul<A, B> / Mul<A, C> -> Div<B, C>

@JvmName("multiplyingDividedByMultiplyingUnitWithLeftAsLeft")
fun <
    NumeratorLeftAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
    NumeratorUnit : UndefinedMultipliedUnit<
        NumeratorLeftAndDenominatorLeftQuantity,
        NumeratorLeftUnit,
        NumeratorRightQuantity,
        NumeratorRightUnit,
        >,
    DenominatorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
    DenominatorUnit : UndefinedMultipliedUnit<
        NumeratorLeftAndDenominatorLeftQuantity,
        DenominatorLeftUnit,
        DenominatorRightQuantity,
        DenominatorRightUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        NumeratorRightQuantity,
        NumeratorRightUnit,
        DenominatorRightQuantity,
        DenominatorRightUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorRightQuantity,
            DenominatorRightQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorLeftQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
    numeratorRightUnitPerDenominatorRightUnit: NumeratorRightUnit.(DenominatorRightUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.right.numeratorRightUnitPerDenominatorRightUnit(
    right.unit.right,
).byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingDividedByMetricAndImperialMultiplyingUnitWithLeftAsLeft")
infix fun <
    NumeratorLeftAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorLeftQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
            DenominatorRightQuantity,
            DenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorRightUnitPerDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                NumeratorRightQuantity,
                NumeratorRightUnit,
                DenominatorRightQuantity,
                DenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricMultiplyingDividedByMetricMultiplyingUnitWithLeftAsLeft")
infix fun <
    NumeratorLeftAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorLeftQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
            DenominatorRightQuantity,
            DenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(
        right,
        numeratorRightUnitPerDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                NumeratorRightQuantity,
                NumeratorRightUnit,
                DenominatorRightQuantity,
                DenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialMultiplyingDividedByImperialMultiplyingUnitWithLeftAsLeft")
infix fun <
    NumeratorLeftAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorLeftQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
            DenominatorRightQuantity,
            DenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorRightUnitPerDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                NumeratorRightQuantity,
                NumeratorRightUnit,
                DenominatorRightQuantity,
                DenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialMultiplyingDividedByUKImperialMultiplyingUnitWithLeftAsLeft")
infix fun <
    NumeratorLeftAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorLeftQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
            DenominatorRightQuantity,
            DenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorRightUnitPerDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                NumeratorRightQuantity,
                NumeratorRightUnit,
                DenominatorRightQuantity,
                DenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryMultiplyingDividedByUSCustomaryMultiplyingUnitWithLeftAsLeft")
infix fun <
    NumeratorLeftAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorLeftQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
            DenominatorRightQuantity,
            DenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorRightUnitPerDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                NumeratorRightQuantity,
                NumeratorRightUnit,
                DenominatorRightQuantity,
                DenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultiplyingDividedByMetricAndUKImperialMultiplyingUnitWithLeftAsLeft")
infix fun <
    NumeratorLeftAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorLeftQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
            DenominatorRightQuantity,
            DenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorRightUnitPerDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                NumeratorRightQuantity,
                NumeratorRightUnit,
                DenominatorRightQuantity,
                DenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultiplyingDividedByMetricAndUSCustomaryMultiplyingUnitWithLeftAsLeft")
infix fun <
    NumeratorLeftAndDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorLeftUnit,
    DenominatorRightQuantity : UndefinedQuantityType,
    DenominatorRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorLeftQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndDenominatorLeftQuantity,
            DenominatorRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
        DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
        DenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorLeftQuantity,
            DenominatorLeftUnit,
            DenominatorRightQuantity,
            DenominatorRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorRightUnitPerDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                NumeratorRightQuantity,
                NumeratorRightUnit,
                DenominatorRightQuantity,
                DenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
