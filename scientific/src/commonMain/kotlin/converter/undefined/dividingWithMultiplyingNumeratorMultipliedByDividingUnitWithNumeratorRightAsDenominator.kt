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

// Div<Mul<C, B>, D> * Div<A, B> -> Div<Mul<C, A>, D>

@JvmName("dividingWithMultiplyingNumeratorMultipliedByDividingUnitWithNumeratorRightAsDenominator")
fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
    LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
    LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
    RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
    TargetNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, RightNumeratorQuantity, RightNumeratorUnit>,
    TargetUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, RightNumeratorQuantity>, TargetNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
    TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, RightNumeratorQuantity>, LeftDenominatorQuantity>, TargetUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftDenominatorQuantity>, LeftUnit>.multipliedByDividingUnitWithNumeratorRightAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
    leftNumeratorLeftUnitXRightNumeratorUnit: LeftNumeratorLeftUnit.(RightNumeratorUnit) -> TargetNumeratorUnit,
    targetNumeratorUnitPerLeftDenominatorUnit: TargetNumeratorUnit.(LeftDenominatorUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.left.leftNumeratorLeftUnitXRightNumeratorUnit(
    right.unit.numerator,
).targetNumeratorUnitPerLeftDenominatorUnit(unit.denominator).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingNumeratorMultipliedByMetricAndImperialDividingUnitWithNumeratorRightAsDenominator")
infix fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftDenominatorQuantity>, LeftUnit>.multipliedByDividingUnitWithNumeratorRightAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDividingUnitWithNumeratorRightAsDenominator(
        right,
        leftNumeratorLeftUnitXRightNumeratorUnit = { x(it) },
        targetNumeratorUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, RightNumeratorQuantity>,
                UndefinedMultipliedUnit.MetricAndImperial<
                    LeftNumeratorLeftQuantity,
                    LeftNumeratorLeftUnit,
                    RightNumeratorQuantity,
                    RightNumeratorUnit,
                    >,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDividingWithMultiplyingNumeratorMultipliedByMetricDividingUnitWithNumeratorRightAsDenominator")
infix fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftDenominatorQuantity>, LeftUnit>.multipliedByDividingUnitWithNumeratorRightAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedByDividingUnitWithNumeratorRightAsDenominator(
        right,
        leftNumeratorLeftUnitXRightNumeratorUnit = { x(it) },
        targetNumeratorUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, RightNumeratorQuantity>,
                UndefinedMultipliedUnit.Metric<
                    LeftNumeratorLeftQuantity,
                    LeftNumeratorLeftUnit,
                    RightNumeratorQuantity,
                    RightNumeratorUnit,
                    >,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDividingWithMultiplyingNumeratorMultipliedByImperialDividingUnitWithNumeratorRightAsDenominator")
infix fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftDenominatorQuantity>, LeftUnit>.multipliedByDividingUnitWithNumeratorRightAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDividingUnitWithNumeratorRightAsDenominator(
        right,
        leftNumeratorLeftUnitXRightNumeratorUnit = { x(it) },
        targetNumeratorUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, RightNumeratorQuantity>,
                UndefinedMultipliedUnit.Imperial<
                    LeftNumeratorLeftQuantity,
                    LeftNumeratorLeftUnit,
                    RightNumeratorQuantity,
                    RightNumeratorUnit,
                    >,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDividingWithMultiplyingNumeratorMultipliedByUKImperialDividingUnitWithNumeratorRightAsDenominator")
infix fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftDenominatorQuantity>, LeftUnit>.multipliedByDividingUnitWithNumeratorRightAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByDividingUnitWithNumeratorRightAsDenominator(
        right,
        leftNumeratorLeftUnitXRightNumeratorUnit = { x(it) },
        targetNumeratorUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, RightNumeratorQuantity>,
                UndefinedMultipliedUnit.UKImperial<
                    LeftNumeratorLeftQuantity,
                    LeftNumeratorLeftUnit,
                    RightNumeratorQuantity,
                    RightNumeratorUnit,
                    >,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingWithMultiplyingNumeratorMultipliedByUSCustomaryDividingUnitWithNumeratorRightAsDenominator")
infix fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftDenominatorQuantity>, LeftUnit>.multipliedByDividingUnitWithNumeratorRightAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDividingUnitWithNumeratorRightAsDenominator(
        right,
        leftNumeratorLeftUnitXRightNumeratorUnit = { x(it) },
        targetNumeratorUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, RightNumeratorQuantity>,
                UndefinedMultipliedUnit.USCustomary<
                    LeftNumeratorLeftQuantity,
                    LeftNumeratorLeftUnit,
                    RightNumeratorQuantity,
                    RightNumeratorUnit,
                    >,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividingWithMultiplyingNumeratorMultipliedByMetricAndUKImperialDividingUnitWithNumeratorRightAsDenominator")
infix fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftDenominatorQuantity>, LeftUnit>.multipliedByDividingUnitWithNumeratorRightAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByDividingUnitWithNumeratorRightAsDenominator(
        right,
        leftNumeratorLeftUnitXRightNumeratorUnit = { x(it) },
        targetNumeratorUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, RightNumeratorQuantity>,
                UndefinedMultipliedUnit.MetricAndUKImperial<
                    LeftNumeratorLeftQuantity,
                    LeftNumeratorLeftUnit,
                    RightNumeratorQuantity,
                    RightNumeratorUnit,
                    >,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDividingWithMultiplyingNumeratorMultipliedByMetricAndUSCustomaryDividingUnitWithNumeratorRightAsDenominator")
infix fun <
    LeftNumeratorLeftQuantity : UndefinedQuantityType,
    LeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightAndRightDenominatorUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftDenominatorQuantity>, LeftUnit>.multipliedByDividingUnitWithNumeratorRightAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, LeftNumeratorRightAndRightDenominatorQuantity, LeftNumeratorRightAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDividingUnitWithNumeratorRightAsDenominator(
        right,
        leftNumeratorLeftUnitXRightNumeratorUnit = { x(it) },
        targetNumeratorUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, RightNumeratorQuantity>,
                UndefinedMultipliedUnit.MetricAndUSCustomary<
                    LeftNumeratorLeftQuantity,
                    LeftNumeratorLeftUnit,
                    RightNumeratorQuantity,
                    RightNumeratorUnit,
                    >,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
