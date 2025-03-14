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
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.per
import kotlin.jvm.JvmName

// Div<Mul<A, B>, Mul<C, D>> / Div<A, D> -> Div<B, C>

@JvmName("dividingWithMultiplyingNumeratorAndMultiplyingDenominatorDividedByDividingUnitWithNumeratorLeftAsNumeratorAndDenominatorRightAsDenominator")
fun <
	NumeratorNumeratorLeftAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftAndDenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorUnit, NumeratorNumeratorRightQuantity, NumeratorNumeratorRightUnit>,
	NumeratorDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftUnit : UndefinedScientificUnit<NumeratorDenominatorLeftQuantity>,
	NumeratorDenominatorRightAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightAndDenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorDenominatorQuantity>,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftQuantity, NumeratorDenominatorLeftUnit, NumeratorDenominatorRightAndDenominatorDenominatorQuantity, NumeratorDenominatorRightAndDenominatorDenominatorUnit>,
	NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorQuantity, NumeratorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorQuantity>, NumeratorDenominatorUnit>,
	DenominatorUnit : UndefinedDividedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorUnit, NumeratorDenominatorRightAndDenominatorDenominatorQuantity, NumeratorDenominatorRightAndDenominatorDenominatorUnit>,
	TargetUnit : UndefinedDividedUnit<NumeratorNumeratorRightQuantity, NumeratorNumeratorRightUnit, NumeratorDenominatorLeftQuantity, NumeratorDenominatorLeftUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorRightQuantity, NumeratorDenominatorLeftQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorQuantity, NumeratorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftQuantity, NumeratorDenominatorRightAndDenominatorDenominatorQuantity>>, NumeratorUnit>.div(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorLeftAndDenominatorNumeratorQuantity, NumeratorDenominatorRightAndDenominatorDenominatorQuantity>, DenominatorUnit>,
	numeratorNumeratorRightUnitPerNumeratorDenominatorLeftUnit: NumeratorNumeratorRightUnit.(NumeratorDenominatorLeftUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.numerator.right.numeratorNumeratorRightUnitPerNumeratorDenominatorLeftUnit(unit.denominator.left).byDividing(this, right, factory)

