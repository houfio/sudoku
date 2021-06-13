package io.houf.sudoku.test.puzzle

import io.houf.sudoku.model.puzzle.impl.SamuraiPuzzleFactory
import io.houf.sudoku.model.tile.Position
import io.houf.sudoku.test.createCandidate
import io.houf.sudoku.test.groupCount
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

internal class SamuraiPuzzleFactoryTest {
    private fun arrange() = SamuraiPuzzleFactory().createPuzzle(createCandidate("samurai", 81, 0, 9))

    @Test
    fun testCreateSize() {
        val puzzle = arrange()

        assertNotNull(puzzle)
        assertEquals(21, puzzle.size)
        assertEquals(369, puzzle.getTiles().size)
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
        assertEquals(41, groupCount(puzzle))
    }
}
