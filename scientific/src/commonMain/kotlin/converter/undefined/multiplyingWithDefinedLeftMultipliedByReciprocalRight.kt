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
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.DefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Mul<Wr<A>, B> * Inv<B> -> A!

@JvmName("multiplyingWithDefinedLeftMultipliedByReciprocalRight")
fun <
	LeftLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftLeftUnit : ScientificUnit<LeftLeftQuantity>,
	WrappedLeftLeftUnit : WrappedUndefinedExtendedUnit<
	LeftLeftQuantity,
	LeftLeftUnit,
		>,
	LeftRightAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
	LeftUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftLeftQuantity,
			>,
		WrappedLeftLeftUnit,
		LeftRightAndRightReciprocalQuantity,
		LeftRightUnit,
		>,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
	RightUnit : UndefinedReciprocalUnit<
		LeftRightAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	LeftLeftValue : ScientificValue<LeftLeftQuantity, LeftLeftUnit>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			LeftLeftQuantity,
			>,
		LeftRightAndRightReciprocalQuantity,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftRightAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
	factory: (Decimal, LeftLeftUnit) -> LeftLeftValue,
) = unit.left.wrapped.byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultiplyingWithDefinedLeftMultipliedByMetricAndImperialReciprocalRight")
infix fun <
	LeftLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftLeftUnit,
	WrappedLeftLeftUnit,
	LeftRightAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			LeftLeftQuantity,
			>,
		LeftRightAndRightReciprocalQuantity,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftRightAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : DefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftLeftUnit : WrappedUndefinedExtendedUnit<
	LeftLeftQuantity,
	LeftLeftUnit,
		>,
	WrappedLeftLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftLeftQuantity,
			>,
		WrappedLeftLeftUnit,
		LeftRightAndRightReciprocalQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		LeftRightAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricMultiplyingWithDefinedLeftMultipliedByMetricReciprocalRight")
infix fun <
	LeftLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftLeftUnit,
	WrappedLeftLeftUnit,
	LeftRightAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			LeftLeftQuantity,
			>,
		LeftRightAndRightReciprocalQuantity,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftRightAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : DefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftLeftUnit : WrappedUndefinedExtendedUnit<
	LeftLeftQuantity,
	LeftLeftUnit,
		>,
	WrappedLeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftLeftQuantity,
			>,
		WrappedLeftLeftUnit,
		LeftRightAndRightReciprocalQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedReciprocalUnit<
		LeftRightAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialMultiplyingWithDefinedLeftMultipliedByImperialReciprocalRight")
infix fun <
	LeftLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftLeftUnit,
	WrappedLeftLeftUnit,
	LeftRightAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			LeftLeftQuantity,
			>,
		LeftRightAndRightReciprocalQuantity,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftRightAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : DefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftLeftUnit : WrappedUndefinedExtendedUnit<
	LeftLeftQuantity,
	LeftLeftUnit,
		>,
	WrappedLeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftLeftQuantity,
			>,
		WrappedLeftLeftUnit,
		LeftRightAndRightReciprocalQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		LeftRightAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialMultiplyingWithDefinedLeftMultipliedByUKImperialReciprocalRight")
infix fun <
	LeftLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftLeftUnit,
	WrappedLeftLeftUnit,
	LeftRightAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			LeftLeftQuantity,
			>,
		LeftRightAndRightReciprocalQuantity,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftRightAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : DefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftLeftUnit : WrappedUndefinedExtendedUnit<
	LeftLeftQuantity,
	LeftLeftUnit,
		>,
	WrappedLeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftLeftQuantity,
			>,
		WrappedLeftLeftUnit,
		LeftRightAndRightReciprocalQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<
		LeftRightAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryMultiplyingWithDefinedLeftMultipliedByUSCustomaryReciprocalRight")
infix fun <
	LeftLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftLeftUnit,
	WrappedLeftLeftUnit,
	LeftRightAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			LeftLeftQuantity,
			>,
		LeftRightAndRightReciprocalQuantity,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftRightAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : DefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftLeftUnit : WrappedUndefinedExtendedUnit<
	LeftLeftQuantity,
	LeftLeftUnit,
		>,
	WrappedLeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftLeftQuantity,
			>,
		WrappedLeftLeftUnit,
		LeftRightAndRightReciprocalQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		LeftRightAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultiplyingWithDefinedLeftMultipliedByMetricAndUKImperialReciprocalRight")
infix fun <
	LeftLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftLeftUnit,
	WrappedLeftLeftUnit,
	LeftRightAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			LeftLeftQuantity,
			>,
		LeftRightAndRightReciprocalQuantity,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftRightAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : DefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftLeftUnit : WrappedUndefinedExtendedUnit<
	LeftLeftQuantity,
	LeftLeftUnit,
		>,
	WrappedLeftLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftLeftQuantity,
			>,
		WrappedLeftLeftUnit,
		LeftRightAndRightReciprocalQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<
		LeftRightAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultiplyingWithDefinedLeftMultipliedByMetricAndUSCustomaryReciprocalRight")
infix fun <
	LeftLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftLeftUnit,
	WrappedLeftLeftUnit,
	LeftRightAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			LeftLeftQuantity,
			>,
		LeftRightAndRightReciprocalQuantity,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftRightAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : DefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftLeftUnit : WrappedUndefinedExtendedUnit<
	LeftLeftQuantity,
	LeftLeftUnit,
		>,
	WrappedLeftLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftLeftQuantity,
			>,
		WrappedLeftLeftUnit,
		LeftRightAndRightReciprocalQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<
		LeftRightAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericMultiplyingWithDefinedLeftMultipliedByGenericReciprocalRight")
infix fun <
	LeftLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftLeftUnit : DefinedScientificUnit<LeftLeftQuantity>,
	WrappedLeftLeftUnit : WrappedUndefinedExtendedUnit<
	LeftLeftQuantity,
	LeftLeftUnit,
		>,
	LeftRightAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
	LeftUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftLeftQuantity,
			>,
		WrappedLeftLeftUnit,
		LeftRightAndRightReciprocalQuantity,
		LeftRightUnit,
		>,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<LeftRightAndRightReciprocalQuantity>,
	RightUnit : UndefinedReciprocalUnit<
		LeftRightAndRightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			LeftLeftQuantity,
			>,
		LeftRightAndRightReciprocalQuantity,
		>,
LeftUnit,
	>.genericMultipliedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftRightAndRightReciprocalQuantity,
		>,
RightUnit,
	>,
) =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftLeftUnit,
		->
		DefaultScientificValue(value, unit)
	}
