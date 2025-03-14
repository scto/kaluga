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
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Div<Mul<A, B>, Mul<C, D>> / Div<Mul<B, E>, Mul<F, C>> -> Div<Mul<A, F>, Mul<D, E>>

@JvmName("dividingWithMultiplyingNumeratorAndMultiplyingDenominatorDividedByDividingUnitWithMultiplyingNumeratorWithNumeratorRightAsLeftAndMultiplyingDenominatorWithDenominatorLeftAsRight")
fun <
	NumeratorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorLeftQuantity>,
	NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit>,
	NumeratorDenominatorLeftAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorRightQuantity>,
	NumeratorDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorRightQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorRightUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
	NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
	DenominatorNumeratorRightQuantity : UndefinedQuantityType,
	DenominatorNumeratorRightUnit : UndefinedScientificUnit<DenominatorNumeratorRightQuantity>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftUnit, DenominatorNumeratorRightQuantity, DenominatorNumeratorRightUnit>,
	DenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	DenominatorDenominatorLeftUnit : UndefinedScientificUnit<DenominatorDenominatorLeftQuantity>,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<DenominatorDenominatorLeftQuantity, DenominatorDenominatorLeftUnit, NumeratorDenominatorLeftAndDenominatorDenominatorRightQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorRightUnit>,
	DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
	TargetNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftQuantity, NumeratorNumeratorLeftUnit, DenominatorDenominatorLeftQuantity, DenominatorDenominatorLeftUnit>,
	TargetDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit, DenominatorNumeratorRightQuantity, DenominatorNumeratorRightUnit>,
	TargetUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, DenominatorDenominatorLeftQuantity>, TargetNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorRightQuantity, DenominatorNumeratorRightQuantity>, TargetDenominatorUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, DenominatorDenominatorLeftQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorRightQuantity, DenominatorNumeratorRightQuantity>>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftQuantity, NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorRightQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightAndDenominatorNumeratorLeftQuantity, DenominatorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<DenominatorDenominatorLeftQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
	numeratorNumeratorLeftUnitXDenominatorDenominatorLeftUnit: NumeratorNumeratorLeftUnit.(DenominatorDenominatorLeftUnit) -> TargetNumeratorUnit,
	numeratorDenominatorRightUnitXDenominatorNumeratorRightUnit: NumeratorDenominatorRightUnit.(DenominatorNumeratorRightUnit) -> TargetDenominatorUnit,
	targetNumeratorUnitPerTargetDenominatorUnit: TargetNumeratorUnit.(TargetDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.numerator.left.numeratorNumeratorLeftUnitXDenominatorDenominatorLeftUnit(right.unit.denominator.left).targetNumeratorUnitPerTargetDenominatorUnit(unit.denominator.right.numeratorDenominatorRightUnitXDenominatorNumeratorRightUnit(right.unit.numerator.right)).byDividing(this, right, factory)

