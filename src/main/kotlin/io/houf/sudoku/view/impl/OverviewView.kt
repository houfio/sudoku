package io.houf.sudoku.view.impl

import io.houf.sudoku.controller.impl.OverviewController
import io.houf.sudoku.view.View
import io.houf.sudoku.widget.impl.ButtonWidget
import java.awt.Graphics2D

class OverviewView(controller: OverviewController) : View<OverviewController>(controller) {
    init {
        addChild(ButtonWidget("Test", 100, 200) {
            println("click")
        })

        addChild(ButtonWidget("Test 2", 100, 300) {
            controller.pushGame()
        })
    }

    override fun draw(g: Graphics2D) {
        g.drawString("Sudoku (${if (focused) "focus" else "no focus"})", 100, 100)

        super.draw(g)
    }
}
