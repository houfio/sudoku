package io.houf.sudoku.controller.impl

import io.houf.sudoku.Sudoku
import io.houf.sudoku.controller.Controller
import io.houf.sudoku.model.puzzle.PuzzleCandidate
import io.houf.sudoku.service.PuzzleReader
import io.houf.sudoku.view.View
import io.houf.sudoku.view.impl.OverviewView
import org.koin.core.component.inject

class OverviewController(sudoku: Sudoku) : Controller<OverviewController>(sudoku) {
    private val puzzleReader: PuzzleReader by inject()
    val puzzles = puzzleReader.readPuzzles()

    fun openDetail(puzzle: PuzzleCandidate) {
        sudoku.game.puzzleCandidate = puzzle
        sudoku.push(StartController::class.java)
    }

    override fun createView(): View<OverviewController> {
        return OverviewView(this)
    }
}
