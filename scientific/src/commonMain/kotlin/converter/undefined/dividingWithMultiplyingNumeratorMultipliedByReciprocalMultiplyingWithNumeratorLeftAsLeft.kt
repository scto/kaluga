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
import com.splendo.kaluga.scientific.unit.per
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Div<Mul<A, B>, C> * Inv<Mul<A, D>> -> Div<B, Mul<C, D>>

@JvmName("dividingWithMultiplyingNumeratorMultipliedByReciprocalMultiplyingWithNumeratorLeftAsLeft")
fun <
    LeftNumeratorLeftAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalLeftQuantity>,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
    LeftNumeratorUnit : UndefinedMultipliedUnit<
        LeftNumeratorLeftAndRightReciprocalLeftQuantity,
        LeftNumeratorLeftUnit,
        LeftNumeratorRightQuantity,
        LeftNumeratorRightUnit,
        >,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
    LeftUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            LeftNumeratorRightQuantity,
            >,
        LeftNumeratorUnit,
        LeftDenominatorQuantity,
        LeftDenominatorUnit,
        >,
    RightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalLeftQuantity>,
    RightReciprocalRightQuantity : UndefinedQuantityType,
    RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
    RightReciprocalUnit : UndefinedMultipliedUnit<
        LeftNumeratorLeftAndRightReciprocalLeftQuantity,
        RightReciprocalLeftUnit,
        RightReciprocalRightQuantity,
        RightReciprocalRightUnit,
        >,
    RightUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            RightReciprocalRightQuantity,
            >,
        RightReciprocalUnit,
        >,
    TargetDenominatorUnit : UndefinedMultipliedUnit<
        LeftDenominatorQuantity,
        LeftDenominatorUnit,
        RightReciprocalRightQuantity,
        RightReciprocalRightUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        LeftNumeratorRightQuantity,
        LeftNumeratorRightUnit,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorQuantity,
            RightReciprocalRightQuantity,
            >,
        TargetDenominatorUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftNumeratorRightQuantity,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorQuantity,
                RightReciprocalRightQuantity,
                >,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            LeftNumeratorRightQuantity,
            >,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
    leftDenominatorUnitXRightReciprocalRightUnit: LeftDenominatorUnit.(RightReciprocalRightUnit) -> TargetDenominatorUnit,
    leftNumeratorRightUnitPerTargetDenominatorUnit: LeftNumeratorRightUnit.(TargetDenominatorUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.right.leftNumeratorRightUnitPerTargetDenominatorUnit(
    unit.denominator.leftDenominatorUnitXRightReciprocalRightUnit(
        right.unit.inverse.right,
    ),
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingNumeratorMultipliedByMetricAndImperialReciprocalMultiplyingWithNumeratorLeftAsLeft")
infix fun <
    LeftNumeratorLeftAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightQuantity : UndefinedQuantityType,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            LeftNumeratorRightQuantity,
            >,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                LeftNumeratorRightQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            RightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftDenominatorUnitXRightReciprocalRightUnit = { x(it) },
        leftNumeratorRightUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightReciprocalRightQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndImperial<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightReciprocalRightQuantity,
                    RightReciprocalRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDividingWithMultiplyingNumeratorMultipliedByMetricReciprocalMultiplyingWithNumeratorLeftAsLeft")
infix fun <
    LeftNumeratorLeftAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightQuantity : UndefinedQuantityType,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            LeftNumeratorRightQuantity,
            >,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                LeftNumeratorRightQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            RightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(
        right,
        leftDenominatorUnitXRightReciprocalRightUnit = { x(it) },
        leftNumeratorRightUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightReciprocalRightQuantity,
                    >,
                UndefinedMultipliedUnit.Metric<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightReciprocalRightQuantity,
                    RightReciprocalRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDividingWithMultiplyingNumeratorMultipliedByImperialReciprocalMultiplyingWithNumeratorLeftAsLeft")
infix fun <
    LeftNumeratorLeftAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightQuantity : UndefinedQuantityType,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            LeftNumeratorRightQuantity,
            >,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                LeftNumeratorRightQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            RightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftDenominatorUnitXRightReciprocalRightUnit = { x(it) },
        leftNumeratorRightUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightReciprocalRightQuantity,
                    >,
                UndefinedMultipliedUnit.Imperial<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightReciprocalRightQuantity,
                    RightReciprocalRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDividingWithMultiplyingNumeratorMultipliedByUKImperialReciprocalMultiplyingWithNumeratorLeftAsLeft")
infix fun <
    LeftNumeratorLeftAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightQuantity : UndefinedQuantityType,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            LeftNumeratorRightQuantity,
            >,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                LeftNumeratorRightQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            RightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftDenominatorUnitXRightReciprocalRightUnit = { x(it) },
        leftNumeratorRightUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightReciprocalRightQuantity,
                    >,
                UndefinedMultipliedUnit.UKImperial<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightReciprocalRightQuantity,
                    RightReciprocalRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingWithMultiplyingNumeratorMultipliedByUSCustomaryReciprocalMultiplyingWithNumeratorLeftAsLeft")
infix fun <
    LeftNumeratorLeftAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightQuantity : UndefinedQuantityType,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            LeftNumeratorRightQuantity,
            >,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                LeftNumeratorRightQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            RightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftDenominatorUnitXRightReciprocalRightUnit = { x(it) },
        leftNumeratorRightUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightReciprocalRightQuantity,
                    >,
                UndefinedMultipliedUnit.USCustomary<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightReciprocalRightQuantity,
                    RightReciprocalRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividingWithMultiplyingNumeratorMultipliedByMetricAndUKImperialReciprocalMultiplyingWithNumeratorLeftAsLeft")
infix fun <
    LeftNumeratorLeftAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightQuantity : UndefinedQuantityType,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            LeftNumeratorRightQuantity,
            >,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                LeftNumeratorRightQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            RightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftDenominatorUnitXRightReciprocalRightUnit = { x(it) },
        leftNumeratorRightUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightReciprocalRightQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUKImperial<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightReciprocalRightQuantity,
                    RightReciprocalRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDividingWithMultiplyingNumeratorMultipliedByMetricAndUSCustomaryReciprocalMultiplyingWithNumeratorLeftAsLeft")
infix fun <
    LeftNumeratorLeftAndRightReciprocalLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightReciprocalLeftUnit,
    RightReciprocalRightQuantity : UndefinedQuantityType,
    RightReciprocalRightUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            LeftNumeratorRightQuantity,
            >,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            LeftNumeratorLeftUnit,
            LeftNumeratorRightQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                LeftNumeratorRightQuantity,
                >,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalLeftQuantity>,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
        RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedMultipliedUnit<
            LeftNumeratorLeftAndRightReciprocalLeftQuantity,
            RightReciprocalLeftUnit,
            RightReciprocalRightQuantity,
            RightReciprocalRightUnit,
            >,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                LeftNumeratorLeftAndRightReciprocalLeftQuantity,
                RightReciprocalRightQuantity,
                >,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftDenominatorUnitXRightReciprocalRightUnit = { x(it) },
        leftNumeratorRightUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightReciprocalRightQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUSCustomary<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightReciprocalRightQuantity,
                    RightReciprocalRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
