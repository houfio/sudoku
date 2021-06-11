package io.houf.sudoku.test

import io.houf.sudoku.model.puzzle.PuzzleCandidate

internal fun createCandidate(type: String, size: Int, vararg tiles: Int): PuzzleCandidate {
    val puzzle = StringBuilder()
    val range = 0 until size

    range.forEach { index ->
        puzzle.append(if (tiles.contains(index)) "1" else "0")
    }

    return PuzzleCandidate("test", type, puzzle.toString())
}
