package io.houf.sudoku.controller.impl

import io.houf.sudoku.Sudoku
import io.houf.sudoku.controller.Controller
import io.houf.sudoku.model.command.impl.EnterCommand
import io.houf.sudoku.util.state.EditorState
import io.houf.sudoku.util.state.PlayState
import io.houf.sudoku.util.state.State
import io.houf.sudoku.view.View
import io.houf.sudoku.view.impl.GameView
import java.lang.invoke.SwitchPoint

class GameController(sudoku: Sudoku) : Controller<GameController>(sudoku) {
    private var state: State? = null

    var errors: List<Pair<Int, Int>> = listOf()
        private set

    init {
        state = PlayState()
    }

    fun getSize() = sudoku.game.puzzle?.size ?: 1

    fun getTile(x: Int, y: Int) = sudoku.game.puzzle?.getTile(x, y)

    fun getTiles() = sudoku.game.puzzle?.getTiles() ?: emptyList()

    fun switchMode(){
        if (state is PlayState){
            state = EditorState()
        }else{
            state = PlayState()
        }
        println(state)
    }
    fun enter(x: Int, y: Int, char: Char?) {
        errors = listOf()
        sudoku.game.execute(EnterCommand(x, y, char))
    }

    fun validate() {
        errors = sudoku.game.puzzle?.getErrors() ?: listOf()
    }

    fun solve() = sudoku.game.puzzle?.solve()

    override fun createView(): View<GameController> {
        return GameView(this)
    }
}
