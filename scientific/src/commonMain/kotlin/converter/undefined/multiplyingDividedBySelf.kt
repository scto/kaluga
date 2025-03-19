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
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.Dimensionless
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.One
import kotlin.jvm.JvmName

// Mul<A, A> / Mul<A, A> -> One

@JvmName("multiplyingDividedBySelf")
fun <
    NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity>,
    NumeratorUnit : UndefinedMultipliedUnit<
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        NumeratorLeftAndRightUnit,
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        NumeratorLeftAndRightUnit,
        >,
    DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity>,
    DenominatorUnit : UndefinedMultipliedUnit<
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        DenominatorLeftAndRightUnit,
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        DenominatorLeftAndRightUnit,
        >,
    TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
    TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
    getDimensionless: () -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = getDimensionless().byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingDividedByMetricAndImperialSelf")
infix fun <
    NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricMultiplyingDividedByMetricSelf")
infix fun <
    NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialMultiplyingDividedByImperialSelf")
infix fun <
    NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialMultiplyingDividedByUKImperialSelf")
infix fun <
    NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryMultiplyingDividedByUSCustomarySelf")
infix fun <
    NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultiplyingDividedByMetricAndUKImperialSelf")
infix fun <
    NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultiplyingDividedByMetricAndUSCustomarySelf")
infix fun <
    NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorLeftAndRightUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity>,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            DenominatorLeftAndRightUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericMultiplyingDividedByGenericSelf")
infix fun <
    NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity>,
    NumeratorUnit : UndefinedMultipliedUnit<
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        NumeratorLeftAndRightUnit,
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        NumeratorLeftAndRightUnit,
        >,
    DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity>,
    DenominatorUnit : UndefinedMultipliedUnit<
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        DenominatorLeftAndRightUnit,
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        DenominatorLeftAndRightUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.genericDividedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            NumeratorLeftAndRightAndDenominatorLeftAndRightQuantity,
            >,
        DenominatorUnit,
        >,
) = dividedBy(
    right,
    getDimensionless = { One },
) {
        value: Decimal,
        unit: One,
    ->
    DefaultScientificValue(value, unit)
}
