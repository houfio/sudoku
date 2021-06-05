package io.houf.sudoku.model.tile

abstract class Tile(value: Char, val group: String) {
    val static = value != '0'
    var value = if (static) value else null
        private set

    abstract val validChars: Array<Char>

    fun enterChar(char: Char?) {
        if (static || (char != null && !validChars.contains(char))) {
            return
        }

        value = if (value == char) null else char
    }

    abstract fun accept(visitor: TileVisitor)
}
