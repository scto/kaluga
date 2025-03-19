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
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// Div<A, Mul<B, Ex<C>>> * C! -> Div<A, B>

@JvmName("dividingWithMultiplyingWithExtendedRightDenominatorMultipliedByDenominatorRight")
fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
    ExtendedLeftDenominatorRightUnit : UndefinedExtendedUnit<
        LeftDenominatorRightAndRightQuantity,
        >,
    LeftDenominatorUnit : UndefinedMultipliedUnit<
        LeftDenominatorLeftQuantity,
        LeftDenominatorLeftUnit,
        UndefinedQuantityType.Extended<
            LeftDenominatorRightAndRightQuantity,
            >,
        ExtendedLeftDenominatorRightUnit,
        >,
    LeftUnit : UndefinedDividedUnit<
        LeftNumeratorQuantity,
        LeftNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            UndefinedQuantityType.Extended<
                LeftDenominatorRightAndRightQuantity,
                >,
            >,
        LeftDenominatorUnit,
        >,
    LeftDenominatorRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightUnit : ScientificUnit<LeftDenominatorRightAndRightQuantity>,
    TargetUnit : UndefinedDividedUnit<
        LeftNumeratorQuantity,
        LeftNumeratorUnit,
        LeftDenominatorLeftQuantity,
        LeftDenominatorLeftUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftNumeratorQuantity,
            LeftDenominatorLeftQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            UndefinedQuantityType.Extended<
                LeftDenominatorRightAndRightQuantity,
                >,
            >,
        >,
    LeftUnit,
    >.multipliedBy(
    right: ScientificValue<LeftDenominatorRightAndRightQuantity, RightUnit>,
    leftNumeratorUnitPerLeftDenominatorLeftUnit: LeftNumeratorUnit.(LeftDenominatorLeftUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.leftNumeratorUnitPerLeftDenominatorLeftUnit(
    unit.denominator.left,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingWithExtendedRightDenominatorMultipliedByMetricAndImperialDenominatorRight")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    ExtendedLeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    LeftDenominatorRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            UndefinedQuantityType.Extended<
                LeftDenominatorRightAndRightQuantity,
                >,
            >,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: ScientificValue<LeftDenominatorRightAndRightQuantity, RightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedLeftDenominatorRightUnit : UndefinedExtendedUnit<
            LeftDenominatorRightAndRightQuantity,
            >,
        ExtendedLeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        ExtendedLeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedLeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            UndefinedQuantityType.Extended<
                LeftDenominatorRightAndRightQuantity,
                >,
            ExtendedLeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                UndefinedQuantityType.Extended<
                    LeftDenominatorRightAndRightQuantity,
                    >,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : AbstractScientificUnit<LeftDenominatorRightAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndImperial<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                LeftDenominatorLeftQuantity,
                LeftDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDividingWithMultiplyingWithExtendedRightDenominatorMultipliedByMetricDenominatorRight")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    ExtendedLeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    LeftDenominatorRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            UndefinedQuantityType.Extended<
                LeftDenominatorRightAndRightQuantity,
                >,
            >,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: ScientificValue<LeftDenominatorRightAndRightQuantity, RightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        ExtendedLeftDenominatorRightUnit : UndefinedExtendedUnit<
            LeftDenominatorRightAndRightQuantity,
            >,
        ExtendedLeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            UndefinedQuantityType.Extended<
                LeftDenominatorRightAndRightQuantity,
                >,
            ExtendedLeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                UndefinedQuantityType.Extended<
                    LeftDenominatorRightAndRightQuantity,
                    >,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightUnit : AbstractScientificUnit<LeftDenominatorRightAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(
        right,
        leftNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Metric<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                LeftDenominatorLeftQuantity,
                LeftDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDividingWithMultiplyingWithExtendedRightDenominatorMultipliedByImperialDenominatorRight")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    ExtendedLeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    LeftDenominatorRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            UndefinedQuantityType.Extended<
                LeftDenominatorRightAndRightQuantity,
                >,
            >,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: ScientificValue<LeftDenominatorRightAndRightQuantity, RightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedLeftDenominatorRightUnit : UndefinedExtendedUnit<
            LeftDenominatorRightAndRightQuantity,
            >,
        ExtendedLeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedLeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            UndefinedQuantityType.Extended<
                LeftDenominatorRightAndRightQuantity,
                >,
            ExtendedLeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                UndefinedQuantityType.Extended<
                    LeftDenominatorRightAndRightQuantity,
                    >,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : AbstractScientificUnit<LeftDenominatorRightAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.Imperial<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                LeftDenominatorLeftQuantity,
                LeftDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDividingWithMultiplyingWithExtendedRightDenominatorMultipliedByUKImperialDenominatorRight")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    ExtendedLeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    LeftDenominatorRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            UndefinedQuantityType.Extended<
                LeftDenominatorRightAndRightQuantity,
                >,
            >,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: ScientificValue<LeftDenominatorRightAndRightQuantity, RightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedLeftDenominatorRightUnit : UndefinedExtendedUnit<
            LeftDenominatorRightAndRightQuantity,
            >,
        ExtendedLeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            UndefinedQuantityType.Extended<
                LeftDenominatorRightAndRightQuantity,
                >,
            ExtendedLeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                UndefinedQuantityType.Extended<
                    LeftDenominatorRightAndRightQuantity,
                    >,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : AbstractScientificUnit<LeftDenominatorRightAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.UKImperial<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                LeftDenominatorLeftQuantity,
                LeftDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingWithMultiplyingWithExtendedRightDenominatorMultipliedByUSCustomaryDenominatorRight")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    ExtendedLeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    LeftDenominatorRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            UndefinedQuantityType.Extended<
                LeftDenominatorRightAndRightQuantity,
                >,
            >,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: ScientificValue<LeftDenominatorRightAndRightQuantity, RightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedLeftDenominatorRightUnit : UndefinedExtendedUnit<
            LeftDenominatorRightAndRightQuantity,
            >,
        ExtendedLeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            UndefinedQuantityType.Extended<
                LeftDenominatorRightAndRightQuantity,
                >,
            ExtendedLeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                UndefinedQuantityType.Extended<
                    LeftDenominatorRightAndRightQuantity,
                    >,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : AbstractScientificUnit<LeftDenominatorRightAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.USCustomary<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                LeftDenominatorLeftQuantity,
                LeftDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividingWithMultiplyingWithExtendedRightDenominatorMultipliedByMetricAndUKImperialDenominatorRight")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    ExtendedLeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    LeftDenominatorRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            UndefinedQuantityType.Extended<
                LeftDenominatorRightAndRightQuantity,
                >,
            >,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: ScientificValue<LeftDenominatorRightAndRightQuantity, RightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedLeftDenominatorRightUnit : UndefinedExtendedUnit<
            LeftDenominatorRightAndRightQuantity,
            >,
        ExtendedLeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        ExtendedLeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            UndefinedQuantityType.Extended<
                LeftDenominatorRightAndRightQuantity,
                >,
            ExtendedLeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                UndefinedQuantityType.Extended<
                    LeftDenominatorRightAndRightQuantity,
                    >,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : AbstractScientificUnit<LeftDenominatorRightAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        leftNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUKImperial<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                LeftDenominatorLeftQuantity,
                LeftDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDividingWithMultiplyingWithExtendedRightDenominatorMultipliedByMetricAndUSCustomaryDenominatorRight")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    ExtendedLeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    LeftDenominatorRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftQuantity,
            UndefinedQuantityType.Extended<
                LeftDenominatorRightAndRightQuantity,
                >,
            >,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: ScientificValue<LeftDenominatorRightAndRightQuantity, RightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedLeftDenominatorRightUnit : UndefinedExtendedUnit<
            LeftDenominatorRightAndRightQuantity,
            >,
        ExtendedLeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        ExtendedLeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftQuantity,
            LeftDenominatorLeftUnit,
            UndefinedQuantityType.Extended<
                LeftDenominatorRightAndRightQuantity,
                >,
            ExtendedLeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftQuantity,
                UndefinedQuantityType.Extended<
                    LeftDenominatorRightAndRightQuantity,
                    >,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : AbstractScientificUnit<LeftDenominatorRightAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        leftNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
    ) {
            value: Decimal,
            unit: UndefinedDividedUnit.MetricAndUSCustomary<
                LeftNumeratorQuantity,
                LeftNumeratorUnit,
                LeftDenominatorLeftQuantity,
                LeftDenominatorLeftUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
