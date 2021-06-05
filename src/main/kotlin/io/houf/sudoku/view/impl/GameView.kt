package io.houf.sudoku.view.impl

import io.houf.sudoku.FrameSize
import io.houf.sudoku.TileSize
import io.houf.sudoku.controller.impl.GameController
import io.houf.sudoku.view.View
import io.houf.sudoku.widget.impl.ActionsWidgetGroup
import io.houf.sudoku.widget.impl.TileWidget

class GameView(controller: GameController) : View<GameController>(
    controller,
    children = arrayOf(
        *controller.getTiles().map { (x, y, tile) ->
            TileWidget(
                x,
                y,
                tile,
                controller.getTile(x, y - 1),
                controller.getTile(x - 1, y)
            ) {
                controller.enter(x, y, it)
            }
        }.toTypedArray(),
        ActionsWidgetGroup()
    ),
    FrameSize / 2 - controller.getSize() * TileSize / 2
)
