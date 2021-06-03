package io.houf.sudoku.widget

import java.awt.Graphics2D
import java.awt.event.KeyEvent

abstract class Widget(
    x: Int,
    y: Int,
    width: Int,
    height: Int
) : Iterable<Widget> {
    var x = x
        protected set
    var y = y
        protected set
    var width = width
        protected set
    var height = height
        protected set

    var hovered = false
        private set
    var focused = false
        private set
    var requestingFocus = false
        private set

    abstract fun draw(g: Graphics2D)

    abstract fun update()

    open fun mouseClick(x: Int, y: Int) {
        if (hovered) {
            requestFocus()
            interact(true)
        }
    }

    open fun mousePress(x: Int, y: Int) {
    }

    open fun mouseRelease(x: Int, y: Int) {
    }

    open fun mouseDrag(x: Int, y: Int) {
    }

    open fun mouseMove(x: Int, y: Int) {
        hovered = x > this.x && x < this.x + width && y > this.y && y < this.y + height
    }

    open fun mouseScroll(rotation: Int) {
    }

    open fun keyType(key: Char) {
    }

    open fun keyPress(key: Int, modifiers: Int) {
        if (focused && (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_ENTER)) {
            interact(false)
        }
    }

    open fun interact(click: Boolean) {
    }

    open fun getCursor(): Int? {
        return null
    }

    open fun canFocus(): Boolean {
        return true
    }

    fun requestFocus() {
        requestingFocus = true
    }

    fun setFocus(focus: Boolean) {
        focused = focus
        requestingFocus = false
    }

    override fun iterator(): Iterator<Widget> {
        return WidgetIterator(this)
    }
}
