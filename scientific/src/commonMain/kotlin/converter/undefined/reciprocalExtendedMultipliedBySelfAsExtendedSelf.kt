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
import com.splendo.kaluga.scientific.unit.UndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.One
import kotlin.jvm.JvmName

// Inv<Ex<A>> * A! -> One

@JvmName("reciprocalExtendedMultipliedBySelfAsExtendedSelf")
fun <
	ExtendedLeftReciprocalUnit : UndefinedExtendedUnit<
	LeftReciprocalAndRightQuantity,
		>,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalAndRightQuantity,
			>,
		ExtendedLeftReciprocalUnit,
		>,
	LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit : ScientificUnit<LeftReciprocalAndRightQuantity>,
	TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
	TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Extended<
			LeftReciprocalAndRightQuantity,
			>,
		>,
LeftUnit,
	>.multipliedBy(
	right: ScientificValue<LeftReciprocalAndRightQuantity, RightUnit>,
	getDimensionless: () -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = getDimensionless().byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalExtendedMultipliedByMetricAndImperialSelfAsExtendedSelf")
infix fun <
	ExtendedLeftReciprocalUnit,
	LeftUnit,
	LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Extended<
			LeftReciprocalAndRightQuantity,
			>,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: ScientificValue<LeftReciprocalAndRightQuantity, RightUnit>,
) where
	ExtendedLeftReciprocalUnit : UndefinedExtendedUnit<
	LeftReciprocalAndRightQuantity,
		>,
	ExtendedLeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	ExtendedLeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedLeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalAndRightQuantity,
			>,
		ExtendedLeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
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

@JvmName("metricReciprocalExtendedMultipliedByMetricSelfAsExtendedSelf")
infix fun <
	ExtendedLeftReciprocalUnit,
	LeftUnit,
	LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Extended<
			LeftReciprocalAndRightQuantity,
			>,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: ScientificValue<LeftReciprocalAndRightQuantity, RightUnit>,
) where
	ExtendedLeftReciprocalUnit : UndefinedExtendedUnit<
	LeftReciprocalAndRightQuantity,
		>,
	ExtendedLeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalAndRightQuantity,
			>,
		ExtendedLeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
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

@JvmName("imperialReciprocalExtendedMultipliedByImperialSelfAsExtendedSelf")
infix fun <
	ExtendedLeftReciprocalUnit,
	LeftUnit,
	LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Extended<
			LeftReciprocalAndRightQuantity,
			>,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: ScientificValue<LeftReciprocalAndRightQuantity, RightUnit>,
) where
	ExtendedLeftReciprocalUnit : UndefinedExtendedUnit<
	LeftReciprocalAndRightQuantity,
		>,
	ExtendedLeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedLeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalAndRightQuantity,
			>,
		ExtendedLeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
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

@JvmName("ukImperialReciprocalExtendedMultipliedByUKImperialSelfAsExtendedSelf")
infix fun <
	ExtendedLeftReciprocalUnit,
	LeftUnit,
	LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Extended<
			LeftReciprocalAndRightQuantity,
			>,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: ScientificValue<LeftReciprocalAndRightQuantity, RightUnit>,
) where
	ExtendedLeftReciprocalUnit : UndefinedExtendedUnit<
	LeftReciprocalAndRightQuantity,
		>,
	ExtendedLeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalAndRightQuantity,
			>,
		ExtendedLeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
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

@JvmName("usCustomaryReciprocalExtendedMultipliedByUSCustomarySelfAsExtendedSelf")
infix fun <
	ExtendedLeftReciprocalUnit,
	LeftUnit,
	LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Extended<
			LeftReciprocalAndRightQuantity,
			>,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: ScientificValue<LeftReciprocalAndRightQuantity, RightUnit>,
) where
	ExtendedLeftReciprocalUnit : UndefinedExtendedUnit<
	LeftReciprocalAndRightQuantity,
		>,
	ExtendedLeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalAndRightQuantity,
			>,
		ExtendedLeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
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

@JvmName("metricAndUKImperialReciprocalExtendedMultipliedByMetricAndUKImperialSelfAsExtendedSelf")
infix fun <
	ExtendedLeftReciprocalUnit,
	LeftUnit,
	LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Extended<
			LeftReciprocalAndRightQuantity,
			>,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: ScientificValue<LeftReciprocalAndRightQuantity, RightUnit>,
) where
	ExtendedLeftReciprocalUnit : UndefinedExtendedUnit<
	LeftReciprocalAndRightQuantity,
		>,
	ExtendedLeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	ExtendedLeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalAndRightQuantity,
			>,
		ExtendedLeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
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

@JvmName("metricAndUSCustomaryReciprocalExtendedMultipliedByMetricAndUSCustomarySelfAsExtendedSelf")
infix fun <
	ExtendedLeftReciprocalUnit,
	LeftUnit,
	LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Extended<
			LeftReciprocalAndRightQuantity,
			>,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: ScientificValue<LeftReciprocalAndRightQuantity, RightUnit>,
) where
	ExtendedLeftReciprocalUnit : UndefinedExtendedUnit<
	LeftReciprocalAndRightQuantity,
		>,
	ExtendedLeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	ExtendedLeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalAndRightQuantity,
			>,
		ExtendedLeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
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

@JvmName("genericReciprocalExtendedMultipliedByGenericSelfAsExtendedSelf")
infix fun <
	ExtendedLeftReciprocalUnit : UndefinedExtendedUnit<
	LeftReciprocalAndRightQuantity,
		>,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			LeftReciprocalAndRightQuantity,
			>,
		ExtendedLeftReciprocalUnit,
		>,
	LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Extended<
			LeftReciprocalAndRightQuantity,
			>,
		>,
LeftUnit,
	>.genericMultipliedByGeneric(
	right: ScientificValue<LeftReciprocalAndRightQuantity, RightUnit>,
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
