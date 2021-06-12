package io.houf.sudoku.widget.impl

import io.houf.sudoku.TileSize
import io.houf.sudoku.model.tile.Position
import io.houf.sudoku.model.tile.Tile
import io.houf.sudoku.util.*
import io.houf.sudoku.widget.Draggable
import io.houf.sudoku.widget.Widget
import java.awt.Graphics2D
import java.awt.RenderingHints
import java.awt.event.KeyEvent

class TileWidget(
    private val tile: Tile,
    private val position: Position,
    private val topTile: Tile?,
    private val leftTile: Tile?,
    private val error: () -> Boolean,
    private val enter: (char: Char?) -> Unit
) : Widget(position.x * TileSize, position.y * TileSize, TileSize, TileSize), Draggable {
    override fun draw(g: Graphics2D) {
        g.color = if ((position.x + position.y) % 2 == 0) Gray500 else Gray400
        g.fillRect(x, y, width, height)

        if (error()) {
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)

            g.color = Red300
            g.fillOval(x + height / 4, y + height / 4, width / 2, height / 2)

            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF)
        }

        tile.value?.let {
            g.color = if (tile.validChars.isEmpty()) Gray300 else Gray0
            g.drawCenteredString(it.toString(), x, y, width, height)
        }

        g.color = Gray0
        g.font = Fonts.Small

        tile.validChars.filter { tile.isNoted(it) }.forEachIndexed { index, char ->
            g.drawString(char.toString(), x + 4 + g.fontMetrics.charWidth(char) * index, y + 14)
        }

        g.font = Fonts.Normal

        if (topTile?.group != tile.group && position.y > 0) {
            g.drawLine(x, y, x + TileSize, y)
        }

        if (leftTile?.group != tile.group && position.x > 0) {
            g.drawLine(x, y, x, y + TileSize)
        }

        if (focused && tile.validChars.isNotEmpty()) {
            g.color = Blue200
            g.drawRect(x + 1, y + 1, width - 2, height - 2)
        }
    }

    override fun update() {
    }

    override fun updatePosition(x: Int, y: Int) {
        this.x = position.x * TileSize + x
        this.y = position.y * TileSize + y
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
        return tile.validChars.isNotEmpty()
    }
}
