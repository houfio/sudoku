package io.houf.sudoku.model.factory

import io.houf.sudoku.model.Puzzle
import io.houf.sudoku.model.PuzzleCandidate
import io.houf.sudoku.model.visitor.SquareVisitor

abstract class PuzzleFactory {
    abstract fun createPuzzle(candidate: PuzzleCandidate): Puzzle

    abstract fun createValidator(): SquareVisitor

    companion object {
        fun get(type: String): PuzzleFactory = when (type) {
            "4x4" -> FourPuzzleFactory()
            else -> throw IllegalArgumentException()
        }
    }
}
