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
import kotlin.jvm.JvmName

// Mul<A, B> * Inv<A> -> B

@JvmName("multiplyingMultipliedByReciprocalLeft")
fun <
	LeftLeftAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightReciprocalQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
	RightUnit : UndefinedReciprocalUnit<
		LeftLeftAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	LeftRightValue : UndefinedScientificValue<
	LeftRightQuantity,
LeftRightUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightReciprocalQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftLeftAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
	factory: (Decimal, LeftRightUnit) -> LeftRightValue,
) = unit.right.byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultiplyingMultipliedByMetricAndImperialReciprocalLeft")
infix fun <
	LeftLeftAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightReciprocalQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftLeftAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightReciprocalQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		LeftLeftAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricMultiplyingMultipliedByMetricReciprocalLeft")
infix fun <
	LeftLeftAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightReciprocalQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftLeftAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightReciprocalQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedReciprocalUnit<
		LeftLeftAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialMultiplyingMultipliedByImperialReciprocalLeft")
infix fun <
	LeftLeftAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightReciprocalQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftLeftAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightReciprocalQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		LeftLeftAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialMultiplyingMultipliedByUKImperialReciprocalLeft")
infix fun <
	LeftLeftAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightReciprocalQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftLeftAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightReciprocalQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<
		LeftLeftAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryMultiplyingMultipliedByUSCustomaryReciprocalLeft")
infix fun <
	LeftLeftAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightReciprocalQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftLeftAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightReciprocalQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		LeftLeftAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultiplyingMultipliedByMetricAndUKImperialReciprocalLeft")
infix fun <
	LeftLeftAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightReciprocalQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftLeftAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightReciprocalQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<
		LeftLeftAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultiplyingMultipliedByMetricAndUSCustomaryReciprocalLeft")
infix fun <
	LeftLeftAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightReciprocalQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftLeftAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightReciprocalQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		LeftLeftAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericMultiplyingMultipliedByGenericReciprocalLeft")
infix fun <
	LeftLeftAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightQuantity>,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftAndRightReciprocalQuantity,
		LeftLeftUnit,
		LeftRightQuantity,
		LeftRightUnit,
		>,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftLeftAndRightReciprocalQuantity>,
	RightUnit : UndefinedReciprocalUnit<
		LeftLeftAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftAndRightReciprocalQuantity,
		LeftRightQuantity,
		>,
LeftUnit,
	>.genericMultipliedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftLeftAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftRightUnit,
		->
		DefaultScientificValue(value, unit)
	}
