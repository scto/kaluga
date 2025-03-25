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

// Div<A, B> / Mul<C, A> -> Inv<Mul<B, C>>

@JvmName("dividingDividedByMultiplyingUnitWithNumeratorAsRight")
fun <
	NumeratorNumeratorAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorRightQuantity>,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorRightQuantity>,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorNumeratorAndDenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	TargetReciprocalUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		>,
	TargetUnit : UndefinedReciprocalUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorQuantity,
			DenominatorLeftQuantity,
			>,
		TargetReciprocalUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorQuantity,
			DenominatorLeftQuantity,
			>,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		NumeratorNumeratorAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
	numeratorDenominatorUnitXDenominatorLeftUnit: NumeratorDenominatorUnit.(DenominatorLeftUnit) -> TargetReciprocalUnit,
	reciprocalTargetUnit: TargetReciprocalUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.denominator.numeratorDenominatorUnitXDenominatorLeftUnit(
	right.unit.left,
).reciprocalTargetUnit().byDividing(this, right, factory)

@JvmName("metricAndImperialDividingDividedByMetricAndImperialMultiplyingUnitWithNumeratorAsRight")
infix fun <
	NumeratorNumeratorAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		NumeratorNumeratorAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorNumeratorAndDenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorDenominatorUnitXDenominatorLeftUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndImperial<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					DenominatorLeftQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndImperial<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorLeftQuantity,
					DenominatorLeftUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingDividedByMetricMultiplyingUnitWithNumeratorAsRight")
infix fun <
	NumeratorNumeratorAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		NumeratorNumeratorAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorNumeratorAndDenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		numeratorDenominatorUnitXDenominatorLeftUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Metric<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					DenominatorLeftQuantity,
					>,
							UndefinedMultipliedUnit.Metric<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorLeftQuantity,
					DenominatorLeftUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingDividedByImperialMultiplyingUnitWithNumeratorAsRight")
infix fun <
	NumeratorNumeratorAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		NumeratorNumeratorAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorNumeratorAndDenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorDenominatorUnitXDenominatorLeftUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.Imperial<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					DenominatorLeftQuantity,
					>,
							UndefinedMultipliedUnit.Imperial<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorLeftQuantity,
					DenominatorLeftUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingDividedByUKImperialMultiplyingUnitWithNumeratorAsRight")
infix fun <
	NumeratorNumeratorAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		NumeratorNumeratorAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorNumeratorAndDenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorDenominatorUnitXDenominatorLeftUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.UKImperial<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					DenominatorLeftQuantity,
					>,
							UndefinedMultipliedUnit.UKImperial<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorLeftQuantity,
					DenominatorLeftUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingDividedByUSCustomaryMultiplyingUnitWithNumeratorAsRight")
infix fun <
	NumeratorNumeratorAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		NumeratorNumeratorAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorNumeratorAndDenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorDenominatorUnitXDenominatorLeftUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.USCustomary<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					DenominatorLeftQuantity,
					>,
							UndefinedMultipliedUnit.USCustomary<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorLeftQuantity,
					DenominatorLeftUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingDividedByMetricAndUKImperialMultiplyingUnitWithNumeratorAsRight")
infix fun <
	NumeratorNumeratorAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		NumeratorNumeratorAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorNumeratorAndDenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorDenominatorUnitXDenominatorLeftUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUKImperial<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					DenominatorLeftQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndUKImperial<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorLeftQuantity,
					DenominatorLeftUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingDividedByMetricAndUSCustomaryMultiplyingUnitWithNumeratorAsRight")
infix fun <
	NumeratorNumeratorAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorLeftUnit,
	DenominatorRightUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorAndDenominatorRightQuantity,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Multiplying<
		DenominatorLeftQuantity,
		NumeratorNumeratorAndDenominatorRightQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorRightQuantity>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		NumeratorNumeratorAndDenominatorRightQuantity,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorLeftUnit : AbstractUndefinedScientificUnit<DenominatorLeftQuantity>,
	DenominatorLeftUnit : MeasurementUsage.UsedInMetric,
	DenominatorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorAndDenominatorRightQuantity>,
	DenominatorRightUnit : MeasurementUsage.UsedInMetric,
	DenominatorRightUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedMultipliedUnit<
		DenominatorLeftQuantity,
		DenominatorLeftUnit,
		NumeratorNumeratorAndDenominatorRightQuantity,
		DenominatorRightUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorDenominatorUnitXDenominatorLeftUnit = { x(it) },
		reciprocalTargetUnit = { reciprocal() },
	) {
		value: Decimal,
		unit: UndefinedReciprocalUnit.MetricAndUSCustomary<
							UndefinedQuantityType.Multiplying<
					NumeratorDenominatorQuantity,
					DenominatorLeftQuantity,
					>,
							UndefinedMultipliedUnit.MetricAndUSCustomary<
				NumeratorDenominatorQuantity,
					NumeratorDenominatorUnit,
					DenominatorLeftQuantity,
					DenominatorLeftUnit,
					>,
				>,
		->
		DefaultScientificValue(value, unit)
	}
