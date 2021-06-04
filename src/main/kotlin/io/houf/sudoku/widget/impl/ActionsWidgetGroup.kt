package io.houf.sudoku.widget.impl

import io.houf.sudoku.FrameSize
import io.houf.sudoku.TaskbarSize
import io.houf.sudoku.util.view.Gray200
import io.houf.sudoku.widget.WidgetGroup
import java.awt.Graphics2D

class ActionsWidgetGroup : WidgetGroup(
    ButtonWidget("Switch mode", 0, FrameSize - TaskbarSize, 200, TaskbarSize) { },
    ButtonWidget("Check", FrameSize - 200, FrameSize - TaskbarSize, 100, TaskbarSize) { },
    ButtonWidget("Solve", FrameSize - 100, FrameSize - TaskbarSize, 100, TaskbarSize) { }
) {
    override fun draw(g: Graphics2D) {
        g.color = Gray200
        g.fillRect(x, y, width, height)

        super.draw(g)
    }
}
