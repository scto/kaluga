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
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// Inv<Mul<A, B>> * Div<Mul<B, A>, C> -> Inv<C>

@JvmName("reciprocalMultiplyingMultipliedByDividingUnitWithSelfFlippedAsNumerator")
fun <
	LeftReciprocalLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightNumeratorRightQuantity>,
	LeftReciprocalRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftAndRightNumeratorRightQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightNumeratorRightQuantity>,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftReciprocalLeftAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	TargetUnit : UndefinedReciprocalUnit<
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		RightDenominatorQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			>,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
	reciprocalTargetUnit: RightDenominatorUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.denominator.reciprocalTargetUnit().byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultiplyingMultipliedByMetricAndImperialDividingUnitWithSelfFlippedAsNumerator")
infix fun <
	LeftReciprocalLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			>,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightNumeratorRightQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftAndRightNumeratorRightQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftReciprocalLeftAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndImperial<
							RightDenominatorQuantity,
							RightDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricReciprocalMultiplyingMultipliedByMetricDividingUnitWithSelfFlippedAsNumerator")
infix fun <
	LeftReciprocalLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			>,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightNumeratorRightQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftAndRightNumeratorRightQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftReciprocalLeftAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Metric<
							RightDenominatorQuantity,
							RightDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialReciprocalMultiplyingMultipliedByImperialDividingUnitWithSelfFlippedAsNumerator")
infix fun <
	LeftReciprocalLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			>,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightNumeratorRightQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftAndRightNumeratorRightQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftReciprocalLeftAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Imperial<
							RightDenominatorQuantity,
							RightDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalMultiplyingMultipliedByUKImperialDividingUnitWithSelfFlippedAsNumerator")
infix fun <
	LeftReciprocalLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			>,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightNumeratorRightQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftAndRightNumeratorRightQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftReciprocalLeftAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.UKImperial<
							RightDenominatorQuantity,
							RightDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalMultiplyingMultipliedByUSCustomaryDividingUnitWithSelfFlippedAsNumerator")
infix fun <
	LeftReciprocalLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			>,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightNumeratorRightQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftAndRightNumeratorRightQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftReciprocalLeftAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.USCustomary<
							RightDenominatorQuantity,
							RightDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalMultiplyingMultipliedByMetricAndUKImperialDividingUnitWithSelfFlippedAsNumerator")
infix fun <
	LeftReciprocalLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			>,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightNumeratorRightQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftAndRightNumeratorRightQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftReciprocalLeftAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUKImperial<
							RightDenominatorQuantity,
							RightDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalMultiplyingMultipliedByMetricAndUSCustomaryDividingUnitWithSelfFlippedAsNumerator")
infix fun <
	LeftReciprocalLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			>,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightNumeratorRightQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftAndRightNumeratorRightQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		LeftReciprocalLeftAndRightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			LeftReciprocalLeftAndRightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
							RightDenominatorQuantity,
							RightDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
