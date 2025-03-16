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
import kotlin.jvm.JvmName

// Div<B, Mul<A, D>> * Div<A, B> -> Inv<D>

@JvmName("dividingWithMultiplyingDenominatorMultipliedByDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator")
fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
    LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
    LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
    LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
    RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
    TargetUnit : UndefinedReciprocalUnit<LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
    TargetValue : UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftDenominatorRightQuantity>, TargetUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.multipliedByDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
    reciprocalTargetUnit: LeftDenominatorRightUnit.() -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.denominator.right.reciprocalTargetUnit().byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingDenominatorMultipliedByMetricAndImperialDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.multipliedByDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndImperial<
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDividingWithMultiplyingDenominatorMultipliedByMetricDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.multipliedByDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedByDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Metric<
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDividingWithMultiplyingDenominatorMultipliedByImperialDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.multipliedByDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Imperial<
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDividingWithMultiplyingDenominatorMultipliedByUKImperialDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.multipliedByDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.UKImperial<
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingWithMultiplyingDenominatorMultipliedByUSCustomaryDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.multipliedByDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.USCustomary<
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividingWithMultiplyingDenominatorMultipliedByMetricAndUKImperialDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.multipliedByDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUKImperial<
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDividingWithMultiplyingDenominatorMultipliedByMetricAndUSCustomaryDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorAndRightDenominatorUnit,
    LeftDenominatorLeftAndRightNumeratorQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightNumeratorUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightDenominatorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.multipliedByDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator(
    right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorLeftAndRightNumeratorQuantity, LeftNumeratorAndRightDenominatorQuantity>, RightUnit>,
) where
        LeftNumeratorAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorAndRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorQuantity>,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<LeftDenominatorLeftAndRightNumeratorQuantity, LeftDenominatorLeftAndRightNumeratorUnit, LeftNumeratorAndRightDenominatorQuantity, LeftNumeratorAndRightDenominatorUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDividingUnitWithDenominatorLeftAsNumeratorAndNumeratorAsDenominator(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
