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
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Div<A, B> / Mul<A, A> -> Inv<Mul<B, A>>

@JvmName("dividingDividedByMultiplyingUnitWithNumeratorAsLeftAndNumeratorAsRight")
fun <
	NumeratorNumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		>,
	TargetReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorUnit,
		>,
	TargetUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorQuantity,
			NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
			>,
		TargetReciprocalUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorQuantity,
			NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
			>,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
	numeratorDenominatorUnitXNumeratorNumeratorUnit: NumeratorDenominatorUnit.(NumeratorNumeratorUnit) -> TargetReciprocalUnit,
	reciprocalTargetUnit: TargetReciprocalUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.denominator.numeratorDenominatorUnitXNumeratorNumeratorUnit(
	unit.numerator,
).reciprocalTargetUnit().byDividing(this, right, factory)

@JvmName("metricAndImperialDividingDividedByMetricAndImperialMultiplyingUnitWithNumeratorAsLeftAndNumeratorAsRight")
infix fun <
	NumeratorNumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftAndRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorDenominatorUnitXNumeratorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndImperial<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndImperial<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorNumeratorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDividingDividedByMetricMultiplyingUnitWithNumeratorAsLeftAndNumeratorAsRight")
infix fun <
	NumeratorNumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftAndRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		numeratorDenominatorUnitXNumeratorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Metric<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					>,
							UndefinedMultipliedUnit.Metric<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorNumeratorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDividingDividedByImperialMultiplyingUnitWithNumeratorAsLeftAndNumeratorAsRight")
infix fun <
	NumeratorNumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftAndRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorDenominatorUnitXNumeratorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Imperial<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					>,
							UndefinedMultipliedUnit.Imperial<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorNumeratorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDividingDividedByUKImperialMultiplyingUnitWithNumeratorAsLeftAndNumeratorAsRight")
infix fun <
	NumeratorNumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftAndRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorDenominatorUnitXNumeratorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.UKImperial<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					>,
							UndefinedMultipliedUnit.UKImperial<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorNumeratorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingDividedByUSCustomaryMultiplyingUnitWithNumeratorAsLeftAndNumeratorAsRight")
infix fun <
	NumeratorNumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftAndRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorDenominatorUnitXNumeratorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.USCustomary<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					>,
							UndefinedMultipliedUnit.USCustomary<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorNumeratorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingDividedByMetricAndUKImperialMultiplyingUnitWithNumeratorAsLeftAndNumeratorAsRight")
infix fun <
	NumeratorNumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftAndRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorDenominatorUnitXNumeratorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUKImperial<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndUKImperial<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorNumeratorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingDividedByMetricAndUSCustomaryMultiplyingUnitWithNumeratorAsLeftAndNumeratorAsRight")
infix fun <
	NumeratorNumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftAndRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftAndRightUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftAndRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorDenominatorUnitXNumeratorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndUSCustomary<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorNumeratorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
