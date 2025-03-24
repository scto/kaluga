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
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import kotlin.jvm.JvmName

// Inv<Mul<A, A>> / Inv<A> -> Inv<A>

@JvmName("reciprocalSquaredDividedByReciprocalRoot")
fun <
	NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	DenominatorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	DenominatorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		DenominatorReciprocalUnit,
		>,
	DenominatorValue : UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		>,
DenominatorUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			>,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		>,
DenominatorUnit,
	>,
	factory: (Decimal, DenominatorUnit) -> DenominatorValue,
) = right.unit.byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalSquaredDividedByMetricAndImperialReciprocalRoot")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricReciprocalSquaredDividedByMetricReciprocalRoot")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			>,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialReciprocalSquaredDividedByImperialReciprocalRoot")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			>,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalSquaredDividedByUKImperialReciprocalRoot")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			>,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalSquaredDividedByUSCustomaryReciprocalRoot")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			>,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalSquaredDividedByMetricAndUKImperialReciprocalRoot")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalSquaredDividedByMetricAndUSCustomaryReciprocalRoot")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("genericReciprocalSquaredDividedByGenericReciprocalRoot")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	DenominatorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity>,
	DenominatorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		DenominatorReciprocalUnit,
		>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
			>,
		>,
NumeratorUnit,
	>.genericDividedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalLeftAndRightAndDenominatorReciprocalQuantity,
		>,
DenominatorUnit,
	>,
) =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
