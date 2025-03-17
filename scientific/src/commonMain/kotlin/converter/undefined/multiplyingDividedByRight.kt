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
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import kotlin.jvm.JvmName

// Mul<A, B> / B -> A

@JvmName("multiplyingDividedByRight")
fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
    NumeratorRightAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorQuantity>,
    NumeratorUnit : UndefinedMultipliedUnit<
        NumeratorLeftQuantity,
        NumeratorLeftUnit,
        NumeratorRightAndDenominatorQuantity,
        NumeratorRightAndDenominatorUnit,
        >,
    NumeratorLeftValue : UndefinedScientificValue<
        NumeratorLeftQuantity,
        NumeratorLeftUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorQuantity,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        NumeratorRightAndDenominatorQuantity,
        NumeratorRightAndDenominatorUnit,
        >,
    factory: (Decimal, NumeratorLeftUnit) -> NumeratorLeftValue,
) = unit.left.byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingDividedByMetricAndImperialRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorUnit,
    NumeratorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorQuantity,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        NumeratorRightAndDenominatorQuantity,
        NumeratorRightAndDenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightAndDenominatorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorQuantity>,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorQuantity,
            NumeratorRightAndDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricMultiplyingDividedByMetricRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorUnit,
    NumeratorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorQuantity,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        NumeratorRightAndDenominatorQuantity,
        NumeratorRightAndDenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightAndDenominatorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorQuantity>,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorQuantity,
            NumeratorRightAndDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialMultiplyingDividedByImperialRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorUnit,
    NumeratorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorQuantity,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        NumeratorRightAndDenominatorQuantity,
        NumeratorRightAndDenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightAndDenominatorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorQuantity>,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorQuantity,
            NumeratorRightAndDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialMultiplyingDividedByUKImperialRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorUnit,
    NumeratorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorQuantity,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        NumeratorRightAndDenominatorQuantity,
        NumeratorRightAndDenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightAndDenominatorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorQuantity>,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorQuantity,
            NumeratorRightAndDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryMultiplyingDividedByUSCustomaryRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorUnit,
    NumeratorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorQuantity,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        NumeratorRightAndDenominatorQuantity,
        NumeratorRightAndDenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightAndDenominatorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorQuantity>,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorQuantity,
            NumeratorRightAndDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultiplyingDividedByMetricAndUKImperialRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorUnit,
    NumeratorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorQuantity,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        NumeratorRightAndDenominatorQuantity,
        NumeratorRightAndDenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightAndDenominatorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorQuantity>,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorQuantity,
            NumeratorRightAndDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultiplyingDividedByMetricAndUSCustomaryRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorUnit,
    NumeratorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorQuantity,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        NumeratorRightAndDenominatorQuantity,
        NumeratorRightAndDenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightAndDenominatorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorQuantity>,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorQuantity,
            NumeratorRightAndDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorLeftUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("genericMultiplyingDividedByGenericRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
    NumeratorRightAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorQuantity>,
    NumeratorUnit : UndefinedMultipliedUnit<
        NumeratorLeftQuantity,
        NumeratorLeftUnit,
        NumeratorRightAndDenominatorQuantity,
        NumeratorRightAndDenominatorUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorQuantity,
        >,
    NumeratorUnit,
    >.genericDividedByGeneric(
    right: UndefinedScientificValue<
        NumeratorRightAndDenominatorQuantity,
        NumeratorRightAndDenominatorUnit,
        >,
) = dividedBy(right) {
        value: Decimal,
        unit: NumeratorLeftUnit,
    ->
    DefaultUndefinedScientificValue(value, unit)
}
