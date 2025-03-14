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

// Inv<Mul<A, Wr<B>>> * B! -> Inv<A>

@JvmName("reciprocalMultiplyingWithDefinedRightMultipliedByDefinedUnit")
fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalRightAndRightUnit : ScientificUnit<LeftReciprocalRightAndRightQuantity>,
	WrappedLeftReciprocalRightAndRightUnit : WrappedUndefinedExtendedUnit<LeftReciprocalRightAndRightQuantity, LeftReciprocalRightAndRightUnit>,
	LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>, WrappedLeftReciprocalRightAndRightUnit>,
	LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>>, LeftReciprocalUnit>,
	TargetUnit : UndefinedReciprocalUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalLeftQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>>>, LeftUnit>.times(
	right: ScientificValue<LeftReciprocalRightAndRightQuantity, LeftReciprocalRightAndRightUnit>,
	reciprocalTargetUnit: LeftReciprocalLeftUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.inverse.left.reciprocalTargetUnit().byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultiplyingWithDefinedRightMultipliedByMetricAndImperialDefinedUnit")
infix operator fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalRightAndRightUnit,
	WrappedLeftReciprocalRightAndRightUnit,
	LeftReciprocalUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>>>, LeftUnit>.times(
	right: ScientificValue<LeftReciprocalRightAndRightQuantity, LeftReciprocalRightAndRightUnit>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightAndRightUnit : AbstractScientificUnit<LeftReciprocalRightAndRightQuantity>,
	LeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftReciprocalRightAndRightUnit : WrappedUndefinedExtendedUnit<LeftReciprocalRightAndRightQuantity, LeftReciprocalRightAndRightUnit>,
	WrappedLeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>, WrappedLeftReciprocalRightAndRightUnit>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>>, LeftReciprocalUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary =
	times(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndImperial<
			LeftReciprocalLeftQuantity,
							LeftReciprocalLeftUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricReciprocalMultiplyingWithDefinedRightMultipliedByMetricDefinedUnit")
infix operator fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalRightAndRightUnit,
	WrappedLeftReciprocalRightAndRightUnit,
	LeftReciprocalUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>>>, LeftUnit>.times(
	right: ScientificValue<LeftReciprocalRightAndRightQuantity, LeftReciprocalRightAndRightUnit>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightAndRightUnit : AbstractScientificUnit<LeftReciprocalRightAndRightQuantity>,
	LeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftReciprocalRightAndRightUnit : WrappedUndefinedExtendedUnit<LeftReciprocalRightAndRightQuantity, LeftReciprocalRightAndRightUnit>,
	WrappedLeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>, WrappedLeftReciprocalRightAndRightUnit>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>>, LeftReciprocalUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric =
	times(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Metric<
			LeftReciprocalLeftQuantity,
							LeftReciprocalLeftUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialReciprocalMultiplyingWithDefinedRightMultipliedByImperialDefinedUnit")
infix operator fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalRightAndRightUnit,
	WrappedLeftReciprocalRightAndRightUnit,
	LeftReciprocalUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>>>, LeftUnit>.times(
	right: ScientificValue<LeftReciprocalRightAndRightQuantity, LeftReciprocalRightAndRightUnit>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightAndRightUnit : AbstractScientificUnit<LeftReciprocalRightAndRightQuantity>,
	LeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftReciprocalRightAndRightUnit : WrappedUndefinedExtendedUnit<LeftReciprocalRightAndRightQuantity, LeftReciprocalRightAndRightUnit>,
	WrappedLeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>, WrappedLeftReciprocalRightAndRightUnit>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>>, LeftReciprocalUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary =
	times(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Imperial<
			LeftReciprocalLeftQuantity,
							LeftReciprocalLeftUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalMultiplyingWithDefinedRightMultipliedByUKImperialDefinedUnit")
infix operator fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalRightAndRightUnit,
	WrappedLeftReciprocalRightAndRightUnit,
	LeftReciprocalUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>>>, LeftUnit>.times(
	right: ScientificValue<LeftReciprocalRightAndRightQuantity, LeftReciprocalRightAndRightUnit>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightAndRightUnit : AbstractScientificUnit<LeftReciprocalRightAndRightQuantity>,
	LeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftReciprocalRightAndRightUnit : WrappedUndefinedExtendedUnit<LeftReciprocalRightAndRightQuantity, LeftReciprocalRightAndRightUnit>,
	WrappedLeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>, WrappedLeftReciprocalRightAndRightUnit>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>>, LeftReciprocalUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial =
	times(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.UKImperial<
			LeftReciprocalLeftQuantity,
							LeftReciprocalLeftUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalMultiplyingWithDefinedRightMultipliedByUSCustomaryDefinedUnit")
infix operator fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalRightAndRightUnit,
	WrappedLeftReciprocalRightAndRightUnit,
	LeftReciprocalUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>>>, LeftUnit>.times(
	right: ScientificValue<LeftReciprocalRightAndRightQuantity, LeftReciprocalRightAndRightUnit>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightAndRightUnit : AbstractScientificUnit<LeftReciprocalRightAndRightQuantity>,
	LeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftReciprocalRightAndRightUnit : WrappedUndefinedExtendedUnit<LeftReciprocalRightAndRightQuantity, LeftReciprocalRightAndRightUnit>,
	WrappedLeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>, WrappedLeftReciprocalRightAndRightUnit>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>>, LeftReciprocalUnit>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary =
	times(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.USCustomary<
			LeftReciprocalLeftQuantity,
							LeftReciprocalLeftUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalMultiplyingWithDefinedRightMultipliedByMetricAndUKImperialDefinedUnit")
infix operator fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalRightAndRightUnit,
	WrappedLeftReciprocalRightAndRightUnit,
	LeftReciprocalUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>>>, LeftUnit>.times(
	right: ScientificValue<LeftReciprocalRightAndRightQuantity, LeftReciprocalRightAndRightUnit>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightAndRightUnit : AbstractScientificUnit<LeftReciprocalRightAndRightQuantity>,
	LeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftReciprocalRightAndRightUnit : WrappedUndefinedExtendedUnit<LeftReciprocalRightAndRightQuantity, LeftReciprocalRightAndRightUnit>,
	WrappedLeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>, WrappedLeftReciprocalRightAndRightUnit>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>>, LeftReciprocalUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial =
	times(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUKImperial<
			LeftReciprocalLeftQuantity,
							LeftReciprocalLeftUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalMultiplyingWithDefinedRightMultipliedByMetricAndUSCustomaryDefinedUnit")
infix operator fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalRightAndRightUnit,
	WrappedLeftReciprocalRightAndRightUnit,
	LeftReciprocalUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>>>, LeftUnit>.times(
	right: ScientificValue<LeftReciprocalRightAndRightQuantity, LeftReciprocalRightAndRightUnit>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightAndRightUnit : AbstractScientificUnit<LeftReciprocalRightAndRightQuantity>,
	LeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftReciprocalRightAndRightUnit : WrappedUndefinedExtendedUnit<LeftReciprocalRightAndRightQuantity, LeftReciprocalRightAndRightUnit>,
	WrappedLeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftReciprocalRightAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftQuantity, LeftReciprocalLeftUnit, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>, WrappedLeftReciprocalRightAndRightUnit>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftQuantity, UndefinedQuantityType.Extended<LeftReciprocalRightAndRightQuantity>>, LeftReciprocalUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary =
	times(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
			LeftReciprocalLeftQuantity,
							LeftReciprocalLeftUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

