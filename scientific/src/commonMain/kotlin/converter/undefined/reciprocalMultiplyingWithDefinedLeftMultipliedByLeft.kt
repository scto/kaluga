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
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// Inv<Mul<Wr<A>, B>> * A! -> Inv<B>

@JvmName("reciprocalMultiplyingWithDefinedLeftMultipliedByLeft")
fun <
    LeftReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftReciprocalLeftAndRightUnit : ScientificUnit<LeftReciprocalLeftAndRightQuantity>,
    WrappedLeftReciprocalLeftAndRightUnit : WrappedUndefinedExtendedUnit<
        LeftReciprocalLeftAndRightQuantity,
        LeftReciprocalLeftAndRightUnit,
        >,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
    LeftReciprocalUnit : UndefinedMultipliedUnit<
        UndefinedQuantityType.Extended<
            LeftReciprocalLeftAndRightQuantity,
            >,
        WrappedLeftReciprocalLeftAndRightUnit,
        LeftReciprocalRightQuantity,
        LeftReciprocalRightUnit,
        >,
    LeftUnit : UndefinedReciprocalUnit<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftReciprocalLeftAndRightQuantity,
                >,
            LeftReciprocalRightQuantity,
            >,
        LeftReciprocalUnit,
        >,
    TargetUnit : UndefinedReciprocalUnit<
        LeftReciprocalRightQuantity,
        LeftReciprocalRightUnit,
        >,
    TargetValue : UndefinedScientificValue<
        UndefinedQuantityType.Reciprocal<
            LeftReciprocalRightQuantity,
            >,
        TargetUnit,
        >,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftReciprocalLeftAndRightQuantity,
                >,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByLeft(
    right: ScientificValue<LeftReciprocalLeftAndRightQuantity, LeftReciprocalLeftAndRightUnit>,
    reciprocalTargetUnit: LeftReciprocalRightUnit.() -> TargetUnit,
    factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.inverse.right.reciprocalTargetUnit().byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultiplyingWithDefinedLeftMultipliedByMetricAndImperialLeft")
infix fun <
    LeftReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftReciprocalLeftAndRightUnit,
    WrappedLeftReciprocalLeftAndRightUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftReciprocalLeftAndRightQuantity,
                >,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByLeft(
    right: ScientificValue<LeftReciprocalLeftAndRightQuantity, LeftReciprocalLeftAndRightUnit>,
) where
        LeftReciprocalLeftAndRightUnit : AbstractScientificUnit<LeftReciprocalLeftAndRightQuantity>,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftReciprocalLeftAndRightUnit : WrappedUndefinedExtendedUnit<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalLeftAndRightUnit,
            >,
        WrappedLeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftReciprocalLeftAndRightQuantity,
                >,
            WrappedLeftReciprocalLeftAndRightUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftReciprocalLeftAndRightQuantity,
                    >,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByLeft(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndImperial<
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricReciprocalMultiplyingWithDefinedLeftMultipliedByMetricLeft")
infix fun <
    LeftReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftReciprocalLeftAndRightUnit,
    WrappedLeftReciprocalLeftAndRightUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftReciprocalLeftAndRightQuantity,
                >,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByLeft(
    right: ScientificValue<LeftReciprocalLeftAndRightQuantity, LeftReciprocalLeftAndRightUnit>,
) where
        LeftReciprocalLeftAndRightUnit : AbstractScientificUnit<LeftReciprocalLeftAndRightQuantity>,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftReciprocalLeftAndRightUnit : WrappedUndefinedExtendedUnit<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalLeftAndRightUnit,
            >,
        WrappedLeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftReciprocalLeftAndRightQuantity,
                >,
            WrappedLeftReciprocalLeftAndRightUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftReciprocalLeftAndRightQuantity,
                    >,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric =
    multipliedByLeft(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Metric<
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("imperialReciprocalMultiplyingWithDefinedLeftMultipliedByImperialLeft")
infix fun <
    LeftReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftReciprocalLeftAndRightUnit,
    WrappedLeftReciprocalLeftAndRightUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftReciprocalLeftAndRightQuantity,
                >,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByLeft(
    right: ScientificValue<LeftReciprocalLeftAndRightQuantity, LeftReciprocalLeftAndRightUnit>,
) where
        LeftReciprocalLeftAndRightUnit : AbstractScientificUnit<LeftReciprocalLeftAndRightQuantity>,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftReciprocalLeftAndRightUnit : WrappedUndefinedExtendedUnit<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalLeftAndRightUnit,
            >,
        WrappedLeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftReciprocalLeftAndRightQuantity,
                >,
            WrappedLeftReciprocalLeftAndRightUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftReciprocalLeftAndRightQuantity,
                    >,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByLeft(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.Imperial<
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("ukImperialReciprocalMultiplyingWithDefinedLeftMultipliedByUKImperialLeft")
infix fun <
    LeftReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftReciprocalLeftAndRightUnit,
    WrappedLeftReciprocalLeftAndRightUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftReciprocalLeftAndRightQuantity,
                >,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByLeft(
    right: ScientificValue<LeftReciprocalLeftAndRightQuantity, LeftReciprocalLeftAndRightUnit>,
) where
        LeftReciprocalLeftAndRightUnit : AbstractScientificUnit<LeftReciprocalLeftAndRightQuantity>,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftReciprocalLeftAndRightUnit : WrappedUndefinedExtendedUnit<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalLeftAndRightUnit,
            >,
        WrappedLeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftReciprocalLeftAndRightQuantity,
                >,
            WrappedLeftReciprocalLeftAndRightUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftReciprocalLeftAndRightQuantity,
                    >,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByLeft(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.UKImperial<
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("usCustomaryReciprocalMultiplyingWithDefinedLeftMultipliedByUSCustomaryLeft")
infix fun <
    LeftReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftReciprocalLeftAndRightUnit,
    WrappedLeftReciprocalLeftAndRightUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftReciprocalLeftAndRightQuantity,
                >,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByLeft(
    right: ScientificValue<LeftReciprocalLeftAndRightQuantity, LeftReciprocalLeftAndRightUnit>,
) where
        LeftReciprocalLeftAndRightUnit : AbstractScientificUnit<LeftReciprocalLeftAndRightQuantity>,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftReciprocalLeftAndRightUnit : WrappedUndefinedExtendedUnit<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalLeftAndRightUnit,
            >,
        WrappedLeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftReciprocalLeftAndRightQuantity,
                >,
            WrappedLeftReciprocalLeftAndRightUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftReciprocalLeftAndRightQuantity,
                    >,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByLeft(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.USCustomary<
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUKImperialReciprocalMultiplyingWithDefinedLeftMultipliedByMetricAndUKImperialLeft")
infix fun <
    LeftReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftReciprocalLeftAndRightUnit,
    WrappedLeftReciprocalLeftAndRightUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftReciprocalLeftAndRightQuantity,
                >,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByLeft(
    right: ScientificValue<LeftReciprocalLeftAndRightQuantity, LeftReciprocalLeftAndRightUnit>,
) where
        LeftReciprocalLeftAndRightUnit : AbstractScientificUnit<LeftReciprocalLeftAndRightQuantity>,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        WrappedLeftReciprocalLeftAndRightUnit : WrappedUndefinedExtendedUnit<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalLeftAndRightUnit,
            >,
        WrappedLeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftReciprocalLeftAndRightQuantity,
                >,
            WrappedLeftReciprocalLeftAndRightUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftReciprocalLeftAndRightQuantity,
                    >,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUKImperial =
    multipliedByLeft(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUKImperial<
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }

@JvmName("metricAndUSCustomaryReciprocalMultiplyingWithDefinedLeftMultipliedByMetricAndUSCustomaryLeft")
infix fun <
    LeftReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    LeftReciprocalLeftAndRightUnit,
    WrappedLeftReciprocalLeftAndRightUnit,
    LeftReciprocalRightQuantity : UndefinedQuantityType,
    LeftReciprocalRightUnit,
    LeftReciprocalUnit,
    LeftUnit,
    > UndefinedScientificValue<
    UndefinedQuantityType.Reciprocal<
        UndefinedQuantityType.Multiplying<
            UndefinedQuantityType.Extended<
                LeftReciprocalLeftAndRightQuantity,
                >,
            LeftReciprocalRightQuantity,
            >,
        >,
    LeftUnit,
    >.multipliedByLeft(
    right: ScientificValue<LeftReciprocalLeftAndRightQuantity, LeftReciprocalLeftAndRightUnit>,
) where
        LeftReciprocalLeftAndRightUnit : AbstractScientificUnit<LeftReciprocalLeftAndRightQuantity>,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        WrappedLeftReciprocalLeftAndRightUnit : WrappedUndefinedExtendedUnit<
            LeftReciprocalLeftAndRightQuantity,
            LeftReciprocalLeftAndRightUnit,
            >,
        WrappedLeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
        WrappedLeftReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
        LeftReciprocalUnit : UndefinedMultipliedUnit<
            UndefinedQuantityType.Extended<
                LeftReciprocalLeftAndRightQuantity,
                >,
            WrappedLeftReciprocalLeftAndRightUnit,
            LeftReciprocalRightQuantity,
            LeftReciprocalRightUnit,
            >,
        LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
        LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
        LeftUnit : UndefinedReciprocalUnit<
            UndefinedQuantityType.Multiplying<
                UndefinedQuantityType.Extended<
                    LeftReciprocalLeftAndRightQuantity,
                    >,
                LeftReciprocalRightQuantity,
                >,
            LeftReciprocalUnit,
            >,
        LeftUnit : MeasurementUsage.UsedInMetric,
        LeftUnit : MeasurementUsage.UsedInUSCustomary =
    multipliedByLeft(
        right,
        reciprocalTargetUnit = { reciprocal() },
    ) {
            value: Decimal,
            unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
                LeftReciprocalRightQuantity,
                LeftReciprocalRightUnit,
                >,
        ->
        DefaultUndefinedScientificValue(value, unit)
    }
