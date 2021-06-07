package io.houf.sudoku.model.state

import io.houf.sudoku.model.GameData

interface State {
    fun enter(data: GameData, x: Int, y: Int, char: Char?): Char?
}
