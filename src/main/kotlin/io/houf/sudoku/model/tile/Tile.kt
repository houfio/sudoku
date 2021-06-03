package io.houf.sudoku.model.tile

import io.houf.sudoku.model.visitor.TileVisitor

abstract class Tile {
    abstract fun accept(visitor: TileVisitor)
}
