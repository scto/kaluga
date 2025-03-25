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
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import kotlin.jvm.JvmName

// Inv<A> / Inv<Mul<A, B>> -> B

@JvmName("reciprocalDividedByReciprocalMultiplyingWithSelfAsLeft")
fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		NumeratorReciprocalUnit,
		>,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalRightQuantity : UndefinedQuantityType,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<DenominatorReciprocalRightQuantity>,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		DenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorReciprocalRightValue : UndefinedScientificValue<
	DenominatorReciprocalRightQuantity,
DenominatorReciprocalRightUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
	factory: (Decimal, DenominatorReciprocalRightUnit) -> DenominatorReciprocalRightValue,
) = right.unit.inverse.right.byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalDividedByMetricAndImperialReciprocalMultiplyingWithSelfAsLeft")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightQuantity : UndefinedQuantityType,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<DenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		DenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
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

@JvmName("metricReciprocalDividedByMetricReciprocalMultiplyingWithSelfAsLeft")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightQuantity : UndefinedQuantityType,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<DenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		DenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
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

@JvmName("imperialReciprocalDividedByImperialReciprocalMultiplyingWithSelfAsLeft")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightQuantity : UndefinedQuantityType,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<DenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		DenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
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

@JvmName("ukImperialReciprocalDividedByUKImperialReciprocalMultiplyingWithSelfAsLeft")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightQuantity : UndefinedQuantityType,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<DenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		DenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
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

@JvmName("usCustomaryReciprocalDividedByUSCustomaryReciprocalMultiplyingWithSelfAsLeft")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightQuantity : UndefinedQuantityType,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<DenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		DenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
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

@JvmName("metricAndUKImperialReciprocalDividedByMetricAndUKImperialReciprocalMultiplyingWithSelfAsLeft")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightQuantity : UndefinedQuantityType,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<DenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		DenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
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

@JvmName("metricAndUSCustomaryReciprocalDividedByMetricAndUSCustomaryReciprocalMultiplyingWithSelfAsLeft")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightQuantity : UndefinedQuantityType,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<DenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		DenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
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

@JvmName("genericReciprocalDividedByGenericReciprocalMultiplyingWithSelfAsLeft")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		NumeratorReciprocalUnit,
		>,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalRightQuantity : UndefinedQuantityType,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<DenominatorReciprocalRightQuantity>,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		DenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
		>,
NumeratorUnit,
	>.genericDividedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
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
