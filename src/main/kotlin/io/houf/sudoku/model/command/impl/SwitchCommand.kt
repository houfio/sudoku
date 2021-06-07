package io.houf.sudoku.model.command.impl

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.command.Command
import io.houf.sudoku.model.state.impl.NoteState
import io.houf.sudoku.model.state.impl.PlayState

class SwitchCommand : Command<GameData> {
    override fun execute(context: GameData): Boolean {
        context.state = if (context.state is PlayState) {
            NoteState()
        } else {
            PlayState()
        }

        return true
    }

    override fun rollback(context: GameData) {
        execute(context)
    }
}
