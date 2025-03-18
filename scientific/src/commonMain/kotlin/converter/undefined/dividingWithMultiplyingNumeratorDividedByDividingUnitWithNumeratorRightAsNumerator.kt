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
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Div<Mul<A, B>, C> / Div<B, D> -> Div<Mul<A, D>, C>

@JvmName("dividingWithMultiplyingNumeratorDividedByDividingUnitWithNumeratorRightAsNumerator")
fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
	NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
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
	TargetUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			DenominatorDenominatorQuantity,
			>,
		TargetNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			DenominatorDenominatorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
	numeratorNumeratorLeftUnitXDenominatorDenominatorUnit: NumeratorNumeratorLeftUnit.(DenominatorDenominatorUnit) -> TargetNumeratorUnit,
	targetNumeratorUnitPerNumeratorDenominatorUnit: TargetNumeratorUnit.(NumeratorDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.left.numeratorNumeratorLeftUnitXDenominatorDenominatorUnit(
	right.unit.denominator,
).targetNumeratorUnitPerNumeratorDenominatorUnit(
	unit.denominator,
).byDividing(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingNumeratorDividedByMetricAndImperialDividingUnitWithNumeratorRightAsNumerator")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
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
		targetNumeratorUnitPerNumeratorDenominatorUnit = { per(it) },
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
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDividingWithMultiplyingNumeratorDividedByMetricDividingUnitWithNumeratorRightAsNumerator")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerNumeratorDenominatorUnit = { per(it) },
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
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDividingWithMultiplyingNumeratorDividedByImperialDividingUnitWithNumeratorRightAsNumerator")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerNumeratorDenominatorUnit = { per(it) },
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
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithMultiplyingNumeratorDividedByUKImperialDividingUnitWithNumeratorRightAsNumerator")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerNumeratorDenominatorUnit = { per(it) },
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
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithMultiplyingNumeratorDividedByUSCustomaryDividingUnitWithNumeratorRightAsNumerator")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerNumeratorDenominatorUnit = { per(it) },
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
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithMultiplyingNumeratorDividedByMetricAndUKImperialDividingUnitWithNumeratorRightAsNumerator")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerNumeratorDenominatorUnit = { per(it) },
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
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithMultiplyingNumeratorDividedByMetricAndUSCustomaryDividingUnitWithNumeratorRightAsNumerator")
infix fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftQuantity,
			NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerNumeratorDenominatorUnit = { per(it) },
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
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
