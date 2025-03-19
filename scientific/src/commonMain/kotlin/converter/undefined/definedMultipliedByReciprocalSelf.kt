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
import com.splendo.kaluga.scientific.unit.Dimensionless
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.One
import kotlin.jvm.JvmName

// A! * Inv<Ex<A>> -> One

@JvmName("definedMultipliedByReciprocalSelf")
fun <
    LeftAndRightReciprocalQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit : ScientificUnit<LeftAndRightReciprocalQuantity>,
    ExtendedRightReciprocalUnit : UndefinedExtendedUnit<
        LeftAndRightReciprocalQuantity,
        >,
    RightUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Extended<
            LeftAndRightReciprocalQuantity,
            >,
        ExtendedRightReciprocalUnit,
        >,
    TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
    TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>,
    > ScientificValue<LeftAndRightReciprocalQuantity, LeftUnit>.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Extended<
                LeftAndRightReciprocalQuantity,
                >,
            >,
        RightUnit,
        >,
    getDimensionless: () -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = getDimensionless().byMultiplying(this, right, factory)

@JvmName("metricAndImperialDefinedMultipliedByMetricAndImperialReciprocalSelf")
infix fun <
    LeftAndRightReciprocalQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    ExtendedRightReciprocalUnit,
    RightUnit,
    > ScientificValue<LeftAndRightReciprocalQuantity, LeftUnit>.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Extended<
                LeftAndRightReciprocalQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractScientificUnit<LeftAndRightReciprocalQuantity>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedRightReciprocalUnit : UndefinedExtendedUnit<
            LeftAndRightReciprocalQuantity,
            >,
        ExtendedRightReciprocalUnit : MeasurementUsage.UsedInMetric,
        ExtendedRightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedRightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Extended<
                LeftAndRightReciprocalQuantity,
                >,
            ExtendedRightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricDefinedMultipliedByMetricReciprocalSelf")
infix fun <
    LeftAndRightReciprocalQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    ExtendedRightReciprocalUnit,
    RightUnit,
    > ScientificValue<LeftAndRightReciprocalQuantity, LeftUnit>.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Extended<
                LeftAndRightReciprocalQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractScientificUnit<LeftAndRightReciprocalQuantity>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        ExtendedRightReciprocalUnit : UndefinedExtendedUnit<
            LeftAndRightReciprocalQuantity,
            >,
        ExtendedRightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Extended<
                LeftAndRightReciprocalQuantity,
                >,
            ExtendedRightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialDefinedMultipliedByImperialReciprocalSelf")
infix fun <
    LeftAndRightReciprocalQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    ExtendedRightReciprocalUnit,
    RightUnit,
    > ScientificValue<LeftAndRightReciprocalQuantity, LeftUnit>.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Extended<
                LeftAndRightReciprocalQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractScientificUnit<LeftAndRightReciprocalQuantity>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedRightReciprocalUnit : UndefinedExtendedUnit<
            LeftAndRightReciprocalQuantity,
            >,
        ExtendedRightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedRightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Extended<
                LeftAndRightReciprocalQuantity,
                >,
            ExtendedRightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialDefinedMultipliedByUKImperialReciprocalSelf")
infix fun <
    LeftAndRightReciprocalQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    ExtendedRightReciprocalUnit,
    RightUnit,
    > ScientificValue<LeftAndRightReciprocalQuantity, LeftUnit>.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Extended<
                LeftAndRightReciprocalQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractScientificUnit<LeftAndRightReciprocalQuantity>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedRightReciprocalUnit : UndefinedExtendedUnit<
            LeftAndRightReciprocalQuantity,
            >,
        ExtendedRightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Extended<
                LeftAndRightReciprocalQuantity,
                >,
            ExtendedRightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryDefinedMultipliedByUSCustomaryReciprocalSelf")
infix fun <
    LeftAndRightReciprocalQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    ExtendedRightReciprocalUnit,
    RightUnit,
    > ScientificValue<LeftAndRightReciprocalQuantity, LeftUnit>.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Extended<
                LeftAndRightReciprocalQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractScientificUnit<LeftAndRightReciprocalQuantity>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedRightReciprocalUnit : UndefinedExtendedUnit<
            LeftAndRightReciprocalQuantity,
            >,
        ExtendedRightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Extended<
                LeftAndRightReciprocalQuantity,
                >,
            ExtendedRightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialDefinedMultipliedByMetricAndUKImperialReciprocalSelf")
infix fun <
    LeftAndRightReciprocalQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    ExtendedRightReciprocalUnit,
    RightUnit,
    > ScientificValue<LeftAndRightReciprocalQuantity, LeftUnit>.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Extended<
                LeftAndRightReciprocalQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractScientificUnit<LeftAndRightReciprocalQuantity>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        ExtendedRightReciprocalUnit : UndefinedExtendedUnit<
            LeftAndRightReciprocalQuantity,
            >,
        ExtendedRightReciprocalUnit : MeasurementUsage.UsedInMetric,
        ExtendedRightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Extended<
                LeftAndRightReciprocalQuantity,
                >,
            ExtendedRightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryDefinedMultipliedByMetricAndUSCustomaryReciprocalSelf")
infix fun <
    LeftAndRightReciprocalQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit,
    ExtendedRightReciprocalUnit,
    RightUnit,
    > ScientificValue<LeftAndRightReciprocalQuantity, LeftUnit>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Extended<
                LeftAndRightReciprocalQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftUnit : AbstractScientificUnit<LeftAndRightReciprocalQuantity>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        ExtendedRightReciprocalUnit : UndefinedExtendedUnit<
            LeftAndRightReciprocalQuantity,
            >,
        ExtendedRightReciprocalUnit : MeasurementUsage.UsedInMetric,
        ExtendedRightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Extended<
                LeftAndRightReciprocalQuantity,
                >,
            ExtendedRightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(
        right,
        getDimensionless = { One },
    ) {
            value: Decimal,
            unit: One,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericDefinedMultipliedByGenericReciprocalSelf")
infix fun <
    LeftAndRightReciprocalQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftUnit : AbstractScientificUnit<LeftAndRightReciprocalQuantity>,
    ExtendedRightReciprocalUnit : UndefinedExtendedUnit<
        LeftAndRightReciprocalQuantity,
        >,
    RightUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Extended<
            LeftAndRightReciprocalQuantity,
            >,
        ExtendedRightReciprocalUnit,
        >,
    > ScientificValue<LeftAndRightReciprocalQuantity, LeftUnit>.genericMultipliedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            UndefinedQuantityType.Extended<
                LeftAndRightReciprocalQuantity,
                >,
            >,
        RightUnit,
        >,
) = multipliedBy(
    right,
    getDimensionless = { One },
) {
        value: Decimal,
        unit: One,
    ->
    DefaultScientificValue(value, unit)
}
