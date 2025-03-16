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
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Div<Wr<A>, B> * B -> A!

@JvmName("dividingWithDefinedNumeratorMultipliedByDenominator")
fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit : ScientificUnit<LeftNumeratorQuantity>,
    WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<LeftNumeratorQuantity, LeftNumeratorUnit>,
    LeftDenominatorAndRightQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
    LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<LeftNumeratorQuantity>, WrappedLeftNumeratorUnit, LeftDenominatorAndRightQuantity, LeftDenominatorAndRightUnit>,
    LeftNumeratorValue : ScientificValue<LeftNumeratorQuantity, LeftNumeratorUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<LeftNumeratorQuantity>, LeftDenominatorAndRightQuantity>, LeftUnit>.multipliedByDenominator(
    right: UndefinedScientificValue<LeftDenominatorAndRightQuantity, LeftDenominatorAndRightUnit>,
    factory: (Decimal, LeftNumeratorUnit) -> LeftNumeratorValue,
) = unit.numerator.wrapped.byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithDefinedNumeratorMultipliedByMetricAndImperialDenominator")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorAndRightQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightUnit,
    LeftUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<LeftNumeratorQuantity>, LeftDenominatorAndRightQuantity>, LeftUnit>.multipliedByDenominator(
    right: UndefinedScientificValue<LeftDenominatorAndRightQuantity, LeftDenominatorAndRightUnit>,
) where
        LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<LeftNumeratorQuantity, LeftNumeratorUnit>,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorAndRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
        LeftDenominatorAndRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorAndRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<LeftNumeratorQuantity>, WrappedLeftNumeratorUnit, LeftDenominatorAndRightQuantity, LeftDenominatorAndRightUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDenominator(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricDividingWithDefinedNumeratorMultipliedByMetricDenominator")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorAndRightQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightUnit,
    LeftUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<LeftNumeratorQuantity>, LeftDenominatorAndRightQuantity>, LeftUnit>.multipliedByDenominator(
    right: UndefinedScientificValue<LeftDenominatorAndRightQuantity, LeftDenominatorAndRightUnit>,
) where
        LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<LeftNumeratorQuantity, LeftNumeratorUnit>,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorAndRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
        LeftDenominatorAndRightUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<LeftNumeratorQuantity>, WrappedLeftNumeratorUnit, LeftDenominatorAndRightQuantity, LeftDenominatorAndRightUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric =
    multipliedByDenominator(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialDividingWithDefinedNumeratorMultipliedByImperialDenominator")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorAndRightQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightUnit,
    LeftUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<LeftNumeratorQuantity>, LeftDenominatorAndRightQuantity>, LeftUnit>.multipliedByDenominator(
    right: UndefinedScientificValue<LeftDenominatorAndRightQuantity, LeftDenominatorAndRightUnit>,
) where
        LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<LeftNumeratorQuantity, LeftNumeratorUnit>,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorAndRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
        LeftDenominatorAndRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<LeftNumeratorQuantity>, WrappedLeftNumeratorUnit, LeftDenominatorAndRightQuantity, LeftDenominatorAndRightUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDenominator(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialDividingWithDefinedNumeratorMultipliedByUKImperialDenominator")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorAndRightQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightUnit,
    LeftUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<LeftNumeratorQuantity>, LeftDenominatorAndRightQuantity>, LeftUnit>.multipliedByDenominator(
    right: UndefinedScientificValue<LeftDenominatorAndRightQuantity, LeftDenominatorAndRightUnit>,
) where
        LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<LeftNumeratorQuantity, LeftNumeratorUnit>,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorAndRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
        LeftDenominatorAndRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<LeftNumeratorQuantity>, WrappedLeftNumeratorUnit, LeftDenominatorAndRightQuantity, LeftDenominatorAndRightUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByDenominator(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingWithDefinedNumeratorMultipliedByUSCustomaryDenominator")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorAndRightQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightUnit,
    LeftUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<LeftNumeratorQuantity>, LeftDenominatorAndRightQuantity>, LeftUnit>.multipliedByDenominator(
    right: UndefinedScientificValue<LeftDenominatorAndRightQuantity, LeftDenominatorAndRightUnit>,
) where
        LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<LeftNumeratorQuantity, LeftNumeratorUnit>,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorAndRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
        LeftDenominatorAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<LeftNumeratorQuantity>, WrappedLeftNumeratorUnit, LeftDenominatorAndRightQuantity, LeftDenominatorAndRightUnit>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDenominator(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividingWithDefinedNumeratorMultipliedByMetricAndUKImperialDenominator")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorAndRightQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightUnit,
    LeftUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<LeftNumeratorQuantity>, LeftDenominatorAndRightQuantity>, LeftUnit>.multipliedByDenominator(
    right: UndefinedScientificValue<LeftDenominatorAndRightQuantity, LeftDenominatorAndRightUnit>,
) where
        LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<LeftNumeratorQuantity, LeftNumeratorUnit>,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorAndRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
        LeftDenominatorAndRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorAndRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<LeftNumeratorQuantity>, WrappedLeftNumeratorUnit, LeftDenominatorAndRightQuantity, LeftDenominatorAndRightUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByDenominator(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDividingWithDefinedNumeratorMultipliedByMetricAndUSCustomaryDenominator")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorAndRightQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightUnit,
    LeftUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<LeftNumeratorQuantity>, LeftDenominatorAndRightQuantity>, LeftUnit>.multipliedByDenominator(
    right: UndefinedScientificValue<LeftDenominatorAndRightQuantity, LeftDenominatorAndRightUnit>,
) where
        LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<LeftNumeratorQuantity, LeftNumeratorUnit>,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorAndRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
        LeftDenominatorAndRightUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<LeftNumeratorQuantity>, WrappedLeftNumeratorUnit, LeftDenominatorAndRightQuantity, LeftDenominatorAndRightUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByDenominator(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericDividingWithDefinedNumeratorMultipliedByGenericDenominator")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
    WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<LeftNumeratorQuantity, LeftNumeratorUnit>,
    LeftDenominatorAndRightQuantity : UndefinedQuantityType,
    LeftDenominatorAndRightUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
    LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<LeftNumeratorQuantity>, WrappedLeftNumeratorUnit, LeftDenominatorAndRightQuantity, LeftDenominatorAndRightUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<LeftNumeratorQuantity>, LeftDenominatorAndRightQuantity>, LeftUnit>.multipliedByDenominator(
    right: UndefinedScientificValue<LeftDenominatorAndRightQuantity, LeftDenominatorAndRightUnit>,
) = multipliedByDenominator(right) {
        value: Decimal,
        unit: LeftNumeratorUnit,
    ->
    DefaultScientificValue(value, unit)
}
