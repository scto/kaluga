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

// Div<A, B> * Div<C, D> -> Div<Mul<A, C>, Mul<B, D>>

@JvmName("dividingMultipliedByDividingUnit")
fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	TargetNumeratorUnit : UndefinedMultipliedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		RightNumeratorQuantity,
		RightNumeratorUnit,
		>,
	TargetDenominatorUnit : UndefinedMultipliedUnit<
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorQuantity,
			RightNumeratorQuantity,
			>,
		TargetNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorQuantity,
			RightDenominatorQuantity,
			>,
		TargetDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			LeftNumeratorQuantity,
			RightNumeratorQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			LeftDenominatorQuantity,
			RightDenominatorQuantity,
			>,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
	leftNumeratorUnitXRightNumeratorUnit: LeftNumeratorUnit.(RightNumeratorUnit) -> TargetNumeratorUnit,
	leftDenominatorUnitXRightDenominatorUnit: LeftDenominatorUnit.(RightDenominatorUnit) -> TargetDenominatorUnit,
	targetNumeratorUnitPerTargetDenominatorUnit: TargetNumeratorUnit.(TargetDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.leftNumeratorUnitXRightNumeratorUnit(
	right.unit.numerator,
).targetNumeratorUnitPerTargetDenominatorUnit(
	unit.denominator.leftDenominatorUnitXRightDenominatorUnit(
	right.unit.denominator,
),
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingMultipliedByMetricAndImperialDividingUnit")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftNumeratorUnitXRightNumeratorUnit = { x(it) },
		leftDenominatorUnitXRightDenominatorUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndImperial<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				UndefinedQuantityType.Multiplying<
					LeftDenominatorQuantity,
					RightDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndImperial<
				LeftDenominatorQuantity,
					LeftDenominatorUnit,
					RightDenominatorQuantity,
					RightDenominatorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingMultipliedByMetricDividingUnit")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		leftNumeratorUnitXRightNumeratorUnit = { x(it) },
		leftDenominatorUnitXRightDenominatorUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.Metric<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				UndefinedQuantityType.Multiplying<
					LeftDenominatorQuantity,
					RightDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.Metric<
				LeftDenominatorQuantity,
					LeftDenominatorUnit,
					RightDenominatorQuantity,
					RightDenominatorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingMultipliedByImperialDividingUnit")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftNumeratorUnitXRightNumeratorUnit = { x(it) },
		leftDenominatorUnitXRightDenominatorUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.Imperial<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				UndefinedQuantityType.Multiplying<
					LeftDenominatorQuantity,
					RightDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.Imperial<
				LeftDenominatorQuantity,
					LeftDenominatorUnit,
					RightDenominatorQuantity,
					RightDenominatorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingMultipliedByUKImperialDividingUnit")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftNumeratorUnitXRightNumeratorUnit = { x(it) },
		leftDenominatorUnitXRightDenominatorUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.UKImperial<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				UndefinedQuantityType.Multiplying<
					LeftDenominatorQuantity,
					RightDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.UKImperial<
				LeftDenominatorQuantity,
					LeftDenominatorUnit,
					RightDenominatorQuantity,
					RightDenominatorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingMultipliedByUSCustomaryDividingUnit")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftNumeratorUnitXRightNumeratorUnit = { x(it) },
		leftDenominatorUnitXRightDenominatorUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.USCustomary<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				UndefinedQuantityType.Multiplying<
					LeftDenominatorQuantity,
					RightDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.USCustomary<
				LeftDenominatorQuantity,
					LeftDenominatorUnit,
					RightDenominatorQuantity,
					RightDenominatorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingMultipliedByMetricAndUKImperialDividingUnit")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftNumeratorUnitXRightNumeratorUnit = { x(it) },
		leftDenominatorUnitXRightDenominatorUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUKImperial<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				UndefinedQuantityType.Multiplying<
					LeftDenominatorQuantity,
					RightDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUKImperial<
				LeftDenominatorQuantity,
					LeftDenominatorUnit,
					RightDenominatorQuantity,
					RightDenominatorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingMultipliedByMetricAndUSCustomaryDividingUnit")
infix fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftNumeratorQuantity,
		LeftDenominatorQuantity,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractUndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : AbstractUndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		LeftNumeratorQuantity,
		LeftNumeratorUnit,
		LeftDenominatorQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		RightDenominatorQuantity,
		RightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftNumeratorUnitXRightNumeratorUnit = { x(it) },
		leftDenominatorUnitXRightDenominatorUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				UndefinedQuantityType.Multiplying<
					LeftNumeratorQuantity,
					RightNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUSCustomary<
				LeftNumeratorQuantity,
					LeftNumeratorUnit,
					RightNumeratorQuantity,
					RightNumeratorUnit,
					>,
				UndefinedQuantityType.Multiplying<
					LeftDenominatorQuantity,
					RightDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUSCustomary<
				LeftDenominatorQuantity,
					LeftDenominatorUnit,
					RightDenominatorQuantity,
					RightDenominatorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}
