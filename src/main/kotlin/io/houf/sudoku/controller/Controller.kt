package io.houf.sudoku.controller

import io.houf.sudoku.Sudoku
import io.houf.sudoku.view.View

abstract class Controller<T : Controller<T>>(protected val sudoku: Sudoku) {
    abstract fun createView(): View<T>

    fun stop() {
        sudoku.stop()
    }
}
