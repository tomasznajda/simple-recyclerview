package com.tomasznajda.simplerecyclerview.util

import org.junit.Assert.assertEquals
import org.junit.Test

class ListExtKtTest {

    @Test
    fun `insert inserts item at the end of list when position is not specified`() {
        val list = listOf(1, 2, 3, 4, 5)
        assertEquals(listOf(1, 2, 3, 4, 5, 10), list.insert(10))
    }

    @Test
    fun `insert inserts item at the specified position when position is specified`() {
        val list = listOf(1, 2, 3, 4, 5)
        assertEquals(listOf(1, 2, 3, 10, 4, 5), list.insert(10, 3))
    }

    @Test
    fun `insert inserts items at the end of list when positionStart is not specified`() {
        val list = listOf(1, 2, 3, 4, 5)
        assertEquals(listOf(1, 2, 3, 4, 5, 10, 11), list.insert(listOf(10, 11)))
    }

    @Test
    fun `insert inserts items starting at the specified position when positionStart is specified`() {
        val list = listOf(1, 2, 3, 4, 5)
        assertEquals(listOf(1, 2, 3, 10, 11, 4, 5), list.insert(listOf(10, 11), 3))
    }

    @Test
    fun `remove removes item from the specified position`() {
        val list = listOf(1, 2, 3, 4, 5)
        assertEquals(listOf(1, 2, 4, 5), list.remove(2))
    }

    @Test
    fun `move moves item from position to new position`() {
        val list = listOf(1, 2, 3, 4, 5)
        assertEquals(listOf(1, 3, 4, 2, 5), list.move(1, 3))
    }

    @Test
    fun `replace replaces item at given position`() {
        val list = listOf(1, 2, 3, 4, 5)
        assertEquals(listOf(1, 2, 3, 10, 5), list.replace(10, 3))
    }
}