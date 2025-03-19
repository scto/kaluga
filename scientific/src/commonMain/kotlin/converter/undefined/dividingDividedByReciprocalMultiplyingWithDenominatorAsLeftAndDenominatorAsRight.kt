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
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Div<A, B> / Inv<Mul<B, B>> -> Mul<A, B>

@JvmName("dividingDividedByReciprocalMultiplyingWithDenominatorAsLeftAndDenominatorAsRight")
fun <
    NumeratorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
    NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity>,
    NumeratorUnit : UndefinedDividedUnit<
        NumeratorNumeratorQuantity,
        NumeratorNumeratorUnit,
        NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
        NumeratorDenominatorUnit,
        >,
    DenominatorReciprocalLeftAndRightUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity>,
    DenominatorReciprocalUnit : UndefinedMultipliedUnit<
        NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
        DenominatorReciprocalLeftAndRightUnit,
        NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
        DenominatorReciprocalLeftAndRightUnit,
        >,
    DenominatorUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            >,
        DenominatorReciprocalUnit,
        >,
    TargetUnit : UndefinedMultipliedUnit<
        NumeratorNumeratorQuantity,
        NumeratorNumeratorUnit,
        NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
        NumeratorDenominatorUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorQuantity,
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        NumeratorNumeratorQuantity,
        NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
    numeratorNumeratorUnitXNumeratorDenominatorUnit: NumeratorNumeratorUnit.(NumeratorDenominatorUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.numeratorNumeratorUnitXNumeratorDenominatorUnit(
    unit.denominator,
).byDividing(this, right, factory)

@JvmName("metricAndImperialDividingDividedByMetricAndImperialReciprocalMultiplyingWithDenominatorAsLeftAndDenominatorAsRight")
infix fun <
    NumeratorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorUnit,
    NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftAndRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        NumeratorNumeratorQuantity,
        NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            NumeratorNumeratorQuantity,
            NumeratorNumeratorUnit,
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalLeftAndRightUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity>,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorNumeratorUnitXNumeratorDenominatorUnit = { x(it) },
    ) {
            value: Decimal,
            unit: UndefinedMultipliedUnit.MetricAndImperial<
                NumeratorNumeratorQuantity,
                NumeratorNumeratorUnit,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDividingDividedByMetricReciprocalMultiplyingWithDenominatorAsLeftAndDenominatorAsRight")
infix fun <
    NumeratorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorUnit,
    NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftAndRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        NumeratorNumeratorQuantity,
        NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedDividedUnit<
            NumeratorNumeratorQuantity,
            NumeratorNumeratorUnit,
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalLeftAndRightUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity>,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(
        right,
        numeratorNumeratorUnitXNumeratorDenominatorUnit = { x(it) },
    ) {
            value: Decimal,
            unit: UndefinedMultipliedUnit.Metric<
                NumeratorNumeratorQuantity,
                NumeratorNumeratorUnit,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDividingDividedByImperialReciprocalMultiplyingWithDenominatorAsLeftAndDenominatorAsRight")
infix fun <
    NumeratorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorUnit,
    NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftAndRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        NumeratorNumeratorQuantity,
        NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            NumeratorNumeratorQuantity,
            NumeratorNumeratorUnit,
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalLeftAndRightUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity>,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorNumeratorUnitXNumeratorDenominatorUnit = { x(it) },
    ) {
            value: Decimal,
            unit: UndefinedMultipliedUnit.Imperial<
                NumeratorNumeratorQuantity,
                NumeratorNumeratorUnit,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDividingDividedByUKImperialReciprocalMultiplyingWithDenominatorAsLeftAndDenominatorAsRight")
infix fun <
    NumeratorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorUnit,
    NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftAndRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        NumeratorNumeratorQuantity,
        NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<
            NumeratorNumeratorQuantity,
            NumeratorNumeratorUnit,
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalLeftAndRightUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity>,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorNumeratorUnitXNumeratorDenominatorUnit = { x(it) },
    ) {
            value: Decimal,
            unit: UndefinedMultipliedUnit.UKImperial<
                NumeratorNumeratorQuantity,
                NumeratorNumeratorUnit,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingDividedByUSCustomaryReciprocalMultiplyingWithDenominatorAsLeftAndDenominatorAsRight")
infix fun <
    NumeratorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorUnit,
    NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftAndRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        NumeratorNumeratorQuantity,
        NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            NumeratorNumeratorQuantity,
            NumeratorNumeratorUnit,
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalLeftAndRightUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity>,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorNumeratorUnitXNumeratorDenominatorUnit = { x(it) },
    ) {
            value: Decimal,
            unit: UndefinedMultipliedUnit.USCustomary<
                NumeratorNumeratorQuantity,
                NumeratorNumeratorUnit,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividingDividedByMetricAndUKImperialReciprocalMultiplyingWithDenominatorAsLeftAndDenominatorAsRight")
infix fun <
    NumeratorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorUnit,
    NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftAndRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        NumeratorNumeratorQuantity,
        NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<
            NumeratorNumeratorQuantity,
            NumeratorNumeratorUnit,
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalLeftAndRightUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity>,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorNumeratorUnitXNumeratorDenominatorUnit = { x(it) },
    ) {
            value: Decimal,
            unit: UndefinedMultipliedUnit.MetricAndUKImperial<
                NumeratorNumeratorQuantity,
                NumeratorNumeratorUnit,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDividingDividedByMetricAndUSCustomaryReciprocalMultiplyingWithDenominatorAsLeftAndDenominatorAsRight")
infix fun <
    NumeratorNumeratorQuantity : UndefinedQuantityType,
    NumeratorNumeratorUnit,
    NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorReciprocalLeftAndRightUnit,
    DenominatorReciprocalUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        NumeratorNumeratorQuantity,
        NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            NumeratorNumeratorQuantity,
            NumeratorNumeratorUnit,
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalLeftAndRightUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity>,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
            DenominatorReciprocalLeftAndRightUnit,
            >,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
        DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                >,
            DenominatorReciprocalUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorNumeratorUnitXNumeratorDenominatorUnit = { x(it) },
    ) {
            value: Decimal,
            unit: UndefinedMultipliedUnit.MetricAndUSCustomary<
                NumeratorNumeratorQuantity,
                NumeratorNumeratorUnit,
                NumeratorDenominatorAndDenominatorReciprocalLeftAndRightQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
