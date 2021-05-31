package io.houf.sudoku.util

object PuzzleReader {
    private val paths = listOf("puzzle.4x4", "puzzle.6x6", "puzzle.9x9", "puzzle.jigsaw", "puzzle.samurai")

    fun readPuzzles() = paths.map {
        Triple(it.substringBeforeLast('.'), it.substringAfterLast('.'), readContents(it))
    }

    private fun readContents(file: String) = this::class.java.getResource("/puzzles/$file")?.readText(Charsets.UTF_8)
}
