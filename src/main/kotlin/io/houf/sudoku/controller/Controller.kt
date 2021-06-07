package io.houf.sudoku.controller

import io.houf.sudoku.Sudoku
import io.houf.sudoku.view.View
import org.koin.core.component.KoinComponent

abstract class Controller<T : Controller<T>>(protected val sudoku: Sudoku) : KoinComponent {
    abstract fun createView(): View<T>

    fun pop() {
        sudoku.pop()
    }

    fun stop() {
        sudoku.stop()
    }

    fun canPop(): Boolean {
        return sudoku.canPop()
    }
}
