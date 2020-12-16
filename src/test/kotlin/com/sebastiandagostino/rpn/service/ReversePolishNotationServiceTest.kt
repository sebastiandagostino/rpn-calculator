package com.sebastiandagostino.rpn.service

import org.junit.Test
import kotlin.test.assertEquals

class ReversePolishNotationServiceTest {

    /**
     * Service tests are better with mocks, but it would take much more time to write
     * Instead this is an integration test
     */
    @Test
    fun testPushAndCalculate() {
        val calculator = ReversePolishNotationService()

        calculator.pushToStack("5")
        calculator.pushToStack("2")
        calculator.pushToStack("+")
        calculator.calculate()

        assertEquals("7", calculator.getStack())
        assertEquals("(+, 5, 2)", calculator.getHistory())
    }


}