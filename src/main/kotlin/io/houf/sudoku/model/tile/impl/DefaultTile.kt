package io.houf.sudoku.model.tile.impl

import io.houf.sudoku.model.tile.Tile
import io.houf.sudoku.model.visitor.TileVisitor

class DefaultTile(size: Int, group: String) : Tile(null, group) {
    override val validChars = Array(size) { '1' + it }

    override fun accept(visitor: TileVisitor) = visitor.visit(this)
}
