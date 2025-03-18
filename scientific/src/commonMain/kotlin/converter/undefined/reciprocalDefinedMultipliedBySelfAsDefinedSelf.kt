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
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.One
import kotlin.jvm.JvmName

// Inv<Wr<A>> * A! -> One

@JvmName("reciprocalDefinedMultipliedBySelfAsDefinedSelf")
fun <
    LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftReciprocalUnit : ScientificUnit<LeftReciprocalAndRightQuantity>,
    WrappedLeftReciprocalUnit : WrappedUndefinedExtendedUnit<
        LeftReciprocalAndRightQuantity,
        LeftReciprocalUnit,
        >,
    LeftUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Extended<
            LeftReciprocalAndRightQuantity,
            >,
        WrappedLeftReciprocalUnit,
        >,
    RightUnit : ScientificUnit<LeftReciprocalAndRightQuantity>,
    TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
    TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Extended<
            LeftReciprocalAndRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedBy(
    right: ScientificValue<LeftReciprocalAndRightQuantity, RightUnit>,
    getDimensionless: () -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = getDimensionless().byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalDefinedMultipliedByMetricAndImperialSelfAsDefinedSelf")
infix fun <
    LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftReciprocalUnit,
    WrappedLeftReciprocalUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Extended<
            LeftReciprocalAndRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: ScientificValue<LeftReciprocalAndRightQuantity, RightUnit>,
) where
        LeftReciprocalUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftReciprocalUnit : WrappedUndefinedExtendedUnit<
            LeftReciprocalAndRightQuantity,
            LeftReciprocalUnit,
            >,
        WrappedLeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Extended<
                LeftReciprocalAndRightQuantity,
                >,
            WrappedLeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
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

@JvmName("metricReciprocalDefinedMultipliedByMetricSelfAsDefinedSelf")
infix fun <
    LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftReciprocalUnit,
    WrappedLeftReciprocalUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Extended<
            LeftReciprocalAndRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: ScientificValue<LeftReciprocalAndRightQuantity, RightUnit>,
) where
        LeftReciprocalUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftReciprocalUnit : WrappedUndefinedExtendedUnit<
            LeftReciprocalAndRightQuantity,
            LeftReciprocalUnit,
            >,
        WrappedLeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Extended<
                LeftReciprocalAndRightQuantity,
                >,
            WrappedLeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
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

@JvmName("imperialReciprocalDefinedMultipliedByImperialSelfAsDefinedSelf")
infix fun <
    LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftReciprocalUnit,
    WrappedLeftReciprocalUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Extended<
            LeftReciprocalAndRightQuantity,
            >,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: ScientificValue<LeftReciprocalAndRightQuantity, RightUnit>,
) where
        LeftReciprocalUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftReciprocalUnit : WrappedUndefinedExtendedUnit<
            LeftReciprocalAndRightQuantity,
            LeftReciprocalUnit,
            >,
        WrappedLeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Extended<
                LeftReciprocalAndRightQuantity,
                >,
            WrappedLeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
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

@JvmName("ukImperialReciprocalDefinedMultipliedByUKImperialSelfAsDefinedSelf")
infix fun <
    LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftReciprocalUnit,
    WrappedLeftReciprocalUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Extended<
            LeftReciprocalAndRightQuantity,
            >,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: ScientificValue<LeftReciprocalAndRightQuantity, RightUnit>,
) where
        LeftReciprocalUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftReciprocalUnit : WrappedUndefinedExtendedUnit<
            LeftReciprocalAndRightQuantity,
            LeftReciprocalUnit,
            >,
        WrappedLeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Extended<
                LeftReciprocalAndRightQuantity,
                >,
            WrappedLeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
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

@JvmName("usCustomaryReciprocalDefinedMultipliedByUSCustomarySelfAsDefinedSelf")
infix fun <
    LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftReciprocalUnit,
    WrappedLeftReciprocalUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Extended<
            LeftReciprocalAndRightQuantity,
            >,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: ScientificValue<LeftReciprocalAndRightQuantity, RightUnit>,
) where
        LeftReciprocalUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftReciprocalUnit : WrappedUndefinedExtendedUnit<
            LeftReciprocalAndRightQuantity,
            LeftReciprocalUnit,
            >,
        WrappedLeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Extended<
                LeftReciprocalAndRightQuantity,
                >,
            WrappedLeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
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

@JvmName("metricAndUKImperialReciprocalDefinedMultipliedByMetricAndUKImperialSelfAsDefinedSelf")
infix fun <
    LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftReciprocalUnit,
    WrappedLeftReciprocalUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Extended<
            LeftReciprocalAndRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: ScientificValue<LeftReciprocalAndRightQuantity, RightUnit>,
) where
        LeftReciprocalUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftReciprocalUnit : WrappedUndefinedExtendedUnit<
            LeftReciprocalAndRightQuantity,
            LeftReciprocalUnit,
            >,
        WrappedLeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Extended<
                LeftReciprocalAndRightQuantity,
                >,
            WrappedLeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
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

@JvmName("metricAndUSCustomaryReciprocalDefinedMultipliedByMetricAndUSCustomarySelfAsDefinedSelf")
infix fun <
    LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftReciprocalUnit,
    WrappedLeftReciprocalUnit,
    LeftUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Extended<
            LeftReciprocalAndRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: ScientificValue<LeftReciprocalAndRightQuantity, RightUnit>,
) where
        LeftReciprocalUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftReciprocalUnit : WrappedUndefinedExtendedUnit<
            LeftReciprocalAndRightQuantity,
            LeftReciprocalUnit,
            >,
        WrappedLeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Extended<
                LeftReciprocalAndRightQuantity,
                >,
            WrappedLeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
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

@JvmName("genericReciprocalDefinedMultipliedByGenericSelfAsDefinedSelf")
infix fun <
    LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftReciprocalUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
    WrappedLeftReciprocalUnit : WrappedUndefinedExtendedUnit<
        LeftReciprocalAndRightQuantity,
        LeftReciprocalUnit,
        >,
    LeftUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Extended<
            LeftReciprocalAndRightQuantity,
            >,
        WrappedLeftReciprocalUnit,
        >,
    RightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Extended<
            LeftReciprocalAndRightQuantity,
            >,
        >,
    LeftUnit,
    >.genericMultipliedByGeneric(
    right: ScientificValue<LeftReciprocalAndRightQuantity, RightUnit>,
) = multipliedBy(
    right,
    getDimensionless = { One },
) {
        value: Decimal,
        unit: One,
    ->
    DefaultScientificValue(value, unit)
}
