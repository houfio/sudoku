package io.houf.sudoku.model.puzzle

import io.houf.sudoku.model.Puzzle
import io.houf.sudoku.model.PuzzleCandidate
import io.houf.sudoku.model.validator.Validator

interface PuzzleFactory {
    fun createPuzzle(candidate: PuzzleCandidate): Puzzle

    fun createValidator(): Validator

    companion object {
        fun get(type: String) = when (type) {
            "4x4" -> DefaultPuzzleFactory()
            "6x6" -> DefaultPuzzleFactory()
            "9x9" -> DefaultPuzzleFactory()
            "jigsaw" -> JigsawPuzzleFactory()
            "samurai" -> SamuraiPuzzleFactory()
            else -> throw IllegalArgumentException()
        }
    }
}
