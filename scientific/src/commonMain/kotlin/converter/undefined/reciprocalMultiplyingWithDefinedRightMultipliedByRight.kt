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
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.DefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// Inv<Mul<A, Wr<B>>> * B! -> Inv<A>

@JvmName("reciprocalMultiplyingWithDefinedRightMultipliedByRight")
fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalRightUnit : ScientificUnit<LeftReciprocalRightAndRightQuantity>,
	WrappedLeftReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	LeftReciprocalRightAndRightQuantity,
	LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			LeftReciprocalRightAndRightQuantity,
			>,
		WrappedLeftReciprocalRightUnit,
		>,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftReciprocalRightAndRightQuantity,
				>,
			>,
		LeftReciprocalUnit,
		>,
	RightUnit : ScientificUnit<LeftReciprocalRightAndRightQuantity>,
	TargetUnit : UndefinedReciprocalUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalLeftQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftReciprocalRightAndRightQuantity,
				>,
			>,
		>,
LeftUnit,
	>.multipliedBy(
	right: ScientificValue<LeftReciprocalRightAndRightQuantity, RightUnit>,
	reciprocalTargetUnit: LeftReciprocalLeftUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.inverse.left.reciprocalTargetUnit().byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultiplyingWithDefinedRightMultipliedByMetricAndImperialRight")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalRightUnit,
	WrappedLeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftReciprocalRightAndRightQuantity,
				>,
			>,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: ScientificValue<LeftReciprocalRightAndRightQuantity, RightUnit>,
) where
	LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightUnit : DefinedScientificUnit<LeftReciprocalRightAndRightQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	LeftReciprocalRightAndRightQuantity,
	LeftReciprocalRightUnit,
		>,
	WrappedLeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			LeftReciprocalRightAndRightQuantity,
			>,
		WrappedLeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftReciprocalRightAndRightQuantity,
				>,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : DefinedScientificUnit<LeftReciprocalRightAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndImperial<
							LeftReciprocalLeftQuantity,
							LeftReciprocalLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricReciprocalMultiplyingWithDefinedRightMultipliedByMetricRight")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalRightUnit,
	WrappedLeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftReciprocalRightAndRightQuantity,
				>,
			>,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: ScientificValue<LeftReciprocalRightAndRightQuantity, RightUnit>,
) where
	LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightUnit : DefinedScientificUnit<LeftReciprocalRightAndRightQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	LeftReciprocalRightAndRightQuantity,
	LeftReciprocalRightUnit,
		>,
	WrappedLeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			LeftReciprocalRightAndRightQuantity,
			>,
		WrappedLeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftReciprocalRightAndRightQuantity,
				>,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightUnit : DefinedScientificUnit<LeftReciprocalRightAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Metric<
							LeftReciprocalLeftQuantity,
							LeftReciprocalLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialReciprocalMultiplyingWithDefinedRightMultipliedByImperialRight")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalRightUnit,
	WrappedLeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftReciprocalRightAndRightQuantity,
				>,
			>,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: ScientificValue<LeftReciprocalRightAndRightQuantity, RightUnit>,
) where
	LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightUnit : DefinedScientificUnit<LeftReciprocalRightAndRightQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	LeftReciprocalRightAndRightQuantity,
	LeftReciprocalRightUnit,
		>,
	WrappedLeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			LeftReciprocalRightAndRightQuantity,
			>,
		WrappedLeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftReciprocalRightAndRightQuantity,
				>,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : DefinedScientificUnit<LeftReciprocalRightAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Imperial<
							LeftReciprocalLeftQuantity,
							LeftReciprocalLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalMultiplyingWithDefinedRightMultipliedByUKImperialRight")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalRightUnit,
	WrappedLeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftReciprocalRightAndRightQuantity,
				>,
			>,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: ScientificValue<LeftReciprocalRightAndRightQuantity, RightUnit>,
) where
	LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightUnit : DefinedScientificUnit<LeftReciprocalRightAndRightQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	LeftReciprocalRightAndRightQuantity,
	LeftReciprocalRightUnit,
		>,
	WrappedLeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			LeftReciprocalRightAndRightQuantity,
			>,
		WrappedLeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftReciprocalRightAndRightQuantity,
				>,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : DefinedScientificUnit<LeftReciprocalRightAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.UKImperial<
							LeftReciprocalLeftQuantity,
							LeftReciprocalLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalMultiplyingWithDefinedRightMultipliedByUSCustomaryRight")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalRightUnit,
	WrappedLeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftReciprocalRightAndRightQuantity,
				>,
			>,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: ScientificValue<LeftReciprocalRightAndRightQuantity, RightUnit>,
) where
	LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightUnit : DefinedScientificUnit<LeftReciprocalRightAndRightQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	LeftReciprocalRightAndRightQuantity,
	LeftReciprocalRightUnit,
		>,
	WrappedLeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			LeftReciprocalRightAndRightQuantity,
			>,
		WrappedLeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftReciprocalRightAndRightQuantity,
				>,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : DefinedScientificUnit<LeftReciprocalRightAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.USCustomary<
							LeftReciprocalLeftQuantity,
							LeftReciprocalLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalMultiplyingWithDefinedRightMultipliedByMetricAndUKImperialRight")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalRightUnit,
	WrappedLeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftReciprocalRightAndRightQuantity,
				>,
			>,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: ScientificValue<LeftReciprocalRightAndRightQuantity, RightUnit>,
) where
	LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightUnit : DefinedScientificUnit<LeftReciprocalRightAndRightQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	LeftReciprocalRightAndRightQuantity,
	LeftReciprocalRightUnit,
		>,
	WrappedLeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			LeftReciprocalRightAndRightQuantity,
			>,
		WrappedLeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftReciprocalRightAndRightQuantity,
				>,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : DefinedScientificUnit<LeftReciprocalRightAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUKImperial<
							LeftReciprocalLeftQuantity,
							LeftReciprocalLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalMultiplyingWithDefinedRightMultipliedByMetricAndUSCustomaryRight")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalRightUnit,
	WrappedLeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftReciprocalRightAndRightQuantity,
				>,
			>,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: ScientificValue<LeftReciprocalRightAndRightQuantity, RightUnit>,
) where
	LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightUnit : DefinedScientificUnit<LeftReciprocalRightAndRightQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	LeftReciprocalRightAndRightQuantity,
	LeftReciprocalRightUnit,
		>,
	WrappedLeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			LeftReciprocalRightAndRightQuantity,
			>,
		WrappedLeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftReciprocalRightAndRightQuantity,
				>,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : DefinedScientificUnit<LeftReciprocalRightAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
							LeftReciprocalLeftQuantity,
							LeftReciprocalLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
