package io.houf.sudoku.controller.impl

import io.houf.sudoku.Sudoku
import io.houf.sudoku.controller.Controller
import io.houf.sudoku.view.View
import io.houf.sudoku.view.impl.OverviewView

class OverviewController(sudoku: Sudoku) : Controller<OverviewController>(sudoku) {
    fun pushGame() {
        sudoku.push(GameController::class.java)
    }

    override fun createView(): View<OverviewController> {
        return OverviewView(this)
    }
}
