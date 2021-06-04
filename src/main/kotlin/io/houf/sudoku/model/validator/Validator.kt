package io.houf.sudoku.model.validator

import io.houf.sudoku.model.tile.Tile
import io.houf.sudoku.model.tile.TileVisitor

interface Validator : TileVisitor {
    fun getErrors(): List<Tile>
}
