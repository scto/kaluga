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
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Div<A, Mul<B, B>> / Div<C, Mul<B, D>> -> Div<Mul<A, D>, Mul<B, C>>

@JvmName("dividingWithSquaredDenominatorDividedByDividingUnitWithMultiplyingDenominatorWithDenominatorRootAsLeft")
fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	TargetNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	TargetDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorLeftUnit,
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		TargetNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			DenominatorNumeratorQuantity,
			>,
		TargetDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			DenominatorNumeratorQuantity,
			>,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
	numeratorNumeratorUnitXDenominatorDenominatorRightUnit: NumeratorNumeratorUnit.(DenominatorDenominatorRightUnit) -> TargetNumeratorUnit,
	numeratorDenominatorLeftUnitXDenominatorNumeratorUnit: NumeratorDenominatorLeftUnit.(DenominatorNumeratorUnit) -> TargetDenominatorUnit,
	targetNumeratorUnitPerTargetDenominatorUnit: TargetNumeratorUnit.(TargetDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.numeratorNumeratorUnitXDenominatorDenominatorRightUnit(
	right.unit.denominator.right,
).targetNumeratorUnitPerTargetDenominatorUnit(
	unit.denominator.left.numeratorDenominatorLeftUnitXDenominatorNumeratorUnit(
	right.unit.numerator,
),
).byDividing(this, right, factory)

@JvmName("metricAndImperialDividingWithSquaredDenominatorDividedByMetricAndImperialDividingUnitWithMultiplyingDenominatorWithDenominatorRootAsLeft")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorUnitXDenominatorDenominatorRightUnit = { x(it) },
		numeratorDenominatorLeftUnitXDenominatorNumeratorUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorQuantity,
					DenominatorDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndImperial<
				NumeratorNumeratorQuantity,
					NumeratorNumeratorUnit,
					DenominatorDenominatorRightQuantity,
					DenominatorDenominatorRightUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
					DenominatorNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndImperial<
				NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
					NumeratorDenominatorLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingWithSquaredDenominatorDividedByMetricDividingUnitWithMultiplyingDenominatorWithDenominatorRootAsLeft")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		numeratorNumeratorUnitXDenominatorDenominatorRightUnit = { x(it) },
		numeratorDenominatorLeftUnitXDenominatorNumeratorUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorQuantity,
					DenominatorDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.Metric<
				NumeratorNumeratorQuantity,
					NumeratorNumeratorUnit,
					DenominatorDenominatorRightQuantity,
					DenominatorDenominatorRightUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
					DenominatorNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.Metric<
				NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
					NumeratorDenominatorLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingWithSquaredDenominatorDividedByImperialDividingUnitWithMultiplyingDenominatorWithDenominatorRootAsLeft")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorUnitXDenominatorDenominatorRightUnit = { x(it) },
		numeratorDenominatorLeftUnitXDenominatorNumeratorUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorQuantity,
					DenominatorDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.Imperial<
				NumeratorNumeratorQuantity,
					NumeratorNumeratorUnit,
					DenominatorDenominatorRightQuantity,
					DenominatorDenominatorRightUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
					DenominatorNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.Imperial<
				NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
					NumeratorDenominatorLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithSquaredDenominatorDividedByUKImperialDividingUnitWithMultiplyingDenominatorWithDenominatorRootAsLeft")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorNumeratorUnitXDenominatorDenominatorRightUnit = { x(it) },
		numeratorDenominatorLeftUnitXDenominatorNumeratorUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorQuantity,
					DenominatorDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.UKImperial<
				NumeratorNumeratorQuantity,
					NumeratorNumeratorUnit,
					DenominatorDenominatorRightQuantity,
					DenominatorDenominatorRightUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
					DenominatorNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.UKImperial<
				NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
					NumeratorDenominatorLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithSquaredDenominatorDividedByUSCustomaryDividingUnitWithMultiplyingDenominatorWithDenominatorRootAsLeft")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorUnitXDenominatorDenominatorRightUnit = { x(it) },
		numeratorDenominatorLeftUnitXDenominatorNumeratorUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorQuantity,
					DenominatorDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.USCustomary<
				NumeratorNumeratorQuantity,
					NumeratorNumeratorUnit,
					DenominatorDenominatorRightQuantity,
					DenominatorDenominatorRightUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
					DenominatorNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.USCustomary<
				NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
					NumeratorDenominatorLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithSquaredDenominatorDividedByMetricAndUKImperialDividingUnitWithMultiplyingDenominatorWithDenominatorRootAsLeft")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorNumeratorUnitXDenominatorDenominatorRightUnit = { x(it) },
		numeratorDenominatorLeftUnitXDenominatorNumeratorUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorQuantity,
					DenominatorDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUKImperial<
				NumeratorNumeratorQuantity,
					NumeratorNumeratorUnit,
					DenominatorDenominatorRightQuantity,
					DenominatorDenominatorRightUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
					DenominatorNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUKImperial<
				NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
					NumeratorDenominatorLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithSquaredDenominatorDividedByMetricAndUSCustomaryDividingUnitWithMultiplyingDenominatorWithDenominatorRootAsLeft")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorUnitXDenominatorDenominatorRightUnit = { x(it) },
		numeratorDenominatorLeftUnitXDenominatorNumeratorUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorQuantity,
					DenominatorDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUSCustomary<
				NumeratorNumeratorQuantity,
					NumeratorNumeratorUnit,
					DenominatorDenominatorRightQuantity,
					DenominatorDenominatorRightUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
					DenominatorNumeratorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUSCustomary<
				NumeratorDenominatorLeftAndRightAndDenominatorDenominatorLeftQuantity,
					NumeratorDenominatorLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}
