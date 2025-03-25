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
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// Inv<A> * Div<A, B> -> Inv<B>

@JvmName("reciprocalMultipliedByDividingUnitWithSelfAsNumerator")
fun <
	LeftReciprocalAndRightNumeratorQuantity : UndefinedQuantityType,
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightNumeratorQuantity>,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightNumeratorQuantity,
		LeftReciprocalUnit,
		>,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightNumeratorQuantity>,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
	RightUnit : UndefinedDividedUnit<
		LeftReciprocalAndRightNumeratorQuantity,
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
		LeftReciprocalAndRightNumeratorQuantity,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftReciprocalAndRightNumeratorQuantity,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
	reciprocalTargetUnit: RightDenominatorUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.denominator.reciprocalTargetUnit().byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalMultipliedByMetricAndImperialDividingUnitWithSelfAsNumerator")
infix fun <
	LeftReciprocalAndRightNumeratorQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightNumeratorQuantity,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftReciprocalAndRightNumeratorQuantity,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightNumeratorQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightNumeratorQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		LeftReciprocalAndRightNumeratorQuantity,
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
		DefaultScientificValue(value, unit)
	}

@JvmName("metricReciprocalMultipliedByMetricDividingUnitWithSelfAsNumerator")
infix fun <
	LeftReciprocalAndRightNumeratorQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightNumeratorQuantity,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftReciprocalAndRightNumeratorQuantity,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightNumeratorQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightNumeratorQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedDividedUnit<
		LeftReciprocalAndRightNumeratorQuantity,
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
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialReciprocalMultipliedByImperialDividingUnitWithSelfAsNumerator")
infix fun <
	LeftReciprocalAndRightNumeratorQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightNumeratorQuantity,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftReciprocalAndRightNumeratorQuantity,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightNumeratorQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightNumeratorQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		LeftReciprocalAndRightNumeratorQuantity,
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
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalMultipliedByUKImperialDividingUnitWithSelfAsNumerator")
infix fun <
	LeftReciprocalAndRightNumeratorQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightNumeratorQuantity,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftReciprocalAndRightNumeratorQuantity,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightNumeratorQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightNumeratorQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		LeftReciprocalAndRightNumeratorQuantity,
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
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalMultipliedByUSCustomaryDividingUnitWithSelfAsNumerator")
infix fun <
	LeftReciprocalAndRightNumeratorQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightNumeratorQuantity,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftReciprocalAndRightNumeratorQuantity,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightNumeratorQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightNumeratorQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		LeftReciprocalAndRightNumeratorQuantity,
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
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalMultipliedByMetricAndUKImperialDividingUnitWithSelfAsNumerator")
infix fun <
	LeftReciprocalAndRightNumeratorQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightNumeratorQuantity,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftReciprocalAndRightNumeratorQuantity,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightNumeratorQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightNumeratorQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		LeftReciprocalAndRightNumeratorQuantity,
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
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalMultipliedByMetricAndUSCustomaryDividingUnitWithSelfAsNumerator")
infix fun <
	LeftReciprocalAndRightNumeratorQuantity : UndefinedQuantityType,
	LeftReciprocalUnit,
	LeftUnit,
	RightNumeratorUnit,
	RightDenominatorQuantity : UndefinedQuantityType,
	RightDenominatorUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		LeftReciprocalAndRightNumeratorQuantity,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		LeftReciprocalAndRightNumeratorQuantity,
		RightDenominatorQuantity,
		>,
RightUnit,
	>,
) where
	LeftReciprocalUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightNumeratorQuantity>,
	LeftReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<
		LeftReciprocalAndRightNumeratorQuantity,
		LeftReciprocalUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : AbstractUndefinedScientificUnit<LeftReciprocalAndRightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : AbstractUndefinedScientificUnit<RightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		LeftReciprocalAndRightNumeratorQuantity,
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
		DefaultScientificValue(value, unit)
	}
