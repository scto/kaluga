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
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.Dimensionless
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.One
import kotlin.jvm.JvmName

// A * Inv<A> -> One

@JvmName("multipliedBySelf")
fun <
	LeftAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
	RightReciprocalUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
	RightUnit : UndefinedReciprocalUnit<
		LeftAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
	TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>,
	> UndefinedScientificValue<
	LeftAndRightReciprocalQuantity,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
	getDimensionless: () -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = getDimensionless().byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultipliedByMetricAndImperialSelf")
infix fun <
	LeftAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	LeftAndRightReciprocalQuantity,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		LeftAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricMultipliedByMetricSelf")
infix fun <
	LeftAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	LeftAndRightReciprocalQuantity,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedReciprocalUnit<
		LeftAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialMultipliedByImperialSelf")
infix fun <
	LeftAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	LeftAndRightReciprocalQuantity,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		LeftAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialMultipliedByUKImperialSelf")
infix fun <
	LeftAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	LeftAndRightReciprocalQuantity,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<
		LeftAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryMultipliedByUSCustomarySelf")
infix fun <
	LeftAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	LeftAndRightReciprocalQuantity,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		LeftAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultipliedByMetricAndUKImperialSelf")
infix fun <
	LeftAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	LeftAndRightReciprocalQuantity,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<
		LeftAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultipliedByMetricAndUSCustomarySelf")
infix fun <
	LeftAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	LeftAndRightReciprocalQuantity,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		LeftAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericMultipliedByGenericSelf")
infix fun <
	LeftAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
	RightReciprocalUnit : UndefinedScientificUnit<LeftAndRightReciprocalQuantity>,
	RightUnit : UndefinedReciprocalUnit<
		LeftAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	> UndefinedScientificValue<
	LeftAndRightReciprocalQuantity,
LeftUnit,
	>.genericMultipliedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) =
	multipliedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}
