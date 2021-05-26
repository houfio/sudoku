package io.houf.sudoku.view

import io.houf.sudoku.FrameSize
import io.houf.sudoku.controller.Controller
import io.houf.sudoku.widget.Widget
import io.houf.sudoku.widget.impl.FrameWidget

abstract class View<T : Controller<T>>(controller: T) : Widget(0, 0, FrameSize, FrameSize, false) {
    init {
        addChild(FrameWidget {
            controller.stop()
        })
    }
}
