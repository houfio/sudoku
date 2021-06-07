package io.houf.sudoku.widget.impl

import io.houf.sudoku.TileSize
import io.houf.sudoku.model.tile.Tile
import io.houf.sudoku.util.*
import io.houf.sudoku.widget.Draggable
import io.houf.sudoku.widget.Widget
import java.awt.Graphics2D
import java.awt.RenderingHints
import java.awt.event.KeyEvent

class TileWidget(
    private val initialX: Int,
    private val initialY: Int,
    private val tile: Tile,
    private val topTile: Tile?,
    private val leftTile: Tile?,
    private val error: () -> Boolean,
    private val enter: (char: Char?) -> Unit
) : Widget(initialX * TileSize, initialY * TileSize, TileSize, TileSize), Draggable {
    override fun draw(g: Graphics2D) {
        g.color = if ((initialX + initialY) % 2 == 0) Gray500 else Gray400
        g.fillRect(x, y, width, height)

        if (error()) {
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)

            g.color = Red300
            g.fillOval(x + height / 4, y + height / 4, width / 2, height / 2)

            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF)
        }

        tile.value?.let {
            g.color = if (tile.static) Gray300 else Gray0
            g.drawCenteredString(it.toString(), x, y, width, height)
        }

        g.color = Gray0

        if (topTile?.group != tile.group && initialY > 0) {
            g.drawLine(x, y, x + TileSize, y)
        }

        if (leftTile?.group != tile.group && initialX > 0) {
            g.drawLine(x, y, x, y + TileSize)
        }

        if (focused && !tile.static) {
            g.color = Blue200
            g.drawRect(x + 1, y + 1, width - 2, height - 2)
        }
    }

    override fun update() {
    }

    override fun updatePosition(x: Int, y: Int) {
        this.x = initialX * TileSize + x
        this.y = initialY * TileSize + y
    }

    override fun keyType(key: Char) {
        if (focused) {
            enter(key)
        }
    }

    override fun keyPress(key: Int, modifiers: Int) {
        if (focused && key == KeyEvent.VK_BACK_SPACE) {
            enter(null)
        }
    }

    override fun canFocus(): Boolean {
        return !tile.static
    }
}
