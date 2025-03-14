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
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// Inv<Mul<A, B>> / Inv<A> -> Inv<B>

@JvmName("reciprocalMultiplyingDividedByReciprocalUndefinedUnit")
fun <
	NumeratorReciprocalLeftAndDenominatorReciprocalQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftAndDenominatorReciprocalUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorReciprocalQuantity>,
	NumeratorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalRightUnit : UndefinedScientificUnit<NumeratorReciprocalRightQuantity>,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalLeftAndDenominatorReciprocalQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalUnit, NumeratorReciprocalRightQuantity, NumeratorReciprocalRightUnit>,
	NumeratorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorReciprocalQuantity, NumeratorReciprocalRightQuantity>, NumeratorReciprocalUnit>,
	DenominatorUnit : UndefinedReciprocalUnit<NumeratorReciprocalLeftAndDenominatorReciprocalQuantity, NumeratorReciprocalLeftAndDenominatorReciprocalUnit>,
	TargetUnit : UndefinedReciprocalUnit<NumeratorReciprocalRightQuantity, NumeratorReciprocalRightUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Reciprocal<NumeratorReciprocalRightQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorReciprocalQuantity, NumeratorReciprocalRightQuantity>>, NumeratorUnit>.div(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<NumeratorReciprocalLeftAndDenominatorReciprocalQuantity>, DenominatorUnit>,
	reciprocalTargetUnit: NumeratorReciprocalRightUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.inverse.right.reciprocalTargetUnit().byDividing(this, right, factory)

