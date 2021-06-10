package io.houf.sudoku.model.command.impl

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.command.Command
import io.houf.sudoku.model.tile.Position

class EnterCommand(
    private val position: Position,
    private val char: Char?
) : Command<GameData> {
    private var current: Char? = null

    override fun execute(context: GameData): Boolean {
        current = context.state.enter(context, position, char)

        return true
    }

    override fun rollback(context: GameData) {
        context.state.enter(context, position, current)
    }
}
