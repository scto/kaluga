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
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.reciprocal
import kotlin.jvm.JvmName

// Inv<Mul<A, B>> / Div<C, Mul<B, A>> -> Inv<C>

@JvmName("reciprocalMultiplyingDividedByDividingUnitWithSelfFlippedAsDenominator")
fun <
	NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit : UndefinedScientificUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>,
	NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>,
	NumeratorReciprocalUnit : UndefinedMultipliedUnit<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit>,
	NumeratorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>, NumeratorReciprocalUnit>,
	DenominatorNumeratorQuantity : UndefinedQuantityType,
	DenominatorNumeratorUnit : UndefinedScientificUnit<DenominatorNumeratorQuantity>,
	DenominatorDenominatorUnit : UndefinedMultipliedUnit<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftUnit, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightUnit>,
	DenominatorUnit : UndefinedDividedUnit<DenominatorNumeratorQuantity, DenominatorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>, DenominatorDenominatorUnit>,
	TargetUnit : UndefinedReciprocalUnit<DenominatorNumeratorQuantity, DenominatorNumeratorUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Reciprocal<DenominatorNumeratorQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity, NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity>>, NumeratorUnit>.div(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<DenominatorNumeratorQuantity, UndefinedQuantityType.Multiplying<NumeratorReciprocalRightAndDenominatorDenominatorLeftQuantity, NumeratorReciprocalLeftAndDenominatorDenominatorRightQuantity>>, DenominatorUnit>,
	reciprocalTargetUnit: DenominatorNumeratorUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = right.unit.numerator.reciprocalTargetUnit().byDividing(this, right, factory)

