package io.houf.sudoku.model.command.impl

import io.houf.sudoku.model.Game
import io.houf.sudoku.model.command.Command

class EnterCommand(
    private val x: Int,
    private val y: Int,
    private val char: Char?
) : Command<Game> {
    private var current: Char? = null

    override fun execute(context: Game): Boolean {
        context.puzzle?.getTile(x, y)?.let {
            current = it.value
            it.enterChar(char)
        }

        return true
    }

    override fun rollback(context: Game) {
        context.puzzle?.getTile(x, y)?.enterChar(current)
    }
}
