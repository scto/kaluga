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

// Inv<A> * A -> One

@JvmName("reciprocalMultipliedBySelf")
fun <
	LeftReciprocalAndRightQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
	TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
	TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightQuantity>, LeftUnit>.multipliedBySelf(
	right: UndefinedScientificValue<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
	getDimensionless: () -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = getDimensionless().byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultipliedByMetricAndImperialSelf")
infix fun <
	LeftReciprocalAndRightQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightQuantity>, LeftUnit>.multipliedBySelf(
	right: UndefinedScientificValue<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
) where
	LeftReciprocalAndRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBySelf(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricReciprocalMultipliedByMetricSelf")
infix fun <
	LeftReciprocalAndRightQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightQuantity>, LeftUnit>.multipliedBySelf(
	right: UndefinedScientificValue<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
) where
	LeftReciprocalAndRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric =
	multipliedBySelf(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialReciprocalMultipliedByImperialSelf")
infix fun <
	LeftReciprocalAndRightQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightQuantity>, LeftUnit>.multipliedBySelf(
	right: UndefinedScientificValue<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
) where
	LeftReciprocalAndRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBySelf(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalMultipliedByUKImperialSelf")
infix fun <
	LeftReciprocalAndRightQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightQuantity>, LeftUnit>.multipliedBySelf(
	right: UndefinedScientificValue<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
) where
	LeftReciprocalAndRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBySelf(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalMultipliedByUSCustomarySelf")
infix fun <
	LeftReciprocalAndRightQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightQuantity>, LeftUnit>.multipliedBySelf(
	right: UndefinedScientificValue<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
) where
	LeftReciprocalAndRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBySelf(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalMultipliedByMetricAndUKImperialSelf")
infix fun <
	LeftReciprocalAndRightQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightQuantity>, LeftUnit>.multipliedBySelf(
	right: UndefinedScientificValue<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
) where
	LeftReciprocalAndRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBySelf(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalMultipliedByMetricAndUSCustomarySelf")
infix fun <
	LeftReciprocalAndRightQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightQuantity>, LeftUnit>.multipliedBySelf(
	right: UndefinedScientificValue<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
) where
	LeftReciprocalAndRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBySelf(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericReciprocalMultipliedByGenericSelf")
infix fun <
	LeftReciprocalAndRightQuantity : UndefinedQuantityType,
	LeftReciprocalAndRightUnit : UndefinedScientificUnit<LeftReciprocalAndRightQuantity>,
	LeftUnit : UndefinedReciprocalUnit<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalAndRightQuantity>, LeftUnit>.multipliedBySelf(
	right: UndefinedScientificValue<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
) =
	multipliedBySelf(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One
		->
		DefaultScientificValue(value, unit)
	}

