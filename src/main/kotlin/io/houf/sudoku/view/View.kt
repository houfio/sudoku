package io.houf.sudoku.view

import io.houf.sudoku.FrameSize
import io.houf.sudoku.controller.Controller
import io.houf.sudoku.widget.Draggable
import io.houf.sudoku.widget.Widget
import io.houf.sudoku.widget.WidgetGroup
import io.houf.sudoku.widget.impl.FrameWidgetGroup
import java.awt.Graphics2D

abstract class View<T : Controller<T>>(
    protected val controller: T,
    vararg children: Widget,
    private var translationX: Int = 0,
    private var translationY: Int = translationX
) : WidgetGroup(
    *children,
    FrameWidgetGroup(controller)
) {
    private var offsetX = 0
    private var offsetY = 0
    private var dragging = false

    init {
        x = 0
        y = 0
        width = FrameSize
        height = FrameSize
    }

    override fun draw(g: Graphics2D) {
        val draggables = children.filter { it is Draggable }

        draggables.forEach { widget ->
            (widget as Draggable).updatePosition(translationX, translationY)
        }

        draggables.forEach { it.draw(g) }

        drawTop(g)

        children.filterNot { draggables.contains(it) }.forEach { it.draw(g) }
    }

    open fun drawTop(g: Graphics2D) {
    }

    override fun mousePress(x: Int, y: Int) {
        dragging = hovered

        if (dragging) {
            offsetX = x - translationX
            offsetY = y - translationY
        }

        super.mousePress(x, y)
    }

    override fun mouseDrag(x: Int, y: Int) {
        if (dragging) {
            translationX = x - offsetX
            translationY = y - offsetY
        }

        super.mouseDrag(x, y)
    }

    override fun mouseRelease(x: Int, y: Int) {
        dragging = false

        super.mouseRelease(x, y)
    }
}
