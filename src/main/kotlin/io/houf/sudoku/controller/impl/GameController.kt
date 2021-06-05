package io.houf.sudoku.controller.impl

import io.houf.sudoku.Sudoku
import io.houf.sudoku.controller.Controller
import io.houf.sudoku.model.command.impl.AppendCommand
import io.houf.sudoku.model.command.impl.RemoveCommand
import io.houf.sudoku.view.View
import io.houf.sudoku.view.impl.GameView

class GameController(sudoku: Sudoku) : Controller<GameController>(sudoku) {
    fun getSize() = sudoku.game.puzzle?.size ?: 1

    fun getTile(x: Int, y: Int) = sudoku.game.puzzle?.getTile(x, y)

    fun getTiles() = sudoku.game.puzzle?.getTiles() ?: emptyList()

    fun append(x: Int, y: Int, char: Char) = sudoku.game.execute(AppendCommand(x, y, char))

    fun remove(x: Int, y: Int) = sudoku.game.execute(RemoveCommand(x, y))

    override fun createView(): View<GameController> {
        return GameView(this)
    }
}
