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

package com.splendo.kaluga.scientific.converter.undefined.multiplying.both.defined

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

fun <
	NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit : ScientificUnit<NumeratorLeftQuantity>,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<NumeratorLeftQuantity, NumeratorLeftUnit>,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightAndDenominatorUnit : ScientificUnit<NumeratorRightAndDenominatorQuantity>,
	WrappedNumeratorRightAndDenominatorUnit : WrappedUndefinedExtendedUnit<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
	NumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, WrappedNumeratorLeftUnit, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>, WrappedNumeratorRightAndDenominatorUnit>,
	NumeratorLeftValue : ScientificValue<NumeratorLeftQuantity, NumeratorLeftUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>>, NumeratorUnit>.dividedByRight(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
	factory: (Decimal, NumeratorLeftUnit) -> NumeratorLeftValue
) = unit.left.wrapped.byDividing(this, right, factory)

@JvmName("metricAndImperialDividedByMetricAndImperialRight")
infix operator fun <
	NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightAndDenominatorUnit,
	WrappedNumeratorRightAndDenominatorUnit,
	NumeratorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>>, NumeratorUnit>.div(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<NumeratorLeftQuantity, NumeratorLeftUnit>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightAndDenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorRightAndDenominatorUnit : WrappedUndefinedExtendedUnit<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, WrappedNumeratorLeftUnit, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>, WrappedNumeratorRightAndDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedByRight(right) {
		value: Decimal,
		unit: NumeratorLeftUnit
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividedByMetricRight")
infix operator fun <
	NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightAndDenominatorUnit,
	WrappedNumeratorRightAndDenominatorUnit,
	NumeratorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>>, NumeratorUnit>.div(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<NumeratorLeftQuantity, NumeratorLeftUnit>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightAndDenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorRightAndDenominatorUnit : WrappedUndefinedExtendedUnit<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, WrappedNumeratorLeftUnit, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>, WrappedNumeratorRightAndDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInMetric =
	dividedByRight(right) {
		value: Decimal,
		unit: NumeratorLeftUnit
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividedByImperialRight")
infix operator fun <
	NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightAndDenominatorUnit,
	WrappedNumeratorRightAndDenominatorUnit,
	NumeratorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>>, NumeratorUnit>.div(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<NumeratorLeftQuantity, NumeratorLeftUnit>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightAndDenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorRightAndDenominatorUnit : WrappedUndefinedExtendedUnit<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, WrappedNumeratorLeftUnit, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>, WrappedNumeratorRightAndDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedByRight(right) {
		value: Decimal,
		unit: NumeratorLeftUnit
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividedByUKImperialRight")
infix operator fun <
	NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightAndDenominatorUnit,
	WrappedNumeratorRightAndDenominatorUnit,
	NumeratorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>>, NumeratorUnit>.div(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<NumeratorLeftQuantity, NumeratorLeftUnit>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightAndDenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorRightAndDenominatorUnit : WrappedUndefinedExtendedUnit<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, WrappedNumeratorLeftUnit, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>, WrappedNumeratorRightAndDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial =
	dividedByRight(right) {
		value: Decimal,
		unit: NumeratorLeftUnit
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividedByUSCustomaryRight")
infix operator fun <
	NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightAndDenominatorUnit,
	WrappedNumeratorRightAndDenominatorUnit,
	NumeratorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>>, NumeratorUnit>.div(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<NumeratorLeftQuantity, NumeratorLeftUnit>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightAndDenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorRightAndDenominatorUnit : WrappedUndefinedExtendedUnit<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, WrappedNumeratorLeftUnit, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>, WrappedNumeratorRightAndDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedByRight(right) {
		value: Decimal,
		unit: NumeratorLeftUnit
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividedByMetricAndUKImperialRight")
infix operator fun <
	NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightAndDenominatorUnit,
	WrappedNumeratorRightAndDenominatorUnit,
	NumeratorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>>, NumeratorUnit>.div(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<NumeratorLeftQuantity, NumeratorLeftUnit>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightAndDenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorRightAndDenominatorUnit : WrappedUndefinedExtendedUnit<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, WrappedNumeratorLeftUnit, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>, WrappedNumeratorRightAndDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial =
	dividedByRight(right) {
		value: Decimal,
		unit: NumeratorLeftUnit
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividedByMetricAndUSCustomaryRight")
infix operator fun <
	NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightAndDenominatorUnit,
	WrappedNumeratorRightAndDenominatorUnit,
	NumeratorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>>, NumeratorUnit>.div(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<NumeratorLeftQuantity, NumeratorLeftUnit>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightAndDenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorRightAndDenominatorUnit : WrappedUndefinedExtendedUnit<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, WrappedNumeratorLeftUnit, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>, WrappedNumeratorRightAndDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedByRight(right) {
		value: Decimal,
		unit: NumeratorLeftUnit
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericDividedByGenericRight")
infix operator fun <
	NumeratorLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftQuantity>,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<NumeratorLeftQuantity, NumeratorLeftUnit>,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightAndDenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	WrappedNumeratorRightAndDenominatorUnit : WrappedUndefinedExtendedUnit<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
	NumeratorUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, WrappedNumeratorLeftUnit, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>, WrappedNumeratorRightAndDenominatorUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<NumeratorLeftQuantity>, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>>, NumeratorUnit>.div(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) =
	dividedByRight(right) {
		value: Decimal,
		unit: NumeratorLeftUnit
		->
		DefaultScientificValue(value, unit)
	}

