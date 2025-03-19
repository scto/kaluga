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

// Div<A, B> * Div<Mul<Wr<C>, B>, A> -> C!

@JvmName("dividingMultipliedByDividingUnitWithMultiplyingNumeratorWithDefinedLeftAndDenominatorAsRightAndNumeratorAsDenominator")
fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
    LeftUnit : UndefinedDividedUnit<
        LeftNumeratorAndRightDenominatorQuantity,
        LeftNumeratorUnit,
        LeftDenominatorAndRightNumeratorRightQuantity,
        LeftDenominatorUnit,
        >,
    RightNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorLeftUnit : ScientificUnit<RightNumeratorLeftQuantity>,
    WrappedRightNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
        RightNumeratorLeftQuantity,
        RightNumeratorLeftUnit,
        >,
    RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
    RightNumeratorUnit : UndefinedMultipliedUnit<
        UndefinedQuantityType.Extended<
            RightNumeratorLeftQuantity,
            >,
        WrappedRightNumeratorLeftUnit,
        LeftDenominatorAndRightNumeratorRightQuantity,
        RightNumeratorRightUnit,
        >,
    RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
    RightUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                RightNumeratorLeftQuantity,
                >,
            LeftDenominatorAndRightNumeratorRightQuantity,
            >,
        RightNumeratorUnit,
        LeftNumeratorAndRightDenominatorQuantity,
        RightDenominatorUnit,
        >,
    RightNumeratorLeftValue : ScientificValue<RightNumeratorLeftQuantity, RightNumeratorLeftUnit>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightDenominatorQuantity,
        LeftDenominatorAndRightNumeratorRightQuantity,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    RightNumeratorLeftQuantity,
                    >,
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            LeftNumeratorAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
    factory: (Decimal, RightNumeratorLeftUnit) -> RightNumeratorLeftValue,
) = right.unit.numerator.left.wrapped.byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingMultipliedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithDefinedLeftAndDenominatorAsRightAndNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorLeftUnit,
    WrappedRightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightDenominatorQuantity,
        LeftDenominatorAndRightNumeratorRightQuantity,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    RightNumeratorLeftQuantity,
                    >,
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            LeftNumeratorAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightDenominatorQuantity,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : AbstractScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            >,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorLeftQuantity,
                >,
            WrappedRightNumeratorLeftUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    RightNumeratorLeftQuantity,
                    >,
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            LeftNumeratorAndRightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricDividingMultipliedByMetricDividingUnitWithMultiplyingNumeratorWithDefinedLeftAndDenominatorAsRightAndNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorLeftUnit,
    WrappedRightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightDenominatorQuantity,
        LeftDenominatorAndRightNumeratorRightQuantity,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    RightNumeratorLeftQuantity,
                    >,
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            LeftNumeratorAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightDenominatorQuantity,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : AbstractScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedRightNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            >,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorLeftQuantity,
                >,
            WrappedRightNumeratorLeftUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    RightNumeratorLeftQuantity,
                    >,
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            LeftNumeratorAndRightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialDividingMultipliedByImperialDividingUnitWithMultiplyingNumeratorWithDefinedLeftAndDenominatorAsRightAndNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorLeftUnit,
    WrappedRightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightDenominatorQuantity,
        LeftDenominatorAndRightNumeratorRightQuantity,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    RightNumeratorLeftQuantity,
                    >,
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            LeftNumeratorAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightDenominatorQuantity,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : AbstractScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            >,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorLeftQuantity,
                >,
            WrappedRightNumeratorLeftUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    RightNumeratorLeftQuantity,
                    >,
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            LeftNumeratorAndRightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialDividingMultipliedByUKImperialDividingUnitWithMultiplyingNumeratorWithDefinedLeftAndDenominatorAsRightAndNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorLeftUnit,
    WrappedRightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightDenominatorQuantity,
        LeftDenominatorAndRightNumeratorRightQuantity,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    RightNumeratorLeftQuantity,
                    >,
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            LeftNumeratorAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightDenominatorQuantity,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : AbstractScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            >,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorLeftQuantity,
                >,
            WrappedRightNumeratorLeftUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    RightNumeratorLeftQuantity,
                    >,
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            LeftNumeratorAndRightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingMultipliedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithDefinedLeftAndDenominatorAsRightAndNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorLeftUnit,
    WrappedRightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightDenominatorQuantity,
        LeftDenominatorAndRightNumeratorRightQuantity,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    RightNumeratorLeftQuantity,
                    >,
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            LeftNumeratorAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightDenominatorQuantity,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : AbstractScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            >,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorLeftQuantity,
                >,
            WrappedRightNumeratorLeftUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    RightNumeratorLeftQuantity,
                    >,
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            LeftNumeratorAndRightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividingMultipliedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithDefinedLeftAndDenominatorAsRightAndNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorLeftUnit,
    WrappedRightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightDenominatorQuantity,
        LeftDenominatorAndRightNumeratorRightQuantity,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    RightNumeratorLeftQuantity,
                    >,
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            LeftNumeratorAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightDenominatorQuantity,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : AbstractScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            >,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorLeftQuantity,
                >,
            WrappedRightNumeratorLeftUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    RightNumeratorLeftQuantity,
                    >,
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            LeftNumeratorAndRightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDividingMultipliedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithDefinedLeftAndDenominatorAsRightAndNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorLeftUnit,
    WrappedRightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightDenominatorQuantity,
        LeftDenominatorAndRightNumeratorRightQuantity,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    RightNumeratorLeftQuantity,
                    >,
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            LeftNumeratorAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            LeftNumeratorAndRightDenominatorQuantity,
            LeftNumeratorUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : AbstractScientificUnit<RightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            >,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedRightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorLeftQuantity,
                >,
            WrappedRightNumeratorLeftUnit,
            LeftDenominatorAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    RightNumeratorLeftQuantity,
                    >,
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            LeftNumeratorAndRightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericDividingMultipliedByGenericDividingUnitWithMultiplyingNumeratorWithDefinedLeftAndDenominatorAsRightAndNumeratorAsDenominator")
infix fun <
    LeftNumeratorAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
    LeftDenominatorAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
    LeftUnit : UndefinedDividedUnit<
        LeftNumeratorAndRightDenominatorQuantity,
        LeftNumeratorUnit,
        LeftDenominatorAndRightNumeratorRightQuantity,
        LeftDenominatorUnit,
        >,
    RightNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorLeftUnit : AbstractScientificUnit<RightNumeratorLeftQuantity>,
    WrappedRightNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
        RightNumeratorLeftQuantity,
        RightNumeratorLeftUnit,
        >,
    RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorRightQuantity>,
    RightNumeratorUnit : UndefinedMultipliedUnit<
        UndefinedQuantityType.Extended<
            RightNumeratorLeftQuantity,
            >,
        WrappedRightNumeratorLeftUnit,
        LeftDenominatorAndRightNumeratorRightQuantity,
        RightNumeratorRightUnit,
        >,
    RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorAndRightDenominatorQuantity>,
    RightUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                RightNumeratorLeftQuantity,
                >,
            LeftDenominatorAndRightNumeratorRightQuantity,
            >,
        RightNumeratorUnit,
        LeftNumeratorAndRightDenominatorQuantity,
        RightDenominatorUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        LeftNumeratorAndRightDenominatorQuantity,
        LeftDenominatorAndRightNumeratorRightQuantity,
        >,
    LeftUnit,
    >.genericMultipliedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    RightNumeratorLeftQuantity,
                    >,
                LeftDenominatorAndRightNumeratorRightQuantity,
                >,
            LeftNumeratorAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) = multipliedBy(right) {
        value: Decimal,
        unit: RightNumeratorLeftUnit,
    ->
    DefaultScientificValue(value, unit)
}
