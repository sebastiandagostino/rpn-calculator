package com.sebastiandagostino.rpn.domain

import org.junit.Test
import java.math.BigDecimal
import kotlin.math.sqrt
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class NumeralTest {

    @Test
    fun testIsNumeral() {
        assertTrue(Numeral.isNumeral("1"))
    }

    @Test
    fun testToString() {
        assertEquals("1.4142135623", Numeral(BigDecimal(sqrt(2.0))).toString())
    }
}