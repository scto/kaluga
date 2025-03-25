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
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// Mul<A, B> * Inv<Mul<C, A>> -> Div<B, C>

@JvmName("multiplyingMultipliedByReciprocalMultiplyingWithLeftAsRight")
fun <
	LeftLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightReciprocalRightQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	RightReciprocalLeftQuantity : UndefinedQuantityType,
	RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		RightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		LeftLeftAndRightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			LeftLeftAndRightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		LeftRightQuantity,
		LeftRightUnit,
		RightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftRightQuantity,
		RightReciprocalLeftQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightReciprocalRightQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			LeftLeftAndRightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
	leftRightUnitPerRightReciprocalLeftUnit: LeftRightUnit.(RightReciprocalLeftUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.right.leftRightUnitPerRightReciprocalLeftUnit(
	right.unit.inverse.left,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultiplyingMultipliedByMetricAndImperialReciprocalMultiplyingWithLeftAsRight")
infix fun <
	LeftLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalLeftQuantity : UndefinedQuantityType,
	RightReciprocalLeftUnit,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightReciprocalRightQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			LeftLeftAndRightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightReciprocalRightQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		RightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		LeftLeftAndRightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			LeftLeftAndRightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftRightUnitPerRightReciprocalLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				LeftRightQuantity,
				LeftRightUnit,
				RightReciprocalLeftQuantity,
				RightReciprocalLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricMultiplyingMultipliedByMetricReciprocalMultiplyingWithLeftAsRight")
infix fun <
	LeftLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalLeftQuantity : UndefinedQuantityType,
	RightReciprocalLeftUnit,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightReciprocalRightQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			LeftLeftAndRightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightReciprocalRightQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		RightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		LeftLeftAndRightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			LeftLeftAndRightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		leftRightUnitPerRightReciprocalLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				LeftRightQuantity,
				LeftRightUnit,
				RightReciprocalLeftQuantity,
				RightReciprocalLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialMultiplyingMultipliedByImperialReciprocalMultiplyingWithLeftAsRight")
infix fun <
	LeftLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalLeftQuantity : UndefinedQuantityType,
	RightReciprocalLeftUnit,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightReciprocalRightQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			LeftLeftAndRightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightReciprocalRightQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		RightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		LeftLeftAndRightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			LeftLeftAndRightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftRightUnitPerRightReciprocalLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				LeftRightQuantity,
				LeftRightUnit,
				RightReciprocalLeftQuantity,
				RightReciprocalLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialMultiplyingMultipliedByUKImperialReciprocalMultiplyingWithLeftAsRight")
infix fun <
	LeftLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalLeftQuantity : UndefinedQuantityType,
	RightReciprocalLeftUnit,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightReciprocalRightQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			LeftLeftAndRightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightReciprocalRightQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		RightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		LeftLeftAndRightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			LeftLeftAndRightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftRightUnitPerRightReciprocalLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				LeftRightQuantity,
				LeftRightUnit,
				RightReciprocalLeftQuantity,
				RightReciprocalLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryMultiplyingMultipliedByUSCustomaryReciprocalMultiplyingWithLeftAsRight")
infix fun <
	LeftLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalLeftQuantity : UndefinedQuantityType,
	RightReciprocalLeftUnit,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightReciprocalRightQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			LeftLeftAndRightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightReciprocalRightQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		RightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		LeftLeftAndRightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			LeftLeftAndRightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftRightUnitPerRightReciprocalLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				LeftRightQuantity,
				LeftRightUnit,
				RightReciprocalLeftQuantity,
				RightReciprocalLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultiplyingMultipliedByMetricAndUKImperialReciprocalMultiplyingWithLeftAsRight")
infix fun <
	LeftLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalLeftQuantity : UndefinedQuantityType,
	RightReciprocalLeftUnit,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightReciprocalRightQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			LeftLeftAndRightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightReciprocalRightQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		RightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		LeftLeftAndRightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			LeftLeftAndRightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftRightUnitPerRightReciprocalLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				LeftRightQuantity,
				LeftRightUnit,
				RightReciprocalLeftQuantity,
				RightReciprocalLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultiplyingMultipliedByMetricAndUSCustomaryReciprocalMultiplyingWithLeftAsRight")
infix fun <
	LeftLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalLeftQuantity : UndefinedQuantityType,
	RightReciprocalLeftUnit,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightReciprocalRightQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			LeftLeftAndRightReciprocalRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightReciprocalRightQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalLeftUnit : AbstractUndefinedScientificUnit<RightReciprocalLeftQuantity>,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<
		RightReciprocalLeftQuantity,
		RightReciprocalLeftUnit,
		LeftLeftAndRightReciprocalRightQuantity,
		RightReciprocalRightUnit,
		>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			RightReciprocalLeftQuantity,
			LeftLeftAndRightReciprocalRightQuantity,
			>,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftRightUnitPerRightReciprocalLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				LeftRightQuantity,
				LeftRightUnit,
				RightReciprocalLeftQuantity,
				RightReciprocalLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
