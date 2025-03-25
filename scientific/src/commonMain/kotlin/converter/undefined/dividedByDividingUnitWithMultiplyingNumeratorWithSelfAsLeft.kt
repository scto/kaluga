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

// A / Div<Mul<A, B>, C> -> Div<C, B>

@JvmName("dividedByDividingUnitWithMultiplyingNumeratorWithSelfAsLeft")
fun <
	NumeratorAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		DenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		DenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorDenominatorQuantity,
		DenominatorNumeratorRightQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftQuantity,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
	denominatorDenominatorUnitPerDenominatorNumeratorRightUnit: DenominatorDenominatorUnit.(DenominatorNumeratorRightUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = right.unit.denominator.denominatorDenominatorUnitPerDenominatorNumeratorRightUnit(
	right.unit.numerator.right,
).byDividing(this, right, factory)

@JvmName("metricAndImperialDividedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithSelfAsLeft")
infix fun <
	NumeratorAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftQuantity,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		DenominatorNumeratorRightQuantity,
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
			NumeratorAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
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
		denominatorDenominatorUnitPerDenominatorNumeratorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				DenominatorNumeratorRightQuantity,
				DenominatorNumeratorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividedByMetricDividingUnitWithMultiplyingNumeratorWithSelfAsLeft")
infix fun <
	NumeratorAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftQuantity,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		DenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		denominatorDenominatorUnitPerDenominatorNumeratorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				DenominatorNumeratorRightQuantity,
				DenominatorNumeratorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividedByImperialDividingUnitWithMultiplyingNumeratorWithSelfAsLeft")
infix fun <
	NumeratorAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftQuantity,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		DenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorUnitPerDenominatorNumeratorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				DenominatorNumeratorRightQuantity,
				DenominatorNumeratorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividedByUKImperialDividingUnitWithMultiplyingNumeratorWithSelfAsLeft")
infix fun <
	NumeratorAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftQuantity,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		DenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		denominatorDenominatorUnitPerDenominatorNumeratorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				DenominatorNumeratorRightQuantity,
				DenominatorNumeratorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithSelfAsLeft")
infix fun <
	NumeratorAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftQuantity,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		DenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorUnitPerDenominatorNumeratorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				DenominatorNumeratorRightQuantity,
				DenominatorNumeratorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithSelfAsLeft")
infix fun <
	NumeratorAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftQuantity,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		DenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		denominatorDenominatorUnitPerDenominatorNumeratorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				DenominatorNumeratorRightQuantity,
				DenominatorNumeratorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithSelfAsLeft")
infix fun <
	NumeratorAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	NumeratorAndDenominatorNumeratorLeftQuantity,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		DenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorDenominatorUnitPerDenominatorNumeratorRightUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				DenominatorDenominatorQuantity,
				DenominatorDenominatorUnit,
				DenominatorNumeratorRightQuantity,
				DenominatorNumeratorRightUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
