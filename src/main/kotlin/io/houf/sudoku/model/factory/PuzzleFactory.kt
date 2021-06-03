package io.houf.sudoku.model.factory

import io.houf.sudoku.model.Puzzle
import io.houf.sudoku.model.PuzzleCandidate
import io.houf.sudoku.model.visitor.TileVisitor

abstract class PuzzleFactory {
    abstract fun createPuzzle(candidate: PuzzleCandidate): Puzzle

    abstract fun createValidator(): TileVisitor

    companion object {
        fun get(type: String): PuzzleFactory = when (type) {
            "4x4" -> FourPuzzleFactory()
            else -> throw IllegalArgumentException()
        }
    }
}
