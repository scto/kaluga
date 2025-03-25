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
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Div<A, B> / Mul<A, A> -> Inv<Mul<B, A>>

@JvmName("dividingDividedBySquaredUnitWithNumeratorAsRoot")
fun <
	NumeratorNumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftUnit,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorRightUnit,
		>,
	TargetReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorUnit,
		>,
	TargetUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorQuantity,
			NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
			>,
		TargetReciprocalUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorQuantity,
			NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
			>,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
	numeratorDenominatorUnitXNumeratorNumeratorUnit: NumeratorDenominatorUnit.(NumeratorNumeratorUnit) -> TargetReciprocalUnit,
	reciprocalTargetUnit: TargetReciprocalUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.denominator.numeratorDenominatorUnitXNumeratorNumeratorUnit(
	unit.numerator,
).reciprocalTargetUnit().byDividing(this, right, factory)

@JvmName("metricAndImperialDividingDividedByMetricAndImperialSquaredUnitWithNumeratorAsRoot")
infix fun <
	NumeratorNumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftUnit,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorDenominatorUnitXNumeratorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndImperial<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndImperial<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingDividedByMetricSquaredUnitWithNumeratorAsRoot")
infix fun <
	NumeratorNumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftUnit,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		numeratorDenominatorUnitXNumeratorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Metric<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					>,
							UndefinedMultipliedUnit.Metric<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingDividedByImperialSquaredUnitWithNumeratorAsRoot")
infix fun <
	NumeratorNumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftUnit,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorDenominatorUnitXNumeratorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Imperial<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					>,
							UndefinedMultipliedUnit.Imperial<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingDividedByUKImperialSquaredUnitWithNumeratorAsRoot")
infix fun <
	NumeratorNumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftUnit,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorDenominatorUnitXNumeratorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.UKImperial<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					>,
							UndefinedMultipliedUnit.UKImperial<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingDividedByUSCustomarySquaredUnitWithNumeratorAsRoot")
infix fun <
	NumeratorNumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftUnit,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorDenominatorUnitXNumeratorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.USCustomary<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					>,
							UndefinedMultipliedUnit.USCustomary<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingDividedByMetricAndUKImperialSquaredUnitWithNumeratorAsRoot")
infix fun <
	NumeratorNumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftUnit,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorDenominatorUnitXNumeratorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUKImperial<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndUKImperial<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingDividedByMetricAndUSCustomarySquaredUnitWithNumeratorAsRoot")
infix fun <
	NumeratorNumeratorAndDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftAndRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorLeftUnit,
		NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorDenominatorUnitXNumeratorNumeratorUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndUSCustomary<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					NumeratorNumeratorAndDenominatorLeftAndRightQuantity,
					NumeratorNumeratorUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}
