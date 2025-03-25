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

// Mul<A, A> / Mul<A, B> -> Div<A, B>

@JvmName("squaredDividedByMultiplyingUnitWithRootAsLeft")
fun <
	NumeratorLeftAndRightAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorRightUnit,
		>,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	DenominatorRightQuantity : UndefinedQuantityType,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorRightQuantity>,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		DenominatorLeftUnit,
		DenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorLeftUnit,
		DenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		DenominatorRightQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		DenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
	numeratorLeftUnitPerDenominatorRightUnit: NumeratorLeftUnit.(DenominatorRightUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.left.numeratorLeftUnitPerDenominatorRightUnit(
	right.unit.right,
).byDividing(this, right, factory)

@JvmName("metricAndImperialSquaredDividedByMetricAndImperialMultiplyingUnitWithRootAsLeft")
infix fun <
	NumeratorLeftAndRightAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightQuantity : UndefinedQuantityType,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		DenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		DenominatorLeftUnit,
		DenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorLeftUnitPerDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				NumeratorLeftAndRightAndDenominatorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorRightQuantity,
				DenominatorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricSquaredDividedByMetricMultiplyingUnitWithRootAsLeft")
infix fun <
	NumeratorLeftAndRightAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightQuantity : UndefinedQuantityType,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		DenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		DenominatorLeftUnit,
		DenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		numeratorLeftUnitPerDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				NumeratorLeftAndRightAndDenominatorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorRightQuantity,
				DenominatorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialSquaredDividedByImperialMultiplyingUnitWithRootAsLeft")
infix fun <
	NumeratorLeftAndRightAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightQuantity : UndefinedQuantityType,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		DenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		DenominatorLeftUnit,
		DenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorLeftUnitPerDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				NumeratorLeftAndRightAndDenominatorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorRightQuantity,
				DenominatorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialSquaredDividedByUKImperialMultiplyingUnitWithRootAsLeft")
infix fun <
	NumeratorLeftAndRightAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightQuantity : UndefinedQuantityType,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		DenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		DenominatorLeftUnit,
		DenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorLeftUnitPerDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				NumeratorLeftAndRightAndDenominatorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorRightQuantity,
				DenominatorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomarySquaredDividedByUSCustomaryMultiplyingUnitWithRootAsLeft")
infix fun <
	NumeratorLeftAndRightAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightQuantity : UndefinedQuantityType,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		DenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		DenominatorLeftUnit,
		DenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorLeftUnitPerDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				NumeratorLeftAndRightAndDenominatorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorRightQuantity,
				DenominatorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialSquaredDividedByMetricAndUKImperialMultiplyingUnitWithRootAsLeft")
infix fun <
	NumeratorLeftAndRightAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightQuantity : UndefinedQuantityType,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		DenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		DenominatorLeftUnit,
		DenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorLeftUnitPerDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				NumeratorLeftAndRightAndDenominatorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorRightQuantity,
				DenominatorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomarySquaredDividedByMetricAndUSCustomaryMultiplyingUnitWithRootAsLeft")
infix fun <
	NumeratorLeftAndRightAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightQuantity : UndefinedQuantityType,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		DenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorLeftQuantity,
		DenominatorLeftUnit,
		DenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorLeftUnitPerDenominatorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				NumeratorLeftAndRightAndDenominatorLeftQuantity,
				NumeratorLeftUnit,
				DenominatorRightQuantity,
				DenominatorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
