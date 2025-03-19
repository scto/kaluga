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
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Div<A, B> * Inv<Mul<C, A>> -> Inv<Mul<B, C>>

@JvmName("dividingMultipliedByReciprocalMultiplyingWithNumeratorAsRight")
fun <
    LeftNumeratorAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalRightQuantity>,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
    LeftUnit : UndefinedDividedUnit<
        LeftNumeratorAndRightReciprocalRightQuantity,
        LeftNumeratorUnit,
        LeftDenominatorQuantity,
        LeftDenominatorUnit,
        >,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit : UndefinedScientificUnit<RightReciprocalLeftQuantity>,
    RightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalRightQuantity>,
    RightReciprocalUnit : UndefinedMultipliedUnit<
        RightReciprocalLeftQuantity,
        RightReciprocalLeftUnit,
        LeftNumeratorAndRightReciprocalRightQuantity,
        RightReciprocalRightUnit,
        >,
    RightUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            RightReciprocalLeftQuantity,
            LeftNumeratorAndRightReciprocalRightQuantity,
            >,
        RightReciprocalUnit,
        >,
    TargetReciprocalUnit : UndefinedMultipliedUnit<
        LeftDenominatorQuantity,
        LeftDenominatorUnit,
        RightReciprocalLeftQuantity,
        RightReciprocalLeftUnit,
        >,
    TargetUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            LeftDenominatorQuantity,
            RightReciprocalLeftQuantity,
            >,
        TargetReciprocalUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorQuantity,
                RightReciprocalLeftQuantity,
                >,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightReciprocalRightQuantity,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftNumeratorAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
    leftDenominatorUnitXRightReciprocalLeftUnit: LeftDenominatorUnit.(RightReciprocalLeftUnit) -> TargetReciprocalUnit,
    reciprocalTargetUnit: TargetReciprocalUnit.() -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.denominator.leftDenominatorUnitXRightReciprocalLeftUnit(
    right.unit.inverse.left,
).reciprocalTargetUnit().byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingMultipliedByMetricAndImperialReciprocalMultiplyingWithNumeratorAsRight")
infix fun <
    LeftNumeratorAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightReciprocalRightQuantity,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftNumeratorAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalRightQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightReciprocalRightQuantity,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : UndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftNumeratorAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftNumeratorAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftDenominatorUnitXRightReciprocalLeftUnit = { x(it) },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndImperial<
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightReciprocalLeftQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndImperial<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightReciprocalLeftQuantity,
                    RightReciprocalLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDividingMultipliedByMetricReciprocalMultiplyingWithNumeratorAsRight")
infix fun <
    LeftNumeratorAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightReciprocalRightQuantity,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftNumeratorAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalRightQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightReciprocalRightQuantity,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : UndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftNumeratorAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftNumeratorAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(
        right,
        leftDenominatorUnitXRightReciprocalLeftUnit = { x(it) },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Metric<
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightReciprocalLeftQuantity,
                    >,
                UndefinedMultipliedUnit.Metric<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightReciprocalLeftQuantity,
                    RightReciprocalLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDividingMultipliedByImperialReciprocalMultiplyingWithNumeratorAsRight")
infix fun <
    LeftNumeratorAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightReciprocalRightQuantity,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftNumeratorAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalRightQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightReciprocalRightQuantity,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : UndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftNumeratorAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftNumeratorAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftDenominatorUnitXRightReciprocalLeftUnit = { x(it) },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Imperial<
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightReciprocalLeftQuantity,
                    >,
                UndefinedMultipliedUnit.Imperial<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightReciprocalLeftQuantity,
                    RightReciprocalLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDividingMultipliedByUKImperialReciprocalMultiplyingWithNumeratorAsRight")
infix fun <
    LeftNumeratorAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightReciprocalRightQuantity,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftNumeratorAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalRightQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightReciprocalRightQuantity,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : UndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftNumeratorAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftNumeratorAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftDenominatorUnitXRightReciprocalLeftUnit = { x(it) },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.UKImperial<
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightReciprocalLeftQuantity,
                    >,
                UndefinedMultipliedUnit.UKImperial<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightReciprocalLeftQuantity,
                    RightReciprocalLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingMultipliedByUSCustomaryReciprocalMultiplyingWithNumeratorAsRight")
infix fun <
    LeftNumeratorAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightReciprocalRightQuantity,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftNumeratorAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalRightQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightReciprocalRightQuantity,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : UndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftNumeratorAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftNumeratorAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftDenominatorUnitXRightReciprocalLeftUnit = { x(it) },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.USCustomary<
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightReciprocalLeftQuantity,
                    >,
                UndefinedMultipliedUnit.USCustomary<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightReciprocalLeftQuantity,
                    RightReciprocalLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividingMultipliedByMetricAndUKImperialReciprocalMultiplyingWithNumeratorAsRight")
infix fun <
    LeftNumeratorAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightReciprocalRightQuantity,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftNumeratorAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalRightQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightReciprocalRightQuantity,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : UndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftNumeratorAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftNumeratorAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftDenominatorUnitXRightReciprocalLeftUnit = { x(it) },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUKImperial<
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightReciprocalLeftQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUKImperial<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightReciprocalLeftQuantity,
                    RightReciprocalLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDividingMultipliedByMetricAndUSCustomaryReciprocalMultiplyingWithNumeratorAsRight")
infix fun <
    LeftNumeratorAndRightReciprocalRightQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftQuantity : UndefinedQuantityType,
    RightReciprocalLeftUnit,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightReciprocalRightQuantity,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftNumeratorAndRightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalRightQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightReciprocalRightQuantity,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : UndefinedScientificUnit<RightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            RightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            LeftNumeratorAndRightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                RightReciprocalLeftQuantity,
                LeftNumeratorAndRightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftDenominatorUnitXRightReciprocalLeftUnit = { x(it) },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightReciprocalLeftQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUSCustomary<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightReciprocalLeftQuantity,
                    RightReciprocalLeftUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
