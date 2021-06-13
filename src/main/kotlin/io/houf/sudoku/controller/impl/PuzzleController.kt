package io.houf.sudoku.controller.impl

import io.houf.sudoku.Sudoku
import io.houf.sudoku.controller.Controller
import io.houf.sudoku.model.command.impl.EnterCommand
import io.houf.sudoku.model.command.impl.SwitchCommand
import io.houf.sudoku.model.tile.Position
import io.houf.sudoku.view.View
import io.houf.sudoku.view.impl.PuzzleView

class PuzzleController(sudoku: Sudoku) : Controller<PuzzleController>(sudoku) {
    var errors: List<Position> = listOf()
        private set

    fun getSize() = sudoku.game.puzzle?.size ?: 1

    fun getTile(position: Position) = sudoku.game.puzzle?.getTile(position)

    fun getTiles() = sudoku.game.puzzle?.getTiles() ?: emptyList()

    fun switchMode() = sudoku.game.execute(SwitchCommand())

    fun enter(position: Position, char: Char?) {
        errors = listOf()
        sudoku.game.execute(EnterCommand(position, char))
    }

    fun rollback() {
        errors = listOf()
        sudoku.game.rollback()
    }

    fun validate() {
        errors = sudoku.game.puzzle?.getErrors() ?: listOf()
    }

    fun solve() = sudoku.game.puzzle?.solve()

    fun isNoting() = sudoku.game.state == "note"

    override fun createView(): View<PuzzleController> {
        return PuzzleView(this)
    }
}
