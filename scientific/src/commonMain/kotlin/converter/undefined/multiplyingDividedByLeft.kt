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

// Mul<A, B> / A -> B

@JvmName("multiplyingDividedByLeft")
fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
    NumeratorUnit : UndefinedMultipliedUnit<
        NumeratorLeftAndDenominatorQuantity,
        NumeratorLeftUnit,
        NumeratorRightQuantity,
        NumeratorRightUnit,
        >,
    DenominatorUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
    NumeratorRightValue : UndefinedScientificValue<
        NumeratorRightQuantity,
        NumeratorRightUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        NumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
    factory: (Decimal, NumeratorRightUnit) -> NumeratorRightValue,
) = unit.right.byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingDividedByMetricAndImperialLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        NumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricMultiplyingDividedByMetricLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        NumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialMultiplyingDividedByImperialLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        NumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialMultiplyingDividedByUKImperialLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        NumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryMultiplyingDividedByUSCustomaryLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        NumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultiplyingDividedByMetricAndUKImperialLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        NumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultiplyingDividedByMetricAndUSCustomaryLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        NumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndDenominatorQuantity,
            NumeratorLeftUnit,
            NumeratorRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("genericMultiplyingDividedByGenericLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
    NumeratorUnit : UndefinedMultipliedUnit<
        NumeratorLeftAndDenominatorQuantity,
        NumeratorLeftUnit,
        NumeratorRightQuantity,
        NumeratorRightUnit,
        >,
    DenominatorUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndDenominatorQuantity,
        NumeratorRightQuantity,
        >,
    NumeratorUnit,
    >.genericDividedByGeneric(
    right: UndefinedScientificValue<
        NumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) = dividedBy(right) {
        value: Decimal,
        unit: NumeratorRightUnit,
    ->
    DefaultUndefinedScientificValue(value, unit)
}
