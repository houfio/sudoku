package io.houf.sudoku.model.tile

abstract class Tile(value: String, val group: String) {
    val static = value != "0"
    var value = if (static) value else ""
        private set

    fun appendChar(char: Char) {
        if (static || !validInput(value + char)) {
            return
        }

        value += char
    }

    fun removeChar() {
        if (static) {
            return
        }

        value = value.dropLast(1)
    }

    abstract fun validInput(value: String): Boolean

    abstract fun accept(visitor: TileVisitor)
}
