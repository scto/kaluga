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
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.DefinedScientificUnit
import com.splendo.kaluga.scientific.unit.Dimensionless
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.One
import kotlin.jvm.JvmName

// A! / Ex<A> -> One

@JvmName("definedDividedBySelf")
fun <
    NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit : ScientificUnit<NumeratorAndDenominatorQuantity>,
    ExtendedDenominatorUnit : UndefinedExtendedUnit<
        NumeratorAndDenominatorQuantity,
        >,
    TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
    TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>,
    > ScientificValue<NumeratorAndDenominatorQuantity, NumeratorUnit>.dividedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Extended<
            NumeratorAndDenominatorQuantity,
            >,
        ExtendedDenominatorUnit,
        >,
    getDimensionless: () -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = getDimensionless().byDividing(this, right, factory)

@JvmName("metricAndImperialDefinedDividedByMetricAndImperialSelf")
infix fun <
    NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorQuantity, NumeratorUnit>.metricAndImperialDividedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Extended<
            NumeratorAndDenominatorQuantity,
            >,
        ExtendedDenominatorUnit,
        >,
) where
        NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedDenominatorUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorQuantity,
            >,
        ExtendedDenominatorUnit : MeasurementUsage.UsedInMetric,
        ExtendedDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedDenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricDefinedDividedByMetricSelf")
infix fun <
    NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorQuantity, NumeratorUnit>.metricDividedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Extended<
            NumeratorAndDenominatorQuantity,
            >,
        ExtendedDenominatorUnit,
        >,
) where
        NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        ExtendedDenominatorUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorQuantity,
            >,
        ExtendedDenominatorUnit : MeasurementUsage.UsedInMetric =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialDefinedDividedByImperialSelf")
infix fun <
    NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorQuantity, NumeratorUnit>.imperialDividedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Extended<
            NumeratorAndDenominatorQuantity,
            >,
        ExtendedDenominatorUnit,
        >,
) where
        NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedDenominatorUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorQuantity,
            >,
        ExtendedDenominatorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedDenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialDefinedDividedByUKImperialSelf")
infix fun <
    NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorQuantity, NumeratorUnit>.ukImperialDividedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Extended<
            NumeratorAndDenominatorQuantity,
            >,
        ExtendedDenominatorUnit,
        >,
) where
        NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedDenominatorUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorQuantity,
            >,
        ExtendedDenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryDefinedDividedByUSCustomarySelf")
infix fun <
    NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorQuantity, NumeratorUnit>.usCustomaryDividedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Extended<
            NumeratorAndDenominatorQuantity,
            >,
        ExtendedDenominatorUnit,
        >,
) where
        NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedDenominatorUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorQuantity,
            >,
        ExtendedDenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDefinedDividedByMetricAndUKImperialSelf")
infix fun <
    NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorQuantity, NumeratorUnit>.metricAndUKImperialDividedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Extended<
            NumeratorAndDenominatorQuantity,
            >,
        ExtendedDenominatorUnit,
        >,
) where
        NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedDenominatorUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorQuantity,
            >,
        ExtendedDenominatorUnit : MeasurementUsage.UsedInMetric,
        ExtendedDenominatorUnit : MeasurementUsage.UsedInUKImperial =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDefinedDividedByMetricAndUSCustomarySelf")
infix fun <
    NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit,
    ExtendedDenominatorUnit,
    > ScientificValue<NumeratorAndDenominatorQuantity, NumeratorUnit>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Extended<
            NumeratorAndDenominatorQuantity,
            >,
        ExtendedDenominatorUnit,
        >,
) where
        NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorQuantity>,
        NumeratorUnit : MeasurementUsage.UsedInMetric,
        NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedDenominatorUnit : UndefinedExtendedUnit<
            NumeratorAndDenominatorQuantity,
            >,
        ExtendedDenominatorUnit : MeasurementUsage.UsedInMetric,
        ExtendedDenominatorUnit : MeasurementUsage.UsedInUSCustomary =
    dividedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericDefinedDividedByGenericSelf")
infix fun <
    NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorQuantity>,
    ExtendedDenominatorUnit : UndefinedExtendedUnit<
        NumeratorAndDenominatorQuantity,
        >,
    > ScientificValue<NumeratorAndDenominatorQuantity, NumeratorUnit>.genericDividedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Extended<
            NumeratorAndDenominatorQuantity,
            >,
        ExtendedDenominatorUnit,
        >,
) = dividedBy(
    right,
    getDimensionless = { One },
) {
        value: Decimal,
        unit: One,
    ->
    DefaultScientificValue(value, unit)
}
