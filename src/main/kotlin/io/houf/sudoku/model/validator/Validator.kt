package io.houf.sudoku.model.validator

import io.houf.sudoku.model.puzzle.Puzzle

interface Validator {
    fun getErrors(puzzle: Puzzle): List<Pair<Int, Int>>
}
