package io.houf.sudoku.test.solver

import io.houf.sudoku.model.puzzle.Puzzle
import io.houf.sudoku.model.puzzle.impl.SamuraiPuzzleFactory
import io.houf.sudoku.model.solver.impl.SamuraiSolver
import io.houf.sudoku.model.tile.Position
import io.houf.sudoku.test.createCandidate
import kotlin.test.Test
import kotlin.test.assertEquals

internal class SamuraiSolverTest {
    private fun arrange(): Pair<SamuraiSolver, Puzzle> {
        val solver = SamuraiSolver()
        val puzzle = SamuraiPuzzleFactory().createPuzzle(createCandidate("samurai", 81, 44, 70, 76, 172, 184, 200))!!

        return solver to puzzle
    }

    @Test
    fun testErrorSingle() {
        val (solver, puzzle) = arrange()

        puzzle.getTile(Position(4, 7))?.enterValue('1')

        val errors = solver.getErrors(puzzle)

        assertEquals(3, errors.size)
    }

    @Test
    fun testErrorDual() {
        val (solver, puzzle) = arrange()

        puzzle.getTile(Position(8, 8))?.enterValue('1')

        val errors = solver.getErrors(puzzle)

        assertEquals(6, errors.size)
    }
}
