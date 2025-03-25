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
import kotlin.jvm.JvmName

// Mul<A, B> / Div<Mul<A, B>, C> -> C

@JvmName("multiplyingDividedByDividingUnitWithSelfAsNumerator")
fun <
	NumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftQuantity>,
	NumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftQuantity,
			NumeratorRightAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorDenominatorValue : UndefinedScientificValue<
	DenominatorDenominatorQuantity,
DenominatorDenominatorUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftQuantity,
			NumeratorRightAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
	factory: (Decimal, DenominatorDenominatorUnit) -> DenominatorDenominatorValue,
) = right.unit.denominator.byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingDividedByMetricAndImperialDividingUnitWithSelfAsNumerator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftQuantity,
			NumeratorRightAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftQuantity,
			NumeratorRightAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorDenominatorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricMultiplyingDividedByMetricDividingUnitWithSelfAsNumerator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftQuantity,
			NumeratorRightAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftQuantity,
			NumeratorRightAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorDenominatorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialMultiplyingDividedByImperialDividingUnitWithSelfAsNumerator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftQuantity,
			NumeratorRightAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftQuantity,
			NumeratorRightAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorDenominatorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialMultiplyingDividedByUKImperialDividingUnitWithSelfAsNumerator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftQuantity,
			NumeratorRightAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftQuantity,
			NumeratorRightAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorDenominatorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryMultiplyingDividedByUSCustomaryDividingUnitWithSelfAsNumerator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftQuantity,
			NumeratorRightAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftQuantity,
			NumeratorRightAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorDenominatorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultiplyingDividedByMetricAndUKImperialDividingUnitWithSelfAsNumerator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftQuantity,
			NumeratorRightAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftQuantity,
			NumeratorRightAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorDenominatorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultiplyingDividedByMetricAndUSCustomaryDividingUnitWithSelfAsNumerator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftQuantity,
			NumeratorRightAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftQuantity,
			NumeratorRightAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorDenominatorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericMultiplyingDividedByGenericDividingUnitWithSelfAsNumerator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftQuantity>,
	NumeratorRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftQuantity,
			NumeratorRightAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorLeftQuantity,
		NumeratorRightAndDenominatorNumeratorRightQuantity,
		>,
NumeratorUnit,
	>.genericDividedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftQuantity,
			NumeratorRightAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorDenominatorUnit,
		->
		DefaultScientificValue(value, unit)
	}
