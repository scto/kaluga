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
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import kotlin.jvm.JvmName

// Mul<A, A> / A -> A

@JvmName("squaredDividedByRoot")
fun <
	NumeratorLeftAndRightAndDenominatorQuantity : UndefinedQuantityType,
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorRightUnit,
		>,
	DenominatorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorLeftValue : UndefinedScientificValue<
	NumeratorLeftAndRightAndDenominatorQuantity,
NumeratorLeftUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorLeftAndRightAndDenominatorQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	NumeratorLeftAndRightAndDenominatorQuantity,
DenominatorUnit,
	>,
	factory: (Decimal, NumeratorLeftUnit) -> NumeratorLeftValue,
) = unit.left.byDividing(this, right, factory)

@JvmName("metricAndImperialSquaredDividedByMetricAndImperialRoot")
infix fun <
	NumeratorLeftAndRightAndDenominatorQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorLeftAndRightAndDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	NumeratorLeftAndRightAndDenominatorQuantity,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricSquaredDividedByMetricRoot")
infix fun <
	NumeratorLeftAndRightAndDenominatorQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorLeftAndRightAndDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	NumeratorLeftAndRightAndDenominatorQuantity,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialSquaredDividedByImperialRoot")
infix fun <
	NumeratorLeftAndRightAndDenominatorQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorLeftAndRightAndDenominatorQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	NumeratorLeftAndRightAndDenominatorQuantity,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialSquaredDividedByUKImperialRoot")
infix fun <
	NumeratorLeftAndRightAndDenominatorQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorLeftAndRightAndDenominatorQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	NumeratorLeftAndRightAndDenominatorQuantity,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomarySquaredDividedByUSCustomaryRoot")
infix fun <
	NumeratorLeftAndRightAndDenominatorQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorLeftAndRightAndDenominatorQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	NumeratorLeftAndRightAndDenominatorQuantity,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialSquaredDividedByMetricAndUKImperialRoot")
infix fun <
	NumeratorLeftAndRightAndDenominatorQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorLeftAndRightAndDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	NumeratorLeftAndRightAndDenominatorQuantity,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomarySquaredDividedByMetricAndUSCustomaryRoot")
infix fun <
	NumeratorLeftAndRightAndDenominatorQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorLeftAndRightAndDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	NumeratorLeftAndRightAndDenominatorQuantity,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("genericSquaredDividedByGenericRoot")
infix fun <
	NumeratorLeftAndRightAndDenominatorQuantity : UndefinedQuantityType,
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorRightUnit,
		>,
	DenominatorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorQuantity>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorQuantity,
		NumeratorLeftAndRightAndDenominatorQuantity,
		>,
NumeratorUnit,
	>.genericDividedByGeneric(
	right: UndefinedScientificValue<
	NumeratorLeftAndRightAndDenominatorQuantity,
DenominatorUnit,
	>,
) =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorLeftUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
