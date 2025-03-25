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
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.per
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Mul<A, B> * Div<C, Mul<D, B>> -> Div<Mul<A, C>, D>

@JvmName("multiplyingMultipliedByDividingUnitWithMultiplyingDenominatorWithRightAsRight")
fun <
	LeftLeftQuantity : UndefinedQuantityType,
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
	LeftRightAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorRightQuantity>,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftQuantity,
		LeftLeftUnit,
		LeftRightAndRightDenominatorRightQuantity,
		LeftRightUnit,
		>,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorRightQuantity>,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftRightAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftRightAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	TargetNumeratorUnit : UndefinedMultipliedUnit<
		LeftLeftQuantity,
		LeftLeftUnit,
		RightNumeratorQuantity,
		RightNumeratorUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftLeftQuantity,
			RightNumeratorQuantity,
			>,
		TargetNumeratorUnit,
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftLeftQuantity,
			RightNumeratorQuantity,
			>,
		RightDenominatorLeftQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftQuantity,
		LeftRightAndRightDenominatorRightQuantity,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftRightAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
	leftLeftUnitXRightNumeratorUnit: LeftLeftUnit.(RightNumeratorUnit) -> TargetNumeratorUnit,
	targetNumeratorUnitPerRightDenominatorLeftUnit: TargetNumeratorUnit.(RightDenominatorLeftUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.left.leftLeftUnitXRightNumeratorUnit(
	right.unit.numerator,
).targetNumeratorUnitPerRightDenominatorLeftUnit(
	right.unit.denominator.left,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultiplyingMultipliedByMetricAndImperialDividingUnitWithMultiplyingDenominatorWithRightAsRight")
infix fun <
	LeftLeftQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftQuantity,
		LeftRightAndRightDenominatorRightQuantity,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftRightAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftQuantity,
		LeftLeftUnit,
		LeftRightAndRightDenominatorRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftRightAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftRightAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftLeftUnitXRightNumeratorUnit = { x(it) },
		targetNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				UndefinedQuantityType.Multiplying<
					LeftLeftQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndImperial<
				LeftLeftQuantity,
					LeftLeftUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricMultiplyingMultipliedByMetricDividingUnitWithMultiplyingDenominatorWithRightAsRight")
infix fun <
	LeftLeftQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftQuantity,
		LeftRightAndRightDenominatorRightQuantity,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftRightAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftQuantity,
		LeftLeftUnit,
		LeftRightAndRightDenominatorRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftRightAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftRightAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		leftLeftUnitXRightNumeratorUnit = { x(it) },
		targetNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				UndefinedQuantityType.Multiplying<
					LeftLeftQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.Metric<
				LeftLeftQuantity,
					LeftLeftUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialMultiplyingMultipliedByImperialDividingUnitWithMultiplyingDenominatorWithRightAsRight")
infix fun <
	LeftLeftQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftQuantity,
		LeftRightAndRightDenominatorRightQuantity,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftRightAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftQuantity,
		LeftLeftUnit,
		LeftRightAndRightDenominatorRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftRightAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftRightAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftLeftUnitXRightNumeratorUnit = { x(it) },
		targetNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				UndefinedQuantityType.Multiplying<
					LeftLeftQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.Imperial<
				LeftLeftQuantity,
					LeftLeftUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialMultiplyingMultipliedByUKImperialDividingUnitWithMultiplyingDenominatorWithRightAsRight")
infix fun <
	LeftLeftQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftQuantity,
		LeftRightAndRightDenominatorRightQuantity,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftRightAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftQuantity,
		LeftLeftUnit,
		LeftRightAndRightDenominatorRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftRightAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftRightAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftLeftUnitXRightNumeratorUnit = { x(it) },
		targetNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				UndefinedQuantityType.Multiplying<
					LeftLeftQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.UKImperial<
				LeftLeftQuantity,
					LeftLeftUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryMultiplyingMultipliedByUSCustomaryDividingUnitWithMultiplyingDenominatorWithRightAsRight")
infix fun <
	LeftLeftQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftQuantity,
		LeftRightAndRightDenominatorRightQuantity,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftRightAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftQuantity,
		LeftLeftUnit,
		LeftRightAndRightDenominatorRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftRightAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftRightAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftLeftUnitXRightNumeratorUnit = { x(it) },
		targetNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				UndefinedQuantityType.Multiplying<
					LeftLeftQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.USCustomary<
				LeftLeftQuantity,
					LeftLeftUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultiplyingMultipliedByMetricAndUKImperialDividingUnitWithMultiplyingDenominatorWithRightAsRight")
infix fun <
	LeftLeftQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftQuantity,
		LeftRightAndRightDenominatorRightQuantity,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftRightAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftQuantity,
		LeftLeftUnit,
		LeftRightAndRightDenominatorRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftRightAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftRightAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftLeftUnitXRightNumeratorUnit = { x(it) },
		targetNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				UndefinedQuantityType.Multiplying<
					LeftLeftQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUKImperial<
				LeftLeftQuantity,
					LeftLeftUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultiplyingMultipliedByMetricAndUSCustomaryDividingUnitWithMultiplyingDenominatorWithRightAsRight")
infix fun <
	LeftLeftQuantity : UndefinedQuantityType,
	LeftLeftUnit,
	LeftRightAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftRightUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorLeftQuantity : UndefinedQuantityType,
	RightDenominatorLeftUnit,
	RightDenominatorRightUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftLeftQuantity,
		LeftRightAndRightDenominatorRightQuantity,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftRightAndRightDenominatorRightQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftLeftUnit : AbstractUndefinedScientificUnit<LeftLeftQuantity>,
	LeftLeftUnit : MeasurementUsage.UsedInMetric,
	LeftLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorRightQuantity>,
	LeftRightUnit : MeasurementUsage.UsedInMetric,
	LeftRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedMultipliedUnit<
		LeftLeftQuantity,
		LeftLeftUnit,
		LeftRightAndRightDenominatorRightQuantity,
		LeftRightUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorLeftUnit : AbstractUndefinedScientificUnit<RightDenominatorLeftQuantity>,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftRightAndRightDenominatorRightQuantity>,
	RightDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedMultipliedUnit<
		RightDenominatorLeftQuantity,
		RightDenominatorLeftUnit,
		LeftRightAndRightDenominatorRightQuantity,
		RightDenominatorRightUnit,
		>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			RightDenominatorLeftQuantity,
			LeftRightAndRightDenominatorRightQuantity,
			>,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftLeftUnitXRightNumeratorUnit = { x(it) },
		targetNumeratorUnitPerRightDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				UndefinedQuantityType.Multiplying<
					LeftLeftQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUSCustomary<
				LeftLeftQuantity,
					LeftLeftUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				RightDenominatorLeftQuantity,
				RightDenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
