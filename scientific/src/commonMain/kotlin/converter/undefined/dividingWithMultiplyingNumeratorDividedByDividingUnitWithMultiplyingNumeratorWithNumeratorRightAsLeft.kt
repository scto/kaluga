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

// Div<Mul<A, B>, C> / Div<Mul<B, D>, E> -> Div<Mul<A, E>, Mul<C, D>>

@JvmName("dividingWithMultiplyingNumeratorDividedByDividingUnitWithMultiplyingNumeratorWithNumeratorRightAsLeft")
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
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
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
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	TargetNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftQuantity,
		NumeratorNumeratorLeftUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	TargetDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		DenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			DenominatorDenominatorQuantity,
			>,
		TargetNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		TargetDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			DenominatorDenominatorQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorQuantity,
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
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
	numeratorNumeratorLeftUnitXDenominatorDenominatorUnit: NumeratorNumeratorLeftUnit.(DenominatorDenominatorUnit) -> TargetNumeratorUnit,
	numeratorDenominatorUnitXDenominatorNumeratorRightUnit: NumeratorDenominatorUnit.(DenominatorNumeratorRightUnit) -> TargetDenominatorUnit,
	targetNumeratorUnitPerTargetDenominatorUnit: TargetNumeratorUnit.(TargetDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.left.numeratorNumeratorLeftUnitXDenominatorDenominatorUnit(
	right.unit.denominator,
).targetNumeratorUnitPerTargetDenominatorUnit(
	unit.denominator.numeratorDenominatorUnitXDenominatorNumeratorRightUnit(
	right.unit.numerator.right,
),
).byDividing(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingNumeratorDividedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithNumeratorRightAsLeft")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
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
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
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
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
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
		numeratorNumeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
		numeratorDenominatorUnitXDenominatorNumeratorRightUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndImperial<
				NumeratorNumeratorLeftQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					DenominatorNumeratorRightQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndImperial<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorNumeratorRightQuantity,
					DenominatorNumeratorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingWithMultiplyingNumeratorDividedByMetricDividingUnitWithMultiplyingNumeratorWithNumeratorRightAsLeft")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
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
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
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
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
		numeratorDenominatorUnitXDenominatorNumeratorRightUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.Metric<
				NumeratorNumeratorLeftQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					DenominatorNumeratorRightQuantity,
					>,
				UndefinedMultipliedUnit.Metric<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorNumeratorRightQuantity,
					DenominatorNumeratorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingWithMultiplyingNumeratorDividedByImperialDividingUnitWithMultiplyingNumeratorWithNumeratorRightAsLeft")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
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
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
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
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
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
		numeratorNumeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
		numeratorDenominatorUnitXDenominatorNumeratorRightUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.Imperial<
				NumeratorNumeratorLeftQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					DenominatorNumeratorRightQuantity,
					>,
				UndefinedMultipliedUnit.Imperial<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorNumeratorRightQuantity,
					DenominatorNumeratorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithMultiplyingNumeratorDividedByUKImperialDividingUnitWithMultiplyingNumeratorWithNumeratorRightAsLeft")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
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
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
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
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
		numeratorDenominatorUnitXDenominatorNumeratorRightUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.UKImperial<
				NumeratorNumeratorLeftQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					DenominatorNumeratorRightQuantity,
					>,
				UndefinedMultipliedUnit.UKImperial<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorNumeratorRightQuantity,
					DenominatorNumeratorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithMultiplyingNumeratorDividedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithNumeratorRightAsLeft")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
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
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
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
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
		numeratorDenominatorUnitXDenominatorNumeratorRightUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.USCustomary<
				NumeratorNumeratorLeftQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					DenominatorNumeratorRightQuantity,
					>,
				UndefinedMultipliedUnit.USCustomary<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorNumeratorRightQuantity,
					DenominatorNumeratorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithMultiplyingNumeratorDividedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithNumeratorRightAsLeft")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
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
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
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
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
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
		numeratorNumeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
		numeratorDenominatorUnitXDenominatorNumeratorRightUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUKImperial<
				NumeratorNumeratorLeftQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					DenominatorNumeratorRightQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUKImperial<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorNumeratorRightQuantity,
					DenominatorNumeratorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithMultiplyingNumeratorDividedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithNumeratorRightAsLeft")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftUnit,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			DenominatorNumeratorRightQuantity,
			>,
		DenominatorDenominatorQuantity,
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
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
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
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity,
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
		numeratorNumeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
		numeratorDenominatorUnitXDenominatorNumeratorRightUnit = { x(it) },
		targetNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUSCustomary<
				NumeratorNumeratorLeftQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					DenominatorNumeratorRightQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUSCustomary<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorNumeratorRightQuantity,
					DenominatorNumeratorRightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}
