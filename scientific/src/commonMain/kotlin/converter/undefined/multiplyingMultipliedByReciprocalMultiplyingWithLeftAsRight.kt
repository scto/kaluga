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

// Mul<A, B> * Inv<Mul<C, A>> -> Div<B, C>

@JvmName("multiplyingMultipliedByReciprocalMultiplyingWithLeftAsRight")
fun <
	LeftLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
	LeftLeftAndRightReciprocalRightUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
	LeftRightQuantity : UndefinedQuantityType,
	LeftRightUnit : UndefinedScientificUnit<LeftRightQuantity>,
	LeftUnit : UndefinedMultipliedUnit<LeftLeftAndRightReciprocalRightQuantity, LeftLeftAndRightReciprocalRightUnit, LeftRightQuantity, LeftRightUnit>,
	RightReciprocalLeftQuantity : UndefinedQuantityType,
	RightReciprocalLeftUnit : UndefinedScientificUnit<RightReciprocalLeftQuantity>,
	RightReciprocalUnit : UndefinedMultipliedUnit<RightReciprocalLeftQuantity, RightReciprocalLeftUnit, LeftLeftAndRightReciprocalRightQuantity, LeftLeftAndRightReciprocalRightUnit>,
	RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<RightReciprocalLeftQuantity, LeftLeftAndRightReciprocalRightQuantity>, RightReciprocalUnit>,
	TargetUnit : UndefinedDividedUnit<LeftRightQuantity, LeftRightUnit, RightReciprocalLeftQuantity, RightReciprocalLeftUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftRightQuantity, RightReciprocalLeftQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<LeftLeftAndRightReciprocalRightQuantity, LeftRightQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<RightReciprocalLeftQuantity, LeftLeftAndRightReciprocalRightQuantity>>, RightUnit>,
	leftRightUnitPerRightReciprocalLeftUnit: LeftRightUnit.(RightReciprocalLeftUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.right.leftRightUnitPerRightReciprocalLeftUnit(right.unit.inverse.left).byMultiplying(this, right, factory)

