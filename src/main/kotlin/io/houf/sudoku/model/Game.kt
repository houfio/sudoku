package io.houf.sudoku.model

import io.houf.sudoku.model.command.Command
import io.houf.sudoku.model.command.CommandExecutor

class Game {
    private var data = GameData()
    private val executor = CommandExecutor(data)

    val candidate
        get() = data.candidate
    val puzzle
        get() = data.puzzle
    val state
        get() = data.state.name

    fun execute(command: Command<GameData>) {
        executor.execute(command)
    }

    fun rollback() {
        executor.rollback()
    }
}
