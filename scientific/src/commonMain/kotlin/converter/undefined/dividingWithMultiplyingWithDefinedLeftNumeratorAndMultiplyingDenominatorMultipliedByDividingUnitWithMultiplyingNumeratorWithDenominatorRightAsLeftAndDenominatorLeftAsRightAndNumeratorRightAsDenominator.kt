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

// Div<Mul<Wr<D>, C>, Mul<B, A>> * Div<Mul<A, B>, C> -> D!

@JvmName(
    "dividingWithMultiplyingWithDefinedLeftNumeratorAndMultiplyingDenominatorMultipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndNumeratorRightAsDenominator",
)
fun <
    LeftNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorLeftUnit : ScientificUnit<LeftNumeratorLeftQuantity>,
    WrappedLeftNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
        LeftNumeratorLeftQuantity,
        LeftNumeratorLeftUnit,
        >,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
    LeftNumeratorUnit : UndefinedMultipliedUnit<
        UndefinedQuantityType.Extended<
            LeftNumeratorLeftQuantity,
            >,
        WrappedLeftNumeratorLeftUnit,
        LeftNumeratorRightAndRightDenominatorQuantity,
        LeftNumeratorRightUnit,
        >,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
    LeftDenominatorUnit : UndefinedMultipliedUnit<
        LeftDenominatorLeftAndRightNumeratorRightQuantity,
        LeftDenominatorLeftUnit,
        LeftDenominatorRightAndRightNumeratorLeftQuantity,
        LeftDenominatorRightUnit,
        >,
    LeftUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftNumeratorLeftQuantity,
                >,
            LeftNumeratorRightAndRightDenominatorQuantity,
            >,
        LeftNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            >,
        LeftDenominatorUnit,
        >,
    RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
    RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
    RightNumeratorUnit : UndefinedMultipliedUnit<
        LeftDenominatorRightAndRightNumeratorLeftQuantity,
        RightNumeratorLeftUnit,
        LeftDenominatorLeftAndRightNumeratorRightQuantity,
        RightNumeratorRightUnit,
        >,
    RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
    RightUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            >,
        RightNumeratorUnit,
        LeftNumeratorRightAndRightDenominatorQuantity,
        RightDenominatorUnit,
        >,
    LeftNumeratorLeftValue : ScientificValue<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftNumeratorLeftQuantity,
                >,
            LeftNumeratorRightAndRightDenominatorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            LeftNumeratorRightAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
    factory: (Decimal, LeftNumeratorLeftUnit) -> LeftNumeratorLeftValue,
) = unit.numerator.left.wrapped.byMultiplying(this, right, factory)

