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
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Mul<A, A> / Div<A, B> -> Mul<A, B>

@JvmName("squaredDividedByDividingUnitWithRootAsNumerator")
fun <
	NumeratorLeftAndRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	TargetUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorLeftUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
	numeratorLeftUnitXDenominatorDenominatorUnit: NumeratorLeftUnit.(DenominatorDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.left.numeratorLeftUnitXDenominatorDenominatorUnit(
	right.unit.denominator,
).byDividing(this, right, factory)

@JvmName("metricAndImperialSquaredDividedByMetricAndImperialDividingUnitWithRootAsNumerator")
infix fun <
	NumeratorLeftAndRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
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
			NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
				NumeratorLeftUnit,
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricSquaredDividedByMetricDividingUnitWithRootAsNumerator")
infix fun <
	NumeratorLeftAndRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
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
			NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
				NumeratorLeftUnit,
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialSquaredDividedByImperialDividingUnitWithRootAsNumerator")
infix fun <
	NumeratorLeftAndRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
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
			NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
				NumeratorLeftUnit,
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialSquaredDividedByUKImperialDividingUnitWithRootAsNumerator")
infix fun <
	NumeratorLeftAndRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
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
			NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
				NumeratorLeftUnit,
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomarySquaredDividedByUSCustomaryDividingUnitWithRootAsNumerator")
infix fun <
	NumeratorLeftAndRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
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
			NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
				NumeratorLeftUnit,
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialSquaredDividedByMetricAndUKImperialDividingUnitWithRootAsNumerator")
infix fun <
	NumeratorLeftAndRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
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
			NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
				NumeratorLeftUnit,
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomarySquaredDividedByMetricAndUSCustomaryDividingUnitWithRootAsNumerator")
infix fun <
	NumeratorLeftAndRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorLeftUnit,
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
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
			NumeratorLeftAndRightAndDenominatorNumeratorQuantity,
				NumeratorLeftUnit,
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
