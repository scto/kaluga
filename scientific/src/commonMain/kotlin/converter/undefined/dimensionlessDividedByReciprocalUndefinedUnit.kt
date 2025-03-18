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
import com.splendo.kaluga.scientific.unit.Dimensionless
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import kotlin.jvm.JvmName

// One / Inv<A> -> A

@JvmName("dimensionlessDividedByReciprocalUndefinedUnit")
fun <
	NumeratorUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
	DenominatorReciprocalQuantity : UndefinedQuantityType,
	DenominatorReciprocalUnit : UndefinedScientificUnit<DenominatorReciprocalQuantity>,
	DenominatorUnit : UndefinedReciprocalUnit<
		DenominatorReciprocalQuantity,
		DenominatorReciprocalUnit,
		>,
	DenominatorReciprocalValue : UndefinedScientificValue<
	DenominatorReciprocalQuantity,
DenominatorReciprocalUnit,
	>,
	> ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		DenominatorReciprocalQuantity,
		>,
DenominatorUnit,
	>,
	factory: (Decimal, DenominatorReciprocalUnit) -> DenominatorReciprocalValue,
) = right.unit.inverse.byDividing(this, right, factory)

@JvmName("metricAndImperialDimensionlessDividedByMetricAndImperialReciprocalUndefinedUnit")
infix fun <
	NumeratorUnit,
	DenominatorReciprocalQuantity : UndefinedQuantityType,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		DenominatorReciprocalQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : Dimensionless,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedScientificUnit<DenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		DenominatorReciprocalQuantity,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorReciprocalUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDimensionlessDividedByMetricReciprocalUndefinedUnit")
infix fun <
	NumeratorUnit,
	DenominatorReciprocalQuantity : UndefinedQuantityType,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		DenominatorReciprocalQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : Dimensionless,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : UndefinedScientificUnit<DenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedReciprocalUnit<
		DenominatorReciprocalQuantity,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorReciprocalUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDimensionlessDividedByImperialReciprocalUndefinedUnit")
infix fun <
	NumeratorUnit,
	DenominatorReciprocalQuantity : UndefinedQuantityType,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		DenominatorReciprocalQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : Dimensionless,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedScientificUnit<DenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		DenominatorReciprocalQuantity,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorReciprocalUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDimensionlessDividedByUKImperialReciprocalUndefinedUnit")
infix fun <
	NumeratorUnit,
	DenominatorReciprocalQuantity : UndefinedQuantityType,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		DenominatorReciprocalQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : Dimensionless,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : UndefinedScientificUnit<DenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedReciprocalUnit<
		DenominatorReciprocalQuantity,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorReciprocalUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDimensionlessDividedByUSCustomaryReciprocalUndefinedUnit")
infix fun <
	NumeratorUnit,
	DenominatorReciprocalQuantity : UndefinedQuantityType,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		DenominatorReciprocalQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : Dimensionless,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedScientificUnit<DenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		DenominatorReciprocalQuantity,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorReciprocalUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDimensionlessDividedByMetricAndUKImperialReciprocalUndefinedUnit")
infix fun <
	NumeratorUnit,
	DenominatorReciprocalQuantity : UndefinedQuantityType,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		DenominatorReciprocalQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : Dimensionless,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorReciprocalUnit : UndefinedScientificUnit<DenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedReciprocalUnit<
		DenominatorReciprocalQuantity,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorReciprocalUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDimensionlessDividedByMetricAndUSCustomaryReciprocalUndefinedUnit")
infix fun <
	NumeratorUnit,
	DenominatorReciprocalQuantity : UndefinedQuantityType,
	DenominatorReciprocalUnit,
	DenominatorUnit,
	> ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		DenominatorReciprocalQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : Dimensionless,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorReciprocalUnit : UndefinedScientificUnit<DenominatorReciprocalQuantity>,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInMetric,
	DenominatorReciprocalUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedReciprocalUnit<
		DenominatorReciprocalQuantity,
		DenominatorReciprocalUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorReciprocalUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("genericDimensionlessDividedByGenericReciprocalUndefinedUnit")
infix fun <
	NumeratorUnit : Dimensionless,
	DenominatorReciprocalQuantity : UndefinedQuantityType,
	DenominatorReciprocalUnit : UndefinedScientificUnit<DenominatorReciprocalQuantity>,
	DenominatorUnit : UndefinedReciprocalUnit<
		DenominatorReciprocalQuantity,
		DenominatorReciprocalUnit,
		>,
	> ScientificValue<PhysicalQuantity.Dimensionless, NumeratorUnit>.genericDividedByGeneric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		DenominatorReciprocalQuantity,
		>,
DenominatorUnit,
	>,
) =
	dividedBy(right) {
		value: Decimal,
		unit: DenominatorReciprocalUnit,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
