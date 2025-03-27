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

package com.splendo.kaluga.scientific.converter.undefined.dividing.numerator.multiplying.and.denominator.multiplying

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

// Div<Mul<A, A>, Mul<B, C>> / Div<Mul<D, A>, Mul<B, B>> -> Div<Mul<A, B>, Mul<C, D>>

internal fun <
	NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity>,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity>,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorRightQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
			>,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorRightQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		DenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			DenominatorNumeratorLeftQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	TargetNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		>,
	TargetDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorRightQuantity,
		NumeratorDenominatorRightUnit,
		DenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
			NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		TargetNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightQuantity,
			DenominatorNumeratorLeftQuantity,
			>,
		TargetDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
			NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightQuantity,
			DenominatorNumeratorLeftQuantity,
			>,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorRightQuantity,
			>,
		>,
NumeratorUnit,
	>.internalDividingWithSquaredNumeratorAndMultiplyingDenominatorDividedByDividingUnitWithMultiplyingNumeratorWithNumeratorRootAsRightAndSquaredDenominatorWithDenominatorLeftAsRoot(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			DenominatorNumeratorLeftQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
	numeratorNumeratorLeftUnitXNumeratorDenominatorLeftUnit: NumeratorNumeratorLeftUnit.(NumeratorDenominatorLeftUnit) -> TargetNumeratorUnit,
	numeratorDenominatorRightUnitXDenominatorNumeratorLeftUnit: NumeratorDenominatorRightUnit.(DenominatorNumeratorLeftUnit) -> TargetDenominatorUnit,
	targetNumeratorUnitPerTargetDenominatorUnit: TargetNumeratorUnit.(TargetDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = unit.numerator.left.numeratorNumeratorLeftUnitXNumeratorDenominatorLeftUnit(
	unit.denominator.left,
).targetNumeratorUnitPerTargetDenominatorUnit(
	unit.denominator.right.numeratorDenominatorRightUnitXDenominatorNumeratorLeftUnit(
	right.unit.numerator.left,
),
).byDividing(this, right, factory)

@JvmName("dividingWithSquaredNumeratorAndMultiplyingDenominatorDividedByDividingUnitWithMultiplyingNumeratorWithNumeratorRootAsRightAndSquaredDenominatorWithDenominatorLeftAsRoot")
fun <
	NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity>,
	NumeratorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity>,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
		NumeratorNumeratorRightUnit,
		>,
	NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity>,
	NumeratorDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		NumeratorDenominatorRightQuantity,
		NumeratorDenominatorRightUnit,
		>,
	NumeratorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
			>,
		NumeratorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorRightQuantity,
			>,
		NumeratorDenominatorUnit,
		>,
	DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	DenominatorNumeratorLeftUnit : AbstractUndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorRightUnit : AbstractUndefinedScientificUnit<NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<
		DenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
		DenominatorNumeratorRightUnit,
		>,
	DenominatorDenominatorLeftUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorRightUnit : AbstractUndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity>,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorLeftUnit,
		NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
		DenominatorDenominatorRightUnit,
		>,
	DenominatorUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			DenominatorNumeratorLeftQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
			>,
		DenominatorNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		DenominatorDenominatorUnit,
		>,
	TargetNumeratorUnit : UndefinedMultipliedUnit<
		NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
		NumeratorNumeratorLeftUnit,
		NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
		NumeratorDenominatorLeftUnit,
		>,
	TargetDenominatorUnit : UndefinedMultipliedUnit<
		NumeratorDenominatorRightQuantity,
		NumeratorDenominatorRightUnit,
		DenominatorNumeratorLeftQuantity,
		DenominatorNumeratorLeftUnit,
		>,
	TargetUnit : UndefinedDividedUnit<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
			NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		TargetNumeratorUnit,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightQuantity,
			DenominatorNumeratorLeftQuantity,
			>,
		TargetDenominatorUnit,
		>,
	TargetValue : UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
			NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorRightQuantity,
			DenominatorNumeratorLeftQuantity,
			>,
		>,
TargetUnit,
	>,
	> UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorRightQuantity,
			>,
		>,
NumeratorUnit,
	>.dividedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Dividing<
		UndefinedQuantityType.Multiplying<
			DenominatorNumeratorLeftQuantity,
			NumeratorNumeratorLeftAndRightAndDenominatorNumeratorRightQuantity,
			>,
		UndefinedQuantityType.Multiplying<
			NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
			NumeratorDenominatorLeftAndDenominatorDenominatorLeftAndRightQuantity,
			>,
		>,
DenominatorUnit,
	>,
	numeratorNumeratorLeftUnitXNumeratorDenominatorLeftUnit: NumeratorNumeratorLeftUnit.(NumeratorDenominatorLeftUnit) -> TargetNumeratorUnit,
	numeratorDenominatorRightUnitXDenominatorNumeratorLeftUnit: NumeratorDenominatorRightUnit.(DenominatorNumeratorLeftUnit) -> TargetDenominatorUnit,
	targetNumeratorUnitPerTargetDenominatorUnit: TargetNumeratorUnit.(TargetDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue,
) = internalDividingWithSquaredNumeratorAndMultiplyingDenominatorDividedByDividingUnitWithMultiplyingNumeratorWithNumeratorRootAsRightAndSquaredDenominatorWithDenominatorLeftAsRoot(
	right = right,
	numeratorNumeratorLeftUnitXNumeratorDenominatorLeftUnit = numeratorNumeratorLeftUnitXNumeratorDenominatorLeftUnit,
	numeratorDenominatorRightUnitXDenominatorNumeratorLeftUnit = numeratorDenominatorRightUnitXDenominatorNumeratorLeftUnit,
	targetNumeratorUnitPerTargetDenominatorUnit = targetNumeratorUnitPerTargetDenominatorUnit,
	factory = factory,
)
