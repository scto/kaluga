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
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Div<Wr<A>, Wr<B>> * B! -> A!

@JvmName("dividingWithDefinedNumeratorAndDefinedDenominatorMultipliedByDenominator")
fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit : ScientificUnit<LeftNumeratorQuantity>,
    WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
        LeftNumeratorQuantity,
        LeftNumeratorUnit,
        >,
    LeftDenominatorAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftDenominatorUnit : ScientificUnit<LeftDenominatorAndRightQuantity>,
    WrappedLeftDenominatorUnit : WrappedUndefinedExtendedUnit<
        LeftDenominatorAndRightQuantity,
        LeftDenominatorUnit,
        >,
    LeftUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        WrappedLeftNumeratorUnit,
        UndefinedQuantityType.Extended<
            LeftDenominatorAndRightQuantity,
            >,
        WrappedLeftDenominatorUnit,
        >,
    RightUnit : ScientificUnit<LeftDenominatorAndRightQuantity>,
    LeftNumeratorValue : ScientificValue<LeftNumeratorQuantity, LeftNumeratorUnit>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        UndefinedQuantityType.Extended<
            LeftDenominatorAndRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedBy(
    right: ScientificValue<LeftDenominatorAndRightQuantity, RightUnit>,
    factory: (Decimal, LeftNumeratorUnit) -> LeftNumeratorValue,
) = unit.numerator.wrapped.byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithDefinedNumeratorAndDefinedDenominatorMultipliedByMetricAndImperialDenominator")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftDenominatorUnit,
    WrappedLeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        UndefinedQuantityType.Extended<
            LeftDenominatorAndRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: ScientificValue<LeftDenominatorAndRightQuantity, RightUnit>,
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
        LeftDenominatorUnit : AbstractScientificUnit<LeftDenominatorAndRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftDenominatorUnit : WrappedUndefinedExtendedUnit<
            LeftDenominatorAndRightQuantity,
            LeftDenominatorUnit,
            >,
        WrappedLeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorQuantity,
                >,
            WrappedLeftNumeratorUnit,
            UndefinedQuantityType.Extended<
                LeftDenominatorAndRightQuantity,
                >,
            WrappedLeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : AbstractScientificUnit<LeftDenominatorAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricDividingWithDefinedNumeratorAndDefinedDenominatorMultipliedByMetricDenominator")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftDenominatorUnit,
    WrappedLeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        UndefinedQuantityType.Extended<
            LeftDenominatorAndRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: ScientificValue<LeftDenominatorAndRightQuantity, RightUnit>,
) where
        LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            >,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : AbstractScientificUnit<LeftDenominatorAndRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftDenominatorUnit : WrappedUndefinedExtendedUnit<
            LeftDenominatorAndRightQuantity,
            LeftDenominatorUnit,
            >,
        WrappedLeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorQuantity,
                >,
            WrappedLeftNumeratorUnit,
            UndefinedQuantityType.Extended<
                LeftDenominatorAndRightQuantity,
                >,
            WrappedLeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightUnit : AbstractScientificUnit<LeftDenominatorAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialDividingWithDefinedNumeratorAndDefinedDenominatorMultipliedByImperialDenominator")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftDenominatorUnit,
    WrappedLeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        UndefinedQuantityType.Extended<
            LeftDenominatorAndRightQuantity,
            >,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: ScientificValue<LeftDenominatorAndRightQuantity, RightUnit>,
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
        LeftDenominatorUnit : AbstractScientificUnit<LeftDenominatorAndRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftDenominatorUnit : WrappedUndefinedExtendedUnit<
            LeftDenominatorAndRightQuantity,
            LeftDenominatorUnit,
            >,
        WrappedLeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorQuantity,
                >,
            WrappedLeftNumeratorUnit,
            UndefinedQuantityType.Extended<
                LeftDenominatorAndRightQuantity,
                >,
            WrappedLeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : AbstractScientificUnit<LeftDenominatorAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialDividingWithDefinedNumeratorAndDefinedDenominatorMultipliedByUKImperialDenominator")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftDenominatorUnit,
    WrappedLeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        UndefinedQuantityType.Extended<
            LeftDenominatorAndRightQuantity,
            >,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: ScientificValue<LeftDenominatorAndRightQuantity, RightUnit>,
) where
        LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            >,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
        LeftDenominatorUnit : AbstractScientificUnit<LeftDenominatorAndRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftDenominatorUnit : WrappedUndefinedExtendedUnit<
            LeftDenominatorAndRightQuantity,
            LeftDenominatorUnit,
            >,
        WrappedLeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorQuantity,
                >,
            WrappedLeftNumeratorUnit,
            UndefinedQuantityType.Extended<
                LeftDenominatorAndRightQuantity,
                >,
            WrappedLeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : AbstractScientificUnit<LeftDenominatorAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryDividingWithDefinedNumeratorAndDefinedDenominatorMultipliedByUSCustomaryDenominator")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftDenominatorUnit,
    WrappedLeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        UndefinedQuantityType.Extended<
            LeftDenominatorAndRightQuantity,
            >,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: ScientificValue<LeftDenominatorAndRightQuantity, RightUnit>,
) where
        LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
        LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
            LeftNumeratorQuantity,
            LeftNumeratorUnit,
            >,
        WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftDenominatorUnit : AbstractScientificUnit<LeftDenominatorAndRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftDenominatorUnit : WrappedUndefinedExtendedUnit<
            LeftDenominatorAndRightQuantity,
            LeftDenominatorUnit,
            >,
        WrappedLeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorQuantity,
                >,
            WrappedLeftNumeratorUnit,
            UndefinedQuantityType.Extended<
                LeftDenominatorAndRightQuantity,
                >,
            WrappedLeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : AbstractScientificUnit<LeftDenominatorAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDividingWithDefinedNumeratorAndDefinedDenominatorMultipliedByMetricAndUKImperialDenominator")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftDenominatorUnit,
    WrappedLeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        UndefinedQuantityType.Extended<
            LeftDenominatorAndRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: ScientificValue<LeftDenominatorAndRightQuantity, RightUnit>,
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
        LeftDenominatorUnit : AbstractScientificUnit<LeftDenominatorAndRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftDenominatorUnit : WrappedUndefinedExtendedUnit<
            LeftDenominatorAndRightQuantity,
            LeftDenominatorUnit,
            >,
        WrappedLeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorQuantity,
                >,
            WrappedLeftNumeratorUnit,
            UndefinedQuantityType.Extended<
                LeftDenominatorAndRightQuantity,
                >,
            WrappedLeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : AbstractScientificUnit<LeftDenominatorAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDividingWithDefinedNumeratorAndDefinedDenominatorMultipliedByMetricAndUSCustomaryDenominator")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit,
    WrappedLeftNumeratorUnit,
    LeftDenominatorAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftDenominatorUnit,
    WrappedLeftDenominatorUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        UndefinedQuantityType.Extended<
            LeftDenominatorAndRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: ScientificValue<LeftDenominatorAndRightQuantity, RightUnit>,
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
        LeftDenominatorUnit : AbstractScientificUnit<LeftDenominatorAndRightQuantity>,
        LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftDenominatorUnit : WrappedUndefinedExtendedUnit<
            LeftDenominatorAndRightQuantity,
            LeftDenominatorUnit,
            >,
        WrappedLeftDenominatorUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedDividedUnit<
            UndefinedQuantityType.Extended<
                LeftNumeratorQuantity,
                >,
            WrappedLeftNumeratorUnit,
            UndefinedQuantityType.Extended<
                LeftDenominatorAndRightQuantity,
                >,
            WrappedLeftDenominatorUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : AbstractScientificUnit<LeftDenominatorAndRightQuantity>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftNumeratorUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericDividingWithDefinedNumeratorAndDefinedDenominatorMultipliedByGenericDenominator")
