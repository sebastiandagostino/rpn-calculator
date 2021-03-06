package com.sebastiandagostino.rpn.service

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LineParserServiceTest {

    @Test
    fun testIsExitLine() {
        assertTrue(LineParserService().isExitLine(LineParserService.EXIT))
    }

    @Test
    fun testSplitTokens() {
        val list = LineParserService().splitTokens("1 2")
        assertEquals(2, list.size)
        assertEquals("1", list.first().first)
        assertEquals(1, list.first().second)
        assertEquals("2", list.last().first)
        assertEquals(3, list.last().second)
    }
}
