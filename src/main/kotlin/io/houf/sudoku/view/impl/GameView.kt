package io.houf.sudoku.view.impl

import io.houf.sudoku.controller.impl.GameController
import io.houf.sudoku.view.View
import java.awt.Graphics2D

class GameView(controller: GameController) : View<GameController>(controller) {
    override fun draw(g: Graphics2D) {
        g.drawString("size: ${controller.getSize()}", 200, 200)

        super.draw(g)
    }
}
