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
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Div<Mul<B, C>, D> * Div<A, B> -> Div<Mul<C, A>, D>

@JvmName("dividingWithMultiplyingNumeratorMultipliedByDividingUnitWithNumeratorLeftAsDenominator")
fun <
	LeftNumeratorLeftAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
	LeftNumeratorRightQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftAndRightDenominatorQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorQuantity,
			LeftNumeratorRightQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftNumeratorLeftAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	TargetNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorRightQuantity,
		LeftNumeratorRightUnit,
		RightNumeratorQuantity,
		RightNumeratorUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightQuantity,
			RightNumeratorQuantity,
			>,
		TargetNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorRightQuantity,
			RightNumeratorQuantity,
			>,
		LeftDenominatorQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorQuantity,
			LeftNumeratorRightQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftNumeratorLeftAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
	leftNumeratorRightUnitXRightNumeratorUnit: LeftNumeratorRightUnit.(RightNumeratorUnit) -> TargetNumeratorUnit,
	targetNumeratorUnitPerLeftDenominatorUnit: TargetNumeratorUnit.(LeftDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.right.leftNumeratorRightUnitXRightNumeratorUnit(
	right.unit.numerator,
).targetNumeratorUnitPerLeftDenominatorUnit(
	unit.denominator,
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingNumeratorMultipliedByMetricAndImperialDividingUnitWithNumeratorLeftAsDenominator")
infix fun <
	LeftNumeratorLeftAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorQuantity,
			LeftNumeratorRightQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftNumeratorLeftAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftAndRightDenominatorQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorQuantity,
			LeftNumeratorRightQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftNumeratorLeftAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftNumeratorRightUnitXRightNumeratorUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorRightQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndImperial<
				LeftNumeratorRightQuantity,
					LeftNumeratorRightUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				LeftDenominatorQuantity,
				LeftDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDividingWithMultiplyingNumeratorMultipliedByMetricDividingUnitWithNumeratorLeftAsDenominator")
infix fun <
	LeftNumeratorLeftAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorQuantity,
			LeftNumeratorRightQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftNumeratorLeftAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftAndRightDenominatorQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorQuantity,
			LeftNumeratorRightQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftNumeratorLeftAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		leftNumeratorRightUnitXRightNumeratorUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorRightQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.Metric<
				LeftNumeratorRightQuantity,
					LeftNumeratorRightUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				LeftDenominatorQuantity,
				LeftDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDividingWithMultiplyingNumeratorMultipliedByImperialDividingUnitWithNumeratorLeftAsDenominator")
infix fun <
	LeftNumeratorLeftAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorQuantity,
			LeftNumeratorRightQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftNumeratorLeftAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftAndRightDenominatorQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorQuantity,
			LeftNumeratorRightQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftNumeratorLeftAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftNumeratorRightUnitXRightNumeratorUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorRightQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.Imperial<
				LeftNumeratorRightQuantity,
					LeftNumeratorRightUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				LeftDenominatorQuantity,
				LeftDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithMultiplyingNumeratorMultipliedByUKImperialDividingUnitWithNumeratorLeftAsDenominator")
infix fun <
	LeftNumeratorLeftAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorQuantity,
			LeftNumeratorRightQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftNumeratorLeftAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftAndRightDenominatorQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorQuantity,
			LeftNumeratorRightQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftNumeratorLeftAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftNumeratorRightUnitXRightNumeratorUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorRightQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.UKImperial<
				LeftNumeratorRightQuantity,
					LeftNumeratorRightUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				LeftDenominatorQuantity,
				LeftDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithMultiplyingNumeratorMultipliedByUSCustomaryDividingUnitWithNumeratorLeftAsDenominator")
infix fun <
	LeftNumeratorLeftAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorQuantity,
			LeftNumeratorRightQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftNumeratorLeftAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftAndRightDenominatorQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorQuantity,
			LeftNumeratorRightQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftNumeratorLeftAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftNumeratorRightUnitXRightNumeratorUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorRightQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.USCustomary<
				LeftNumeratorRightQuantity,
					LeftNumeratorRightUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				LeftDenominatorQuantity,
				LeftDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithMultiplyingNumeratorMultipliedByMetricAndUKImperialDividingUnitWithNumeratorLeftAsDenominator")
infix fun <
	LeftNumeratorLeftAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorQuantity,
			LeftNumeratorRightQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftNumeratorLeftAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftAndRightDenominatorQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorQuantity,
			LeftNumeratorRightQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftNumeratorLeftAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftNumeratorRightUnitXRightNumeratorUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorRightQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUKImperial<
				LeftNumeratorRightQuantity,
					LeftNumeratorRightUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				LeftDenominatorQuantity,
				LeftDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithMultiplyingNumeratorMultipliedByMetricAndUSCustomaryDividingUnitWithNumeratorLeftAsDenominator")
infix fun <
	LeftNumeratorLeftAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit,
	LeftNumeratorRightQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorQuantity,
			LeftNumeratorRightQuantity,
			>,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		LeftNumeratorLeftAndRightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorLeftAndRightDenominatorQuantity,
		LeftNumeratorLeftUnit,
		LeftNumeratorRightQuantity,
		LeftNumeratorRightUnit,
		>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorLeftAndRightDenominatorQuantity,
			LeftNumeratorRightQuantity,
			>,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		LeftNumeratorLeftAndRightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftNumeratorRightUnitXRightNumeratorUnit = { x(it) },
		targetNumeratorUnitPerLeftDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorRightQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUSCustomary<
				LeftNumeratorRightQuantity,
					LeftNumeratorRightUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				LeftDenominatorQuantity,
				LeftDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
