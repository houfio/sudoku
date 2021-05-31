package io.houf.sudoku.widget

import java.awt.Graphics2D

open class WidgetGroup(protected vararg val children: Widget) : Widget(0, 0, 0, 0) {
    init {
        x = children.minOfOrNull { it.x } ?: 0
        y = children.minOfOrNull { it.y } ?: 0
        width = children.maxOfOrNull { it.x - x + it.width } ?: 0
        height = children.maxOfOrNull { it.y - y + it.height } ?: 0
    }

    override fun draw(g: Graphics2D) {
        children.forEach { it.draw(g) }
    }

    override fun update() {
        children.forEach { it.update() }
    }

    override fun mouseClick(x: Int, y: Int) {
        super.mouseClick(x, y)

        children.forEach { it.mouseClick(x, y) }
    }

    override fun mousePress(x: Int, y: Int) {
        children.forEach { it.mousePress(x, y) }
    }

    override fun mouseRelease(x: Int, y: Int) {
        children.forEach { it.mouseRelease(x, y) }
    }

    override fun mouseDrag(x: Int, y: Int) {
        children.forEach { it.mouseDrag(x, y) }
    }

    override fun mouseMove(x: Int, y: Int) {
        super.mouseMove(x, y)

        children.forEach { it.mouseMove(x, y) }
    }

    override fun mouseScroll(rotation: Int) {
        children.forEach { it.mouseScroll(rotation) }
    }

    override fun keyType(key: Char) {
        children.forEach { it.keyType(key) }
    }

    override fun keyPress(key: Int, modifiers: Int) {
        super.keyPress(key, modifiers)

        children.forEach { it.keyPress(key, modifiers) }
    }

    override fun canFocus(): Boolean {
        return false
    }

    fun getChildren(): List<Widget> {
        return children.toList()
    }

    protected inline fun <reified T : Widget> findChild(index: Int = 0): T {
        val found = children.filterIsInstance(T::class.java)

        return found[index]
    }
}
