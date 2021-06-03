package io.houf.sudoku.model.factory

import io.houf.sudoku.model.Puzzle
import io.houf.sudoku.model.PuzzleCandidate
import io.houf.sudoku.model.visitor.DefaultSquareValidator
import io.houf.sudoku.model.visitor.SquareVisitor

class FourPuzzleFactory : PuzzleFactory() {
    override fun createPuzzle(candidate: PuzzleCandidate): Puzzle {
        return Puzzle()
    }

    override fun createValidator(): SquareVisitor {
        return DefaultSquareValidator()
    }
}
