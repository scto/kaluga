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
import com.splendo.kaluga.scientific.DefaultUndefinedScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import kotlin.jvm.JvmName

// Div<A, Mul<B, C>> / Inv<Mul<C, B>> -> A

@JvmName("dividingWithMultiplyingDenominatorDividedByReciprocalMultiplyingWithDenominatorRightAsLeftAndDenominatorLeftAsRight")
fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
	NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	DenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	NumeratorNumeratorValue : UndefinedScientificValue<
	NumeratorNumeratorQuantity,
NumeratorNumeratorUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
	factory: (Decimal, NumeratorNumeratorUnit) -> NumeratorNumeratorValue,
) = unit.numerator.byDividing(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingDenominatorDividedByMetricAndImperialReciprocalMultiplyingWithDenominatorRightAsLeftAndDenominatorLeftAsRight")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorNumeratorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDividingWithMultiplyingDenominatorDividedByMetricReciprocalMultiplyingWithDenominatorRightAsLeftAndDenominatorLeftAsRight")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorNumeratorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDividingWithMultiplyingDenominatorDividedByImperialReciprocalMultiplyingWithDenominatorRightAsLeftAndDenominatorLeftAsRight")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorNumeratorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithMultiplyingDenominatorDividedByUKImperialReciprocalMultiplyingWithDenominatorRightAsLeftAndDenominatorLeftAsRight")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorNumeratorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithMultiplyingDenominatorDividedByUSCustomaryReciprocalMultiplyingWithDenominatorRightAsLeftAndDenominatorLeftAsRight")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorNumeratorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithMultiplyingDenominatorDividedByMetricAndUKImperialReciprocalMultiplyingWithDenominatorRightAsLeftAndDenominatorLeftAsRight")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorNumeratorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithMultiplyingDenominatorDividedByMetricAndUSCustomaryReciprocalMultiplyingWithDenominatorRightAsLeftAndDenominatorLeftAsRight")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorNumeratorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("genericDividingWithMultiplyingDenominatorDividedByGenericReciprocalMultiplyingWithDenominatorRightAsLeftAndDenominatorLeftAsRight")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
	NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	DenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.genericDividedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity,
			NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorNumeratorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
