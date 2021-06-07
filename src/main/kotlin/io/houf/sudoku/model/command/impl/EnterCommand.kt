package io.houf.sudoku.model.command.impl

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.command.Command

class EnterCommand(
    private val x: Int,
    private val y: Int,
    private val char: Char?
) : Command<GameData> {
    private var current: Char? = null

    override fun execute(context: GameData): Boolean {
        current = context.state.enter(context, x, y, char)

        return true
    }

    override fun rollback(context: GameData) {
        context.state.enter(context, x, y, current)
    }
}
