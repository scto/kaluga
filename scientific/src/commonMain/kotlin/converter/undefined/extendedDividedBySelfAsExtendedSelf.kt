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
import com.splendo.kaluga.scientific.unit.Dimensionless
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.One
import kotlin.jvm.JvmName

// Ex<A> / A! -> One

@JvmName("extendedDividedBySelfAsExtendedSelf")
fun <
	ExtendedNumeratorUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorQuantity,
		>,
	NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit : ScientificUnit<NumeratorAndDenominatorQuantity>,
	TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
	TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Extended<
		NumeratorAndDenominatorQuantity,
		>,
ExtendedNumeratorUnit,
	>.dividedBy(
	right: ScientificValue<NumeratorAndDenominatorQuantity, DenominatorUnit>,
	getDimensionless: () -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = getDimensionless().byDividing(this, right, factory)

@JvmName("metricAndImperialExtendedDividedByMetricAndImperialSelfAsExtendedSelf")
infix fun <
	ExtendedNumeratorUnit,
	NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Extended<
		NumeratorAndDenominatorQuantity,
		>,
ExtendedNumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: ScientificValue<NumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorQuantity,
		>,
	ExtendedNumeratorUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorUnit : MeasurementUsage.UsedInMetric,
	ExtendedNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : DefinedScientificUnit<NumeratorAndDenominatorQuantity>,
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

@JvmName("metricExtendedDividedByMetricSelfAsExtendedSelf")
infix fun <
	ExtendedNumeratorUnit,
	NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Extended<
		NumeratorAndDenominatorQuantity,
		>,
ExtendedNumeratorUnit,
	>.metricDividedByMetric(
	right: ScientificValue<NumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorQuantity,
		>,
	ExtendedNumeratorUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : DefinedScientificUnit<NumeratorAndDenominatorQuantity>,
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

@JvmName("imperialExtendedDividedByImperialSelfAsExtendedSelf")
infix fun <
	ExtendedNumeratorUnit,
	NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Extended<
		NumeratorAndDenominatorQuantity,
		>,
ExtendedNumeratorUnit,
	>.imperialDividedByImperial(
	right: ScientificValue<NumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorQuantity,
		>,
	ExtendedNumeratorUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	ExtendedNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : DefinedScientificUnit<NumeratorAndDenominatorQuantity>,
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

@JvmName("ukImperialExtendedDividedByUKImperialSelfAsExtendedSelf")
infix fun <
	ExtendedNumeratorUnit,
	NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Extended<
		NumeratorAndDenominatorQuantity,
		>,
ExtendedNumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: ScientificValue<NumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorQuantity,
		>,
	ExtendedNumeratorUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : DefinedScientificUnit<NumeratorAndDenominatorQuantity>,
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

@JvmName("usCustomaryExtendedDividedByUSCustomarySelfAsExtendedSelf")
infix fun <
	ExtendedNumeratorUnit,
	NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Extended<
		NumeratorAndDenominatorQuantity,
		>,
ExtendedNumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: ScientificValue<NumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorQuantity,
		>,
	ExtendedNumeratorUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : DefinedScientificUnit<NumeratorAndDenominatorQuantity>,
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

@JvmName("metricAndUKImperialExtendedDividedByMetricAndUKImperialSelfAsExtendedSelf")
infix fun <
	ExtendedNumeratorUnit,
	NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Extended<
		NumeratorAndDenominatorQuantity,
		>,
ExtendedNumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: ScientificValue<NumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorQuantity,
		>,
	ExtendedNumeratorUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorUnit : MeasurementUsage.UsedInMetric,
	ExtendedNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : DefinedScientificUnit<NumeratorAndDenominatorQuantity>,
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

@JvmName("metricAndUSCustomaryExtendedDividedByMetricAndUSCustomarySelfAsExtendedSelf")
infix fun <
	ExtendedNumeratorUnit,
	NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Extended<
		NumeratorAndDenominatorQuantity,
		>,
ExtendedNumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: ScientificValue<NumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	ExtendedNumeratorUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorQuantity,
		>,
	ExtendedNumeratorUnit : AbstractUndefinedScientificUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorQuantity,
			>,
		>,
	ExtendedNumeratorUnit : MeasurementUsage.UsedInMetric,
	ExtendedNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : DefinedScientificUnit<NumeratorAndDenominatorQuantity>,
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

@JvmName("genericExtendedDividedByGenericSelfAsExtendedSelf")
infix fun <
	ExtendedNumeratorUnit : UndefinedExtendedUnit<
		NumeratorAndDenominatorQuantity,
		>,
	NumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit : DefinedScientificUnit<NumeratorAndDenominatorQuantity>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Extended<
		NumeratorAndDenominatorQuantity,
		>,
ExtendedNumeratorUnit,
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
