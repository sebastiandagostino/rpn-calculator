package com.sebastiandagostino.rpn.domain.exception

class IllegalOperationException(private val operator: String): RuntimeException() {
    override val message: String?
        get() = "operator $operator: wrong use"
}