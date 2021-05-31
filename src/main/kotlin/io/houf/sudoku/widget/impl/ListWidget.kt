package io.houf.sudoku.widget.impl

import io.houf.sudoku.util.Blue200
import io.houf.sudoku.util.Gray100
import io.houf.sudoku.util.Gray200
import io.houf.sudoku.widget.Widget
import java.awt.Cursor
import java.awt.Graphics2D
import java.awt.event.KeyEvent

abstract class ListWidget<T>(x: Int, y: Int, width: Int, height: Int, private val itemHeight: Int) : Widget(x, y, width, height) {
    private var items = listOf<T>()
    private var selected = 0
    private var hoveredIndex: Int? = null
    private var offset = 0

    override fun draw(g: Graphics2D) {
        g.color = Gray100
        g.fillRect(x, y, width, height)

        val clip = g.clip
        g.setClip(x, y, width, height)

        items.forEachIndexed { index, item ->
            val offset = index * itemHeight + -this.offset

            g.translate(x, y + offset)

            if (hoveredIndex == index) {
                g.color = Gray200
                g.fillRect(0, 0, width, itemHeight)
            }

            if (focused && selected == index) {
                g.color = Blue200
                g.drawRect(0, 0, width - 2, itemHeight - 2)
            }

            drawItem(item, g)
            g.translate(-x, -y - offset)
        }

        g.clip = clip
    }

    override fun update() {
    }

    override fun mouseMove(x: Int, y: Int) {
        super.mouseMove(x, y)

        if (!hovered) {
            hoveredIndex = null

            return
        }

        hoveredIndex = (y - this.y + offset) / itemHeight
    }

    override fun mouseScroll(rotation: Int) {
        if (hovered) {
            offset = (offset + rotation * 18).coerceIn(0, items.size * itemHeight - height)
        }
    }

    override fun keyPress(key: Int, modifiers: Int) {
        super.keyPress(key, modifiers)

        if (!focused || (key != KeyEvent.VK_UP && key != KeyEvent.VK_DOWN)) {
            return
        }

        selected += if (key == KeyEvent.VK_UP) -1 else 1
        wrapSelected()

        val top = selected * itemHeight
        val bottom = top + itemHeight - height

        offset = offset.coerceIn(bottom, top)
    }

    override fun interact(click: Boolean) {
        if (click) {
            selected = hoveredIndex ?: 0
        }

        clickItem(items[selected])
    }

    override fun getCursor(): Int? {
        return if (hoveredIndex != null) Cursor.HAND_CURSOR else super.getCursor()
    }

    abstract fun drawItem(item: T, g: Graphics2D)

    abstract fun clickItem(item: T)

    fun setItems(i: List<T>) {
        items = i
        wrapSelected()
    }

    private fun wrapSelected() {
        if (selected < 0) {
            selected = items.size - 1
        } else if (selected > items.size - 1) {
            selected = 0
        }
    }
}
