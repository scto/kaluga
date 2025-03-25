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

// Inv<Mul<A, A>> / Div<B, A> -> Inv<Mul<A, B>>

@JvmName("reciprocalSquaredDividedByDividingUnitWithRootAsDenominator")
fun <
	NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	TargetReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalLeftUnit,
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		>,
	TargetUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			DenominatorNumeratorQuantity,
			>,
		TargetReciprocalUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			DenominatorNumeratorQuantity,
			>,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
	numeratorReciprocalLeftUnitXDenominatorNumeratorUnit: NumeratorReciprocalLeftUnit.(DenominatorNumeratorUnit) -> TargetReciprocalUnit,
	reciprocalTargetUnit: TargetReciprocalUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.inverse.left.numeratorReciprocalLeftUnitXDenominatorNumeratorUnit(
	right.unit.numerator,
).reciprocalTargetUnit().byDividing(this, right, factory)

@JvmName("metricAndImperialReciprocalSquaredDividedByMetricAndImperialDividingUnitWithRootAsDenominator")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
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
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
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
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
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
					NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
					DenominatorNumeratorQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndImperial<
				NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
					NumeratorReciprocalLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricReciprocalSquaredDividedByMetricDividingUnitWithRootAsDenominator")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
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
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
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
					NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
					DenominatorNumeratorQuantity,
					>,
							UndefinedMultipliedUnit.Metric<
				NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
					NumeratorReciprocalLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialReciprocalSquaredDividedByImperialDividingUnitWithRootAsDenominator")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
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
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
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
					NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
					DenominatorNumeratorQuantity,
					>,
							UndefinedMultipliedUnit.Imperial<
				NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
					NumeratorReciprocalLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalSquaredDividedByUKImperialDividingUnitWithRootAsDenominator")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
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
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
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
					NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
					DenominatorNumeratorQuantity,
					>,
							UndefinedMultipliedUnit.UKImperial<
				NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
					NumeratorReciprocalLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalSquaredDividedByUSCustomaryDividingUnitWithRootAsDenominator")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
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
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
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
					NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
					DenominatorNumeratorQuantity,
					>,
							UndefinedMultipliedUnit.USCustomary<
				NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
					NumeratorReciprocalLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalSquaredDividedByMetricAndUKImperialDividingUnitWithRootAsDenominator")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
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
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
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
					NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
					DenominatorNumeratorQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndUKImperial<
				NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
					NumeratorReciprocalLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalSquaredDividedByMetricAndUSCustomaryDividingUnitWithRootAsDenominator")
infix fun <
	NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftUnit,
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
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		DenominatorNumeratorQuantity,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorReciprocalLeftUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalRightUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalLeftUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
		NumeratorReciprocalRightUnit,
		>,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInMetric,
	NumeratorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
			>,
		NumeratorReciprocalUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		DenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
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
					NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
					DenominatorNumeratorQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndUSCustomary<
				NumeratorReciprocalLeftAndRightAndDenominatorDenominatorQuantity,
					NumeratorReciprocalLeftUnit,
					DenominatorNumeratorQuantity,
					DenominatorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}
