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
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// Inv<A> / Div<B, Mul<A, A>> -> Div<A, B>

@JvmName("reciprocalDividedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeftAndSelfAsRight")
fun <
    NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
    NumeratorUnit : UndefinedReciprocalUnit<
        NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
        NumeratorReciprocalUnit,
        >,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
    DenominatorDenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
    DenominatorDenominatorUnit : UndefinedMultipliedUnit<
        NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
        DenominatorDenominatorLeftAndRightUnit,
        NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
        DenominatorDenominatorLeftAndRightUnit,
        >,
    DenominatorUnit : UndefinedDividedUnit<
        DenominatorNumeratorQuantity,
        DenominatorNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            >,
        DenominatorDenominatorUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
        NumeratorReciprocalUnit,
        DenominatorNumeratorQuantity,
        DenominatorNumeratorUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            DenominatorNumeratorQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
    numeratorReciprocalUnitPerDenominatorNumeratorUnit: NumeratorReciprocalUnit.(DenominatorNumeratorUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.inverse.numeratorReciprocalUnitPerDenominatorNumeratorUnit(
    right.unit.numerator,
).byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalDividedByMetricAndImperialDividingUnitWithMultiplyingDenominatorWithSelfAsLeftAndSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftAndRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
        DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            DenominatorDenominatorLeftAndRightUnit,
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            DenominatorDenominatorLeftAndRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                >,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorReciprocalUnitPerDenominatorNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalUnit,
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricReciprocalDividedByMetricDividingUnitWithMultiplyingDenominatorWithSelfAsLeftAndSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftAndRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
        DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            DenominatorDenominatorLeftAndRightUnit,
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            DenominatorDenominatorLeftAndRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                >,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(
        right,
        numeratorReciprocalUnitPerDenominatorNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalUnit,
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialReciprocalDividedByImperialDividingUnitWithMultiplyingDenominatorWithSelfAsLeftAndSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftAndRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
        DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            DenominatorDenominatorLeftAndRightUnit,
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            DenominatorDenominatorLeftAndRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                >,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorReciprocalUnitPerDenominatorNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalUnit,
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialReciprocalDividedByUKImperialDividingUnitWithMultiplyingDenominatorWithSelfAsLeftAndSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftAndRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
        DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            DenominatorDenominatorLeftAndRightUnit,
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            DenominatorDenominatorLeftAndRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                >,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorReciprocalUnitPerDenominatorNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalUnit,
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryReciprocalDividedByUSCustomaryDividingUnitWithMultiplyingDenominatorWithSelfAsLeftAndSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftAndRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
        DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            DenominatorDenominatorLeftAndRightUnit,
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            DenominatorDenominatorLeftAndRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                >,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorReciprocalUnitPerDenominatorNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalUnit,
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialReciprocalDividedByMetricAndUKImperialDividingUnitWithMultiplyingDenominatorWithSelfAsLeftAndSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftAndRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
        DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            DenominatorDenominatorLeftAndRightUnit,
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            DenominatorDenominatorLeftAndRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                >,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorReciprocalUnitPerDenominatorNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalUnit,
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryReciprocalDividedByMetricAndUSCustomaryDividingUnitWithMultiplyingDenominatorWithSelfAsLeftAndSelfAsRight")
infix fun <
    NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorLeftAndRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
        DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            DenominatorDenominatorLeftAndRightUnit,
            NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
            DenominatorDenominatorLeftAndRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                >,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorReciprocalUnitPerDenominatorNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
                NumeratorReciprocalUnit,
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
