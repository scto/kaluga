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
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.DefinedScientificUnit
import com.splendo.kaluga.scientific.unit.Dimensionless
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.One
import kotlin.jvm.JvmName

// Div<A, Mul<B, B>> / Div<A, Mul<B, B>> -> One

@JvmName("dividingWithSquaredDenominatorDividedBySelf")
fun <
	NumeratorNumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorNumeratorQuantity>,
	NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorNumeratorQuantity>,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
	TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
	getDimensionless: () -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = getDimensionless().byDividing(this, right, factory)

@JvmName("metricAndImperialDividingWithSquaredDenominatorDividedByMetricAndImperialSelf")
infix fun <
	NumeratorNumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingWithSquaredDenominatorDividedByMetricSelf")
infix fun <
	NumeratorNumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingWithSquaredDenominatorDividedByImperialSelf")
infix fun <
	NumeratorNumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithSquaredDenominatorDividedByUKImperialSelf")
infix fun <
	NumeratorNumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithSquaredDenominatorDividedByUSCustomarySelf")
infix fun <
	NumeratorNumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithSquaredDenominatorDividedByMetricAndUKImperialSelf")
infix fun <
	NumeratorNumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithSquaredDenominatorDividedByMetricAndUSCustomarySelf")
infix fun <
	NumeratorNumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericDividingWithSquaredDenominatorDividedByGenericSelf")
infix fun <
	NumeratorNumeratorAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorNumeratorQuantity>,
	NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorNumeratorQuantity>,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
NumeratorUnit,
	>.genericDividedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}
