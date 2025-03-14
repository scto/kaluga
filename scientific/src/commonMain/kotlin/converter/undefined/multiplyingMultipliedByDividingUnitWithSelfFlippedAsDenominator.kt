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

// Mul<A, B> * Div<C, Mul<B, A>> -> C

@JvmName("multiplyingMultipliedByDividingUnitWithSelfFlippedAsDenominator")
fun <
	LeftLeftAndRightDenominatorRightQuantity : UndefinedQuantityType,
	LeftLeftAndRightDenominatorRightUnit : UndefinedScientificUnit<LeftLeftAndRightDenominatorRightQuantity>,
	LeftRightAndRightDenominatorLeftQuantity : UndefinedQuantityType,
	LeftRightAndRightDenominatorLeftUnit : UndefinedScientificUnit<LeftRightAndRightDenominatorLeftQuantity>,
	LeftUnit : UndefinedMultipliedUnit<LeftLeftAndRightDenominatorRightQuantity, LeftLeftAndRightDenominatorRightUnit, LeftRightAndRightDenominatorLeftQuantity, LeftRightAndRightDenominatorLeftUnit>,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightDenominatorUnit : UndefinedMultipliedUnit<LeftRightAndRightDenominatorLeftQuantity, LeftRightAndRightDenominatorLeftUnit, LeftLeftAndRightDenominatorRightQuantity, LeftLeftAndRightDenominatorRightUnit>,
	RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, UndefinedQuantityType.Multiplying<LeftRightAndRightDenominatorLeftQuantity, LeftLeftAndRightDenominatorRightQuantity>, RightDenominatorUnit>,
	RightNumeratorValue : UndefinedScientificValue<RightNumeratorQuantity, RightNumeratorUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<LeftLeftAndRightDenominatorRightQuantity, LeftRightAndRightDenominatorLeftQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, UndefinedQuantityType.Multiplying<LeftRightAndRightDenominatorLeftQuantity, LeftLeftAndRightDenominatorRightQuantity>>, RightUnit>,
	factory: (Decimal, RightNumeratorUnit) -> RightNumeratorValue
) = right.unit.numerator.byMultiplying(this, right, factory)

