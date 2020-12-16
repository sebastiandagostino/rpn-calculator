package com.sebastiandagostino.rpn.domain

abstract class Symbol(var position: Int?) {

    abstract fun isNumeral(): Boolean
}