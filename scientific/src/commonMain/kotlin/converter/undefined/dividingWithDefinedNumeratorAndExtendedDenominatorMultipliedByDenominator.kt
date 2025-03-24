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
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Div<Wr<A>, Ex<B>> * B! -> A!

@JvmName("dividingWithDefinedNumeratorAndExtendedDenominatorMultipliedByDenominator")
fun <
	LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftNumeratorUnit : ScientificUnit<LeftNumeratorQuantity>,
	WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
	LeftNumeratorQuantity,
	LeftNumeratorUnit,
		>,
	ExtendedLeftDenominatorUnit : UndefinedExtendedUnit<
		LeftDenominatorAndRightQuantity,
		>,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		WrappedLeftNumeratorUnit,
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		ExtendedLeftDenominatorUnit,
		>,
	LeftDenominatorAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit : ScientificUnit<LeftDenominatorAndRightQuantity>,
	LeftNumeratorValue : ScientificValue<LeftNumeratorQuantity, LeftNumeratorUnit>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		>,
LeftUnit,
	>.multipliedBy(
	right: ScientificValue<LeftDenominatorAndRightQuantity, RightUnit>,
	factory: (Decimal, LeftNumeratorUnit) -> LeftNumeratorValue,
) = unit.numerator.wrapped.byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithDefinedNumeratorAndExtendedDenominatorMultipliedByMetricAndImperialDenominator")
infix fun <
	LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftNumeratorUnit,
	WrappedLeftNumeratorUnit,
	ExtendedLeftDenominatorUnit,
	LeftUnit,
	LeftDenominatorAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: ScientificValue<LeftDenominatorAndRightQuantity, RightUnit>,
) where
	LeftNumeratorUnit : DefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
	LeftNumeratorQuantity,
	LeftNumeratorUnit,
		>,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedLeftDenominatorUnit : UndefinedExtendedUnit<
		LeftDenominatorAndRightQuantity,
		>,
	ExtendedLeftDenominatorUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		>,
	ExtendedLeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	ExtendedLeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedLeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		WrappedLeftNumeratorUnit,
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		ExtendedLeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : DefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingWithDefinedNumeratorAndExtendedDenominatorMultipliedByMetricDenominator")
infix fun <
	LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftNumeratorUnit,
	WrappedLeftNumeratorUnit,
	ExtendedLeftDenominatorUnit,
	LeftUnit,
	LeftDenominatorAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: ScientificValue<LeftDenominatorAndRightQuantity, RightUnit>,
) where
	LeftNumeratorUnit : DefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
	LeftNumeratorQuantity,
	LeftNumeratorUnit,
		>,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	ExtendedLeftDenominatorUnit : UndefinedExtendedUnit<
		LeftDenominatorAndRightQuantity,
		>,
	ExtendedLeftDenominatorUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		>,
	ExtendedLeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		WrappedLeftNumeratorUnit,
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		ExtendedLeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightUnit : DefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingWithDefinedNumeratorAndExtendedDenominatorMultipliedByImperialDenominator")
infix fun <
	LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftNumeratorUnit,
	WrappedLeftNumeratorUnit,
	ExtendedLeftDenominatorUnit,
	LeftUnit,
	LeftDenominatorAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: ScientificValue<LeftDenominatorAndRightQuantity, RightUnit>,
) where
	LeftNumeratorUnit : DefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
	LeftNumeratorQuantity,
	LeftNumeratorUnit,
		>,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedLeftDenominatorUnit : UndefinedExtendedUnit<
		LeftDenominatorAndRightQuantity,
		>,
	ExtendedLeftDenominatorUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		>,
	ExtendedLeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedLeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		WrappedLeftNumeratorUnit,
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		ExtendedLeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : DefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithDefinedNumeratorAndExtendedDenominatorMultipliedByUKImperialDenominator")
infix fun <
	LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftNumeratorUnit,
	WrappedLeftNumeratorUnit,
	ExtendedLeftDenominatorUnit,
	LeftUnit,
	LeftDenominatorAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: ScientificValue<LeftDenominatorAndRightQuantity, RightUnit>,
) where
	LeftNumeratorUnit : DefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
	LeftNumeratorQuantity,
	LeftNumeratorUnit,
		>,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedLeftDenominatorUnit : UndefinedExtendedUnit<
		LeftDenominatorAndRightQuantity,
		>,
	ExtendedLeftDenominatorUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		>,
	ExtendedLeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		WrappedLeftNumeratorUnit,
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		ExtendedLeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : DefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithDefinedNumeratorAndExtendedDenominatorMultipliedByUSCustomaryDenominator")
infix fun <
	LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftNumeratorUnit,
	WrappedLeftNumeratorUnit,
	ExtendedLeftDenominatorUnit,
	LeftUnit,
	LeftDenominatorAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: ScientificValue<LeftDenominatorAndRightQuantity, RightUnit>,
) where
	LeftNumeratorUnit : DefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
	LeftNumeratorQuantity,
	LeftNumeratorUnit,
		>,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedLeftDenominatorUnit : UndefinedExtendedUnit<
		LeftDenominatorAndRightQuantity,
		>,
	ExtendedLeftDenominatorUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		>,
	ExtendedLeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		WrappedLeftNumeratorUnit,
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		ExtendedLeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : DefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithDefinedNumeratorAndExtendedDenominatorMultipliedByMetricAndUKImperialDenominator")
infix fun <
	LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftNumeratorUnit,
	WrappedLeftNumeratorUnit,
	ExtendedLeftDenominatorUnit,
	LeftUnit,
	LeftDenominatorAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: ScientificValue<LeftDenominatorAndRightQuantity, RightUnit>,
) where
	LeftNumeratorUnit : DefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
	LeftNumeratorQuantity,
	LeftNumeratorUnit,
		>,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedLeftDenominatorUnit : UndefinedExtendedUnit<
		LeftDenominatorAndRightQuantity,
		>,
	ExtendedLeftDenominatorUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		>,
	ExtendedLeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	ExtendedLeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		WrappedLeftNumeratorUnit,
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		ExtendedLeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : DefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithDefinedNumeratorAndExtendedDenominatorMultipliedByMetricAndUSCustomaryDenominator")
infix fun <
	LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftNumeratorUnit,
	WrappedLeftNumeratorUnit,
	ExtendedLeftDenominatorUnit,
	LeftUnit,
	LeftDenominatorAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: ScientificValue<LeftDenominatorAndRightQuantity, RightUnit>,
) where
	LeftNumeratorUnit : DefinedScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
	LeftNumeratorQuantity,
	LeftNumeratorUnit,
		>,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	ExtendedLeftDenominatorUnit : UndefinedExtendedUnit<
		LeftDenominatorAndRightQuantity,
		>,
	ExtendedLeftDenominatorUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		>,
	ExtendedLeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	ExtendedLeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		WrappedLeftNumeratorUnit,
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		ExtendedLeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : DefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericDividingWithDefinedNumeratorAndExtendedDenominatorMultipliedByGenericDenominator")
infix fun <
	LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftNumeratorUnit : DefinedScientificUnit<LeftNumeratorQuantity>,
	WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
	LeftNumeratorQuantity,
	LeftNumeratorUnit,
		>,
	ExtendedLeftDenominatorUnit : UndefinedExtendedUnit<
		LeftDenominatorAndRightQuantity,
		>,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		WrappedLeftNumeratorUnit,
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		ExtendedLeftDenominatorUnit,
		>,
	LeftDenominatorAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightUnit : DefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		UndefinedQuantityType.Extended<
			LeftDenominatorAndRightQuantity,
			>,
		>,
LeftUnit,
	>.genericMultipliedByGeneric(
	right: ScientificValue<LeftDenominatorAndRightQuantity, RightUnit>,
) =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}