@JvmName(
    "metricAndImperialDividingWithMultiplyingWithDefinedLeftNumeratorAndMultiplyingDenominatorMultipliedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndNumeratorRightAsDenominator",
)
infix fun <
    LeftNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorLeftUnit,
    WrappedLeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftNumeratorLeftQuantity,
                >,
            LeftNumeratorRightAndRightDenominatorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            LeftNumeratorRightAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : AbstractScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            LeftNumeratorLeftQuantity,
            LeftNumeratorLeftUnit,
            >,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorLeftQuantity,
                >,
            WrappedLeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftNumeratorLeftQuantity,
                    >,
                LeftNumeratorRightAndRightDenominatorQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            LeftNumeratorRightAndRightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName(
    "metricDividingWithMultiplyingWithDefinedLeftNumeratorAndMultiplyingDenominatorMultipliedByMetricDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndNumeratorRightAsDenominator",
)
infix fun <
    LeftNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorLeftUnit,
    WrappedLeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftNumeratorLeftQuantity,
                >,
            LeftNumeratorRightAndRightDenominatorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            >,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            LeftNumeratorRightAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : AbstractScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            LeftNumeratorLeftQuantity,
            LeftNumeratorLeftUnit,
            >,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorLeftQuantity,
                >,
            WrappedLeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftNumeratorLeftQuantity,
                    >,
                LeftNumeratorRightAndRightDenominatorQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            LeftNumeratorRightAndRightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName(
    "imperialDividingWithMultiplyingWithDefinedLeftNumeratorAndMultiplyingDenominatorMultipliedByImperialDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndNumeratorRightAsDenominator",
)
infix fun <
    LeftNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorLeftUnit,
    WrappedLeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftNumeratorLeftQuantity,
                >,
            LeftNumeratorRightAndRightDenominatorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            >,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            LeftNumeratorRightAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : AbstractScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            LeftNumeratorLeftQuantity,
            LeftNumeratorLeftUnit,
            >,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorLeftQuantity,
                >,
            WrappedLeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftNumeratorLeftQuantity,
                    >,
                LeftNumeratorRightAndRightDenominatorQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            LeftNumeratorRightAndRightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName(
    "ukImperialDividingWithMultiplyingWithDefinedLeftNumeratorAndMultiplyingDenominatorMultipliedByUKImperialDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndNumeratorRightAsDenominator",
)
infix fun <
    LeftNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorLeftUnit,
    WrappedLeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftNumeratorLeftQuantity,
                >,
            LeftNumeratorRightAndRightDenominatorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            >,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            LeftNumeratorRightAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : AbstractScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            LeftNumeratorLeftQuantity,
            LeftNumeratorLeftUnit,
            >,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorLeftQuantity,
                >,
            WrappedLeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftNumeratorLeftQuantity,
                    >,
                LeftNumeratorRightAndRightDenominatorQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            LeftNumeratorRightAndRightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName(
    "usCustomaryDividingWithMultiplyingWithDefinedLeftNumeratorAndMultiplyingDenominatorMultipliedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndNumeratorRightAsDenominator",
)
infix fun <
    LeftNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorLeftUnit,
    WrappedLeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftNumeratorLeftQuantity,
                >,
            LeftNumeratorRightAndRightDenominatorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            >,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            LeftNumeratorRightAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : AbstractScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            LeftNumeratorLeftQuantity,
            LeftNumeratorLeftUnit,
            >,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorLeftQuantity,
                >,
            WrappedLeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftNumeratorLeftQuantity,
                    >,
                LeftNumeratorRightAndRightDenominatorQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            LeftNumeratorRightAndRightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName(
    "metricAndUKImperialDividingWithMultiplyingWithDefinedLeftNumeratorAndMultiplyingDenominatorMultipliedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndNumeratorRightAsDenominator",
)
infix fun <
    LeftNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorLeftUnit,
    WrappedLeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftNumeratorLeftQuantity,
                >,
            LeftNumeratorRightAndRightDenominatorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            LeftNumeratorRightAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : AbstractScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            LeftNumeratorLeftQuantity,
            LeftNumeratorLeftUnit,
            >,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorLeftQuantity,
                >,
            WrappedLeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftNumeratorLeftQuantity,
                    >,
                LeftNumeratorRightAndRightDenominatorQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            LeftNumeratorRightAndRightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName(
    "metricAndUSCustomaryDividingWithMultiplyingWithDefinedLeftNumeratorAndMultiplyingDenominatorMultipliedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndNumeratorRightAsDenominator",
)
infix fun <
    LeftNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorLeftUnit,
    WrappedLeftNumeratorLeftUnit,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit,
    LeftNumeratorUnit,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit,
    LeftDenominatorUnit,
    LeftUnit,
    RightNumeratorLeftUnit,
    RightNumeratorRightUnit,
    RightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftNumeratorLeftQuantity,
                >,
            LeftNumeratorRightAndRightDenominatorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            LeftNumeratorRightAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftNumeratorLeftUnit : AbstractScientificUnit<LeftNumeratorLeftQuantity>,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
            LeftNumeratorLeftQuantity,
            LeftNumeratorLeftUnit,
            >,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftNumeratorUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorLeftQuantity,
                >,
            WrappedLeftNumeratorLeftUnit,
            LeftNumeratorRightAndRightDenominatorQuantity,
            LeftNumeratorRightUnit,
            >,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : UndefinedMultipliedUnit<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorLeftUnit,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            LeftDenominatorRightUnit,
            >,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftNumeratorLeftQuantity,
                    >,
                LeftNumeratorRightAndRightDenominatorQuantity,
                >,
            LeftNumeratorUnit,
            UndefinedQuantityType.Multiplying<
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                >,
            LeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
        RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : UndefinedMultipliedUnit<
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            RightNumeratorLeftUnit,
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            RightNumeratorRightUnit,
            >,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            RightNumeratorUnit,
            LeftNumeratorRightAndRightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName(
    "genericDividingWithMultiplyingWithDefinedLeftNumeratorAndMultiplyingDenominatorMultipliedByGenericDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndNumeratorRightAsDenominator",
)
infix fun <
    LeftNumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorLeftUnit : AbstractScientificUnit<LeftNumeratorLeftQuantity>,
    WrappedLeftNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
        LeftNumeratorLeftQuantity,
        LeftNumeratorLeftUnit,
        >,
    LeftNumeratorRightAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
    LeftNumeratorUnit : UndefinedMultipliedUnit<
        UndefinedQuantityType.Extended<
            LeftNumeratorLeftQuantity,
            >,
        WrappedLeftNumeratorLeftUnit,
        LeftNumeratorRightAndRightDenominatorQuantity,
        LeftNumeratorRightUnit,
        >,
    LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
    LeftDenominatorLeftUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
    LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
    LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
    LeftDenominatorUnit : UndefinedMultipliedUnit<
        LeftDenominatorLeftAndRightNumeratorRightQuantity,
        LeftDenominatorLeftUnit,
        LeftDenominatorRightAndRightNumeratorLeftQuantity,
        LeftDenominatorRightUnit,
        >,
    LeftUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftNumeratorLeftQuantity,
                >,
            LeftNumeratorRightAndRightDenominatorQuantity,
            >,
        LeftNumeratorUnit,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            >,
        LeftDenominatorUnit,
        >,
    RightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
    RightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
    RightNumeratorUnit : UndefinedMultipliedUnit<
        LeftDenominatorRightAndRightNumeratorLeftQuantity,
        RightNumeratorLeftUnit,
        LeftDenominatorLeftAndRightNumeratorRightQuantity,
        RightNumeratorRightUnit,
        >,
    RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorQuantity>,
    RightUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Multiplying<
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            >,
        RightNumeratorUnit,
        LeftNumeratorRightAndRightDenominatorQuantity,
        RightDenominatorUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftNumeratorLeftQuantity,
                >,
            LeftNumeratorRightAndRightDenominatorQuantity,
            >,
        UndefinedQuantityType.Multiplying<
            LeftDenominatorLeftAndRightNumeratorRightQuantity,
            LeftDenominatorRightAndRightNumeratorLeftQuantity,
            >,
        >,
    LeftUnit,
    >.genericMultipliedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Multiplying<
                LeftDenominatorRightAndRightNumeratorLeftQuantity,
                LeftDenominatorLeftAndRightNumeratorRightQuantity,
                >,
            LeftNumeratorRightAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) = multipliedBy(right) {
        value: Decimal,
        unit: LeftNumeratorLeftUnit,
    ->
    DefaultScientificValue(value, unit)
}
