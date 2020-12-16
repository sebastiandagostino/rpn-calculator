package com.sebastiandagostino.rpn.service

class LineParserService {

    fun isExitLine(line: String): Boolean {
        return line.trim().toLowerCase() == EXIT
    }

    fun splitTokens(line: String, separatorRegex: String = DEFAULT_SEPARATOR_REGEX): List<Pair<String, Int>> {
        val tokens = mutableListOf<Pair<String, Int>>()
        val strings = line.trim().split(separatorRegex.toRegex())
        var pos = 0
        for (string in strings) {
            pos = line.indexOf(string, pos) + 1
            tokens.add(Pair(string, pos))
        }
        return tokens
    }

    companion object {
        const val EXIT = "exit"
        const val DEFAULT_SEPARATOR_REGEX = "\\s+"
    }
}