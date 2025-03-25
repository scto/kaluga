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
import com.splendo.kaluga.scientific.unit.UndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// A! * Inv<Mul<Ex<A>, B>> -> Inv<B>

@JvmName("definedMultipliedByReciprocalMultiplyingWithSelfAsLeft")
fun <
	LeftAndRightReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit : ScientificUnit<LeftAndRightReciprocalLeftQuantity>,
	ExtendedRightReciprocalLeftUnit : UndefinedExtendedUnit<
		LeftAndRightReciprocalLeftQuantity,
		>,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalLeftQuantity,
			>,
		ExtendedRightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalLeftQuantity,
				>,
			RightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	TargetUnit : UndefinedReciprocalUnit<
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		RightReciprocalRightQuantity,
		>,
TargetUnit,
	>,
	> ScientificValue<LeftAndRightReciprocalLeftQuantity, LeftUnit>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalLeftQuantity,
				>,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
	reciprocalTargetUnit: RightReciprocalRightUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.inverse.right.reciprocalTargetUnit().byMultiplying(this, right, factory)

@JvmName("metricAndImperialDefinedMultipliedByMetricAndImperialReciprocalMultiplyingWithSelfAsLeft")
infix fun <
	LeftAndRightReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	ExtendedRightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> ScientificValue<LeftAndRightReciprocalLeftQuantity, LeftUnit>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalLeftQuantity,
				>,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightReciprocalLeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedRightReciprocalLeftUnit : UndefinedExtendedUnit<
		LeftAndRightReciprocalLeftQuantity,
		>,
	ExtendedRightReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalLeftQuantity,
			>,
		>,
	ExtendedRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalLeftQuantity,
			>,
		ExtendedRightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalLeftQuantity,
				>,
			RightReciprocalRightQuantity,
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
							RightReciprocalRightQuantity,
							RightReciprocalRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDefinedMultipliedByMetricReciprocalMultiplyingWithSelfAsLeft")
infix fun <
	LeftAndRightReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	ExtendedRightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> ScientificValue<LeftAndRightReciprocalLeftQuantity, LeftUnit>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalLeftQuantity,
				>,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightReciprocalLeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedRightReciprocalLeftUnit : UndefinedExtendedUnit<
		LeftAndRightReciprocalLeftQuantity,
		>,
	ExtendedRightReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalLeftQuantity,
			>,
		>,
	ExtendedRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalLeftQuantity,
			>,
		ExtendedRightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalLeftQuantity,
				>,
			RightReciprocalRightQuantity,
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
							RightReciprocalRightQuantity,
							RightReciprocalRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDefinedMultipliedByImperialReciprocalMultiplyingWithSelfAsLeft")
infix fun <
	LeftAndRightReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	ExtendedRightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> ScientificValue<LeftAndRightReciprocalLeftQuantity, LeftUnit>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalLeftQuantity,
				>,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightReciprocalLeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedRightReciprocalLeftUnit : UndefinedExtendedUnit<
		LeftAndRightReciprocalLeftQuantity,
		>,
	ExtendedRightReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalLeftQuantity,
			>,
		>,
	ExtendedRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalLeftQuantity,
			>,
		ExtendedRightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalLeftQuantity,
				>,
			RightReciprocalRightQuantity,
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
							RightReciprocalRightQuantity,
							RightReciprocalRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDefinedMultipliedByUKImperialReciprocalMultiplyingWithSelfAsLeft")
infix fun <
	LeftAndRightReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	ExtendedRightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> ScientificValue<LeftAndRightReciprocalLeftQuantity, LeftUnit>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalLeftQuantity,
				>,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightReciprocalLeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedRightReciprocalLeftUnit : UndefinedExtendedUnit<
		LeftAndRightReciprocalLeftQuantity,
		>,
	ExtendedRightReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalLeftQuantity,
			>,
		>,
	ExtendedRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalLeftQuantity,
			>,
		ExtendedRightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalLeftQuantity,
				>,
			RightReciprocalRightQuantity,
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
							RightReciprocalRightQuantity,
							RightReciprocalRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDefinedMultipliedByUSCustomaryReciprocalMultiplyingWithSelfAsLeft")
infix fun <
	LeftAndRightReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	ExtendedRightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> ScientificValue<LeftAndRightReciprocalLeftQuantity, LeftUnit>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalLeftQuantity,
				>,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightReciprocalLeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedRightReciprocalLeftUnit : UndefinedExtendedUnit<
		LeftAndRightReciprocalLeftQuantity,
		>,
	ExtendedRightReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalLeftQuantity,
			>,
		>,
	ExtendedRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalLeftQuantity,
			>,
		ExtendedRightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalLeftQuantity,
				>,
			RightReciprocalRightQuantity,
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
							RightReciprocalRightQuantity,
							RightReciprocalRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDefinedMultipliedByMetricAndUKImperialReciprocalMultiplyingWithSelfAsLeft")
infix fun <
	LeftAndRightReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	ExtendedRightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> ScientificValue<LeftAndRightReciprocalLeftQuantity, LeftUnit>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalLeftQuantity,
				>,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightReciprocalLeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedRightReciprocalLeftUnit : UndefinedExtendedUnit<
		LeftAndRightReciprocalLeftQuantity,
		>,
	ExtendedRightReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalLeftQuantity,
			>,
		>,
	ExtendedRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalLeftQuantity,
			>,
		ExtendedRightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalLeftQuantity,
				>,
			RightReciprocalRightQuantity,
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
							RightReciprocalRightQuantity,
							RightReciprocalRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDefinedMultipliedByMetricAndUSCustomaryReciprocalMultiplyingWithSelfAsLeft")
infix fun <
	LeftAndRightReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	ExtendedRightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> ScientificValue<LeftAndRightReciprocalLeftQuantity, LeftUnit>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalLeftQuantity,
				>,
			RightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : DefinedScientificUnit<LeftAndRightReciprocalLeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedRightReciprocalLeftUnit : UndefinedExtendedUnit<
		LeftAndRightReciprocalLeftQuantity,
		>,
	ExtendedRightReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalLeftQuantity,
			>,
		>,
	ExtendedRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftAndRightReciprocalLeftQuantity,
			>,
		ExtendedRightReciprocalLeftUnit,
		RightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				LeftAndRightReciprocalLeftQuantity,
				>,
			RightReciprocalRightQuantity,
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
							RightReciprocalRightQuantity,
							RightReciprocalRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
