package io.houf.sudoku.model

import io.houf.sudoku.model.puzzle.Puzzle
import io.houf.sudoku.model.puzzle.PuzzleCandidate
import io.houf.sudoku.model.state.State
import io.houf.sudoku.model.state.impl.PlayState

class GameData {
    var state: State = PlayState()
    var candidate: PuzzleCandidate? = null
    var puzzle: Puzzle? = null
}
