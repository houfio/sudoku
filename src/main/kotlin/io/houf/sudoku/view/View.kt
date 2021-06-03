package io.houf.sudoku.view

import io.houf.sudoku.FrameSize
import io.houf.sudoku.controller.Controller
import io.houf.sudoku.widget.Widget
import io.houf.sudoku.widget.WidgetGroup
import io.houf.sudoku.widget.impl.FrameWidgetGroup

abstract class View<T : Controller<T>>(protected val controller: T, vararg children: Widget) : WidgetGroup(
    *children,
    FrameWidgetGroup(controller)
) {
    init {
        x = 0
        y = 0
        width = FrameSize
        height = FrameSize
    }
}
