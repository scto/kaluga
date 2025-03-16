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
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Mul<A, B> / Div<Mul<C, B>, D> -> Div<Mul<A, D>, C>

@JvmName("multiplyingDividedByDividingUnitWithMultiplyingNumeratorWithRightAsRight")
fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
    NumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
    NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftQuantity, NumeratorLeftUnit, NumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorRightAndDenominatorNumeratorRightUnit>,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
    DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorRightAndDenominatorNumeratorRightUnit>,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
    DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
    TargetNumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftQuantity, NumeratorLeftUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
    TargetUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, DenominatorDenominatorQuantity>, TargetNumeratorUnit, DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit>,
    TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, DenominatorDenominatorQuantity>, DenominatorNumeratorLeftQuantity>, TargetUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithRightAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
    numeratorLeftUnitXDenominatorDenominatorUnit: NumeratorLeftUnit.(DenominatorDenominatorUnit) -> TargetNumeratorUnit,
    targetNumeratorUnitPerDenominatorNumeratorLeftUnit: TargetNumeratorUnit.(DenominatorNumeratorLeftUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.left.numeratorLeftUnitXDenominatorDenominatorUnit(
    right.unit.denominator,
).targetNumeratorUnitPerDenominatorNumeratorLeftUnit(right.unit.numerator.left).byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingDividedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithRightAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
        NumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftQuantity, NumeratorLeftUnit, NumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorRightAndDenominatorNumeratorRightUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorRightAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByDividingUnitWithMultiplyingNumeratorWithRightAsRight(
        right,
        numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, DenominatorDenominatorQuantity>,
                UndefinedMultipliedUnit.MetricAndImperial<
                    NumeratorLeftQuantity,
                    NumeratorLeftUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricMultiplyingDividedByMetricDividingUnitWithMultiplyingNumeratorWithRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithRightAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
        NumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftQuantity, NumeratorLeftUnit, NumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorRightAndDenominatorNumeratorRightUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorRightAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedByDividingUnitWithMultiplyingNumeratorWithRightAsRight(
        right,
        numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, DenominatorDenominatorQuantity>,
                UndefinedMultipliedUnit.Metric<
                    NumeratorLeftQuantity,
                    NumeratorLeftUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialMultiplyingDividedByImperialDividingUnitWithMultiplyingNumeratorWithRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithRightAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
        NumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftQuantity, NumeratorLeftUnit, NumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorRightAndDenominatorNumeratorRightUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorRightAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByDividingUnitWithMultiplyingNumeratorWithRightAsRight(
        right,
        numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, DenominatorDenominatorQuantity>,
                UndefinedMultipliedUnit.Imperial<
                    NumeratorLeftQuantity,
                    NumeratorLeftUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialMultiplyingDividedByUKImperialDividingUnitWithMultiplyingNumeratorWithRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithRightAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
        NumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftQuantity, NumeratorLeftUnit, NumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorRightAndDenominatorNumeratorRightUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorRightAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedByDividingUnitWithMultiplyingNumeratorWithRightAsRight(
        right,
        numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, DenominatorDenominatorQuantity>,
                UndefinedMultipliedUnit.UKImperial<
                    NumeratorLeftQuantity,
                    NumeratorLeftUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryMultiplyingDividedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithRightAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
        NumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftQuantity, NumeratorLeftUnit, NumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorRightAndDenominatorNumeratorRightUnit>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorRightAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByDividingUnitWithMultiplyingNumeratorWithRightAsRight(
        right,
        numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, DenominatorDenominatorQuantity>,
                UndefinedMultipliedUnit.USCustomary<
                    NumeratorLeftQuantity,
                    NumeratorLeftUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultiplyingDividedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithRightAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
        NumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftQuantity, NumeratorLeftUnit, NumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorRightAndDenominatorNumeratorRightUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorRightAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedByDividingUnitWithMultiplyingNumeratorWithRightAsRight(
        right,
        numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, DenominatorDenominatorQuantity>,
                UndefinedMultipliedUnit.MetricAndUKImperial<
                    NumeratorLeftQuantity,
                    NumeratorLeftUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultiplyingDividedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorRightAndDenominatorNumeratorRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, NumeratorUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithRightAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
        NumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftQuantity, NumeratorLeftUnit, NumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorRightAndDenominatorNumeratorRightUnit>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorRightAndDenominatorNumeratorRightQuantity, NumeratorRightAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorRightAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByDividingUnitWithMultiplyingNumeratorWithRightAsRight(
        right,
        numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, DenominatorDenominatorQuantity>,
                UndefinedMultipliedUnit.MetricAndUSCustomary<
                    NumeratorLeftQuantity,
                    NumeratorLeftUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
