package io.houf.sudoku.widget.impl

import io.houf.sudoku.TileSize
import io.houf.sudoku.model.tile.Tile
import io.houf.sudoku.util.widget.*
import io.houf.sudoku.widget.Draggable
import io.houf.sudoku.widget.Widget
import java.awt.Graphics2D

class TileWidget(
    private val initialX: Int,
    private val initialY: Int,
    private val tile: Tile,
    private val topTile: Tile?,
    private val leftTile: Tile?
) : Widget(initialX * TileSize, initialY * TileSize, TileSize, TileSize), Draggable {
    override fun draw(g: Graphics2D) {
        g.color = if ((initialX + initialY) % 2 == 0) Gray500 else Gray400
        g.fillRect(x, y, width, height)

        tile.value?.let {
            g.color = if (tile.static) Gray300 else Gray0
            g.drawCenteredString(it.toString(), x, y, width, height)
        }

        g.color = Gray0

        if (topTile?.group != tile.group && initialY > 0) {
            g.drawLine(x, y - 1, x + TileSize - 1, y - 1)
        }

        if (leftTile?.group != tile.group && initialX > 0) {
            g.drawLine(x - 1, y, x - 1, y + TileSize - 1)
        }

        if (focused && !tile.static) {
            g.color = Blue200
            g.drawRect(x, y, width - 2, height - 2)
        }
    }

    override fun update() {
    }

    override fun updatePosition(x: Int, y: Int) {
        this.x = initialX * TileSize + x
        this.y = initialY * TileSize + y
    }

    override fun canFocus(): Boolean {
        return !tile.static
    }
}
