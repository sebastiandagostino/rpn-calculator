package com.sebastiandagostino.rpn.domain

abstract class Operator(val operator: String) : Symbol {

    abstract fun execute(expression: Expression, history: History)

    override fun isNumeral(): Boolean = false

    override fun toString(): String = operator
}
