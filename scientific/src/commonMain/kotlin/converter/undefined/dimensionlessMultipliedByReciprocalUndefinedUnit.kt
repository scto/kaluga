@file:Suppress("ktlint:standard:wrapping")
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
import com.splendo.kaluga.scientific.unit.AbstractUndefinedScientificUnit
import com.splendo.kaluga.scientific.unit.DefinedScientificUnit
import com.splendo.kaluga.scientific.unit.Dimensionless
import com.splendo.kaluga.scientific.unit.MeasurementUsage
import com.splendo.kaluga.scientific.unit.ScientificUnit
import com.splendo.kaluga.scientific.unit.UndefinedReciprocalUnit
import kotlin.jvm.JvmName

// One * Inv<A> -> Inv<A>

@JvmName("dimensionlessMultipliedByReciprocalUndefinedUnit")
fun <
	LeftUnit : ScientificUnit<PhysicalQuantity.Dimensionless>,
	RightReciprocalQuantity : UndefinedQuantityType,
	RightReciprocalUnit : AbstractUndefinedScientificUnit<RightReciprocalQuantity>,
	RightUnit : UndefinedReciprocalUnit<
		RightReciprocalQuantity,
		RightReciprocalUnit,
		>,
	RightValue : UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		RightReciprocalQuantity,
		>,
RightUnit,
	>,
	> ScientificValue<PhysicalQuantity.Dimensionless, LeftUnit>.multipliedBy(
	right: UndefinedScientificValue<
	UndefinedQuantityType.Reciprocal<
		RightReciprocalQuantity,
		>,
RightUnit,
	>,
	factory: (Decimal, RightUnit) -> RightValue,
) = right.unit.byMultiplying(this, right, factory)
