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
import kotlin.jvm.JvmName

// A / Div<Mul<B, A>, C> -> Div<C, B>

@JvmName("dividedByDividingUnitWithMultiplyingNumeratorWithSelfAsRight")
fun <
    NumeratorAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorRightQuantity>,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
    DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorAndDenominatorNumeratorRightQuantity, NumeratorAndDenominatorNumeratorRightUnit>,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
    DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
    TargetUnit : UndefinedDividedUnit<DenominatorDenominatorQuantity, DenominatorDenominatorUnit, DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit>,
    TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<DenominatorDenominatorQuantity, DenominatorNumeratorLeftQuantity>, TargetUnit>,
    > UndefinedScientificValue<NumeratorAndDenominatorNumeratorRightQuantity, NumeratorAndDenominatorNumeratorRightUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithSelfAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
    denominatorDenominatorUnitPerDenominatorNumeratorLeftUnit: DenominatorDenominatorUnit.(DenominatorNumeratorLeftUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.denominator.denominatorDenominatorUnitPerDenominatorNumeratorLeftUnit(right.unit.numerator.left).byDividing(this, right, factory)

@JvmName("metricAndImperialDividedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorNumeratorRightUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<NumeratorAndDenominatorNumeratorRightQuantity, NumeratorAndDenominatorNumeratorRightUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithSelfAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorRightQuantity>,
        NumeratorAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorAndDenominatorNumeratorRightQuantity, NumeratorAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByDividingUnitWithMultiplyingNumeratorWithSelfAsRight(
        right,
        denominatorDenominatorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDividedByMetricDividingUnitWithMultiplyingNumeratorWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorNumeratorRightUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<NumeratorAndDenominatorNumeratorRightQuantity, NumeratorAndDenominatorNumeratorRightUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithSelfAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorRightQuantity>,
        NumeratorAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorAndDenominatorNumeratorRightQuantity, NumeratorAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedByDividingUnitWithMultiplyingNumeratorWithSelfAsRight(
        right,
        denominatorDenominatorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDividedByImperialDividingUnitWithMultiplyingNumeratorWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorNumeratorRightUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<NumeratorAndDenominatorNumeratorRightQuantity, NumeratorAndDenominatorNumeratorRightUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithSelfAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorRightQuantity>,
        NumeratorAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorAndDenominatorNumeratorRightQuantity, NumeratorAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByDividingUnitWithMultiplyingNumeratorWithSelfAsRight(
        right,
        denominatorDenominatorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDividedByUKImperialDividingUnitWithMultiplyingNumeratorWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorNumeratorRightUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<NumeratorAndDenominatorNumeratorRightQuantity, NumeratorAndDenominatorNumeratorRightUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithSelfAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorRightQuantity>,
        NumeratorAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorAndDenominatorNumeratorRightQuantity, NumeratorAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedByDividingUnitWithMultiplyingNumeratorWithSelfAsRight(
        right,
        denominatorDenominatorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDividedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorNumeratorRightUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<NumeratorAndDenominatorNumeratorRightQuantity, NumeratorAndDenominatorNumeratorRightUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithSelfAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorRightQuantity>,
        NumeratorAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorAndDenominatorNumeratorRightQuantity, NumeratorAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByDividingUnitWithMultiplyingNumeratorWithSelfAsRight(
        right,
        denominatorDenominatorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorNumeratorRightUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<NumeratorAndDenominatorNumeratorRightQuantity, NumeratorAndDenominatorNumeratorRightUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithSelfAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorRightQuantity>,
        NumeratorAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorAndDenominatorNumeratorRightQuantity, NumeratorAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedByDividingUnitWithMultiplyingNumeratorWithSelfAsRight(
        right,
        denominatorDenominatorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDividedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithSelfAsRight")
infix fun <
    NumeratorAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorAndDenominatorNumeratorRightUnit,
    DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<NumeratorAndDenominatorNumeratorRightQuantity, NumeratorAndDenominatorNumeratorRightUnit>.dividedByDividingUnitWithMultiplyingNumeratorWithSelfAsRight(
    right:
    UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
) where
        NumeratorAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorRightQuantity>,
        NumeratorAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorAndDenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorAndDenominatorNumeratorRightQuantity, NumeratorAndDenominatorNumeratorRightUnit>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByDividingUnitWithMultiplyingNumeratorWithSelfAsRight(
        right,
        denominatorDenominatorUnitPerDenominatorNumeratorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                DenominatorDenominatorQuantity,
                DenominatorDenominatorUnit,
                DenominatorNumeratorLeftQuantity,
                DenominatorNumeratorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
