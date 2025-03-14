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
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.ScientificValue
import com.splendo.kaluga.scientific.UndefinedQuantityType
import com.splendo.kaluga.scientific.UndefinedScientificValue
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// Inv<Mul<Wr<A>, B>> * A! -> Inv<B>

@JvmName("reciprocalMultiplyingWithDefinedLeftMultipliedByDefinedUnit")
fun <
	LeftReciprocalLeftAndRightQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftReciprocalLeftAndRightUnit : ScientificUnit<LeftReciprocalLeftAndRightQuantity>,
	WrappedLeftReciprocalLeftAndRightUnit : WrappedUndefinedExtendedUnit<LeftReciprocalLeftAndRightQuantity, LeftReciprocalLeftAndRightUnit>,
	LeftReciprocalRightQuantity : UndefinedQuantityType,
	LeftReciprocalRightUnit : UndefinedScientificUnit<LeftReciprocalRightQuantity>,
	LeftReciprocalUnit : UndefinedMultipliedUnit<UndefinedQuantityType.Extended<LeftReciprocalLeftAndRightQuantity>, WrappedLeftReciprocalLeftAndRightUnit, LeftReciprocalRightQuantity, LeftReciprocalRightUnit>,
	LeftUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftReciprocalLeftAndRightQuantity>, LeftReciprocalRightQuantity>, LeftReciprocalUnit>,
	TargetUnit : UndefinedReciprocalUnit<LeftReciprocalRightQuantity, LeftReciprocalRightUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Reciprocal<LeftReciprocalRightQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<UndefinedQuantityType.Extended<LeftReciprocalLeftAndRightQuantity>, LeftReciprocalRightQuantity>>, LeftUnit>.times(
	right: ScientificValue<LeftReciprocalLeftAndRightQuantity, LeftReciprocalLeftAndRightUnit>,
	reciprocalTargetUnit: LeftReciprocalRightUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.inverse.right.reciprocalTargetUnit().byMultiplying(this, right, factory)

