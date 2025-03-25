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
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.DefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.asUndefined
import com.splendo.kaluga.scientific.unit.per
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Div<A, B> / C! -> Div<A, Mul<B, Wr<C>>>

@JvmName("dividingDividedByDefinedUnit")
fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit : ScientificUnit<DenominatorQuantity>,
	WrappedDenominatorUnit : WrappedUndefinedExtendedUnit<
	DenominatorQuantity,
	DenominatorUnit,
		>,
	TargetDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		UndefinedQuantityType.Extended<
			DenominatorQuantity,
			>,
		WrappedDenominatorUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorQuantity,
			UndefinedQuantityType.Extended<
				DenominatorQuantity,
				>,
			>,
		TargetDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorQuantity,
			UndefinedQuantityType.Extended<
				DenominatorQuantity,
				>,
			>,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
	denominatorAsUndefined: DenominatorUnit.() -> WrappedDenominatorUnit,
	numeratorDenominatorUnitXWrappedDenominatorUnit: NumeratorDenominatorUnit.(WrappedDenominatorUnit) -> TargetDenominatorUnit,
	numeratorNumeratorUnitPerTargetDenominatorUnit: NumeratorNumeratorUnit.(TargetDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.numeratorNumeratorUnitPerTargetDenominatorUnit(
	unit.denominator.numeratorDenominatorUnitXWrappedDenominatorUnit(
	right.unit.denominatorAsUndefined(),
),
).byDividing(this, right, factory)

@JvmName("metricAndImperialDividingDividedByMetricAndImperialDefinedUnit")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : DefinedScientificUnit<DenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorAsUndefined = { asUndefined() },
		numeratorDenominatorUnitXWrappedDenominatorUnit = { x(it) },
		numeratorNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				NumeratorNumeratorQuantity,
				NumeratorNumeratorUnit,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					UndefinedQuantityType.Extended<
						DenominatorQuantity,
						>,
					>,
				UndefinedMultipliedUnit.MetricAndImperial<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					UndefinedQuantityType.Extended<
						DenominatorQuantity,
						>,
					WrappedUndefinedExtendedUnit.MetricAndImperial<
						DenominatorQuantity,
						DenominatorUnit,
						>,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingDividedByMetricDefinedUnit")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : DefinedScientificUnit<DenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		denominatorAsUndefined = { asUndefined() },
		numeratorDenominatorUnitXWrappedDenominatorUnit = { x(it) },
		numeratorNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				NumeratorNumeratorQuantity,
				NumeratorNumeratorUnit,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					UndefinedQuantityType.Extended<
						DenominatorQuantity,
						>,
					>,
				UndefinedMultipliedUnit.Metric<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					UndefinedQuantityType.Extended<
						DenominatorQuantity,
						>,
					WrappedUndefinedExtendedUnit.Metric<
						DenominatorQuantity,
						DenominatorUnit,
						>,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingDividedByImperialDefinedUnit")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : DefinedScientificUnit<DenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorAsUndefined = { asUndefined() },
		numeratorDenominatorUnitXWrappedDenominatorUnit = { x(it) },
		numeratorNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				NumeratorNumeratorQuantity,
				NumeratorNumeratorUnit,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					UndefinedQuantityType.Extended<
						DenominatorQuantity,
						>,
					>,
				UndefinedMultipliedUnit.Imperial<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					UndefinedQuantityType.Extended<
						DenominatorQuantity,
						>,
					WrappedUndefinedExtendedUnit.Imperial<
						DenominatorQuantity,
						DenominatorUnit,
						>,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingDividedByUKImperialDefinedUnit")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : DefinedScientificUnit<DenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		denominatorAsUndefined = { asUndefined() },
		numeratorDenominatorUnitXWrappedDenominatorUnit = { x(it) },
		numeratorNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				NumeratorNumeratorQuantity,
				NumeratorNumeratorUnit,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					UndefinedQuantityType.Extended<
						DenominatorQuantity,
						>,
					>,
				UndefinedMultipliedUnit.UKImperial<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					UndefinedQuantityType.Extended<
						DenominatorQuantity,
						>,
					WrappedUndefinedExtendedUnit.UKImperial<
						DenominatorQuantity,
						DenominatorUnit,
						>,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingDividedByUSCustomaryDefinedUnit")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : DefinedScientificUnit<DenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorAsUndefined = { asUndefined() },
		numeratorDenominatorUnitXWrappedDenominatorUnit = { x(it) },
		numeratorNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				NumeratorNumeratorQuantity,
				NumeratorNumeratorUnit,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					UndefinedQuantityType.Extended<
						DenominatorQuantity,
						>,
					>,
				UndefinedMultipliedUnit.USCustomary<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					UndefinedQuantityType.Extended<
						DenominatorQuantity,
						>,
					WrappedUndefinedExtendedUnit.USCustomary<
						DenominatorQuantity,
						DenominatorUnit,
						>,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingDividedByMetricAndUKImperialDefinedUnit")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : DefinedScientificUnit<DenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		denominatorAsUndefined = { asUndefined() },
		numeratorDenominatorUnitXWrappedDenominatorUnit = { x(it) },
		numeratorNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				NumeratorNumeratorQuantity,
				NumeratorNumeratorUnit,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					UndefinedQuantityType.Extended<
						DenominatorQuantity,
						>,
					>,
				UndefinedMultipliedUnit.MetricAndUKImperial<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					UndefinedQuantityType.Extended<
						DenominatorQuantity,
						>,
					WrappedUndefinedExtendedUnit.MetricAndUKImperial<
						DenominatorQuantity,
						DenominatorUnit,
						>,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingDividedByMetricAndUSCustomaryDefinedUnit")
infix fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : DefinedScientificUnit<DenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		denominatorAsUndefined = { asUndefined() },
		numeratorDenominatorUnitXWrappedDenominatorUnit = { x(it) },
		numeratorNumeratorUnitPerTargetDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				NumeratorNumeratorQuantity,
				NumeratorNumeratorUnit,
				UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					UndefinedQuantityType.Extended<
						DenominatorQuantity,
						>,
					>,
				UndefinedMultipliedUnit.MetricAndUSCustomary<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					UndefinedQuantityType.Extended<
						DenominatorQuantity,
						>,
					WrappedUndefinedExtendedUnit.MetricAndUSCustomary<
						DenominatorQuantity,
						DenominatorUnit,
						>,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}
