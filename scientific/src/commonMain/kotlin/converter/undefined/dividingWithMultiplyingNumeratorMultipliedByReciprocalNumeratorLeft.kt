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
import kotlin.jvm.JvmName

// Div<Mul<A, B>, C> * Inv<A> -> Div<B, C>

@JvmName("dividingWithMultiplyingNumeratorMultipliedByReciprocalNumeratorLeft")
fun <
    LeftNumeratorLeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightReciprocalUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalQuantity>,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
    LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorLeftAndRightReciprocalUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
    LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
    RightUnit : UndefinedReciprocalUnit<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorLeftAndRightReciprocalUnit>,
    TargetUnit : UndefinedDividedUnit<LeftNumeratorRightQuantity, LeftNumeratorRightUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
    TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorRightQuantity, LeftDenominatorQuantity>, TargetUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorRightQuantity>, LeftDenominatorQuantity>, LeftUnit>.multipliedByReciprocalNumeratorLeft(
    right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftNumeratorLeftAndRightReciprocalQuantity>, RightUnit>,
    leftNumeratorRightUnitPerLeftDenominatorUnit: LeftNumeratorRightUnit.(LeftDenominatorUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.right.leftNumeratorRightUnitPerLeftDenominatorUnit(unit.denominator).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingNumeratorMultipliedByMetricAndImperialReciprocalNumeratorLeft")
infix fun <
    LeftNumeratorLeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightReciprocalUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorRightQuantity>, LeftDenominatorQuantity>, LeftUnit>.multipliedByReciprocalNumeratorLeft(
    right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftNumeratorLeftAndRightReciprocalQuantity>, RightUnit>,
) where
        LeftNumeratorLeftAndRightReciprocalUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalQuantity>,
        LeftNumeratorLeftAndRightReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftAndRightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftAndRightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorLeftAndRightReciprocalUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorLeftAndRightReciprocalUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByReciprocalNumeratorLeft(
        right,
        leftNumeratorRightUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDividingWithMultiplyingNumeratorMultipliedByMetricReciprocalNumeratorLeft")
infix fun <
    LeftNumeratorLeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightReciprocalUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorRightQuantity>, LeftDenominatorQuantity>, LeftUnit>.multipliedByReciprocalNumeratorLeft(
    right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftNumeratorLeftAndRightReciprocalQuantity>, RightUnit>,
) where
        LeftNumeratorLeftAndRightReciprocalUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalQuantity>,
        LeftNumeratorLeftAndRightReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorLeftAndRightReciprocalUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedReciprocalUnit<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorLeftAndRightReciprocalUnit>,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedByReciprocalNumeratorLeft(
        right,
        leftNumeratorRightUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDividingWithMultiplyingNumeratorMultipliedByImperialReciprocalNumeratorLeft")
infix fun <
    LeftNumeratorLeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightReciprocalUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorRightQuantity>, LeftDenominatorQuantity>, LeftUnit>.multipliedByReciprocalNumeratorLeft(
    right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftNumeratorLeftAndRightReciprocalQuantity>, RightUnit>,
) where
        LeftNumeratorLeftAndRightReciprocalUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalQuantity>,
        LeftNumeratorLeftAndRightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftAndRightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorLeftAndRightReciprocalUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorLeftAndRightReciprocalUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByReciprocalNumeratorLeft(
        right,
        leftNumeratorRightUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDividingWithMultiplyingNumeratorMultipliedByUKImperialReciprocalNumeratorLeft")
infix fun <
    LeftNumeratorLeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightReciprocalUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorRightQuantity>, LeftDenominatorQuantity>, LeftUnit>.multipliedByReciprocalNumeratorLeft(
    right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftNumeratorLeftAndRightReciprocalQuantity>, RightUnit>,
) where
        LeftNumeratorLeftAndRightReciprocalUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalQuantity>,
        LeftNumeratorLeftAndRightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorLeftAndRightReciprocalUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorLeftAndRightReciprocalUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByReciprocalNumeratorLeft(
        right,
        leftNumeratorRightUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingWithMultiplyingNumeratorMultipliedByUSCustomaryReciprocalNumeratorLeft")
infix fun <
    LeftNumeratorLeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightReciprocalUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorRightQuantity>, LeftDenominatorQuantity>, LeftUnit>.multipliedByReciprocalNumeratorLeft(
    right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftNumeratorLeftAndRightReciprocalQuantity>, RightUnit>,
) where
        LeftNumeratorLeftAndRightReciprocalUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalQuantity>,
        LeftNumeratorLeftAndRightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorLeftAndRightReciprocalUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorLeftAndRightReciprocalUnit>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByReciprocalNumeratorLeft(
        right,
        leftNumeratorRightUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividingWithMultiplyingNumeratorMultipliedByMetricAndUKImperialReciprocalNumeratorLeft")
infix fun <
    LeftNumeratorLeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightReciprocalUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorRightQuantity>, LeftDenominatorQuantity>, LeftUnit>.multipliedByReciprocalNumeratorLeft(
    right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftNumeratorLeftAndRightReciprocalQuantity>, RightUnit>,
) where
        LeftNumeratorLeftAndRightReciprocalUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalQuantity>,
        LeftNumeratorLeftAndRightReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftAndRightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorLeftAndRightReciprocalUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorLeftAndRightReciprocalUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByReciprocalNumeratorLeft(
        right,
        leftNumeratorRightUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDividingWithMultiplyingNumeratorMultipliedByMetricAndUSCustomaryReciprocalNumeratorLeft")
infix fun <
    LeftNumeratorLeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftNumeratorLeftAndRightReciprocalUnit,
    LeftNumeratorRightQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorRightQuantity>, LeftDenominatorQuantity>, LeftUnit>.multipliedByReciprocalNumeratorLeft(
    right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftNumeratorLeftAndRightReciprocalQuantity>, RightUnit>,
) where
        LeftNumeratorLeftAndRightReciprocalUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalQuantity>,
        LeftNumeratorLeftAndRightReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftAndRightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorLeftAndRightReciprocalUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<LeftNumeratorLeftAndRightReciprocalQuantity, LeftNumeratorLeftAndRightReciprocalUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByReciprocalNumeratorLeft(
        right,
        leftNumeratorRightUnitPerLeftDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                LeftNumeratorRightQuantity,
                LeftNumeratorRightUnit,
                LeftDenominatorQuantity,
                LeftDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
