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
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import kotlin.jvm.JvmName

// Div<A, Mul<B, C>> * Mul<C, B> -> A

@JvmName("dividingWithMultiplyingDenominatorMultipliedByMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight")
fun <
	LeftNumeratorQuantity : UndefinedQuantityType,
	LeftNumeratorUnit : UndefinedScientificUnit<LeftNumeratorQuantity>,
	LeftDenominatorLeftAndRightRightQuantity : UndefinedQuantityType,
	LeftDenominatorLeftAndRightRightUnit : UndefinedScientificUnit<LeftDenominatorLeftAndRightRightQuantity>,
	LeftDenominatorRightAndRightLeftQuantity : UndefinedQuantityType,
	LeftDenominatorRightAndRightLeftUnit : UndefinedScientificUnit<LeftDenominatorRightAndRightLeftQuantity>,
	LeftDenominatorUnit : UndefinedMultipliedUnit<LeftDenominatorLeftAndRightRightQuantity, LeftDenominatorLeftAndRightRightUnit, LeftDenominatorRightAndRightLeftQuantity, LeftDenominatorRightAndRightLeftUnit>,
	LeftUnit : UndefinedDividedUnit<LeftNumeratorQuantity, LeftNumeratorUnit, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightRightQuantity, LeftDenominatorRightAndRightLeftQuantity>, LeftDenominatorUnit>,
	RightUnit : UndefinedMultipliedUnit<LeftDenominatorRightAndRightLeftQuantity, LeftDenominatorRightAndRightLeftUnit, LeftDenominatorLeftAndRightRightQuantity, LeftDenominatorLeftAndRightRightUnit>,
	LeftNumeratorValue : UndefinedScientificValue<LeftNumeratorQuantity, LeftNumeratorUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<LeftNumeratorQuantity, UndefinedQuantityType.Multiplying<LeftDenominatorLeftAndRightRightQuantity, LeftDenominatorRightAndRightLeftQuantity>>, LeftUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Multiplying<LeftDenominatorRightAndRightLeftQuantity, LeftDenominatorLeftAndRightRightQuantity>, RightUnit>,
	factory: (Decimal, LeftNumeratorUnit) -> LeftNumeratorValue
) = unit.numerator.byMultiplying(this, right, factory)

