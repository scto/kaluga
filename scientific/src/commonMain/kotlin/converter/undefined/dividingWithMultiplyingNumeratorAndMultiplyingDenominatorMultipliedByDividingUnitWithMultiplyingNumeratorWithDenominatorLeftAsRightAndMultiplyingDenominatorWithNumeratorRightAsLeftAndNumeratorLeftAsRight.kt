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
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// Div<Mul<A, B>, Mul<C, D>> * Div<Mul<E, C>, Mul<B, A>> -> Div<E, D>

@JvmName("dividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorLeftAsRightAndMultiplyingDenominatorWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
fun <
	LeftNumeratorLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftNumeratorLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity>,
	LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
	LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit, LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit>,
	LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorLeftAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
	LeftDenominatorRightQuantity : UndefinedQuantityType,
	LeftDenominatorRightUnit : UndefinedScientificUnit<LeftDenominatorRightQuantity>,
	LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorLeftAndRightNumeratorRightUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
	LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorRightQuantity>, LeftDenominatorUnit>,
	RightNumeratorLeftQuantity : UndefinedQuantityType,
	RightNumeratorLeftUnit : UndefinedScientificUnit<RightNumeratorLeftQuantity>,
	RightNumeratorUnit : UndefinedMultipliedUnit<RightNumeratorLeftQuantity, RightNumeratorLeftUnit, LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorLeftAndRightNumeratorRightUnit>,
	RightDenominatorUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit, LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorLeftAndRightDenominatorRightUnit>,
	RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<RightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorRightQuantity>, RightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
	TargetUnit : UndefinedDividedUnit<RightNumeratorLeftQuantity, RightNumeratorLeftUnit, LeftDenominatorRightQuantity, LeftDenominatorRightUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorLeftQuantity, LeftDenominatorRightQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorRightQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorRightQuantity>>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<RightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorLeftAndRightDenominatorRightQuantity>>, RightUnit>,
	rightNumeratorLeftUnitPerLeftDenominatorRightUnit: RightNumeratorLeftUnit.(LeftDenominatorRightUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = right.unit.numerator.left.rightNumeratorLeftUnitPerLeftDenominatorRightUnit(unit.denominator.right).byMultiplying(this, right, factory)

