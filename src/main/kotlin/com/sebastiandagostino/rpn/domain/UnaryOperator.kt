package com.sebastiandagostino.rpn.domain

import com.sebastiandagostino.rpn.domain.exception.InsufficientParametersException

abstract class UnaryOperator(operator: String): Operator(operator) {
    override fun execute(expression: Expression, history: History) {
        if (!expression.isTopNumeral()) {
            throw InsufficientParametersException(operator, position)
        }
        val numeral = expression.pop()
        expression.push(execute(numeral as Numeral))
        history.push(Operation(listOf(this, numeral)))
    }

    internal abstract fun execute(numeral: Numeral): Numeral
}