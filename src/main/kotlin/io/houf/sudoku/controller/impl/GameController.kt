package io.houf.sudoku.controller.impl

import io.houf.sudoku.Sudoku
import io.houf.sudoku.controller.Controller
import io.houf.sudoku.model.command.impl.EnterCommand
import io.houf.sudoku.view.View
import io.houf.sudoku.view.impl.GameView

class GameController(sudoku: Sudoku) : Controller<GameController>(sudoku) {
    fun getSize() = sudoku.game.puzzle?.size ?: 1

    fun getTile(x: Int, y: Int) = sudoku.game.puzzle?.getTile(x, y)

    fun getTiles() = sudoku.game.puzzle?.getTiles() ?: emptyList()

    fun enter(x: Int, y: Int, char: Char?) = sudoku.game.execute(EnterCommand(x, y, char))

    fun validate() = println(sudoku.game.puzzle?.getErrors())

    fun solve() = sudoku.game.puzzle?.solve()

    override fun createView(): View<GameController> {
        return GameView(this)
    }
}
