package io.houf.sudoku.model.tile.impl

import io.houf.sudoku.model.tile.Tile
import io.houf.sudoku.model.tile.TileVisitor

class DefaultTile(value: String, group: String) : Tile(value, group) {
    override fun validInput(value: String): Boolean {
        val parsed = value.toIntOrNull()

        return parsed != null && parsed < 10
    }

    override fun accept(visitor: TileVisitor) {
        visitor.visitDefault(this)
    }
}
