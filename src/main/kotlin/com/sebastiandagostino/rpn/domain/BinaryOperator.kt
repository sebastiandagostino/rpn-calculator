package com.sebastiandagostino.rpn.domain

import com.sebastiandagostino.rpn.domain.exception.InsufficientParametersException

abstract class BinaryOperator(operator: String): Operator(operator) {
    override fun execute(expression: Expression, history: History) {
        if (!expression.isTopNumeral()) {
            throw InsufficientParametersException(operator, position)
        }
        val numeral2 = expression.pop()
        if (!expression.isTopNumeral()) {
            expression.push(numeral2)
            throw InsufficientParametersException(operator, position)
        }
        val numeral1 = expression.pop()
        expression.push(execute(numeral1 as Numeral, numeral2 as Numeral))
        history.push(Operation(listOf(this, numeral1, numeral2)))
    }

    internal abstract fun execute(numeral1: Numeral, numeral2: Numeral): Numeral
}
