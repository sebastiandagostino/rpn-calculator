package com.sebastiandagostino.rpn

import com.sebastiandagostino.rpn.service.LineParserService
import com.sebastiandagostino.rpn.service.ReversePolishNotationService

fun main(args: Array<String>) {
    val calculator = ReversePolishNotationService()
    val lineParser = LineParserService()
    var line = readLine()!!
    while (!lineParser.isExitLine(line)) {
        while (line.isEmpty()) {
            line = readLine()!!
            if (lineParser.isExitLine(line)) {
                return
            }
        }
        try {
            lineParser.splitTokens(line).forEach{
                calculator.pushToStack(it.first, it.second)
                calculator.calculate()
            }
        } catch (exception: RuntimeException) {
            println(exception.message)
        } finally {
            println("stack: " + calculator.getStack())
            if (args.contains("-h")) {
                println("history: " + calculator.getHistory())
            }
            line = readLine()!!
        }
    }
}