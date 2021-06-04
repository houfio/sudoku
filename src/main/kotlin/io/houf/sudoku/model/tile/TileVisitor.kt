package io.houf.sudoku.model.tile

interface TileVisitor {
    fun visitDefault(tile: DefaultTile)
}
