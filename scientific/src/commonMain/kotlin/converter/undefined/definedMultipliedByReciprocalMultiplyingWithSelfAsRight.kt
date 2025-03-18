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

// A! * Inv<Mul<B, Wr<A>>> -> Inv<B>

@JvmName("definedMultipliedByReciprocalMultiplyingWithSelfAsRight")
fun <
	LeftAndRightReciprocalRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit : ScientificUnit<LeftAndRightReciprocalRightQuantity>,
	RightReciprocalLeftQuantity : UndefinedQuantityType,
	RightReciprocalLeftUnit : UndefinedScientificUnit<RightReciprocalLeftQuantity>,
	RightReciprocalRightUnit : ScientificUnit<LeftAndRightReciprocalRightQuantity>,
	WrappedRightReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	LeftAndRightReciprocalRightQuantity,
	RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		RightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalRightQuantity,
			>,
		WrappedRightReciprocalRightUnit,
		>,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalRightQuantity,
				>,
			>,
		RightReciprocalUnit,
		>,
	TargetUnit : UndefinedReciprocalUnit<
		RightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		RightReciprocalLeftQuantity,
		>,
TargetUnit,
	>,
	> ScientificValue<LeftAndRightReciprocalRightQuantity, LeftUnit>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalRightQuantity,
				>,
			>,
		>,
RightUnit,
	>,
	reciprocalTargetUnit: RightReciprocalLeftUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.inverse.left.reciprocalTargetUnit().byMultiplying(this, right, factory)

@JvmName("metricAndImperialDefinedMultipliedByMetricAndImperialReciprocalMultiplyingWithSelfAsRight")
infix fun <
	LeftAndRightReciprocalRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightReciprocalLeftQuantity : UndefinedQuantityType,
	RightReciprocalLeftUnit,
	RightReciprocalRightUnit,
	WrappedRightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> ScientificValue<LeftAndRightReciprocalRightQuantity, LeftUnit>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalRightQuantity,
				>,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : AbstractScientificUnit<LeftAndRightReciprocalRightQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalLeftUnit : UndefinedScientificUnit<RightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : AbstractScientificUnit<LeftAndRightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedRightReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	LeftAndRightReciprocalRightQuantity,
	RightReciprocalRightUnit,
		>,
	WrappedRightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	WrappedRightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedRightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		RightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalRightQuantity,
			>,
		WrappedRightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalRightQuantity,
				>,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndImperial<
							RightReciprocalLeftQuantity,
							RightReciprocalLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDefinedMultipliedByMetricReciprocalMultiplyingWithSelfAsRight")
infix fun <
	LeftAndRightReciprocalRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightReciprocalLeftQuantity : UndefinedQuantityType,
	RightReciprocalLeftUnit,
	RightReciprocalRightUnit,
	WrappedRightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> ScientificValue<LeftAndRightReciprocalRightQuantity, LeftUnit>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalRightQuantity,
				>,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : AbstractScientificUnit<LeftAndRightReciprocalRightQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalLeftUnit : UndefinedScientificUnit<RightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : AbstractScientificUnit<LeftAndRightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	WrappedRightReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	LeftAndRightReciprocalRightQuantity,
	RightReciprocalRightUnit,
		>,
	WrappedRightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		RightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalRightQuantity,
			>,
		WrappedRightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalRightQuantity,
				>,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Metric<
							RightReciprocalLeftQuantity,
							RightReciprocalLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDefinedMultipliedByImperialReciprocalMultiplyingWithSelfAsRight")
infix fun <
	LeftAndRightReciprocalRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightReciprocalLeftQuantity : UndefinedQuantityType,
	RightReciprocalLeftUnit,
	RightReciprocalRightUnit,
	WrappedRightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> ScientificValue<LeftAndRightReciprocalRightQuantity, LeftUnit>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalRightQuantity,
				>,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : AbstractScientificUnit<LeftAndRightReciprocalRightQuantity>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalLeftUnit : UndefinedScientificUnit<RightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : AbstractScientificUnit<LeftAndRightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedRightReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	LeftAndRightReciprocalRightQuantity,
	RightReciprocalRightUnit,
		>,
	WrappedRightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedRightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		RightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalRightQuantity,
			>,
		WrappedRightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalRightQuantity,
				>,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Imperial<
							RightReciprocalLeftQuantity,
							RightReciprocalLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDefinedMultipliedByUKImperialReciprocalMultiplyingWithSelfAsRight")
