package io.houf.sudoku.model

import io.houf.sudoku.model.command.Command
import io.houf.sudoku.model.command.CommandExecutor
import io.houf.sudoku.model.puzzle.Puzzle
import io.houf.sudoku.model.puzzle.PuzzleCandidate

class Game {
    private val executor = CommandExecutor(this)

    var puzzleCandidate: PuzzleCandidate? = null
    var puzzle: Puzzle? = null

    fun execute(command: Command<Game>) {
        executor.execute(command)
    }

    fun rollback() {
        executor.rollback()
    }
}
