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
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Inv<A> * Mul<A, Wr<B>> -> B!

@JvmName("reciprocalMultipliedByMultiplyingUnitWithSelfAsLeftAndDefinedRight")
fun <
    LeftReciprocalAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
    LeftUnit : UndefinedReciprocalUnit<
        LeftReciprocalAndRightLeftQuantity,
        LeftReciprocalUnit,
        >,
    RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
    RightRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightRightUnit : ScientificUnit<RightRightQuantity>,
    WrappedRightRightUnit : WrappedUndefinedExtendedUnit<
        RightRightQuantity,
        RightRightUnit,
        >,
    RightUnit : UndefinedMultipliedUnit<
        LeftReciprocalAndRightLeftQuantity,
        RightLeftUnit,
        UndefinedQuantityType.Extended<
            RightRightQuantity,
            >,
        WrappedRightRightUnit,
        >,
    RightRightValue : ScientificValue<RightRightQuantity, RightRightUnit>,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        LeftReciprocalAndRightLeftQuantity,
        >,
    LeftUnit,
    >.multipliedBy(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalAndRightLeftQuantity,
            UndefinedQuantityType.Extended<
                RightRightQuantity,
                >,
            >,
        RightUnit,
        >,
    factory: (Decimal, RightRightUnit) -> RightRightValue,
) = right.unit.right.wrapped.byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultipliedByMetricAndImperialMultiplyingUnitWithSelfAsLeftAndDefinedRight")
infix fun <
    LeftReciprocalAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftUnit,
    RightRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightRightUnit,
    WrappedRightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        LeftReciprocalAndRightLeftQuantity,
        >,
    LeftUnit,
    >.metricAndImperialMultipliedByMetricAndImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalAndRightLeftQuantity,
            UndefinedQuantityType.Extended<
                RightRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            LeftReciprocalAndRightLeftQuantity,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInMetric,
        RightLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightRightUnit : DefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInMetric,
        RightRightUnit : MeasurementUsage.UsedInUKImperial,
        RightRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightRightUnit : WrappedUndefinedExtendedUnit<
            RightRightQuantity,
            RightRightUnit,
            >,
        WrappedRightRightUnit : MeasurementUsage.UsedInMetric,
        WrappedRightRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<
            LeftReciprocalAndRightLeftQuantity,
            RightLeftUnit,
            UndefinedQuantityType.Extended<
                RightRightQuantity,
                >,
            WrappedRightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: RightRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricReciprocalMultipliedByMetricMultiplyingUnitWithSelfAsLeftAndDefinedRight")
