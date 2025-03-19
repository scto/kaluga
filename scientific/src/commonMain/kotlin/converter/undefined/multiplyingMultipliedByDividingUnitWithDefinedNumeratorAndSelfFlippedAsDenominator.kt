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

// Mul<A, B> * Div<Wr<C>, Mul<B, A>> -> C!

@JvmName("multiplyingMultipliedByDividingUnitWithDefinedNumeratorAndSelfFlippedAsDenominator")
fun <
    LeftLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
    LeftRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftRightUnit : UndefinedScientificUnit<LeftRightAndRightDenominatorLeftQuantity>,
    LeftUnit : UndefinedMultipliedUnit<
        LeftLeftAndRightDenominatorRightQuantity,
        LeftLeftUnit,
        LeftRightAndRightDenominatorLeftQuantity,
        LeftRightUnit,
        >,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit : ScientificUnit<RightNumeratorQuantity>,
    WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
        RightNumeratorQuantity,
        RightNumeratorUnit,
        >,
    RightDenominatorLeftUnit : UndefinedScientificUnit<LeftRightAndRightDenominatorLeftQuantity>,
    RightDenominatorRightUnit : UndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
    RightDenominatorUnit : UndefinedMultipliedUnit<
        LeftRightAndRightDenominatorLeftQuantity,
        RightDenominatorLeftUnit,
        LeftLeftAndRightDenominatorRightQuantity,
        RightDenominatorRightUnit,
        >,
    RightUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Extended<
            RightNumeratorQuantity,
            >,
        WrappedRightNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            LeftRightAndRightDenominatorLeftQuantity,
            LeftLeftAndRightDenominatorRightQuantity,
            >,
        RightDenominatorUnit,
        >,
    RightNumeratorValue : ScientificValue<RightNumeratorQuantity, RightNumeratorUnit>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightDenominatorRightQuantity,
        LeftRightAndRightDenominatorLeftQuantity,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
    factory: (Decimal, RightNumeratorUnit) -> RightNumeratorValue,
) = right.unit.numerator.wrapped.byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultiplyingMultipliedByMetricAndImperialDividingUnitWithDefinedNumeratorAndSelfFlippedAsDenominator")
infix fun <
    LeftLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightDenominatorRightQuantity,
        LeftRightAndRightDenominatorLeftQuantity,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : UndefinedScientificUnit<LeftRightAndRightDenominatorLeftQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightDenominatorRightQuantity,
            LeftLeftUnit,
            LeftRightAndRightDenominatorLeftQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : AbstractScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            >,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : UndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricMultiplyingMultipliedByMetricDividingUnitWithDefinedNumeratorAndSelfFlippedAsDenominator")
infix fun <
    LeftLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightDenominatorRightQuantity,
        LeftRightAndRightDenominatorLeftQuantity,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : UndefinedScientificUnit<LeftRightAndRightDenominatorLeftQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightDenominatorRightQuantity,
            LeftLeftUnit,
            LeftRightAndRightDenominatorLeftQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : AbstractScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            >,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : UndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialMultiplyingMultipliedByImperialDividingUnitWithDefinedNumeratorAndSelfFlippedAsDenominator")
infix fun <
    LeftLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightDenominatorRightQuantity,
        LeftRightAndRightDenominatorLeftQuantity,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : UndefinedScientificUnit<LeftRightAndRightDenominatorLeftQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightDenominatorRightQuantity,
            LeftLeftUnit,
            LeftRightAndRightDenominatorLeftQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : AbstractScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            >,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : UndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialMultiplyingMultipliedByUKImperialDividingUnitWithDefinedNumeratorAndSelfFlippedAsDenominator")
infix fun <
    LeftLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightDenominatorRightQuantity,
        LeftRightAndRightDenominatorLeftQuantity,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : UndefinedScientificUnit<LeftRightAndRightDenominatorLeftQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightDenominatorRightQuantity,
            LeftLeftUnit,
            LeftRightAndRightDenominatorLeftQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : AbstractScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            >,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : UndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryMultiplyingMultipliedByUSCustomaryDividingUnitWithDefinedNumeratorAndSelfFlippedAsDenominator")
