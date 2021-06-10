package io.houf.sudoku.model.tile

data class Position(
    val x: Int,
    val y: Int
) {
    fun top() = Position(x, y - 1)

    fun bottom() = Position(x, y + 1)

    fun left() = Position(x - 1, y)

    fun right() = Position(x + 1, y)

    fun inside(size: Int) = x >= 0 && y >= 0 && x < size && y < size
}
