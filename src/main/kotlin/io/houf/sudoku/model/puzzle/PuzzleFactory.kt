package io.houf.sudoku.model.puzzle

import io.houf.sudoku.model.puzzle.impl.DefaultPuzzleFactory
import io.houf.sudoku.model.puzzle.impl.JigsawPuzzleFactory
import io.houf.sudoku.model.puzzle.impl.SamuraiPuzzleFactory
import io.houf.sudoku.model.validator.Validator

interface PuzzleFactory {
    fun createPuzzle(candidate: PuzzleCandidate): Puzzle

    fun createValidator(): Validator

    companion object {
        fun get(type: String) = when (type) {
            "4x4", "6x6", "9x9" -> DefaultPuzzleFactory()
            "jigsaw" -> JigsawPuzzleFactory()
            "samurai" -> SamuraiPuzzleFactory()
            else -> throw IllegalArgumentException()
        }
    }
}