infix fun <
    LeftLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightDenominatorRightQuantity,
        LeftRightAndRightDenominatorLeftQuantity,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : UndefinedScientificUnit<LeftRightAndRightDenominatorLeftQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightDenominatorRightQuantity,
            LeftLeftUnit,
            LeftRightAndRightDenominatorLeftQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : AbstractScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            >,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : UndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultiplyingMultipliedByMetricAndUKImperialDividingUnitWithDefinedNumeratorAndSelfFlippedAsDenominator")
infix fun <
    LeftLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightDenominatorRightQuantity,
        LeftRightAndRightDenominatorLeftQuantity,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : UndefinedScientificUnit<LeftRightAndRightDenominatorLeftQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightDenominatorRightQuantity,
            LeftLeftUnit,
            LeftRightAndRightDenominatorLeftQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : AbstractScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            >,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorRightUnit : UndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultiplyingMultipliedByMetricAndUSCustomaryDividingUnitWithDefinedNumeratorAndSelfFlippedAsDenominator")
infix fun <
    LeftLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftRightUnit,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    RightDenominatorLeftUnit,
    RightDenominatorRightUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightDenominatorRightQuantity,
        LeftRightAndRightDenominatorLeftQuantity,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : UndefinedScientificUnit<LeftRightAndRightDenominatorLeftQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightDenominatorRightQuantity,
            LeftLeftUnit,
            LeftRightAndRightDenominatorLeftQuantity,
            LeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : AbstractScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            >,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorLeftUnit : UndefinedScientificUnit<LeftRightAndRightDenominatorLeftQuantity>,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorRightUnit : UndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
        RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedMultipliedUnit<
            LeftRightAndRightDenominatorLeftQuantity,
            RightDenominatorLeftUnit,
            LeftLeftAndRightDenominatorRightQuantity,
            RightDenominatorRightUnit,
            >,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericMultiplyingMultipliedByGenericDividingUnitWithDefinedNumeratorAndSelfFlippedAsDenominator")
infix fun <
    LeftLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
    LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
    LeftRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
    LeftRightUnit : UndefinedScientificUnit<LeftRightAndRightDenominatorLeftQuantity>,
    LeftUnit : UndefinedMultipliedUnit<
        LeftLeftAndRightDenominatorRightQuantity,
        LeftLeftUnit,
        LeftRightAndRightDenominatorLeftQuantity,
        LeftRightUnit,
        >,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit : AbstractScientificUnit<RightNumeratorQuantity>,
    WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
        RightNumeratorQuantity,
        RightNumeratorUnit,
        >,
    RightDenominatorLeftUnit : UndefinedScientificUnit<LeftRightAndRightDenominatorLeftQuantity>,
    RightDenominatorRightUnit : UndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
    RightDenominatorUnit : UndefinedMultipliedUnit<
        LeftRightAndRightDenominatorLeftQuantity,
        RightDenominatorLeftUnit,
        LeftLeftAndRightDenominatorRightQuantity,
        RightDenominatorRightUnit,
        >,
    RightUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Extended<
            RightNumeratorQuantity,
            >,
        WrappedRightNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            LeftRightAndRightDenominatorLeftQuantity,
            LeftLeftAndRightDenominatorRightQuantity,
            >,
        RightDenominatorUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightDenominatorRightQuantity,
        LeftRightAndRightDenominatorLeftQuantity,
        >,
    LeftUnit,
    >.genericMultipliedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            UndefinedQuantityType.Multiplying<
                LeftRightAndRightDenominatorLeftQuantity,
                LeftLeftAndRightDenominatorRightQuantity,
                >,
            >,
        RightUnit,
        >,
) = multipliedBy(right) {
        value: Decimal,
        unit: RightNumeratorUnit,
    ->
    DefaultScientificValue(value, unit)
}
