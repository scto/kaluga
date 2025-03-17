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
    LeftDenominatorLeftAndRightRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
    LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
    LeftDenominatorUnit : UndefinedMultipliedUnit<
        LeftDenominatorLeftAndRightRightQuantity,
        LeftDenominatorLeftAndRightRightUnit,
        LeftDenominatorRightAndRightLeftQuantity,
        LeftDenominatorRightAndRightLeftUnit,
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
    RightUnit : UndefinedMultipliedUnit<
        LeftDenominatorRightAndRightLeftQuantity,
        LeftDenominatorRightAndRightLeftUnit,
        LeftDenominatorLeftAndRightRightQuantity,
        LeftDenominatorLeftAndRightRightUnit,
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
    >.multipliedByMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight(
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
    LeftDenominatorLeftAndRightRightUnit,
    LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightLeftUnit,
    LeftDenominatorUnit,
    LeftUnit,
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
    >.multipliedByMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight(
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
        LeftDenominatorLeftAndRightRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        LeftDenominatorLeftAndRightRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightAndRightLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        LeftDenominatorRightAndRightLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightAndRightLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightAndRightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftAndRightRightUnit,
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightAndRightLeftUnit,
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
        RightUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightAndRightLeftUnit,
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftAndRightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight(right) {
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
    LeftDenominatorLeftAndRightRightUnit,
    LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightLeftUnit,
    LeftDenominatorUnit,
    LeftUnit,
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
    >.multipliedByMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight(
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
        LeftDenominatorLeftAndRightRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        LeftDenominatorLeftAndRightRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightAndRightLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        LeftDenominatorRightAndRightLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftAndRightRightUnit,
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightAndRightLeftUnit,
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
        RightUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightAndRightLeftUnit,
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftAndRightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedByMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight(right) {
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
    LeftDenominatorLeftAndRightRightUnit,
    LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightLeftUnit,
    LeftDenominatorUnit,
    LeftUnit,
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
    >.multipliedByMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight(
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
        LeftDenominatorLeftAndRightRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        LeftDenominatorLeftAndRightRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftAndRightRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightAndRightLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        LeftDenominatorRightAndRightLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightAndRightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftAndRightRightUnit,
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightAndRightLeftUnit,
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
        RightUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightAndRightLeftUnit,
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftAndRightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight(right) {
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
    LeftDenominatorLeftAndRightRightUnit,
    LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightLeftUnit,
    LeftDenominatorUnit,
    LeftUnit,
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
    >.multipliedByMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight(
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
        LeftDenominatorLeftAndRightRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        LeftDenominatorLeftAndRightRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightAndRightLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        LeftDenominatorRightAndRightLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftAndRightRightUnit,
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightAndRightLeftUnit,
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
        RightUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightAndRightLeftUnit,
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftAndRightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight(right) {
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
    LeftDenominatorLeftAndRightRightUnit,
    LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightLeftUnit,
    LeftDenominatorUnit,
    LeftUnit,
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
    >.multipliedByMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight(
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
        LeftDenominatorLeftAndRightRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        LeftDenominatorLeftAndRightRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightAndRightLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        LeftDenominatorRightAndRightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftAndRightRightUnit,
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightAndRightLeftUnit,
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
        RightUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightAndRightLeftUnit,
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftAndRightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight(right) {
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
    LeftDenominatorLeftAndRightRightUnit,
    LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightLeftUnit,
    LeftDenominatorUnit,
    LeftUnit,
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
    >.multipliedByMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight(
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
        LeftDenominatorLeftAndRightRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        LeftDenominatorLeftAndRightRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightAndRightLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        LeftDenominatorRightAndRightLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightAndRightLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftAndRightRightUnit,
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightAndRightLeftUnit,
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
        RightUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightAndRightLeftUnit,
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftAndRightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight(right) {
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
    LeftDenominatorLeftAndRightRightUnit,
    LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightLeftUnit,
    LeftDenominatorUnit,
    LeftUnit,
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
    >.multipliedByMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight(
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
        LeftDenominatorLeftAndRightRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
        LeftDenominatorLeftAndRightRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftAndRightRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightAndRightLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
        LeftDenominatorRightAndRightLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightAndRightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftAndRightRightUnit,
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightAndRightLeftUnit,
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
        RightUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorRightAndRightLeftUnit,
            LeftDenominatorLeftAndRightRightQuantity,
            LeftDenominatorLeftAndRightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight(right) {
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
    LeftDenominatorLeftAndRightRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
    LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightAndRightLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
    LeftDenominatorUnit : UndefinedMultipliedUnit<
        LeftDenominatorLeftAndRightRightQuantity,
        LeftDenominatorLeftAndRightRightUnit,
        LeftDenominatorRightAndRightLeftQuantity,
        LeftDenominatorRightAndRightLeftUnit,
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
    RightUnit : UndefinedMultipliedUnit<
        LeftDenominatorRightAndRightLeftQuantity,
        LeftDenominatorRightAndRightLeftUnit,
        LeftDenominatorLeftAndRightRightQuantity,
        LeftDenominatorLeftAndRightRightUnit,
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
    >.multipliedByMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftDenominatorRightAndRightLeftQuantity,
            LeftDenominatorLeftAndRightRightQuantity,
            >,
        RightUnit,
        >,
) = multipliedByMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight(right) {
        value: Decimal,
        unit: LeftNumeratorUnit,
    ->
    DefaultScientificValue(value, unit)
}
