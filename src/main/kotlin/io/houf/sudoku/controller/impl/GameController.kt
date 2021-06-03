package io.houf.sudoku.controller.impl

import io.houf.sudoku.Sudoku
import io.houf.sudoku.controller.Controller
import io.houf.sudoku.model.tile.Tile
import io.houf.sudoku.view.View
import io.houf.sudoku.view.impl.GameView

class GameController(sudoku: Sudoku) : Controller<GameController>(sudoku) {
    fun getTile(x: Int, y: Int) = sudoku.game.puzzle?.getTile(x, y)

    fun forEachTile(fn: (Int, Int, Tile) -> Unit) = sudoku.game.puzzle?.forEachTile(fn)

    override fun createView(): View<GameController> {
        return GameView(this)
    }
}
