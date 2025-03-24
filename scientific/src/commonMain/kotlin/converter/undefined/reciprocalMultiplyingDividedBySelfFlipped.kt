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
import com.splendo.kaluga.scientific.unit.Dimensionless
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.One
import kotlin.jvm.JvmName

// Inv<Mul<A, B>> / Inv<Mul<B, A>> -> One

@JvmName("reciprocalMultiplyingDividedBySelfFlipped")
fun <
	NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
	NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
	TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
	getDimensionless: () -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = getDimensionless().byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalMultiplyingDividedByMetricAndImperialSelfFlipped")
infix fun <
	NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricReciprocalMultiplyingDividedByMetricSelfFlipped")
infix fun <
	NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialReciprocalMultiplyingDividedByImperialSelfFlipped")
infix fun <
	NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalMultiplyingDividedByUKImperialSelfFlipped")
infix fun <
	NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalMultiplyingDividedByUSCustomarySelfFlipped")
infix fun <
	NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalMultiplyingDividedByMetricAndUKImperialSelfFlipped")
infix fun <
	NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalMultiplyingDividedByMetricAndUSCustomarySelfFlipped")
infix fun <
	NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericReciprocalMultiplyingDividedByGenericSelfFlipped")
infix fun <
	NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
	NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	DenominatorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity>,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.genericDividedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalRightAndDenominatorReciprocalLeftQuantity,
			NumeratorReciprocalLeftAndDenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}
