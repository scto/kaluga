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
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Inv<Wr<A>> / Inv<Mul<Wr<A>, Wr<A>>> -> A!

@JvmName("reciprocalDefinedDividedByReciprocalMultiplyingWithSelfAsLeftAndSelfAsRight")
fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorReciprocalUnit : ScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	WrappedNumeratorReciprocalUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	NumeratorReciprocalUnit,
		>,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedNumeratorReciprocalUnit,
		>,
	DenominatorReciprocalLeftAndRightUnit : ScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	WrappedDenominatorReciprocalLeftAndRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	DenominatorReciprocalLeftAndRightUnit,
		>,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalLeftAndRightUnit,
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalLeftAndRightUnit,
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
	NumeratorReciprocalValue : ScientificValue<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity, NumeratorReciprocalUnit>,
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
	factory: (Decimal, NumeratorReciprocalUnit) -> NumeratorReciprocalValue,
) = unit.inverse.wrapped.byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalDefinedDividedByMetricAndImperialReciprocalMultiplyingWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorReciprocalUnit,
	WrappedNumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftAndRightUnit,
	WrappedDenominatorReciprocalLeftAndRightUnit,
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
	NumeratorReciprocalUnit : AbstractScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorReciprocalUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	NumeratorReciprocalUnit,
		>,
	WrappedNumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedNumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftAndRightUnit : AbstractScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorReciprocalLeftAndRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	DenominatorReciprocalLeftAndRightUnit,
		>,
	WrappedDenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalLeftAndRightUnit,
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalLeftAndRightUnit,
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
		unit: NumeratorReciprocalUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricReciprocalDefinedDividedByMetricReciprocalMultiplyingWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorReciprocalUnit,
	WrappedNumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftAndRightUnit,
	WrappedDenominatorReciprocalLeftAndRightUnit,
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
	NumeratorReciprocalUnit : AbstractScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorReciprocalUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	NumeratorReciprocalUnit,
		>,
	WrappedNumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedNumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftAndRightUnit : AbstractScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorReciprocalLeftAndRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	DenominatorReciprocalLeftAndRightUnit,
		>,
	WrappedDenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalLeftAndRightUnit,
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalLeftAndRightUnit,
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
		unit: NumeratorReciprocalUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialReciprocalDefinedDividedByImperialReciprocalMultiplyingWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorReciprocalUnit,
	WrappedNumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftAndRightUnit,
	WrappedDenominatorReciprocalLeftAndRightUnit,
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
	NumeratorReciprocalUnit : AbstractScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorReciprocalUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	NumeratorReciprocalUnit,
		>,
	WrappedNumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedNumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftAndRightUnit : AbstractScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorReciprocalLeftAndRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	DenominatorReciprocalLeftAndRightUnit,
		>,
	WrappedDenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalLeftAndRightUnit,
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalLeftAndRightUnit,
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
		unit: NumeratorReciprocalUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalDefinedDividedByUKImperialReciprocalMultiplyingWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorReciprocalUnit,
	WrappedNumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftAndRightUnit,
	WrappedDenominatorReciprocalLeftAndRightUnit,
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
	NumeratorReciprocalUnit : AbstractScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorReciprocalUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	NumeratorReciprocalUnit,
		>,
	WrappedNumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedNumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftAndRightUnit : AbstractScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorReciprocalLeftAndRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	DenominatorReciprocalLeftAndRightUnit,
		>,
	WrappedDenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalLeftAndRightUnit,
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalLeftAndRightUnit,
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
		unit: NumeratorReciprocalUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalDefinedDividedByUSCustomaryReciprocalMultiplyingWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorReciprocalUnit,
	WrappedNumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftAndRightUnit,
	WrappedDenominatorReciprocalLeftAndRightUnit,
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
	NumeratorReciprocalUnit : AbstractScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorReciprocalUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	NumeratorReciprocalUnit,
		>,
	WrappedNumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedNumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftAndRightUnit : AbstractScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorReciprocalLeftAndRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	DenominatorReciprocalLeftAndRightUnit,
		>,
	WrappedDenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalLeftAndRightUnit,
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalLeftAndRightUnit,
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
		unit: NumeratorReciprocalUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalDefinedDividedByMetricAndUKImperialReciprocalMultiplyingWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorReciprocalUnit,
	WrappedNumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftAndRightUnit,
	WrappedDenominatorReciprocalLeftAndRightUnit,
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
	NumeratorReciprocalUnit : AbstractScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorReciprocalUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	NumeratorReciprocalUnit,
		>,
	WrappedNumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedNumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftAndRightUnit : AbstractScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorReciprocalLeftAndRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	DenominatorReciprocalLeftAndRightUnit,
		>,
	WrappedDenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalLeftAndRightUnit,
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalLeftAndRightUnit,
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
		unit: NumeratorReciprocalUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalDefinedDividedByMetricAndUSCustomaryReciprocalMultiplyingWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorReciprocalUnit,
	WrappedNumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftAndRightUnit,
	WrappedDenominatorReciprocalLeftAndRightUnit,
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
	NumeratorReciprocalUnit : AbstractScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorReciprocalUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	NumeratorReciprocalUnit,
		>,
	WrappedNumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedNumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftAndRightUnit : AbstractScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorReciprocalLeftAndRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	DenominatorReciprocalLeftAndRightUnit,
		>,
	WrappedDenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalLeftAndRightUnit,
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalLeftAndRightUnit,
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
		unit: NumeratorReciprocalUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericReciprocalDefinedDividedByGenericReciprocalMultiplyingWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorReciprocalUnit : AbstractScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	WrappedNumeratorReciprocalUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	NumeratorReciprocalUnit,
		>,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedNumeratorReciprocalUnit,
		>,
	DenominatorReciprocalLeftAndRightUnit : AbstractScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	WrappedDenominatorReciprocalLeftAndRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
	DenominatorReciprocalLeftAndRightUnit,
		>,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalLeftAndRightUnit,
		UndefinedQuantityType.Extended<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		WrappedDenominatorReciprocalLeftAndRightUnit,
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
		unit: NumeratorReciprocalUnit,
		->
		DefaultScientificValue(value, unit)
	}
