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
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Mul<A, B> * Div<C, B> -> Mul<B, C>

@JvmName("multiplyingMultipliedByDividingUnitWithRightAsDenominator")
fun <
	LeftLeftQuantity : UndefinedQuantityType,
	LeftLeftUnit : UndefinedScientificUnit<LeftLeftQuantity>,
	LeftRightAndRightDenominatorQuantity : UndefinedQuantityType,
	LeftRightAndRightDenominatorUnit : UndefinedScientificUnit<LeftRightAndRightDenominatorQuantity>,
	LeftUnit : UndefinedMultipliedUnit<LeftLeftQuantity, LeftLeftUnit, LeftRightAndRightDenominatorQuantity, LeftRightAndRightDenominatorUnit>,
	RightNumeratorQuantity : UndefinedQuantityType,
	RightNumeratorUnit : UndefinedScientificUnit<RightNumeratorQuantity>,
	RightUnit : UndefinedDividedUnit<RightNumeratorQuantity, RightNumeratorUnit, LeftRightAndRightDenominatorQuantity, LeftRightAndRightDenominatorUnit>,
	TargetUnit : UndefinedMultipliedUnit<LeftRightAndRightDenominatorQuantity, LeftRightAndRightDenominatorUnit, RightNumeratorQuantity, RightNumeratorUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Multiplying<LeftRightAndRightDenominatorQuantity, RightNumeratorQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<LeftLeftQuantity, LeftRightAndRightDenominatorQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<RightNumeratorQuantity, LeftRightAndRightDenominatorQuantity>, RightUnit>,
	leftRightAndRightDenominatorUnitXRightNumeratorUnit: LeftRightAndRightDenominatorUnit.(RightNumeratorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.right.leftRightAndRightDenominatorUnitXRightNumeratorUnit(right.unit.numerator).byMultiplying(this, right, factory)

