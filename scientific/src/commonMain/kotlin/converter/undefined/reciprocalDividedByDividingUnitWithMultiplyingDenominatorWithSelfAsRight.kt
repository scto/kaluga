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

// Inv<A> / Div<C, Mul<B, A>> -> Div<B, C>

@JvmName("reciprocalDividedByDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
fun <
	NumeratorReciprocalAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorRightQuantity>,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		NumeratorReciprocalUnit,
		>,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorRightQuantity>,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		DenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			DenominatorDenominatorLeftQuantity,
			NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		DenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorDenominatorLeftQuantity,
		DenominatorNumeratorQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			DenominatorDenominatorLeftQuantity,
			NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
	denominatorDenominatorLeftUnitPerDenominatorNumeratorUnit: DenominatorDenominatorLeftUnit.(DenominatorNumeratorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.denominator.left.denominatorDenominatorLeftUnitPerDenominatorNumeratorUnit(
	right.unit.numerator,
).byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalDividedByMetricAndImperialDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			DenominatorDenominatorLeftQuantity,
			NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		DenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			DenominatorDenominatorLeftQuantity,
			NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorLeftUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				DenominatorDenominatorLeftQuantity,
				DenominatorDenominatorLeftUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricReciprocalDividedByMetricDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			DenominatorDenominatorLeftQuantity,
			NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		DenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			DenominatorDenominatorLeftQuantity,
			NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		denominatorDenominatorLeftUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				DenominatorDenominatorLeftQuantity,
				DenominatorDenominatorLeftUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialReciprocalDividedByImperialDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			DenominatorDenominatorLeftQuantity,
			NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		DenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			DenominatorDenominatorLeftQuantity,
			NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorLeftUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				DenominatorDenominatorLeftQuantity,
				DenominatorDenominatorLeftUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalDividedByUKImperialDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			DenominatorDenominatorLeftQuantity,
			NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		DenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			DenominatorDenominatorLeftQuantity,
			NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		denominatorDenominatorLeftUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				DenominatorDenominatorLeftQuantity,
				DenominatorDenominatorLeftUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalDividedByUSCustomaryDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			DenominatorDenominatorLeftQuantity,
			NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		DenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			DenominatorDenominatorLeftQuantity,
			NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorLeftUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				DenominatorDenominatorLeftQuantity,
				DenominatorDenominatorLeftUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalDividedByMetricAndUKImperialDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			DenominatorDenominatorLeftQuantity,
			NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		DenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			DenominatorDenominatorLeftQuantity,
			NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		denominatorDenominatorLeftUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				DenominatorDenominatorLeftQuantity,
				DenominatorDenominatorLeftUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalDividedByMetricAndUSCustomaryDividingUnitWithMultiplyingDenominatorWithSelfAsRight")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			DenominatorDenominatorLeftQuantity,
			NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorRightQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		DenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			DenominatorDenominatorLeftQuantity,
			NumeratorReciprocalAndDenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorLeftUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				DenominatorDenominatorLeftQuantity,
				DenominatorDenominatorLeftUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
