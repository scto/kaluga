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
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import kotlin.jvm.JvmName

// Inv<A> * Mul<B, A> -> B

@JvmName("reciprocalMultipliedByMultiplyingUnitWithSelfAsRight")
fun <
	LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightRightQuantity,
		LeftReciprocalUnit,
		>,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftReciprocalAndRightRightQuantity,
		RightRightUnit,
		>,
	RightLeftValue : UndefinedScientificValue<
	RightLeftQuantity,
RightLeftUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightRightQuantity,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftReciprocalAndRightRightQuantity,
		>,
RightUnit,
	>,
	factory: (Decimal, RightLeftUnit) -> RightLeftValue,
) = right.unit.left.byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultipliedByMetricAndImperialMultiplyingUnitWithSelfAsRight")
infix fun <
	LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightRightQuantity,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftReciprocalAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightRightQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftReciprocalAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: RightLeftUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricReciprocalMultipliedByMetricMultiplyingUnitWithSelfAsRight")
infix fun <
	LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightRightQuantity,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftReciprocalAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightRightQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftReciprocalAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(right) {
		value: Decimal,
		unit: RightLeftUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialReciprocalMultipliedByImperialMultiplyingUnitWithSelfAsRight")
infix fun <
	LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightRightQuantity,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftReciprocalAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightRightQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftReciprocalAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: RightLeftUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalMultipliedByUKImperialMultiplyingUnitWithSelfAsRight")
infix fun <
	LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightRightQuantity,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftReciprocalAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightRightQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftReciprocalAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(right) {
		value: Decimal,
		unit: RightLeftUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalMultipliedByUSCustomaryMultiplyingUnitWithSelfAsRight")
infix fun <
	LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightRightQuantity,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftReciprocalAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightRightQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftReciprocalAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: RightLeftUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalMultipliedByMetricAndUKImperialMultiplyingUnitWithSelfAsRight")
infix fun <
	LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightRightQuantity,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftReciprocalAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightRightQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftReciprocalAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(right) {
		value: Decimal,
		unit: RightLeftUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalMultipliedByMetricAndUSCustomaryMultiplyingUnitWithSelfAsRight")
infix fun <
	LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightRightQuantity,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftReciprocalAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightRightQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftReciprocalAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: RightLeftUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("genericReciprocalMultipliedByGenericMultiplyingUnitWithSelfAsRight")
infix fun <
	LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightRightQuantity,
		LeftReciprocalUnit,
		>,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftReciprocalAndRightRightQuantity,
		RightRightUnit,
		>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightRightQuantity,
		>,
LeftUnit,
	>.genericMultipliedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftReciprocalAndRightRightQuantity,
		>,
RightUnit,
	>,
) =
	multipliedBy(right) {
		value: Decimal,
		unit: RightLeftUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
