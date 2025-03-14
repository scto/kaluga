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
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Div<Mul<A, B>, C> / Div<Mul<D, A>, E> -> Div<Mul<B, E>, Mul<C, D>>

@JvmName("dividingWithMultiplyingNumeratorDividedByDividingUnitWithMultiplyingNumeratorWithNumeratorLeftAsRight")
fun <
	NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>,
	NumeratorNumeratorRightQuantity : UndefinedQuantityType,
	NumeratorNumeratorRightUnit : UndefinedScientificUnit<NumeratorNumeratorRightQuantity>,
	NumeratorNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit, NumeratorNumeratorRightQuantity, NumeratorNumeratorRightUnit>,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightQuantity>, NumeratorNumeratorUnit, NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
	DenominatorNumeratorLeftQuantity : UndefinedQuantityType,
	DenominatorNumeratorLeftUnit : UndefinedScientificUnit<DenominatorNumeratorLeftQuantity>,
	DenominatorNumeratorUnit : UndefinedMultipliedUnit<DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightUnit>,
	DenominatorDenominatorQuantity : UndefinedQuantityType,
	DenominatorDenominatorUnit : UndefinedScientificUnit<DenominatorDenominatorQuantity>,
	DenominatorUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorNumeratorUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
	TargetNumeratorUnit : UndefinedMultipliedUnit<NumeratorNumeratorRightQuantity, NumeratorNumeratorRightUnit, DenominatorDenominatorQuantity, DenominatorDenominatorUnit>,
	TargetDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorQuantity, NumeratorDenominatorUnit, DenominatorNumeratorLeftQuantity, DenominatorNumeratorLeftUnit>,
	TargetUnit : UndefinedDividedUnit<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightQuantity, DenominatorDenominatorQuantity>, TargetNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorQuantity, DenominatorNumeratorLeftQuantity>, TargetDenominatorUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorRightQuantity, DenominatorDenominatorQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorQuantity, DenominatorNumeratorLeftQuantity>>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity, NumeratorNumeratorRightQuantity>, NumeratorDenominatorQuantity>, NumeratorUnit>.div(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Multiplying<DenominatorNumeratorLeftQuantity, NumeratorNumeratorLeftAndDenominatorNumeratorRightQuantity>, DenominatorDenominatorQuantity>, DenominatorUnit>,
	numeratorNumeratorRightUnitXDenominatorDenominatorUnit: NumeratorNumeratorRightUnit.(DenominatorDenominatorUnit) -> TargetNumeratorUnit,
	numeratorDenominatorUnitXDenominatorNumeratorLeftUnit: NumeratorDenominatorUnit.(DenominatorNumeratorLeftUnit) -> TargetDenominatorUnit,
	targetNumeratorUnitPerTargetDenominatorUnit: TargetNumeratorUnit.(TargetDenominatorUnit) -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.numerator.right.numeratorNumeratorRightUnitXDenominatorDenominatorUnit(right.unit.denominator).targetNumeratorUnitPerTargetDenominatorUnit(unit.denominator.numeratorDenominatorUnitXDenominatorNumeratorLeftUnit(right.unit.numerator.left)).byDividing(this, right, factory)

