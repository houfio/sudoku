package io.houf.sudoku.widget.impl

import io.houf.sudoku.FrameSize
import io.houf.sudoku.TaskbarSize
import io.houf.sudoku.util.BlackOlive
import io.houf.sudoku.util.EerieBlack
import io.houf.sudoku.util.Fonts
import io.houf.sudoku.widget.Widget
import java.awt.Graphics2D

class FrameWidget(private val stop: () -> Unit) : Widget(0, 0, FrameSize, TaskbarSize, false) {
    init {
        addChild(ButtonWidget("X", FrameSize - TaskbarSize, 0, TaskbarSize, TaskbarSize) {
            stop()
        })
    }

    override fun draw(g: Graphics2D) {
        g.color = EerieBlack
        g.fillRect(0, 0, width, height)

        g.color = BlackOlive
        g.font = Fonts.Big
        g.drawString("SUDOKU", 6, 25)
        g.font = Fonts.Normal

        super.draw(g)
    }
}
