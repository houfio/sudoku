package io.houf.sudoku.widget.impl

import io.houf.sudoku.util.EerieBlack
import io.houf.sudoku.util.Flame
import io.houf.sudoku.util.FloralWhite
import io.houf.sudoku.util.drawCenteredString
import io.houf.sudoku.widget.Widget
import java.awt.Cursor
import java.awt.Graphics2D

class ButtonWidget(
    private val text: String,
    x: Int,
    y: Int,
    width: Int = 128,
    height: Int = 32,
    private val onClick: () -> Unit
) : Widget(x, y, width, height) {
    override fun draw(g: Graphics2D) {
        g.color = if (hovered) EerieBlack else EerieBlack
        g.fillRect(x, y, width, height)

        g.color = FloralWhite
        g.drawCenteredString(text, x, y, width, height)

        if (focused) {
            g.color = Flame
            g.drawRect(x, y, width - 2, height - 2)
        }

        super.draw(g)
    }

    override fun interact() {
        onClick()
    }

    override fun getCursor(): Int? {
        if (!hovered) {
            return super.getCursor()
        }

        return Cursor.HAND_CURSOR
    }
}
