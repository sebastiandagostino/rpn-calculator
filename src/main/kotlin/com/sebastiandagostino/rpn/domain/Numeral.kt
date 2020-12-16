package com.sebastiandagostino.rpn.domain

import java.math.BigDecimal
import java.math.RoundingMode

class Numeral(var value: BigDecimal, position: Int? = null): Symbol(position) {
    constructor(symbol: String, position: Int?): this(symbol.toBigDecimal(), position)

    init {
        value = value.setScale(PRECISION, RoundingMode.HALF_UP)
    }

    override fun isNumeral(): Boolean = true

    override fun toString(): String = value.setScale(DISPLAY, RoundingMode.DOWN).stripTrailingZeros().toPlainString()

    override fun equals(other: Any?): Boolean {
        return this.value == (other as Numeral).value
    }

    companion object{
        const val PRECISION = 15
        const val DISPLAY = 10

        fun isNumeral(string: String): Boolean {
            return string.toBigDecimalOrNull() != null
        }
    }
}