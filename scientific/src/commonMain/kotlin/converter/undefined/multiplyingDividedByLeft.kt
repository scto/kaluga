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
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import kotlin.jvm.JvmName

// Mul<A, B> / A -> B

@JvmName("multiplyingDividedByLeft")
fun <
	NumeratorLeftAndDenominatorQuantity : UndefinedQuantityType,
	NumeratorLeftAndDenominatorUnit : UndefinedScientificUnit<NumeratorLeftAndDenominatorQuantity>,
	NumeratorRightQuantity : UndefinedQuantityType,
	NumeratorRightUnit : UndefinedScientificUnit<NumeratorRightQuantity>,
	NumeratorUnit : UndefinedMultipliedUnit<NumeratorLeftAndDenominatorQuantity, NumeratorLeftAndDenominatorUnit, NumeratorRightQuantity, NumeratorRightUnit>,
	NumeratorRightValue : UndefinedScientificValue<NumeratorRightQuantity, NumeratorRightUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Multiplying<NumeratorLeftAndDenominatorQuantity, NumeratorRightQuantity>, NumeratorUnit>.div(
	right: UndefinedScientificValue<NumeratorLeftAndDenominatorQuantity, NumeratorLeftAndDenominatorUnit>,
	factory: (Decimal, NumeratorRightUnit) -> NumeratorRightValue
) = unit.right.byDividing(this, right, factory)

