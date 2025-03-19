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
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Mul<A, Wr<B>> * Inv<A> -> B!

@JvmName("multiplyingWithDefinedRightMultipliedByReciprocalLeft")
fun <
    LeftLeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
    LeftRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftRightUnit : ScientificUnit<LeftRightQuantity>,
    WrappedLeftRightUnit : WrappedUndefinedExtendedUnit<
        LeftRightQuantity,
        LeftRightUnit,
        >,
    LeftUnit : UndefinedMultipliedUnit<
        LeftLeftAndRightReciprocalQuantity,
        LeftLeftUnit,
        UndefinedQuantityType.Extended<
            LeftRightQuantity,
            >,
        WrappedLeftRightUnit,
        >,
    RightReciprocalUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
    RightUnit : UndefinedReciprocalUnit<
        LeftLeftAndRightReciprocalQuantity,
        RightReciprocalUnit,
        >,
    LeftRightValue : ScientificValue<LeftRightQuantity, LeftRightUnit>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightReciprocalQuantity,
        UndefinedQuantityType.Extended<
            LeftRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftLeftAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
    factory: (Decimal, LeftRightUnit) -> LeftRightValue,
) = unit.right.wrapped.byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultiplyingWithDefinedRightMultipliedByMetricAndImperialReciprocalLeft")
infix fun <
    LeftLeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftRightUnit,
    WrappedLeftRightUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightReciprocalQuantity,
        UndefinedQuantityType.Extended<
            LeftRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftLeftAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : AbstractScientificUnit<LeftRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftRightUnit : WrappedUndefinedExtendedUnit<
            LeftRightQuantity,
            LeftRightUnit,
            >,
        WrappedLeftRightUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightReciprocalQuantity,
            LeftLeftUnit,
            UndefinedQuantityType.Extended<
                LeftRightQuantity,
                >,
            WrappedLeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            LeftLeftAndRightReciprocalQuantity,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricMultiplyingWithDefinedRightMultipliedByMetricReciprocalLeft")
infix fun <
    LeftLeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftRightUnit,
    WrappedLeftRightUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightReciprocalQuantity,
        UndefinedQuantityType.Extended<
            LeftRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftLeftAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : AbstractScientificUnit<LeftRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftRightUnit : WrappedUndefinedExtendedUnit<
            LeftRightQuantity,
            LeftRightUnit,
            >,
        WrappedLeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightReciprocalQuantity,
            LeftLeftUnit,
            UndefinedQuantityType.Extended<
                LeftRightQuantity,
                >,
            WrappedLeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedReciprocalUnit<
            LeftLeftAndRightReciprocalQuantity,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialMultiplyingWithDefinedRightMultipliedByImperialReciprocalLeft")
infix fun <
    LeftLeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftRightUnit,
    WrappedLeftRightUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightReciprocalQuantity,
        UndefinedQuantityType.Extended<
            LeftRightQuantity,
            >,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftLeftAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : AbstractScientificUnit<LeftRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftRightUnit : WrappedUndefinedExtendedUnit<
            LeftRightQuantity,
            LeftRightUnit,
            >,
        WrappedLeftRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightReciprocalQuantity,
            LeftLeftUnit,
            UndefinedQuantityType.Extended<
                LeftRightQuantity,
                >,
            WrappedLeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            LeftLeftAndRightReciprocalQuantity,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialMultiplyingWithDefinedRightMultipliedByUKImperialReciprocalLeft")
infix fun <
    LeftLeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftRightUnit,
    WrappedLeftRightUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightReciprocalQuantity,
        UndefinedQuantityType.Extended<
            LeftRightQuantity,
            >,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftLeftAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : AbstractScientificUnit<LeftRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftRightUnit : WrappedUndefinedExtendedUnit<
            LeftRightQuantity,
            LeftRightUnit,
            >,
        WrappedLeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightReciprocalQuantity,
            LeftLeftUnit,
            UndefinedQuantityType.Extended<
                LeftRightQuantity,
                >,
            WrappedLeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            LeftLeftAndRightReciprocalQuantity,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryMultiplyingWithDefinedRightMultipliedByUSCustomaryReciprocalLeft")
