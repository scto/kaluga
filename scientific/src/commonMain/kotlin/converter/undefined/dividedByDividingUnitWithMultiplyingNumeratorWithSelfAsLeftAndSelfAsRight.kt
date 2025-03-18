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
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// A / Div<Mul<A, A>, B> -> Div<B, A>

@JvmName("dividedByDividingUnitWithMultiplyingNumeratorWithSelfAsLeftAndSelfAsRight")
fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		>,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorDenominatorQuantity,
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
	denominatorDenominatorUnitPerNumeratorUnit: DenominatorDenominatorUnit.(NumeratorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.denominator.denominatorDenominatorUnitPerNumeratorUnit(
	unit,
).byDividing(this, right, factory)

@JvmName("metricAndImperialDividedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftAndRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorUnitPerNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDividedByMetricDividingUnitWithMultiplyingNumeratorWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftAndRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		denominatorDenominatorUnitPerNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDividedByImperialDividingUnitWithMultiplyingNumeratorWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftAndRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorUnitPerNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDividedByUKImperialDividingUnitWithMultiplyingNumeratorWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftAndRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		denominatorDenominatorUnitPerNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDividedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftAndRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorUnitPerNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftAndRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		denominatorDenominatorUnitPerNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithSelfAsLeftAndSelfAsRight")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftAndRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorUnitPerNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
