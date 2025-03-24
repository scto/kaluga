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
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.DefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// Inv<Mul<Ex<A>, B>> * A! -> Inv<B>

@JvmName("reciprocalMultiplyingWithExtendedLeftMultipliedByLeft")
fun <
	ExtendedLeftReciprocalLeftUnit : UndefinedExtendedUnit<
		LeftReciprocalLeftAndRightQuantity,
		>,
	LeftReciprocalRightQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightQuantity>,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalLeftAndRightQuantity,
			>,
		ExtendedLeftReciprocalLeftUnit,
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
	LeftReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit : ScientificUnit<LeftReciprocalLeftAndRightQuantity>,
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
	>.multipliedBy(
	right: ScientificValue<LeftReciprocalLeftAndRightQuantity, RightUnit>,
	reciprocalTargetUnit: LeftReciprocalRightUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.inverse.right.reciprocalTargetUnit().byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultiplyingWithExtendedLeftMultipliedByMetricAndImperialLeft")
infix fun <
	ExtendedLeftReciprocalLeftUnit,
	LeftReciprocalRightQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	LeftReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
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
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: ScientificValue<LeftReciprocalLeftAndRightQuantity, RightUnit>,
) where
	ExtendedLeftReciprocalLeftUnit : UndefinedExtendedUnit<
		LeftReciprocalLeftAndRightQuantity,
		>,
	ExtendedLeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedLeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedLeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedLeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalLeftAndRightQuantity,
			>,
		ExtendedLeftReciprocalLeftUnit,
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
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : DefinedScientificUnit<LeftReciprocalLeftAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
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

@JvmName("metricReciprocalMultiplyingWithExtendedLeftMultipliedByMetricLeft")
infix fun <
	ExtendedLeftReciprocalLeftUnit,
	LeftReciprocalRightQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	LeftReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
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
	>.metricMultipliedByMetric(
	right: ScientificValue<LeftReciprocalLeftAndRightQuantity, RightUnit>,
) where
	ExtendedLeftReciprocalLeftUnit : UndefinedExtendedUnit<
		LeftReciprocalLeftAndRightQuantity,
		>,
	ExtendedLeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedLeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalLeftAndRightQuantity,
			>,
		ExtendedLeftReciprocalLeftUnit,
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
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightUnit : DefinedScientificUnit<LeftReciprocalLeftAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
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

@JvmName("imperialReciprocalMultiplyingWithExtendedLeftMultipliedByImperialLeft")
infix fun <
	ExtendedLeftReciprocalLeftUnit,
	LeftReciprocalRightQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	LeftReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
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
	>.imperialMultipliedByImperial(
	right: ScientificValue<LeftReciprocalLeftAndRightQuantity, RightUnit>,
) where
	ExtendedLeftReciprocalLeftUnit : UndefinedExtendedUnit<
		LeftReciprocalLeftAndRightQuantity,
		>,
	ExtendedLeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedLeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedLeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalLeftAndRightQuantity,
			>,
		ExtendedLeftReciprocalLeftUnit,
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
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : DefinedScientificUnit<LeftReciprocalLeftAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
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

@JvmName("ukImperialReciprocalMultiplyingWithExtendedLeftMultipliedByUKImperialLeft")
infix fun <
	ExtendedLeftReciprocalLeftUnit,
	LeftReciprocalRightQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	LeftReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
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
	>.ukImperialMultipliedByUKImperial(
	right: ScientificValue<LeftReciprocalLeftAndRightQuantity, RightUnit>,
) where
	ExtendedLeftReciprocalLeftUnit : UndefinedExtendedUnit<
		LeftReciprocalLeftAndRightQuantity,
		>,
	ExtendedLeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedLeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalLeftAndRightQuantity,
			>,
		ExtendedLeftReciprocalLeftUnit,
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
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : DefinedScientificUnit<LeftReciprocalLeftAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
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

@JvmName("usCustomaryReciprocalMultiplyingWithExtendedLeftMultipliedByUSCustomaryLeft")
infix fun <
	ExtendedLeftReciprocalLeftUnit,
	LeftReciprocalRightQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	LeftReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
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
	>.usCustomaryMultipliedByUSCustomary(
	right: ScientificValue<LeftReciprocalLeftAndRightQuantity, RightUnit>,
) where
	ExtendedLeftReciprocalLeftUnit : UndefinedExtendedUnit<
		LeftReciprocalLeftAndRightQuantity,
		>,
	ExtendedLeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedLeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalLeftAndRightQuantity,
			>,
		ExtendedLeftReciprocalLeftUnit,
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
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : DefinedScientificUnit<LeftReciprocalLeftAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
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

@JvmName("metricAndUKImperialReciprocalMultiplyingWithExtendedLeftMultipliedByMetricAndUKImperialLeft")
infix fun <
	ExtendedLeftReciprocalLeftUnit,
	LeftReciprocalRightQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	LeftReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
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
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: ScientificValue<LeftReciprocalLeftAndRightQuantity, RightUnit>,
) where
	ExtendedLeftReciprocalLeftUnit : UndefinedExtendedUnit<
		LeftReciprocalLeftAndRightQuantity,
		>,
	ExtendedLeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedLeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedLeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalLeftAndRightQuantity,
			>,
		ExtendedLeftReciprocalLeftUnit,
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
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : DefinedScientificUnit<LeftReciprocalLeftAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
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

@JvmName("metricAndUSCustomaryReciprocalMultiplyingWithExtendedLeftMultipliedByMetricAndUSCustomaryLeft")
infix fun <
	ExtendedLeftReciprocalLeftUnit,
	LeftReciprocalRightQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	LeftReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
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
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: ScientificValue<LeftReciprocalLeftAndRightQuantity, RightUnit>,
) where
	ExtendedLeftReciprocalLeftUnit : UndefinedExtendedUnit<
		LeftReciprocalLeftAndRightQuantity,
		>,
	ExtendedLeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedLeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedLeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalLeftAndRightQuantity,
			>,
		ExtendedLeftReciprocalLeftUnit,
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
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : DefinedScientificUnit<LeftReciprocalLeftAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
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
