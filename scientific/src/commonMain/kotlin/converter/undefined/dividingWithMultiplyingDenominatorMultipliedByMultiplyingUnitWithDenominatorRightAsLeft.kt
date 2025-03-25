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

// Div<A, Mul<B, C>> * Mul<C, D> -> Div<Mul<A, D>, B>

@JvmName("dividingWithMultiplyingDenominatorMultipliedByMultiplyingUnitWithDenominatorRightAsLeft")
fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightLeftQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightLeftQuantity,
			>,
		LeftDenominatorUnit,
		>,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightUnit : UndefinedMultipliedUnit<
		LeftDenominatorRightAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	TargetNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorQuantity,
			RightRightQuantity,
			>,
		TargetNumeratorUnit,
		LeftDenominatorLeftQuantity,
		LeftDenominatorLeftUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorQuantity,
			RightRightQuantity,
			>,
		LeftDenominatorLeftQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightLeftQuantity,
			>,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftDenominatorRightAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
	leftNumeratorUnitXRightRightUnit: LeftNumeratorUnit.(RightRightUnit) -> TargetNumeratorUnit,
	targetNumeratorUnitPerLeftDenominatorLeftUnit: TargetNumeratorUnit.(LeftDenominatorLeftUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.leftNumeratorUnitXRightRightUnit(
	right.unit.right,
).targetNumeratorUnitPerLeftDenominatorLeftUnit(
	unit.denominator.left,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingDenominatorMultipliedByMetricAndImperialMultiplyingUnitWithDenominatorRightAsLeft")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightLeftQuantity,
			>,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftDenominatorRightAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightLeftQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightLeftQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		LeftDenominatorRightAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftNumeratorUnitXRightRightUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightRightQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndImperial<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightRightQuantity,
					RightRightUnit,
					>,
				LeftDenominatorLeftQuantity,
				LeftDenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingWithMultiplyingDenominatorMultipliedByMetricMultiplyingUnitWithDenominatorRightAsLeft")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightLeftQuantity,
			>,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftDenominatorRightAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightLeftQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightLeftQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedMultipliedUnit<
		LeftDenominatorRightAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		leftNumeratorUnitXRightRightUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightRightQuantity,
					>,
				UndefinedMultipliedUnit.Metric<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightRightQuantity,
					RightRightUnit,
					>,
				LeftDenominatorLeftQuantity,
				LeftDenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingWithMultiplyingDenominatorMultipliedByImperialMultiplyingUnitWithDenominatorRightAsLeft")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightLeftQuantity,
			>,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftDenominatorRightAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightLeftQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightLeftQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		LeftDenominatorRightAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftNumeratorUnitXRightRightUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightRightQuantity,
					>,
				UndefinedMultipliedUnit.Imperial<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightRightQuantity,
					RightRightUnit,
					>,
				LeftDenominatorLeftQuantity,
				LeftDenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithMultiplyingDenominatorMultipliedByUKImperialMultiplyingUnitWithDenominatorRightAsLeft")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightLeftQuantity,
			>,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftDenominatorRightAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightLeftQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightLeftQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedMultipliedUnit<
		LeftDenominatorRightAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftNumeratorUnitXRightRightUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightRightQuantity,
					>,
				UndefinedMultipliedUnit.UKImperial<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightRightQuantity,
					RightRightUnit,
					>,
				LeftDenominatorLeftQuantity,
				LeftDenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithMultiplyingDenominatorMultipliedByUSCustomaryMultiplyingUnitWithDenominatorRightAsLeft")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightLeftQuantity,
			>,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftDenominatorRightAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightLeftQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightLeftQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		LeftDenominatorRightAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftNumeratorUnitXRightRightUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightRightQuantity,
					>,
				UndefinedMultipliedUnit.USCustomary<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightRightQuantity,
					RightRightUnit,
					>,
				LeftDenominatorLeftQuantity,
				LeftDenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithMultiplyingDenominatorMultipliedByMetricAndUKImperialMultiplyingUnitWithDenominatorRightAsLeft")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightLeftQuantity,
			>,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftDenominatorRightAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightLeftQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightLeftQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedMultipliedUnit<
		LeftDenominatorRightAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftNumeratorUnitXRightRightUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightRightQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUKImperial<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightRightQuantity,
					RightRightUnit,
					>,
				LeftDenominatorLeftQuantity,
				LeftDenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithMultiplyingDenominatorMultipliedByMetricAndUSCustomaryMultiplyingUnitWithDenominatorRightAsLeft")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftUnit,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightLeftQuantity,
			>,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftDenominatorRightAndRightLeftQuantity,
		RightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightAndRightLeftQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftQuantity,
			LeftDenominatorRightAndRightLeftQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<RightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		LeftDenominatorRightAndRightLeftQuantity,
		RightLeftUnit,
		RightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftNumeratorUnitXRightRightUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightRightQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUSCustomary<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightRightQuantity,
					RightRightUnit,
					>,
				LeftDenominatorLeftQuantity,
				LeftDenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
