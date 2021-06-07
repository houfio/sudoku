package io.houf.sudoku.widget.impl

import io.houf.sudoku.FrameSize
import io.houf.sudoku.TaskbarSize
import io.houf.sudoku.util.Gray200
import io.houf.sudoku.widget.WidgetGroup
import java.awt.Graphics2D

class ActionsWidgetGroup(switchMode: () -> Unit, validate: () -> Unit, solve: () -> Unit) : WidgetGroup(
    ButtonWidget("Switch mode", 0, FrameSize - TaskbarSize, 200, TaskbarSize, switchMode),
    ButtonWidget("Check", FrameSize - 200, FrameSize - TaskbarSize, 100, TaskbarSize, validate),
    ButtonWidget("Solve", FrameSize - 100, FrameSize - TaskbarSize, 100, TaskbarSize, solve)
) {
    override fun draw(g: Graphics2D) {
        g.color = Gray200
        g.fillRect(x, y, width, height)

        super.draw(g)
    }
}
