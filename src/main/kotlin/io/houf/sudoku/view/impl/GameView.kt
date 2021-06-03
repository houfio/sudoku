package io.houf.sudoku.view.impl

import io.houf.sudoku.TaskbarSize
import io.houf.sudoku.controller.impl.GameController
import io.houf.sudoku.util.view.Gray0
import io.houf.sudoku.util.view.Gray500
import io.houf.sudoku.util.view.drawCenteredString
import io.houf.sudoku.view.View
import java.awt.Graphics2D

class GameView(controller: GameController) : View<GameController>(controller) {
    override fun draw(g: Graphics2D) {
        controller.forEachTile { x, y, tile ->
            val size = 64
            val xx = 100 + x * size
            val yy = 100 + TaskbarSize + y * size

            g.color = Gray500
            g.fillRect(xx, yy, size, size)
            g.color = Gray0
            g.drawCenteredString(tile.value?.toString() ?: "-", xx, yy, size, size)

            val leftGroup = controller.getTile(x - 1, y)?.group ?: -1
            val topGroup = controller.getTile(x, y - 1)?.group ?: -1

            if (leftGroup != tile.group && x > 0) {
                g.drawLine(xx, yy, xx, yy + size)
            }

            if (topGroup != tile.group && y > 0) {
                g.drawLine(xx, yy, xx + size, yy)
            }
        }

        super.draw(g)
    }
}
