package io.houf.sudoku.model

import io.houf.sudoku.model.command.Command
import io.houf.sudoku.model.command.CommandExecutor
import io.houf.sudoku.model.puzzle.Puzzle
import io.houf.sudoku.model.puzzle.PuzzleCandidate
import io.houf.sudoku.util.state.EditorState
import io.houf.sudoku.util.state.PlayState
import io.houf.sudoku.util.state.State

class Game {
    private val executor = CommandExecutor(this)

    var state: State = PlayState()
        private set
    var puzzleCandidate: PuzzleCandidate? = null
    var puzzle: Puzzle? = null



    fun execute(command: Command<Game>) {
        executor.execute(command)
    }

    fun rollback() {
        executor.rollback()
    }

    fun switchMode() {
        state = if (state is PlayState){
            EditorState()
        }else{
            PlayState()
        }
        println(state)
    }
}
