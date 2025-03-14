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

// Div<Mul<A, B>, Mul<C, D>> / Div<A, C> -> Div<B, D>

@JvmName("dividingWithMultiplyingNumeratorAndMultiplyingDenominatorDividedByDividingUnitWithNumeratorLeftAsNumeratorAndDenominatorLeftAsDenominator")
fun <
	NumeratorNumeratorLeftAndDenominatorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftAndDenominatorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorQuantity>,
	NumeratorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorUnit, NumeratorNumeratorRightQuantity, NumeratorNumeratorRightUnit>,
	NumeratorDenominatorLeftAndDenominatorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftAndDenominatorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>,
	NumeratorDenominatorRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightUnit : UndefinedScientificUnit<NumeratorDenominatorRightQuantity>,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
	NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorQuantity, NumeratorNumeratorRightQuantity>, NumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>, NumeratorDenominatorUnit>,
	DenominatorUnit : UndefinedDividedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorUnit, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorUnit>,
	TargetUnit : UndefinedDividedUnit<NumeratorNumeratorRightQuantity, NumeratorNumeratorRightUnit, NumeratorDenominatorRightQuantity, NumeratorDenominatorRightUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorRightQuantity, NumeratorDenominatorRightQuantity>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorQuantity, NumeratorNumeratorRightQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorDenominatorQuantity, NumeratorDenominatorRightQuantity>>, NumeratorUnit>.div(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorLeftAndDenominatorNumeratorQuantity, NumeratorDenominatorLeftAndDenominatorDenominatorQuantity>, DenominatorUnit>,
	numeratorNumeratorRightUnitPerNumeratorDenominatorRightUnit: NumeratorNumeratorRightUnit.(NumeratorDenominatorRightUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.numerator.right.numeratorNumeratorRightUnitPerNumeratorDenominatorRightUnit(unit.denominator.right).byDividing(this, right, factory)

