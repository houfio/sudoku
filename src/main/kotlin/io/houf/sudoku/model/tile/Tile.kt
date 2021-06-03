package io.houf.sudoku.model.tile

import io.houf.sudoku.model.visitor.TileVisitor

abstract class Tile(value: Char?, val group: Int) {
    var value = value
        private set

    abstract fun accept(visitor: TileVisitor)
}
