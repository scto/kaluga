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

// Mul<A, A> / Div<Mul<A, B>, C> -> Div<Mul<A, C>, B>

@JvmName("multiplyingDividedByDividingUnitWithMultiplyingNumeratorWithLeftAsLeftAndRightAsLeft")
fun <
    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity>,
    NumeratorUnit : UndefinedMultipliedUnit<
        NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
        NumeratorLeftAndRightUnit,
        NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
        NumeratorLeftAndRightUnit,
        >,
    DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity>,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
    DenominatorNumeratorUnit : UndefinedMultipliedUnit<
        NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
        DenominatorNumeratorLeftUnit,
        DenominatorNumeratorRightQuantity,
        DenominatorNumeratorRightUnit,
        >,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
    DenominatorUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            DenominatorNumeratorRightQuantity,
            >,
        DenominatorNumeratorUnit,
        DenominatorDenominatorQuantity,
        DenominatorDenominatorUnit,
        >,
    TargetNumeratorUnit : UndefinedMultipliedUnit<
        NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
        NumeratorLeftAndRightUnit,
        DenominatorDenominatorQuantity,
        DenominatorDenominatorUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            DenominatorDenominatorQuantity,
            >,
        TargetNumeratorUnit,
        DenominatorNumeratorRightQuantity,
        DenominatorNumeratorRightUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                DenominatorDenominatorQuantity,
                >,
            DenominatorNumeratorRightQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
        NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                DenominatorNumeratorRightQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
    numeratorLeftAndRightUnitXDenominatorDenominatorUnit: NumeratorLeftAndRightUnit.(DenominatorDenominatorUnit) -> TargetNumeratorUnit,
    targetNumeratorUnitPerDenominatorNumeratorRightUnit: TargetNumeratorUnit.(DenominatorNumeratorRightUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.left.numeratorLeftAndRightUnitXDenominatorDenominatorUnit(
    right.unit.denominator,
).targetNumeratorUnitPerDenominatorNumeratorRightUnit(
    right.unit.numerator.right,
).byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingDividedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithLeftAsLeftAndRightAsLeft")
infix fun <
    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
        NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                DenominatorNumeratorRightQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            NumeratorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            NumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            DenominatorNumeratorLeftUnit,
            DenominatorNumeratorRightQuantity,
            DenominatorNumeratorRightUnit,
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
                NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                DenominatorNumeratorRightQuantity,
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
        numeratorLeftAndRightUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerDenominatorNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                UndefinedQuantityType.Multiplying<
                    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                    DenominatorDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndImperial<
                    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                    NumeratorLeftAndRightUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                DenominatorNumeratorRightQuantity,
                DenominatorNumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricMultiplyingDividedByMetricDividingUnitWithMultiplyingNumeratorWithLeftAsLeftAndRightAsLeft")
infix fun <
    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
        NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                DenominatorNumeratorRightQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            NumeratorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            NumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            DenominatorNumeratorLeftUnit,
            DenominatorNumeratorRightQuantity,
            DenominatorNumeratorRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                DenominatorNumeratorRightQuantity,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(
        right,
        numeratorLeftAndRightUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerDenominatorNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                UndefinedQuantityType.Multiplying<
                    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                    DenominatorDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.Metric<
                    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                    NumeratorLeftAndRightUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                DenominatorNumeratorRightQuantity,
                DenominatorNumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialMultiplyingDividedByImperialDividingUnitWithMultiplyingNumeratorWithLeftAsLeftAndRightAsLeft")
infix fun <
    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
        NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                DenominatorNumeratorRightQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            NumeratorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            NumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            DenominatorNumeratorLeftUnit,
            DenominatorNumeratorRightQuantity,
            DenominatorNumeratorRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                DenominatorNumeratorRightQuantity,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorLeftAndRightUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerDenominatorNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                UndefinedQuantityType.Multiplying<
                    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                    DenominatorDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.Imperial<
                    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                    NumeratorLeftAndRightUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                DenominatorNumeratorRightQuantity,
                DenominatorNumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialMultiplyingDividedByUKImperialDividingUnitWithMultiplyingNumeratorWithLeftAsLeftAndRightAsLeft")
infix fun <
    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
        NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                DenominatorNumeratorRightQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            NumeratorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            NumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            DenominatorNumeratorLeftUnit,
            DenominatorNumeratorRightQuantity,
            DenominatorNumeratorRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                DenominatorNumeratorRightQuantity,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorLeftAndRightUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerDenominatorNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                UndefinedQuantityType.Multiplying<
                    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                    DenominatorDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.UKImperial<
                    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                    NumeratorLeftAndRightUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                DenominatorNumeratorRightQuantity,
                DenominatorNumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryMultiplyingDividedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithLeftAsLeftAndRightAsLeft")
infix fun <
    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
        NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                DenominatorNumeratorRightQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            NumeratorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            NumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            DenominatorNumeratorLeftUnit,
            DenominatorNumeratorRightQuantity,
            DenominatorNumeratorRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                DenominatorNumeratorRightQuantity,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorLeftAndRightUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerDenominatorNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                UndefinedQuantityType.Multiplying<
                    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                    DenominatorDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.USCustomary<
                    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                    NumeratorLeftAndRightUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                DenominatorNumeratorRightQuantity,
                DenominatorNumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultiplyingDividedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithLeftAsLeftAndRightAsLeft")
infix fun <
    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
        NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                DenominatorNumeratorRightQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            NumeratorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            NumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            DenominatorNumeratorLeftUnit,
            DenominatorNumeratorRightQuantity,
            DenominatorNumeratorRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                DenominatorNumeratorRightQuantity,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorLeftAndRightUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerDenominatorNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                UndefinedQuantityType.Multiplying<
                    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                    DenominatorDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUKImperial<
                    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                    NumeratorLeftAndRightUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                DenominatorNumeratorRightQuantity,
                DenominatorNumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultiplyingDividedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithLeftAsLeftAndRightAsLeft")
infix fun <
    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
    NumeratorLeftAndRightUnit,
    NumeratorUnit,
    DenominatorNumeratorLeftUnit,
    DenominatorNumeratorRightQuantity : UndefinedQuantityType,
    DenominatorNumeratorRightUnit,
    DenominatorNumeratorUnit,
    DenominatorDenominatorQuantity : UndefinedQuantityType,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
        NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                DenominatorNumeratorRightQuantity,
                >,
            DenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorLeftAndRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity>,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            NumeratorLeftAndRightUnit,
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            NumeratorLeftAndRightUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity>,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
            DenominatorNumeratorLeftUnit,
            DenominatorNumeratorRightQuantity,
            DenominatorNumeratorRightUnit,
            >,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                DenominatorNumeratorRightQuantity,
                >,
            DenominatorNumeratorUnit,
            DenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorLeftAndRightUnitXDenominatorDenominatorUnit = { x(it) },
        targetNumeratorUnitPerDenominatorNumeratorRightUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                UndefinedQuantityType.Multiplying<
                    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                    DenominatorDenominatorQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUSCustomary<
                    NumeratorLeftAndRightAndDenominatorNumeratorLeftQuantity,
                    NumeratorLeftAndRightUnit,
                    DenominatorDenominatorQuantity,
                    DenominatorDenominatorUnit,
                    >,
                DenominatorNumeratorRightQuantity,
                DenominatorNumeratorRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
