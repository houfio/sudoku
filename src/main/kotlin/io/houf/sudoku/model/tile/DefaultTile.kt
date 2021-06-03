package io.houf.sudoku.model.tile

import io.houf.sudoku.model.visitor.TileVisitor

class DefaultTile(private var value: Char?, private val group: Int) : Tile() {
    override fun accept(visitor: TileVisitor) {
        visitor.visitDefault(this)
    }
}
