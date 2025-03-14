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
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// Div<Mul<A, B>, C> * Inv<Mul<B, A>> -> Inv<C>

@JvmName("dividingWithMultiplyingNumeratorMultipliedByReciprocalMultiplyingUnitWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
fun <
	LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
	LeftNumeratorLeftAndRightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
	LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit, LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit>,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
	RightReciprocalUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit, LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit>,
	RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>, RightReciprocalUnit>,
	TargetUnit : UndefinedReciprocalUnit<LeftDenominatorQuantity, LeftDenominatorUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftDenominatorQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftDenominatorQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>>, RightUnit>,
	reciprocalTargetUnit: LeftDenominatorUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.denominator.reciprocalTargetUnit().byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithMultiplyingNumeratorMultipliedByMetricAndImperialReciprocalMultiplyingUnitWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix operator fun <
	LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
	LeftNumeratorLeftAndRightReciprocalRightUnit,
	LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightAndRightReciprocalLeftUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftDenominatorQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>>, RightUnit>,
) where
	LeftNumeratorLeftAndRightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
	LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit, LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit, LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>, RightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	times(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndImperial<
			LeftDenominatorQuantity,
							LeftDenominatorUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDividingWithMultiplyingNumeratorMultipliedByMetricReciprocalMultiplyingUnitWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix operator fun <
	LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
	LeftNumeratorLeftAndRightReciprocalRightUnit,
	LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightAndRightReciprocalLeftUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftDenominatorQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>>, RightUnit>,
) where
	LeftNumeratorLeftAndRightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
	LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit, LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit, LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>, RightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInMetric =
	times(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Metric<
			LeftDenominatorQuantity,
							LeftDenominatorUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDividingWithMultiplyingNumeratorMultipliedByImperialReciprocalMultiplyingUnitWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix operator fun <
	LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
	LeftNumeratorLeftAndRightReciprocalRightUnit,
	LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightAndRightReciprocalLeftUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftDenominatorQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>>, RightUnit>,
) where
	LeftNumeratorLeftAndRightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
	LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit, LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit, LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>, RightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	times(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Imperial<
			LeftDenominatorQuantity,
							LeftDenominatorUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithMultiplyingNumeratorMultipliedByUKImperialReciprocalMultiplyingUnitWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix operator fun <
	LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
	LeftNumeratorLeftAndRightReciprocalRightUnit,
	LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightAndRightReciprocalLeftUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftDenominatorQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>>, RightUnit>,
) where
	LeftNumeratorLeftAndRightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
	LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit, LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit, LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>, RightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	times(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.UKImperial<
			LeftDenominatorQuantity,
							LeftDenominatorUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithMultiplyingNumeratorMultipliedByUSCustomaryReciprocalMultiplyingUnitWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix operator fun <
	LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
	LeftNumeratorLeftAndRightReciprocalRightUnit,
	LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightAndRightReciprocalLeftUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftDenominatorQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>>, RightUnit>,
) where
	LeftNumeratorLeftAndRightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
	LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit, LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit, LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit>,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>, RightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	times(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.USCustomary<
			LeftDenominatorQuantity,
							LeftDenominatorUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithMultiplyingNumeratorMultipliedByMetricAndUKImperialReciprocalMultiplyingUnitWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix operator fun <
	LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
	LeftNumeratorLeftAndRightReciprocalRightUnit,
	LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightAndRightReciprocalLeftUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftDenominatorQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>>, RightUnit>,
) where
	LeftNumeratorLeftAndRightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
	LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit, LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit, LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>, RightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	times(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUKImperial<
			LeftDenominatorQuantity,
							LeftDenominatorUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithMultiplyingNumeratorMultipliedByMetricAndUSCustomaryReciprocalMultiplyingUnitWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
infix operator fun <
	LeftNumeratorLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
	LeftNumeratorLeftAndRightReciprocalRightUnit,
	LeftNumeratorRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightAndRightReciprocalLeftUnit,
	LeftNumeratorUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightReciprocalUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftDenominatorQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>>, RightUnit>,
) where
	LeftNumeratorLeftAndRightReciprocalRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity>,
	LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorLeftAndRightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity>,
	LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorRightAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit, LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorRightAndRightReciprocalLeftQuantity>, LeftNumeratorUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorRightAndRightReciprocalLeftUnit, LeftNumeratorLeftAndRightReciprocalRightQuantity, LeftNumeratorLeftAndRightReciprocalRightUnit>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightReciprocalLeftQuantity, LeftNumeratorLeftAndRightReciprocalRightQuantity>, RightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	times(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
			LeftDenominatorQuantity,
							LeftDenominatorUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

