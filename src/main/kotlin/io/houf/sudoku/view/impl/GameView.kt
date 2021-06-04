package io.houf.sudoku.view.impl

import io.houf.sudoku.FrameSize
import io.houf.sudoku.TileSize
import io.houf.sudoku.controller.impl.GameController
import io.houf.sudoku.view.View
import io.houf.sudoku.widget.impl.TileWidget

class GameView(controller: GameController) : View<GameController>(
    controller,
    children = controller.getTiles().map { (x, y, tile) ->
        TileWidget(x, y, tile)
    }.toTypedArray(),
    FrameSize / 2 - controller.getSize() * TileSize / 2
)
