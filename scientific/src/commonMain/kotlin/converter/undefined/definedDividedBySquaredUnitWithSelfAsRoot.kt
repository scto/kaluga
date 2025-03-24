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
import com.splendo.kaluga.scientific.unit.DefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.asUndefined
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// A! / Mul<Wr<A>, Wr<A>> -> Inv<Wr<A>>

@JvmName("definedDividedBySquaredUnitWithSelfAsRoot")
fun <
	NumeratorAndDenominatorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit : ScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftUnit : ScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	WrappedDenominatorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorLeftAndRightQuantity,
	DenominatorLeftUnit,
		>,
	DenominatorRightUnit : ScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	WrappedDenominatorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorLeftAndRightQuantity,
	DenominatorRightUnit,
		>,
	DenominatorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		WrappedDenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		WrappedDenominatorRightUnit,
		>,
	WrappedNumeratorUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorLeftAndRightQuantity,
	NumeratorUnit,
		>,
	TargetUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		WrappedNumeratorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		>,
TargetUnit,
	>,
	> ScientificValue<NumeratorAndDenominatorLeftAndRightQuantity, NumeratorUnit>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
	numeratorAsUndefined: NumeratorUnit.() -> WrappedNumeratorUnit,
	reciprocalTargetUnit: WrappedNumeratorUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numeratorAsUndefined().reciprocalTargetUnit().byDividing(this, right, factory)

@JvmName("metricAndImperialDefinedDividedByMetricAndImperialSquaredUnitWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorLeftUnit,
	WrappedDenominatorLeftUnit,
	DenominatorRightUnit,
	WrappedDenominatorRightUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorLeftAndRightQuantity, NumeratorUnit>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorLeftAndRightQuantity,
	DenominatorLeftUnit,
		>,
	WrappedDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorLeftAndRightQuantity,
	DenominatorRightUnit,
		>,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		WrappedDenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		WrappedDenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorAsUndefined = { asUndefined() },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndImperial<
							UndefinedQuantityType.Extended<
					NumeratorAndDenominatorLeftAndRightQuantity,
					>,
							WrappedUndefinedExtendedUnit.MetricAndImperial<
					NumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricDefinedDividedByMetricSquaredUnitWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorLeftUnit,
	WrappedDenominatorLeftUnit,
	DenominatorRightUnit,
	WrappedDenominatorRightUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorLeftAndRightQuantity, NumeratorUnit>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorLeftAndRightQuantity,
	DenominatorLeftUnit,
		>,
	WrappedDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorLeftAndRightQuantity,
	DenominatorRightUnit,
		>,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		WrappedDenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		WrappedDenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		numeratorAsUndefined = { asUndefined() },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Metric<
							UndefinedQuantityType.Extended<
					NumeratorAndDenominatorLeftAndRightQuantity,
					>,
							WrappedUndefinedExtendedUnit.Metric<
					NumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("imperialDefinedDividedByImperialSquaredUnitWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorLeftUnit,
	WrappedDenominatorLeftUnit,
	DenominatorRightUnit,
	WrappedDenominatorRightUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorLeftAndRightQuantity, NumeratorUnit>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorLeftAndRightQuantity,
	DenominatorLeftUnit,
		>,
	WrappedDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorLeftAndRightQuantity,
	DenominatorRightUnit,
		>,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		WrappedDenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		WrappedDenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorAsUndefined = { asUndefined() },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Imperial<
							UndefinedQuantityType.Extended<
					NumeratorAndDenominatorLeftAndRightQuantity,
					>,
							WrappedUndefinedExtendedUnit.Imperial<
					NumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("ukImperialDefinedDividedByUKImperialSquaredUnitWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorLeftUnit,
	WrappedDenominatorLeftUnit,
	DenominatorRightUnit,
	WrappedDenominatorRightUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorLeftAndRightQuantity, NumeratorUnit>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorLeftAndRightQuantity,
	DenominatorLeftUnit,
		>,
	WrappedDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorLeftAndRightQuantity,
	DenominatorRightUnit,
		>,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		WrappedDenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		WrappedDenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorAsUndefined = { asUndefined() },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.UKImperial<
							UndefinedQuantityType.Extended<
					NumeratorAndDenominatorLeftAndRightQuantity,
					>,
							WrappedUndefinedExtendedUnit.UKImperial<
					NumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("usCustomaryDefinedDividedByUSCustomarySquaredUnitWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorLeftUnit,
	WrappedDenominatorLeftUnit,
	DenominatorRightUnit,
	WrappedDenominatorRightUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorLeftAndRightQuantity, NumeratorUnit>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorLeftAndRightQuantity,
	DenominatorLeftUnit,
		>,
	WrappedDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorLeftAndRightQuantity,
	DenominatorRightUnit,
		>,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		WrappedDenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		WrappedDenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorAsUndefined = { asUndefined() },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.USCustomary<
							UndefinedQuantityType.Extended<
					NumeratorAndDenominatorLeftAndRightQuantity,
					>,
							WrappedUndefinedExtendedUnit.USCustomary<
					NumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDefinedDividedByMetricAndUKImperialSquaredUnitWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorLeftUnit,
	WrappedDenominatorLeftUnit,
	DenominatorRightUnit,
	WrappedDenominatorRightUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorLeftAndRightQuantity, NumeratorUnit>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorLeftAndRightQuantity,
	DenominatorLeftUnit,
		>,
	WrappedDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	WrappedDenominatorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorLeftAndRightQuantity,
	DenominatorRightUnit,
		>,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		WrappedDenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		WrappedDenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorAsUndefined = { asUndefined() },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUKImperial<
							UndefinedQuantityType.Extended<
					NumeratorAndDenominatorLeftAndRightQuantity,
					>,
							WrappedUndefinedExtendedUnit.MetricAndUKImperial<
					NumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDefinedDividedByMetricAndUSCustomarySquaredUnitWithSelfAsRoot")
infix fun <
	NumeratorAndDenominatorLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorUnit,
	DenominatorLeftUnit,
	WrappedDenominatorLeftUnit,
	DenominatorRightUnit,
	WrappedDenominatorRightUnit,
	DenominatorUnit,
	> ScientificValue<NumeratorAndDenominatorLeftAndRightQuantity, NumeratorUnit>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
) where
	NumeratorUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorLeftUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorLeftAndRightQuantity,
	DenominatorLeftUnit,
		>,
	WrappedDenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : DefinedScientificUnit<NumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	WrappedDenominatorRightUnit : WrappedUndefinedExtendedUnit<
	NumeratorAndDenominatorLeftAndRightQuantity,
	DenominatorRightUnit,
		>,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInMetric,
	WrappedDenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		WrappedDenominatorLeftUnit,
		UndefinedQuantityType.Extended<
			NumeratorAndDenominatorLeftAndRightQuantity,
			>,
		WrappedDenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorAsUndefined = { asUndefined() },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
							UndefinedQuantityType.Extended<
					NumeratorAndDenominatorLeftAndRightQuantity,
					>,
							WrappedUndefinedExtendedUnit.MetricAndUSCustomary<
					NumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorUnit,
					>,
				>,
		->
		DefaultUndefinedScientificValue(value, unit)
	}
