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
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// Div<A, B> * Div<C, A> -> Div<C, B>

@JvmName("dividingMultipliedByDividingUnitWithNumeratorAsDenominator")
fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
    LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
    RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
    TargetUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
    TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, LeftDenominatorQuantity>, TargetUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, LeftDenominatorQuantity>, LeftUnit>.multipliedByDividingUnitWithNumeratorAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
    rightNumeratorUnitPerLeftDenominatorUnit: RightNumeratorUnit.(LeftDenominatorUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.numerator.rightNumeratorUnitPerLeftDenominatorUnit(unit.denominator).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingMultipliedByMetricAndImperialDividingUnitWithNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, LeftDenominatorQuantity>, LeftUnit>.multipliedByDividingUnitWithNumeratorAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDividingUnitWithNumeratorAsDenominator(
        right,
        rightNumeratorUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDividingMultipliedByMetricDividingUnitWithNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, LeftDenominatorQuantity>, LeftUnit>.multipliedByDividingUnitWithNumeratorAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedByDividingUnitWithNumeratorAsDenominator(
        right,
        rightNumeratorUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDividingMultipliedByImperialDividingUnitWithNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, LeftDenominatorQuantity>, LeftUnit>.multipliedByDividingUnitWithNumeratorAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDividingUnitWithNumeratorAsDenominator(
        right,
        rightNumeratorUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDividingMultipliedByUKImperialDividingUnitWithNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, LeftDenominatorQuantity>, LeftUnit>.multipliedByDividingUnitWithNumeratorAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByDividingUnitWithNumeratorAsDenominator(
        right,
        rightNumeratorUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingMultipliedByUSCustomaryDividingUnitWithNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, LeftDenominatorQuantity>, LeftUnit>.multipliedByDividingUnitWithNumeratorAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDividingUnitWithNumeratorAsDenominator(
        right,
        rightNumeratorUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividingMultipliedByMetricAndUKImperialDividingUnitWithNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, LeftDenominatorQuantity>, LeftUnit>.multipliedByDividingUnitWithNumeratorAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByDividingUnitWithNumeratorAsDenominator(
        right,
        rightNumeratorUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDividingMultipliedByMetricAndUSCustomaryDividingUnitWithNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, LeftDenominatorQuantity>, LeftUnit>.multipliedByDividingUnitWithNumeratorAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDividingUnitWithNumeratorAsDenominator(
        right,
        rightNumeratorUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                RightNumeratorQuantity,
                RightNumeratorUnit,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
