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

// Div<A, Mul<Ex<B>, C>> * B! -> Div<A, C>

@JvmName("dividingWithMultiplyingWithExtendedLeftDenominatorMultipliedByDenominatorLeft")
fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
    ExtendedLeftDenominatorLeftUnit : UndefinedExtendedUnit<
        LeftDenominatorLeftAndRightQuantity,
        >,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
    LeftDenominatorUnit : UndefinedMultipliedUnit<
        UndefinedQuantityType.Extended<
            LeftDenominatorLeftAndRightQuantity,
            >,
        ExtendedLeftDenominatorLeftUnit,
        LeftDenominatorRightQuantity,
        LeftDenominatorRightUnit,
        >,
    LeftUnit : UndefinedDividedUnit<
        LeftNumeratorQuantity,
        LeftNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftDenominatorLeftAndRightQuantity,
                >,
            LeftDenominatorRightQuantity,
            >,
        LeftDenominatorUnit,
        >,
    LeftDenominatorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightUnit : ScientificUnit<LeftDenominatorLeftAndRightQuantity>,
    TargetUnit : UndefinedDividedUnit<
        LeftNumeratorQuantity,
        LeftNumeratorUnit,
        LeftDenominatorRightQuantity,
        LeftDenominatorRightUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            LeftNumeratorQuantity,
            LeftDenominatorRightQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftDenominatorLeftAndRightQuantity,
                >,
            LeftDenominatorRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedBy(
    right: ScientificValue<LeftDenominatorLeftAndRightQuantity, RightUnit>,
    leftNumeratorUnitPerLeftDenominatorRightUnit: LeftNumeratorUnit.(LeftDenominatorRightUnit) -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.leftNumeratorUnitPerLeftDenominatorRightUnit(
    unit.denominator.right,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingWithExtendedLeftDenominatorMultipliedByMetricAndImperialDenominatorLeft")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    ExtendedLeftDenominatorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    LeftDenominatorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftDenominatorLeftAndRightQuantity,
                >,
            LeftDenominatorRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: ScientificValue<LeftDenominatorLeftAndRightQuantity, RightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedLeftDenominatorLeftUnit : UndefinedExtendedUnit<
            LeftDenominatorLeftAndRightQuantity,
            >,
        ExtendedLeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        ExtendedLeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedLeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftDenominatorLeftAndRightQuantity,
                >,
            ExtendedLeftDenominatorLeftUnit,
            LeftDenominatorRightQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftDenominatorLeftAndRightQuantity,
                    >,
                LeftDenominatorRightQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : AbstractScientificUnit<LeftDenominatorLeftAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
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

@JvmName("metricDividingWithMultiplyingWithExtendedLeftDenominatorMultipliedByMetricDenominatorLeft")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    ExtendedLeftDenominatorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    LeftDenominatorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftDenominatorLeftAndRightQuantity,
                >,
            LeftDenominatorRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: ScientificValue<LeftDenominatorLeftAndRightQuantity, RightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        ExtendedLeftDenominatorLeftUnit : UndefinedExtendedUnit<
            LeftDenominatorLeftAndRightQuantity,
            >,
        ExtendedLeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftDenominatorLeftAndRightQuantity,
                >,
            ExtendedLeftDenominatorLeftUnit,
            LeftDenominatorRightQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftDenominatorLeftAndRightQuantity,
                    >,
                LeftDenominatorRightQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightUnit : AbstractScientificUnit<LeftDenominatorLeftAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(
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

@JvmName("imperialDividingWithMultiplyingWithExtendedLeftDenominatorMultipliedByImperialDenominatorLeft")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    ExtendedLeftDenominatorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    LeftDenominatorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftDenominatorLeftAndRightQuantity,
                >,
            LeftDenominatorRightQuantity,
            >,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: ScientificValue<LeftDenominatorLeftAndRightQuantity, RightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedLeftDenominatorLeftUnit : UndefinedExtendedUnit<
            LeftDenominatorLeftAndRightQuantity,
            >,
        ExtendedLeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedLeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftDenominatorLeftAndRightQuantity,
                >,
            ExtendedLeftDenominatorLeftUnit,
            LeftDenominatorRightQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftDenominatorLeftAndRightQuantity,
                    >,
                LeftDenominatorRightQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : AbstractScientificUnit<LeftDenominatorLeftAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
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

@JvmName("ukImperialDividingWithMultiplyingWithExtendedLeftDenominatorMultipliedByUKImperialDenominatorLeft")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    ExtendedLeftDenominatorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    LeftDenominatorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftDenominatorLeftAndRightQuantity,
                >,
            LeftDenominatorRightQuantity,
            >,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: ScientificValue<LeftDenominatorLeftAndRightQuantity, RightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedLeftDenominatorLeftUnit : UndefinedExtendedUnit<
            LeftDenominatorLeftAndRightQuantity,
            >,
        ExtendedLeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftDenominatorLeftAndRightQuantity,
                >,
            ExtendedLeftDenominatorLeftUnit,
            LeftDenominatorRightQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftDenominatorLeftAndRightQuantity,
                    >,
                LeftDenominatorRightQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : AbstractScientificUnit<LeftDenominatorLeftAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
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

@JvmName("usCustomaryDividingWithMultiplyingWithExtendedLeftDenominatorMultipliedByUSCustomaryDenominatorLeft")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    ExtendedLeftDenominatorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    LeftDenominatorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftDenominatorLeftAndRightQuantity,
                >,
            LeftDenominatorRightQuantity,
            >,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: ScientificValue<LeftDenominatorLeftAndRightQuantity, RightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedLeftDenominatorLeftUnit : UndefinedExtendedUnit<
            LeftDenominatorLeftAndRightQuantity,
            >,
        ExtendedLeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftDenominatorLeftAndRightQuantity,
                >,
            ExtendedLeftDenominatorLeftUnit,
            LeftDenominatorRightQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftDenominatorLeftAndRightQuantity,
                    >,
                LeftDenominatorRightQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : AbstractScientificUnit<LeftDenominatorLeftAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
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

@JvmName("metricAndUKImperialDividingWithMultiplyingWithExtendedLeftDenominatorMultipliedByMetricAndUKImperialDenominatorLeft")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    ExtendedLeftDenominatorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    LeftDenominatorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftDenominatorLeftAndRightQuantity,
                >,
            LeftDenominatorRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: ScientificValue<LeftDenominatorLeftAndRightQuantity, RightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedLeftDenominatorLeftUnit : UndefinedExtendedUnit<
            LeftDenominatorLeftAndRightQuantity,
            >,
        ExtendedLeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        ExtendedLeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftDenominatorLeftAndRightQuantity,
                >,
            ExtendedLeftDenominatorLeftUnit,
            LeftDenominatorRightQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftDenominatorLeftAndRightQuantity,
                    >,
                LeftDenominatorRightQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : AbstractScientificUnit<LeftDenominatorLeftAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
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

@JvmName("metricAndUSCustomaryDividingWithMultiplyingWithExtendedLeftDenominatorMultipliedByMetricAndUSCustomaryDenominatorLeft")
infix fun <
    LeftNumeratorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    ExtendedLeftDenominatorLeftUnit,
    LeftDenominatorRightQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    LeftDenominatorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorQuantity,
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftDenominatorLeftAndRightQuantity,
                >,
            LeftDenominatorRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: ScientificValue<LeftDenominatorLeftAndRightQuantity, RightUnit>,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedLeftDenominatorLeftUnit : UndefinedExtendedUnit<
            LeftDenominatorLeftAndRightQuantity,
            >,
        ExtendedLeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        ExtendedLeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftDenominatorLeftAndRightQuantity,
                >,
            ExtendedLeftDenominatorLeftUnit,
            LeftDenominatorRightQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftDenominatorLeftAndRightQuantity,
                    >,
                LeftDenominatorRightQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : AbstractScientificUnit<LeftDenominatorLeftAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
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
