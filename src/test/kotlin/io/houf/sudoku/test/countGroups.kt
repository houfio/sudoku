package io.houf.sudoku.test

import io.houf.sudoku.model.puzzle.Puzzle

internal fun Puzzle.countGroups() = getTiles().groupBy { it.tile.group }.count()
