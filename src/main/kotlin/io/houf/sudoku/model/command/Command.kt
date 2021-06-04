package io.houf.sudoku.model.command

interface Command<T> {
    fun execute(context: T): Boolean

    fun rollback(context: T) {
    }
}
