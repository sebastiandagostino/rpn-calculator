package com.sebastiandagostino.rpn.domain.exception

class NonExistentOperatorException(private val operator: String) : RuntimeException() {
    override val message: String?
        get() = "operator $operator: not found"
}