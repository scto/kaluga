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
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.Dimensionless
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.One
import kotlin.jvm.JvmName

// Mul<A, B> * Inv<Mul<B, A>> -> One

@JvmName("multiplyingMultipliedByReciprocalSelfFlipped")
fun <
	LeftLeftAndRightReciprocalRightQuantity : UndefinedQuantityType,
	LeftLeftAndRightReciprocalRightUnit : UndefinedScientificUnit<LeftLeftAndRightReciprocalRightQuantity>,
	LeftRightAndRightReciprocalLeftQuantity : UndefinedQuantityType,
	LeftRightAndRightReciprocalLeftUnit : UndefinedScientificUnit<LeftRightAndRightReciprocalLeftQuantity>,
	LeftUnit : UndefinedMultipliedUnit<LeftLeftAndRightReciprocalRightQuantity, LeftLeftAndRightReciprocalRightUnit, LeftRightAndRightReciprocalLeftQuantity, LeftRightAndRightReciprocalLeftUnit>,
	RightReciprocalUnit : UndefinedMultipliedUnit<LeftRightAndRightReciprocalLeftQuantity, LeftRightAndRightReciprocalLeftUnit, LeftLeftAndRightReciprocalRightQuantity, LeftLeftAndRightReciprocalRightUnit>,
	RightUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<LeftRightAndRightReciprocalLeftQuantity, LeftLeftAndRightReciprocalRightQuantity>, RightReciprocalUnit>,
	TargetUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
	TargetValue : ScientificValue<PhysicalQuantity.Dimensionless, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<LeftLeftAndRightReciprocalRightQuantity, LeftRightAndRightReciprocalLeftQuantity>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<LeftRightAndRightReciprocalLeftQuantity, LeftLeftAndRightReciprocalRightQuantity>>, RightUnit>,
	getDimensionless: () -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = getDimensionless().byMultiplying(this, right, factory)

