package io.houf.sudoku.model.state.impl

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.state.State

class PlayState : State {
    override fun enter(data: GameData, x: Int, y: Int, char: Char?): Char? {
        var current: Char? = null

        data.puzzle?.getTile(x, y)?.let {
            current = it.value
            it.enterChar(char)
        }

        return current
    }
}
