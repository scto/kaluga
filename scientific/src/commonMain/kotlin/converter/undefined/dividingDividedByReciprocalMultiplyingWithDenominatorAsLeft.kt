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
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Div<A, B> / Inv<Mul<B, C>> -> Mul<A, C>

@JvmName("dividingDividedByReciprocalMultiplyingWithDenominatorAsLeft")
fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorDenominatorAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftQuantity>,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		NumeratorDenominatorUnit,
		>,
	DenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalRightQuantity : UndefinedQuantityType,
	DenominatorReciprocalRightUnit : UndefinedScientificUnit<DenominatorReciprocalRightQuantity>,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		DenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	TargetUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		DenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorNumeratorQuantity,
		DenominatorReciprocalRightQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
	numeratorNumeratorUnitXDenominatorReciprocalRightUnit: NumeratorNumeratorUnit.(DenominatorReciprocalRightUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.numeratorNumeratorUnitXDenominatorReciprocalRightUnit(
	right.unit.inverse.right,
).byDividing(this, right, factory)

@JvmName("metricAndImperialDividingDividedByMetricAndImperialReciprocalMultiplyingWithDenominatorAsLeft")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightQuantity : UndefinedQuantityType,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : UndefinedScientificUnit<DenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		DenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorUnitXDenominatorReciprocalRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndImperial<
			NumeratorNumeratorQuantity,
				NumeratorNumeratorUnit,
				DenominatorReciprocalRightQuantity,
				DenominatorReciprocalRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDividingDividedByMetricReciprocalMultiplyingWithDenominatorAsLeft")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightQuantity : UndefinedQuantityType,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : UndefinedScientificUnit<DenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		DenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		numeratorNumeratorUnitXDenominatorReciprocalRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.Metric<
			NumeratorNumeratorQuantity,
				NumeratorNumeratorUnit,
				DenominatorReciprocalRightQuantity,
				DenominatorReciprocalRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDividingDividedByImperialReciprocalMultiplyingWithDenominatorAsLeft")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightQuantity : UndefinedQuantityType,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : UndefinedScientificUnit<DenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		DenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorUnitXDenominatorReciprocalRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.Imperial<
			NumeratorNumeratorQuantity,
				NumeratorNumeratorUnit,
				DenominatorReciprocalRightQuantity,
				DenominatorReciprocalRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDividingDividedByUKImperialReciprocalMultiplyingWithDenominatorAsLeft")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightQuantity : UndefinedQuantityType,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : UndefinedScientificUnit<DenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		DenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorNumeratorUnitXDenominatorReciprocalRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.UKImperial<
			NumeratorNumeratorQuantity,
				NumeratorNumeratorUnit,
				DenominatorReciprocalRightQuantity,
				DenominatorReciprocalRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingDividedByUSCustomaryReciprocalMultiplyingWithDenominatorAsLeft")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightQuantity : UndefinedQuantityType,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : UndefinedScientificUnit<DenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		DenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorUnitXDenominatorReciprocalRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.USCustomary<
			NumeratorNumeratorQuantity,
				NumeratorNumeratorUnit,
				DenominatorReciprocalRightQuantity,
				DenominatorReciprocalRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingDividedByMetricAndUKImperialReciprocalMultiplyingWithDenominatorAsLeft")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightQuantity : UndefinedQuantityType,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalRightUnit : UndefinedScientificUnit<DenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		DenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorNumeratorUnitXDenominatorReciprocalRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndUKImperial<
			NumeratorNumeratorQuantity,
				NumeratorNumeratorUnit,
				DenominatorReciprocalRightQuantity,
				DenominatorReciprocalRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingDividedByMetricAndUSCustomaryReciprocalMultiplyingWithDenominatorAsLeft")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorReciprocalLeftUnit,
	DenominatorReciprocalRightQuantity : UndefinedQuantityType,
	DenominatorReciprocalRightUnit,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalLeftQuantity>,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalRightUnit : UndefinedScientificUnit<DenominatorReciprocalRightQuantity>,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
		DenominatorReciprocalLeftUnit,
		DenominatorReciprocalRightQuantity,
		DenominatorReciprocalRightUnit,
		>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorAndDenominatorReciprocalLeftQuantity,
			DenominatorReciprocalRightQuantity,
			>,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorUnitXDenominatorReciprocalRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndUSCustomary<
			NumeratorNumeratorQuantity,
				NumeratorNumeratorUnit,
				DenominatorReciprocalRightQuantity,
				DenominatorReciprocalRightUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
