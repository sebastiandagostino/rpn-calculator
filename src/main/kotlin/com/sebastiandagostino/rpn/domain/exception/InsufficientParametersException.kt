package com.sebastiandagostino.rpn.domain.exception

class InsufficientParametersException(private val operator: String, private val position: Int?): RuntimeException() {
    override val message: String?
        get() = "operator $operator (position: $position): insufficient parameters"
}