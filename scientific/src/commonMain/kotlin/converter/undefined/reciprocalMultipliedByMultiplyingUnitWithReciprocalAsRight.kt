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
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import kotlin.jvm.JvmName

// Inv<A> * Mul<B, A> -> B

@JvmName("reciprocalMultipliedByMultiplyingUnitWithReciprocalAsRight")
fun <
	LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
	RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
	RightLeftValue : UndefinedScientificValue<RightLeftQuantity, RightLeftUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightRightQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftReciprocalAndRightRightQuantity>, RightUnit>,
	factory: (Decimal, RightLeftUnit) -> RightLeftValue
) = right.unit.left.byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultipliedByMetricAndImperialMultiplyingUnitWithReciprocalAsRight")
infix operator fun <
	LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightRightUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightRightQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftReciprocalAndRightRightQuantity>, RightUnit>,
) where
	LeftReciprocalAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	times(right) {
		value: Decimal,
		unit: RightLeftUnit
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricReciprocalMultipliedByMetricMultiplyingUnitWithReciprocalAsRight")
infix operator fun <
	LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightRightUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightRightQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftReciprocalAndRightRightQuantity>, RightUnit>,
) where
	LeftReciprocalAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
	RightUnit : MeasurementUsage.UsedInMetric =
	times(right) {
		value: Decimal,
		unit: RightLeftUnit
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialReciprocalMultipliedByImperialMultiplyingUnitWithReciprocalAsRight")
infix operator fun <
	LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightRightUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightRightQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftReciprocalAndRightRightQuantity>, RightUnit>,
) where
	LeftReciprocalAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	times(right) {
		value: Decimal,
		unit: RightLeftUnit
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalMultipliedByUKImperialMultiplyingUnitWithReciprocalAsRight")
infix operator fun <
	LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightRightUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightRightQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftReciprocalAndRightRightQuantity>, RightUnit>,
) where
	LeftReciprocalAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	times(right) {
		value: Decimal,
		unit: RightLeftUnit
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalMultipliedByUSCustomaryMultiplyingUnitWithReciprocalAsRight")
infix operator fun <
	LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightRightUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightRightQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftReciprocalAndRightRightQuantity>, RightUnit>,
) where
	LeftReciprocalAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	times(right) {
		value: Decimal,
		unit: RightLeftUnit
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalMultipliedByMetricAndUKImperialMultiplyingUnitWithReciprocalAsRight")
infix operator fun <
	LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightRightUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightRightQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftReciprocalAndRightRightQuantity>, RightUnit>,
) where
	LeftReciprocalAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	times(right) {
		value: Decimal,
		unit: RightLeftUnit
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalMultipliedByMetricAndUSCustomaryMultiplyingUnitWithReciprocalAsRight")
infix operator fun <
	LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightRightUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightRightQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftReciprocalAndRightRightQuantity>, RightUnit>,
) where
	LeftReciprocalAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalAndRightRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	times(right) {
		value: Decimal,
		unit: RightLeftUnit
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("genericReciprocalMultipliedByGenericMultiplyingUnitWithReciprocalAsRight")
infix operator fun <
	LeftReciprocalAndRightRightQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightRightQuantity>,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
	RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftReciprocalAndRightRightQuantity, LeftReciprocalAndRightRightUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightRightQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftReciprocalAndRightRightQuantity>, RightUnit>,
) =
	times(right) {
		value: Decimal,
		unit: RightLeftUnit
		->
		DefaultUndefinedScientificValue(value, unit)
	}

