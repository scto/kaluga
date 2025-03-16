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

// Div<A, Mul<B, C>> * B -> Div<A, C>

@JvmName("dividingWithMultiplyingDenominatorMultipliedByDenominatorLeft")
fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
    LeftDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightQuantity>,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
    LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightQuantity, LeftDenominatorLeftAndRightUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
    LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
    TargetUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
    TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, LeftDenominatorRightQuantity>, TargetUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.multipliedByDenominatorLeft(
    right: UndefinedScientificValue<LeftDenominatorLeftAndRightQuantity, LeftDenominatorLeftAndRightUnit>,
    leftNumeratorUnitPerLeftDenominatorRightUnit: LeftNumeratorUnit.(LeftDenominatorRightUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.leftNumeratorUnitPerLeftDenominatorRightUnit(unit.denominator.right).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingDenominatorMultipliedByMetricAndImperialDenominatorLeft")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.multipliedByDenominatorLeft(
    right: UndefinedScientificValue<LeftDenominatorLeftAndRightQuantity, LeftDenominatorLeftAndRightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftAndRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightQuantity>,
        LeftDenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightQuantity, LeftDenominatorLeftAndRightUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDenominatorLeft(
        right,
        leftNumeratorUnitPerLeftDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDividingWithMultiplyingDenominatorMultipliedByMetricDenominatorLeft")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.multipliedByDenominatorLeft(
    right: UndefinedScientificValue<LeftDenominatorLeftAndRightQuantity, LeftDenominatorLeftAndRightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightQuantity>,
        LeftDenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightQuantity, LeftDenominatorLeftAndRightUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric =
    multipliedByDenominatorLeft(
        right,
        leftNumeratorUnitPerLeftDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDividingWithMultiplyingDenominatorMultipliedByImperialDenominatorLeft")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.multipliedByDenominatorLeft(
    right: UndefinedScientificValue<LeftDenominatorLeftAndRightQuantity, LeftDenominatorLeftAndRightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftAndRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightQuantity>,
        LeftDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightQuantity, LeftDenominatorLeftAndRightUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDenominatorLeft(
        right,
        leftNumeratorUnitPerLeftDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDividingWithMultiplyingDenominatorMultipliedByUKImperialDenominatorLeft")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.multipliedByDenominatorLeft(
    right: UndefinedScientificValue<LeftDenominatorLeftAndRightQuantity, LeftDenominatorLeftAndRightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightQuantity>,
        LeftDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightQuantity, LeftDenominatorLeftAndRightUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByDenominatorLeft(
        right,
        leftNumeratorUnitPerLeftDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingWithMultiplyingDenominatorMultipliedByUSCustomaryDenominatorLeft")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.multipliedByDenominatorLeft(
    right: UndefinedScientificValue<LeftDenominatorLeftAndRightQuantity, LeftDenominatorLeftAndRightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftAndRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightQuantity>,
        LeftDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightQuantity, LeftDenominatorLeftAndRightUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDenominatorLeft(
        right,
        leftNumeratorUnitPerLeftDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividingWithMultiplyingDenominatorMultipliedByMetricAndUKImperialDenominatorLeft")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.multipliedByDenominatorLeft(
    right: UndefinedScientificValue<LeftDenominatorLeftAndRightQuantity, LeftDenominatorLeftAndRightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightQuantity>,
        LeftDenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightQuantity, LeftDenominatorLeftAndRightUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByDenominatorLeft(
        right,
        leftNumeratorUnitPerLeftDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDividingWithMultiplyingDenominatorMultipliedByMetricAndUSCustomaryDenominatorLeft")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftAndRightUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.multipliedByDenominatorLeft(
    right: UndefinedScientificValue<LeftDenominatorLeftAndRightQuantity, LeftDenominatorLeftAndRightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftAndRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightQuantity>,
        LeftDenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightQuantity, LeftDenominatorLeftAndRightUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDenominatorLeft(
        right,
        leftNumeratorUnitPerLeftDenominatorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                LeftDenominatorRightQuantity,
                LeftDenominatorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
