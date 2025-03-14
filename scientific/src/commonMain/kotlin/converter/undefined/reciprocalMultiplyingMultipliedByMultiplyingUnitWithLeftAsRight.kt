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
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// Inv<Mul<A, B>> * Mul<C, A> -> Div<C, B>

@JvmName("reciprocalMultiplyingMultipliedByMultiplyingUnitWithLeftAsRight")
fun <
	LeftReciprocalLeftAndRightRightQuantity : UndefinedQuantityType,
	LeftReciprocalLeftAndRightRightUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightRightQuantity>,
	LeftReciprocalRightQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
	LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftAndRightRightQuantity, LeftReciprocalLeftAndRightRightUnit, LeftReciprocalRightQuantity, LeftReciprocalRightUnit>,
	LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftAndRightRightQuantity, LeftReciprocalRightQuantity>, LeftReciprocalUnit>,
	RightLeftQuantity : UndefinedQuantityType,
	RightLeftUnit : UndefinedScientificUnit<RightLeftQuantity>,
	RightUnit : UndefinedMultipliedUnit<RightLeftQuantity, RightLeftUnit, LeftReciprocalLeftAndRightRightQuantity, LeftReciprocalLeftAndRightRightUnit>,
	TargetUnit : UndefinedDividedUnit<RightLeftQuantity, RightLeftUnit, LeftReciprocalRightQuantity, LeftReciprocalRightUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<RightLeftQuantity, LeftReciprocalRightQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftAndRightRightQuantity, LeftReciprocalRightQuantity>>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<RightLeftQuantity, LeftReciprocalLeftAndRightRightQuantity>, RightUnit>,
	rightLeftUnitPerLeftReciprocalRightUnit: RightLeftUnit.(LeftReciprocalRightUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = right.unit.left.rightLeftUnitPerLeftReciprocalRightUnit(unit.inverse.right).byMultiplying(this, right, factory)

