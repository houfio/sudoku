package io.houf.sudoku.test

import io.houf.sudoku.model.puzzle.PuzzleCandidate

internal fun createCandidate(type: String, size: Int, vararg tiles: Int): PuzzleCandidate {
    val puzzle = StringBuilder()
    val range = 0 until size

    when (type) {
        "jigsaw" -> {
            val list = range.map { index ->
                "${if (tiles.contains(index)) "1" else "0"}J${index / 9}"
            }

            puzzle.append(list.joinToString("=", "SumoCueV1="))
        }
        "samurai" -> repeat(5) { grid ->
            range.forEach { index ->
                puzzle.append(if (tiles.contains(grid * 81 + index)) "1" else "0")
            }

            puzzle.append("\n")
        }
        else -> range.forEach { index ->
            puzzle.append(if (tiles.contains(index)) "1" else "0")
        }
    }

    println(puzzle)

    return PuzzleCandidate("test", type, puzzle.toString())
}
