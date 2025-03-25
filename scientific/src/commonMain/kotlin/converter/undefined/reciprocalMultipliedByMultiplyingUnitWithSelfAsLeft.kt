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

// Inv<A> * Mul<A, B> -> B

@JvmName("reciprocalMultipliedByMultiplyingUnitWithSelfAsLeft")
fun <
	LeftReciprocalAndRightLeftQuantity : UndefinedQuantityType,
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightLeftQuantity,
		LeftReciprocalUnit,
		>,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightUnit : UndefinedMultipliedUnit<
		LeftReciprocalAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightRightValue : UndefinedScientificValue<
	RightRightQuantity,
RightRightUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightLeftQuantity,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftReciprocalAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
	factory: (Decimal, RightRightUnit) -> RightRightValue,
) = right.unit.right.byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultipliedByMetricAndImperialMultiplyingUnitWithSelfAsLeft")
infix fun <
	LeftReciprocalAndRightLeftQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightLeftQuantity,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftReciprocalAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightLeftQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		LeftReciprocalAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: RightRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricReciprocalMultipliedByMetricMultiplyingUnitWithSelfAsLeft")
infix fun <
	LeftReciprocalAndRightLeftQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightLeftQuantity,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftReciprocalAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightLeftQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedMultipliedUnit<
		LeftReciprocalAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(right) {
		value: Decimal,
		unit: RightRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialReciprocalMultipliedByImperialMultiplyingUnitWithSelfAsLeft")
infix fun <
	LeftReciprocalAndRightLeftQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightLeftQuantity,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftReciprocalAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightLeftQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		LeftReciprocalAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: RightRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalMultipliedByUKImperialMultiplyingUnitWithSelfAsLeft")
infix fun <
	LeftReciprocalAndRightLeftQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightLeftQuantity,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftReciprocalAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightLeftQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedMultipliedUnit<
		LeftReciprocalAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(right) {
		value: Decimal,
		unit: RightRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalMultipliedByUSCustomaryMultiplyingUnitWithSelfAsLeft")
infix fun <
	LeftReciprocalAndRightLeftQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightLeftQuantity,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftReciprocalAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightLeftQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		LeftReciprocalAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: RightRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalMultipliedByMetricAndUKImperialMultiplyingUnitWithSelfAsLeft")
infix fun <
	LeftReciprocalAndRightLeftQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightLeftQuantity,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftReciprocalAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightLeftQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedMultipliedUnit<
		LeftReciprocalAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(right) {
		value: Decimal,
		unit: RightRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalMultipliedByMetricAndUSCustomaryMultiplyingUnitWithSelfAsLeft")
infix fun <
	LeftReciprocalAndRightLeftQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightLeftQuantity,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftReciprocalAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightLeftQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		LeftReciprocalAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: RightRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericReciprocalMultipliedByGenericMultiplyingUnitWithSelfAsLeft")
infix fun <
	LeftReciprocalAndRightLeftQuantity : UndefinedQuantityType,
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightLeftQuantity,
		LeftReciprocalUnit,
		>,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightLeftQuantity>,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightUnit : UndefinedMultipliedUnit<
		LeftReciprocalAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightLeftQuantity,
		>,
LeftUnit,
	>.genericMultipliedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftReciprocalAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) =
	multipliedBy(right) {
		value: Decimal,
		unit: RightRightUnit,
		->
		DefaultScientificValue(value, unit)
	}
