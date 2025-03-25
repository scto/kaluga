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
import com.splendo.kaluga.scientific.unit.per
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Div<Mul<A, A>, B> / Div<A, C> -> Div<Mul<A, C>, B>

@JvmName("dividingWithSquaredNumeratorDividedByDividingUnitWithNumeratorRootAsNumerator")
fun <
	NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	TargetNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorLeftUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			DenominatorDenominatorQuantity,
			>,
		TargetNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			DenominatorDenominatorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
	numeratorNumeratorLeftUnitXDenominatorDenominatorUnit: NumeratorNumeratorLeftUnit.(DenominatorDenominatorUnit) -> TargetNumeratorUnit,
	targetNumeratorUnitPerNumeratorDenominatorUnit: TargetNumeratorUnit.(NumeratorDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.left.numeratorNumeratorLeftUnitXDenominatorDenominatorUnit(
	right.unit.denominator,
).targetNumeratorUnitPerNumeratorDenominatorUnit(
	unit.denominator,
).byDividing(this, right, factory)

@JvmName("metricAndImperialDividingWithSquaredNumeratorDividedByMetricAndImperialDividingUnitWithNumeratorRootAsNumerator")
infix fun <
	NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndImperialDividedByMetricAndImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndImperial<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndImperial<
				NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricDividingWithSquaredNumeratorDividedByMetricDividingUnitWithNumeratorRootAsNumerator")
infix fun <
	NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricDividedByMetric(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Metric<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.Metric<
				NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("imperialDividingWithSquaredNumeratorDividedByImperialDividingUnitWithNumeratorRootAsNumerator")
infix fun <
	NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.imperialDividedByImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.Imperial<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.Imperial<
				NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("ukImperialDividingWithSquaredNumeratorDividedByUKImperialDividingUnitWithNumeratorRootAsNumerator")
infix fun <
	NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.ukImperialDividedByUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.UKImperial<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.UKImperial<
				NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("usCustomaryDividingWithSquaredNumeratorDividedByUSCustomaryDividingUnitWithNumeratorRootAsNumerator")
infix fun <
	NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.usCustomaryDividedByUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.USCustomary<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.USCustomary<
				NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUKImperialDividingWithSquaredNumeratorDividedByMetricAndUKImperialDividingUnitWithNumeratorRootAsNumerator")
infix fun <
	NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUKImperialDividedByMetricAndUKImperial(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUKImperial,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUKImperial =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUKImperial<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUKImperial<
				NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}

@JvmName("metricAndUSCustomaryDividingWithSquaredNumeratorDividedByMetricAndUSCustomaryDividingUnitWithNumeratorRootAsNumerator")
infix fun <
	NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit,
	NumeratorNumeratorRightUnit,
	NumeratorNumeratorUnit,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit,
	NumeratorUnit,
	DenominatorNumeratorUnit,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit,
	DenominatorUnit,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorDenominatorQuantity,
		>,
NumeratorUnit,
	>.metricAndUSCustomaryDividedByMetricAndUSCustomary(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorDenominatorQuantity,
		>,
DenominatorUnit,
	>,
) where
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorLeftUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorRightUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorDenominatorUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInMetric,
	NumeratorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
			>,
		NumeratorNumeratorUnit,
		NumeratorDenominatorQuantity,
		NumeratorDenominatorUnit,
		>,
	NumeratorUnit : MeasurementUsage.UsedInMetric,
	NumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorNumeratorUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity>,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInMetric,
	DenominatorNumeratorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorDenominatorUnit : AbstractUndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorDenominatorUnit : MeasurementUsage.UsedInUSCustomary,
	DenominatorUnit : UndefinedDividedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
		DenominatorNumeratorUnit,
		DenominatorDenominatorQuantity,
		DenominatorDenominatorUnit,
		>,
	DenominatorUnit : MeasurementUsage.UsedInMetric,
	DenominatorUnit : MeasurementUsage.UsedInUSCustomary =
	dividedBy(
		right,
		numeratorNumeratorLeftUnitXDenominatorDenominatorUnit = { x(it) },
		targetNumeratorUnitPerNumeratorDenominatorUnit = { per(it) },
	) {
		value: Decimal,
		unit: UndefinedDividedUnit.MetricAndUSCustomary<
				UndefinedQuantityType.Multiplying<
					NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
					DenominatorDenominatorQuantity,
					>,
				UndefinedMultipliedUnit.MetricAndUSCustomary<
				NumeratorNumeratorLeftAndRightAndDenominatorNumeratorQuantity,
					NumeratorNumeratorLeftUnit,
					DenominatorDenominatorQuantity,
					DenominatorDenominatorUnit,
					>,
				NumeratorDenominatorQuantity,
				NumeratorDenominatorUnit,
				>,
		->
		DefaultScientificValue(value, unit)
	}
