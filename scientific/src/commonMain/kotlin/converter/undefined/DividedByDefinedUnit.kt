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
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.asUndefined
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// A / B! -> Div<A, Wr<B>>

@JvmName("dividedByDefinedUnit")
fun <
	NumeratorQuantity : UndefinedQuantityType,
	NumeratorUnit : UndefinedScientificUnit<NumeratorQuantity>,
	DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit : ScientificUnit<DenominatorQuantity>,
	WrappedDenominatorUnit : WrappedUndefinedExtendedUnit<DenominatorQuantity, DenominatorUnit>,
	TargetUnit : UndefinedDividedUnit<NumeratorQuantity, NumeratorUnit, UndefinedQuantityType.Extended<DenominatorQuantity>, WrappedDenominatorUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorQuantity, UndefinedQuantityType.Extended<DenominatorQuantity>>, TargetUnit>
	> UndefinedScientificValue<NumeratorQuantity, NumeratorUnit>.div(
	right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
	denominatorAsUndefined: DenominatorUnit.() -> WrappedDenominatorUnit,
	numeratorUnitPerWrappedDenominatorUnit: NumeratorUnit.(WrappedDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.numeratorUnitPerWrappedDenominatorUnit(right.unit.denominatorAsUndefined()).byDividing(this, right, factory)

@JvmName("metricAndImperialDividedByMetricAndImperialDefinedUnit")
infix operator fun <
	NumeratorQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit
	> UndefinedScientificValue<NumeratorQuantity, NumeratorUnit>.div(
	right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<DenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	div(
		right,
		denominatorAsUndefined = { asUndefined() },
		numeratorUnitPerWrappedDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				NumeratorQuantity,
				NumeratorUnit,
				UndefinedQuantityType.Extended<DenominatorQuantity>,
				WrappedUndefinedExtendedUnit.MetricAndImperial<DenominatorQuantity, DenominatorUnit>
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDividedByMetricDefinedUnit")
infix operator fun <
	NumeratorQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit
	> UndefinedScientificValue<NumeratorQuantity, NumeratorUnit>.div(
	right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : AbstractScientificUnit<DenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	div(
		right,
		denominatorAsUndefined = { asUndefined() },
		numeratorUnitPerWrappedDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				NumeratorQuantity,
				NumeratorUnit,
				UndefinedQuantityType.Extended<DenominatorQuantity>,
				WrappedUndefinedExtendedUnit.Metric<DenominatorQuantity, DenominatorUnit>
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDividedByImperialDefinedUnit")
infix operator fun <
	NumeratorQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit
	> UndefinedScientificValue<NumeratorQuantity, NumeratorUnit>.div(
	right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<DenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	div(
		right,
		denominatorAsUndefined = { asUndefined() },
		numeratorUnitPerWrappedDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				NumeratorQuantity,
				NumeratorUnit,
				UndefinedQuantityType.Extended<DenominatorQuantity>,
				WrappedUndefinedExtendedUnit.Imperial<DenominatorQuantity, DenominatorUnit>
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDividedByUKImperialDefinedUnit")
infix operator fun <
	NumeratorQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit
	> UndefinedScientificValue<NumeratorQuantity, NumeratorUnit>.div(
	right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : AbstractScientificUnit<DenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	div(
		right,
		denominatorAsUndefined = { asUndefined() },
		numeratorUnitPerWrappedDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				NumeratorQuantity,
				NumeratorUnit,
				UndefinedQuantityType.Extended<DenominatorQuantity>,
				WrappedUndefinedExtendedUnit.UKImperial<DenominatorQuantity, DenominatorUnit>
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDividedByUSCustomaryDefinedUnit")
infix operator fun <
	NumeratorQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit
	> UndefinedScientificValue<NumeratorQuantity, NumeratorUnit>.div(
	right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<DenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	div(
		right,
		denominatorAsUndefined = { asUndefined() },
		numeratorUnitPerWrappedDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				NumeratorQuantity,
				NumeratorUnit,
				UndefinedQuantityType.Extended<DenominatorQuantity>,
				WrappedUndefinedExtendedUnit.USCustomary<DenominatorQuantity, DenominatorUnit>
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividedByMetricAndUKImperialDefinedUnit")
infix operator fun <
	NumeratorQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit
	> UndefinedScientificValue<NumeratorQuantity, NumeratorUnit>.div(
	right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : AbstractScientificUnit<DenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	div(
		right,
		denominatorAsUndefined = { asUndefined() },
		numeratorUnitPerWrappedDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				NumeratorQuantity,
				NumeratorUnit,
				UndefinedQuantityType.Extended<DenominatorQuantity>,
				WrappedUndefinedExtendedUnit.MetricAndUKImperial<DenominatorQuantity, DenominatorUnit>
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividedByMetricAndUSCustomaryDefinedUnit")
infix operator fun <
	NumeratorQuantity : UndefinedQuantityType,
	NumeratorUnit,
	DenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit
	> UndefinedScientificValue<NumeratorQuantity, NumeratorUnit>.div(
	right: ScientificValue<DenominatorQuantity, DenominatorUnit>,
) where
	NumeratorUnit : UndefinedScientificUnit<NumeratorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<DenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	div(
		right,
		denominatorAsUndefined = { asUndefined() },
		numeratorUnitPerWrappedDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				NumeratorQuantity,
				NumeratorUnit,
				UndefinedQuantityType.Extended<DenominatorQuantity>,
				WrappedUndefinedExtendedUnit.MetricAndUSCustomary<DenominatorQuantity, DenominatorUnit>
			>
		->
		DefaultUndefinedScientificValue(value, unit)
	}

