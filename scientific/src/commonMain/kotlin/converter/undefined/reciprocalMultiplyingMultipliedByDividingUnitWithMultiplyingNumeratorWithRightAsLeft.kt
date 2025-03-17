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
import com.splendo.kaluga.scientific.unit.per
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Inv<Mul<A, B>> * Div<Mul<B, C>, D> -> Div<C, Mul<A, D>>

@JvmName("reciprocalMultiplyingMultipliedByDividingUnitWithMultiplyingNumeratorWithRightAsLeft")
fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	RightNumeratorRightQuantity : UndefinedQuantityType,
	RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		RightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			RightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	TargetDenominatorUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		RightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			RightDenominatorQuantity,
			>,
		TargetDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorRightQuantity,
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			RightDenominatorQuantity,
			>,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			RightNumeratorRightQuantity,
			>,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
	leftReciprocalLeftUnitXRightDenominatorUnit: LeftReciprocalLeftUnit.(RightDenominatorUnit) -> TargetDenominatorUnit,
	rightNumeratorRightUnitPerTargetDenominatorUnit: RightNumeratorRightUnit.(TargetDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.numerator.right.rightNumeratorRightUnitPerTargetDenominatorUnit(
	unit.inverse.left.leftReciprocalLeftUnitXRightDenominatorUnit(
	right.unit.denominator,
),
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultiplyingMultipliedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithRightAsLeft")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightQuantity : UndefinedQuantityType,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			RightNumeratorRightQuantity,
			>,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
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
	RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		RightNumeratorRightQuantity,
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
			RightNumeratorRightQuantity,
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
		leftReciprocalLeftUnitXRightDenominatorUnit = { x(it) },
		rightNumeratorRightUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				RightNumeratorRightQuantity,
				RightNumeratorRightUnit,
				UndefinedQuantityType.Multiplying<
					LeftReciprocalLeftQuantity,
					RightDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndImperial<
				LeftReciprocalLeftQuantity,
					LeftReciprocalLeftUnit,
					RightDenominatorQuantity,
					RightDenominatorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricReciprocalMultiplyingMultipliedByMetricDividingUnitWithMultiplyingNumeratorWithRightAsLeft")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightQuantity : UndefinedQuantityType,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			RightNumeratorRightQuantity,
			>,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		RightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			RightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		leftReciprocalLeftUnitXRightDenominatorUnit = { x(it) },
		rightNumeratorRightUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				RightNumeratorRightQuantity,
				RightNumeratorRightUnit,
				UndefinedQuantityType.Multiplying<
					LeftReciprocalLeftQuantity,
					RightDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.Metric<
				LeftReciprocalLeftQuantity,
					LeftReciprocalLeftUnit,
					RightDenominatorQuantity,
					RightDenominatorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialReciprocalMultiplyingMultipliedByImperialDividingUnitWithMultiplyingNumeratorWithRightAsLeft")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightQuantity : UndefinedQuantityType,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			RightNumeratorRightQuantity,
			>,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		RightNumeratorRightQuantity,
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
			RightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftReciprocalLeftUnitXRightDenominatorUnit = { x(it) },
		rightNumeratorRightUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				RightNumeratorRightQuantity,
				RightNumeratorRightUnit,
				UndefinedQuantityType.Multiplying<
					LeftReciprocalLeftQuantity,
					RightDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.Imperial<
				LeftReciprocalLeftQuantity,
					LeftReciprocalLeftUnit,
					RightDenominatorQuantity,
					RightDenominatorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalMultiplyingMultipliedByUKImperialDividingUnitWithMultiplyingNumeratorWithRightAsLeft")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightQuantity : UndefinedQuantityType,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			RightNumeratorRightQuantity,
			>,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		RightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			RightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftReciprocalLeftUnitXRightDenominatorUnit = { x(it) },
		rightNumeratorRightUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				RightNumeratorRightQuantity,
				RightNumeratorRightUnit,
				UndefinedQuantityType.Multiplying<
					LeftReciprocalLeftQuantity,
					RightDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.UKImperial<
				LeftReciprocalLeftQuantity,
					LeftReciprocalLeftUnit,
					RightDenominatorQuantity,
					RightDenominatorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalMultiplyingMultipliedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithRightAsLeft")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightQuantity : UndefinedQuantityType,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			RightNumeratorRightQuantity,
			>,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		RightNumeratorRightQuantity,
		RightNumeratorRightUnit,
		>,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			RightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftReciprocalLeftUnitXRightDenominatorUnit = { x(it) },
		rightNumeratorRightUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				RightNumeratorRightQuantity,
				RightNumeratorRightUnit,
				UndefinedQuantityType.Multiplying<
					LeftReciprocalLeftQuantity,
					RightDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.USCustomary<
				LeftReciprocalLeftQuantity,
					LeftReciprocalLeftUnit,
					RightDenominatorQuantity,
					RightDenominatorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalMultiplyingMultipliedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithRightAsLeft")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightQuantity : UndefinedQuantityType,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			RightNumeratorRightQuantity,
			>,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		RightNumeratorRightQuantity,
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
			RightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftReciprocalLeftUnitXRightDenominatorUnit = { x(it) },
		rightNumeratorRightUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				RightNumeratorRightQuantity,
				RightNumeratorRightUnit,
				UndefinedQuantityType.Multiplying<
					LeftReciprocalLeftQuantity,
					RightDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUKImperial<
				LeftReciprocalLeftQuantity,
					LeftReciprocalLeftUnit,
					RightDenominatorQuantity,
					RightDenominatorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalMultiplyingMultipliedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithRightAsLeft")
infix fun <
	LeftReciprocalLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftUnit,
	LeftReciprocalRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorLeftUnit,
	RightNumeratorRightQuantity : UndefinedQuantityType,
	RightNumeratorRightUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			RightNumeratorRightQuantity,
			>,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftQuantity>,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftReciprocalUnit : UndefinedMultipliedUnit<
		LeftReciprocalLeftQuantity,
		LeftReciprocalLeftUnit,
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		LeftReciprocalRightUnit,
		>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			LeftReciprocalLeftQuantity,
			LeftReciprocalRightAndRightNumeratorLeftQuantity,
			>,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorLeftUnit : UndefinedScientificUnit<LeftReciprocalRightAndRightNumeratorLeftQuantity>,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorRightUnit : UndefinedScientificUnit<RightNumeratorRightQuantity>,
	RightNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedMultipliedUnit<
		LeftReciprocalRightAndRightNumeratorLeftQuantity,
		RightNumeratorLeftUnit,
		RightNumeratorRightQuantity,
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
			RightNumeratorRightQuantity,
			>,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftReciprocalLeftUnitXRightDenominatorUnit = { x(it) },
		rightNumeratorRightUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				RightNumeratorRightQuantity,
				RightNumeratorRightUnit,
				UndefinedQuantityType.Multiplying<
					LeftReciprocalLeftQuantity,
					RightDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUSCustomary<
				LeftReciprocalLeftQuantity,
					LeftReciprocalLeftUnit,
					RightDenominatorQuantity,
					RightDenominatorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
