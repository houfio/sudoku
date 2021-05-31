package io.houf.sudoku.view.impl

import io.houf.sudoku.FrameSize
import io.houf.sudoku.controller.impl.OverviewController
import io.houf.sudoku.util.Gray500
import io.houf.sudoku.view.View
import io.houf.sudoku.widget.impl.ButtonWidget
import io.houf.sudoku.widget.impl.ListWidget
import java.awt.Graphics2D

class OverviewView(controller: OverviewController) : View<OverviewController>(
    controller,
    ButtonWidget("Test", 100, 200) {
        println("click")
    },
    object : ListWidget<Triple<String, String, String>>(0, 300, FrameSize, 200, 64) {
        override fun drawItem(item: Triple<String, String, String>, g: Graphics2D) {
            g.color = Gray500
            g.drawString("${item.first} (${item.second})", 12, 24)
        }

        override fun clickItem(item: Triple<String, String, String>) {
            controller.openDetail(item)
        }
    }
) {
    init {
        findChild<ListWidget<Any>>().setItems(controller.puzzles)
    }

    override fun draw(g: Graphics2D) {
        g.drawString("Sudoku (${if (focused) "focus" else "no focus"})", 100, 100)

        super.draw(g)
    }
}
