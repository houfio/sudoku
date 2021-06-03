package io.houf.sudoku.model.visitor

import io.houf.sudoku.model.tile.DefaultTile

class DefaultTileVisitor : TileVisitor {
    override fun visitDefault(tile: DefaultTile) {
        println(tile)
    }
}
