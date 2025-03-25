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

// Div<Mul<A, B>, Mul<C, D>> / Div<Mul<B, E>, Mul<D, F>> -> Div<Mul<A, F>, Mul<C, E>>

@JvmName("dividingWithMultiplyingNumeratorAndMultiplyingDenominatorDividedByDividingUnitWithMultiplyingNumeratorWithNumeratorRightAsLeftAndMultiplyingDenominatorWithDenominatorRightAsLeft")
fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
	NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
	NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftQuantity,
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		DenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	TargetNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftQuantity,
		NumeratorNumeratorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	TargetDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftQuantity,
		NumeratorDenominatorLeftUnit,
		DenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		TargetNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		TargetDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftQuantity,
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
	numeratorNumeratorLeftUnitXDenominatorDenominatorRightUnit: NumeratorNumeratorLeftUnit.(DenominatorDenominatorRightUnit) -> TargetNumeratorUnit,
	numeratorDenominatorLeftUnitXDenominatorNumeratorRightUnit: NumeratorDenominatorLeftUnit.(DenominatorNumeratorRightUnit) -> TargetDenominatorUnit,
	targetNumeratorUnitPerTargetDenominatorUnit: TargetNumeratorUnit.(TargetDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.left.numeratorNumeratorLeftUnitXDenominatorDenominatorRightUnit(
	right.unit.denominator.right,
).targetNumeratorUnitPerTargetDenominatorUnit(
	unit.denominator.left.numeratorDenominatorLeftUnitXDenominatorNumeratorRightUnit(
	right.unit.numerator.right,
),
).byDividing(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorDividedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithNumeratorRightAsLeftAndMultiplyingDenominatorWithDenominatorRightAsLeft")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftQuantity,
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftQuantity,
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		DenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorRightUnit = { x(it) },
		numeratorDenominatorLeftUnitXDenominatorNumeratorRightUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftQuantity,
					DenominatorDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndImperial<
				NumeratorNumeratorLeftQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorRightQuantity,
					DenominatorDenominatorRightUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorLeftQuantity,
					DenominatorNumeratorRightQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndImperial<
				NumeratorDenominatorLeftQuantity,
					NumeratorDenominatorLeftUnit,
					DenominatorNumeratorRightQuantity,
					DenominatorNumeratorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingWithMultiplyingNumeratorAndMultiplyingDenominatorDividedByMetricDividingUnitWithMultiplyingNumeratorWithNumeratorRightAsLeftAndMultiplyingDenominatorWithDenominatorRightAsLeft")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftQuantity,
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftQuantity,
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		DenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorRightUnit = { x(it) },
		numeratorDenominatorLeftUnitXDenominatorNumeratorRightUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftQuantity,
					DenominatorDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.Metric<
				NumeratorNumeratorLeftQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorRightQuantity,
					DenominatorDenominatorRightUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorLeftQuantity,
					DenominatorNumeratorRightQuantity,
					>,
				UndefinedMultipliedUnit.Metric<
				NumeratorDenominatorLeftQuantity,
					NumeratorDenominatorLeftUnit,
					DenominatorNumeratorRightQuantity,
					DenominatorNumeratorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorDividedByImperialDividingUnitWithMultiplyingNumeratorWithNumeratorRightAsLeftAndMultiplyingDenominatorWithDenominatorRightAsLeft")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftQuantity,
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftQuantity,
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		DenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorRightUnit = { x(it) },
		numeratorDenominatorLeftUnitXDenominatorNumeratorRightUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftQuantity,
					DenominatorDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.Imperial<
				NumeratorNumeratorLeftQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorRightQuantity,
					DenominatorDenominatorRightUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorLeftQuantity,
					DenominatorNumeratorRightQuantity,
					>,
				UndefinedMultipliedUnit.Imperial<
				NumeratorDenominatorLeftQuantity,
					NumeratorDenominatorLeftUnit,
					DenominatorNumeratorRightQuantity,
					DenominatorNumeratorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorDividedByUKImperialDividingUnitWithMultiplyingNumeratorWithNumeratorRightAsLeftAndMultiplyingDenominatorWithDenominatorRightAsLeft")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftQuantity,
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftQuantity,
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		DenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorRightUnit = { x(it) },
		numeratorDenominatorLeftUnitXDenominatorNumeratorRightUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftQuantity,
					DenominatorDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.UKImperial<
				NumeratorNumeratorLeftQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorRightQuantity,
					DenominatorDenominatorRightUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorLeftQuantity,
					DenominatorNumeratorRightQuantity,
					>,
				UndefinedMultipliedUnit.UKImperial<
				NumeratorDenominatorLeftQuantity,
					NumeratorDenominatorLeftUnit,
					DenominatorNumeratorRightQuantity,
					DenominatorNumeratorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithMultiplyingNumeratorAndMultiplyingDenominatorDividedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithNumeratorRightAsLeftAndMultiplyingDenominatorWithDenominatorRightAsLeft")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftQuantity,
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftQuantity,
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		DenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorRightUnit = { x(it) },
		numeratorDenominatorLeftUnitXDenominatorNumeratorRightUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftQuantity,
					DenominatorDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.USCustomary<
				NumeratorNumeratorLeftQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorRightQuantity,
					DenominatorDenominatorRightUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorLeftQuantity,
					DenominatorNumeratorRightQuantity,
					>,
				UndefinedMultipliedUnit.USCustomary<
				NumeratorDenominatorLeftQuantity,
					NumeratorDenominatorLeftUnit,
					DenominatorNumeratorRightQuantity,
					DenominatorNumeratorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithMultiplyingNumeratorAndMultiplyingDenominatorDividedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithNumeratorRightAsLeftAndMultiplyingDenominatorWithDenominatorRightAsLeft")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftQuantity,
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftQuantity,
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		DenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorRightUnit = { x(it) },
		numeratorDenominatorLeftUnitXDenominatorNumeratorRightUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftQuantity,
					DenominatorDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUKImperial<
				NumeratorNumeratorLeftQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorRightQuantity,
					DenominatorDenominatorRightUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorLeftQuantity,
					DenominatorNumeratorRightQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUKImperial<
				NumeratorDenominatorLeftQuantity,
					NumeratorDenominatorLeftUnit,
					DenominatorNumeratorRightQuantity,
					DenominatorNumeratorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithMultiplyingNumeratorAndMultiplyingDenominatorDividedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithNumeratorRightAsLeftAndMultiplyingDenominatorWithDenominatorRightAsLeft")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit,
	NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorLeftUnit,
	DenominatorDenominatorRightQuantity : UndefinedQuantityType,
	DenominatorDenominatorRightUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftQuantity,
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftQuantity,
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		DenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorRightQuantity>,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
		DenominatorDenominatorLeftUnit,
		DenominatorDenominatorRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightAndDenominatorDenominatorLeftQuantity,
			DenominatorDenominatorRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorRightUnit = { x(it) },
		numeratorDenominatorLeftUnitXDenominatorNumeratorRightUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftQuantity,
					DenominatorDenominatorRightQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUSCustomary<
				NumeratorNumeratorLeftQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorRightQuantity,
					DenominatorDenominatorRightUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorLeftQuantity,
					DenominatorNumeratorRightQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUSCustomary<
				NumeratorDenominatorLeftQuantity,
					NumeratorDenominatorLeftUnit,
					DenominatorNumeratorRightQuantity,
					DenominatorNumeratorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}
