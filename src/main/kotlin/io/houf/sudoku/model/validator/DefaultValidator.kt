package io.houf.sudoku.model.validator

import io.houf.sudoku.model.tile.DefaultTile
import io.houf.sudoku.model.tile.Tile

class DefaultValidator : Validator {
    override fun getErrors(): List<Tile> {
        return listOf()
    }

    override fun visitDefault(tile: DefaultTile) {
        println(tile)
    }
}
