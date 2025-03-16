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
import kotlin.jvm.JvmName

// Div<Mul<D, E>, Mul<B, A>> * Div<Mul<A, B>, Mul<C, D>> -> Div<E, C>

@JvmName(
    "dividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight",
)
fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
    LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
    LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorLeftAndRightNumeratorRightUnit, LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorLeftUnit>,
    LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorLeftQuantity>, LeftDenominatorUnit>,
    RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorLeftUnit, LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorLeftAndRightNumeratorRightUnit>,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
    RightDenominatorUnit : UndefinedMultipliedUnit<RightDenominatorLeftQuantity, RightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
    RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorRightQuantity>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
    TargetUnit : UndefinedDividedUnit<LeftNumeratorRightQuantity, LeftNumeratorRightUnit, RightDenominatorLeftQuantity, RightDenominatorLeftUnit>,
    TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorRightQuantity, RightDenominatorLeftQuantity>, TargetUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorLeftQuantity>>, LeftUnit>.multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
    leftNumeratorRightUnitPerRightDenominatorLeftUnit: LeftNumeratorRightUnit.(RightDenominatorLeftUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.right.leftNumeratorRightUnitPerRightDenominatorLeftUnit(right.unit.denominator.left).byMultiplying(this, right, factory)

@JvmName(
    "metricAndImperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorRightUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightNumeratorLeftUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorLeftQuantity>>, LeftUnit>.multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftAndRightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightAndRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorLeftAndRightNumeratorRightUnit, LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorLeftUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorLeftQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorLeftUnit, LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorLeftAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<RightDenominatorLeftQuantity, RightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorRightQuantity>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight(
        right,
        leftNumeratorRightUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "metricDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByMetricDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorRightUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightNumeratorLeftUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorLeftQuantity>>, LeftUnit>.multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftAndRightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightAndRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorLeftAndRightNumeratorRightUnit, LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorLeftUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorLeftQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorLeftUnit, LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorLeftAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : UndefinedMultipliedUnit<RightDenominatorLeftQuantity, RightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorRightQuantity>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight(
        right,
        leftNumeratorRightUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "imperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByImperialDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorRightUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightNumeratorLeftUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorLeftQuantity>>, LeftUnit>.multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftAndRightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorLeftAndRightNumeratorRightUnit, LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorLeftUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorLeftQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorLeftUnit, LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorLeftAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<RightDenominatorLeftQuantity, RightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorRightQuantity>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight(
        right,
        leftNumeratorRightUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "ukImperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByUKImperialDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorRightUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightNumeratorLeftUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorLeftQuantity>>, LeftUnit>.multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftAndRightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorLeftAndRightNumeratorRightUnit, LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorLeftUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorLeftQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorLeftUnit, LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorLeftAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedMultipliedUnit<RightDenominatorLeftQuantity, RightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorRightQuantity>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight(
        right,
        leftNumeratorRightUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "usCustomaryDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorRightUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightNumeratorLeftUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorLeftQuantity>>, LeftUnit>.multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftAndRightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorLeftAndRightNumeratorRightUnit, LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorLeftUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorLeftQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorLeftUnit, LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorLeftAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<RightDenominatorLeftQuantity, RightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorRightQuantity>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight(
        right,
        leftNumeratorRightUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "metricAndUKImperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorRightUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightNumeratorLeftUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorLeftQuantity>>, LeftUnit>.multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftAndRightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightAndRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorLeftAndRightNumeratorRightUnit, LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorLeftUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorLeftQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorLeftUnit, LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorLeftAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedMultipliedUnit<RightDenominatorLeftQuantity, RightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorRightQuantity>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight(
        right,
        leftNumeratorRightUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName(
    "metricAndUSCustomaryDividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight",
)
infix fun <
    LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightDenominatorRightUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorRightUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightNumeratorLeftUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorLeftQuantity>>, LeftUnit>.multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
) where
        LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftAndRightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftAndRightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightAndRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightAndRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorLeftAndRightNumeratorRightUnit, LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorLeftUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorLeftQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorLeftUnit, LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorLeftAndRightNumeratorRightUnit>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<RightDenominatorLeftQuantity, RightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorRightQuantity>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<RightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorLeftAsRight(
        right,
        leftNumeratorRightUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
