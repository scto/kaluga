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
import com.splendo.kaluga.scientific.byMultiplying
import com.splendo.kaluga.scientific.unit.AbstractScientificUnit
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedDividedUnit
import com.splendo.kaluga.scientific.unit.WrappedUndefinedExtendedUnit
import kotlin.jvm.JvmName

// A! * Div<Wr<B>, Wr<A>> -> B!

@JvmName("definedMultipliedByDividingUnitWithDefinedNumeratorAndSelfAsDenominator")
fun <
	LeftAndRightDenominatorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	LeftAndRightDenominatorUnit : ScientificUnit<LeftAndRightDenominatorQuantity>,
	RightNumeratorQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
	RightNumeratorUnit : ScientificUnit<RightNumeratorQuantity>,
	WrappedRightNumeratorUnit : WrappedUndefinedExtendedUnit<RightNumeratorQuantity, RightNumeratorUnit>,
	WrappedLeftAndRightDenominatorUnit : WrappedUndefinedExtendedUnit<LeftAndRightDenominatorQuantity, LeftAndRightDenominatorUnit>,
	RightUnit : UndefinedDividedUnit<UndefinedQuantityType.Extended<RightNumeratorQuantity>, WrappedRightNumeratorUnit, UndefinedQuantityType.Extended<LeftAndRightDenominatorQuantity>, WrappedLeftAndRightDenominatorUnit>,
	RightNumeratorValue : ScientificValue<RightNumeratorQuantity, RightNumeratorUnit>
	> ScientificValue<LeftAndRightDenominatorQuantity, LeftAndRightDenominatorUnit>.times(
	right: UndefinedScientificValue<UndefinedQuantityType.Dividing<UndefinedQuantityType.Extended<RightNumeratorQuantity>, UndefinedQuantityType.Extended<LeftAndRightDenominatorQuantity>>, RightUnit>,
	factory: (Decimal, RightNumeratorUnit) -> RightNumeratorValue
) = right.unit.numerator.wrapped.byMultiplying(this, right, factory)

