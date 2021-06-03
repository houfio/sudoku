package io.houf.sudoku.model.tile

import io.houf.sudoku.model.visitor.TileVisitor

class DefaultTile(value: Char?, group: String) : Tile(value, group) {
    override fun accept(visitor: TileVisitor) {
        visitor.visitDefault(this)
    }
}
