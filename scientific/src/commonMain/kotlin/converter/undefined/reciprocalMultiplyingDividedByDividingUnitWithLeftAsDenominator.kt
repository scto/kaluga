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
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Inv<Mul<A, B>> / Div<C, A> -> Inv<Mul<B, C>>

@JvmName("reciprocalMultiplyingDividedByDividingUnitWithLeftAsDenominator")
fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorQuantity>,
    NumeratorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightQuantity>,
    NumeratorReciprocalUnit : UndefinedMultipliedUnit<
        NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
        NumeratorReciprocalLeftUnit,
        NumeratorReciprocalRightQuantity,
        NumeratorReciprocalRightUnit,
        >,
    NumeratorUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            NumeratorReciprocalRightQuantity,
            >,
        NumeratorReciprocalUnit,
        >,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
    DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorQuantity>,
    DenominatorUnit : UndefinedDividedUnit<
        DenominatorNumeratorQuantity,
        DenominatorNumeratorUnit,
        NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
        DenominatorDenominatorUnit,
        >,
    TargetReciprocalUnit : UndefinedMultipliedUnit<
        NumeratorReciprocalRightQuantity,
        NumeratorReciprocalRightUnit,
        DenominatorNumeratorQuantity,
        DenominatorNumeratorUnit,
        >,
    TargetUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalRightQuantity,
            DenominatorNumeratorQuantity,
            >,
        TargetReciprocalUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalRightQuantity,
                DenominatorNumeratorQuantity,
                >,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            NumeratorReciprocalRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
    numeratorReciprocalRightUnitXDenominatorNumeratorUnit: NumeratorReciprocalRightUnit.(DenominatorNumeratorUnit) -> TargetReciprocalUnit,
    reciprocalTargetUnit: TargetReciprocalUnit.() -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.inverse.right.numeratorReciprocalRightUnitXDenominatorNumeratorUnit(
    right.unit.numerator,
).reciprocalTargetUnit().byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalMultiplyingDividedByMetricAndImperialDividingUnitWithLeftAsDenominator")
infix fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftUnit,
    NumeratorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            NumeratorReciprocalRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorQuantity>,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightQuantity>,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            NumeratorReciprocalLeftUnit,
            NumeratorReciprocalRightQuantity,
            NumeratorReciprocalRightUnit,
            >,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
                NumeratorReciprocalRightQuantity,
                >,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorReciprocalRightUnitXDenominatorNumeratorUnit = { x(it) },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndImperial<
                UndefinedQuantityType.Multiplying<
                    NumeratorReciprocalRightQuantity,
                    DenominatorNumeratorQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndImperial<
                    NumeratorReciprocalRightQuantity,
                    NumeratorReciprocalRightUnit,
                    DenominatorNumeratorQuantity,
                    DenominatorNumeratorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricReciprocalMultiplyingDividedByMetricDividingUnitWithLeftAsDenominator")
