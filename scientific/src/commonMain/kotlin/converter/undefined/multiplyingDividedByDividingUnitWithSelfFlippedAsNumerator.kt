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

// Mul<A, B> / Div<Mul<B, A>, C> -> C

@JvmName("multiplyingDividedByDividingUnitWithSelfFlippedAsNumerator")
fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorRightUnit,
		>,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
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
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
	factory: (Decimal, DenominatorDenominatorUnit) -> DenominatorDenominatorValue,
) = right.unit.denominator.byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingDividedByMetricAndImperialDividingUnitWithSelfFlippedAsNumerator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
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
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
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
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
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

@JvmName("metricMultiplyingDividedByMetricDividingUnitWithSelfFlippedAsNumerator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
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
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
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

@JvmName("imperialMultiplyingDividedByImperialDividingUnitWithSelfFlippedAsNumerator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
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
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
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

@JvmName("ukImperialMultiplyingDividedByUKImperialDividingUnitWithSelfFlippedAsNumerator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
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
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
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

@JvmName("usCustomaryMultiplyingDividedByUSCustomaryDividingUnitWithSelfFlippedAsNumerator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
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
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
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

@JvmName("metricAndUKImperialMultiplyingDividedByMetricAndUKImperialDividingUnitWithSelfFlippedAsNumerator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
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
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
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

@JvmName("metricAndUSCustomaryMultiplyingDividedByMetricAndUSCustomaryDividingUnitWithSelfFlippedAsNumerator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
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
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
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

@JvmName("genericMultiplyingDividedByGenericDividingUnitWithSelfFlippedAsNumerator")
infix fun <
	NumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorRightUnit,
		>,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorRightQuantity,
		NumeratorRightAndDenominatorNumeratorLeftQuantity,
		>,
NumeratorUnit,
	>.genericDividedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorRightAndDenominatorNumeratorLeftQuantity,
			NumeratorLeftAndDenominatorNumeratorRightQuantity,
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
