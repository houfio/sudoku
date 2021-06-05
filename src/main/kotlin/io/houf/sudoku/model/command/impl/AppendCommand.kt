package io.houf.sudoku.model.command.impl

import io.houf.sudoku.model.Game
import io.houf.sudoku.model.command.Command

class AppendCommand(
    private val x: Int,
    private val y: Int,
    private val char: Char
) : Command<Game> {
    override fun execute(context: Game): Boolean {
        context.puzzle?.getTile(x, y)?.appendChar(char)

        return true
    }

    override fun rollback(context: Game) {
        context.puzzle?.getTile(x, y)?.removeChar()
    }
}
