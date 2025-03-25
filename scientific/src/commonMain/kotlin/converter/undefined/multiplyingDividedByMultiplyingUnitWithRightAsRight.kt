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
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// Mul<A, B> / Mul<C, B> -> Div<A, C>

@JvmName("multiplyingDividedByMultiplyingUnitWithRightAsRight")
fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorRightAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		NumeratorRightUnit,
		>,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		NumeratorLeftQuantity,
		NumeratorLeftUnit,
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorLeftQuantity,
		DenominatorLeftQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
	numeratorLeftUnitPerDenominatorLeftUnit: NumeratorLeftUnit.(DenominatorLeftUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.left.numeratorLeftUnitPerDenominatorLeftUnit(
	right.unit.left,
).byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingDividedByMetricAndImperialMultiplyingUnitWithRightAsRight")
infix fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorLeftUnitPerDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				NumeratorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorLeftQuantity,
				DenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricMultiplyingDividedByMetricMultiplyingUnitWithRightAsRight")
infix fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		numeratorLeftUnitPerDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				NumeratorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorLeftQuantity,
				DenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialMultiplyingDividedByImperialMultiplyingUnitWithRightAsRight")
infix fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorLeftUnitPerDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				NumeratorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorLeftQuantity,
				DenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialMultiplyingDividedByUKImperialMultiplyingUnitWithRightAsRight")
infix fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorLeftUnitPerDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				NumeratorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorLeftQuantity,
				DenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryMultiplyingDividedByUSCustomaryMultiplyingUnitWithRightAsRight")
infix fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorLeftUnitPerDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				NumeratorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorLeftQuantity,
				DenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultiplyingDividedByMetricAndUKImperialMultiplyingUnitWithRightAsRight")
infix fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorLeftUnitPerDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				NumeratorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorLeftQuantity,
				DenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultiplyingDividedByMetricAndUSCustomaryMultiplyingUnitWithRightAsRight")
infix fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorLeftUnitPerDenominatorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				NumeratorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorLeftQuantity,
				DenominatorLeftUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
