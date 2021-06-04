package io.houf.sudoku.view.impl

import io.houf.sudoku.FrameSize
import io.houf.sudoku.controller.impl.OverviewController
import io.houf.sudoku.model.puzzle.PuzzleCandidate
import io.houf.sudoku.util.widget.Gray500
import io.houf.sudoku.view.View
import io.houf.sudoku.widget.impl.ButtonWidget
import io.houf.sudoku.widget.impl.ListWidget
import java.awt.Graphics2D

class OverviewView(controller: OverviewController) : View<OverviewController>(
    controller,
    ButtonWidget("Test", 100, 200) {
        println("click")
    },
    object : ListWidget<PuzzleCandidate>(0, 300, FrameSize, 200, 64) {
        override fun drawItem(item: PuzzleCandidate, g: Graphics2D) {
            g.color = Gray500
            g.drawString("${item.name} (${item.type})", 12, 24)
        }

        override fun clickItem(item: PuzzleCandidate) {
            controller.openDetail(item)
        }
    }
) {
    init {
        findChild<ListWidget<PuzzleCandidate>>().setItems(controller.puzzles)
    }

    override fun draw(g: Graphics2D) {
        g.drawString("Sudoku (${if (focused) "focus" else "no focus"})", 100, 100)

        super.draw(g)
    }
}
