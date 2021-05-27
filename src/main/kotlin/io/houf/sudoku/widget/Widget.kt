package io.houf.sudoku.widget

import java.awt.Graphics2D
import java.awt.event.KeyEvent

open class Widget(
    protected val x: Int,
    protected val y: Int,
    protected val width: Int,
    protected val height: Int
) {
    private val children: MutableList<Widget> = mutableListOf()
    var hovered: Boolean = false
        private set
    var focused: Boolean = false
        private set
    var requestingFocus: Boolean = false
        private set

    open fun draw(g: Graphics2D) {
        children.forEach { it.draw(g) }
    }

    open fun update() {
        children.forEach { it.update() }
    }

    open fun mouseClick(x: Int, y: Int) {
        if (hovered) {
            requestFocus()
            interact()
        }

        children.forEach { it.mouseClick(x, y) }
    }

    open fun mousePress(x: Int, y: Int) {
        children.forEach { it.mousePress(x, y) }
    }

    open fun mouseRelease(x: Int, y: Int) {
        children.forEach { it.mouseRelease(x, y) }
    }

    open fun mouseDrag(x: Int, y: Int) {
        children.forEach { it.mouseDrag(x, y) }
    }

    open fun mouseMove(x: Int, y: Int) {
        hovered = x > this.x && x < this.x + width && y > this.y && y < this.y + height

        children.forEach { it.mouseMove(x, y) }
    }

    open fun keyType(key: Char) {
        children.forEach { it.keyType(key) }
    }

    open fun keyPress(key: Int, modifiers: Int) {
        if (focused && (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_ENTER)) {
            interact()
        }

        children.forEach { it.keyPress(key, modifiers) }
    }

    open fun interact() {
    }

    open fun getCursor(): Int? {
        return null
    }

    fun addChild(widget: Widget) {
        children.add(widget);
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

    fun forEach(fn: (Widget) -> Unit) {
        fn(this)
        children.forEach { it.forEach(fn) }
    }
}
