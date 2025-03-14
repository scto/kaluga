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
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import kotlin.jvm.JvmName

// Div<A, B> / Inv<B> -> A

@JvmName("dividingDividedByReciprocalDenominator")
fun <
	NumeratorNumeratorQuantity : UndefinedQuantityType,
	NumeratorNumeratorUnit : UndefinedScientificUnit<NumeratorNumeratorQuantity>,
	NumeratorDenominatorAndDenominatorReciprocalQuantity : UndefinedQuantityType,
	NumeratorDenominatorAndDenominatorReciprocalUnit : UndefinedScientificUnit<NumeratorDenominatorAndDenominatorReciprocalQuantity>,
	NumeratorUnit : UndefinedDividedUnit<NumeratorNumeratorQuantity, NumeratorNumeratorUnit, NumeratorDenominatorAndDenominatorReciprocalQuantity, NumeratorDenominatorAndDenominatorReciprocalUnit>,
	DenominatorUnit : UndefinedReciprocalUnit<NumeratorDenominatorAndDenominatorReciprocalQuantity, NumeratorDenominatorAndDenominatorReciprocalUnit>,
	NumeratorNumeratorValue : UndefinedScientificValue<NumeratorNumeratorQuantity, NumeratorNumeratorUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<NumeratorNumeratorQuantity, NumeratorDenominatorAndDenominatorReciprocalQuantity>, NumeratorUnit>.div(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<NumeratorDenominatorAndDenominatorReciprocalQuantity>, DenominatorUnit>,
	factory: (Decimal, NumeratorNumeratorUnit) -> NumeratorNumeratorValue
) = unit.numerator.byDividing(this, right, factory)

