package com.sebastiandagostino.rpn.domain

import com.sebastiandagostino.rpn.domain.exception.InsufficientParametersException
import org.junit.Test
import java.math.BigDecimal
import kotlin.math.sqrt
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class UnaryOperatorTest {

    @Test
    fun testUnaryOperator() {
        val value = Numeral(BigDecimal(2))
        val operator = SquareRootOperator("")
        val expression = Expression(mutableListOf(value))
        val history = History()

        operator.execute(expression, history)

        assertEquals(Numeral(BigDecimal(sqrt(2.0))), expression.pop())
        assertEquals(Operation(mutableListOf(operator, value)), history.undo())
    }

    @Test
    fun testInsufficientParametersForOperator() {
        val operator = SquareRootOperator("")
        val expression = Expression()
        val operation = Operation(mutableListOf())
        val history = History(mutableListOf(operation))

        assertFailsWith<InsufficientParametersException> { operator.execute(expression, history) }
        assertEquals(operation, history.undo())
    }
}