infix fun <
    LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
    WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
        LeftNumeratorQuantity,
        LeftNumeratorUnit,
        >,
    LeftDenominatorAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftDenominatorUnit : AbstractScientificUnit<LeftDenominatorAndRightQuantity>,
    WrappedLeftDenominatorUnit : WrappedUndefinedExtendedUnit<
        LeftDenominatorAndRightQuantity,
        LeftDenominatorUnit,
        >,
    LeftUnit : UndefinedDividedUnit<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        WrappedLeftNumeratorUnit,
        UndefinedQuantityType.Extended<
            LeftDenominatorAndRightQuantity,
            >,
        WrappedLeftDenominatorUnit,
        >,
    RightUnit : AbstractScientificUnit<LeftDenominatorAndRightQuantity>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Dividing<
        UndefinedQuantityType.Extended<
            LeftNumeratorQuantity,
            >,
        UndefinedQuantityType.Extended<
            LeftDenominatorAndRightQuantity,
            >,
        >,
    LeftUnit,
    >.genericMultipliedByGeneric(
    right: ScientificValue<LeftDenominatorAndRightQuantity, RightUnit>,
) = multipliedBy(right) {
        value: Decimal,
        unit: LeftNumeratorUnit,
    ->
    DefaultScientificValue(value, unit)
}
