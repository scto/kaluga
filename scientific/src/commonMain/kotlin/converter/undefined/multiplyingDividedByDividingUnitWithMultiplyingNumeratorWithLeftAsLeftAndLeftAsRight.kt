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

// Mul<A, B> / Div<Mul<A, A>, C> -> Div<Mul<B, C>, A>

@JvmName("multiplyingDividedByDividingUnitWithMultiplyingNumeratorWithLeftAsLeftAndLeftAsRight")
fun <
	NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	DenominatorNumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		>,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	TargetNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorRightQuantity,
		NumeratorRightUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorRightQuantity,
			DenominatorDenominatorQuantity,
			>,
		TargetNumeratorUnit,
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorRightQuantity,
			DenominatorDenominatorQuantity,
			>,
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorRightQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
	numeratorRightUnitXDenominatorDenominatorUnit: NumeratorRightUnit.(DenominatorDenominatorUnit) -> TargetNumeratorUnit,
	targetNumeratorUnitPerNumeratorLeftUnit: TargetNumeratorUnit.(NumeratorLeftUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.right.numeratorRightUnitXDenominatorDenominatorUnit(
	right.unit.denominator,
).targetNumeratorUnitPerNumeratorLeftUnit(
	unit.left,
).byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingDividedByMetricAndImperialDividingUnitWithMultiplyingNumeratorWithLeftAsLeftAndLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftAndRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorRightQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
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
		numeratorRightUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				UndefinedQuantityType.Multiplying<
					NumeratorRightQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndImperial<
				NumeratorRightQuantity,
					NumeratorRightUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricMultiplyingDividedByMetricDividingUnitWithMultiplyingNumeratorWithLeftAsLeftAndLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftAndRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorRightQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		numeratorRightUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				UndefinedQuantityType.Multiplying<
					NumeratorRightQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.Metric<
				NumeratorRightQuantity,
					NumeratorRightUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialMultiplyingDividedByImperialDividingUnitWithMultiplyingNumeratorWithLeftAsLeftAndLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftAndRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorRightQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorRightUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				UndefinedQuantityType.Multiplying<
					NumeratorRightQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.Imperial<
				NumeratorRightQuantity,
					NumeratorRightUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialMultiplyingDividedByUKImperialDividingUnitWithMultiplyingNumeratorWithLeftAsLeftAndLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftAndRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorRightQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorRightUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				UndefinedQuantityType.Multiplying<
					NumeratorRightQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.UKImperial<
				NumeratorRightQuantity,
					NumeratorRightUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryMultiplyingDividedByUSCustomaryDividingUnitWithMultiplyingNumeratorWithLeftAsLeftAndLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftAndRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorRightQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorRightUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				UndefinedQuantityType.Multiplying<
					NumeratorRightQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.USCustomary<
				NumeratorRightQuantity,
					NumeratorRightUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultiplyingDividedByMetricAndUKImperialDividingUnitWithMultiplyingNumeratorWithLeftAsLeftAndLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftAndRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorRightQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorRightUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				UndefinedQuantityType.Multiplying<
					NumeratorRightQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUKImperial<
				NumeratorRightQuantity,
					NumeratorRightUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultiplyingDividedByMetricAndUSCustomaryDividingUnitWithMultiplyingNumeratorWithLeftAsLeftAndLeftAsRight")
infix fun <
	NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorNumeratorLeftAndRightUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorRightQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		NumeratorLeftUnit,
		NumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorLeftAndRightUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity>,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorLeftAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
		DenominatorNumeratorLeftAndRightUnit,
		>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
			>,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorRightUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerNumeratorLeftUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				UndefinedQuantityType.Multiplying<
					NumeratorRightQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUSCustomary<
				NumeratorRightQuantity,
					NumeratorRightUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				NumeratorLeftAndDenominatorNumeratorLeftAndRightQuantity,
				NumeratorLeftUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
