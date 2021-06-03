package io.houf.sudoku.model.visitor

import io.houf.sudoku.model.tile.DefaultTile

interface TileVisitor {
    fun visitDefault(tile: DefaultTile)
}
