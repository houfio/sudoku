package io.houf.sudoku.controller.impl

import io.houf.sudoku.Sudoku
import io.houf.sudoku.controller.Controller
import io.houf.sudoku.util.PuzzleReader
import io.houf.sudoku.view.View
import io.houf.sudoku.view.impl.OverviewView
import io.houf.sudoku.widget.impl.ButtonWidget

class OverviewController(sudoku: Sudoku) : Controller<OverviewController>(sudoku) {

    var puzzles = emptyList<Triple<String, String, String>>()

    init {
        puzzles = PuzzleReader.read()
    }

    fun pushGame() {
        sudoku.push(GameController::class.java)
    }

    override fun createView(): View<OverviewController> {
        return OverviewView(this)
    }
}
