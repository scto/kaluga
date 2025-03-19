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
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// Div<Mul<A, B>, C> / A -> Div<B, C>

@JvmName("dividingWithMultiplyingNumeratorDividedByNumeratorLeft")
fun <
    NumeratorNumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
    NumeratorNumeratorUnit : UndefinedMultipliedUnit<
        NumeratorNumeratorLeftAndDenominatorQuantity,
        NumeratorNumeratorLeftUnit,
        NumeratorNumeratorRightQuantity,
        NumeratorNumeratorRightUnit,
        >,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
    NumeratorUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftAndDenominatorQuantity,
            NumeratorNumeratorRightQuantity,
            >,
        NumeratorNumeratorUnit,
        NumeratorDenominatorQuantity,
        NumeratorDenominatorUnit,
        >,
    DenominatorUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
    TargetUnit : UndefinedDividedUnit<
        NumeratorNumeratorRightQuantity,
        NumeratorNumeratorRightUnit,
        NumeratorDenominatorQuantity,
        NumeratorDenominatorUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            NumeratorNumeratorRightQuantity,
            NumeratorDenominatorQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftAndDenominatorQuantity,
            NumeratorNumeratorRightQuantity,
            >,
        NumeratorDenominatorQuantity,
        >,
    NumeratorUnit,
    >.dividedBy(
    right: UndefinedScientificValue<
        NumeratorNumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
    numeratorNumeratorRightUnitPerNumeratorDenominatorUnit: NumeratorNumeratorRightUnit.(NumeratorDenominatorUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.right.numeratorNumeratorRightUnitPerNumeratorDenominatorUnit(
    unit.denominator,
).byDividing(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingNumeratorDividedByMetricAndImperialNumeratorLeft")
infix fun <
    NumeratorNumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftAndDenominatorQuantity,
            NumeratorNumeratorRightQuantity,
            >,
        NumeratorDenominatorQuantity,
        >,
    NumeratorUnit,
    >.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        NumeratorNumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftAndDenominatorQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftAndDenominatorQuantity,
                NumeratorNumeratorRightQuantity,
                >,
            NumeratorNumeratorUnit,
            NumeratorDenominatorQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorNumeratorRightUnitPerNumeratorDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                NumeratorNumeratorRightQuantity,
                NumeratorNumeratorRightUnit,
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDividingWithMultiplyingNumeratorDividedByMetricNumeratorLeft")
infix fun <
    NumeratorNumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftAndDenominatorQuantity,
            NumeratorNumeratorRightQuantity,
            >,
        NumeratorDenominatorQuantity,
        >,
    NumeratorUnit,
    >.metricDividedByMetric(
    right: UndefinedScientificValue<
        NumeratorNumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftAndDenominatorQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftAndDenominatorQuantity,
                NumeratorNumeratorRightQuantity,
                >,
            NumeratorNumeratorUnit,
            NumeratorDenominatorQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(
        right,
        numeratorNumeratorRightUnitPerNumeratorDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                NumeratorNumeratorRightQuantity,
                NumeratorNumeratorRightUnit,
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDividingWithMultiplyingNumeratorDividedByImperialNumeratorLeft")
infix fun <
    NumeratorNumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftAndDenominatorQuantity,
            NumeratorNumeratorRightQuantity,
            >,
        NumeratorDenominatorQuantity,
        >,
    NumeratorUnit,
    >.imperialDividedByImperial(
    right: UndefinedScientificValue<
        NumeratorNumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftAndDenominatorQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftAndDenominatorQuantity,
                NumeratorNumeratorRightQuantity,
                >,
            NumeratorNumeratorUnit,
            NumeratorDenominatorQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorNumeratorRightUnitPerNumeratorDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                NumeratorNumeratorRightQuantity,
                NumeratorNumeratorRightUnit,
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDividingWithMultiplyingNumeratorDividedByUKImperialNumeratorLeft")
infix fun <
    NumeratorNumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftAndDenominatorQuantity,
            NumeratorNumeratorRightQuantity,
            >,
        NumeratorDenominatorQuantity,
        >,
    NumeratorUnit,
    >.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        NumeratorNumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftAndDenominatorQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftAndDenominatorQuantity,
                NumeratorNumeratorRightQuantity,
                >,
            NumeratorNumeratorUnit,
            NumeratorDenominatorQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorNumeratorRightUnitPerNumeratorDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                NumeratorNumeratorRightQuantity,
                NumeratorNumeratorRightUnit,
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingWithMultiplyingNumeratorDividedByUSCustomaryNumeratorLeft")
infix fun <
    NumeratorNumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftAndDenominatorQuantity,
            NumeratorNumeratorRightQuantity,
            >,
        NumeratorDenominatorQuantity,
        >,
    NumeratorUnit,
    >.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        NumeratorNumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftAndDenominatorQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftAndDenominatorQuantity,
                NumeratorNumeratorRightQuantity,
                >,
            NumeratorNumeratorUnit,
            NumeratorDenominatorQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorNumeratorRightUnitPerNumeratorDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                NumeratorNumeratorRightQuantity,
                NumeratorNumeratorRightUnit,
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividingWithMultiplyingNumeratorDividedByMetricAndUKImperialNumeratorLeft")
infix fun <
    NumeratorNumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftAndDenominatorQuantity,
            NumeratorNumeratorRightQuantity,
            >,
        NumeratorDenominatorQuantity,
        >,
    NumeratorUnit,
    >.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        NumeratorNumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftAndDenominatorQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftAndDenominatorQuantity,
                NumeratorNumeratorRightQuantity,
                >,
            NumeratorNumeratorUnit,
            NumeratorDenominatorQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        DenominatorUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        numeratorNumeratorRightUnitPerNumeratorDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                NumeratorNumeratorRightQuantity,
                NumeratorNumeratorRightUnit,
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDividingWithMultiplyingNumeratorDividedByMetricAndUSCustomaryNumeratorLeft")
infix fun <
    NumeratorNumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
    NumeratorNumeratorLeftUnit,
    NumeratorNumeratorRightQuantity : UndefinedQuantityType,
    NumeratorNumeratorRightUnit,
    NumeratorNumeratorUnit,
    NumeratorDenominatorQuantity : UndefinedQuantityType,
    NumeratorDenominatorUnit,
    NumeratorUnit,
    DenominatorUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            NumeratorNumeratorLeftAndDenominatorQuantity,
            NumeratorNumeratorRightQuantity,
            >,
        NumeratorDenominatorQuantity,
        >,
    NumeratorUnit,
    >.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        NumeratorNumeratorLeftAndDenominatorQuantity,
        DenominatorUnit,
        >,
) where
        NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorNumeratorUnit : UndefinedMultipliedUnit<
            NumeratorNumeratorLeftAndDenominatorQuantity,
            NumeratorNumeratorLeftUnit,
            NumeratorNumeratorRightQuantity,
            NumeratorNumeratorRightUnit,
            >,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
        NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        NumeratorUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                NumeratorNumeratorLeftAndDenominatorQuantity,
                NumeratorNumeratorRightQuantity,
                >,
            NumeratorNumeratorUnit,
            NumeratorDenominatorQuantity,
            NumeratorDenominatorUnit,
            >,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        DenominatorUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorQuantity>,
        DenominatorUnit : MeasurementUsage.UsedInMetric,
        DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        numeratorNumeratorRightUnitPerNumeratorDenominatorUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                NumeratorNumeratorRightQuantity,
                NumeratorNumeratorRightUnit,
                NumeratorDenominatorQuantity,
                NumeratorDenominatorUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
