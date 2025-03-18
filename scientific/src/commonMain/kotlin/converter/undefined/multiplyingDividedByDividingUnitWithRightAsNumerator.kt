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
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Mul<A, B> / Div<B, C> -> Mul<A, C>

@JvmName("multiplyingDividedByDividingUnitWithRightAsNumerator")
fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorQuantity,
		NumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorQuantity>,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	TargetUnit : UndefinedMultipliedUnit<
		NumeratorLeftQuantity,
		NumeratorLeftUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftQuantity,
		DenominatorDenominatorQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftQuantity,
		NumeratorRightAndDenominatorNumeratorQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
	numeratorLeftUnitXDenominatorDenominatorUnit: NumeratorLeftUnit.(DenominatorDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.left.numeratorLeftUnitXDenominatorDenominatorUnit(
	right.unit.denominator,
).byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingDividedByMetricAndImperialDividingUnitWithRightAsNumerator")
infix fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftQuantity,
		NumeratorRightAndDenominatorNumeratorQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndImperial<
			NumeratorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricMultiplyingDividedByMetricDividingUnitWithRightAsNumerator")
infix fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftQuantity,
		NumeratorRightAndDenominatorNumeratorQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.Metric<
			NumeratorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialMultiplyingDividedByImperialDividingUnitWithRightAsNumerator")
infix fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftQuantity,
		NumeratorRightAndDenominatorNumeratorQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.Imperial<
			NumeratorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialMultiplyingDividedByUKImperialDividingUnitWithRightAsNumerator")
infix fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftQuantity,
		NumeratorRightAndDenominatorNumeratorQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.UKImperial<
			NumeratorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryMultiplyingDividedByUSCustomaryDividingUnitWithRightAsNumerator")
infix fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftQuantity,
		NumeratorRightAndDenominatorNumeratorQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.USCustomary<
			NumeratorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultiplyingDividedByMetricAndUKImperialDividingUnitWithRightAsNumerator")
infix fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftQuantity,
		NumeratorRightAndDenominatorNumeratorQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndUKImperial<
			NumeratorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultiplyingDividedByMetricAndUSCustomaryDividingUnitWithRightAsNumerator")
infix fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftQuantity,
		NumeratorRightAndDenominatorNumeratorQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndUSCustomary<
			NumeratorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
