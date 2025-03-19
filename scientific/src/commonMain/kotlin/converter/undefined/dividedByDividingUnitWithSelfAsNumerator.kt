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
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import kotlin.jvm.JvmName

// A / Div<A, B> -> B

@JvmName("dividedByDividingUnitWithSelfAsNumerator")
fun <
    NumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
    DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
    DenominatorUnit : UndefinedDividedUnit<
        NumeratorAndDenominatorNumeratorQuantity,
        DenominatorNumeratorUnit,
        DenominatorDenominatorQuantity,
        DenominatorDenominatorUnit,
        >,
    DenominatorDenominatorValue : UndefinedScientificValue<
        DenominatorDenominatorQuantity,
        DenominatorDenominatorUnit,
        >,
    > UndefinedScientificValue<
    NumeratorAndDenominatorNumeratorQuantity,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorAndDenominatorNumeratorQuantity,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
    factory: (Decimal, DenominatorDenominatorUnit) -> DenominatorDenominatorValue,
) = right.unit.denominator.byDividing(this, right, factory)

@JvmName("metricAndImperialDividedByMetricAndImperialDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorNumeratorQuantity,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorAndDenominatorNumeratorQuantity,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            NumeratorAndDenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDividedByMetricDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorNumeratorQuantity,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorAndDenominatorNumeratorQuantity,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<
            NumeratorAndDenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDividedByImperialDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorNumeratorQuantity,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorAndDenominatorNumeratorQuantity,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            NumeratorAndDenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDividedByUKImperialDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorNumeratorQuantity,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorAndDenominatorNumeratorQuantity,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            NumeratorAndDenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDividedByUSCustomaryDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorNumeratorQuantity,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorAndDenominatorNumeratorQuantity,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            NumeratorAndDenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividedByMetricAndUKImperialDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorNumeratorQuantity,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorAndDenominatorNumeratorQuantity,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            NumeratorAndDenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDividedByMetricAndUSCustomaryDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    NumeratorAndDenominatorNumeratorQuantity,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorAndDenominatorNumeratorQuantity,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            NumeratorAndDenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(right) {
            value: Decimal,
            unit: DenominatorDenominatorUnit,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("genericDividedByGenericDividingUnitWithSelfAsNumerator")
infix fun <
    NumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
    NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
    DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorQuantity>,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
    DenominatorUnit : UndefinedDividedUnit<
        NumeratorAndDenominatorNumeratorQuantity,
        DenominatorNumeratorUnit,
        DenominatorDenominatorQuantity,
        DenominatorDenominatorUnit,
        >,
    > UndefinedScientificValue<
    NumeratorAndDenominatorNumeratorQuantity,
    NumeratorUnit,
    >.genericDividedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorAndDenominatorNumeratorQuantity,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) = dividedBy(right) {
        value: Decimal,
        unit: DenominatorDenominatorUnit,
    ->
    DefaultUndefinedScientificValue(value, unit)
}
