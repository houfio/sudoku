package io.houf.sudoku.model.puzzle

data class PuzzleCandidate(
    val name: String,
    val type: String,
    val content: String
) {
    val fullName: String
        get() = "${name}.${type}"
}
