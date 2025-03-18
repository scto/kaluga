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
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// A / Mul<A, A> -> Inv<A>

@JvmName("dividedByMultiplyingUnitWithSelfAsLeftAndSelfAsRight")
fun <
	NumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		NumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		>,
	TargetUnit : UndefinedReciprocalUnit<
		NumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorAndDenominatorLeftAndRightQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	NumeratorAndDenominatorLeftAndRightQuantity,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
	reciprocalTargetUnit: NumeratorUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.reciprocalTargetUnit().byDividing(this, right, factory)

@JvmName("metricAndImperialDividedByMetricAndImperialMultiplyingUnitWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorLeftAndRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorLeftAndRightQuantity,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		NumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndImperial<
							NumeratorAndDenominatorLeftAndRightQuantity,
							NumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDividedByMetricMultiplyingUnitWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorLeftAndRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorLeftAndRightQuantity,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		NumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Metric<
							NumeratorAndDenominatorLeftAndRightQuantity,
							NumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDividedByImperialMultiplyingUnitWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorLeftAndRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorLeftAndRightQuantity,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		NumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Imperial<
							NumeratorAndDenominatorLeftAndRightQuantity,
							NumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDividedByUKImperialMultiplyingUnitWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorLeftAndRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorLeftAndRightQuantity,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		NumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.UKImperial<
							NumeratorAndDenominatorLeftAndRightQuantity,
							NumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDividedByUSCustomaryMultiplyingUnitWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorLeftAndRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorLeftAndRightQuantity,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		NumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.USCustomary<
							NumeratorAndDenominatorLeftAndRightQuantity,
							NumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividedByMetricAndUKImperialMultiplyingUnitWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorLeftAndRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorLeftAndRightQuantity,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		NumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUKImperial<
							NumeratorAndDenominatorLeftAndRightQuantity,
							NumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividedByMetricAndUSCustomaryMultiplyingUnitWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorLeftAndRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorLeftAndRightQuantity,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		NumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
							NumeratorAndDenominatorLeftAndRightQuantity,
							NumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
