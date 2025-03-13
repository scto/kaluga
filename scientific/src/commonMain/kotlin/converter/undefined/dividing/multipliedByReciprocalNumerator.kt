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

package com.splendo.kaluga.scientific.converter.undefined.dividing

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultUndefinedScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

fun <
	LeftNumeratorAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftNumeratorAndRightReciprocalUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightReciprocalQuantity, LeftNumeratorAndRightReciprocalUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
	RightUnit : UndefinedReciprocalUnit<LeftNumeratorAndRightReciprocalQuantity, LeftNumeratorAndRightReciprocalUnit>,
	TargetUnit : UndefinedReciprocalUnit<LeftDenominatorQuantity, LeftDenominatorUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftDenominatorQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightReciprocalQuantity, LeftDenominatorQuantity>, LeftUnit>.multipliedByReciprocalNumerator(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftNumeratorAndRightReciprocalQuantity>, RightUnit>,
	reciprocalTargetUnit: LeftDenominatorUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.denominator.reciprocalTargetUnit().byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultipliedByMetricAndImperialReciprocalNumerator")
infix operator fun <
	LeftNumeratorAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftNumeratorAndRightReciprocalUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightReciprocalQuantity, LeftDenominatorQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftNumeratorAndRightReciprocalQuantity>, RightUnit>,
) where
	LeftNumeratorAndRightReciprocalUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	LeftNumeratorAndRightReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorAndRightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorAndRightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightReciprocalQuantity, LeftNumeratorAndRightReciprocalUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<LeftNumeratorAndRightReciprocalQuantity, LeftNumeratorAndRightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByReciprocalNumerator(
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

@JvmName("metricMultipliedByMetricReciprocalNumerator")
infix operator fun <
	LeftNumeratorAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftNumeratorAndRightReciprocalUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightReciprocalQuantity, LeftDenominatorQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftNumeratorAndRightReciprocalQuantity>, RightUnit>,
) where
	LeftNumeratorAndRightReciprocalUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	LeftNumeratorAndRightReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightReciprocalQuantity, LeftNumeratorAndRightReciprocalUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedReciprocalUnit<LeftNumeratorAndRightReciprocalQuantity, LeftNumeratorAndRightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedByReciprocalNumerator(
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

@JvmName("imperialMultipliedByImperialReciprocalNumerator")
infix operator fun <
	LeftNumeratorAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftNumeratorAndRightReciprocalUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightReciprocalQuantity, LeftDenominatorQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftNumeratorAndRightReciprocalQuantity>, RightUnit>,
) where
	LeftNumeratorAndRightReciprocalUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	LeftNumeratorAndRightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorAndRightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightReciprocalQuantity, LeftNumeratorAndRightReciprocalUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<LeftNumeratorAndRightReciprocalQuantity, LeftNumeratorAndRightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByReciprocalNumerator(
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

@JvmName("ukImperialMultipliedByUKImperialReciprocalNumerator")
infix operator fun <
	LeftNumeratorAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftNumeratorAndRightReciprocalUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightReciprocalQuantity, LeftDenominatorQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftNumeratorAndRightReciprocalQuantity>, RightUnit>,
) where
	LeftNumeratorAndRightReciprocalUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	LeftNumeratorAndRightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightReciprocalQuantity, LeftNumeratorAndRightReciprocalUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<LeftNumeratorAndRightReciprocalQuantity, LeftNumeratorAndRightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedByReciprocalNumerator(
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

@JvmName("usCustomaryMultipliedByUSCustomaryReciprocalNumerator")
infix operator fun <
	LeftNumeratorAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftNumeratorAndRightReciprocalUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightReciprocalQuantity, LeftDenominatorQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftNumeratorAndRightReciprocalQuantity>, RightUnit>,
) where
	LeftNumeratorAndRightReciprocalUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	LeftNumeratorAndRightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightReciprocalQuantity, LeftNumeratorAndRightReciprocalUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<LeftNumeratorAndRightReciprocalQuantity, LeftNumeratorAndRightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByReciprocalNumerator(
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

@JvmName("metricAndUKImperialMultipliedByMetricAndUKImperialReciprocalNumerator")
infix operator fun <
	LeftNumeratorAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftNumeratorAndRightReciprocalUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightReciprocalQuantity, LeftDenominatorQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftNumeratorAndRightReciprocalQuantity>, RightUnit>,
) where
	LeftNumeratorAndRightReciprocalUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	LeftNumeratorAndRightReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorAndRightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightReciprocalQuantity, LeftNumeratorAndRightReciprocalUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<LeftNumeratorAndRightReciprocalQuantity, LeftNumeratorAndRightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedByReciprocalNumerator(
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

@JvmName("metricAndUSCustomaryMultipliedByMetricAndUSCustomaryReciprocalNumerator")
infix operator fun <
	LeftNumeratorAndRightReciprocalQuantity : UndefinedQuantityType,
	LeftNumeratorAndRightReciprocalUnit,
	LeftDenominatorQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorAndRightReciprocalQuantity, LeftDenominatorQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftNumeratorAndRightReciprocalQuantity>, RightUnit>,
) where
	LeftNumeratorAndRightReciprocalUnit : UndefinedScientificUnit<LeftNumeratorAndRightReciprocalQuantity>,
	LeftNumeratorAndRightReciprocalUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorAndRightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorAndRightReciprocalQuantity, LeftNumeratorAndRightReciprocalUnit, LeftDenominatorQuantity, LeftDenominatorUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<LeftNumeratorAndRightReciprocalQuantity, LeftNumeratorAndRightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByReciprocalNumerator(
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

