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
import com.splendo.kaluga.scientific.byDividing
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.UndefinedMultipliedUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import com.splendo.kaluga.scientific.unit.UndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// Div<Wr<A>, Mul<B, C>> / Inv<Mul<C, B>> -> A!

@JvmName("dividingWithDefinedNumeratorAndMultiplyingDenominatorDividedByReciprocalMultiplyingUnitWithDenominatorRightAsLeftAndDenominatorLeftAsRight")
fun <
	NumeratorNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	NumeratorNumeratorUnit : ScientificUnit<NumeratorNumeratorQuantity>,
	WrappedNumeratorNumeratorUnit : WrappedUndefinedExtendedUnit<NumeratorNumeratorQuantity, NumeratorNumeratorUnit>,
	NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity : UndefinedQuantityType,
	NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit : UndefinedScientificUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>,
	NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity : UndefinedQuantityType,
	NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit : UndefinedScientificUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>,
	NumeratorDenominatorUnit : UndefinedMultipliedUnit<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit>,
	NumeratorUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<NumeratorNumeratorQuantity>, WrappedNumeratorNumeratorUnit, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>, NumeratorDenominatorUnit>,
	DenominatorReciprocalUnit : UndefinedMultipliedUnit<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftUnit, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightUnit>,
	DenominatorUnit : UndefinedReciprocalUnit<UndefinedQuantityType.Multiplying<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>, DenominatorReciprocalUnit>,
	NumeratorNumeratorValue : ScientificValue<NumeratorNumeratorQuantity, NumeratorNumeratorUnit>
	> UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<NumeratorNumeratorQuantity>, UndefinedQuantityType.Multiplying<NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity, NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity>>, NumeratorUnit>.div(
	right: UndefinedScientificValue<UndefinedQuantityType.Reciprocal<UndefinedQuantityType.Multiplying<NumeratorDenominatorRightAndDenominatorReciprocalLeftQuantity, NumeratorDenominatorLeftAndDenominatorReciprocalRightQuantity>>, DenominatorUnit>,
	factory: (Decimal, NumeratorNumeratorUnit) -> NumeratorNumeratorValue
) = unit.numerator.wrapped.byDividing(this, right, factory)

