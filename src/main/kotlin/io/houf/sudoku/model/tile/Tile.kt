package io.houf.sudoku.model.tile

import io.houf.sudoku.model.visitor.TileVisitor

abstract class Tile(value: Char?, val group: String) {
    protected val notes = mutableListOf<Char>()
    var value = value
        protected set

    open val validChars = arrayOf<Char>()

    open fun enterValue(char: Char?) {
        if (!validCharacter(char)) {
            return
        }

        value = if (value == char) null else char
    }

    open fun enterNote(char: Char) {
        if (!validCharacter(char)) {
            return
        }

        if (isNoted(char)) {
            notes.remove(char)
        } else {
            notes.add(char)
        }
    }

    open fun isNoted(char: Char) = notes.contains(char)

    open fun validCharacter(char: Char?) = char == null || validChars.contains(char)

    abstract fun accept(visitor: TileVisitor)
}
