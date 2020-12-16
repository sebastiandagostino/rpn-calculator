package com.sebastiandagostino.rpn.domain

class History(private val operations: MutableList<Operation> = mutableListOf()) {

    fun push(operation: Operation) {
        operations.add(operation)
    }

    fun undo(): Operation? {
        val item = operations.lastOrNull()
        operations.remove(item)
        return item
    }

    fun clear() {
        operations.clear()
    }

    fun isEmpty(): Boolean = operations.isEmpty()

    override fun toString(): String {
        return operations.toString().replace("[", "").replace("]", "")
    }
}