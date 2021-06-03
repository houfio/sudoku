package io.houf.sudoku.controller.impl

import io.houf.sudoku.Sudoku
import io.houf.sudoku.controller.Controller
import io.houf.sudoku.model.PuzzleCandidate
import io.houf.sudoku.util.PuzzleReader
import io.houf.sudoku.view.View
import io.houf.sudoku.view.impl.OverviewView

class OverviewController(sudoku: Sudoku) : Controller<OverviewController>(sudoku) {
    val puzzles = PuzzleReader.readPuzzles()

    fun openDetail(puzzle: PuzzleCandidate) {
        sudoku.game.puzzle = puzzle
        sudoku.push(GameController::class.java)
    }

    override fun createView(): View<OverviewController> {
        return OverviewView(this)
    }
}
