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
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Mul<A, B> * Div<C, Mul<D, A>> -> Div<Mul<B, C>, D>

@JvmName("multiplyingMultipliedByDividingUnitWithMultiplyingDenominatorWithLeftAsRight")
fun <
    LeftLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
    LeftRightQuantity : UndefinedQuantityType,
    LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
    LeftUnit : UndefinedMultipliedUnit<
        LeftLeftAndRightDenominatorRightQuantity,
        LeftLeftUnit,
        LeftRightQuantity,
        LeftRightUnit,
        >,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
    RightDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
    RightDenominatorUnit : UndefinedMultipliedUnit<
        RightDenominatorLeftQuantity,
        RightDenominatorLeftUnit,
        LeftLeftAndRightDenominatorRightQuantity,
        RightDenominatorRightUnit,
        >,
    RightUnit : UndefinedDividedUnit<
        RightNumeratorQuantity,
        RightNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            RightDenominatorLeftQuantity,
            LeftLeftAndRightDenominatorRightQuantity,
            >,
        RightDenominatorUnit,
        >,
    TargetNumeratorUnit : UndefinedMultipliedUnit<
        LeftRightQuantity,
        LeftRightUnit,
        RightNumeratorQuantity,
        RightNumeratorUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            LeftRightQuantity,
            RightNumeratorQuantity,
            >,
        TargetNumeratorUnit,
        RightDenominatorLeftQuantity,
        RightDenominatorLeftUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                LeftRightQuantity,
                RightNumeratorQuantity,
                >,
            RightDenominatorLeftQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightDenominatorRightQuantity,
        LeftRightQuantity,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                RightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
    leftRightUnitXRightNumeratorUnit: LeftRightUnit.(RightNumeratorUnit) -> TargetNumeratorUnit,
    targetNumeratorUnitPerRightDenominatorLeftUnit: TargetNumeratorUnit.(RightDenominatorLeftUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.right.leftRightUnitXRightNumeratorUnit(
    right.unit.numerator,
).targetNumeratorUnitPerRightDenominatorLeftUnit(
    right.unit.denominator.left,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultiplyingMultipliedByMetricAndImperialDividingUnitWithMultiplyingDenominatorWithLeftAsRight")
infix fun <
    LeftLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightDenominatorRightQuantity,
        LeftRightQuantity,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                RightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightDenominatorRightQuantity,
            LeftLeftUnit,
            LeftRightQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            RightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                RightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftRightUnitXRightNumeratorUnit = { x(it) },
        targetNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                UndefinedQuantityType.Multiplying<
                    LeftRightQuantity,
                    RightNumeratorQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndImperial<
                    LeftRightQuantity,
                    LeftRightUnit,
                    RightNumeratorQuantity,
                    RightNumeratorUnit,
                    >,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricMultiplyingMultipliedByMetricDividingUnitWithMultiplyingDenominatorWithLeftAsRight")
infix fun <
    LeftLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightDenominatorRightQuantity,
        LeftRightQuantity,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                RightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightDenominatorRightQuantity,
            LeftLeftUnit,
            LeftRightQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            RightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                RightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(
        right,
        leftRightUnitXRightNumeratorUnit = { x(it) },
        targetNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                UndefinedQuantityType.Multiplying<
                    LeftRightQuantity,
                    RightNumeratorQuantity,
                    >,
                UndefinedMultipliedUnit.Metric<
                    LeftRightQuantity,
                    LeftRightUnit,
                    RightNumeratorQuantity,
                    RightNumeratorUnit,
                    >,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialMultiplyingMultipliedByImperialDividingUnitWithMultiplyingDenominatorWithLeftAsRight")
infix fun <
    LeftLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightDenominatorRightQuantity,
        LeftRightQuantity,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                RightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightDenominatorRightQuantity,
            LeftLeftUnit,
            LeftRightQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            RightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                RightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftRightUnitXRightNumeratorUnit = { x(it) },
        targetNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                UndefinedQuantityType.Multiplying<
                    LeftRightQuantity,
                    RightNumeratorQuantity,
                    >,
                UndefinedMultipliedUnit.Imperial<
                    LeftRightQuantity,
                    LeftRightUnit,
                    RightNumeratorQuantity,
                    RightNumeratorUnit,
                    >,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialMultiplyingMultipliedByUKImperialDividingUnitWithMultiplyingDenominatorWithLeftAsRight")
infix fun <
    LeftLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightDenominatorRightQuantity,
        LeftRightQuantity,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                RightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightDenominatorRightQuantity,
            LeftLeftUnit,
            LeftRightQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            RightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                RightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftRightUnitXRightNumeratorUnit = { x(it) },
        targetNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                UndefinedQuantityType.Multiplying<
                    LeftRightQuantity,
                    RightNumeratorQuantity,
                    >,
                UndefinedMultipliedUnit.UKImperial<
                    LeftRightQuantity,
                    LeftRightUnit,
                    RightNumeratorQuantity,
                    RightNumeratorUnit,
                    >,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryMultiplyingMultipliedByUSCustomaryDividingUnitWithMultiplyingDenominatorWithLeftAsRight")
infix fun <
    LeftLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightDenominatorRightQuantity,
        LeftRightQuantity,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                RightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightDenominatorRightQuantity,
            LeftLeftUnit,
            LeftRightQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            RightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                RightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftRightUnitXRightNumeratorUnit = { x(it) },
        targetNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                UndefinedQuantityType.Multiplying<
                    LeftRightQuantity,
                    RightNumeratorQuantity,
                    >,
                UndefinedMultipliedUnit.USCustomary<
                    LeftRightQuantity,
                    LeftRightUnit,
                    RightNumeratorQuantity,
                    RightNumeratorUnit,
                    >,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultiplyingMultipliedByMetricAndUKImperialDividingUnitWithMultiplyingDenominatorWithLeftAsRight")
infix fun <
    LeftLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightDenominatorRightQuantity,
        LeftRightQuantity,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                RightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightDenominatorRightQuantity,
            LeftLeftUnit,
            LeftRightQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            RightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                RightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftRightUnitXRightNumeratorUnit = { x(it) },
        targetNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                UndefinedQuantityType.Multiplying<
                    LeftRightQuantity,
                    RightNumeratorQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUKImperial<
                    LeftRightQuantity,
                    LeftRightUnit,
                    RightNumeratorQuantity,
                    RightNumeratorUnit,
                    >,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultiplyingMultipliedByMetricAndUSCustomaryDividingUnitWithMultiplyingDenominatorWithLeftAsRight")
infix fun <
    LeftLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    RightDenominatorLeftQuantity : UndefinedQuantityType,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightDenominatorRightQuantity,
        LeftRightQuantity,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                RightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightDenominatorRightQuantity,
            LeftLeftUnit,
            LeftRightQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            RightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                RightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftRightUnitXRightNumeratorUnit = { x(it) },
        targetNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                UndefinedQuantityType.Multiplying<
                    LeftRightQuantity,
                    RightNumeratorQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUSCustomary<
                    LeftRightQuantity,
                    LeftRightUnit,
                    RightNumeratorQuantity,
                    RightNumeratorUnit,
                    >,
                RightDenominatorLeftQuantity,
                RightDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
