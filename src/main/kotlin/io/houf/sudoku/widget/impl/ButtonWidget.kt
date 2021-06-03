package io.houf.sudoku.widget.impl

import io.houf.sudoku.util.view.*
import io.houf.sudoku.widget.Widget
import java.awt.AlphaComposite
import java.awt.Cursor
import java.awt.Graphics2D
import java.awt.image.BufferedImage

class ButtonWidget(
    private val text: String,
    x: Int,
    y: Int,
    width: Int = 128,
    height: Int = 32,
    private val onClick: () -> Unit
) : Widget(x, y, width, height) {
    private var image: BufferedImage? = null
    var disabled = false

    constructor(i: BufferedImage, x: Int, y: Int, width: Int, height: Int, onClick: () -> Unit) : this("", x, y, width, height, onClick) {
        image = i
    }

    override fun draw(g: Graphics2D) {
        g.color = if (disabled) Blue100 else if (hovered) Blue300 else Blue200
        g.fillRect(x, y, width, height)

        if (image != null) {
            val composite = g.composite

            if (disabled) {
                g.composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)
            }

            g.drawImage(image, x, y, width, height, null)
            g.composite = composite
        }

        g.color = Gray500
        g.drawCenteredString(text, x, y, width, height)

        if (focused && !disabled) {
            g.color = Gray500
            g.drawRect(x, y, width - 2, height - 2)
        }
    }

    override fun update() {
    }

    override fun interact(click: Boolean) {
        if (!disabled) {
            onClick()
        }
    }

    override fun getCursor(): Int? {
        if (!hovered || disabled) {
            return super.getCursor()
        }

        return Cursor.HAND_CURSOR
    }

    override fun canFocus(): Boolean {
        return !disabled
    }
}
