package io.houf.sudoku.model.validator

import io.houf.sudoku.model.puzzle.Puzzle
import io.houf.sudoku.model.tile.Tile

interface Validator {
    fun getErrors(puzzle: Puzzle): List<Tile>
}