infix fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftUnit,
    NumeratorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            NumeratorReciprocalRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorQuantity>,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightQuantity>,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            NumeratorReciprocalLeftUnit,
            NumeratorReciprocalRightQuantity,
            NumeratorReciprocalRightUnit,
            >,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
                NumeratorReciprocalRightQuantity,
                >,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(
        right,
        numeratorReciprocalRightUnitXDenominatorNumeratorUnit = { x(it) },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Metric<
                UndefinedQuantityType.Multiplying<
                    NumeratorReciprocalRightQuantity,
                    DenominatorNumeratorQuantity,
                    >,
                UndefinedMultipliedUnit.Metric<
                    NumeratorReciprocalRightQuantity,
                    NumeratorReciprocalRightUnit,
                    DenominatorNumeratorQuantity,
                    DenominatorNumeratorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialReciprocalMultiplyingDividedByImperialDividingUnitWithLeftAsDenominator")
infix fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftUnit,
    NumeratorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            NumeratorReciprocalRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorQuantity>,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightQuantity>,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            NumeratorReciprocalLeftUnit,
            NumeratorReciprocalRightQuantity,
            NumeratorReciprocalRightUnit,
            >,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
                NumeratorReciprocalRightQuantity,
                >,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorReciprocalRightUnitXDenominatorNumeratorUnit = { x(it) },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Imperial<
                UndefinedQuantityType.Multiplying<
                    NumeratorReciprocalRightQuantity,
                    DenominatorNumeratorQuantity,
                    >,
                UndefinedMultipliedUnit.Imperial<
                    NumeratorReciprocalRightQuantity,
                    NumeratorReciprocalRightUnit,
                    DenominatorNumeratorQuantity,
                    DenominatorNumeratorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialReciprocalMultiplyingDividedByUKImperialDividingUnitWithLeftAsDenominator")
infix fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftUnit,
    NumeratorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            NumeratorReciprocalRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorQuantity>,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightQuantity>,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            NumeratorReciprocalLeftUnit,
            NumeratorReciprocalRightQuantity,
            NumeratorReciprocalRightUnit,
            >,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
                NumeratorReciprocalRightQuantity,
                >,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorReciprocalRightUnitXDenominatorNumeratorUnit = { x(it) },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.UKImperial<
                UndefinedQuantityType.Multiplying<
                    NumeratorReciprocalRightQuantity,
                    DenominatorNumeratorQuantity,
                    >,
                UndefinedMultipliedUnit.UKImperial<
                    NumeratorReciprocalRightQuantity,
                    NumeratorReciprocalRightUnit,
                    DenominatorNumeratorQuantity,
                    DenominatorNumeratorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryReciprocalMultiplyingDividedByUSCustomaryDividingUnitWithLeftAsDenominator")
infix fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftUnit,
    NumeratorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            NumeratorReciprocalRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorQuantity>,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightQuantity>,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            NumeratorReciprocalLeftUnit,
            NumeratorReciprocalRightQuantity,
            NumeratorReciprocalRightUnit,
            >,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
                NumeratorReciprocalRightQuantity,
                >,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorReciprocalRightUnitXDenominatorNumeratorUnit = { x(it) },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.USCustomary<
                UndefinedQuantityType.Multiplying<
                    NumeratorReciprocalRightQuantity,
                    DenominatorNumeratorQuantity,
                    >,
                UndefinedMultipliedUnit.USCustomary<
                    NumeratorReciprocalRightQuantity,
                    NumeratorReciprocalRightUnit,
                    DenominatorNumeratorQuantity,
                    DenominatorNumeratorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialReciprocalMultiplyingDividedByMetricAndUKImperialDividingUnitWithLeftAsDenominator")
infix fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftUnit,
    NumeratorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            NumeratorReciprocalRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorQuantity>,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightQuantity>,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            NumeratorReciprocalLeftUnit,
            NumeratorReciprocalRightQuantity,
            NumeratorReciprocalRightUnit,
            >,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
                NumeratorReciprocalRightQuantity,
                >,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorReciprocalRightUnitXDenominatorNumeratorUnit = { x(it) },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUKImperial<
                UndefinedQuantityType.Multiplying<
                    NumeratorReciprocalRightQuantity,
                    DenominatorNumeratorQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUKImperial<
                    NumeratorReciprocalRightQuantity,
                    NumeratorReciprocalRightUnit,
                    DenominatorNumeratorQuantity,
                    DenominatorNumeratorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryReciprocalMultiplyingDividedByMetricAndUSCustomaryDividingUnitWithLeftAsDenominator")
infix fun <
    NumeratorReciprocalLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
    NumeratorReciprocalLeftUnit,
    NumeratorReciprocalRightQuantity : UndefinedQuantityType,
    NumeratorReciprocalRightUnit,
    NumeratorReciprocalUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            NumeratorReciprocalRightQuantity,
            >,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorQuantity>,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightQuantity>,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorReciprocalUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            NumeratorReciprocalLeftUnit,
            NumeratorReciprocalRightQuantity,
            NumeratorReciprocalRightUnit,
            >,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
                NumeratorReciprocalRightQuantity,
                >,
            NumeratorReciprocalUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorQuantity>,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            NumeratorReciprocalLeftAndDenominatorDenominatorQuantity,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorReciprocalRightUnitXDenominatorNumeratorUnit = { x(it) },
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
                UndefinedQuantityType.Multiplying<
                    NumeratorReciprocalRightQuantity,
                    DenominatorNumeratorQuantity,
                    >,
                UndefinedMultipliedUnit.MetricAndUSCustomary<
                    NumeratorReciprocalRightQuantity,
                    NumeratorReciprocalRightUnit,
                    DenominatorNumeratorQuantity,
                    DenominatorNumeratorUnit,
                    >,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
