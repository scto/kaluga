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
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.One
import kotlin.jvm.JvmName

// Mul<A, B> / Mul<A, B> -> One

@JvmName("multiplyingDividedBySelf")
fun <
	NumeratorLeftAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
	NumeratorRightAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		NumeratorRightUnit,
		>,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
	TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
	getDimensionless: () -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = getDimensionless().byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingDividedByMetricAndImperialSelf")
infix fun <
	NumeratorLeftAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		DenominatorRightUnit,
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

@JvmName("metricMultiplyingDividedByMetricSelf")
infix fun <
	NumeratorLeftAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		DenominatorRightUnit,
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

@JvmName("imperialMultiplyingDividedByImperialSelf")
infix fun <
	NumeratorLeftAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		DenominatorRightUnit,
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

@JvmName("ukImperialMultiplyingDividedByUKImperialSelf")
infix fun <
	NumeratorLeftAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		DenominatorRightUnit,
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

@JvmName("usCustomaryMultiplyingDividedByUSCustomarySelf")
infix fun <
	NumeratorLeftAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		DenominatorRightUnit,
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

@JvmName("metricAndUKImperialMultiplyingDividedByMetricAndUKImperialSelf")
infix fun <
	NumeratorLeftAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		DenominatorRightUnit,
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

@JvmName("metricAndUSCustomaryMultiplyingDividedByMetricAndUSCustomarySelf")
infix fun <
	NumeratorLeftAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		DenominatorRightUnit,
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

@JvmName("genericMultiplyingDividedByGenericSelf")
infix fun <
	NumeratorLeftAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
	NumeratorRightAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		NumeratorRightUnit,
		>,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndDenominatorLeftQuantity>,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorRightAndDenominatorRightQuantity>,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorRightAndDenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
		>,
NumeratorUnit,
	>.genericDividedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorLeftQuantity,
		NumeratorRightAndDenominatorRightQuantity,
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
