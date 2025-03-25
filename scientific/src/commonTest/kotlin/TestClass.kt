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

package com.splendo.kaluga.scientific

import com.splendo.kaluga.scientific.converter.undefined.metricAndImperialDividedByMetricAndImperial
import com.splendo.kaluga.scientific.unit.Ampere
import com.splendo.kaluga.scientific.unit.Biot
import com.splendo.kaluga.scientific.unit.Kilowatt
import com.splendo.kaluga.scientific.unit.Watt
import com.splendo.kaluga.scientific.unit.reciprocal
import com.splendo.kaluga.scientific.unit.x

fun test() {
    val left = 1((Watt x Ampere).reciprocal())
    val right = 2((Biot x Kilowatt).reciprocal())
    val test = left metricAndImperialDividedByMetricAndImperial right

}