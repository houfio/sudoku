package io.houf.sudoku.widget.impl

import io.houf.sudoku.FrameSize
import io.houf.sudoku.TaskbarSize
import io.houf.sudoku.controller.Controller
import io.houf.sudoku.util.Fonts
import io.houf.sudoku.util.Gray0
import io.houf.sudoku.util.Gray200
import io.houf.sudoku.util.Images
import io.houf.sudoku.widget.WidgetGroup
import java.awt.Graphics2D

class FrameWidgetGroup(controller: Controller<*>) : WidgetGroup(
    ButtonWidget(Images.read("back"), 0, 0, TaskbarSize, TaskbarSize) {
        controller.pop()
    },
    ButtonWidget(Images.read("close"), FrameSize - TaskbarSize, 0, TaskbarSize, TaskbarSize) {
        controller.stop()
    }
) {
    init {
        findChild<ButtonWidget>().disabled = !controller.canPop()
    }

    override fun draw(g: Graphics2D) {
        g.color = Gray200
        g.fillRect(x, y, width, height)

        g.color = Gray0
        g.font = Fonts.Big
        g.drawString("SUDOKU", 6 + height, 25)
        g.font = Fonts.Normal

        super.draw(g)
    }
}
