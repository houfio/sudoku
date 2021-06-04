package io.houf.sudoku.model.validator.impl

import io.houf.sudoku.model.tile.Tile
import io.houf.sudoku.model.tile.impl.DefaultTile
import io.houf.sudoku.model.validator.Validator

class DefaultValidator : Validator {
    override fun getErrors(): List<Tile> {
        return listOf()
    }

    override fun visitDefault(tile: DefaultTile) {
        println(tile)
    }
}
