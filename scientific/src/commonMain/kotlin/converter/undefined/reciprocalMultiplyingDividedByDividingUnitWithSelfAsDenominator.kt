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
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// Inv<Mul<A, A>> / Div<B, Mul<A, A>> -> Inv<B>

@JvmName("reciprocalMultiplyingDividedByDividingUnitWithSelfAsDenominator")
fun <
	NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalLeftAndRightUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalLeftAndRightUnit,
		>,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorDenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftAndRightUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftAndRightUnit,
		>,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	TargetUnit : UndefinedReciprocalUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		DenominatorNumeratorQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
	reciprocalTargetUnit: DenominatorNumeratorUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.numerator.reciprocalTargetUnit().byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalMultiplyingDividedByMetricAndImperialDividingUnitWithSelfAsDenominator")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftAndRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftAndRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalLeftAndRightUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalLeftAndRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftAndRightUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftAndRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
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
							DenominatorNumeratorQuantity,
							DenominatorNumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricReciprocalMultiplyingDividedByMetricDividingUnitWithSelfAsDenominator")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftAndRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftAndRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalLeftAndRightUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalLeftAndRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftAndRightUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftAndRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Metric<
							DenominatorNumeratorQuantity,
							DenominatorNumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialReciprocalMultiplyingDividedByImperialDividingUnitWithSelfAsDenominator")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftAndRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftAndRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalLeftAndRightUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalLeftAndRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftAndRightUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftAndRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Imperial<
							DenominatorNumeratorQuantity,
							DenominatorNumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalMultiplyingDividedByUKImperialDividingUnitWithSelfAsDenominator")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftAndRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftAndRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalLeftAndRightUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalLeftAndRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftAndRightUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftAndRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.UKImperial<
							DenominatorNumeratorQuantity,
							DenominatorNumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalMultiplyingDividedByUSCustomaryDividingUnitWithSelfAsDenominator")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftAndRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftAndRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalLeftAndRightUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalLeftAndRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftAndRightUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftAndRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.USCustomary<
							DenominatorNumeratorQuantity,
							DenominatorNumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalMultiplyingDividedByMetricAndUKImperialDividingUnitWithSelfAsDenominator")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftAndRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftAndRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalLeftAndRightUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalLeftAndRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftAndRightUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftAndRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUKImperial<
							DenominatorNumeratorQuantity,
							DenominatorNumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalMultiplyingDividedByMetricAndUSCustomaryDividingUnitWithSelfAsDenominator")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftAndRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftAndRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalLeftAndRightUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalLeftAndRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftAndRightUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftAndRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
							DenominatorNumeratorQuantity,
							DenominatorNumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
