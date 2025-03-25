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
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import kotlin.jvm.JvmName

// Div<A, Mul<B, B>> / Inv<Mul<B, B>> -> A

@JvmName("dividingWithSquaredDenominatorDividedByReciprocalSquaredWithDenominatorRootAsRoot")
fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
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
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
	factory: (Decimal, NumeratorNumeratorUnit) -> NumeratorNumeratorValue,
) = unit.numerator.byDividing(this, right, factory)

@JvmName("metricAndImperialDividingWithSquaredDenominatorDividedByMetricAndImperialReciprocalSquaredWithDenominatorRootAsRoot")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
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
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
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
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingWithSquaredDenominatorDividedByMetricReciprocalSquaredWithDenominatorRootAsRoot")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
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
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingWithSquaredDenominatorDividedByImperialReciprocalSquaredWithDenominatorRootAsRoot")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
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
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithSquaredDenominatorDividedByUKImperialReciprocalSquaredWithDenominatorRootAsRoot")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
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
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithSquaredDenominatorDividedByUSCustomaryReciprocalSquaredWithDenominatorRootAsRoot")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
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
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithSquaredDenominatorDividedByMetricAndUKImperialReciprocalSquaredWithDenominatorRootAsRoot")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
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
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithSquaredDenominatorDividedByMetricAndUSCustomaryReciprocalSquaredWithDenominatorRootAsRoot")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
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
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericDividingWithSquaredDenominatorDividedByGenericReciprocalSquaredWithDenominatorRootAsRoot")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.genericDividedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}
