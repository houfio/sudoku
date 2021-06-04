package io.houf.sudoku.model

import io.houf.sudoku.model.puzzle.PuzzleFactory

class Game {
    var puzzleCandidate: PuzzleCandidate? = null
    var puzzle: Puzzle? = null
        private set

    fun startPuzzle() {
        puzzleCandidate?.let {
            puzzle = PuzzleFactory.get(it.type).createPuzzle(it)
        }
    }
}
