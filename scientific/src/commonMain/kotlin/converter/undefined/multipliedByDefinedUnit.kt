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
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.DefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.asUndefined
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// A * B! -> Mul<A, Wr<B>>

@JvmName("multipliedByDefinedUnit")
fun <
	LeftQuantity : UndefinedQuantityType,
	LeftUnit : AbstractUndefinedScientificUnit<LeftQuantity>,
	RightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit : ScientificUnit<RightQuantity>,
	WrappedRightUnit : WrappedUndefinedExtendedUnit<
	RightQuantity,
	RightUnit,
		>,
	TargetUnit : UndefinedMultipliedUnit<
		LeftQuantity,
		LeftUnit,
		UndefinedQuantityType.Extended<
			RightQuantity,
			>,
		WrappedRightUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		LeftQuantity,
		UndefinedQuantityType.Extended<
			RightQuantity,
			>,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	LeftQuantity,
LeftUnit,
	>.multipliedBy(
	right: ScientificValue<RightQuantity, RightUnit>,
	rightAsUndefined: RightUnit.() -> WrappedRightUnit,
	leftUnitXWrappedRightUnit: LeftUnit.(WrappedRightUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.leftUnitXWrappedRightUnit(
	right.unit.rightAsUndefined(),
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialMultipliedByMetricAndImperialDefinedUnit")
infix fun <
	LeftQuantity : UndefinedQuantityType,
	LeftUnit,
	RightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	LeftQuantity,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: ScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : AbstractUndefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : DefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightAsUndefined = { asUndefined() },
		leftUnitXWrappedRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndImperial<
			LeftQuantity,
				LeftUnit,
				UndefinedQuantityType.Extended<
					RightQuantity,
					>,
				WrappedUndefinedExtendedUnit.MetricAndImperial<
					RightQuantity,
					RightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricMultipliedByMetricDefinedUnit")
infix fun <
	LeftQuantity : UndefinedQuantityType,
	LeftUnit,
	RightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	LeftQuantity,
LeftUnit,
	>.metricMultipliedByMetric(
	right: ScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : AbstractUndefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightUnit : DefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		rightAsUndefined = { asUndefined() },
		leftUnitXWrappedRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.Metric<
			LeftQuantity,
				LeftUnit,
				UndefinedQuantityType.Extended<
					RightQuantity,
					>,
				WrappedUndefinedExtendedUnit.Metric<
					RightQuantity,
					RightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialMultipliedByImperialDefinedUnit")
infix fun <
	LeftQuantity : UndefinedQuantityType,
	LeftUnit,
	RightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	LeftQuantity,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: ScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : AbstractUndefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : DefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightAsUndefined = { asUndefined() },
		leftUnitXWrappedRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.Imperial<
			LeftQuantity,
				LeftUnit,
				UndefinedQuantityType.Extended<
					RightQuantity,
					>,
				WrappedUndefinedExtendedUnit.Imperial<
					RightQuantity,
					RightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialMultipliedByUKImperialDefinedUnit")
infix fun <
	LeftQuantity : UndefinedQuantityType,
	LeftUnit,
	RightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	LeftQuantity,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: ScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : AbstractUndefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : DefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		rightAsUndefined = { asUndefined() },
		leftUnitXWrappedRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.UKImperial<
			LeftQuantity,
				LeftUnit,
				UndefinedQuantityType.Extended<
					RightQuantity,
					>,
				WrappedUndefinedExtendedUnit.UKImperial<
					RightQuantity,
					RightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryMultipliedByUSCustomaryDefinedUnit")
infix fun <
	LeftQuantity : UndefinedQuantityType,
	LeftUnit,
	RightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	LeftQuantity,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: ScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : AbstractUndefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : DefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightAsUndefined = { asUndefined() },
		leftUnitXWrappedRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.USCustomary<
			LeftQuantity,
				LeftUnit,
				UndefinedQuantityType.Extended<
					RightQuantity,
					>,
				WrappedUndefinedExtendedUnit.USCustomary<
					RightQuantity,
					RightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultipliedByMetricAndUKImperialDefinedUnit")
infix fun <
	LeftQuantity : UndefinedQuantityType,
	LeftUnit,
	RightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	LeftQuantity,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: ScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : AbstractUndefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : DefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		rightAsUndefined = { asUndefined() },
		leftUnitXWrappedRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndUKImperial<
			LeftQuantity,
				LeftUnit,
				UndefinedQuantityType.Extended<
					RightQuantity,
					>,
				WrappedUndefinedExtendedUnit.MetricAndUKImperial<
					RightQuantity,
					RightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultipliedByMetricAndUSCustomaryDefinedUnit")
infix fun <
	LeftQuantity : UndefinedQuantityType,
	LeftUnit,
	RightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	LeftQuantity,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: ScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : AbstractUndefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : DefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		rightAsUndefined = { asUndefined() },
		leftUnitXWrappedRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndUSCustomary<
			LeftQuantity,
				LeftUnit,
				UndefinedQuantityType.Extended<
					RightQuantity,
					>,
				WrappedUndefinedExtendedUnit.MetricAndUSCustomary<
					RightQuantity,
					RightUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}
