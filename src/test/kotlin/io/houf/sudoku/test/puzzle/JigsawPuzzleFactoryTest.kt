package io.houf.sudoku.test.puzzle

import io.houf.sudoku.model.puzzle.impl.JigsawPuzzleFactory
import io.houf.sudoku.model.tile.Position
import io.houf.sudoku.test.countGroups
import io.houf.sudoku.test.createCandidate
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

internal class JigsawPuzzleFactoryTest {
    private fun arrange() = JigsawPuzzleFactory().createPuzzle(createCandidate("jigsaw", 81, 0, 9))

    @Test
    fun testCreateSize() {
        val puzzle = arrange()

        assertNotNull(puzzle)
        assertEquals(9, puzzle.size)
        assertEquals(81, puzzle.getTiles().size)
    }

    @Test
    fun testCreatePositions() {
        val puzzle = arrange()

        assertNotNull(puzzle)
        assertEquals('1', puzzle.getTile(Position(0, 0))?.value)
        assertEquals('1', puzzle.getTile(Position(0, 1))?.value)
    }

    @Test
    fun testCreateGroups() {
        val puzzle = arrange()

        assertNotNull(puzzle)
        assertEquals(9, puzzle.countGroups())
    }
}
