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
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.Dimensionless
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.One
import kotlin.jvm.JvmName

// Wr<A> / A! -> One

@JvmName("definedDividedBySelfAsDefinedSelf")
fun <
	NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit : ScientificUnit<NumeratorAndDenominatorQuantity>,
	WrappedNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorQuantity,
	NumeratorUnit,
		>,
	DenominatorUnit : ScientificUnit<NumeratorAndDenominatorQuantity>,
	TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
	TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Extended<
		NumeratorAndDenominatorQuantity,
		>,
WrappedNumeratorUnit,
	>.dividedBy(
	right: ScientificValue<NumeratorAndDenominatorQuantity, DenominatorUnit>,
	getDimensionless: () -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = getDimensionless().byDividing(this, right, factory)

@JvmName("metricAndImperialDefinedDividedByMetricAndImperialSelfAsDefinedSelf")
infix fun <
	NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	WrappedNumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Extended<
		NumeratorAndDenominatorQuantity,
		>,
WrappedNumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: ScientificValue<NumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorQuantity,
	NumeratorUnit,
		>,
	WrappedNumeratorUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<NumeratorAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDefinedDividedByMetricSelfAsDefinedSelf")
infix fun <
	NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	WrappedNumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Extended<
		NumeratorAndDenominatorQuantity,
		>,
WrappedNumeratorUnit,
	>.metricDividedByMetric(
	right: ScientificValue<NumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorQuantity,
	NumeratorUnit,
		>,
	WrappedNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : AbstractScientificUnit<NumeratorAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDefinedDividedByImperialSelfAsDefinedSelf")
infix fun <
	NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	WrappedNumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Extended<
		NumeratorAndDenominatorQuantity,
		>,
WrappedNumeratorUnit,
	>.imperialDividedByImperial(
	right: ScientificValue<NumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorQuantity,
	NumeratorUnit,
		>,
	WrappedNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<NumeratorAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDefinedDividedByUKImperialSelfAsDefinedSelf")
infix fun <
	NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	WrappedNumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Extended<
		NumeratorAndDenominatorQuantity,
		>,
WrappedNumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: ScientificValue<NumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorQuantity,
	NumeratorUnit,
		>,
	WrappedNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : AbstractScientificUnit<NumeratorAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDefinedDividedByUSCustomarySelfAsDefinedSelf")
infix fun <
	NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	WrappedNumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Extended<
		NumeratorAndDenominatorQuantity,
		>,
WrappedNumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: ScientificValue<NumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorQuantity,
	NumeratorUnit,
		>,
	WrappedNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<NumeratorAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDefinedDividedByMetricAndUKImperialSelfAsDefinedSelf")
infix fun <
	NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	WrappedNumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Extended<
		NumeratorAndDenominatorQuantity,
		>,
WrappedNumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: ScientificValue<NumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorQuantity,
	NumeratorUnit,
		>,
	WrappedNumeratorUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : AbstractScientificUnit<NumeratorAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDefinedDividedByMetricAndUSCustomarySelfAsDefinedSelf")
infix fun <
	NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	WrappedNumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Extended<
		NumeratorAndDenominatorQuantity,
		>,
WrappedNumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: ScientificValue<NumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorQuantity,
	NumeratorUnit,
		>,
	WrappedNumeratorUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<NumeratorAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericDefinedDividedByGenericSelfAsDefinedSelf")
infix fun <
	NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit : AbstractScientificUnit<NumeratorAndDenominatorQuantity>,
	WrappedNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorQuantity,
	NumeratorUnit,
		>,
	DenominatorUnit : AbstractScientificUnit<NumeratorAndDenominatorQuantity>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Extended<
		NumeratorAndDenominatorQuantity,
		>,
WrappedNumeratorUnit,
	>.genericDividedByGeneric(
	right: ScientificValue<NumeratorAndDenominatorQuantity, DenominatorUnit>,
) =
	dividedBy(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One,
		->
		DefaultScientificValue(value, unit)
	}