infix fun <
    LeftLeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftRightUnit,
    WrappedLeftRightUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightReciprocalQuantity,
        UndefinedQuantityType.Extended<
            LeftRightQuantity,
            >,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftLeftAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : AbstractScientificUnit<LeftRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftRightUnit : WrappedUndefinedExtendedUnit<
            LeftRightQuantity,
            LeftRightUnit,
            >,
        WrappedLeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightReciprocalQuantity,
            LeftLeftUnit,
            UndefinedQuantityType.Extended<
                LeftRightQuantity,
                >,
            WrappedLeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            LeftLeftAndRightReciprocalQuantity,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialMultiplyingWithDefinedRightMultipliedByMetricAndUKImperialReciprocalLeft")
infix fun <
    LeftLeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftRightUnit,
    WrappedLeftRightUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightReciprocalQuantity,
        UndefinedQuantityType.Extended<
            LeftRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftLeftAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftRightUnit : AbstractScientificUnit<LeftRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftRightUnit : WrappedUndefinedExtendedUnit<
            LeftRightQuantity,
            LeftRightUnit,
            >,
        WrappedLeftRightUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightReciprocalQuantity,
            LeftLeftUnit,
            UndefinedQuantityType.Extended<
                LeftRightQuantity,
                >,
            WrappedLeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightReciprocalUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedReciprocalUnit<
            LeftLeftAndRightReciprocalQuantity,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryMultiplyingWithDefinedRightMultipliedByMetricAndUSCustomaryReciprocalLeft")
infix fun <
    LeftLeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftLeftUnit,
    LeftRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftRightUnit,
    WrappedLeftRightUnit,
    LeftUnit,
    RightReciprocalUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightReciprocalQuantity,
        UndefinedQuantityType.Extended<
            LeftRightQuantity,
            >,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftLeftAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) where
        LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
        LeftLeftUnit : MeasurementUsage.UsedInMetric,
        LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
        LeftRightUnit : AbstractScientificUnit<LeftRightQuantity>,
        LeftRightUnit : MeasurementUsage.UsedInMetric,
        LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftRightUnit : WrappedUndefinedExtendedUnit<
            LeftRightQuantity,
            LeftRightUnit,
            >,
        WrappedLeftRightUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedMultipliedUnit<
            LeftLeftAndRightReciprocalQuantity,
            LeftLeftUnit,
            UndefinedQuantityType.Extended<
                LeftRightQuantity,
                >,
            WrappedLeftRightUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightReciprocalUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
        RightReciprocalUnit : MeasurementUsage.UsedInMetric,
        RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedReciprocalUnit<
            LeftLeftAndRightReciprocalQuantity,
            RightReciprocalUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: LeftRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericMultiplyingWithDefinedRightMultipliedByGenericReciprocalLeft")
infix fun <
    LeftLeftAndRightReciprocalQuantity : UndefinedQuantityType,
    LeftLeftUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
    LeftRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftRightUnit : AbstractScientificUnit<LeftRightQuantity>,
    WrappedLeftRightUnit : WrappedUndefinedExtendedUnit<
        LeftRightQuantity,
        LeftRightUnit,
        >,
    LeftUnit : UndefinedMultipliedUnit<
        LeftLeftAndRightReciprocalQuantity,
        LeftLeftUnit,
        UndefinedQuantityType.Extended<
            LeftRightQuantity,
            >,
        WrappedLeftRightUnit,
        >,
    RightReciprocalUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
    RightUnit : UndefinedReciprocalUnit<
        LeftLeftAndRightReciprocalQuantity,
        RightReciprocalUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Multiplying<
        LeftLeftAndRightReciprocalQuantity,
        UndefinedQuantityType.Extended<
            LeftRightQuantity,
            >,
        >,
    LeftUnit,
    >.genericMultipliedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftLeftAndRightReciprocalQuantity,
            >,
        RightUnit,
        >,
) = multipliedBy(right) {
        value: Decimal,
        unit: LeftRightUnit,
    ->
    DefaultScientificValue(value, unit)
}
