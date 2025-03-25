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
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// Inv<A> / Div<B, Mul<A, A>> -> Div<A, B>

@JvmName("reciprocalDividedByDividingUnitWithSquaredDenominatorWithSelfAsRoot")
fun <
	NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalUnit,
		>,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalUnit,
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorNumeratorQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
	numeratorReciprocalUnitPerDenominatorNumeratorUnit: NumeratorReciprocalUnit.(DenominatorNumeratorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.inverse.numeratorReciprocalUnitPerDenominatorNumeratorUnit(
	right.unit.numerator,
).byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalDividedByMetricAndImperialDividingUnitWithSquaredDenominatorWithSelfAsRoot")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorReciprocalUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
				NumeratorReciprocalUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricReciprocalDividedByMetricDividingUnitWithSquaredDenominatorWithSelfAsRoot")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		numeratorReciprocalUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
				NumeratorReciprocalUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialReciprocalDividedByImperialDividingUnitWithSquaredDenominatorWithSelfAsRoot")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorReciprocalUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
				NumeratorReciprocalUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalDividedByUKImperialDividingUnitWithSquaredDenominatorWithSelfAsRoot")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorReciprocalUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
				NumeratorReciprocalUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalDividedByUSCustomaryDividingUnitWithSquaredDenominatorWithSelfAsRoot")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorReciprocalUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
				NumeratorReciprocalUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalDividedByMetricAndUKImperialDividingUnitWithSquaredDenominatorWithSelfAsRoot")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorReciprocalUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
				NumeratorReciprocalUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalDividedByMetricAndUSCustomaryDividingUnitWithSquaredDenominatorWithSelfAsRoot")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorReciprocalUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				NumeratorReciprocalAndDenominatorDenominatorLeftAndRightQuantity,
				NumeratorReciprocalUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
