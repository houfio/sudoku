package io.houf.sudoku.controller.impl

import io.houf.sudoku.Sudoku
import io.houf.sudoku.controller.Controller
import io.houf.sudoku.model.command.impl.StartCommand
import io.houf.sudoku.view.View
import io.houf.sudoku.view.impl.StartView

class StartController(sudoku: Sudoku) : Controller<StartController>(sudoku) {
    fun getPuzzleName() = sudoku.game.candidate?.name ?: ""

    fun startPuzzle() {
        sudoku.game.execute(StartCommand())
        sudoku.push(GameController::class.java)
    }

    override fun createView(): View<StartController> {
        return StartView(this)
    }
}
