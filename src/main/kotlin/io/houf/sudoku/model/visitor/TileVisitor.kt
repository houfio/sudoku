package io.houf.sudoku.model.visitor

import io.houf.sudoku.model.tile.impl.DefaultTile
import io.houf.sudoku.model.tile.impl.StaticTile

interface TileVisitor {
    fun visit(tile: DefaultTile)

    fun visit(tile: StaticTile)
}
