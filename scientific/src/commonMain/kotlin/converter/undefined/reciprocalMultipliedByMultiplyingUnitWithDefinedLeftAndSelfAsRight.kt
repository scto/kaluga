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

// Inv<A> * Mul<Wr<B>, A> -> B!

@JvmName("reciprocalMultipliedByMultiplyingUnitWithDefinedLeftAndSelfAsRight")
fun <
    LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
    LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
    RightLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightLeftUnit : ScientificUnit<RightLeftQuantity>,
    WrappedRightLeftUnit : WrappedUndefinedExtendedUnit<RightLeftQuantity, RightLeftUnit>,
    RightUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<RightLeftQuantity>, WrappedRightLeftUnit, LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
    RightLeftValue : ScientificValue<RightLeftQuantity, RightLeftUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightRightQuantity>, LeftUnit>.multipliedByMultiplyingUnitWithDefinedLeftAndSelfAsRight(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightLeftQuantity>, LeftReciprocalAndRightRightQuantity>, RightUnit>,
    factory: (Decimal, RightLeftUnit) -> RightLeftValue,
) = right.unit.left.wrapped.byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultipliedByMetricAndImperialMultiplyingUnitWithDefinedLeftAndSelfAsRight")
infix fun <
    LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalAndRightRightUnit,
    LeftUnit,
    RightLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightLeftUnit,
    WrappedRightLeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightRightQuantity>, LeftUnit>.multipliedByMultiplyingUnitWithDefinedLeftAndSelfAsRight(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightLeftQuantity>, LeftReciprocalAndRightRightQuantity>, RightUnit>,
) where
        LeftReciprocalAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
        LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightLeftUnit : AbstractScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInMetric,
        RightLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightLeftUnit : WrappedUndefinedExtendedUnit<RightLeftQuantity, RightLeftUnit>,
        WrappedRightLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedRightLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<RightLeftQuantity>, WrappedRightLeftUnit, LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByMultiplyingUnitWithDefinedLeftAndSelfAsRight(right) {
            value: Decimal,
            unit: RightLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricReciprocalMultipliedByMetricMultiplyingUnitWithDefinedLeftAndSelfAsRight")
infix fun <
    LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalAndRightRightUnit,
    LeftUnit,
    RightLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightLeftUnit,
    WrappedRightLeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightRightQuantity>, LeftUnit>.multipliedByMultiplyingUnitWithDefinedLeftAndSelfAsRight(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightLeftQuantity>, LeftReciprocalAndRightRightQuantity>, RightUnit>,
) where
        LeftReciprocalAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
        LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        RightLeftUnit : AbstractScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedRightLeftUnit : WrappedUndefinedExtendedUnit<RightLeftQuantity, RightLeftUnit>,
        WrappedRightLeftUnit : MeasurementUsage.UsedInMetric,
        RightUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<RightLeftQuantity>, WrappedRightLeftUnit, LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
        RightUnit : MeasurementUsage.UsedInMetric =
    multipliedByMultiplyingUnitWithDefinedLeftAndSelfAsRight(right) {
            value: Decimal,
            unit: RightLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("imperialReciprocalMultipliedByImperialMultiplyingUnitWithDefinedLeftAndSelfAsRight")
infix fun <
    LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalAndRightRightUnit,
    LeftUnit,
    RightLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightLeftUnit,
    WrappedRightLeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightRightQuantity>, LeftUnit>.multipliedByMultiplyingUnitWithDefinedLeftAndSelfAsRight(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightLeftQuantity>, LeftReciprocalAndRightRightQuantity>, RightUnit>,
) where
        LeftReciprocalAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
        LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightLeftUnit : AbstractScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightLeftUnit : WrappedUndefinedExtendedUnit<RightLeftQuantity, RightLeftUnit>,
        WrappedRightLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<RightLeftQuantity>, WrappedRightLeftUnit, LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByMultiplyingUnitWithDefinedLeftAndSelfAsRight(right) {
            value: Decimal,
            unit: RightLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("ukImperialReciprocalMultipliedByUKImperialMultiplyingUnitWithDefinedLeftAndSelfAsRight")
infix fun <
    LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalAndRightRightUnit,
    LeftUnit,
    RightLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightLeftUnit,
    WrappedRightLeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightRightQuantity>, LeftUnit>.multipliedByMultiplyingUnitWithDefinedLeftAndSelfAsRight(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightLeftQuantity>, LeftReciprocalAndRightRightQuantity>, RightUnit>,
) where
        LeftReciprocalAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
        LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightLeftUnit : AbstractScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightLeftUnit : WrappedUndefinedExtendedUnit<RightLeftQuantity, RightLeftUnit>,
        WrappedRightLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<RightLeftQuantity>, WrappedRightLeftUnit, LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByMultiplyingUnitWithDefinedLeftAndSelfAsRight(right) {
            value: Decimal,
            unit: RightLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("usCustomaryReciprocalMultipliedByUSCustomaryMultiplyingUnitWithDefinedLeftAndSelfAsRight")
infix fun <
    LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalAndRightRightUnit,
    LeftUnit,
    RightLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightLeftUnit,
    WrappedRightLeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightRightQuantity>, LeftUnit>.multipliedByMultiplyingUnitWithDefinedLeftAndSelfAsRight(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightLeftQuantity>, LeftReciprocalAndRightRightQuantity>, RightUnit>,
) where
        LeftReciprocalAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
        LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightLeftUnit : AbstractScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightLeftUnit : WrappedUndefinedExtendedUnit<RightLeftQuantity, RightLeftUnit>,
        WrappedRightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<RightLeftQuantity>, WrappedRightLeftUnit, LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByMultiplyingUnitWithDefinedLeftAndSelfAsRight(right) {
            value: Decimal,
            unit: RightLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialReciprocalMultipliedByMetricAndUKImperialMultiplyingUnitWithDefinedLeftAndSelfAsRight")
infix fun <
    LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalAndRightRightUnit,
    LeftUnit,
    RightLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightLeftUnit,
    WrappedRightLeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightRightQuantity>, LeftUnit>.multipliedByMultiplyingUnitWithDefinedLeftAndSelfAsRight(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightLeftQuantity>, LeftReciprocalAndRightRightQuantity>, RightUnit>,
) where
        LeftReciprocalAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
        LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        RightLeftUnit : AbstractScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInMetric,
        RightLeftUnit : MeasurementUsage.UsedInUKImperial,
        WrappedRightLeftUnit : WrappedUndefinedExtendedUnit<RightLeftQuantity, RightLeftUnit>,
        WrappedRightLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedRightLeftUnit : MeasurementUsage.UsedInUKImperial,
        RightUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<RightLeftQuantity>, WrappedRightLeftUnit, LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByMultiplyingUnitWithDefinedLeftAndSelfAsRight(right) {
            value: Decimal,
            unit: RightLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryReciprocalMultipliedByMetricAndUSCustomaryMultiplyingUnitWithDefinedLeftAndSelfAsRight")
infix fun <
    LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalAndRightRightUnit,
    LeftUnit,
    RightLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightLeftUnit,
    WrappedRightLeftUnit,
    RightUnit,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightRightQuantity>, LeftUnit>.multipliedByMultiplyingUnitWithDefinedLeftAndSelfAsRight(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightLeftQuantity>, LeftReciprocalAndRightRightQuantity>, RightUnit>,
) where
        LeftReciprocalAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
        LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightLeftUnit : AbstractScientificUnit<RightLeftQuantity>,
        RightLeftUnit : MeasurementUsage.UsedInMetric,
        RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedRightLeftUnit : WrappedUndefinedExtendedUnit<RightLeftQuantity, RightLeftUnit>,
        WrappedRightLeftUnit : MeasurementUsage.UsedInMetric,
        WrappedRightLeftUnit : MeasurementUsage.UsedInUSCustomary,
        RightUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<RightLeftQuantity>, WrappedRightLeftUnit, LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
        RightUnit : MeasurementUsage.UsedInMetric,
        RightUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByMultiplyingUnitWithDefinedLeftAndSelfAsRight(right) {
            value: Decimal,
            unit: RightLeftUnit,
        ->
        DefaultScientificValue(value, unit)
    }

@JvmName("genericReciprocalMultipliedByGenericMultiplyingUnitWithDefinedLeftAndSelfAsRight")
infix fun <
    LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
    LeftReciprocalAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
    LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
    RightLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    RightLeftUnit : AbstractScientificUnit<RightLeftQuantity>,
    WrappedRightLeftUnit : WrappedUndefinedExtendedUnit<RightLeftQuantity, RightLeftUnit>,
    RightUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<RightLeftQuantity>, WrappedRightLeftUnit, LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
    > UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightRightQuantity>, LeftUnit>.multipliedByMultiplyingUnitWithDefinedLeftAndSelfAsRight(
    right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<RightLeftQuantity>, LeftReciprocalAndRightRightQuantity>, RightUnit>,
) = multipliedByMultiplyingUnitWithDefinedLeftAndSelfAsRight(right) {
        value: Decimal,
        unit: RightLeftUnit,
    ->
    DefaultScientificValue(value, unit)
}
