package io.houf.sudoku.model.tile.impl

import io.houf.sudoku.model.tile.Tile
import io.houf.sudoku.model.tile.TileVisitor

class DefaultTile(size: Int, value: Char, group: String) : Tile(value, group) {
    override val validChars = Array(size) {
        index -> '1' + index
    }

    override fun accept(visitor: TileVisitor) {
        visitor.visitDefault(this)
    }
}
