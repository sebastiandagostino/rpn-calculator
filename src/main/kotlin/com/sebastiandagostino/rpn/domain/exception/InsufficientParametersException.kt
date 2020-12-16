package com.sebastiandagostino.rpn.domain.exception

class InsufficientParametersException(private val operator: String) : RuntimeException() {
    override val message: String?
        get() = "operator $operator: insufficient parameters"
}