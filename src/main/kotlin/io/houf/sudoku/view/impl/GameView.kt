package io.houf.sudoku.view.impl

import io.houf.sudoku.FrameSize
import io.houf.sudoku.controller.impl.GameController
import io.houf.sudoku.util.view.Gray0
import io.houf.sudoku.util.view.Gray500
import io.houf.sudoku.util.view.drawCenteredString
import io.houf.sudoku.view.View
import java.awt.Graphics2D

class GameView(controller: GameController) : View<GameController>(controller) {
    private var translationX = 0
    private var translationY = 0
    private var offsetX = 0
    private var offsetY = 0
    private var dragging = false

    override fun draw(g: Graphics2D) {

        g.translate(translationX, translationY)

        controller.forEachTile { x, y, tile ->
            val size = 64
            val offset = FrameSize / 2 - controller.getSize() * size / 2
            val xx = offset + x * size
            val yy = offset + y * size

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

        g.translate(-translationX, -translationY)

        super.draw(g)
    }

    override fun mousePress(x: Int, y: Int) {
        dragging = hovered

        if (dragging) {
            offsetX = x - translationX
            offsetY = y - translationY
        }

        super.mousePress(x, y)
    }

    override fun mouseDrag(x: Int, y: Int) {
        if (dragging) {
            translationX = x - offsetX
            translationY = y - offsetY
        }

        super.mouseDrag(x, y)
    }

    override fun mouseRelease(x: Int, y: Int) {
        dragging = false

        super.mouseRelease(x, y)
    }
}
