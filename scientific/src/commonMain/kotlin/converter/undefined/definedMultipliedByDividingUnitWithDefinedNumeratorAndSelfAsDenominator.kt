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
import com.splendo.kaluga.scientific.unit.UndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// A! * Div<Wr<B>, Ex<A>> -> B!

@JvmName("definedMultipliedByDividingUnitWithDefinedNumeratorAndSelfAsDenominator")
fun <
    LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit : ScientificUnit<LeftAndRightDenominatorQuantity>,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit : ScientificUnit<RightNumeratorQuantity>,
    WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
        RightNumeratorQuantity,
        RightNumeratorUnit,
        >,
    ExtendedRightDenominatorUnit : UndefinedExtendedUnit<
        LeftAndRightDenominatorQuantity,
        >,
    RightUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Extended<
            RightNumeratorQuantity,
            >,
        WrappedRightNumeratorUnit,
        UndefinedQuantityType.Extended<
            LeftAndRightDenominatorQuantity,
            >,
        ExtendedRightDenominatorUnit,
        >,
    RightNumeratorValue : ScientificValue<RightNumeratorQuantity, RightNumeratorUnit>,
    > ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            >,
        RightUnit,
        >,
    factory: (Decimal, RightNumeratorUnit) -> RightNumeratorValue,
) = right.unit.numerator.wrapped.byMultiplying(this, right, factory)

@JvmName("metricAndImperialDefinedMultipliedByMetricAndImperialDividingUnitWithDefinedNumeratorAndSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    ExtendedRightDenominatorUnit,
    RightUnit,
    > ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
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
        ExtendedRightDenominatorUnit : UndefinedExtendedUnit<
            LeftAndRightDenominatorQuantity,
            >,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            ExtendedRightDenominatorUnit,
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

@JvmName("metricDefinedMultipliedByMetricDividingUnitWithDefinedNumeratorAndSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    ExtendedRightDenominatorUnit,
    RightUnit,
    > ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : AbstractScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            >,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInMetric,
        ExtendedRightDenominatorUnit : UndefinedExtendedUnit<
            LeftAndRightDenominatorQuantity,
            >,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            ExtendedRightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialDefinedMultipliedByImperialDividingUnitWithDefinedNumeratorAndSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    ExtendedRightDenominatorUnit,
    RightUnit,
    > ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
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
        ExtendedRightDenominatorUnit : UndefinedExtendedUnit<
            LeftAndRightDenominatorQuantity,
            >,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            ExtendedRightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialDefinedMultipliedByUKImperialDividingUnitWithDefinedNumeratorAndSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    ExtendedRightDenominatorUnit,
    RightUnit,
    > ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : AbstractScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            >,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedRightDenominatorUnit : UndefinedExtendedUnit<
            LeftAndRightDenominatorQuantity,
            >,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            ExtendedRightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryDefinedMultipliedByUSCustomaryDividingUnitWithDefinedNumeratorAndSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    ExtendedRightDenominatorUnit,
    RightUnit,
    > ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : AbstractScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
            >,
        WrappedRightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedRightDenominatorUnit : UndefinedExtendedUnit<
            LeftAndRightDenominatorQuantity,
            >,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            ExtendedRightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDefinedMultipliedByMetricAndUKImperialDividingUnitWithDefinedNumeratorAndSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    ExtendedRightDenominatorUnit,
    RightUnit,
    > ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
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
        ExtendedRightDenominatorUnit : UndefinedExtendedUnit<
            LeftAndRightDenominatorQuantity,
            >,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            ExtendedRightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDefinedMultipliedByMetricAndUSCustomaryDividingUnitWithDefinedNumeratorAndSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit,
    WrappedRightNumeratorUnit,
    ExtendedRightDenominatorUnit,
    RightUnit,
    > ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
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
        ExtendedRightDenominatorUnit : UndefinedExtendedUnit<
            LeftAndRightDenominatorQuantity,
            >,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            WrappedRightNumeratorUnit,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            ExtendedRightDenominatorUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: RightNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericDefinedMultipliedByGenericDividingUnitWithDefinedNumeratorAndSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
    RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightNumeratorUnit : AbstractScientificUnit<RightNumeratorQuantity>,
    WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<
        RightNumeratorQuantity,
        RightNumeratorUnit,
        >,
    ExtendedRightDenominatorUnit : UndefinedExtendedUnit<
        LeftAndRightDenominatorQuantity,
        >,
    RightUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Extended<
            RightNumeratorQuantity,
            >,
        WrappedRightNumeratorUnit,
        UndefinedQuantityType.Extended<
            LeftAndRightDenominatorQuantity,
            >,
        ExtendedRightDenominatorUnit,
        >,
    > ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.genericMultipliedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            UndefinedQuantityType.Extended<
                RightNumeratorQuantity,
                >,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
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
