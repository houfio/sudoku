package io.houf.sudoku.view.impl

import io.houf.sudoku.FrameSize
import io.houf.sudoku.TaskbarSize
import io.houf.sudoku.TileSize
import io.houf.sudoku.controller.impl.GameController
import io.houf.sudoku.util.Gray200
import io.houf.sudoku.util.Gray500
import io.houf.sudoku.view.View
import io.houf.sudoku.widget.impl.ButtonWidget
import io.houf.sudoku.widget.impl.TileWidget
import java.awt.Graphics2D

class GameView(controller: GameController) : View<GameController>(
    controller,
    children = arrayOf(
        *controller.getTiles().map { (tile, position) ->
            TileWidget(
                tile,
                position,
                controller.getTile(position.top()),
                controller.getTile(position.left()),
                { controller.errors.any { it == position } },
                { controller.enter(position, it) }
            )
        }.toTypedArray(),
        ButtonWidget("Switch mode", 0, FrameSize - TaskbarSize, 150, TaskbarSize) {
            controller.switchMode()
        },
        ButtonWidget("Check", FrameSize - 150, FrameSize - TaskbarSize, 75, TaskbarSize) {
            controller.validate()
        },
        ButtonWidget("Solve", FrameSize - 75, FrameSize - TaskbarSize, 75, TaskbarSize) {
            controller.solve()
        }
    ),
    FrameSize / 2 - controller.getSize() * TileSize / 2
) {
    override fun drawTop(g: Graphics2D) {
        g.color = Gray200
        g.fillRect(0, FrameSize - TaskbarSize, width, TaskbarSize)

        g.color = Gray500
        g.drawString("(currently: ${if (controller.isNoting()) "noting" else "playing"})", 160, FrameSize - 11)
    }
}
