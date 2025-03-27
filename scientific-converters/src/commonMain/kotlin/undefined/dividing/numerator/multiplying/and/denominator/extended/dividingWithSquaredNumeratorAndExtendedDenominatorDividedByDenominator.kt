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

package com.splendo.kaluga.scientific.converter.undefined.dividing.numerator.multiplying.and.denominator.extended

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.DefinedScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Div<Mul<A, A>, Ex<B>> / B! -> Div<Mul<Ex<B>, Wr<B>>, Mul<A, A>>

fun <
	NumeratorNumeratorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightQuantity>,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightQuantity>,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightQuantity,
		NumeratorNumeratorRightUnit,
		>,
	ExtendedNumeratorDenominatorUnit : UndefinedExtendedUnit<
		NumeratorDenominatorAndDenominatorQuantity,
		>,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightQuantity,
			>,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Extended<
			NumeratorDenominatorAndDenominatorQuantity,
			>,
		ExtendedNumeratorDenominatorUnit,
		>,
	NumeratorDenominatorAndDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorUnit : ScientificUnit<NumeratorDenominatorAndDenominatorQuantity>,
	WrappedDenominatorUnit : WrappedUndefinedExtendedUnit<
	NumeratorDenominatorAndDenominatorQuantity,
	DenominatorUnit,
		>,
	TargetNumeratorUnit : UndefinedMultipliedUnit<
		UndefinedQuantityType.Extended<
			NumeratorDenominatorAndDenominatorQuantity,
			>,
		ExtendedNumeratorDenominatorUnit,
		UndefinedQuantityType.Extended<
			NumeratorDenominatorAndDenominatorQuantity,
			>,
		WrappedDenominatorUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorDenominatorAndDenominatorQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorDenominatorAndDenominatorQuantity,
				>,
			>,
		TargetNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightQuantity,
			>,
		NumeratorNumeratorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			UndefinedQuantityType.Extended<
				NumeratorDenominatorAndDenominatorQuantity,
				>,
			UndefinedQuantityType.Extended<
				NumeratorDenominatorAndDenominatorQuantity,
				>,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightQuantity,
			>,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightQuantity,
			NumeratorNumeratorLeftAndRightQuantity,
			>,
		UndefinedQuantityType.Extended<
			NumeratorDenominatorAndDenominatorQuantity,
			>,
		>,
NumeratorUnit,
	>.dividingWithSquaredNumeratorAndExtendedDenominatorDividedByDenominator(
	right: ScientificValue<NumeratorDenominatorAndDenominatorQuantity, DenominatorUnit>,
	extendedNumeratorDenominatorUnitXWrappedDenominatorUnit: ExtendedNumeratorDenominatorUnit.(WrappedDenominatorUnit) -> TargetNumeratorUnit,
	targetNumeratorUnitPerNumeratorNumeratorUnit: TargetNumeratorUnit.(NumeratorNumeratorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.denominator.extendedNumeratorDenominatorUnitXWrappedDenominatorUnit(
	unit.denominator.extended,
).targetNumeratorUnitPerNumeratorNumeratorUnit(
	unit.numerator,
).byDividing(this, right, factory)
