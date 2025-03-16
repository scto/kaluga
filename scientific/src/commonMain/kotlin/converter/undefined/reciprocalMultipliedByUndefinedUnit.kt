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
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// Inv<A> * B -> Div<B, A>

@JvmName("reciprocalMultipliedByUndefinedUnit")
fun <
	LeftReciprocalQuantity : UndefinedQuantityType,
	LeftReciprocalUnit : UndefinedScientificUnit<LeftReciprocalQuantity>,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalQuantity, LeftReciprocalUnit>,
	RightQuantity : UndefinedQuantityType,
	RightUnit : UndefinedScientificUnit<RightQuantity>,
	TargetUnit : UndefinedDividedUnit<RightQuantity, RightUnit, LeftReciprocalQuantity, LeftReciprocalUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<RightQuantity, LeftReciprocalQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalQuantity>, LeftUnit>.multipliedByUndefinedUnit(
	right: UndefinedScientificValue<RightQuantity, RightUnit>,
	rightUnitPerLeftReciprocalUnit: RightUnit.(LeftReciprocalUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = right.unit.rightUnitPerLeftReciprocalUnit(unit.inverse).byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultipliedByMetricAndImperialUndefinedUnit")
infix fun <
	LeftReciprocalQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightQuantity : UndefinedQuantityType,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalQuantity>, LeftUnit>.multipliedByUndefinedUnit(
	right: UndefinedScientificValue<RightQuantity, RightUnit>,
) where
	LeftReciprocalUnit : UndefinedScientificUnit<LeftReciprocalQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalQuantity, LeftReciprocalUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByUndefinedUnit(
		right,
		rightUnitPerLeftReciprocalUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				RightQuantity,
				RightUnit,
				LeftReciprocalQuantity,
				LeftReciprocalUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricReciprocalMultipliedByMetricUndefinedUnit")
infix fun <
	LeftReciprocalQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightQuantity : UndefinedQuantityType,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalQuantity>, LeftUnit>.multipliedByUndefinedUnit(
	right: UndefinedScientificValue<RightQuantity, RightUnit>,
) where
	LeftReciprocalUnit : UndefinedScientificUnit<LeftReciprocalQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalQuantity, LeftReciprocalUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedByUndefinedUnit(
		right,
		rightUnitPerLeftReciprocalUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				RightQuantity,
				RightUnit,
				LeftReciprocalQuantity,
				LeftReciprocalUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialReciprocalMultipliedByImperialUndefinedUnit")
infix fun <
	LeftReciprocalQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightQuantity : UndefinedQuantityType,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalQuantity>, LeftUnit>.multipliedByUndefinedUnit(
	right: UndefinedScientificValue<RightQuantity, RightUnit>,
) where
	LeftReciprocalUnit : UndefinedScientificUnit<LeftReciprocalQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalQuantity, LeftReciprocalUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByUndefinedUnit(
		right,
		rightUnitPerLeftReciprocalUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				RightQuantity,
				RightUnit,
				LeftReciprocalQuantity,
				LeftReciprocalUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalMultipliedByUKImperialUndefinedUnit")
infix fun <
	LeftReciprocalQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightQuantity : UndefinedQuantityType,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalQuantity>, LeftUnit>.multipliedByUndefinedUnit(
	right: UndefinedScientificValue<RightQuantity, RightUnit>,
) where
	LeftReciprocalUnit : UndefinedScientificUnit<LeftReciprocalQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalQuantity, LeftReciprocalUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedByUndefinedUnit(
		right,
		rightUnitPerLeftReciprocalUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				RightQuantity,
				RightUnit,
				LeftReciprocalQuantity,
				LeftReciprocalUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalMultipliedByUSCustomaryUndefinedUnit")
infix fun <
	LeftReciprocalQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightQuantity : UndefinedQuantityType,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalQuantity>, LeftUnit>.multipliedByUndefinedUnit(
	right: UndefinedScientificValue<RightQuantity, RightUnit>,
) where
	LeftReciprocalUnit : UndefinedScientificUnit<LeftReciprocalQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalQuantity, LeftReciprocalUnit>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByUndefinedUnit(
		right,
		rightUnitPerLeftReciprocalUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				RightQuantity,
				RightUnit,
				LeftReciprocalQuantity,
				LeftReciprocalUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalMultipliedByMetricAndUKImperialUndefinedUnit")
infix fun <
	LeftReciprocalQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightQuantity : UndefinedQuantityType,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalQuantity>, LeftUnit>.multipliedByUndefinedUnit(
	right: UndefinedScientificValue<RightQuantity, RightUnit>,
) where
	LeftReciprocalUnit : UndefinedScientificUnit<LeftReciprocalQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalQuantity, LeftReciprocalUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedByUndefinedUnit(
		right,
		rightUnitPerLeftReciprocalUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				RightQuantity,
				RightUnit,
				LeftReciprocalQuantity,
				LeftReciprocalUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalMultipliedByMetricAndUSCustomaryUndefinedUnit")
infix fun <
	LeftReciprocalQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightQuantity : UndefinedQuantityType,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalQuantity>, LeftUnit>.multipliedByUndefinedUnit(
	right: UndefinedScientificValue<RightQuantity, RightUnit>,
) where
	LeftReciprocalUnit : UndefinedScientificUnit<LeftReciprocalQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalQuantity, LeftReciprocalUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByUndefinedUnit(
		right,
		rightUnitPerLeftReciprocalUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				RightQuantity,
				RightUnit,
				LeftReciprocalQuantity,
				LeftReciprocalUnit
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

