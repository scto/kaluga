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
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Div<Wr<A>, Mul<B, C>> * Mul<C, B> -> A!

@JvmName("dividingWithDefinedNumeratorAndMultiplyingDenominatorMultipliedByMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight")
fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit : ScientificUnit<LeftNumeratorQuantity>,
    WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
        LeftNumeratorQuantity,
        LeftNumeratorUnit,
        >,
    LeftDenominatorLeftAndRightRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
    LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
    LeftDenominatorUnit : UndefinedMultipliedUnit<
        LeftDenominatorLeftAndRightRightQuantity,
        LeftDenominatorLeftUnit,
        LeftDenominatorRightAndRightLeftQuantity,
        LeftDenominatorRightUnit,
        >,
    LeftUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        WrappedLeftNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorRightAndRightLeftQuantity,
            >,
        LeftDenominatorUnit,
        >,
    RightLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
    RightRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
    RightUnit : UndefinedMultipliedUnit<
        LeftDenominatorRightAndRightLeftQuantity,
        RightLeftUnit,
        LeftDenominatorLeftAndRightRightQuantity,
        RightRightUnit,
        >,
    LeftNumeratorValue : ScientificValue<LeftNumeratorQuantity, LeftNumeratorUnit>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorRightAndRightLeftQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorLeftAndRightRightQuantity,
            >,
        RightUnit,
        >,
    factory: (Decimal, LeftNumeratorUnit) -> LeftNumeratorValue,
) = unit.numerator.wrapped.byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithDefinedNumeratorAndMultiplyingDenominatorMultipliedByMetricAndImperialMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorLeftAndRightRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightLeftUnit,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorRightAndRightLeftQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorLeftAndRightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            >,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorQuantity,
                >,
            WrappedLeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightRightQuantity,
                LeftDenominatorRightAndRightLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInMetric,
        RightLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInMetric,
        RightRightUnit : MeasurementUsage.UsedInUKImperial,
        RightRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightLeftQuantity,
            RightLeftUnit,
            LeftDenominatorLeftAndRightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricDividingWithDefinedNumeratorAndMultiplyingDenominatorMultipliedByMetricMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorLeftAndRightRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightLeftUnit,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorRightAndRightLeftQuantity,
            >,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorLeftAndRightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            >,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorQuantity,
                >,
            WrappedLeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightRightQuantity,
                LeftDenominatorRightAndRightLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInMetric,
        RightRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightLeftQuantity,
            RightLeftUnit,
            LeftDenominatorLeftAndRightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialDividingWithDefinedNumeratorAndMultiplyingDenominatorMultipliedByImperialMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorLeftAndRightRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightLeftUnit,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorRightAndRightLeftQuantity,
            >,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorLeftAndRightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            >,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorQuantity,
                >,
            WrappedLeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightRightQuantity,
                LeftDenominatorRightAndRightLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInUKImperial,
        RightRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightLeftQuantity,
            RightLeftUnit,
            LeftDenominatorLeftAndRightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialDividingWithDefinedNumeratorAndMultiplyingDenominatorMultipliedByUKImperialMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorLeftAndRightRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightLeftUnit,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorRightAndRightLeftQuantity,
            >,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorLeftAndRightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            >,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorQuantity,
                >,
            WrappedLeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightRightQuantity,
                LeftDenominatorRightAndRightLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightLeftQuantity,
            RightLeftUnit,
            LeftDenominatorLeftAndRightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingWithDefinedNumeratorAndMultiplyingDenominatorMultipliedByUSCustomaryMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorLeftAndRightRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightLeftUnit,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorRightAndRightLeftQuantity,
            >,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorLeftAndRightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            >,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorQuantity,
                >,
            WrappedLeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightRightQuantity,
                LeftDenominatorRightAndRightLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightLeftQuantity,
            RightLeftUnit,
            LeftDenominatorLeftAndRightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName(
    "metricAndUKImperialDividingWithDefinedNumeratorAndMultiplyingDenominatorMultipliedByMetricAndUKImperialMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight",
)
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorLeftAndRightRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightLeftUnit,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorRightAndRightLeftQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorLeftAndRightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            >,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorQuantity,
                >,
            WrappedLeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightRightQuantity,
                LeftDenominatorRightAndRightLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInMetric,
        RightLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInMetric,
        RightRightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightLeftQuantity,
            RightLeftUnit,
            LeftDenominatorLeftAndRightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName(
    "metricAndUSCustomaryDividingWithDefinedNumeratorAndMultiplyingDenominatorMultipliedByMetricAndUSCustomaryMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight",
)
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorLeftAndRightRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightLeftUnit,
    RightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorRightAndRightLeftQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorLeftAndRightRightQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            >,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorQuantity,
                >,
            WrappedLeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightRightQuantity,
                LeftDenominatorRightAndRightLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInMetric,
        RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInMetric,
        RightRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightLeftQuantity,
            RightLeftUnit,
            LeftDenominatorLeftAndRightRightQuantity,
            RightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericDividingWithDefinedNumeratorAndMultiplyingDenominatorMultipliedByGenericMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
    WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
        LeftNumeratorQuantity,
        LeftNumeratorUnit,
        >,
    LeftDenominatorLeftAndRightRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
    LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
    LeftDenominatorUnit : UndefinedMultipliedUnit<
        LeftDenominatorLeftAndRightRightQuantity,
        LeftDenominatorLeftUnit,
        LeftDenominatorRightAndRightLeftQuantity,
        LeftDenominatorRightUnit,
        >,
    LeftUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        WrappedLeftNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorRightAndRightLeftQuantity,
            >,
        LeftDenominatorUnit,
        >,
    RightLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
    RightRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
    RightUnit : UndefinedMultipliedUnit<
        LeftDenominatorRightAndRightLeftQuantity,
        RightLeftUnit,
        LeftDenominatorLeftAndRightRightQuantity,
        RightRightUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorRightAndRightLeftQuantity,
            >,
        >,
    LeftUnit,
    >.genericMultipliedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorLeftAndRightRightQuantity,
            >,
        RightUnit,
        >,
) = multipliedBy(right) {
        value: Decimal,
        unit: LeftNumeratorUnit,
    ->
    DefaultScientificValue(value, unit)
}
