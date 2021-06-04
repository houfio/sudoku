package io.houf.sudoku.model.tile.impl

import io.houf.sudoku.model.tile.Tile
import io.houf.sudoku.model.tile.TileVisitor

class DefaultTile(value: Char?, group: String) : Tile(value, group) {
    override fun accept(visitor: TileVisitor) {
        visitor.visitDefault(this)
    }
}
