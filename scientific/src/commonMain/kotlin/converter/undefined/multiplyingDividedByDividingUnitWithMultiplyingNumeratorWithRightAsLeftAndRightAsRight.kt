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
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Mul<A, B> / Div<Mul<B, B>, C> -> Div<Mul<A, C>, B>

@JvmName("multiplyingDividedByDividingUnitWithMultiplyingNumeratorWithRightAsLeftAndRightAsRight")
fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftQuantity>,
    NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity>,
    NumeratorUnit : UndefinedMultipliedUnit<
        NumeratorLeftQuantity,
        NumeratorLeftUnit,
        NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
        NumeratorRightUnit,
        >,
    DenominatorNumeratorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity>,
    DenominatorNumeratorUnit : UndefinedMultipliedUnit<
        NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
        DenominatorNumeratorLeftAndRightUnit,
        NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
        DenominatorNumeratorLeftAndRightUnit,
        >,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
    DenominatorUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            >,
        DenominatorNumeratorUnit,
        DenominatorDenominatorQuantity,
        DenominatorDenominatorUnit,
        >,
    TargetNumeratorUnit : UndefinedMultipliedUnit<
        NumeratorLeftQuantity,
        NumeratorLeftUnit,
        DenominatorDenominatorQuantity,
        DenominatorDenominatorUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftQuantity,
            DenominatorDenominatorQuantity,
            >,
        TargetNumeratorUnit,
        NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
        NumeratorRightUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                NumeratorLeftQuantity,
                DenominatorDenominatorQuantity,
                >,
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
    numeratorLeftUnitXDenominatorDenominatorUnit: NumeratorLeftUnit.(DenominatorDenominatorUnit) -> TargetNumeratorUnit,
    targetNumeratorUnitPerNumeratorRightUnit: TargetNumeratorUnit.(NumeratorRightUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.left.numeratorLeftUnitXDenominatorDenominatorUnit(
    right.unit.denominator,
).targetNumeratorUnitPerNumeratorRightUnit(
    unit.right,
).byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingDividedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithRightAsLeftAndRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftAndRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity>,
        DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            DenominatorNumeratorLeftAndRightUnit,
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            DenominatorNumeratorLeftAndRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                UndefinedQuantityType.Multiplying<
                    NumeratorLeftQuantity,
                    DenominatorDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndImperial<
                    NumeratorLeftQuantity,
                    NumeratorLeftUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricMultiplyingDividedByMetricDividingUnitWithMultiplyingNumeratorWithRightAsLeftAndRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftAndRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity>,
        DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            DenominatorNumeratorLeftAndRightUnit,
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            DenominatorNumeratorLeftAndRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(
        right,
        numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                UndefinedQuantityType.Multiplying<
                    NumeratorLeftQuantity,
                    DenominatorDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.Metric<
                    NumeratorLeftQuantity,
                    NumeratorLeftUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialMultiplyingDividedByImperialDividingUnitWithMultiplyingNumeratorWithRightAsLeftAndRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftAndRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity>,
        DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            DenominatorNumeratorLeftAndRightUnit,
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            DenominatorNumeratorLeftAndRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                UndefinedQuantityType.Multiplying<
                    NumeratorLeftQuantity,
                    DenominatorDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.Imperial<
                    NumeratorLeftQuantity,
                    NumeratorLeftUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialMultiplyingDividedByUKImperialDividingUnitWithMultiplyingNumeratorWithRightAsLeftAndRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftAndRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity>,
        DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            DenominatorNumeratorLeftAndRightUnit,
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            DenominatorNumeratorLeftAndRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                UndefinedQuantityType.Multiplying<
                    NumeratorLeftQuantity,
                    DenominatorDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.UKImperial<
                    NumeratorLeftQuantity,
                    NumeratorLeftUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryMultiplyingDividedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithRightAsLeftAndRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftAndRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity>,
        DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            DenominatorNumeratorLeftAndRightUnit,
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            DenominatorNumeratorLeftAndRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                UndefinedQuantityType.Multiplying<
                    NumeratorLeftQuantity,
                    DenominatorDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.USCustomary<
                    NumeratorLeftQuantity,
                    NumeratorLeftUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultiplyingDividedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithRightAsLeftAndRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftAndRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity>,
        DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            DenominatorNumeratorLeftAndRightUnit,
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            DenominatorNumeratorLeftAndRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                UndefinedQuantityType.Multiplying<
                    NumeratorLeftQuantity,
                    DenominatorDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUKImperial<
                    NumeratorLeftQuantity,
                    NumeratorLeftUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultiplyingDividedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithRightAsLeftAndRightAsRight")
infix fun <
    NumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftUnit,
    NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
    NumeratorRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftAndRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftQuantity,
        NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftQuantity>,
        NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity>,
        NumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftQuantity,
            NumeratorLeftUnit,
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            NumeratorRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity>,
        DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            DenominatorNumeratorLeftAndRightUnit,
            NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
            DenominatorNumeratorLeftAndRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                UndefinedQuantityType.Multiplying<
                    NumeratorLeftQuantity,
                    DenominatorDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUSCustomary<
                    NumeratorLeftQuantity,
                    NumeratorLeftUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                NumeratorRightAndDenominatorNumeratorLeftAndRightQuantity,
                NumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
