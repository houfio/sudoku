package io.houf.sudoku.model.tile

import io.houf.sudoku.model.tile.impl.DefaultTile

interface TileVisitor {
    fun visitDefault(tile: DefaultTile)
}
