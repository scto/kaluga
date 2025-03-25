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

// Inv<A> / Div<C, Mul<A, B>> -> Div<B, C>

@JvmName("reciprocalDividedByDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
fun <
	NumeratorReciprocalAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		NumeratorReciprocalUnit,
		>,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorDenominatorRightQuantity,
		DenominatorNumeratorQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
	denominatorDenominatorRightUnitPerDenominatorNumeratorUnit: DenominatorDenominatorRightUnit.(DenominatorNumeratorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.denominator.right.denominatorDenominatorRightUnitPerDenominatorNumeratorUnit(
	right.unit.numerator,
).byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalDividedByMetricAndImperialDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorRightUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				DenominatorDenominatorRightQuantity,
				DenominatorDenominatorRightUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricReciprocalDividedByMetricDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		denominatorDenominatorRightUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				DenominatorDenominatorRightQuantity,
				DenominatorDenominatorRightUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialReciprocalDividedByImperialDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorRightUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				DenominatorDenominatorRightQuantity,
				DenominatorDenominatorRightUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalDividedByUKImperialDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		denominatorDenominatorRightUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				DenominatorDenominatorRightQuantity,
				DenominatorDenominatorRightUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalDividedByUSCustomaryDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorRightUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				DenominatorDenominatorRightQuantity,
				DenominatorDenominatorRightUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalDividedByMetricAndUKImperialDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		denominatorDenominatorRightUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				DenominatorDenominatorRightQuantity,
				DenominatorDenominatorRightUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalDividedByMetricAndUSCustomaryDividingUnitWithMultiplyingDenominatorWithSelfAsLeft")
infix fun <
	NumeratorReciprocalAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorRightUnitPerDenominatorNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				DenominatorDenominatorRightQuantity,
				DenominatorDenominatorRightUnit,
				DenominatorNumeratorQuantity,
				DenominatorNumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
