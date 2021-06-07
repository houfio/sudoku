package io.houf.sudoku.util.state

import io.houf.sudoku.Sudoku
import io.houf.sudoku.model.command.impl.EnterCommand

class PlayState() : State {

    override fun enter(sudoku: Sudoku, x: Int, y: Int, char: Char?) {
        sudoku.game.execute(EnterCommand(x, y, char))
    }
}
