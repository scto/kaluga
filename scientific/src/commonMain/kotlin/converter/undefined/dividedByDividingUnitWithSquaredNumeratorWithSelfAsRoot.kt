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

// A / Div<Mul<A, A>, B> -> Div<B, A>

@JvmName("dividedByDividingUnitWithSquaredNumeratorWithSelfAsRoot")
fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorDenominatorQuantity,
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
	denominatorDenominatorUnitPerNumeratorUnit: DenominatorDenominatorUnit.(NumeratorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.denominator.denominatorDenominatorUnitPerNumeratorUnit(
	unit,
).byDividing(this, right, factory)

@JvmName("metricAndImperialDividedByMetricAndImperialDividingUnitWithSquaredNumeratorWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
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
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorUnitPerNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividedByMetricDividingUnitWithSquaredNumeratorWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		denominatorDenominatorUnitPerNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividedByImperialDividingUnitWithSquaredNumeratorWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorUnitPerNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividedByUKImperialDividingUnitWithSquaredNumeratorWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		denominatorDenominatorUnitPerNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividedByUSCustomaryDividingUnitWithSquaredNumeratorWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorUnitPerNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividedByMetricAndUKImperialDividingUnitWithSquaredNumeratorWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		denominatorDenominatorUnitPerNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividedByMetricAndUSCustomaryDividingUnitWithSquaredNumeratorWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorUnitPerNumeratorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				NumeratorAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
