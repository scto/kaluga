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
import kotlin.jvm.JvmName

// Div<Mul<C, D>, Mul<B, A>> * Div<Mul<A, B>, C> -> D

@JvmName("dividingWithMultiplyingNumeratorAndMultiplyingDenominatorMultipliedByDividingUnitWithMultiplyingNumeratorWithDenominatorRightAsLeftAndDenominatorLeftAsRightAndNumeratorLeftAsDenominator")
fun <
	LeftNumeratorLeftAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftNumeratorLeftAndRightDenominatorUnit : UndefinedScientificUnit<LeftNumeratorLeftAndRightDenominatorQuantity>,
	LeftNumeratorRightQuantity : UndefinedQuantityType,
	LeftNumeratorRightUnit : UndefinedScientificUnit<LeftNumeratorRightQuantity>,
	LeftNumeratorUnit : UndefinedMultipliedUnit<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorLeftAndRightDenominatorUnit, LeftNumeratorRightQuantity, LeftNumeratorRightUnit>,
	LeftDenominatorLeftAndRightNumeratorRightQuantity : UndefinedQuantityType,
	LeftDenominatorLeftAndRightNumeratorRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity>,
	LeftDenominatorRightAndRightNumeratorLeftQuantity : UndefinedQuantityType,
	LeftDenominatorRightAndRightNumeratorLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity>,
	LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorLeftAndRightNumeratorRightUnit, LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorLeftUnit>,
	LeftUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorRightQuantity>, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorLeftQuantity>, LeftDenominatorUnit>,
	RightNumeratorUnit : UndefinedMultipliedUnit<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorRightAndRightNumeratorLeftUnit, LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorLeftAndRightNumeratorRightUnit>,
	RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorRightQuantity>, RightNumeratorUnit, LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorLeftAndRightDenominatorUnit>,
	LeftNumeratorRightValue : UndefinedScientificValue<LeftNumeratorRightQuantity, LeftNumeratorRightUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftNumeratorLeftAndRightDenominatorQuantity, LeftNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightNumeratorRightQuantity, LeftDenominatorRightAndRightNumeratorLeftQuantity>>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<LeftDenominatorRightAndRightNumeratorLeftQuantity, LeftDenominatorLeftAndRightNumeratorRightQuantity>, LeftNumeratorLeftAndRightDenominatorQuantity>, RightUnit>,
	factory: (Decimal, LeftNumeratorRightUnit) -> LeftNumeratorRightValue
) = unit.numerator.right.byMultiplying(this, right, factory)

