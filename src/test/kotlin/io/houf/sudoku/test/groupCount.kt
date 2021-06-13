package io.houf.sudoku.test

import io.houf.sudoku.model.puzzle.Puzzle

internal fun groupCount(puzzle: Puzzle) = puzzle.getTiles().groupBy { it.tile.group }.count()
