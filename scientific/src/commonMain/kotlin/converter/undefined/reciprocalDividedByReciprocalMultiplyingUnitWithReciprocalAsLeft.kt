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
import kotlin.jvm.JvmName

// Inv<A> / Inv<Mul<A, B>> -> B

@JvmName("reciprocalDividedByReciprocalMultiplyingUnitWithReciprocalAsLeft")
fun <
	NumeratorReciprocalAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>,
	NumeratorUnit : UndefinedReciprocalUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalAndDenominatorReciprocalLeftUnit>,
	DenominatorReciprocalRightQuantity : UndefinedQuantityType,
	DenominatorReciprocalRightUnit : UndefinedScientificUnit<DenominatorReciprocalRightQuantity>,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, NumeratorReciprocalAndDenominatorReciprocalLeftUnit, DenominatorReciprocalRightQuantity, DenominatorReciprocalRightUnit>,
	DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, DenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
	DenominatorReciprocalRightValue : UndefinedScientificValue<DenominatorReciprocalRightQuantity, DenominatorReciprocalRightUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity>, NumeratorUnit>.div(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalAndDenominatorReciprocalLeftQuantity, DenominatorReciprocalRightQuantity>>, DenominatorUnit>,
	factory: (Decimal, DenominatorReciprocalRightUnit) -> DenominatorReciprocalRightValue
) = right.unit.inverse.right.byDividing(this, right, factory)

