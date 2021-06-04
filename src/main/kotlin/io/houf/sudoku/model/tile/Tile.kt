package io.houf.sudoku.model.tile

abstract class Tile(value: Char?, val group: String) {
    var value = value
        private set
    val static = value != null

    abstract fun accept(visitor: TileVisitor)
}
