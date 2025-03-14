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
import com.splendo.kaluga.scientific.unit.Dimensionless
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.One
import kotlin.jvm.JvmName

// Inv<Wr<A>> * A! -> One

@JvmName("reciprocalDefinedMultipliedByReciprocalAsSelf")
fun <
	LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalAndRightUnit : ScientificUnit<LeftReciprocalAndRightQuantity>,
	WrappedLeftReciprocalAndRightUnit : WrappedUndefinedExtendedUnit<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
	LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Extended<LeftReciprocalAndRightQuantity>, WrappedLeftReciprocalAndRightUnit>,
	TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
	TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Extended<LeftReciprocalAndRightQuantity>>, LeftUnit>.times(
	right: ScientificValue<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
	getDimensionless: () -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = getDimensionless().byMultiplying(this, right, factory)

@JvmName("metricAndImperialReciprocalDefinedMultipliedByMetricAndImperialReciprocalAsSelf")
infix operator fun <
	LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalAndRightUnit,
	WrappedLeftReciprocalAndRightUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Extended<LeftReciprocalAndRightQuantity>>, LeftUnit>.times(
	right: ScientificValue<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
) where
	LeftReciprocalAndRightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftReciprocalAndRightUnit : WrappedUndefinedExtendedUnit<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
	WrappedLeftReciprocalAndRightUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftReciprocalAndRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftReciprocalAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Extended<LeftReciprocalAndRightQuantity>, WrappedLeftReciprocalAndRightUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary =
	times(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricReciprocalDefinedMultipliedByMetricReciprocalAsSelf")
infix operator fun <
	LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalAndRightUnit,
	WrappedLeftReciprocalAndRightUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Extended<LeftReciprocalAndRightQuantity>>, LeftUnit>.times(
	right: ScientificValue<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
) where
	LeftReciprocalAndRightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftReciprocalAndRightUnit : WrappedUndefinedExtendedUnit<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
	WrappedLeftReciprocalAndRightUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Extended<LeftReciprocalAndRightQuantity>, WrappedLeftReciprocalAndRightUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric =
	times(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialReciprocalDefinedMultipliedByImperialReciprocalAsSelf")
infix operator fun <
	LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalAndRightUnit,
	WrappedLeftReciprocalAndRightUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Extended<LeftReciprocalAndRightQuantity>>, LeftUnit>.times(
	right: ScientificValue<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
) where
	LeftReciprocalAndRightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftReciprocalAndRightUnit : WrappedUndefinedExtendedUnit<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
	WrappedLeftReciprocalAndRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftReciprocalAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Extended<LeftReciprocalAndRightQuantity>, WrappedLeftReciprocalAndRightUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : MeasurementUsage.UsedInUSCustomary =
	times(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialReciprocalDefinedMultipliedByUKImperialReciprocalAsSelf")
infix operator fun <
	LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalAndRightUnit,
	WrappedLeftReciprocalAndRightUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Extended<LeftReciprocalAndRightQuantity>>, LeftUnit>.times(
	right: ScientificValue<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
) where
	LeftReciprocalAndRightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftReciprocalAndRightUnit : WrappedUndefinedExtendedUnit<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
	WrappedLeftReciprocalAndRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Extended<LeftReciprocalAndRightQuantity>, WrappedLeftReciprocalAndRightUnit>,
	LeftUnit : MeasurementUsage.UsedInUKImperial =
	times(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryReciprocalDefinedMultipliedByUSCustomaryReciprocalAsSelf")
infix operator fun <
	LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalAndRightUnit,
	WrappedLeftReciprocalAndRightUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Extended<LeftReciprocalAndRightQuantity>>, LeftUnit>.times(
	right: ScientificValue<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
) where
	LeftReciprocalAndRightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftReciprocalAndRightUnit : WrappedUndefinedExtendedUnit<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
	WrappedLeftReciprocalAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Extended<LeftReciprocalAndRightQuantity>, WrappedLeftReciprocalAndRightUnit>,
	LeftUnit : MeasurementUsage.UsedInUSCustomary =
	times(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialReciprocalDefinedMultipliedByMetricAndUKImperialReciprocalAsSelf")
infix operator fun <
	LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalAndRightUnit,
	WrappedLeftReciprocalAndRightUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Extended<LeftReciprocalAndRightQuantity>>, LeftUnit>.times(
	right: ScientificValue<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
) where
	LeftReciprocalAndRightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedLeftReciprocalAndRightUnit : WrappedUndefinedExtendedUnit<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
	WrappedLeftReciprocalAndRightUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftReciprocalAndRightUnit : MeasurementUsage.UsedInUKImperial,
	LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Extended<LeftReciprocalAndRightQuantity>, WrappedLeftReciprocalAndRightUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUKImperial =
	times(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryReciprocalDefinedMultipliedByMetricAndUSCustomaryReciprocalAsSelf")
infix operator fun <
	LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalAndRightUnit,
	WrappedLeftReciprocalAndRightUnit,
	LeftUnit
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Extended<LeftReciprocalAndRightQuantity>>, LeftUnit>.times(
	right: ScientificValue<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
) where
	LeftReciprocalAndRightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInMetric,
	LeftReciprocalAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedLeftReciprocalAndRightUnit : WrappedUndefinedExtendedUnit<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
	WrappedLeftReciprocalAndRightUnit : MeasurementUsage.UsedInMetric,
	WrappedLeftReciprocalAndRightUnit : MeasurementUsage.UsedInUSCustomary,
	LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Extended<LeftReciprocalAndRightQuantity>, WrappedLeftReciprocalAndRightUnit>,
	LeftUnit : MeasurementUsage.UsedInMetric,
	LeftUnit : MeasurementUsage.UsedInUSCustomary =
	times(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("genericReciprocalDefinedMultipliedByGenericReciprocalAsSelf")
infix operator fun <
	LeftReciprocalAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalAndRightUnit : AbstractScientificUnit<LeftReciprocalAndRightQuantity>,
	WrappedLeftReciprocalAndRightUnit : WrappedUndefinedExtendedUnit<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
	LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Extended<LeftReciprocalAndRightQuantity>, WrappedLeftReciprocalAndRightUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Extended<LeftReciprocalAndRightQuantity>>, LeftUnit>.times(
	right: ScientificValue<LeftReciprocalAndRightQuantity, LeftReciprocalAndRightUnit>,
) =
	times(
		right,
		getDimensionless = { One },
	) {
		value: Decimal,
		unit: One
		->
		DefaultScientificValue(value, unit)
	}

