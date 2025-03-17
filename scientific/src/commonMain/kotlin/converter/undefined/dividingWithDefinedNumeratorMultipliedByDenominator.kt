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
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Div<Wr<A>, B> * B -> A!

@JvmName("dividingWithDefinedNumeratorMultipliedByDenominator")
fun <
	LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftNumeratorUnit : ScientificUnit<LeftNumeratorQuantity>,
	WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
	LeftNumeratorQuantity,
	LeftNumeratorUnit,
		>,
	LeftDenominatorAndRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		WrappedLeftNumeratorUnit,
		LeftDenominatorAndRightQuantity,
		LeftDenominatorUnit,
		>,
	RightUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	LeftNumeratorValue : ScientificValue<LeftNumeratorQuantity, LeftNumeratorUnit>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		LeftDenominatorAndRightQuantity,
		>,
LeftUnit,
	>.multipliedBy(
	right: UndefinedScientificValue<
	LeftDenominatorAndRightQuantity,
RightUnit,
	>,
	factory: (Decimal, LeftNumeratorUnit) -> LeftNumeratorValue,
) = unit.numerator.wrapped.byMultiplying(this, right, factory)

@JvmName("metricAndImperialDividingWithDefinedNumeratorMultipliedByMetricAndImperialDenominator")
infix fun <
	LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftNumeratorUnit,
	WrappedLeftNumeratorUnit,
	LeftDenominatorAndRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		LeftDenominatorAndRightQuantity,
		>,
LeftUnit,
	>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	LeftDenominatorAndRightQuantity,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
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
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		WrappedLeftNumeratorUnit,
		LeftDenominatorAndRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingWithDefinedNumeratorMultipliedByMetricDenominator")
infix fun <
	LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftNumeratorUnit,
	WrappedLeftNumeratorUnit,
	LeftDenominatorAndRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		LeftDenominatorAndRightQuantity,
		>,
LeftUnit,
	>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	LeftDenominatorAndRightQuantity,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
	LeftNumeratorQuantity,
	LeftNumeratorUnit,
		>,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		WrappedLeftNumeratorUnit,
		LeftDenominatorAndRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingWithDefinedNumeratorMultipliedByImperialDenominator")
infix fun <
	LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftNumeratorUnit,
	WrappedLeftNumeratorUnit,
	LeftDenominatorAndRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		LeftDenominatorAndRightQuantity,
		>,
LeftUnit,
	>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	LeftDenominatorAndRightQuantity,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
	LeftNumeratorQuantity,
	LeftNumeratorUnit,
		>,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		WrappedLeftNumeratorUnit,
		LeftDenominatorAndRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithDefinedNumeratorMultipliedByUKImperialDenominator")
infix fun <
	LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftNumeratorUnit,
	WrappedLeftNumeratorUnit,
	LeftDenominatorAndRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		LeftDenominatorAndRightQuantity,
		>,
LeftUnit,
	>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	LeftDenominatorAndRightQuantity,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
	LeftNumeratorQuantity,
	LeftNumeratorUnit,
		>,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		WrappedLeftNumeratorUnit,
		LeftDenominatorAndRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithDefinedNumeratorMultipliedByUSCustomaryDenominator")
infix fun <
	LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftNumeratorUnit,
	WrappedLeftNumeratorUnit,
	LeftDenominatorAndRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		LeftDenominatorAndRightQuantity,
		>,
LeftUnit,
	>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	LeftDenominatorAndRightQuantity,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
	LeftNumeratorQuantity,
	LeftNumeratorUnit,
		>,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		WrappedLeftNumeratorUnit,
		LeftDenominatorAndRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithDefinedNumeratorMultipliedByMetricAndUKImperialDenominator")
infix fun <
	LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftNumeratorUnit,
	WrappedLeftNumeratorUnit,
	LeftDenominatorAndRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		LeftDenominatorAndRightQuantity,
		>,
LeftUnit,
	>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	LeftDenominatorAndRightQuantity,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
	LeftNumeratorQuantity,
	LeftNumeratorUnit,
		>,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		WrappedLeftNumeratorUnit,
		LeftDenominatorAndRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithDefinedNumeratorMultipliedByMetricAndUSCustomaryDenominator")
infix fun <
	LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftNumeratorUnit,
	WrappedLeftNumeratorUnit,
	LeftDenominatorAndRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit,
	LeftUnit,
	RightUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		LeftDenominatorAndRightQuantity,
		>,
LeftUnit,
	>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	LeftDenominatorAndRightQuantity,
RightUnit,
	>,
) where
	LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
	LeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	LeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
	LeftNumeratorQuantity,
	LeftNumeratorUnit,
		>,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	LeftDenominatorUnit : MeasurementUsage.UsedInMetric,
	LeftDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		WrappedLeftNumeratorUnit,
		LeftDenominatorAndRightQuantity,
		LeftDenominatorUnit,
		>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericDividingWithDefinedNumeratorMultipliedByGenericDenominator")
infix fun <
	LeftNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftNumeratorUnit : AbstractScientificUnit<LeftNumeratorQuantity>,
	WrappedLeftNumeratorUnit : WrappedUndefinedExtendedUnit<
	LeftNumeratorQuantity,
	LeftNumeratorUnit,
		>,
	LeftDenominatorAndRightQuantity : UndefinedQuantityType,
	LeftDenominatorUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	LeftUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		WrappedLeftNumeratorUnit,
		LeftDenominatorAndRightQuantity,
		LeftDenominatorUnit,
		>,
	RightUnit : UndefinedScientificUnit<LeftDenominatorAndRightQuantity>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			LeftNumeratorQuantity,
			>,
		LeftDenominatorAndRightQuantity,
		>,
LeftUnit,
	>.genericMultipliedByGeneric(
	right: UndefinedScientificValue<
	LeftDenominatorAndRightQuantity,
RightUnit,
	>,
) =
	multipliedBy(right) {
		value: Decimal,
		unit: LeftNumeratorUnit,
		->
		DefaultScientificValue(value, unit)
	}
