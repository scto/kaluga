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
import com.splendo.kaluga.scientific.unit.x
import kotlin.jvm.JvmName

// Div<A, B> / Mul<A, C> -> Inv<Mul<B, C>>

@JvmName("dividingDividedByMultiplyingUnitWithNumeratorAsLeft")
fun <
	NumeratorNumeratorAndDenominatorLeftQuantity : UndefinedQuantityType,
	NumeratorNumeratorAndDenominatorLeftUnit : UndefinedScientificUnit<NumeratorNumeratorAndDenominatorLeftQuantity>,
	NumeratorDenominatorQuantity : UndefinedQuantityType,
	NumeratorDenominatorUnit : UndefinedScientificUnit<NumeratorDenominatorQuantity>,
	NumeratorUnit : UndefinedDividedUnit<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorNumeratorAndDenominatorLeftUnit, NumeratorDenominatorQuantity, NumeratorDenominatorUnit>,
	DenominatorRightQuantity : UndefinedQuantityType,
	DenominatorRightUnit : UndefinedScientificUnit<DenominatorRightQuantity>,
	DenominatorUnit : UndefinedMultipliedUnit<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorNumeratorAndDenominatorLeftUnit, DenominatorRightQuantity, DenominatorRightUnit>,
	TargetReciprocalUnit : UndefinedMultipliedUnit<NumeratorDenominatorQuantity, NumeratorDenominatorUnit, DenominatorRightQuantity, DenominatorRightUnit>,
	TargetUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorDenominatorQuantity, DenominatorRightQuantity>, TargetReciprocalUnit>,
	TargetValue : UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorDenominatorQuantity, DenominatorRightQuantity>>, TargetUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorAndDenominatorLeftQuantity, NumeratorDenominatorQuantity>, NumeratorUnit>.div(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorNumeratorAndDenominatorLeftQuantity, DenominatorRightQuantity>, DenominatorUnit>,
	numeratorDenominatorUnitXDenominatorRightUnit: NumeratorDenominatorUnit.(DenominatorRightUnit) -> TargetReciprocalUnit,
	reciprocalTargetUnit: TargetReciprocalUnit.() -> TargetUnit,
	factory: (Decimal, TargetUnit) -> TargetValue
) = unit.denominator.numeratorDenominatorUnitXDenominatorRightUnit(right.unit.right).reciprocalTargetUnit().byDividing(this, right, factory)

