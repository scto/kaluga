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

// Div<A, Mul<B, C>> * Mul<D, B> -> Div<Mul<A, D>, C>

@JvmName("dividingWithMultiplyingDenominatorMultipliedByMultiplyingUnitWithDenominatorLeftAsRight")
fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftDenominatorLeftAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
	LeftDenominatorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightQuantity>,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftAndRightRightQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightRightQuantity,
			LeftDenominatorRightQuantity,
			>,
		LeftDenominatorUnit,
		>,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftDenominatorLeftAndRightRightQuantity,
		RightRightUnit,
		>,
	TargetNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		RightLeftQuantity,
		RightLeftUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorQuantity,
			RightLeftQuantity,
			>,
		TargetNumeratorUnit,
		LeftDenominatorRightQuantity,
		LeftDenominatorRightUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorQuantity,
			RightLeftQuantity,
			>,
		LeftDenominatorRightQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightRightQuantity,
			LeftDenominatorRightQuantity,
			>,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftDenominatorLeftAndRightRightQuantity,
		>,
RightUnit,
	>,
	leftNumeratorUnitXRightLeftUnit: LeftNumeratorUnit.(RightLeftUnit) -> TargetNumeratorUnit,
	targetNumeratorUnitPerLeftDenominatorRightUnit: TargetNumeratorUnit.(LeftDenominatorRightUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.leftNumeratorUnitXRightLeftUnit(
	right.unit.left,
).targetNumeratorUnitPerLeftDenominatorRightUnit(
	unit.denominator.right,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingDenominatorMultipliedByMetricAndImperialMultiplyingUnitWithDenominatorLeftAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightRightQuantity,
			LeftDenominatorRightQuantity,
			>,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftDenominatorLeftAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftAndRightRightQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightRightQuantity,
			LeftDenominatorRightQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftDenominatorLeftAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightLeftQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndImperial<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightLeftQuantity,
					RightLeftUnit,
					>,
				LeftDenominatorRightQuantity,
				LeftDenominatorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingWithMultiplyingDenominatorMultipliedByMetricMultiplyingUnitWithDenominatorLeftAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightRightQuantity,
			LeftDenominatorRightQuantity,
			>,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftDenominatorLeftAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftAndRightRightQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightRightQuantity,
			LeftDenominatorRightQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftDenominatorLeftAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightLeftQuantity,
					>,
				UndefinedMultipliedUnit.Metric<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightLeftQuantity,
					RightLeftUnit,
					>,
				LeftDenominatorRightQuantity,
				LeftDenominatorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingWithMultiplyingDenominatorMultipliedByImperialMultiplyingUnitWithDenominatorLeftAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightRightQuantity,
			LeftDenominatorRightQuantity,
			>,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftDenominatorLeftAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftAndRightRightQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightRightQuantity,
			LeftDenominatorRightQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftDenominatorLeftAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightLeftQuantity,
					>,
				UndefinedMultipliedUnit.Imperial<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightLeftQuantity,
					RightLeftUnit,
					>,
				LeftDenominatorRightQuantity,
				LeftDenominatorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithMultiplyingDenominatorMultipliedByUKImperialMultiplyingUnitWithDenominatorLeftAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightRightQuantity,
			LeftDenominatorRightQuantity,
			>,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftDenominatorLeftAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftAndRightRightQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightRightQuantity,
			LeftDenominatorRightQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftDenominatorLeftAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightLeftQuantity,
					>,
				UndefinedMultipliedUnit.UKImperial<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightLeftQuantity,
					RightLeftUnit,
					>,
				LeftDenominatorRightQuantity,
				LeftDenominatorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithMultiplyingDenominatorMultipliedByUSCustomaryMultiplyingUnitWithDenominatorLeftAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightRightQuantity,
			LeftDenominatorRightQuantity,
			>,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftDenominatorLeftAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftAndRightRightQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightRightQuantity,
			LeftDenominatorRightQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftDenominatorLeftAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightLeftQuantity,
					>,
				UndefinedMultipliedUnit.USCustomary<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightLeftQuantity,
					RightLeftUnit,
					>,
				LeftDenominatorRightQuantity,
				LeftDenominatorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithMultiplyingDenominatorMultipliedByMetricAndUKImperialMultiplyingUnitWithDenominatorLeftAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightRightQuantity,
			LeftDenominatorRightQuantity,
			>,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftDenominatorLeftAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftAndRightRightQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightRightQuantity,
			LeftDenominatorRightQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftDenominatorLeftAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightLeftQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUKImperial<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightLeftQuantity,
					RightLeftUnit,
					>,
				LeftDenominatorRightQuantity,
				LeftDenominatorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithMultiplyingDenominatorMultipliedByMetricAndUSCustomaryMultiplyingUnitWithDenominatorLeftAsRight")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorLeftAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorLeftUnit,
	LeftDenominatorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit,
	LeftDenominatorUnit,
	LeftUnit,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit,
	RightRightUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightRightQuantity,
			LeftDenominatorRightQuantity,
			>,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		RightLeftQuantity,
		LeftDenominatorLeftAndRightRightQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorLeftUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorRightQuantity>,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorLeftAndRightRightQuantity,
		LeftDenominatorLeftUnit,
		LeftDenominatorRightQuantity,
		LeftDenominatorRightUnit,
		>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorLeftAndRightRightQuantity,
			LeftDenominatorRightQuantity,
			>,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightLeftUnit : AbstractUndefinedScientificUnit<RightLeftQuantity>,
	RightLeftUnit : MeasurementUsage.UsedInMetric,
	RightLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightRightUnit : AbstractUndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
	RightRightUnit : MeasurementUsage.UsedInMetric,
	RightRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedMultipliedUnit<
		RightLeftQuantity,
		RightLeftUnit,
		LeftDenominatorLeftAndRightRightQuantity,
		RightRightUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftNumeratorUnitXRightLeftUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightLeftQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUSCustomary<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightLeftQuantity,
					RightLeftUnit,
					>,
				LeftDenominatorRightQuantity,
				LeftDenominatorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
