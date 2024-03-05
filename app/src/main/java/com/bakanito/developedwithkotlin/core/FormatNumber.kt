package com.bakanito.developedwithkotlin.core

object FormatNumber {
    fun toDecimals(stringWeightHeight: String): String {
        val num = stringWeightHeight.toInt() / 10.0
        return String.format("%.1f", num).replace(",", ".")
    }
}