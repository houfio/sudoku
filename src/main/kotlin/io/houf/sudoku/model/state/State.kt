package io.houf.sudoku.model.state

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.tile.Position

interface State {
    val name: String

    fun enter(data: GameData, position: Position, char: Char?): Char?
}
