package io.houf.sudoku.view

import io.houf.sudoku.FrameSize
import io.houf.sudoku.controller.Controller
import io.houf.sudoku.widget.Widget

abstract class View<T : Controller<T>>(protected val controller: T) : Widget(0, 0, FrameSize, FrameSize) {
    override fun canFocus(): Boolean {
        return false
    }
}
