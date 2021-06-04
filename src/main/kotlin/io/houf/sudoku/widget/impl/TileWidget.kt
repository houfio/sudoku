package io.houf.sudoku.widget.impl

import io.houf.sudoku.TileSize
import io.houf.sudoku.model.tile.Tile
import io.houf.sudoku.util.view.*
import io.houf.sudoku.widget.Draggable
import io.houf.sudoku.widget.Widget
import java.awt.Graphics2D

class TileWidget(
    private val initialX: Int,
    private val initialY: Int,
    private val tile: Tile
) : Widget(initialX * TileSize, initialY * TileSize, TileSize, TileSize), Draggable {
    override fun draw(g: Graphics2D) {
        g.color = if ((initialX + initialY) % 2 == 0) Gray500 else Gray400
        g.fillRect(x, y, width, height)
        g.color = Gray0

        tile.value?.let {
            g.drawCenteredString(it.toString(), x, y, width, height)
        }

        if (focused) {
            g.color = Blue200
            g.drawRect(x, y, width - 2, height - 2)
        }
    }

    override fun update() {
    }

    override fun interact() {
        println("bruh")
    }

    override fun updatePosition(x: Int, y: Int) {
        this.x = initialX * TileSize + x
        this.y = initialY * TileSize + y
    }
}
