package io.houf.sudoku.test.solver

import io.houf.sudoku.model.puzzle.Puzzle
import io.houf.sudoku.model.puzzle.impl.DefaultPuzzleFactory
import io.houf.sudoku.model.solver.impl.DefaultSolver
import io.houf.sudoku.model.tile.Position
import io.houf.sudoku.test.createCandidate
import org.junit.jupiter.api.Assertions.assertArrayEquals
import kotlin.test.Test
import kotlin.test.assertTrue

internal class DefaultSolverTest {
    private fun arrange(): Pair<DefaultSolver, Puzzle> {
        val solver = DefaultSolver()
        val puzzle = DefaultPuzzleFactory().createPuzzle(createCandidate("4x4", 16, 0, 9))!!

        return solver to puzzle
    }

    @Test
    fun testSolve() {
        val (solver, puzzle) = arrange()

        solver.trySolve(puzzle)

        assertTrue(solver.getErrors(puzzle).isEmpty())
    }

    @Test
    fun testErrors() {
        val (solver, puzzle) = arrange()

        puzzle.getTile(Position(1, 0))?.enterValue('1')

        val errors = solver.getErrors(puzzle)

        assertArrayEquals(arrayOf(Position(0, 0), Position(1, 0), Position(1, 2)), errors.toTypedArray())
    }
}
