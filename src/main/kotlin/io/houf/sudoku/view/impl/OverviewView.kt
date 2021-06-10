package io.houf.sudoku.view.impl

import io.houf.sudoku.FrameSize
import io.houf.sudoku.controller.impl.OverviewController
import io.houf.sudoku.model.puzzle.PuzzleCandidate
import io.houf.sudoku.util.Fonts
import io.houf.sudoku.util.Gray500
import io.houf.sudoku.util.drawCenteredString
import io.houf.sudoku.view.View
import io.houf.sudoku.widget.impl.ListWidget
import java.awt.Graphics2D

class OverviewView(controller: OverviewController) : View<OverviewController>(
    controller,
    object : ListWidget<PuzzleCandidate>(64, 256, FrameSize - 128, 320, 64) {
        override fun drawItem(item: PuzzleCandidate, g: Graphics2D) {
            g.color = Gray500
            g.drawString("${item.name} (${item.type})", 12, 24)
        }

        override fun clickItem(item: PuzzleCandidate) {
            controller.start(item)
        }
    }
) {
    init {
        findChild<ListWidget<PuzzleCandidate>>().setItems(controller.puzzles)
    }

    override fun draw(g: Graphics2D) {
        g.font = Fonts.Big
        g.drawCenteredString("Welcome to Sudoku", 0, 192, FrameSize)

        g.font = Fonts.Normal
        g.drawCenteredString("Pick a puzzle to get started", 0, 640, FrameSize)

        super.draw(g)
    }
}
