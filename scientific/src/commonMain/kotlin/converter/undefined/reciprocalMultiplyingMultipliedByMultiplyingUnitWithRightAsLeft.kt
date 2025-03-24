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

// Inv<Mul<A, B>> * Mul<B, C> -> Div<C, A>

@JvmName("reciprocalMultiplyingMultipliedByMultiplyingUnitWithRightAsLeft")
fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalRightAndRightLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		RightRightQuantity,
		RightRightUnit,
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightRightQuantity,
		LeftReciprocalLeftQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightLeftQuantity,
			>,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftReciprocalRightAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
	rightRightUnitPerLeftReciprocalLeftUnit: RightRightUnit.(LeftReciprocalLeftUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.right.rightRightUnitPerLeftReciprocalLeftUnit(
	unit.inverse.left,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultiplyingMultipliedByMetricAndImperialMultiplyingUnitWithRightAsLeft")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightLeftQuantity,
			>,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftReciprocalRightAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightRightUnitPerLeftReciprocalLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				RightRightQuantity,
				RightRightUnit,
				LeftReciprocalLeftQuantity,
				LeftReciprocalLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricReciprocalMultiplyingMultipliedByMetricMultiplyingUnitWithRightAsLeft")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightLeftQuantity,
			>,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftReciprocalRightAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		rightRightUnitPerLeftReciprocalLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				RightRightQuantity,
				RightRightUnit,
				LeftReciprocalLeftQuantity,
				LeftReciprocalLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialReciprocalMultiplyingMultipliedByImperialMultiplyingUnitWithRightAsLeft")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightLeftQuantity,
			>,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftReciprocalRightAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightRightUnitPerLeftReciprocalLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				RightRightQuantity,
				RightRightUnit,
				LeftReciprocalLeftQuantity,
				LeftReciprocalLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalMultiplyingMultipliedByUKImperialMultiplyingUnitWithRightAsLeft")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightLeftQuantity,
			>,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftReciprocalRightAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		rightRightUnitPerLeftReciprocalLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				RightRightQuantity,
				RightRightUnit,
				LeftReciprocalLeftQuantity,
				LeftReciprocalLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalMultiplyingMultipliedByUSCustomaryMultiplyingUnitWithRightAsLeft")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightLeftQuantity,
			>,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftReciprocalRightAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightRightUnitPerLeftReciprocalLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				RightRightQuantity,
				RightRightUnit,
				LeftReciprocalLeftQuantity,
				LeftReciprocalLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalMultiplyingMultipliedByMetricAndUKImperialMultiplyingUnitWithRightAsLeft")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightLeftQuantity,
			>,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftReciprocalRightAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		rightRightUnitPerLeftReciprocalLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				RightRightQuantity,
				RightRightUnit,
				LeftReciprocalLeftQuantity,
				LeftReciprocalLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalMultiplyingMultipliedByMetricAndUSCustomaryMultiplyingUnitWithRightAsLeft")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightLeftQuantity,
			>,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftReciprocalRightAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalRightAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightRightUnitPerLeftReciprocalLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				RightRightQuantity,
				RightRightUnit,
				LeftReciprocalLeftQuantity,
				LeftReciprocalLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
