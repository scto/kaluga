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
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.DefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Inv<Ex<A>> / Inv<Mul<Ex<A>, Wr<A>>> -> A!

@JvmName("reciprocalExtendedDividedByReciprocalMultiplyingWithSelfAsLeftAndSelfAsRight")
fun <
	ExtendedNumeratorReciprocalUnit : UndefinedExtendedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		ExtendedNumeratorReciprocalUnit,
		>,
	ExtendedDenominatorReciprocalLeftUnit : UndefinedExtendedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorReciprocalRightUnit : ScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	WrappedDenominatorReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		ExtendedDenominatorReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalRightUnit,
		>,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorReciprocalRightValue : ScientificValue<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity, DenominatorReciprocalRightUnit>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			>,
		>,
DenominatorUnit,
	>,
	factory: (Decimal, DenominatorReciprocalRightUnit) -> DenominatorReciprocalRightValue,
) = unit.inverse.extended.byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalExtendedDividedByMetricAndImperialReciprocalMultiplyingWithSelfAsLeftAndSelfAsRight")
infix fun <
	ExtendedNumeratorReciprocalUnit,
	NumeratorUnit,
	ExtendedDenominatorReciprocalLeftUnit,
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorReciprocalRightUnit,
	WrappedDenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			>,
		>,
DenominatorUnit,
	>,
) where
	ExtendedNumeratorReciprocalUnit : UndefinedExtendedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
	ExtendedNumeratorReciprocalUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedNumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	ExtendedNumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedNumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		ExtendedNumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedDenominatorReciprocalLeftUnit : UndefinedExtendedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
	ExtendedDenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : DefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	DenominatorReciprocalRightUnit,
		>,
	WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		ExtendedDenominatorReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorReciprocalRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricReciprocalExtendedDividedByMetricReciprocalMultiplyingWithSelfAsLeftAndSelfAsRight")
infix fun <
	ExtendedNumeratorReciprocalUnit,
	NumeratorUnit,
	ExtendedDenominatorReciprocalLeftUnit,
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorReciprocalRightUnit,
	WrappedDenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			>,
		>,
DenominatorUnit,
	>,
) where
	ExtendedNumeratorReciprocalUnit : UndefinedExtendedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
	ExtendedNumeratorReciprocalUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedNumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		ExtendedNumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	ExtendedDenominatorReciprocalLeftUnit : UndefinedExtendedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
	ExtendedDenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : DefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	DenominatorReciprocalRightUnit,
		>,
	WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		ExtendedDenominatorReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorReciprocalRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialReciprocalExtendedDividedByImperialReciprocalMultiplyingWithSelfAsLeftAndSelfAsRight")
infix fun <
	ExtendedNumeratorReciprocalUnit,
	NumeratorUnit,
	ExtendedDenominatorReciprocalLeftUnit,
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorReciprocalRightUnit,
	WrappedDenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			>,
		>,
DenominatorUnit,
	>,
) where
	ExtendedNumeratorReciprocalUnit : UndefinedExtendedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
	ExtendedNumeratorReciprocalUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedNumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedNumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		ExtendedNumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedDenominatorReciprocalLeftUnit : UndefinedExtendedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
	ExtendedDenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : DefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	DenominatorReciprocalRightUnit,
		>,
	WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		ExtendedDenominatorReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorReciprocalRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalExtendedDividedByUKImperialReciprocalMultiplyingWithSelfAsLeftAndSelfAsRight")
infix fun <
	ExtendedNumeratorReciprocalUnit,
	NumeratorUnit,
	ExtendedDenominatorReciprocalLeftUnit,
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorReciprocalRightUnit,
	WrappedDenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			>,
		>,
DenominatorUnit,
	>,
) where
	ExtendedNumeratorReciprocalUnit : UndefinedExtendedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
	ExtendedNumeratorReciprocalUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedNumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		ExtendedNumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedDenominatorReciprocalLeftUnit : UndefinedExtendedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
	ExtendedDenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : DefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	DenominatorReciprocalRightUnit,
		>,
	WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		ExtendedDenominatorReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorReciprocalRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalExtendedDividedByUSCustomaryReciprocalMultiplyingWithSelfAsLeftAndSelfAsRight")
infix fun <
	ExtendedNumeratorReciprocalUnit,
	NumeratorUnit,
	ExtendedDenominatorReciprocalLeftUnit,
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorReciprocalRightUnit,
	WrappedDenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			>,
		>,
DenominatorUnit,
	>,
) where
	ExtendedNumeratorReciprocalUnit : UndefinedExtendedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
	ExtendedNumeratorReciprocalUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedNumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		ExtendedNumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedDenominatorReciprocalLeftUnit : UndefinedExtendedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
	ExtendedDenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : DefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	DenominatorReciprocalRightUnit,
		>,
	WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		ExtendedDenominatorReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorReciprocalRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalExtendedDividedByMetricAndUKImperialReciprocalMultiplyingWithSelfAsLeftAndSelfAsRight")
infix fun <
	ExtendedNumeratorReciprocalUnit,
	NumeratorUnit,
	ExtendedDenominatorReciprocalLeftUnit,
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorReciprocalRightUnit,
	WrappedDenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			>,
		>,
DenominatorUnit,
	>,
) where
	ExtendedNumeratorReciprocalUnit : UndefinedExtendedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
	ExtendedNumeratorReciprocalUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedNumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	ExtendedNumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		ExtendedNumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedDenominatorReciprocalLeftUnit : UndefinedExtendedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
	ExtendedDenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : DefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	DenominatorReciprocalRightUnit,
		>,
	WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		ExtendedDenominatorReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorReciprocalRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalExtendedDividedByMetricAndUSCustomaryReciprocalMultiplyingWithSelfAsLeftAndSelfAsRight")
infix fun <
	ExtendedNumeratorReciprocalUnit,
	NumeratorUnit,
	ExtendedDenominatorReciprocalLeftUnit,
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorReciprocalRightUnit,
	WrappedDenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			>,
		>,
DenominatorUnit,
	>,
) where
	ExtendedNumeratorReciprocalUnit : UndefinedExtendedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
	ExtendedNumeratorReciprocalUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedNumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	ExtendedNumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		ExtendedNumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedDenominatorReciprocalLeftUnit : UndefinedExtendedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
	ExtendedDenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
	ExtendedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	ExtendedDenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : DefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	DenominatorReciprocalRightUnit,
		>,
	WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		ExtendedDenominatorReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorReciprocalRightUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericReciprocalExtendedDividedByGenericReciprocalMultiplyingWithSelfAsLeftAndSelfAsRight")
infix fun <
	ExtendedNumeratorReciprocalUnit : UndefinedExtendedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		ExtendedNumeratorReciprocalUnit,
		>,
	ExtendedDenominatorReciprocalLeftUnit : UndefinedExtendedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorReciprocalRightUnit : DefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	WrappedDenominatorReciprocalRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		ExtendedDenominatorReciprocalLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalRightUnit,
		>,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			>,
		DenominatorReciprocalUnit,
		>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.genericDividedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
				>,
			>,
		>,
DenominatorUnit,
	>,
) =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorReciprocalRightUnit,
		->
		DefaultScientificValue(value, unit)
	}
