package io.houf.sudoku.model.tile

import io.houf.sudoku.model.visitor.TileVisitor

abstract class Tile(value: Char?, val group: String) {
    var value = value
        private set
    val static = value != null

    abstract fun accept(visitor: TileVisitor)
}
