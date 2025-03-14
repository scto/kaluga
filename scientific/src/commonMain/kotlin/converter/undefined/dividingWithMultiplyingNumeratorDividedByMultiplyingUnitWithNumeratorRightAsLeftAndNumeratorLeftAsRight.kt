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

// Div<Mul<A, B>, C> / Mul<B, A> -> Inv<C>

@JvmName("dividingWithMultiplyingNumeratorDividedByMultiplyingUnitWithNumeratorRightAsLeftAndNumeratorLeftAsRight")
fun <
	NumeratorNumeratorLeftAndDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftAndDenominatorRightUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorRightQuantity>,
	NumeratorNumeratorRightAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightAndDenominatorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorRightAndDenominatorLeftQuantity>,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorRightQuantity, NumeratorNumeratorLeftAndDenominatorRightUnit, NumeratorNumeratorRightAndDenominatorLeftQuantity, NumeratorNumeratorRightAndDenominatorLeftUnit>,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorRightQuantity, NumeratorNumeratorRightAndDenominatorLeftQuantity>, NumeratorNumeratorUnit, NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
	DenominatorUnit : UndefinedMultipliedUnit<NumeratorNumeratorRightAndDenominatorLeftQuantity, NumeratorNumeratorRightAndDenominatorLeftUnit, NumeratorNumeratorLeftAndDenominatorRightQuantity, NumeratorNumeratorLeftAndDenominatorRightUnit>,
	TargetUnit : UndefinedReciprocalUnit<NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Reciprocal<NumeratorDenominatorQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorRightQuantity, NumeratorNumeratorRightAndDenominatorLeftQuantity>, NumeratorDenominatorQuantity>, NumeratorUnit>.div(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightAndDenominatorLeftQuantity, NumeratorNumeratorLeftAndDenominatorRightQuantity>, DenominatorUnit>,
	reciprocalTargetUnit: NumeratorDenominatorUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.denominator.reciprocalTargetUnit().byDividing(this, right, factory)

