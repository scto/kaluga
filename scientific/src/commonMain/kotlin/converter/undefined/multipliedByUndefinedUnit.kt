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
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

fun <
	LeftQuantity : UndefinedQuantityType,
	LeftUnit : UndefinedScientificUnit<LeftQuantity>,
	RightQuantity : UndefinedQuantityType,
	RightUnit : UndefinedScientificUnit<RightQuantity>,
	TargetUnit : UndefinedMultipliedUnit<LeftQuantity, LeftUnit, RightQuantity, RightUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Multiplying<LeftQuantity, RightQuantity>, TargetUnit>
	> UndefinedScientificValue<LeftQuantity, LeftUnit>.multipliedByUndefinedUnit(
	right: UndefinedScientificValue<RightQuantity, RightUnit>,
	leftUnitXRightUnit: LeftUnit.(RightUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.leftUnitXRightUnit(right.unit).byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultipliedByMetricAndImperialUndefinedUnit")
infix operator fun <
	LeftQuantity : UndefinedQuantityType,
	LeftUnit,
	RightQuantity : UndefinedQuantityType,
	RightUnit
	> UndefinedScientificValue<LeftQuantity, LeftUnit>.times(
	right: UndefinedScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : UndefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByUndefinedUnit(
		right,
		leftUnitXRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndImperial<
				LeftQuantity,
				LeftUnit,
				RightQuantity,
				RightUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricMultipliedByMetricUndefinedUnit")
infix operator fun <
	LeftQuantity : UndefinedQuantityType,
	LeftUnit,
	RightQuantity : UndefinedQuantityType,
	RightUnit
	> UndefinedScientificValue<LeftQuantity, LeftUnit>.times(
	right: UndefinedScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : UndefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedByUndefinedUnit(
		right,
		leftUnitXRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.Metric<
				LeftQuantity,
				LeftUnit,
				RightQuantity,
				RightUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialMultipliedByImperialUndefinedUnit")
infix operator fun <
	LeftQuantity : UndefinedQuantityType,
	LeftUnit,
	RightQuantity : UndefinedQuantityType,
	RightUnit
	> UndefinedScientificValue<LeftQuantity, LeftUnit>.times(
	right: UndefinedScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : UndefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByUndefinedUnit(
		right,
		leftUnitXRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.Imperial<
				LeftQuantity,
				LeftUnit,
				RightQuantity,
				RightUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialMultipliedByUKImperialUndefinedUnit")
infix operator fun <
	LeftQuantity : UndefinedQuantityType,
	LeftUnit,
	RightQuantity : UndefinedQuantityType,
	RightUnit
	> UndefinedScientificValue<LeftQuantity, LeftUnit>.times(
	right: UndefinedScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : UndefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedByUndefinedUnit(
		right,
		leftUnitXRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.UKImperial<
				LeftQuantity,
				LeftUnit,
				RightQuantity,
				RightUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryMultipliedByUSCustomaryUndefinedUnit")
infix operator fun <
	LeftQuantity : UndefinedQuantityType,
	LeftUnit,
	RightQuantity : UndefinedQuantityType,
	RightUnit
	> UndefinedScientificValue<LeftQuantity, LeftUnit>.times(
	right: UndefinedScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : UndefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByUndefinedUnit(
		right,
		leftUnitXRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.USCustomary<
				LeftQuantity,
				LeftUnit,
				RightQuantity,
				RightUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultipliedByMetricAndUKImperialUndefinedUnit")
infix operator fun <
	LeftQuantity : UndefinedQuantityType,
	LeftUnit,
	RightQuantity : UndefinedQuantityType,
	RightUnit
	> UndefinedScientificValue<LeftQuantity, LeftUnit>.times(
	right: UndefinedScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : UndefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedByUndefinedUnit(
		right,
		leftUnitXRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndUKImperial<
				LeftQuantity,
				LeftUnit,
				RightQuantity,
				RightUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultipliedByMetricAndUSCustomaryUndefinedUnit")
infix operator fun <
	LeftQuantity : UndefinedQuantityType,
	LeftUnit,
	RightQuantity : UndefinedQuantityType,
	RightUnit
	> UndefinedScientificValue<LeftQuantity, LeftUnit>.times(
	right: UndefinedScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : UndefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByUndefinedUnit(
		right,
		leftUnitXRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndUSCustomary<
				LeftQuantity,
				LeftUnit,
				RightQuantity,
				RightUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

