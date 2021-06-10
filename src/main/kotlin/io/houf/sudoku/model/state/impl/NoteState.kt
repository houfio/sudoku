package io.houf.sudoku.model.state.impl

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.state.State
import io.houf.sudoku.model.tile.Position

class NoteState : State {
    override val name = "note"

    override fun enter(data: GameData, position: Position, char: Char?): Char? {
        if (char == null) {
            return null
        }

        data.puzzle?.getTile(position)?.enterNote(char)

        return char
    }
}
