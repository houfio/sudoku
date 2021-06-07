package io.houf.sudoku.model.solver

import io.houf.sudoku.model.puzzle.Puzzle

interface Solver {
    fun trySolve(puzzle: Puzzle): Boolean

    fun getErrors(puzzle: Puzzle): List<Pair<Int, Int>>
}
