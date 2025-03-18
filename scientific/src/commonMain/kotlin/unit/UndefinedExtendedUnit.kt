/*
 Copyright 2023 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.scientific.unit

import com.splendo.kaluga.base.utils.Decimal
import com.splendo.kaluga.base.utils.div
import com.splendo.kaluga.base.utils.minus
import com.splendo.kaluga.base.utils.plus
import com.splendo.kaluga.base.utils.times
import com.splendo.kaluga.base.utils.toDecimal
import com.splendo.kaluga.scientific.PhysicalQuantity
import com.splendo.kaluga.scientific.UndefinedQuantityType
import kotlinx.serialization.Serializable

sealed interface UndefinedExtendedUnit<
    ExtendedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    > :
    UndefinedScientificUnit<UndefinedQuantityType.Extended<ExtendedQuantity>> {

    sealed interface MetricAndImperial<ExtendedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension> :
        UndefinedExtendedUnit<ExtendedQuantity>,
        UndefinedScientificUnit.MetricAndImperial<UndefinedQuantityType.Extended<ExtendedQuantity>>

    sealed interface Metric<ExtendedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension> :
        UndefinedExtendedUnit<ExtendedQuantity>,
        UndefinedScientificUnit.Metric<UndefinedQuantityType.Extended<ExtendedQuantity>>

    sealed interface Imperial<ExtendedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension> :
        UndefinedExtendedUnit<ExtendedQuantity>,
        UndefinedScientificUnit.Imperial<UndefinedQuantityType.Extended<ExtendedQuantity>>

    sealed interface UKImperial<ExtendedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension> :
        UndefinedExtendedUnit<ExtendedQuantity>,
        UndefinedScientificUnit.UKImperial<UndefinedQuantityType.Extended<ExtendedQuantity>>

    sealed interface USCustomary<ExtendedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension> :
        UndefinedExtendedUnit<ExtendedQuantity>,
        UndefinedScientificUnit.USCustomary<UndefinedQuantityType.Extended<ExtendedQuantity>>

    sealed interface MetricAndUKImperial<ExtendedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension> :
        UndefinedExtendedUnit<ExtendedQuantity>,
        UndefinedScientificUnit.MetricAndUKImperial<UndefinedQuantityType.Extended<ExtendedQuantity>>

    sealed interface MetricAndUSCustomary<ExtendedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension> :
        UndefinedExtendedUnit<ExtendedQuantity>,
        UndefinedScientificUnit.MetricAndUSCustomary<UndefinedQuantityType.Extended<ExtendedQuantity>>

    val extendedQuantity: ExtendedQuantity
    override val quantityType get() = UndefinedQuantityType.Extended(extendedQuantity)

    override val numeratorUnits: List<ScientificUnit<*>> get() = listOf(this)
    override val denominatorUnits: List<ScientificUnit<*>> get() = emptyList()
}

@Serializable
sealed class CustomUndefinedExtendedUnit<
    ExtendedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    > :
    AbstractUndefinedScientificUnit<UndefinedQuantityType.Extended<ExtendedQuantity>>(),
    UndefinedExtendedUnit<ExtendedQuantity> {

    abstract val siFactor: Double
    abstract val siOffset: Double
    private val siFactorDecimal by lazy { siFactor.toDecimal() }
    private val siOffsetDecimal by lazy { siOffset.toDecimal() }

    override fun fromSIUnit(value: Decimal): Decimal = (value * siFactorDecimal) + siOffsetDecimal
    override fun toSIUnit(value: Decimal): Decimal = (value - siOffsetDecimal) / siFactorDecimal

    @Serializable
    data class MetricAndImperial<ExtendedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension>(
        override val extendedQuantity: ExtendedQuantity,
        override val siFactor: Double,
        override val siOffset: Double,
        override val symbol: String,
    ) : CustomUndefinedExtendedUnit<ExtendedQuantity>(),
        UndefinedExtendedUnit.MetricAndImperial<ExtendedQuantity> {
        override val system = MeasurementSystem.MetricAndImperial

        override val metric: Metric<ExtendedQuantity> by lazy {
            Metric<ExtendedQuantity>(extendedQuantity, siFactor, siOffset, symbol)
        }
        override val imperial: Imperial<ExtendedQuantity> by lazy {
            Imperial<ExtendedQuantity>(extendedQuantity, siFactor, siOffset, symbol)
        }
        override val ukImperial: UKImperial<ExtendedQuantity> by lazy {
            UKImperial<ExtendedQuantity>(extendedQuantity, siFactor, siOffset, symbol)
        }
        override val usCustomary: USCustomary<ExtendedQuantity> by lazy {
            USCustomary<ExtendedQuantity>(extendedQuantity, siFactor, siOffset, symbol)
        }
        override val metricAndUKImperial: MetricAndUKImperial<ExtendedQuantity> by lazy {
            MetricAndUKImperial<ExtendedQuantity>(extendedQuantity, siFactor, siOffset, symbol)
        }
        override val metricAndUSCustomary: MetricAndUSCustomary<ExtendedQuantity> by lazy {
            MetricAndUSCustomary<ExtendedQuantity>(extendedQuantity, siFactor, siOffset, symbol)
        }
    }

    @Serializable
    data class Metric<ExtendedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension>(
        override val extendedQuantity: ExtendedQuantity,
        override val siFactor: Double,
        override val siOffset: Double,
        override val symbol: String,
    ) : CustomUndefinedExtendedUnit<ExtendedQuantity>(),
        UndefinedExtendedUnit.Metric<ExtendedQuantity> {
        override val system = MeasurementSystem.Metric
    }

    @Serializable
    data class Imperial<ExtendedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension>(
        override val extendedQuantity: ExtendedQuantity,
        override val siFactor: Double,
        override val siOffset: Double,
        override val symbol: String,
    ) : CustomUndefinedExtendedUnit<ExtendedQuantity>(),
        UndefinedExtendedUnit.Imperial<ExtendedQuantity> {
        override val system = MeasurementSystem.Imperial

        override val ukImperial: UKImperial<ExtendedQuantity> by lazy {
            UKImperial<ExtendedQuantity>(extendedQuantity, siFactor, siOffset, symbol)
        }
        override val usCustomary: USCustomary<ExtendedQuantity> by lazy {
            USCustomary<ExtendedQuantity>(extendedQuantity, siFactor, siOffset, symbol)
        }
    }

    @Serializable
    data class UKImperial<ExtendedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension>(
        override val extendedQuantity: ExtendedQuantity,
        override val siFactor: Double,
        override val siOffset: Double,
        override val symbol: String,
    ) : CustomUndefinedExtendedUnit<ExtendedQuantity>(),
        UndefinedExtendedUnit.UKImperial<ExtendedQuantity> {
        override val system = MeasurementSystem.UKImperial
    }

    @Serializable
    data class USCustomary<ExtendedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension>(
        override val extendedQuantity: ExtendedQuantity,
        override val siFactor: Double,
        override val siOffset: Double,
        override val symbol: String,
    ) : CustomUndefinedExtendedUnit<ExtendedQuantity>(),
        UndefinedExtendedUnit.USCustomary<ExtendedQuantity> {
        override val system = MeasurementSystem.USCustomary
    }

    @Serializable
    data class MetricAndUKImperial<ExtendedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension>(
        override val extendedQuantity: ExtendedQuantity,
        override val siFactor: Double,
        override val siOffset: Double,
        override val symbol: String,
    ) : CustomUndefinedExtendedUnit<ExtendedQuantity>(),
        UndefinedExtendedUnit.MetricAndUKImperial<ExtendedQuantity> {
        override val system = MeasurementSystem.MetricAndUKImperial

        override val metric: Metric<ExtendedQuantity> by lazy {
            Metric<ExtendedQuantity>(extendedQuantity, siFactor, siOffset, symbol)
        }
        override val ukImperial: UKImperial<ExtendedQuantity> by lazy {
            UKImperial<ExtendedQuantity>(extendedQuantity, siFactor, siOffset, symbol)
        }
    }

    @Serializable
    data class MetricAndUSCustomary<ExtendedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension>(
        override val extendedQuantity: ExtendedQuantity,
        override val siFactor: Double,
        override val siOffset: Double,
        override val symbol: String,
    ) : CustomUndefinedExtendedUnit<ExtendedQuantity>(),
        UndefinedExtendedUnit.MetricAndUSCustomary<ExtendedQuantity> {
        override val system = MeasurementSystem.MetricAndUSCustomary

        override val metric: Metric<ExtendedQuantity> by lazy {
            Metric<ExtendedQuantity>(extendedQuantity, siFactor, siOffset, symbol)
        }
        override val usCustomary: USCustomary<ExtendedQuantity> by lazy {
            USCustomary<ExtendedQuantity>(extendedQuantity, siFactor, siOffset, symbol)
        }
    }
}

@Serializable
sealed class WrappedUndefinedExtendedUnit<
    WrappedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    WrappedUnit : ScientificUnit<WrappedQuantity>,
    > :
    AbstractUndefinedScientificUnit<UndefinedQuantityType.Extended<WrappedQuantity>>(),
    UndefinedExtendedUnit<WrappedQuantity> {
    abstract val wrapped: WrappedUnit
    override val extendedQuantity: WrappedQuantity by lazy { wrapped.quantity }

    override val numeratorUnits: List<ScientificUnit<*>> by lazy { listOf(wrapped) }

    override fun fromSIUnit(value: Decimal): Decimal = wrapped.toSIUnit(value)
    override fun toSIUnit(value: Decimal): Decimal = wrapped.fromSIUnit(value)
    override fun deltaFromSIUnitDelta(delta: Decimal): Decimal = wrapped.deltaFromSIUnitDelta(delta)
    override fun deltaToSIUnitDelta(delta: Decimal): Decimal = wrapped.deltaToSIUnitDelta(delta)

    @Serializable
    data class MetricAndImperial<
        WrappedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
        WrappedUnit,
        > internal constructor(
        override val wrapped: WrappedUnit,
    ) : WrappedUndefinedExtendedUnit<WrappedQuantity, WrappedUnit>(),
        UndefinedExtendedUnit.MetricAndImperial<WrappedQuantity> where
              WrappedUnit : AbstractScientificUnit<WrappedQuantity>,
              WrappedUnit : MeasurementUsage.UsedInMetric,
              WrappedUnit : MeasurementUsage.UsedInUKImperial,
              WrappedUnit : MeasurementUsage.UsedInUSCustomary {
        override val system = MeasurementSystem.MetricAndImperial
        override val metric: Metric<WrappedQuantity, WrappedUnit> by lazy { Metric(wrapped) }
        override val imperial: Imperial<WrappedQuantity, WrappedUnit> by lazy { Imperial(wrapped) }
        override val ukImperial: UKImperial<WrappedQuantity, WrappedUnit> by lazy { UKImperial(wrapped) }
        override val usCustomary: USCustomary<WrappedQuantity, WrappedUnit> by lazy { USCustomary(wrapped) }
        override val metricAndUKImperial: MetricAndUKImperial<WrappedQuantity, WrappedUnit> by lazy { MetricAndUKImperial(wrapped) }
        override val metricAndUSCustomary: MetricAndUSCustomary<WrappedQuantity, WrappedUnit> by lazy { MetricAndUSCustomary(wrapped) }
    }

    @Serializable
    data class Metric<
        WrappedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
        WrappedUnit,
        > internal constructor(
        override val wrapped: WrappedUnit,
    ) : WrappedUndefinedExtendedUnit<WrappedQuantity, WrappedUnit>(),
        UndefinedExtendedUnit.Metric<WrappedQuantity> where
              WrappedUnit : AbstractScientificUnit<WrappedQuantity>,
              WrappedUnit : MeasurementUsage.UsedInMetric {
        override val system = MeasurementSystem.Metric
    }

    @Serializable
    data class Imperial<
        WrappedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
        WrappedUnit,
        > internal constructor(
        override val wrapped: WrappedUnit,
    ) : WrappedUndefinedExtendedUnit<WrappedQuantity, WrappedUnit>(),
        UndefinedExtendedUnit.Imperial<WrappedQuantity> where
              WrappedUnit : AbstractScientificUnit<WrappedQuantity>,
              WrappedUnit : MeasurementUsage.UsedInUKImperial,
              WrappedUnit : MeasurementUsage.UsedInUSCustomary {
        override val system = MeasurementSystem.Imperial
        override val ukImperial: UKImperial<WrappedQuantity, WrappedUnit> by lazy { UKImperial(wrapped) }
        override val usCustomary: USCustomary<WrappedQuantity, WrappedUnit> by lazy { USCustomary(wrapped) }
    }

    @Serializable
    data class UKImperial<
        WrappedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
        WrappedUnit,
        > internal constructor(
        override val wrapped: WrappedUnit,
    ) : WrappedUndefinedExtendedUnit<WrappedQuantity, WrappedUnit>(),
        UndefinedExtendedUnit.UKImperial<WrappedQuantity> where
              WrappedUnit : AbstractScientificUnit<WrappedQuantity>,
              WrappedUnit : MeasurementUsage.UsedInUKImperial {
        override val system = MeasurementSystem.UKImperial
    }

    @Serializable
    data class USCustomary<
        WrappedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
        WrappedUnit,
        > internal constructor(
        override val wrapped: WrappedUnit,
    ) : WrappedUndefinedExtendedUnit<WrappedQuantity, WrappedUnit>(),
        UndefinedExtendedUnit.USCustomary<WrappedQuantity> where
              WrappedUnit : AbstractScientificUnit<WrappedQuantity>,
              WrappedUnit : MeasurementUsage.UsedInUSCustomary {
        override val system = MeasurementSystem.USCustomary
    }

    @Serializable
    data class MetricAndUKImperial<
        WrappedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
        WrappedUnit,
        > internal constructor(
        override val wrapped: WrappedUnit,
    ) : WrappedUndefinedExtendedUnit<WrappedQuantity, WrappedUnit>(),
        UndefinedExtendedUnit.MetricAndUKImperial<WrappedQuantity> where
              WrappedUnit : AbstractScientificUnit<WrappedQuantity>,
              WrappedUnit : MeasurementUsage.UsedInMetric,
              WrappedUnit : MeasurementUsage.UsedInUKImperial {
        override val system = MeasurementSystem.MetricAndUKImperial
        override val metric: Metric<WrappedQuantity, WrappedUnit> by lazy { Metric(wrapped) }
        override val ukImperial: UKImperial<WrappedQuantity, WrappedUnit> by lazy { UKImperial(wrapped) }
    }

    @Serializable
    data class MetricAndUSCustomary<
        WrappedQuantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
        WrappedUnit,
        > internal constructor(
        override val wrapped: WrappedUnit,
    ) : WrappedUndefinedExtendedUnit<WrappedQuantity, WrappedUnit>(),
        UndefinedExtendedUnit.MetricAndUSCustomary<WrappedQuantity> where
              WrappedUnit : AbstractScientificUnit<WrappedQuantity>,
              WrappedUnit : MeasurementUsage.UsedInMetric,
              WrappedUnit : MeasurementUsage.UsedInUSCustomary {
        override val system = MeasurementSystem.MetricAndUSCustomary
        override val metric: Metric<WrappedQuantity, WrappedUnit> by lazy { Metric(wrapped) }
        override val usCustomary: USCustomary<WrappedQuantity, WrappedUnit> by lazy { USCustomary(wrapped) }
    }
}

fun <
    Quantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    Unit,
    > Unit.asUndefined() where
                               Unit : AbstractScientificUnit<Quantity>,
                               Unit : MeasurementUsage.UsedInMetric,
                               Unit : MeasurementUsage.UsedInUKImperial,
                               Unit : MeasurementUsage.UsedInUSCustomary =
    WrappedUndefinedExtendedUnit.MetricAndImperial(
        this,
    )
fun <
    Quantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    Unit,
    > Unit.asUndefined() where
                               Unit : AbstractScientificUnit<Quantity>,
                               Unit : MeasurementUsage.UsedInMetric =
    WrappedUndefinedExtendedUnit.Metric(this)
fun <
    Quantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    Unit,
    > Unit.asUndefined() where
                               Unit : AbstractScientificUnit<Quantity>,
                               Unit : MeasurementUsage.UsedInUKImperial,
                               Unit : MeasurementUsage.UsedInUSCustomary =
    WrappedUndefinedExtendedUnit.Imperial(
        this,
    )
fun <
    Quantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    Unit,
    > Unit.asUndefined() where
                               Unit : AbstractScientificUnit<Quantity>,
                               Unit : MeasurementUsage.UsedInUKImperial =
    WrappedUndefinedExtendedUnit.UKImperial(this)
fun <
    Quantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    Unit,
    > Unit.asUndefined() where
                               Unit : AbstractScientificUnit<Quantity>,
                               Unit : MeasurementUsage.UsedInUSCustomary =
    WrappedUndefinedExtendedUnit.USCustomary(this)
fun <
    Quantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    Unit,
    > Unit.asUndefined() where
                               Unit : AbstractScientificUnit<Quantity>,
                               Unit : MeasurementUsage.UsedInMetric,
                               Unit : MeasurementUsage.UsedInUKImperial =
    WrappedUndefinedExtendedUnit.MetricAndUKImperial(
        this,
    )
fun <
    Quantity : PhysicalQuantity.DefinedPhysicalQuantityWithDimension,
    Unit,
    > Unit.asUndefined() where
                               Unit : AbstractScientificUnit<Quantity>,
                               Unit : MeasurementUsage.UsedInMetric,
                               Unit : MeasurementUsage.UsedInUSCustomary =
    WrappedUndefinedExtendedUnit.MetricAndUSCustomary(
        this,
    )
