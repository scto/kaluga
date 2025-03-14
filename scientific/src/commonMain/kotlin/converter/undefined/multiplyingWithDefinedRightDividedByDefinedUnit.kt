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
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Mul<A, Wr<B>> / B! -> A

@JvmName("multiplyingWithDefinedRightDividedByDefinedUnit")
fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightAndDenominatorUnit : ScientificUnit<NumeratorRightAndDenominatorQuantity>,
	WrappedNumeratorRightAndDenominatorUnit : WrappedUndefinedExtendedUnit<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftQuantity, NumeratorLeftUnit, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>, WrappedNumeratorRightAndDenominatorUnit>,
	NumeratorLeftValue : UndefinedScientificValue<NumeratorLeftQuantity, NumeratorLeftUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>>, NumeratorUnit>.div(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
	factory: (Decimal, NumeratorLeftUnit) -> NumeratorLeftValue
) = unit.left.byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingWithDefinedRightDividedByMetricAndImperialDefinedUnit")
infix operator fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightAndDenominatorUnit,
	WrappedNumeratorRightAndDenominatorUnit,
	NumeratorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>>, NumeratorUnit>.div(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightAndDenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorRightAndDenominatorUnit : WrappedUndefinedExtendedUnit<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftQuantity, NumeratorLeftUnit, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>, WrappedNumeratorRightAndDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary =
	div(right) {
		value: Decimal,
		unit: NumeratorLeftUnit
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricMultiplyingWithDefinedRightDividedByMetricDefinedUnit")
infix operator fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightAndDenominatorUnit,
	WrappedNumeratorRightAndDenominatorUnit,
	NumeratorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>>, NumeratorUnit>.div(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightAndDenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorRightAndDenominatorUnit : WrappedUndefinedExtendedUnit<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftQuantity, NumeratorLeftUnit, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>, WrappedNumeratorRightAndDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInMetric =
	div(right) {
		value: Decimal,
		unit: NumeratorLeftUnit
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialMultiplyingWithDefinedRightDividedByImperialDefinedUnit")
infix operator fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightAndDenominatorUnit,
	WrappedNumeratorRightAndDenominatorUnit,
	NumeratorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>>, NumeratorUnit>.div(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightAndDenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorRightAndDenominatorUnit : WrappedUndefinedExtendedUnit<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftQuantity, NumeratorLeftUnit, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>, WrappedNumeratorRightAndDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary =
	div(right) {
		value: Decimal,
		unit: NumeratorLeftUnit
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialMultiplyingWithDefinedRightDividedByUKImperialDefinedUnit")
infix operator fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightAndDenominatorUnit,
	WrappedNumeratorRightAndDenominatorUnit,
	NumeratorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>>, NumeratorUnit>.div(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightAndDenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorRightAndDenominatorUnit : WrappedUndefinedExtendedUnit<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftQuantity, NumeratorLeftUnit, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>, WrappedNumeratorRightAndDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial =
	div(right) {
		value: Decimal,
		unit: NumeratorLeftUnit
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryMultiplyingWithDefinedRightDividedByUSCustomaryDefinedUnit")
infix operator fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightAndDenominatorUnit,
	WrappedNumeratorRightAndDenominatorUnit,
	NumeratorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>>, NumeratorUnit>.div(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightAndDenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorRightAndDenominatorUnit : WrappedUndefinedExtendedUnit<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftQuantity, NumeratorLeftUnit, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>, WrappedNumeratorRightAndDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary =
	div(right) {
		value: Decimal,
		unit: NumeratorLeftUnit
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultiplyingWithDefinedRightDividedByMetricAndUKImperialDefinedUnit")
infix operator fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightAndDenominatorUnit,
	WrappedNumeratorRightAndDenominatorUnit,
	NumeratorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>>, NumeratorUnit>.div(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightAndDenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorRightAndDenominatorUnit : WrappedUndefinedExtendedUnit<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftQuantity, NumeratorLeftUnit, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>, WrappedNumeratorRightAndDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial =
	div(right) {
		value: Decimal,
		unit: NumeratorLeftUnit
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultiplyingWithDefinedRightDividedByMetricAndUSCustomaryDefinedUnit")
infix operator fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightAndDenominatorUnit,
	WrappedNumeratorRightAndDenominatorUnit,
	NumeratorUnit
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>>, NumeratorUnit>.div(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) where
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightAndDenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorRightAndDenominatorUnit : WrappedUndefinedExtendedUnit<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorRightAndDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftQuantity, NumeratorLeftUnit, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>, WrappedNumeratorRightAndDenominatorUnit>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary =
	div(right) {
		value: Decimal,
		unit: NumeratorLeftUnit
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("genericMultiplyingWithDefinedRightDividedByGenericDefinedUnit")
infix operator fun <
	NumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorLeftUnit : UndefinedScientificUnit<NumeratorLeftQuantity>,
	NumeratorRightAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorRightAndDenominatorUnit : AbstractScientificUnit<NumeratorRightAndDenominatorQuantity>,
	WrappedNumeratorRightAndDenominatorUnit : WrappedUndefinedExtendedUnit<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftQuantity, NumeratorLeftUnit, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>, WrappedNumeratorRightAndDenominatorUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftQuantity, UndefinedQuantityType.Extended<NumeratorRightAndDenominatorQuantity>>, NumeratorUnit>.div(
	right: ScientificValue<NumeratorRightAndDenominatorQuantity, NumeratorRightAndDenominatorUnit>,
) =
	div(right) {
		value: Decimal,
		unit: NumeratorLeftUnit
		->
		DefaultUndefinedScientificValue(value, unit)
	}

