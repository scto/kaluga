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

// Inv<A> / Inv<Mul<A, A>> -> A

@JvmName("reciprocalDividedByReciprocalSquaredWithSelfAsRoot")
fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorReciprocalUnit,
		>,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	NumeratorReciprocalValue : UndefinedScientificValue<
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
NumeratorReciprocalUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
	factory: (Decimal, NumeratorReciprocalUnit) -> NumeratorReciprocalValue,
) = unit.inverse.byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalDividedByMetricAndImperialReciprocalSquaredWithSelfAsRoot")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
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

@JvmName("metricReciprocalDividedByMetricReciprocalSquaredWithSelfAsRoot")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
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

@JvmName("imperialReciprocalDividedByImperialReciprocalSquaredWithSelfAsRoot")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
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

@JvmName("ukImperialReciprocalDividedByUKImperialReciprocalSquaredWithSelfAsRoot")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
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

@JvmName("usCustomaryReciprocalDividedByUSCustomaryReciprocalSquaredWithSelfAsRoot")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
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

@JvmName("metricAndUKImperialReciprocalDividedByMetricAndUKImperialReciprocalSquaredWithSelfAsRoot")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
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

@JvmName("metricAndUSCustomaryReciprocalDividedByMetricAndUSCustomaryReciprocalSquaredWithSelfAsRoot")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
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

@JvmName("genericReciprocalDividedByGenericReciprocalSquaredWithSelfAsRoot")
infix fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		NumeratorReciprocalUnit,
		>,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity>,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.genericDividedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorReciprocalLeftAndRightQuantity,
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
