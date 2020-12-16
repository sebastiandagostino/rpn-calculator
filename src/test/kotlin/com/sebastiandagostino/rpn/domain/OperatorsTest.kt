package com.sebastiandagostino.rpn.domain

import com.sebastiandagostino.rpn.domain.exception.IllegalOperationException
import com.sebastiandagostino.rpn.domain.exception.NonExistentOperatorException
import org.junit.Test
import java.math.BigDecimal
import kotlin.math.sqrt
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class OperatorsTest {

    @Test
    fun testBuild() {
        assertTrue(Operators.build(Operators.SQUARE_ROOT.operator.operator) is SquareRootOperator)
        assertFailsWith<NonExistentOperatorException> { Operators.build("") }
    }

    @Test
    fun testUndoOperator() {
        val operator = UndoOperator("")
        val value1 = Numeral(BigDecimal(1))
        val value2 = Numeral(BigDecimal(2))
        val expression = Expression(mutableListOf(Numeral(BigDecimal(2))))
        val operation = Operation(mutableListOf(value1, value2, AdditionOperator("")))
        val history = History(mutableListOf(operation))

        operator.execute(expression, history)

        assertEquals(value2, expression.pop())
        assertEquals(value1, expression.pop())
        assertTrue(expression.isEmpty())
        assertTrue(history.isEmpty())
    }

    @Test
    fun testNothingToDoUndoOperator() {
        val operator = UndoOperator("")
        val expression = Expression()
        val history = History()

        operator.execute(expression, history)

        assertTrue(expression.isEmpty())
        assertTrue(history.isEmpty())
    }

    @Test
    fun testClearOperator() {
        val operator = ClearOperator("")
        val value = Numeral(BigDecimal.ONE)
        val expression = Expression(mutableListOf(value))
        val operation = Operation(mutableListOf(value))
        val history = History(mutableListOf(operation))

        operator.execute(expression, history)

        assertTrue(expression.isEmpty())
        assertTrue(history.isEmpty())
    }

    @Test
    fun testAdditionOperator() {
        val operator = AdditionOperator("")
        assertEquals(Numeral(BigDecimal.ONE), operator.execute(Numeral(BigDecimal.ONE), Numeral(BigDecimal.ZERO)))
    }

    @Test
    fun testSubtractionOperator() {
        val operator = SubtractionOperator("")
        assertEquals(Numeral(BigDecimal.ZERO), operator.execute(Numeral(BigDecimal.ONE), Numeral(BigDecimal.ONE)))
    }

    @Test
    fun testMultiplicationOperator() {
        val operator = MultiplicationOperator("")
        assertEquals(Numeral(BigDecimal.ONE), operator.execute(Numeral(BigDecimal.ONE), Numeral(BigDecimal.ONE)))
    }

    @Test
    fun testDivisionOperator() {
        val operator = DivisionOperator("")
        assertEquals(Numeral(BigDecimal(2)), operator.execute(Numeral(BigDecimal(4)), Numeral(BigDecimal(2))))
    }

    @Test
    fun testInvalidDivisionOperator() {
        val operator = DivisionOperator("")
        assertFailsWith<IllegalOperationException> { operator.execute(Numeral(BigDecimal.ONE), Numeral(BigDecimal.ZERO)) }
    }

    @Test
    fun testSquareRootOperator() {
        val operator = SquareRootOperator("")
        assertEquals(Numeral(BigDecimal(sqrt(2.0))), operator.execute(Numeral(BigDecimal(2))))
    }

    @Test
    fun testInvalidSquareRootOperator() {
        val operator = SquareRootOperator("")
        assertFailsWith<IllegalOperationException> { operator.execute(Numeral(BigDecimal(-2))) }
    }
}