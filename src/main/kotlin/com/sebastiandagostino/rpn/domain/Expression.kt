package com.sebastiandagostino.rpn.domain

class Expression(private val symbols: MutableList<Symbol> = mutableListOf()) {

    fun push(symbol: String) {
        symbols.add(if (Numeral.isNumeral(symbol)) Numeral(symbol) else Operators.build(symbol))
    }

    fun push(symbol: Symbol) {
        symbols.add(symbol)
    }

    fun pop(): Symbol {
        val item = symbols.last()
        if (symbols.isNotEmpty()) {
            symbols.remove(item)
        }
        return item
    }

    fun isTopNumeral() = !isEmpty() && symbols.last().isNumeral()

    fun isEmpty() = symbols.isEmpty()

    fun clear() {
        symbols.clear()
    }

    override fun toString(): String {
        return symbols.toString().replace("[", "").replace("]", "")
    }
}