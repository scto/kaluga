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
import com.splendo.kaluga.scientific.unit.DefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import kotlin.jvm.JvmName

// A! * Div<B, Ex<A>> -> B

@JvmName("definedMultipliedByDividingUnitWithSelfAsDenominator")
fun <
    LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit : ScientificUnit<LeftAndRightDenominatorQuantity>,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
    ExtendedRightDenominatorUnit : UndefinedExtendedUnit<
        LeftAndRightDenominatorQuantity,
        >,
    RightUnit : UndefinedDividedUnit<
        RightNumeratorQuantity,
        RightNumeratorUnit,
        UndefinedQuantityType.Extended<
            LeftAndRightDenominatorQuantity,
            >,
        ExtendedRightDenominatorUnit,
        >,
    RightNumeratorValue : UndefinedScientificValue<
        RightNumeratorQuantity,
        RightNumeratorUnit,
        >,
    > ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            >,
        RightUnit,
        >,
    factory: (Decimal, RightNumeratorUnit) -> RightNumeratorValue,
) = right.unit.numerator.byMultiplying(this, right, factory)

@JvmName("metricAndImperialDefinedMultipliedByMetricAndImperialDividingUnitWithSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    ExtendedRightDenominatorUnit,
    RightUnit,
    > ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedRightDenominatorUnit : UndefinedExtendedUnit<
            LeftAndRightDenominatorQuantity,
            >,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
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
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricDefinedMultipliedByMetricDividingUnitWithSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    ExtendedRightDenominatorUnit,
    RightUnit,
    > ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        ExtendedRightDenominatorUnit : UndefinedExtendedUnit<
            LeftAndRightDenominatorQuantity,
            >,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
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
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialDefinedMultipliedByImperialDividingUnitWithSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    ExtendedRightDenominatorUnit,
    RightUnit,
    > ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedRightDenominatorUnit : UndefinedExtendedUnit<
            LeftAndRightDenominatorQuantity,
            >,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
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
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialDefinedMultipliedByUKImperialDividingUnitWithSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    ExtendedRightDenominatorUnit,
    RightUnit,
    > ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedRightDenominatorUnit : UndefinedExtendedUnit<
            LeftAndRightDenominatorQuantity,
            >,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
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
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryDefinedMultipliedByUSCustomaryDividingUnitWithSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    ExtendedRightDenominatorUnit,
    RightUnit,
    > ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedRightDenominatorUnit : UndefinedExtendedUnit<
            LeftAndRightDenominatorQuantity,
            >,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
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
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDefinedMultipliedByMetricAndUKImperialDividingUnitWithSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    ExtendedRightDenominatorUnit,
    RightUnit,
    > ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedRightDenominatorUnit : UndefinedExtendedUnit<
            LeftAndRightDenominatorQuantity,
            >,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
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
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDefinedMultipliedByMetricAndUSCustomaryDividingUnitWithSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit,
    ExtendedRightDenominatorUnit,
    RightUnit,
    > ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
            UndefinedQuantityType.Extended<
                LeftAndRightDenominatorQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorQuantity>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
        RightNumeratorUnit : MeasurementUsage.UsedInMetric,
        RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedRightDenominatorUnit : UndefinedExtendedUnit<
            LeftAndRightDenominatorQuantity,
            >,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInMetric,
        ExtendedRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedDividedUnit<
            RightNumeratorQuantity,
            RightNumeratorUnit,
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
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("genericDefinedMultipliedByGenericDividingUnitWithSelfAsDenominator")
infix fun <
    LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit : DefinedScientificUnit<LeftAndRightDenominatorQuantity>,
    RightNumeratorQuantity : UndefinedQuantityType,
    RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
    ExtendedRightDenominatorUnit : UndefinedExtendedUnit<
        LeftAndRightDenominatorQuantity,
        >,
    RightUnit : UndefinedDividedUnit<
        RightNumeratorQuantity,
        RightNumeratorUnit,
        UndefinedQuantityType.Extended<
            LeftAndRightDenominatorQuantity,
            >,
        ExtendedRightDenominatorUnit,
        >,
    > ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.genericMultipliedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Dividing<
            RightNumeratorQuantity,
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
    DefaultUndefinedScientificValue(value, unit)
}
