package io.houf.sudoku.view.impl

import io.houf.sudoku.FrameSize
import io.houf.sudoku.TaskbarSize
import io.houf.sudoku.TileSize
import io.houf.sudoku.controller.impl.GameController
import io.houf.sudoku.util.Gray200
import io.houf.sudoku.view.View
import io.houf.sudoku.widget.impl.ButtonWidget
import io.houf.sudoku.widget.impl.TileWidget
import java.awt.Graphics2D

class GameView(controller: GameController) : View<GameController>(
    controller,
    children = arrayOf(
        ButtonWidget("Switch mode", 0, FrameSize - TaskbarSize, 200, TaskbarSize) {
            controller.switchMode()
        },
        ButtonWidget("Check", FrameSize - 200, FrameSize - TaskbarSize, 100, TaskbarSize) {
            controller.validate()
        },
        ButtonWidget("Solve", FrameSize - 100, FrameSize - TaskbarSize, 100, TaskbarSize) {
            controller.solve()
        },
        *controller.getTiles().map { (x, y, tile) ->
            TileWidget(
                x,
                y,
                tile,
                controller.getTile(x, y - 1),
                controller.getTile(x - 1, y),
                { controller.errors.any { it.first == x && it.second == y } },
                { controller.enter(x, y, it) }
            )
        }.toTypedArray()
    ),
    FrameSize / 2 - controller.getSize() * TileSize / 2
) {
    override fun drawTop(g: Graphics2D) {
        g.color = Gray200
        g.fillRect(0, FrameSize - TaskbarSize, width, TaskbarSize)
    }
}
