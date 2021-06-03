package io.houf.sudoku.view.impl

import io.houf.sudoku.controller.impl.StartController
import io.houf.sudoku.view.View
import io.houf.sudoku.widget.impl.ButtonWidget
import java.awt.Graphics2D

class StartView(controller: StartController) : View<StartController>(
    controller,
    ButtonWidget("Start", 50, 50) {
        controller.startPuzzle()
    }
) {
    override fun draw(g: Graphics2D) {
        g.drawString(controller.getPuzzleName(), 200, 200)

        super.draw(g)
    }
}
