package io.houf.sudoku.model

import io.houf.sudoku.model.puzzle.Puzzle
import io.houf.sudoku.model.state.State
import io.houf.sudoku.model.state.impl.PlayState

data class GameData(
    var state: State = PlayState(),
    var puzzle: Puzzle? = null
)
