package io.houf.sudoku.controller.impl

import io.houf.sudoku.Sudoku
import io.houf.sudoku.controller.Controller
import io.houf.sudoku.view.View
import io.houf.sudoku.view.impl.GameView

class GameController(sudoku: Sudoku) : Controller<GameController>(sudoku) {
    override fun createView(): View<GameController> {
        return GameView(this)
    }
}
