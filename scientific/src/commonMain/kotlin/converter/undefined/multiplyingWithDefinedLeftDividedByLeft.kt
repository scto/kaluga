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

// Mul<Wr<A>, B> / A! -> B

@JvmName("multiplyingWithDefinedLeftDividedByLeft")
fun <
	NumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit : ScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		NumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	DenominatorUnit : ScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	NumeratorRightValue : UndefinedScientificValue<
	NumeratorRightQuantity,
NumeratorRightUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		NumeratorRightQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: ScientificValue<NumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
	factory: (Decimal, NumeratorRightUnit) -> NumeratorRightValue,
) = unit.right.byDividing(this, right, factory)

@JvmName("metricAndImperialMultiplyingWithDefinedLeftDividedByMetricAndImperialLeft")
infix fun <
	NumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		NumeratorRightQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: ScientificValue<NumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		NumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorRightUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricMultiplyingWithDefinedLeftDividedByMetricLeft")
infix fun <
	NumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		NumeratorRightQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: ScientificValue<NumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		NumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorRightUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialMultiplyingWithDefinedLeftDividedByImperialLeft")
infix fun <
	NumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		NumeratorRightQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: ScientificValue<NumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		NumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorRightUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialMultiplyingWithDefinedLeftDividedByUKImperialLeft")
infix fun <
	NumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		NumeratorRightQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: ScientificValue<NumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		NumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorRightUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryMultiplyingWithDefinedLeftDividedByUSCustomaryLeft")
infix fun <
	NumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		NumeratorRightQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: ScientificValue<NumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		NumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorRightUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialMultiplyingWithDefinedLeftDividedByMetricAndUKImperialLeft")
infix fun <
	NumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		NumeratorRightQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: ScientificValue<NumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		NumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorRightUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryMultiplyingWithDefinedLeftDividedByMetricAndUSCustomaryLeft")
infix fun <
	NumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit,
	WrappedNumeratorLeftUnit,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		NumeratorRightQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: ScientificValue<NumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	NumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		NumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorRightUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("genericMultiplyingWithDefinedLeftDividedByGenericLeft")
infix fun <
	NumeratorLeftAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorLeftUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	WrappedNumeratorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorLeftAndDenominatorQuantity,
	NumeratorLeftUnit,
		>,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		WrappedNumeratorLeftUnit,
		NumeratorRightQuantity,
		NumeratorRightUnit,
		>,
	DenominatorUnit : AbstractScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorLeftAndDenominatorQuantity,
			>,
		NumeratorRightQuantity,
		>,
NumeratorUnit,
	>.genericDividedByGeneric(
	right: ScientificValue<NumeratorLeftAndDenominatorQuantity, DenominatorUnit>,
) =
	dividedBy(right) {
		value: Decimal,
		unit: NumeratorRightUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
