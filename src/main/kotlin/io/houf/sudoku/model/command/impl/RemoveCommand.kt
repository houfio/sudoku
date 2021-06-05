package io.houf.sudoku.model.command.impl

import io.houf.sudoku.model.Game
import io.houf.sudoku.model.command.Command

class RemoveCommand(
    private val x: Int,
    private val y: Int
) : Command<Game> {
    private var last: Char? = null

    override fun execute(context: Game): Boolean {
        context.puzzle?.getTile(x, y)?.let {
            if (it.value.isEmpty()) {
                return false
            }

            last = it.value.last()
            it.removeChar()
        }

        return true
    }

    override fun rollback(context: Game) {
        last?.let {
            context.puzzle?.getTile(x, y)?.appendChar(it)
        }
    }
}
