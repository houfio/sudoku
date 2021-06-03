package io.houf.sudoku.controller.impl

import io.houf.sudoku.Sudoku
import io.houf.sudoku.controller.Controller
import io.houf.sudoku.view.View
import io.houf.sudoku.view.impl.GameView

class GameController(sudoku: Sudoku) : Controller<GameController>(sudoku) {
    fun getSize() = sudoku.game.puzzle?.size ?: -1

    override fun createView(): View<GameController> {
        return GameView(this)
    }
}
