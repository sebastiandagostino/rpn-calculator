package com.sebastiandagostino.rpn.domain

import com.sebastiandagostino.rpn.domain.exception.IllegalOperationException
import com.sebastiandagostino.rpn.domain.exception.NonExistentOperatorException
import java.lang.RuntimeException
import java.math.BigDecimal
import kotlin.math.sqrt

enum class Operators(val operator: Operator) {
    UNDO(UndoOperator("undo")),
    CLEAR(ClearOperator("clear")),
    ADDITION(AdditionOperator("+")),
    SUBTRACTION(SubtractionOperator("-")),
    MULTIPLICATION(MultiplicationOperator("*")),
    DIVISION(DivisionOperator("/")),
    SQUARE_ROOT(SquareRootOperator("sqrt"));

    companion object {
        fun build(operator: String): Operator {
            try {
                return values().first { it.operator.operator.toLowerCase() == operator.toLowerCase() }.operator
            } catch (e: RuntimeException) {
                throw NonExistentOperatorException(operator)
            }
        }
    }
}

class UndoOperator(operator: String) : Operator(operator) {
    override fun execute(expression: Expression, history: History) {
        if (expression.isEmpty()) {
            return
        }
        val operation = history.undo()
        expression.pop()
        operation?.let {
            operation.symbols.onEach { if (it.isNumeral()) expression.push(it) }
        }
    }
}

class ClearOperator(operator: String) : Operator(operator) {
    override fun execute(expression: Expression, history: History) {
        expression.clear()
        history.clear()
    }
}

class AdditionOperator(operator: String) : BinaryOperator(operator) {
    override fun execute(numeral1: Numeral, numeral2: Numeral): Numeral {
        return Numeral(numeral1.value + numeral2.value)
    }
}

class SubtractionOperator(operator: String): BinaryOperator(operator) {
    override fun execute(numeral1: Numeral, numeral2: Numeral): Numeral {
        return Numeral(numeral1.value - numeral2.value)
    }
}

class MultiplicationOperator(operator: String) : BinaryOperator(operator) {
    override fun execute(numeral1: Numeral, numeral2: Numeral): Numeral {
        return Numeral(numeral1.value * numeral2.value)
    }
}

class DivisionOperator(operator: String): BinaryOperator(operator) {
    override fun execute(numeral1: Numeral, numeral2: Numeral): Numeral {
        if (numeral2 == Numeral(BigDecimal.ZERO)) {
            throw IllegalOperationException(operator)
        }
        return Numeral(numeral1.value / numeral2.value)
    }
}

class SquareRootOperator(operator: String): UnaryOperator(operator) {
    override fun execute(numeral: Numeral): Numeral {
        if (numeral.value < BigDecimal.ZERO) {
            throw IllegalOperationException(operator)
        }
        return Numeral(BigDecimal(sqrt(numeral.value.toDouble())))
    }
}