infix fun <
    LeftReciprocalAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftUnit,
    RightRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightRightUnit,
    WrappedRightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        LeftReciprocalAndRightLeftQuantity,
        >,
    LeftUnit,
    >.metricMultipliedByMetric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalAndRightLeftQuantity,
            UndefinedQuantityType.Extended<
                RightRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedReciprocalUnit<
            LeftReciprocalAndRightLeftQuantity,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInMetric,
        RightRightUnit : DefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInMetric,
        WrappedRightRightUnit : WrappedUndefinedExtendedUnit<
            RightRightQuantity,
            RightRightUnit,
            >,
        WrappedRightRightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedMultipliedUnit<
            LeftReciprocalAndRightLeftQuantity,
            RightLeftUnit,
            UndefinedQuantityType.Extended<
                RightRightQuantity,
                >,
            WrappedRightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedBy(right) {
            value: Decimal,
            unit: RightRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialReciprocalMultipliedByImperialMultiplyingUnitWithSelfAsLeftAndDefinedRight")
infix fun <
    LeftReciprocalAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftUnit,
    RightRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightRightUnit,
    WrappedRightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        LeftReciprocalAndRightLeftQuantity,
        >,
    LeftUnit,
    >.imperialMultipliedByImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalAndRightLeftQuantity,
            UndefinedQuantityType.Extended<
                RightRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            LeftReciprocalAndRightLeftQuantity,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightRightUnit : DefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInUKImperial,
        RightRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightRightUnit : WrappedUndefinedExtendedUnit<
            RightRightQuantity,
            RightRightUnit,
            >,
        WrappedRightRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<
            LeftReciprocalAndRightLeftQuantity,
            RightLeftUnit,
            UndefinedQuantityType.Extended<
                RightRightQuantity,
                >,
            WrappedRightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: RightRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialReciprocalMultipliedByUKImperialMultiplyingUnitWithSelfAsLeftAndDefinedRight")
infix fun <
    LeftReciprocalAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftUnit,
    RightRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightRightUnit,
    WrappedRightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        LeftReciprocalAndRightLeftQuantity,
        >,
    LeftUnit,
    >.ukImperialMultipliedByUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalAndRightLeftQuantity,
            UndefinedQuantityType.Extended<
                RightRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<
            LeftReciprocalAndRightLeftQuantity,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightRightUnit : DefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightRightUnit : WrappedUndefinedExtendedUnit<
            RightRightQuantity,
            RightRightUnit,
            >,
        WrappedRightRightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedMultipliedUnit<
            LeftReciprocalAndRightLeftQuantity,
            RightLeftUnit,
            UndefinedQuantityType.Extended<
                RightRightQuantity,
                >,
            WrappedRightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(right) {
            value: Decimal,
            unit: RightRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryReciprocalMultipliedByUSCustomaryMultiplyingUnitWithSelfAsLeftAndDefinedRight")
infix fun <
    LeftReciprocalAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftUnit,
    RightRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightRightUnit,
    WrappedRightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        LeftReciprocalAndRightLeftQuantity,
        >,
    LeftUnit,
    >.usCustomaryMultipliedByUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalAndRightLeftQuantity,
            UndefinedQuantityType.Extended<
                RightRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            LeftReciprocalAndRightLeftQuantity,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightRightUnit : DefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightRightUnit : WrappedUndefinedExtendedUnit<
            RightRightQuantity,
            RightRightUnit,
            >,
        WrappedRightRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<
            LeftReciprocalAndRightLeftQuantity,
            RightLeftUnit,
            UndefinedQuantityType.Extended<
                RightRightQuantity,
                >,
            WrappedRightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: RightRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialReciprocalMultipliedByMetricAndUKImperialMultiplyingUnitWithSelfAsLeftAndDefinedRight")
infix fun <
    LeftReciprocalAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftUnit,
    RightRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightRightUnit,
    WrappedRightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        LeftReciprocalAndRightLeftQuantity,
        >,
    LeftUnit,
    >.metricAndUKImperialMultipliedByMetricAndUKImperial(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalAndRightLeftQuantity,
            UndefinedQuantityType.Extended<
                RightRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<
            LeftReciprocalAndRightLeftQuantity,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInMetric,
        RightLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightRightUnit : DefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInMetric,
        RightRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightRightUnit : WrappedUndefinedExtendedUnit<
            RightRightQuantity,
            RightRightUnit,
            >,
        WrappedRightRightUnit : MeasurementUsage.UsedInMetric,
        WrappedRightRightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedMultipliedUnit<
            LeftReciprocalAndRightLeftQuantity,
            RightLeftUnit,
            UndefinedQuantityType.Extended<
                RightRightQuantity,
                >,
            WrappedRightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedBy(right) {
            value: Decimal,
            unit: RightRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryReciprocalMultipliedByMetricAndUSCustomaryMultiplyingUnitWithSelfAsLeftAndDefinedRight")
infix fun <
    LeftReciprocalAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalUnit,
    LeftUnit,
    RightLeftUnit,
    RightRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightRightUnit,
    WrappedRightRightUnit,
    RightUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        LeftReciprocalAndRightLeftQuantity,
        >,
    LeftUnit,
    >.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalAndRightLeftQuantity,
            UndefinedQuantityType.Extended<
                RightRightQuantity,
                >,
            >,
        RightUnit,
        >,
) where
        LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            LeftReciprocalAndRightLeftQuantity,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInMetric,
        RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightRightUnit : DefinedScientificUnit<RightRightQuantity>,
        RightRightUnit : MeasurementUsage.UsedInMetric,
        RightRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightRightUnit : WrappedUndefinedExtendedUnit<
            RightRightQuantity,
            RightRightUnit,
            >,
        WrappedRightRightUnit : MeasurementUsage.UsedInMetric,
        WrappedRightRightUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<
            LeftReciprocalAndRightLeftQuantity,
            RightLeftUnit,
            UndefinedQuantityType.Extended<
                RightRightQuantity,
                >,
            WrappedRightRightUnit,
            >,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedBy(right) {
            value: Decimal,
            unit: RightRightUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericReciprocalMultipliedByGenericMultiplyingUnitWithSelfAsLeftAndDefinedRight")
infix fun <
    LeftReciprocalAndRightLeftQuantity : UndefinedQuantityType,
    LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
    LeftUnit : UndefinedReciprocalUnit<
        LeftReciprocalAndRightLeftQuantity,
        LeftReciprocalUnit,
        >,
    RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
    RightRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightRightUnit : DefinedScientificUnit<RightRightQuantity>,
    WrappedRightRightUnit : WrappedUndefinedExtendedUnit<
        RightRightQuantity,
        RightRightUnit,
        >,
    RightUnit : UndefinedMultipliedUnit<
        LeftReciprocalAndRightLeftQuantity,
        RightLeftUnit,
        UndefinedQuantityType.Extended<
            RightRightQuantity,
            >,
        WrappedRightRightUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        LeftReciprocalAndRightLeftQuantity,
        >,
    LeftUnit,
    >.genericMultipliedByGeneric(
    right: UndefinedScientificValue<
        UndefinedQuantityType.Multiplying<
            LeftReciprocalAndRightLeftQuantity,
            UndefinedQuantityType.Extended<
                RightRightQuantity,
                >,
            >,
        RightUnit,
        >,
) = multipliedBy(right) {
        value: Decimal,
        unit: RightRightUnit,
    ->
    DefaultScientificValue(value, unit)
}
