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

// Inv<Mul<A, B>> * Mul<A, C> -> Div<C, B>

@JvmName("reciprocalMultiplyingMultipliedByMultiplyingUnitWithReciprocalLeftAsLeft")
fun <
	LeftReciprocalLeftAndRightLeftQuantity : UndefinedQuantityType,
	LeftReciprocalLeftAndRightLeftUnit : UndefinedScientificUnit<LeftReciprocalLeftAndRightLeftQuantity>,
	LeftReciprocalRightQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
	LeftReciprocalUnit : UndefinedMultipliedUnit<LeftReciprocalLeftAndRightLeftQuantity, LeftReciprocalLeftAndRightLeftUnit, LeftReciprocalRightQuantity, LeftReciprocalRightUnit>,
	LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftReciprocalLeftAndRightLeftQuantity, LeftReciprocalRightQuantity>, LeftReciprocalUnit>,
	RightRightQuantity : UndefinedQuantityType,
	RightRightUnit : UndefinedScientificUnit<RightRightQuantity>,
	RightUnit : UndefinedMultipliedUnit<LeftReciprocalLeftAndRightLeftQuantity, LeftReciprocalLeftAndRightLeftUnit, RightRightQuantity, RightRightUnit>,
	TargetUnit : UndefinedDividedUnit<RightRightQuantity, RightRightUnit, LeftReciprocalRightQuantity, LeftReciprocalRightUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<RightRightQuantity, LeftReciprocalRightQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftReciprocalLeftAndRightLeftQuantity, LeftReciprocalRightQuantity>>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<LeftReciprocalLeftAndRightLeftQuantity, RightRightQuantity>, RightUnit>,
	rightRightUnitPerLeftReciprocalRightUnit: RightRightUnit.(LeftReciprocalRightUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = right.unit.right.rightRightUnitPerLeftReciprocalRightUnit(unit.inverse.right).byMultiplying(this, right, factory)

