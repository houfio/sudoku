package io.houf.sudoku.model.command

import java.util.*

class CommandExecutor<T>(private val context: T) {
    private val commands = Stack<Command<T>>()

    fun execute(command: Command<T>) {
        if (command.execute(context)) {
            commands.push(command)
        }
    }

    fun rollback() {
        if (empty()) {
            return
        }

        commands.pop().rollback(context)
    }

    fun empty() = commands.empty()
}
