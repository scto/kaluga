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
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Inv<Mul<A, B>> / Div<C, B> -> Inv<Mul<A, C>>

@JvmName("reciprocalMultiplyingDividedByDividingUnitWithRightAsDenominator")
fun <
	NumeratorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftQuantity>,
	NumeratorReciprocalRightAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftQuantity,
			NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorQuantity>,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	TargetReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftQuantity,
		NumeratorReciprocalLeftUnit,
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		>,
	TargetUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftQuantity,
			DenominatorNumeratorQuantity,
			>,
		TargetReciprocalUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftQuantity,
			DenominatorNumeratorQuantity,
			>,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftQuantity,
			NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
	numeratorReciprocalLeftUnitXDenominatorNumeratorUnit: NumeratorReciprocalLeftUnit.(DenominatorNumeratorUnit) -> TargetReciprocalUnit,
	reciprocalTargetUnit: TargetReciprocalUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.inverse.left.numeratorReciprocalLeftUnitXDenominatorNumeratorUnit(
	right.unit.numerator,
).reciprocalTargetUnit().byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalMultiplyingDividedByMetricAndImperialDividingUnitWithRightAsDenominator")
infix fun <
	NumeratorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftQuantity,
			NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftQuantity,
			NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorReciprocalLeftUnitXDenominatorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndImperial<
							UndefinedQuantityType.Multiplying<
					NumeratorReciprocalLeftQuantity,
					DenominatorNumeratorQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndImperial<
				NumeratorReciprocalLeftQuantity,
					NumeratorReciprocalLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricReciprocalMultiplyingDividedByMetricDividingUnitWithRightAsDenominator")
infix fun <
	NumeratorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftQuantity,
			NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftQuantity,
			NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		numeratorReciprocalLeftUnitXDenominatorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Metric<
							UndefinedQuantityType.Multiplying<
					NumeratorReciprocalLeftQuantity,
					DenominatorNumeratorQuantity,
					>,
							UndefinedMultipliedUnit.Metric<
				NumeratorReciprocalLeftQuantity,
					NumeratorReciprocalLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialReciprocalMultiplyingDividedByImperialDividingUnitWithRightAsDenominator")
infix fun <
	NumeratorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftQuantity,
			NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftQuantity,
			NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorReciprocalLeftUnitXDenominatorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Imperial<
							UndefinedQuantityType.Multiplying<
					NumeratorReciprocalLeftQuantity,
					DenominatorNumeratorQuantity,
					>,
							UndefinedMultipliedUnit.Imperial<
				NumeratorReciprocalLeftQuantity,
					NumeratorReciprocalLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalMultiplyingDividedByUKImperialDividingUnitWithRightAsDenominator")
infix fun <
	NumeratorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftQuantity,
			NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftQuantity,
			NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorReciprocalLeftUnitXDenominatorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.UKImperial<
							UndefinedQuantityType.Multiplying<
					NumeratorReciprocalLeftQuantity,
					DenominatorNumeratorQuantity,
					>,
							UndefinedMultipliedUnit.UKImperial<
				NumeratorReciprocalLeftQuantity,
					NumeratorReciprocalLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalMultiplyingDividedByUSCustomaryDividingUnitWithRightAsDenominator")
infix fun <
	NumeratorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftQuantity,
			NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftQuantity,
			NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorReciprocalLeftUnitXDenominatorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.USCustomary<
							UndefinedQuantityType.Multiplying<
					NumeratorReciprocalLeftQuantity,
					DenominatorNumeratorQuantity,
					>,
							UndefinedMultipliedUnit.USCustomary<
				NumeratorReciprocalLeftQuantity,
					NumeratorReciprocalLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalMultiplyingDividedByMetricAndUKImperialDividingUnitWithRightAsDenominator")
infix fun <
	NumeratorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftQuantity,
			NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftQuantity,
			NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorReciprocalLeftUnitXDenominatorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUKImperial<
							UndefinedQuantityType.Multiplying<
					NumeratorReciprocalLeftQuantity,
					DenominatorNumeratorQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndUKImperial<
				NumeratorReciprocalLeftQuantity,
					NumeratorReciprocalLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalMultiplyingDividedByMetricAndUSCustomaryDividingUnitWithRightAsDenominator")
infix fun <
	NumeratorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
	NumeratorReciprocalRightAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorReciprocalRightUnit,
	NumeratorReciprocalUnit,
	NumeratorUnit,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftQuantity,
			NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftQuantity,
			NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		NumeratorReciprocalRightAndDenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorReciprocalLeftUnitXDenominatorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
							UndefinedQuantityType.Multiplying<
					NumeratorReciprocalLeftQuantity,
					DenominatorNumeratorQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndUSCustomary<
				NumeratorReciprocalLeftQuantity,
					NumeratorReciprocalLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}
