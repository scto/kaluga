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
    NumeratorLeftAndDenominatorUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
    NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorQuantity, NumeratorLeftAndDenominatorUnit, NumeratorRightQuantity, NumeratorRightUnit>,
    NumeratorRightValue : UndefinedScientificValue<NumeratorRightQuantity, NumeratorRightUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByLeft(
    right: UndefinedScientificValue<NumeratorLeftAndDenominatorQuantity, NumeratorLeftAndDenominatorUnit>,
    factory: (Decimal, NumeratorRightUnit) -> NumeratorRightValue,
) = unit.right.byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingDividedByMetricAndImperialLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftAndDenominatorUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByLeft(
    right: UndefinedScientificValue<NumeratorLeftAndDenominatorQuantity, NumeratorLeftAndDenominatorUnit>,
) where
        NumeratorLeftAndDenominatorUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftAndDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorQuantity, NumeratorLeftAndDenominatorUnit, NumeratorRightQuantity, NumeratorRightUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByLeft(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricMultiplyingDividedByMetricLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftAndDenominatorUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByLeft(
    right: UndefinedScientificValue<NumeratorLeftAndDenominatorQuantity, NumeratorLeftAndDenominatorUnit>,
) where
        NumeratorLeftAndDenominatorUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftAndDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorQuantity, NumeratorLeftAndDenominatorUnit, NumeratorRightQuantity, NumeratorRightUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric =
    dividedByLeft(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialMultiplyingDividedByImperialLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftAndDenominatorUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByLeft(
    right: UndefinedScientificValue<NumeratorLeftAndDenominatorQuantity, NumeratorLeftAndDenominatorUnit>,
) where
        NumeratorLeftAndDenominatorUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorQuantity, NumeratorLeftAndDenominatorUnit, NumeratorRightQuantity, NumeratorRightUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByLeft(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialMultiplyingDividedByUKImperialLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftAndDenominatorUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByLeft(
    right: UndefinedScientificValue<NumeratorLeftAndDenominatorQuantity, NumeratorLeftAndDenominatorUnit>,
) where
        NumeratorLeftAndDenominatorUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorQuantity, NumeratorLeftAndDenominatorUnit, NumeratorRightQuantity, NumeratorRightUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial =
    dividedByLeft(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryMultiplyingDividedByUSCustomaryLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftAndDenominatorUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByLeft(
    right: UndefinedScientificValue<NumeratorLeftAndDenominatorQuantity, NumeratorLeftAndDenominatorUnit>,
) where
        NumeratorLeftAndDenominatorUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorQuantity, NumeratorLeftAndDenominatorUnit, NumeratorRightQuantity, NumeratorRightUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByLeft(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultiplyingDividedByMetricAndUKImperialLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftAndDenominatorUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByLeft(
    right: UndefinedScientificValue<NumeratorLeftAndDenominatorQuantity, NumeratorLeftAndDenominatorUnit>,
) where
        NumeratorLeftAndDenominatorUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftAndDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorQuantity, NumeratorLeftAndDenominatorUnit, NumeratorRightQuantity, NumeratorRightUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial =
    dividedByLeft(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultiplyingDividedByMetricAndUSCustomaryLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftAndDenominatorUnit,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByLeft(
    right: UndefinedScientificValue<NumeratorLeftAndDenominatorQuantity, NumeratorLeftAndDenominatorUnit>,
) where
        NumeratorLeftAndDenominatorUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
        NumeratorLeftAndDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorQuantity, NumeratorLeftAndDenominatorUnit, NumeratorRightQuantity, NumeratorRightUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByLeft(right) {
            value: Decimal,
            unit: NumeratorRightUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("genericMultiplyingDividedByGenericLeft")
infix fun <
    NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorLeftAndDenominatorUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
    NumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
    NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorQuantity, NumeratorLeftAndDenominatorUnit, NumeratorRightQuantity, NumeratorRightUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorQuantity, NumeratorRightQuantity>, NumeratorUnit>.dividedByLeft(
    right: UndefinedScientificValue<NumeratorLeftAndDenominatorQuantity, NumeratorLeftAndDenominatorUnit>,
) = dividedByLeft(right) {
        value: Decimal,
        unit: NumeratorRightUnit,
    ->
    DefaultUndefinedScientificValue(value, unit)
}
