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

package com.splendo.kaluga.scientific.converter.undefined.defined

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultUndefinedScientificValue
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

fun <
	LeftAndRightReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftAndRightReciprocalLeftUnit : ScientificUnit<LeftAndRightReciprocalLeftQuantity>,
	WrappedLeftAndRightReciprocalLeftUnit : WrappedUndefinedExtendedUnit<LeftAndRightReciprocalLeftQuantity, LeftAndRightReciprocalLeftUnit>,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, WrappedLeftAndRightReciprocalLeftUnit, RightReciprocalRightQuantity, RightReciprocalRightUnit>,
	RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, RightReciprocalRightQuantity>, RightReciprocalUnit>,
	TargetUnit : UndefinedReciprocalUnit<RightReciprocalRightQuantity, RightReciprocalRightUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Reciprocal<RightReciprocalRightQuantity>, TargetUnit>
	> ScientificValue<LeftAndRightReciprocalLeftQuantity, LeftAndRightReciprocalLeftUnit>.multipliedByReciprocalMultiplyingUnitWithSelfAsLeft(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, RightReciprocalRightQuantity>>, RightUnit>,
	reciprocalTargetUnit: RightReciprocalRightUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = right.unit.inverse.right.reciprocalTargetUnit().byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultipliedByMetricAndImperialReciprocalMultiplyingUnitWithSelfAsLeft")
infix operator fun <
	LeftAndRightReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftAndRightReciprocalLeftUnit,
	WrappedLeftAndRightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit
	> ScientificValue<LeftAndRightReciprocalLeftQuantity, LeftAndRightReciprocalLeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, RightReciprocalRightQuantity>>, RightUnit>,
) where
	LeftAndRightReciprocalLeftUnit : AbstractScientificUnit<LeftAndRightReciprocalLeftQuantity>,
	LeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftAndRightReciprocalLeftUnit : WrappedUndefinedExtendedUnit<LeftAndRightReciprocalLeftQuantity, LeftAndRightReciprocalLeftUnit>,
	WrappedLeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, WrappedLeftAndRightReciprocalLeftUnit, RightReciprocalRightQuantity, RightReciprocalRightUnit>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, RightReciprocalRightQuantity>, RightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByReciprocalMultiplyingUnitWithSelfAsLeft(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndImperial<
			RightReciprocalRightQuantity,
							RightReciprocalRightUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricMultipliedByMetricReciprocalMultiplyingUnitWithSelfAsLeft")
infix operator fun <
	LeftAndRightReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftAndRightReciprocalLeftUnit,
	WrappedLeftAndRightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit
	> ScientificValue<LeftAndRightReciprocalLeftQuantity, LeftAndRightReciprocalLeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, RightReciprocalRightQuantity>>, RightUnit>,
) where
	LeftAndRightReciprocalLeftUnit : AbstractScientificUnit<LeftAndRightReciprocalLeftQuantity>,
	LeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftAndRightReciprocalLeftUnit : WrappedUndefinedExtendedUnit<LeftAndRightReciprocalLeftQuantity, LeftAndRightReciprocalLeftUnit>,
	WrappedLeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, WrappedLeftAndRightReciprocalLeftUnit, RightReciprocalRightQuantity, RightReciprocalRightUnit>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, RightReciprocalRightQuantity>, RightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedByReciprocalMultiplyingUnitWithSelfAsLeft(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Metric<
			RightReciprocalRightQuantity,
							RightReciprocalRightUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialMultipliedByImperialReciprocalMultiplyingUnitWithSelfAsLeft")
infix operator fun <
	LeftAndRightReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftAndRightReciprocalLeftUnit,
	WrappedLeftAndRightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit
	> ScientificValue<LeftAndRightReciprocalLeftQuantity, LeftAndRightReciprocalLeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, RightReciprocalRightQuantity>>, RightUnit>,
) where
	LeftAndRightReciprocalLeftUnit : AbstractScientificUnit<LeftAndRightReciprocalLeftQuantity>,
	LeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftAndRightReciprocalLeftUnit : WrappedUndefinedExtendedUnit<LeftAndRightReciprocalLeftQuantity, LeftAndRightReciprocalLeftUnit>,
	WrappedLeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, WrappedLeftAndRightReciprocalLeftUnit, RightReciprocalRightQuantity, RightReciprocalRightUnit>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, RightReciprocalRightQuantity>, RightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByReciprocalMultiplyingUnitWithSelfAsLeft(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Imperial<
			RightReciprocalRightQuantity,
							RightReciprocalRightUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialMultipliedByUKImperialReciprocalMultiplyingUnitWithSelfAsLeft")
infix operator fun <
	LeftAndRightReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftAndRightReciprocalLeftUnit,
	WrappedLeftAndRightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit
	> ScientificValue<LeftAndRightReciprocalLeftQuantity, LeftAndRightReciprocalLeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, RightReciprocalRightQuantity>>, RightUnit>,
) where
	LeftAndRightReciprocalLeftUnit : AbstractScientificUnit<LeftAndRightReciprocalLeftQuantity>,
	LeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftAndRightReciprocalLeftUnit : WrappedUndefinedExtendedUnit<LeftAndRightReciprocalLeftQuantity, LeftAndRightReciprocalLeftUnit>,
	WrappedLeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, WrappedLeftAndRightReciprocalLeftUnit, RightReciprocalRightQuantity, RightReciprocalRightUnit>,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, RightReciprocalRightQuantity>, RightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedByReciprocalMultiplyingUnitWithSelfAsLeft(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.UKImperial<
			RightReciprocalRightQuantity,
							RightReciprocalRightUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryMultipliedByUSCustomaryReciprocalMultiplyingUnitWithSelfAsLeft")
infix operator fun <
	LeftAndRightReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftAndRightReciprocalLeftUnit,
	WrappedLeftAndRightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit
	> ScientificValue<LeftAndRightReciprocalLeftQuantity, LeftAndRightReciprocalLeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, RightReciprocalRightQuantity>>, RightUnit>,
) where
	LeftAndRightReciprocalLeftUnit : AbstractScientificUnit<LeftAndRightReciprocalLeftQuantity>,
	LeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftAndRightReciprocalLeftUnit : WrappedUndefinedExtendedUnit<LeftAndRightReciprocalLeftQuantity, LeftAndRightReciprocalLeftUnit>,
	WrappedLeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, WrappedLeftAndRightReciprocalLeftUnit, RightReciprocalRightQuantity, RightReciprocalRightUnit>,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, RightReciprocalRightQuantity>, RightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByReciprocalMultiplyingUnitWithSelfAsLeft(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.USCustomary<
			RightReciprocalRightQuantity,
							RightReciprocalRightUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultipliedByMetricAndUKImperialReciprocalMultiplyingUnitWithSelfAsLeft")
infix operator fun <
	LeftAndRightReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftAndRightReciprocalLeftUnit,
	WrappedLeftAndRightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit
	> ScientificValue<LeftAndRightReciprocalLeftQuantity, LeftAndRightReciprocalLeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, RightReciprocalRightQuantity>>, RightUnit>,
) where
	LeftAndRightReciprocalLeftUnit : AbstractScientificUnit<LeftAndRightReciprocalLeftQuantity>,
	LeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftAndRightReciprocalLeftUnit : WrappedUndefinedExtendedUnit<LeftAndRightReciprocalLeftQuantity, LeftAndRightReciprocalLeftUnit>,
	WrappedLeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUKImperial,
	RightReciprocalUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, WrappedLeftAndRightReciprocalLeftUnit, RightReciprocalRightQuantity, RightReciprocalRightUnit>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, RightReciprocalRightQuantity>, RightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedByReciprocalMultiplyingUnitWithSelfAsLeft(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUKImperial<
			RightReciprocalRightQuantity,
							RightReciprocalRightUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultipliedByMetricAndUSCustomaryReciprocalMultiplyingUnitWithSelfAsLeft")
infix operator fun <
	LeftAndRightReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftAndRightReciprocalLeftUnit,
	WrappedLeftAndRightReciprocalLeftUnit,
	RightReciprocalRightQuantity : UndefinedQuantityType,
	RightReciprocalRightUnit,
	RightReciprocalUnit,
	RightUnit
	> ScientificValue<LeftAndRightReciprocalLeftQuantity, LeftAndRightReciprocalLeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, RightReciprocalRightQuantity>>, RightUnit>,
) where
	LeftAndRightReciprocalLeftUnit : AbstractScientificUnit<LeftAndRightReciprocalLeftQuantity>,
	LeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	LeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftAndRightReciprocalLeftUnit : WrappedUndefinedExtendedUnit<LeftAndRightReciprocalLeftQuantity, LeftAndRightReciprocalLeftUnit>,
	WrappedLeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftAndRightReciprocalLeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalRightUnit : UndefinedScientificUnit<RightReciprocalRightQuantity>,
	RightReciprocalRightUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalRightUnit : MeasurementUsage.UsedInUSCustomary,
	RightReciprocalUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, WrappedLeftAndRightReciprocalLeftUnit, RightReciprocalRightQuantity, RightReciprocalRightUnit>,
	RightReciprocalUnit : MeasurementUsage.UsedInMetric,
	RightReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftAndRightReciprocalLeftQuantity>, RightReciprocalRightQuantity>, RightReciprocalUnit>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedByReciprocalMultiplyingUnitWithSelfAsLeft(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
			RightReciprocalRightQuantity,
							RightReciprocalRightUnit>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

