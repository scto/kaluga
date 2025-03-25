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

// Div<Mul<A, A>, B> / Div<Mul<A, A>, B> -> One

@JvmName("dividingWithSquaredNumeratorDividedBySelf")
fun <
	NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorDenominatorAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorAndDenominatorDenominatorQuantity>,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorAndDenominatorDenominatorQuantity>,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
	TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
	getDimensionless: () -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = getDimensionless().byDividing(this, right, factory)

@JvmName("metricAndImperialDividingWithSquaredNumeratorDividedByMetricAndImperialSelf")
infix fun <
	NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorAndDenominatorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
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

@JvmName("metricDividingWithSquaredNumeratorDividedByMetricSelf")
infix fun <
	NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorAndDenominatorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
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

@JvmName("imperialDividingWithSquaredNumeratorDividedByImperialSelf")
infix fun <
	NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorAndDenominatorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
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

@JvmName("ukImperialDividingWithSquaredNumeratorDividedByUKImperialSelf")
infix fun <
	NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorAndDenominatorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
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

@JvmName("usCustomaryDividingWithSquaredNumeratorDividedByUSCustomarySelf")
infix fun <
	NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorAndDenominatorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
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

@JvmName("metricAndUKImperialDividingWithSquaredNumeratorDividedByMetricAndUKImperialSelf")
infix fun <
	NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorAndDenominatorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
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

@JvmName("metricAndUSCustomaryDividingWithSquaredNumeratorDividedByMetricAndUSCustomarySelf")
infix fun <
	NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorAndDenominatorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
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

@JvmName("genericDividingWithSquaredNumeratorDividedByGenericSelf")
infix fun <
	NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorDenominatorAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorAndDenominatorDenominatorQuantity>,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorAndDenominatorDenominatorQuantity>,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
		>,
NumeratorUnit,
	>.genericDividedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		NumeratorDenominatorAndDenominatorDenominatorQuantity,
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
