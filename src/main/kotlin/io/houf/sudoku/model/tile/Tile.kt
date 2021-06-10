package io.houf.sudoku.model.tile

abstract class Tile(value: Char, val group: String, emptyChar: Char) {
    private val notes = mutableListOf<Char>()
    val static = value != emptyChar
    var value = if (static) value else null
        private set

    abstract val validChars: Array<Char>

    fun enterValue(char: Char?) {
        if (static || !validCharacter(char)) {
            return
        }

        value = if (value == char) null else char
    }

    fun enterNote(char: Char) {
        if (static || !validCharacter(char)) {
            return
        }

        if (isNoted(char)) {
            notes.remove(char)
        } else {
            notes.add(char)
        }
    }

    fun isNoted(char: Char) = notes.contains(char)

    open fun validCharacter(char: Char?) = char == null || validChars.contains(char)

    abstract fun accept(visitor: TileVisitor)
}
