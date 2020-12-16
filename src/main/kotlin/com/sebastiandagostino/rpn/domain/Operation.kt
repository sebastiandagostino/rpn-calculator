package com.sebastiandagostino.rpn.domain

data class Operation(val symbols: List<Symbol>) {
    override fun toString(): String {
        return symbols.toString().replace("[", "(").replace("]", ")")
    }
}