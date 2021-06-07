package io.houf.sudoku.model.state.impl

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.state.State

class NoteState : State {
    override val name = "note"

    override fun enter(data: GameData, x: Int, y: Int, char: Char?): Char? {
        if (char == null) {
            return null
        }

        data.puzzle?.getTile(x, y)?.enterNote(char)

        return char
    }
}
