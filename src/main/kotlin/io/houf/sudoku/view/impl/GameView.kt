package io.houf.sudoku.view.impl

import io.houf.sudoku.controller.impl.GameController
import io.houf.sudoku.view.View
import io.houf.sudoku.widget.impl.ButtonWidget

class GameView(controller: GameController) : View<GameController>(controller) {
    init {
        addChild(ButtonWidget("back", 50, 50) {
            controller.pop()
        })
    }
}
