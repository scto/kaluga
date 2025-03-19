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
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Div<A, B> * Div<C, Mul<A, D>> -> Div<C, Mul<B, D>>

@JvmName("dividingMultipliedByDividingUnitWithMultiplyingDenominatorWithNumeratorAsLeft")
fun <
    LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
    LeftUnit : UndefinedDividedUnit<
        LeftNumeratorAndRightDenominatorLeftQuantity,
        LeftNumeratorUnit,
        LeftDenominatorQuantity,
        LeftDenominatorUnit,
        >,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
    RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
    RightDenominatorUnit : UndefinedMultipliedUnit<
        LeftNumeratorAndRightDenominatorLeftQuantity,
        RightDenominatorLeftUnit,
        RightDenominatorRightQuantity,
        RightDenominatorRightUnit,
        >,
    RightUnit : UndefinedDividedUnit<
        RightNumeratorQuantity,
        RightNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            LeftNumeratorAndRightDenominatorLeftQuantity,
            RightDenominatorRightQuantity,
            >,
        RightDenominatorUnit,
        >,
    TargetDenominatorUnit : UndefinedMultipliedUnit<
        LeftDenominatorQuantity,
        LeftDenominatorUnit,
        RightDenominatorRightQuantity,
        RightDenominatorRightUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        RightNumeratorQuantity,
        RightNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorQuantity,
            RightDenominatorRightQuantity,
            >,
        TargetDenominatorUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightDenominatorLeftQuantity,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
    leftDenominatorUnitXRightDenominatorRightUnit: LeftDenominatorUnit.(RightDenominatorRightUnit) -> TargetDenominatorUnit,
    rightNumeratorUnitPerTargetDenominatorUnit: RightNumeratorUnit.(TargetDenominatorUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.numerator.rightNumeratorUnitPerTargetDenominatorUnit(
    unit.denominator.leftDenominatorUnitXRightDenominatorRightUnit(
        right.unit.denominator.right,
    ),
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingMultipliedByMetricAndImperialDividingUnitWithMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
    LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightDenominatorLeftQuantity,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightDenominatorLeftQuantity,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftDenominatorUnitXRightDenominatorRightUnit = { x(it) },
        rightNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightDenominatorRightQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndImperial<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightDenominatorRightQuantity,
                    RightDenominatorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDividingMultipliedByMetricDividingUnitWithMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
    LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightDenominatorLeftQuantity,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightDenominatorLeftQuantity,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(
        right,
        leftDenominatorUnitXRightDenominatorRightUnit = { x(it) },
        rightNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightDenominatorRightQuantity,
                    >,
                UndefinedMultipliedUnit.Metric<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightDenominatorRightQuantity,
                    RightDenominatorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDividingMultipliedByImperialDividingUnitWithMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
    LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightDenominatorLeftQuantity,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightDenominatorLeftQuantity,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftDenominatorUnitXRightDenominatorRightUnit = { x(it) },
        rightNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightDenominatorRightQuantity,
                    >,
                UndefinedMultipliedUnit.Imperial<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightDenominatorRightQuantity,
                    RightDenominatorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDividingMultipliedByUKImperialDividingUnitWithMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
    LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightDenominatorLeftQuantity,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightDenominatorLeftQuantity,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftDenominatorUnitXRightDenominatorRightUnit = { x(it) },
        rightNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightDenominatorRightQuantity,
                    >,
                UndefinedMultipliedUnit.UKImperial<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightDenominatorRightQuantity,
                    RightDenominatorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingMultipliedByUSCustomaryDividingUnitWithMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
    LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightDenominatorLeftQuantity,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightDenominatorLeftQuantity,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftDenominatorUnitXRightDenominatorRightUnit = { x(it) },
        rightNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightDenominatorRightQuantity,
                    >,
                UndefinedMultipliedUnit.USCustomary<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightDenominatorRightQuantity,
                    RightDenominatorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividingMultipliedByMetricAndUKImperialDividingUnitWithMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
    LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightDenominatorLeftQuantity,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightDenominatorLeftQuantity,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftDenominatorUnitXRightDenominatorRightUnit = { x(it) },
        rightNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightDenominatorRightQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUKImperial<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightDenominatorRightQuantity,
                    RightDenominatorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDividingMultipliedByMetricAndUSCustomaryDividingUnitWithMultiplyingDenominatorWithNumeratorAsLeft")
infix fun <
    LeftNumeratorAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightQuantity : UndefinedQuantityType,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightDenominatorLeftQuantity,
        LeftDenominatorQuantity,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightDenominatorLeftQuantity,
            LeftNumeratorUnit,
            LeftDenominatorQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftNumeratorAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            RightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftNumeratorAndRightDenominatorLeftQuantity,
                RightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftDenominatorUnitXRightDenominatorRightUnit = { x(it) },
        rightNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorQuantity,
                    RightDenominatorRightQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUSCustomary<
                    LeftDenominatorQuantity,
                    LeftDenominatorUnit,
                    RightDenominatorRightQuantity,
                    RightDenominatorRightUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
