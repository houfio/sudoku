package io.houf.sudoku.test.puzzle

import io.houf.sudoku.model.puzzle.impl.DefaultPuzzleFactory
import io.houf.sudoku.model.tile.Position
import io.houf.sudoku.test.createCandidate
import io.houf.sudoku.test.groupCount
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

internal class DefaultPuzzleFactoryTest {
    private fun arrange4x4() = DefaultPuzzleFactory().createPuzzle(createCandidate("4x4", 16, 0, 4))
    private fun arrange6x6() = DefaultPuzzleFactory().createPuzzle(createCandidate("6x6", 36, 0, 6))
    private fun arrange9x9() = DefaultPuzzleFactory().createPuzzle(createCandidate("9x9", 81, 0, 9))

    @Test
    fun testCreate4x4Size() {
        val puzzle = arrange4x4()

        assertNotNull(puzzle)
        assertEquals(4, puzzle.size)
        assertEquals(16, puzzle.getTiles().size)
    }

    @Test
    fun testCreate4x4Positions() {
        val puzzle = arrange4x4()

        assertNotNull(puzzle)
        assertEquals('1', puzzle.getTile(Position(0, 0))?.value)
        assertEquals('1', puzzle.getTile(Position(0, 1))?.value)
    }

    @Test
    fun testCreate4x4Groups() {
        val puzzle = arrange4x4()

        assertNotNull(puzzle)
        assertEquals(4, groupCount(puzzle))
    }

    @Test
    fun testCreate6x6Size() {
        val puzzle = arrange6x6()

        assertNotNull(puzzle)
        assertEquals(6, puzzle.size)
        assertEquals(36, puzzle.getTiles().size)
    }

    @Test
    fun testCreate6x6Position() {
        val puzzle = arrange6x6()

        assertNotNull(puzzle)
        assertEquals('1', puzzle.getTile(Position(0, 0))?.value)
        assertEquals('1', puzzle.getTile(Position(0, 1))?.value)
    }

    @Test
    fun testCreate6x6Groups() {
        val puzzle = arrange6x6()

        assertNotNull(puzzle)
        assertEquals(6, groupCount(puzzle))
    }

    @Test
    fun testCreate9x9Size() {
        val puzzle = arrange9x9()

        assertNotNull(puzzle)
        assertEquals(9, puzzle.size)
        assertEquals(81, puzzle.getTiles().size)
    }

    @Test
    fun testCreate9x9Position() {
        val puzzle = arrange9x9()

        assertNotNull(puzzle)
        assertEquals('1', puzzle.getTile(Position(0, 0))?.value)
        assertEquals('1', puzzle.getTile(Position(0, 1))?.value)
    }

    @Test
    fun testCreate9x9Groups() {
        val puzzle = arrange9x9()

        assertNotNull(puzzle)
        assertEquals(9, groupCount(puzzle))
    }

    @Test
    fun testCreateInvalid() {
        val puzzle = DefaultPuzzleFactory().createPuzzle(createCandidate("4x4", 1))

        assertNull(puzzle)
    }

    @Test
    fun testCreateUnknown() {
        val puzzle = DefaultPuzzleFactory().createPuzzle(createCandidate("unknown", 1))

        assertNull(puzzle)
    }
}
