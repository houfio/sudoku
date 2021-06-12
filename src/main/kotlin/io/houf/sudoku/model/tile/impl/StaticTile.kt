package io.houf.sudoku.model.tile.impl

import io.houf.sudoku.model.tile.Tile
import io.houf.sudoku.model.visitor.TileVisitor

class StaticTile(value: Char, group: String) : Tile(value, group) {
    override fun validCharacter(char: Char?) = false

    override fun accept(visitor: TileVisitor) = visitor.visit(this)
}
