package io.houf.sudoku.model.solver

import io.houf.sudoku.model.puzzle.Puzzle
import io.houf.sudoku.model.tile.Position

interface Solver {
    fun trySolve(puzzle: Puzzle): Boolean

    fun getErrors(puzzle: Puzzle): List<Position>
}
