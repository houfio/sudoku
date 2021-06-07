package io.houf.sudoku.model.state

import io.houf.sudoku.model.GameData

interface State {
    val name: String

    fun enter(data: GameData, x: Int, y: Int, char: Char?): Char?
}
