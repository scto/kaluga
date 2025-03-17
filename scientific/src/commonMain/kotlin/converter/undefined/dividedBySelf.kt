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
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.One
import kotlin.jvm.JvmName

// A / A -> One

@JvmName("dividedBySelf")
fun <
    NumeratorAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorUnit : UndefinedScientificUnit<NumeratorAndDenominatorQuantity>,
    TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
    TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>,
    > UndefinedScientificValue<
    NumeratorAndDenominatorQuantity,
    NumeratorAndDenominatorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        NumeratorAndDenominatorQuantity,
        NumeratorAndDenominatorUnit,
        >,
    getDimensionless: () -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = getDimensionless().byDividing(this, right, factory)

@JvmName("metricAndImperialDividedByMetricAndImperialSelf")
infix fun <
    NumeratorAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorQuantity,
    NumeratorAndDenominatorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        NumeratorAndDenominatorQuantity,
        NumeratorAndDenominatorUnit,
        >,
) where
        NumeratorAndDenominatorUnit : UndefinedScientificUnit<NumeratorAndDenominatorQuantity>,
        NumeratorAndDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricDividedByMetricSelf")
infix fun <
    NumeratorAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorQuantity,
    NumeratorAndDenominatorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        NumeratorAndDenominatorQuantity,
        NumeratorAndDenominatorUnit,
        >,
) where
        NumeratorAndDenominatorUnit : UndefinedScientificUnit<NumeratorAndDenominatorQuantity>,
        NumeratorAndDenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialDividedByImperialSelf")
infix fun <
    NumeratorAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorQuantity,
    NumeratorAndDenominatorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        NumeratorAndDenominatorQuantity,
        NumeratorAndDenominatorUnit,
        >,
) where
        NumeratorAndDenominatorUnit : UndefinedScientificUnit<NumeratorAndDenominatorQuantity>,
        NumeratorAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialDividedByUKImperialSelf")
infix fun <
    NumeratorAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorQuantity,
    NumeratorAndDenominatorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        NumeratorAndDenominatorQuantity,
        NumeratorAndDenominatorUnit,
        >,
) where
        NumeratorAndDenominatorUnit : UndefinedScientificUnit<NumeratorAndDenominatorQuantity>,
        NumeratorAndDenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryDividedByUSCustomarySelf")
infix fun <
    NumeratorAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorQuantity,
    NumeratorAndDenominatorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        NumeratorAndDenominatorQuantity,
        NumeratorAndDenominatorUnit,
        >,
) where
        NumeratorAndDenominatorUnit : UndefinedScientificUnit<NumeratorAndDenominatorQuantity>,
        NumeratorAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividedByMetricAndUKImperialSelf")
infix fun <
    NumeratorAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorQuantity,
    NumeratorAndDenominatorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        NumeratorAndDenominatorQuantity,
        NumeratorAndDenominatorUnit,
        >,
) where
        NumeratorAndDenominatorUnit : UndefinedScientificUnit<NumeratorAndDenominatorQuantity>,
        NumeratorAndDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorAndDenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDividedByMetricAndUSCustomarySelf")
infix fun <
    NumeratorAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorQuantity,
    NumeratorAndDenominatorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        NumeratorAndDenominatorQuantity,
        NumeratorAndDenominatorUnit,
        >,
) where
        NumeratorAndDenominatorUnit : UndefinedScientificUnit<NumeratorAndDenominatorQuantity>,
        NumeratorAndDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericDividedByGenericSelf")
infix fun <
    NumeratorAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorUnit : UndefinedScientificUnit<NumeratorAndDenominatorQuantity>,
    > UndefinedScientificValue<
    NumeratorAndDenominatorQuantity,
    NumeratorAndDenominatorUnit,
    >.genericDividedByGeneric(
    right: UndefinedScientificValue<
        NumeratorAndDenominatorQuantity,
        NumeratorAndDenominatorUnit,
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
