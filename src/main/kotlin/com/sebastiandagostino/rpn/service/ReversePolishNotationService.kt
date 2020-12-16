package com.sebastiandagostino.rpn.service

import com.sebastiandagostino.rpn.domain.History
import com.sebastiandagostino.rpn.domain.Expression
import com.sebastiandagostino.rpn.domain.Operator

class ReversePolishNotationService(private val expression: Expression = Expression(),
                                   private val history: History = History()) {

    fun pushToStack(symbol: String) {
        expression.push(symbol)
    }

    fun calculate() {
        while (!expression.isEmpty() && !expression.isTopNumeral()) {
            (expression.pop() as Operator).execute(expression, history)
        }
    }

    fun getStack(): String {
        return expression.toString()
    }

    fun getHistory(): String {
        return history.toString()
    }
}