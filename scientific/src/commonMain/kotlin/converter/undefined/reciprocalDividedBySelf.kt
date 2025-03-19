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
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.One
import kotlin.jvm.JvmName

// Inv<A> / Inv<A> -> One

@JvmName("reciprocalDividedBySelf")
fun <
    NumeratorReciprocalAndDenominatorReciprocalQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalQuantity>,
    NumeratorUnit : UndefinedReciprocalUnit<
        NumeratorReciprocalAndDenominatorReciprocalQuantity,
        NumeratorReciprocalUnit,
        >,
    DenominatorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalQuantity>,
    DenominatorUnit : UndefinedReciprocalUnit<
        NumeratorReciprocalAndDenominatorReciprocalQuantity,
        DenominatorReciprocalUnit,
        >,
    TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
    TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorReciprocalQuantity,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
    getDimensionless: () -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = getDimensionless().byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalDividedByMetricAndImperialSelf")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorReciprocalQuantity,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            DenominatorReciprocalUnit,
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

@JvmName("metricReciprocalDividedByMetricSelf")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorReciprocalQuantity,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            DenominatorReciprocalUnit,
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

@JvmName("imperialReciprocalDividedByImperialSelf")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorReciprocalQuantity,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            DenominatorReciprocalUnit,
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

@JvmName("ukImperialReciprocalDividedByUKImperialSelf")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorReciprocalQuantity,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            DenominatorReciprocalUnit,
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

@JvmName("usCustomaryReciprocalDividedByUSCustomarySelf")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorReciprocalQuantity,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            DenominatorReciprocalUnit,
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

@JvmName("metricAndUKImperialReciprocalDividedByMetricAndUKImperialSelf")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorReciprocalQuantity,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            DenominatorReciprocalUnit,
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

@JvmName("metricAndUSCustomaryReciprocalDividedByMetricAndUSCustomarySelf")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorReciprocalQuantity,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalQuantity>,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
            DenominatorReciprocalUnit,
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

@JvmName("genericReciprocalDividedByGenericSelf")
infix fun <
    NumeratorReciprocalAndDenominatorReciprocalQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalQuantity>,
    NumeratorUnit : UndefinedReciprocalUnit<
        NumeratorReciprocalAndDenominatorReciprocalQuantity,
        NumeratorReciprocalUnit,
        >,
    DenominatorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalQuantity>,
    DenominatorUnit : UndefinedReciprocalUnit<
        NumeratorReciprocalAndDenominatorReciprocalQuantity,
        DenominatorReciprocalUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorReciprocalQuantity,
        >,
    NumeratorUnit,
    >.genericDividedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            NumeratorReciprocalAndDenominatorReciprocalQuantity,
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
