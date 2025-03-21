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
import com.splendo.kaluga.scientific.unit.DefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// A * Div<Wr<B>, A> -> B!

@JvmName("multipliedByDividingUnitWithDefinedNumeratorAndSelfAsDenominator")
fun <
    LeftAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftUnit : AbstractUndefinedScientificUnit<LeftAndRightDenominatorQuantity>,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit : ScientificUnit<RightNumeratorQuantity>,
    WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
        RightNumeratorQuantity,
        RightNumeratorUnit,
        >,
    RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftAndRightDenominatorQuantity>,
    RightUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Extended<
            RightNumeratorQuantity,
            >,
        WrappedRightNumeratorUnit,
        LeftAndRightDenominatorQuantity,
        RightDenominatorUnit,
        >,
    RightNumeratorValue : ScientificValue<RightNumeratorQuantity, RightNumeratorUnit>,
    > UndefinedScientificValue<
    LeftAndRightDenominatorQuantity,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            LeftAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
    factory: (Decimal, RightNumeratorUnit) -> RightNumeratorValue,
) = right.unit.numerator.wrapped.byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultipliedByMetricAndImperialDividingUnitWithDefinedNumeratorAndSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightDenominatorQuantity,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            LeftAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractUndefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : DefinedScientificUnit<RightNumeratorQuantity>,
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
        RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            LeftAndRightDenominatorQuantity,
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

@JvmName("metricMultipliedByMetricDividingUnitWithDefinedNumeratorAndSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightDenominatorQuantity,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            LeftAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractUndefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : DefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            >,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            LeftAndRightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialMultipliedByImperialDividingUnitWithDefinedNumeratorAndSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightDenominatorQuantity,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            LeftAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractUndefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : DefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            >,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            LeftAndRightDenominatorQuantity,
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

@JvmName("ukImperialMultipliedByUKImperialDividingUnitWithDefinedNumeratorAndSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightDenominatorQuantity,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            LeftAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractUndefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : DefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            >,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            LeftAndRightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryMultipliedByUSCustomaryDividingUnitWithDefinedNumeratorAndSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightDenominatorQuantity,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            LeftAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractUndefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : DefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            >,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            LeftAndRightDenominatorQuantity,
            RightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultipliedByMetricAndUKImperialDividingUnitWithDefinedNumeratorAndSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightDenominatorQuantity,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            LeftAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractUndefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : DefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            >,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            LeftAndRightDenominatorQuantity,
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

@JvmName("metricAndUSCustomaryMultipliedByMetricAndUSCustomaryDividingUnitWithDefinedNumeratorAndSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    RightDenominatorUnit,
    RightUnit,
    > UndefinedScientificValue<
    LeftAndRightDenominatorQuantity,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            LeftAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractUndefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : DefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            >,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        RightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            LeftAndRightDenominatorQuantity,
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

@JvmName("genericMultipliedByGenericDividingUnitWithDefinedNumeratorAndSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : UndefinedQuantityType,
    LeftUnit : AbstractUndefinedScientificUnit<LeftAndRightDenominatorQuantity>,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit : DefinedScientificUnit<RightNumeratorQuantity>,
    WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
        RightNumeratorQuantity,
        RightNumeratorUnit,
        >,
    RightDenominatorUnit : AbstractUndefinedScientificUnit<LeftAndRightDenominatorQuantity>,
    RightUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Extended<
            RightNumeratorQuantity,
            >,
        WrappedRightNumeratorUnit,
        LeftAndRightDenominatorQuantity,
        RightDenominatorUnit,
        >,
    > UndefinedScientificValue<
    LeftAndRightDenominatorQuantity,
    LeftUnit,
    >.genericMultipliedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            LeftAndRightDenominatorQuantity,
            >,
        RightUnit,
        >,
) = multipliedBy(right) {
        value: Decimal,
        unit: RightNumeratorUnit,
    ->
    DefaultScientificValue(value, unit)
}
