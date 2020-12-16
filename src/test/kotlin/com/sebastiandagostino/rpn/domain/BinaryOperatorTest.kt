package com.sebastiandagostino.rpn.domain

import com.sebastiandagostino.rpn.domain.exception.InsufficientParametersException
import org.junit.Test
import java.math.BigDecimal
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class BinaryOperatorTest {

    @Test
    fun testUnaryOperator() {
        val value1 = Numeral(BigDecimal(1))
        val value2 = Numeral(BigDecimal(2))
        val operator = AdditionOperator("")
        val expression = Expression(mutableListOf(value1, value2))
        val history = History()

        operator.execute(expression, history)

        assertEquals(Numeral(BigDecimal(3)), expression.pop())
        assertEquals(Operation(mutableListOf(operator, value1, value2)), history.undo())
    }

    @Test
    fun testTwoInsufficientParametersForOperator() {
        val operator = DivisionOperator("")
        val expression = Expression()
        val operation = Operation(mutableListOf())
        val history = History(mutableListOf(operation))

        assertFailsWith<InsufficientParametersException> { operator.execute(expression, history) }
        assertEquals(operation, history.undo())
    }

    @Test
    fun testOneInsufficientParametersForOperator() {
        val value = Numeral(BigDecimal(2))
        val operator = SubtractionOperator("")
        val expression = Expression(mutableListOf(value))
        val operation = Operation(mutableListOf())
        val history = History(mutableListOf(operation))

        assertFailsWith<InsufficientParametersException> { operator.execute(expression, history) }
        assertEquals(operation, history.undo())
    }
}