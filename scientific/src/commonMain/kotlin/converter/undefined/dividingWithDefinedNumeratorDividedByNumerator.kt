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
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// Div<Wr<A>, B> / A! -> Inv<B>

@JvmName("dividingWithDefinedNumeratorDividedByNumerator")
fun <
	NumeratorNumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorNumeratorUnit : ScientificUnit<NumeratorNumeratorAndDenominatorQuantity>,
	WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorNumeratorAndDenominatorQuantity,
	NumeratorNumeratorUnit,
		>,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorAndDenominatorQuantity,
			>,
		WrappedNumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	DenominatorUnit : ScientificUnit<NumeratorNumeratorAndDenominatorQuantity>,
	TargetUnit : UndefinedReciprocalUnit<
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		NumeratorDenominatorQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorAndDenominatorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: ScientificValue<NumeratorNumeratorAndDenominatorQuantity, DenominatorUnit>,
	reciprocalTargetUnit: NumeratorDenominatorUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.denominator.reciprocalTargetUnit().byDividing(this, right, factory)

@JvmName("metricAndImperialDividingWithDefinedNumeratorDividedByMetricAndImperialNumerator")
infix fun <
	NumeratorNumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorNumeratorUnit,
	WrappedNumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorAndDenominatorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: ScientificValue<NumeratorNumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorAndDenominatorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorNumeratorAndDenominatorQuantity,
	NumeratorNumeratorUnit,
		>,
	WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorAndDenominatorQuantity,
			>,
		WrappedNumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<NumeratorNumeratorAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndImperial<
							NumeratorDenominatorQuantity,
							NumeratorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDividingWithDefinedNumeratorDividedByMetricNumerator")
infix fun <
	NumeratorNumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorNumeratorUnit,
	WrappedNumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorAndDenominatorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: ScientificValue<NumeratorNumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorAndDenominatorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorNumeratorAndDenominatorQuantity,
	NumeratorNumeratorUnit,
		>,
	WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorAndDenominatorQuantity,
			>,
		WrappedNumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : AbstractScientificUnit<NumeratorNumeratorAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Metric<
							NumeratorDenominatorQuantity,
							NumeratorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDividingWithDefinedNumeratorDividedByImperialNumerator")
infix fun <
	NumeratorNumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorNumeratorUnit,
	WrappedNumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorAndDenominatorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: ScientificValue<NumeratorNumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorAndDenominatorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorNumeratorAndDenominatorQuantity,
	NumeratorNumeratorUnit,
		>,
	WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorAndDenominatorQuantity,
			>,
		WrappedNumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<NumeratorNumeratorAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Imperial<
							NumeratorDenominatorQuantity,
							NumeratorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithDefinedNumeratorDividedByUKImperialNumerator")
infix fun <
	NumeratorNumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorNumeratorUnit,
	WrappedNumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorAndDenominatorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: ScientificValue<NumeratorNumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorAndDenominatorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorNumeratorAndDenominatorQuantity,
	NumeratorNumeratorUnit,
		>,
	WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorAndDenominatorQuantity,
			>,
		WrappedNumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : AbstractScientificUnit<NumeratorNumeratorAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.UKImperial<
							NumeratorDenominatorQuantity,
							NumeratorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithDefinedNumeratorDividedByUSCustomaryNumerator")
infix fun <
	NumeratorNumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorNumeratorUnit,
	WrappedNumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorAndDenominatorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: ScientificValue<NumeratorNumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorAndDenominatorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorNumeratorAndDenominatorQuantity,
	NumeratorNumeratorUnit,
		>,
	WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorAndDenominatorQuantity,
			>,
		WrappedNumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<NumeratorNumeratorAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.USCustomary<
							NumeratorDenominatorQuantity,
							NumeratorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithDefinedNumeratorDividedByMetricAndUKImperialNumerator")
infix fun <
	NumeratorNumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorNumeratorUnit,
	WrappedNumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorAndDenominatorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: ScientificValue<NumeratorNumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorAndDenominatorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorNumeratorAndDenominatorQuantity,
	NumeratorNumeratorUnit,
		>,
	WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorAndDenominatorQuantity,
			>,
		WrappedNumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : AbstractScientificUnit<NumeratorNumeratorAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUKImperial<
							NumeratorDenominatorQuantity,
							NumeratorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithDefinedNumeratorDividedByMetricAndUSCustomaryNumerator")
infix fun <
	NumeratorNumeratorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorNumeratorUnit,
	WrappedNumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorAndDenominatorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: ScientificValue<NumeratorNumeratorAndDenominatorQuantity, DenominatorUnit>,
) where
	NumeratorNumeratorUnit : AbstractScientificUnit<NumeratorNumeratorAndDenominatorQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorNumeratorAndDenominatorQuantity,
	NumeratorNumeratorUnit,
		>,
	WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	WrappedNumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Extended<
			NumeratorNumeratorAndDenominatorQuantity,
			>,
		WrappedNumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : AbstractScientificUnit<NumeratorNumeratorAndDenominatorQuantity>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
							NumeratorDenominatorQuantity,
							NumeratorDenominatorUnit,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
