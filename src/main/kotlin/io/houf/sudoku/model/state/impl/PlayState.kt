package io.houf.sudoku.model.state.impl

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.state.State
import io.houf.sudoku.model.tile.Position

class PlayState : State {
    override val name = "play"

    override fun enter(data: GameData, position: Position, char: Char?): Char? {
        var current: Char? = null

        data.puzzle?.getTile(position)?.let {
            current = it.value
            it.enterValue(char)
        }

        return current
    }
}
