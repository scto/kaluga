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
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// A! * Div<B, Wr<A>> -> B

@JvmName("definedMultipliedByDividingUnitWithSelfAsDenominator")
fun <
	LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit : ScientificUnit<LeftAndRightDenominatorQuantity>,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightDenominatorUnit : ScientificUnit<LeftAndRightDenominatorQuantity>,
	WrappedRightDenominatorUnit : WrappedUndefinedExtendedUnit<
	LeftAndRightDenominatorQuantity,
	RightDenominatorUnit,
		>,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorQuantity,
			>,
		WrappedRightDenominatorUnit,
		>,
	RightNumeratorValue : UndefinedScientificValue<
	RightNumeratorQuantity,
RightNumeratorUnit,
	>,
	> ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorQuantity,
			>,
		>,
RightUnit,
	>,
	factory: (Decimal, RightNumeratorUnit) -> RightNumeratorValue,
) = right.unit.numerator.byMultiplying(this, right, factory)

@JvmName("metricAndImperialDefinedMultipliedByMetricAndImperialDividingUnitWithSelfAsDenominator")
infix fun <
	LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	WrappedRightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.metricAndImperialMultipliedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedRightDenominatorUnit : WrappedUndefinedExtendedUnit<
	LeftAndRightDenominatorQuantity,
	RightDenominatorUnit,
		>,
	WrappedRightDenominatorUnit : MeasurementUsage.UsedInMetric,
	WrappedRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorQuantity,
			>,
		WrappedRightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: RightNumeratorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDefinedMultipliedByMetricDividingUnitWithSelfAsDenominator")
infix fun <
	LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	WrappedRightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.metricMultipliedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	WrappedRightDenominatorUnit : WrappedUndefinedExtendedUnit<
	LeftAndRightDenominatorQuantity,
	RightDenominatorUnit,
		>,
	WrappedRightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorQuantity,
			>,
		WrappedRightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric =
	multipliedBy(right) {
		value: Decimal,
		unit: RightNumeratorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDefinedMultipliedByImperialDividingUnitWithSelfAsDenominator")
infix fun <
	LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	WrappedRightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.imperialMultipliedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedRightDenominatorUnit : WrappedUndefinedExtendedUnit<
	LeftAndRightDenominatorQuantity,
	RightDenominatorUnit,
		>,
	WrappedRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorQuantity,
			>,
		WrappedRightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: RightNumeratorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDefinedMultipliedByUKImperialDividingUnitWithSelfAsDenominator")
infix fun <
	LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	WrappedRightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.ukImperialMultipliedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedRightDenominatorUnit : WrappedUndefinedExtendedUnit<
	LeftAndRightDenominatorQuantity,
	RightDenominatorUnit,
		>,
	WrappedRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorQuantity,
			>,
		WrappedRightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(right) {
		value: Decimal,
		unit: RightNumeratorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDefinedMultipliedByUSCustomaryDividingUnitWithSelfAsDenominator")
infix fun <
	LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	WrappedRightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.usCustomaryMultipliedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedRightDenominatorUnit : WrappedUndefinedExtendedUnit<
	LeftAndRightDenominatorQuantity,
	RightDenominatorUnit,
		>,
	WrappedRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorQuantity,
			>,
		WrappedRightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: RightNumeratorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDefinedMultipliedByMetricAndUKImperialDividingUnitWithSelfAsDenominator")
infix fun <
	LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	WrappedRightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.metricAndUKImperialMultipliedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	RightDenominatorUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedRightDenominatorUnit : WrappedUndefinedExtendedUnit<
	LeftAndRightDenominatorQuantity,
	RightDenominatorUnit,
		>,
	WrappedRightDenominatorUnit : MeasurementUsage.UsedInMetric,
	WrappedRightDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorQuantity,
			>,
		WrappedRightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUKImperial =
	multipliedBy(right) {
		value: Decimal,
		unit: RightNumeratorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDefinedMultipliedByMetricAndUSCustomaryDividingUnitWithSelfAsDenominator")
infix fun <
	LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit,
	RightDenominatorUnit,
	WrappedRightDenominatorUnit,
	RightUnit,
	> ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.metricAndUSCustomaryMultipliedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorQuantity,
			>,
		>,
RightUnit,
	>,
) where
	LeftUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightNumeratorUnit : MeasurementUsage.UsedInMetric,
	RightNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	RightDenominatorUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
	RightDenominatorUnit : MeasurementUsage.UsedInMetric,
	RightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedRightDenominatorUnit : WrappedUndefinedExtendedUnit<
	LeftAndRightDenominatorQuantity,
	RightDenominatorUnit,
		>,
	WrappedRightDenominatorUnit : MeasurementUsage.UsedInMetric,
	WrappedRightDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorQuantity,
			>,
		WrappedRightDenominatorUnit,
		>,
	RightUnit : MeasurementUsage.UsedInMetric,
	RightUnit : MeasurementUsage.UsedInUSCustomary =
	multipliedBy(right) {
		value: Decimal,
		unit: RightNumeratorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("genericDefinedMultipliedByGenericDividingUnitWithSelfAsDenominator")
infix fun <
	LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightDenominatorUnit : AbstractScientificUnit<LeftAndRightDenominatorQuantity>,
	WrappedRightDenominatorUnit : WrappedUndefinedExtendedUnit<
	LeftAndRightDenominatorQuantity,
	RightDenominatorUnit,
		>,
	RightUnit : UndefinedDividedUnit<
		RightNumeratorQuantity,
		RightNumeratorUnit,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorQuantity,
			>,
		WrappedRightDenominatorUnit,
		>,
	> ScientificValue<LeftAndRightDenominatorQuantity, LeftUnit>.genericMultipliedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		RightNumeratorQuantity,
		UndefinedQuantityType.Extended<
			LeftAndRightDenominatorQuantity,
			>,
		>,
RightUnit,
	>,
) =
	multipliedBy(right) {
		value: Decimal,
		unit: RightNumeratorUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
