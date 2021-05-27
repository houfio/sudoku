package io.houf.sudoku.widget.impl

import io.houf.sudoku.FrameSize
import io.houf.sudoku.Sudoku
import io.houf.sudoku.TaskbarSize
import io.houf.sudoku.util.Fonts
import io.houf.sudoku.util.Gray0
import io.houf.sudoku.util.Gray200
import io.houf.sudoku.util.Images
import io.houf.sudoku.widget.Widget
import java.awt.Graphics2D

class FrameWidget(sudoku: Sudoku) : Widget(0, 0, FrameSize, TaskbarSize) {
    init {
        val button = ButtonWidget(Images.read("back"), 0, 0, height, height) {
            sudoku.pop()
        }

        button.disabled = !sudoku.canPop()

        addChild(button)

        addChild(ButtonWidget(Images.read("close"), width - height, 0, height, height) {
            sudoku.stop()
        })
    }

    override fun draw(g: Graphics2D) {
        g.color = Gray200
        g.fillRect(0, 0, width, height)

        g.color = Gray0
        g.font = Fonts.Big
        g.drawString("SUDOKU", 6 + height, 25)
        g.font = Fonts.Normal

        super.draw(g)
    }

    override fun canFocus(): Boolean {
        return false
    }
}
