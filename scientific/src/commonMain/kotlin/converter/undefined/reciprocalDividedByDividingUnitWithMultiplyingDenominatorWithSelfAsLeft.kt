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
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// Inv<A> / Div<C, Mul<A, B>> -> Div<B, C>

@JvmName("reciprocalDividedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
fun <
    NumeratorReciprocalAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
    NumeratorUnit : UndefinedReciprocalUnit<
        NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
        >,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
    DenominatorDenominatorRightQuantity : UndefinedQuantityType,
    DenominatorDenominatorRightUnit : UndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
    DenominatorDenominatorUnit : UndefinedMultipliedUnit<
        NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
        DenominatorDenominatorRightQuantity,
        DenominatorDenominatorRightUnit,
        >,
    DenominatorUnit : UndefinedDividedUnit<
        DenominatorNumeratorQuantity,
        DenominatorNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
            DenominatorDenominatorRightQuantity,
            >,
        DenominatorDenominatorUnit,
        >,
    TargetUnit : UndefinedDividedUnit<
        DenominatorDenominatorRightQuantity,
        DenominatorDenominatorRightUnit,
        DenominatorNumeratorQuantity,
        DenominatorNumeratorUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorDenominatorRightQuantity,
            DenominatorNumeratorQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
        >,
    NumeratorUnit,
    >.dividedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeft(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
                DenominatorDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
    denominatorDenominatorRightUnitPerDenominatorNumeratorUnit: DenominatorDenominatorRightUnit.(DenominatorNumeratorUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.denominator.right.denominatorDenominatorRightUnitPerDenominatorNumeratorUnit(
    right.unit.numerator,
).byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalDividedByMetricAndImperialDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
    NumeratorReciprocalAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorRightQuantity : UndefinedQuantityType,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
        >,
    NumeratorUnit,
    >.dividedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeft(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
                DenominatorDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorRightUnit : UndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
            DenominatorDenominatorRightQuantity,
            DenominatorDenominatorRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
                DenominatorDenominatorRightQuantity,
                >,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeft(
        right,
        denominatorDenominatorRightUnitPerDenominatorNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                DenominatorDenominatorRightQuantity,
                DenominatorDenominatorRightUnit,
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricReciprocalDividedByMetricDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
    NumeratorReciprocalAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorRightQuantity : UndefinedQuantityType,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
        >,
    NumeratorUnit,
    >.dividedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeft(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
                DenominatorDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorRightUnit : UndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
            DenominatorDenominatorRightQuantity,
            DenominatorDenominatorRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
                DenominatorDenominatorRightQuantity,
                >,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeft(
        right,
        denominatorDenominatorRightUnitPerDenominatorNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                DenominatorDenominatorRightQuantity,
                DenominatorDenominatorRightUnit,
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialReciprocalDividedByImperialDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
    NumeratorReciprocalAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorRightQuantity : UndefinedQuantityType,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
        >,
    NumeratorUnit,
    >.dividedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeft(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
                DenominatorDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorRightUnit : UndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
            DenominatorDenominatorRightQuantity,
            DenominatorDenominatorRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
                DenominatorDenominatorRightQuantity,
                >,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeft(
        right,
        denominatorDenominatorRightUnitPerDenominatorNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                DenominatorDenominatorRightQuantity,
                DenominatorDenominatorRightUnit,
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialReciprocalDividedByUKImperialDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
    NumeratorReciprocalAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorRightQuantity : UndefinedQuantityType,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
        >,
    NumeratorUnit,
    >.dividedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeft(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
                DenominatorDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorRightUnit : UndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
            DenominatorDenominatorRightQuantity,
            DenominatorDenominatorRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
                DenominatorDenominatorRightQuantity,
                >,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeft(
        right,
        denominatorDenominatorRightUnitPerDenominatorNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                DenominatorDenominatorRightQuantity,
                DenominatorDenominatorRightUnit,
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryReciprocalDividedByUSCustomaryDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
    NumeratorReciprocalAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorRightQuantity : UndefinedQuantityType,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
        >,
    NumeratorUnit,
    >.dividedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeft(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
                DenominatorDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorRightUnit : UndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
            DenominatorDenominatorRightQuantity,
            DenominatorDenominatorRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
                DenominatorDenominatorRightQuantity,
                >,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeft(
        right,
        denominatorDenominatorRightUnitPerDenominatorNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                DenominatorDenominatorRightQuantity,
                DenominatorDenominatorRightUnit,
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialReciprocalDividedByMetricAndUKImperialDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
    NumeratorReciprocalAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorRightQuantity : UndefinedQuantityType,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
        >,
    NumeratorUnit,
    >.dividedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeft(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
                DenominatorDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorRightUnit : UndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
            DenominatorDenominatorRightQuantity,
            DenominatorDenominatorRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
                DenominatorDenominatorRightQuantity,
                >,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeft(
        right,
        denominatorDenominatorRightUnitPerDenominatorNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                DenominatorDenominatorRightQuantity,
                DenominatorDenominatorRightUnit,
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryReciprocalDividedByMetricAndUSCustomaryDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
    NumeratorReciprocalAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
    NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
    NumeratorUnit,
    DenominatorNumeratorQuantity : UndefinedQuantityType,
    DenominatorNumeratorUnit,
    DenominatorDenominatorRightQuantity : UndefinedQuantityType,
    DenominatorDenominatorRightUnit,
    DenominatorDenominatorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
        >,
    NumeratorUnit,
    >.dividedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeft(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            DenominatorNumeratorQuantity,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
                DenominatorDenominatorRightQuantity,
                >,
            >,
        DenominatorUnit,
        >,
) where
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorReciprocalAndDenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedReciprocalUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorRightUnit : UndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorDenominatorUnit : UndefinedMultipliedUnit<
            NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
            NumeratorReciprocalAndDenominatorDenominatorLeftUnit,
            DenominatorDenominatorRightQuantity,
            DenominatorDenominatorRightUnit,
            >,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedDividedUnit<
            DenominatorNumeratorQuantity,
            DenominatorNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
                DenominatorDenominatorRightQuantity,
                >,
            DenominatorDenominatorUnit,
            >,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeft(
        right,
        denominatorDenominatorRightUnitPerDenominatorNumeratorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                DenominatorDenominatorRightQuantity,
                DenominatorDenominatorRightUnit,
                DenominatorNumeratorQuantity,
                DenominatorNumeratorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
