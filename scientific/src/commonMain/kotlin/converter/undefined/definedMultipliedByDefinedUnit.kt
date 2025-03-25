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
import com.splendo.kaluga.scientific.unit.DefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.asUndefined
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// A! * B! -> Mul<Wr<A>, Wr<B>>

@JvmName("definedMultipliedByDefinedUnit")
fun <
	LeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit : ScientificUnit<LeftQuantity>,
	RightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit : ScientificUnit<RightQuantity>,
	WrappedLeftUnit : WrappedUndefinedExtendedUnit<
	LeftQuantity,
	LeftUnit,
		>,
	WrappedRightUnit : WrappedUndefinedExtendedUnit<
	RightQuantity,
	RightUnit,
		>,
	TargetUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			LeftQuantity,
			>,
		WrappedLeftUnit,
		UndefinedQuantityType.Extended<
			RightQuantity,
			>,
		WrappedRightUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			LeftQuantity,
			>,
		UndefinedQuantityType.Extended<
			RightQuantity,
			>,
		>,
TargetUnit,
	>,
	> ScientificValue<LeftQuantity, LeftUnit>.multipliedBy(
	right: ScientificValue<RightQuantity, RightUnit>,
	leftAsUndefined: LeftUnit.() -> WrappedLeftUnit,
	rightAsUndefined: RightUnit.() -> WrappedRightUnit,
	wrappedLeftUnitXWrappedRightUnit: WrappedLeftUnit.(WrappedRightUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.leftAsUndefined().wrappedLeftUnitXWrappedRightUnit(
	right.unit.rightAsUndefined(),
).byMultiplying(this, right, factory)

@JvmName("metricAndImperialDefinedMultipliedByMetricAndImperialDefinedUnit")
infix fun <
	LeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> ScientificValue<LeftQuantity, LeftUnit>.metricAndImperialMultipliedByMetricAndImperial(
	right: ScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : DefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : DefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftAsUndefined = { asUndefined() },
		rightAsUndefined = { asUndefined() },
		wrappedLeftUnitXWrappedRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndImperial<
			UndefinedQuantityType.Extended<
				LeftQuantity,
				>,
				WrappedUndefinedExtendedUnit.MetricAndImperial<
					LeftQuantity,
					LeftUnit,
					>,
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

@JvmName("metricDefinedMultipliedByMetricDefinedUnit")
infix fun <
	LeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> ScientificValue<LeftQuantity, LeftUnit>.metricMultipliedByMetric(
	right: ScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : DefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightUnit : DefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(
		right,
		leftAsUndefined = { asUndefined() },
		rightAsUndefined = { asUndefined() },
		wrappedLeftUnitXWrappedRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.Metric<
			UndefinedQuantityType.Extended<
				LeftQuantity,
				>,
				WrappedUndefinedExtendedUnit.Metric<
					LeftQuantity,
					LeftUnit,
					>,
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

@JvmName("imperialDefinedMultipliedByImperialDefinedUnit")
infix fun <
	LeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> ScientificValue<LeftQuantity, LeftUnit>.imperialMultipliedByImperial(
	right: ScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : DefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : DefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftAsUndefined = { asUndefined() },
		rightAsUndefined = { asUndefined() },
		wrappedLeftUnitXWrappedRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.Imperial<
			UndefinedQuantityType.Extended<
				LeftQuantity,
				>,
				WrappedUndefinedExtendedUnit.Imperial<
					LeftQuantity,
					LeftUnit,
					>,
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

@JvmName("ukImperialDefinedMultipliedByUKImperialDefinedUnit")
infix fun <
	LeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> ScientificValue<LeftQuantity, LeftUnit>.ukImperialMultipliedByUKImperial(
	right: ScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : DefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : DefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftAsUndefined = { asUndefined() },
		rightAsUndefined = { asUndefined() },
		wrappedLeftUnitXWrappedRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.UKImperial<
			UndefinedQuantityType.Extended<
				LeftQuantity,
				>,
				WrappedUndefinedExtendedUnit.UKImperial<
					LeftQuantity,
					LeftUnit,
					>,
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

@JvmName("usCustomaryDefinedMultipliedByUSCustomaryDefinedUnit")
infix fun <
	LeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> ScientificValue<LeftQuantity, LeftUnit>.usCustomaryMultipliedByUSCustomary(
	right: ScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : DefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : DefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftAsUndefined = { asUndefined() },
		rightAsUndefined = { asUndefined() },
		wrappedLeftUnitXWrappedRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.USCustomary<
			UndefinedQuantityType.Extended<
				LeftQuantity,
				>,
				WrappedUndefinedExtendedUnit.USCustomary<
					LeftQuantity,
					LeftUnit,
					>,
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

@JvmName("metricAndUKImperialDefinedMultipliedByMetricAndUKImperialDefinedUnit")
infix fun <
	LeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> ScientificValue<LeftQuantity, LeftUnit>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: ScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : DefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : DefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(
		right,
		leftAsUndefined = { asUndefined() },
		rightAsUndefined = { asUndefined() },
		wrappedLeftUnitXWrappedRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndUKImperial<
			UndefinedQuantityType.Extended<
				LeftQuantity,
				>,
				WrappedUndefinedExtendedUnit.MetricAndUKImperial<
					LeftQuantity,
					LeftUnit,
					>,
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

@JvmName("metricAndUSCustomaryDefinedMultipliedByMetricAndUSCustomaryDefinedUnit")
infix fun <
	LeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> ScientificValue<LeftQuantity, LeftUnit>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: ScientificValue<RightQuantity, RightUnit>,
) where
	LeftUnit : DefinedScientificUnit<LeftQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : DefinedScientificUnit<RightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(
		right,
		leftAsUndefined = { asUndefined() },
		rightAsUndefined = { asUndefined() },
		wrappedLeftUnitXWrappedRightUnit = { x(it) },
	) {
		value: Decimal,
		unit: UndefinedMultipliedUnit.MetricAndUSCustomary<
			UndefinedQuantityType.Extended<
				LeftQuantity,
				>,
				WrappedUndefinedExtendedUnit.MetricAndUSCustomary<
					LeftQuantity,
					LeftUnit,
					>,
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
