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
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Inv<A> * Inv<B> -> Inv<Mul<A, B>>

@JvmName("reciprocalMultipliedByReciprocalUndefinedUnit")
fun <
	LeftReciprocalQuantity : UndefinedQuantityType,
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalQuantity>,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalQuantity,
		LeftReciprocalUnit,
		>,
	RightReciprocalQuantity : UndefinedQuantityType,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<RightReciprocalQuantity>,
	RightUnit : UndefinedReciprocalUnit<
		RightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	TargetReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalQuantity,
		LeftReciprocalUnit,
		RightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	TargetUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalQuantity,
			RightReciprocalQuantity,
			>,
		TargetReciprocalUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalQuantity,
			RightReciprocalQuantity,
			>,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalQuantity,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		RightReciprocalQuantity,
		>,
RightUnit,
	>,
	leftReciprocalUnitXRightReciprocalUnit: LeftReciprocalUnit.(RightReciprocalUnit) -> TargetReciprocalUnit,
	reciprocalTargetUnit: TargetReciprocalUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.inverse.leftReciprocalUnitXRightReciprocalUnit(
	right.unit.inverse,
).reciprocalTargetUnit().byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultipliedByMetricAndImperialReciprocalUndefinedUnit")
infix fun <
	LeftReciprocalQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightReciprocalQuantity : UndefinedQuantityType,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalQuantity,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		RightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<RightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		RightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftReciprocalUnitXRightReciprocalUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndImperial<
							UndefinedQuantityType.Multiplying<
					LeftReciprocalQuantity,
					RightReciprocalQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndImperial<
				LeftReciprocalQuantity,
					LeftReciprocalUnit,
					RightReciprocalQuantity,
					RightReciprocalUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricReciprocalMultipliedByMetricReciprocalUndefinedUnit")
infix fun <
	LeftReciprocalQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightReciprocalQuantity : UndefinedQuantityType,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalQuantity,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		RightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<RightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedReciprocalUnit<
		RightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		leftReciprocalUnitXRightReciprocalUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Metric<
							UndefinedQuantityType.Multiplying<
					LeftReciprocalQuantity,
					RightReciprocalQuantity,
					>,
							UndefinedMultipliedUnit.Metric<
				LeftReciprocalQuantity,
					LeftReciprocalUnit,
					RightReciprocalQuantity,
					RightReciprocalUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialReciprocalMultipliedByImperialReciprocalUndefinedUnit")
infix fun <
	LeftReciprocalQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightReciprocalQuantity : UndefinedQuantityType,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalQuantity,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		RightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<RightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		RightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftReciprocalUnitXRightReciprocalUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Imperial<
							UndefinedQuantityType.Multiplying<
					LeftReciprocalQuantity,
					RightReciprocalQuantity,
					>,
							UndefinedMultipliedUnit.Imperial<
				LeftReciprocalQuantity,
					LeftReciprocalUnit,
					RightReciprocalQuantity,
					RightReciprocalUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalMultipliedByUKImperialReciprocalUndefinedUnit")
infix fun <
	LeftReciprocalQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightReciprocalQuantity : UndefinedQuantityType,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalQuantity,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		RightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<RightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<
		RightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftReciprocalUnitXRightReciprocalUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.UKImperial<
							UndefinedQuantityType.Multiplying<
					LeftReciprocalQuantity,
					RightReciprocalQuantity,
					>,
							UndefinedMultipliedUnit.UKImperial<
				LeftReciprocalQuantity,
					LeftReciprocalUnit,
					RightReciprocalQuantity,
					RightReciprocalUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalMultipliedByUSCustomaryReciprocalUndefinedUnit")
infix fun <
	LeftReciprocalQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightReciprocalQuantity : UndefinedQuantityType,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalQuantity,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		RightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<RightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		RightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftReciprocalUnitXRightReciprocalUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.USCustomary<
							UndefinedQuantityType.Multiplying<
					LeftReciprocalQuantity,
					RightReciprocalQuantity,
					>,
							UndefinedMultipliedUnit.USCustomary<
				LeftReciprocalQuantity,
					LeftReciprocalUnit,
					RightReciprocalQuantity,
					RightReciprocalUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalMultipliedByMetricAndUKImperialReciprocalUndefinedUnit")
infix fun <
	LeftReciprocalQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightReciprocalQuantity : UndefinedQuantityType,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalQuantity,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		RightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<RightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<
		RightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftReciprocalUnitXRightReciprocalUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUKImperial<
							UndefinedQuantityType.Multiplying<
					LeftReciprocalQuantity,
					RightReciprocalQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndUKImperial<
				LeftReciprocalQuantity,
					LeftReciprocalUnit,
					RightReciprocalQuantity,
					RightReciprocalUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalMultipliedByMetricAndUSCustomaryReciprocalUndefinedUnit")
infix fun <
	LeftReciprocalQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightReciprocalQuantity : UndefinedQuantityType,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalQuantity,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		RightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<RightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		RightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftReciprocalUnitXRightReciprocalUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
							UndefinedQuantityType.Multiplying<
					LeftReciprocalQuantity,
					RightReciprocalQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndUSCustomary<
				LeftReciprocalQuantity,
					LeftReciprocalUnit,
					RightReciprocalQuantity,
					RightReciprocalUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}
