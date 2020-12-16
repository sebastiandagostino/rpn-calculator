package com.sebastiandagostino.rpn.service

class LineParserService {

    fun isExitLine(line: String): Boolean {
        return line.trim().toLowerCase() == EXIT
    }

    fun splitTokens(line: String, separatorRegex: String = "\\s+"): List<String> {
        return line.trim().split(separatorRegex.toRegex())
    }

    companion object {
        const val EXIT = "exit"
    }
}