infix fun <
	LeftAndRightReciprocalRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightReciprocalLeftQuantity : UndefinedQuantityType,
	RightReciprocalLeftUnit,
	RightReciprocalRightUnit,
	WrappedRightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> ScientificValue<LeftAndRightReciprocalRightQuantity, LeftUnit>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalRightQuantity,
				>,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : AbstractScientificUnit<LeftAndRightReciprocalRightQuantity>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalLeftUnit : UndefinedScientificUnit<RightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : AbstractScientificUnit<LeftAndRightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedRightReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	LeftAndRightReciprocalRightQuantity,
	RightReciprocalRightUnit,
		>,
	WrappedRightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		RightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalRightQuantity,
			>,
		WrappedRightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalRightQuantity,
				>,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.UKImperial<
							RightReciprocalLeftQuantity,
							RightReciprocalLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDefinedMultipliedByUSCustomaryReciprocalMultiplyingWithSelfAsRight")
infix fun <
	LeftAndRightReciprocalRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightReciprocalLeftQuantity : UndefinedQuantityType,
	RightReciprocalLeftUnit,
	RightReciprocalRightUnit,
	WrappedRightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> ScientificValue<LeftAndRightReciprocalRightQuantity, LeftUnit>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalRightQuantity,
				>,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : AbstractScientificUnit<LeftAndRightReciprocalRightQuantity>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalLeftUnit : UndefinedScientificUnit<RightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : AbstractScientificUnit<LeftAndRightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedRightReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	LeftAndRightReciprocalRightQuantity,
	RightReciprocalRightUnit,
		>,
	WrappedRightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		RightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalRightQuantity,
			>,
		WrappedRightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalRightQuantity,
				>,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.USCustomary<
							RightReciprocalLeftQuantity,
							RightReciprocalLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDefinedMultipliedByMetricAndUKImperialReciprocalMultiplyingWithSelfAsRight")
infix fun <
	LeftAndRightReciprocalRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightReciprocalLeftQuantity : UndefinedQuantityType,
	RightReciprocalLeftUnit,
	RightReciprocalRightUnit,
	WrappedRightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> ScientificValue<LeftAndRightReciprocalRightQuantity, LeftUnit>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalRightQuantity,
				>,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : AbstractScientificUnit<LeftAndRightReciprocalRightQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalLeftUnit : UndefinedScientificUnit<RightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : AbstractScientificUnit<LeftAndRightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedRightReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	LeftAndRightReciprocalRightQuantity,
	RightReciprocalRightUnit,
		>,
	WrappedRightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	WrappedRightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		RightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalRightQuantity,
			>,
		WrappedRightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalRightQuantity,
				>,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUKImperial<
							RightReciprocalLeftQuantity,
							RightReciprocalLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDefinedMultipliedByMetricAndUSCustomaryReciprocalMultiplyingWithSelfAsRight")
infix fun <
	LeftAndRightReciprocalRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightReciprocalLeftQuantity : UndefinedQuantityType,
	RightReciprocalLeftUnit,
	RightReciprocalRightUnit,
	WrappedRightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> ScientificValue<LeftAndRightReciprocalRightQuantity, LeftUnit>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalRightQuantity,
				>,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : AbstractScientificUnit<LeftAndRightReciprocalRightQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalLeftUnit : UndefinedScientificUnit<RightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : AbstractScientificUnit<LeftAndRightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedRightReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	LeftAndRightReciprocalRightQuantity,
	RightReciprocalRightUnit,
		>,
	WrappedRightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	WrappedRightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		RightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalRightQuantity,
			>,
		WrappedRightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalRightQuantity,
				>,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
							RightReciprocalLeftQuantity,
							RightReciprocalLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
