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
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.Dimensionless
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// One / Inv<Wr<A>> -> A!

@JvmName("dimensionlessDividedByReciprocalDefined")
fun <
	NumeratorUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
	DenominatorReciprocalQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorReciprocalUnit : ScientificUnit<DenominatorReciprocalQuantity>,
	WrappedDenominatorReciprocalUnit : WrappedUndefinedExtendedUnit<DenominatorReciprocalQuantity, DenominatorReciprocalUnit>,
	DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Extended<DenominatorReciprocalQuantity>, WrappedDenominatorReciprocalUnit>,
	DenominatorReciprocalValue : ScientificValue<DenominatorReciprocalQuantity, DenominatorReciprocalUnit>
	> ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.dividedByReciprocalDefined(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Extended<DenominatorReciprocalQuantity>>, DenominatorUnit>,
	factory: (Decimal, DenominatorReciprocalUnit) -> DenominatorReciprocalValue
) = right.unit.inverse.wrapped.byDividing(this, right, factory)

@JvmName("metricAndImperialDimensionlessDividedByMetricAndImperialReciprocalDefined")
infix fun <
	NumeratorUnit,
	DenominatorReciprocalQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorReciprocalUnit,
	WrappedDenominatorReciprocalUnit,
	DenominatorUnit
	> ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.dividedByReciprocalDefined(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Extended<DenominatorReciprocalQuantity>>, DenominatorUnit>,
) where
	NumeratorUnit : Dimensionless,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : AbstractScientificUnit<DenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorReciprocalUnit : WrappedUndefinedExtendedUnit<DenominatorReciprocalQuantity, DenominatorReciprocalUnit>,
	WrappedDenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Extended<DenominatorReciprocalQuantity>, WrappedDenominatorReciprocalUnit>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedByReciprocalDefined(right) {
		value: Decimal,
		unit: DenominatorReciprocalUnit
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDimensionlessDividedByMetricReciprocalDefined")
infix fun <
	NumeratorUnit,
	DenominatorReciprocalQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorReciprocalUnit,
	WrappedDenominatorReciprocalUnit,
	DenominatorUnit
	> ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.dividedByReciprocalDefined(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Extended<DenominatorReciprocalQuantity>>, DenominatorUnit>,
) where
	NumeratorUnit : Dimensionless,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : AbstractScientificUnit<DenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorReciprocalUnit : WrappedUndefinedExtendedUnit<DenominatorReciprocalQuantity, DenominatorReciprocalUnit>,
	WrappedDenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Extended<DenominatorReciprocalQuantity>, WrappedDenominatorReciprocalUnit>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedByReciprocalDefined(right) {
		value: Decimal,
		unit: DenominatorReciprocalUnit
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDimensionlessDividedByImperialReciprocalDefined")
infix fun <
	NumeratorUnit,
	DenominatorReciprocalQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorReciprocalUnit,
	WrappedDenominatorReciprocalUnit,
	DenominatorUnit
	> ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.dividedByReciprocalDefined(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Extended<DenominatorReciprocalQuantity>>, DenominatorUnit>,
) where
	NumeratorUnit : Dimensionless,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : AbstractScientificUnit<DenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorReciprocalUnit : WrappedUndefinedExtendedUnit<DenominatorReciprocalQuantity, DenominatorReciprocalUnit>,
	WrappedDenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Extended<DenominatorReciprocalQuantity>, WrappedDenominatorReciprocalUnit>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedByReciprocalDefined(right) {
		value: Decimal,
		unit: DenominatorReciprocalUnit
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDimensionlessDividedByUKImperialReciprocalDefined")
infix fun <
	NumeratorUnit,
	DenominatorReciprocalQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorReciprocalUnit,
	WrappedDenominatorReciprocalUnit,
	DenominatorUnit
	> ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.dividedByReciprocalDefined(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Extended<DenominatorReciprocalQuantity>>, DenominatorUnit>,
) where
	NumeratorUnit : Dimensionless,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : AbstractScientificUnit<DenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorReciprocalUnit : WrappedUndefinedExtendedUnit<DenominatorReciprocalQuantity, DenominatorReciprocalUnit>,
	WrappedDenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Extended<DenominatorReciprocalQuantity>, WrappedDenominatorReciprocalUnit>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedByReciprocalDefined(right) {
		value: Decimal,
		unit: DenominatorReciprocalUnit
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDimensionlessDividedByUSCustomaryReciprocalDefined")
infix fun <
	NumeratorUnit,
	DenominatorReciprocalQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorReciprocalUnit,
	WrappedDenominatorReciprocalUnit,
	DenominatorUnit
	> ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.dividedByReciprocalDefined(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Extended<DenominatorReciprocalQuantity>>, DenominatorUnit>,
) where
	NumeratorUnit : Dimensionless,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : AbstractScientificUnit<DenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorReciprocalUnit : WrappedUndefinedExtendedUnit<DenominatorReciprocalQuantity, DenominatorReciprocalUnit>,
	WrappedDenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Extended<DenominatorReciprocalQuantity>, WrappedDenominatorReciprocalUnit>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedByReciprocalDefined(right) {
		value: Decimal,
		unit: DenominatorReciprocalUnit
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDimensionlessDividedByMetricAndUKImperialReciprocalDefined")
infix fun <
	NumeratorUnit,
	DenominatorReciprocalQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorReciprocalUnit,
	WrappedDenominatorReciprocalUnit,
	DenominatorUnit
	> ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.dividedByReciprocalDefined(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Extended<DenominatorReciprocalQuantity>>, DenominatorUnit>,
) where
	NumeratorUnit : Dimensionless,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : AbstractScientificUnit<DenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorReciprocalUnit : WrappedUndefinedExtendedUnit<DenominatorReciprocalQuantity, DenominatorReciprocalUnit>,
	WrappedDenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Extended<DenominatorReciprocalQuantity>, WrappedDenominatorReciprocalUnit>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedByReciprocalDefined(right) {
		value: Decimal,
		unit: DenominatorReciprocalUnit
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDimensionlessDividedByMetricAndUSCustomaryReciprocalDefined")
infix fun <
	NumeratorUnit,
	DenominatorReciprocalQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorReciprocalUnit,
	WrappedDenominatorReciprocalUnit,
	DenominatorUnit
	> ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.dividedByReciprocalDefined(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Extended<DenominatorReciprocalQuantity>>, DenominatorUnit>,
) where
	NumeratorUnit : Dimensionless,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : AbstractScientificUnit<DenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorReciprocalUnit : WrappedUndefinedExtendedUnit<DenominatorReciprocalQuantity, DenominatorReciprocalUnit>,
	WrappedDenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Extended<DenominatorReciprocalQuantity>, WrappedDenominatorReciprocalUnit>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedByReciprocalDefined(right) {
		value: Decimal,
		unit: DenominatorReciprocalUnit
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericDimensionlessDividedByGenericReciprocalDefined")
infix fun <
	NumeratorUnit : Dimensionless,
	DenominatorReciprocalQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorReciprocalUnit : AbstractScientificUnit<DenominatorReciprocalQuantity>,
	WrappedDenominatorReciprocalUnit : WrappedUndefinedExtendedUnit<DenominatorReciprocalQuantity, DenominatorReciprocalUnit>,
	DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Extended<DenominatorReciprocalQuantity>, WrappedDenominatorReciprocalUnit>
	> ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.dividedByReciprocalDefined(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Extended<DenominatorReciprocalQuantity>>, DenominatorUnit>,
) =
	dividedByReciprocalDefined(right) {
		value: Decimal,
		unit: DenominatorReciprocalUnit
		->
		DefaultScientificValue(value, unit)
	}

