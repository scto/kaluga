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

// Div<Mul<A, B>, C> * Div<C, Mul<B, D>> -> Div<A, D>

@JvmName("dividingWithMultiplyingNumeratorMultipliedByDividingUnitWithDenominatorAsNumeratorAndMultiplyingDenominatorWithNumeratorRightAsLeft")
fun <
	LeftNumeratorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorLeftUnit : UndefinedScientificUnit<LeftNumeratorLeftQuantity>,
	LeftNumeratorRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftNumeratorRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity>,
	LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit>,
	LeftDenominatorAndRightNumeratorQuantity : UndefinedQuantityType,
	LeftDenominatorAndRightNumeratorUnit : UndefinedScientificUnit<LeftDenominatorAndRightNumeratorQuantity>,
	LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftNumeratorUnit, LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit>,
	RightDenominatorRightQuantity : UndefinedQuantityType,
	RightDenominatorRightUnit : UndefinedScientificUnit<RightDenominatorRightQuantity>,
	RightDenominatorUnit : UndefinedMultipliedUnit<LeftNumeratorRightAndRightDenominatorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftUnit, RightDenominatorRightQuantity, RightDenominatorRightUnit>,
	RightUnit : UndefinedDividedUnit<LeftDenominatorAndRightNumeratorQuantity, LeftDenominatorAndRightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, RightDenominatorRightQuantity>, RightDenominatorUnit>,
	TargetUnit : UndefinedDividedUnit<LeftNumeratorLeftQuantity, LeftNumeratorLeftUnit, RightDenominatorRightQuantity, RightDenominatorRightUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorLeftQuantity, RightDenominatorRightQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftQuantity, LeftNumeratorRightAndRightDenominatorLeftQuantity>, LeftDenominatorAndRightNumeratorQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftDenominatorAndRightNumeratorQuantity, UndefinedQuantityType.Multiplying<LeftNumeratorRightAndRightDenominatorLeftQuantity, RightDenominatorRightQuantity>>, RightUnit>,
	leftNumeratorLeftUnitPerRightDenominatorRightUnit: LeftNumeratorLeftUnit.(RightDenominatorRightUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.numerator.left.leftNumeratorLeftUnitPerRightDenominatorRightUnit(right.unit.denominator.right).byMultiplying(this, right, factory)

