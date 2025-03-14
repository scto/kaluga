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
import com.splendo.kaluga.scientific.DefaultScientificValue
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Inv<A> / Inv<Mul<Wr<B>, A>> -> B!

@JvmName("reciprocalDividedByReciprocalMultiplyingWithDefinedLeftAndSelfAsRight")
fun <
	NumeratorReciprocalAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalAndDenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>,
	NumeratorUnit : UndefinedReciprocalUnit<NumeratorReciprocalAndDenominatorReciprocalRightQuantity, NumeratorReciprocalAndDenominatorReciprocalRightUnit>,
	DenominatorReciprocalLeftQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	DenominatorReciprocalLeftUnit : ScientificUnit<DenominatorReciprocalLeftQuantity>,
	WrappedDenominatorReciprocalLeftUnit : WrappedUndefinedExtendedUnit<DenominatorReciprocalLeftQuantity, DenominatorReciprocalLeftUnit>,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<DenominatorReciprocalLeftQuantity>, WrappedDenominatorReciprocalLeftUnit, NumeratorReciprocalAndDenominatorReciprocalRightQuantity, NumeratorReciprocalAndDenominatorReciprocalRightUnit>,
	DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<DenominatorReciprocalLeftQuantity>, NumeratorReciprocalAndDenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
	DenominatorReciprocalLeftValue : ScientificValue<DenominatorReciprocalLeftQuantity, DenominatorReciprocalLeftUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<NumeratorReciprocalAndDenominatorReciprocalRightQuantity>, NumeratorUnit>.div(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<DenominatorReciprocalLeftQuantity>, NumeratorReciprocalAndDenominatorReciprocalRightQuantity>>, DenominatorUnit>,
	factory: (Decimal, DenominatorReciprocalLeftUnit) -> DenominatorReciprocalLeftValue
) = right.unit.inverse.left.wrapped.byDividing(this, right, factory)

