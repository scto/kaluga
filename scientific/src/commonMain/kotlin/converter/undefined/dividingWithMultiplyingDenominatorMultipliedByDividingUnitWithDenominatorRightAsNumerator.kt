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

// Div<C, Mul<D, A>> * Div<A, B> -> Div<C, Mul<D, B>>

@JvmName("dividingWithMultiplyingDenominatorMultipliedByDividingUnitWithDenominatorRightAsNumerator")
fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
    LeftDenominatorRightAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorQuantity>,
    LeftDenominatorUnit : UndefinedMultipliedUnit<
        LeftDenominatorLeftQuantity,
        LeftDenominatorLeftUnit,
        LeftDenominatorRightAndRightNumeratorQuantity,
        LeftDenominatorRightUnit,
        >,
    LeftUnit : UndefinedDividedUnit<
        LeftNumeratorQuantity,
        LeftNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            LeftDenominatorRightAndRightNumeratorQuantity,
            >,
        LeftDenominatorUnit,
        >,
    RightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorQuantity>,
    RightDenominatorQuantity : UndefinedQuantityType,
    RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
    RightUnit : UndefinedDividedUnit<
        LeftDenominatorRightAndRightNumeratorQuantity,
        RightNumeratorUnit,
        RightDenominatorQuantity,
        RightDenominatorUnit,
        >,
    TargetDenominatorUnit : UndefinedMultipliedUnit<
        LeftDenominatorLeftQuantity,
        LeftDenominatorLeftUnit,
        RightDenominatorQuantity,
        RightDenominatorUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        LeftNumeratorQuantity,
        LeftNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            RightDenominatorQuantity,
            >,
        TargetDenominatorUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                RightDenominatorQuantity,
                >,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            LeftDenominatorRightAndRightNumeratorQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftDenominatorRightAndRightNumeratorQuantity,
            RightDenominatorQuantity,
            >,
        RightUnit,
        >,
    leftDenominatorLeftUnitXRightDenominatorUnit: LeftDenominatorLeftUnit.(RightDenominatorUnit) -> TargetDenominatorUnit,
    leftNumeratorUnitPerTargetDenominatorUnit: LeftNumeratorUnit.(TargetDenominatorUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.leftNumeratorUnitPerTargetDenominatorUnit(
    unit.denominator.left.leftDenominatorLeftUnitXRightDenominatorUnit(
        right.unit.denominator,
    ),
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingDenominatorMultipliedByMetricAndImperialDividingUnitWithDenominatorRightAsNumerator")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorQuantity : UndefinedQuantityType,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            LeftDenominatorRightAndRightNumeratorQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftDenominatorRightAndRightNumeratorQuantity,
            RightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                LeftDenominatorRightAndRightNumeratorQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            LeftDenominatorRightAndRightNumeratorQuantity,
            RightNumeratorUnit,
            RightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftDenominatorLeftUnitXRightDenominatorUnit = { x(it) },
        leftNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorLeftQuantity,
                    RightDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndImperial<
                    LeftDenominatorLeftQuantity,
                    LeftDenominatorLeftUnit,
                    RightDenominatorQuantity,
                    RightDenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDividingWithMultiplyingDenominatorMultipliedByMetricDividingUnitWithDenominatorRightAsNumerator")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorQuantity : UndefinedQuantityType,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            LeftDenominatorRightAndRightNumeratorQuantity,
            >,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftDenominatorRightAndRightNumeratorQuantity,
            RightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                LeftDenominatorRightAndRightNumeratorQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<
            LeftDenominatorRightAndRightNumeratorQuantity,
            RightNumeratorUnit,
            RightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(
        right,
        leftDenominatorLeftUnitXRightDenominatorUnit = { x(it) },
        leftNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorLeftQuantity,
                    RightDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.Metric<
                    LeftDenominatorLeftQuantity,
                    LeftDenominatorLeftUnit,
                    RightDenominatorQuantity,
                    RightDenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDividingWithMultiplyingDenominatorMultipliedByImperialDividingUnitWithDenominatorRightAsNumerator")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorQuantity : UndefinedQuantityType,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            LeftDenominatorRightAndRightNumeratorQuantity,
            >,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftDenominatorRightAndRightNumeratorQuantity,
            RightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                LeftDenominatorRightAndRightNumeratorQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            LeftDenominatorRightAndRightNumeratorQuantity,
            RightNumeratorUnit,
            RightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftDenominatorLeftUnitXRightDenominatorUnit = { x(it) },
        leftNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorLeftQuantity,
                    RightDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.Imperial<
                    LeftDenominatorLeftQuantity,
                    LeftDenominatorLeftUnit,
                    RightDenominatorQuantity,
                    RightDenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDividingWithMultiplyingDenominatorMultipliedByUKImperialDividingUnitWithDenominatorRightAsNumerator")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorQuantity : UndefinedQuantityType,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            LeftDenominatorRightAndRightNumeratorQuantity,
            >,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftDenominatorRightAndRightNumeratorQuantity,
            RightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                LeftDenominatorRightAndRightNumeratorQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            LeftDenominatorRightAndRightNumeratorQuantity,
            RightNumeratorUnit,
            RightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftDenominatorLeftUnitXRightDenominatorUnit = { x(it) },
        leftNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorLeftQuantity,
                    RightDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.UKImperial<
                    LeftDenominatorLeftQuantity,
                    LeftDenominatorLeftUnit,
                    RightDenominatorQuantity,
                    RightDenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingWithMultiplyingDenominatorMultipliedByUSCustomaryDividingUnitWithDenominatorRightAsNumerator")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorQuantity : UndefinedQuantityType,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            LeftDenominatorRightAndRightNumeratorQuantity,
            >,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftDenominatorRightAndRightNumeratorQuantity,
            RightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                LeftDenominatorRightAndRightNumeratorQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            LeftDenominatorRightAndRightNumeratorQuantity,
            RightNumeratorUnit,
            RightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftDenominatorLeftUnitXRightDenominatorUnit = { x(it) },
        leftNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorLeftQuantity,
                    RightDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.USCustomary<
                    LeftDenominatorLeftQuantity,
                    LeftDenominatorLeftUnit,
                    RightDenominatorQuantity,
                    RightDenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividingWithMultiplyingDenominatorMultipliedByMetricAndUKImperialDividingUnitWithDenominatorRightAsNumerator")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorQuantity : UndefinedQuantityType,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            LeftDenominatorRightAndRightNumeratorQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftDenominatorRightAndRightNumeratorQuantity,
            RightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                LeftDenominatorRightAndRightNumeratorQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            LeftDenominatorRightAndRightNumeratorQuantity,
            RightNumeratorUnit,
            RightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftDenominatorLeftUnitXRightDenominatorUnit = { x(it) },
        leftNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorLeftQuantity,
                    RightDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUKImperial<
                    LeftDenominatorLeftQuantity,
                    LeftDenominatorLeftUnit,
                    RightDenominatorQuantity,
                    RightDenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDividingWithMultiplyingDenominatorMultipliedByMetricAndUSCustomaryDividingUnitWithDenominatorRightAsNumerator")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorQuantity : UndefinedQuantityType,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            LeftDenominatorRightAndRightNumeratorQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftDenominatorRightAndRightNumeratorQuantity,
            RightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                LeftDenominatorRightAndRightNumeratorQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            LeftDenominatorRightAndRightNumeratorQuantity,
            RightNumeratorUnit,
            RightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftDenominatorLeftUnitXRightDenominatorUnit = { x(it) },
        leftNumeratorUnitPerTargetDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                UndefinedQuantityType.Multiplying<
                    LeftDenominatorLeftQuantity,
                    RightDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUSCustomary<
                    LeftDenominatorLeftQuantity,
                    LeftDenominatorLeftUnit,
                    RightDenominatorQuantity,
                    RightDenominatorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
