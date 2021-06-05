package io.houf.sudoku.model.validator.impl

import io.houf.sudoku.model.puzzle.Puzzle
import io.houf.sudoku.model.tile.Tile
import io.houf.sudoku.model.validator.Validator

class DefaultValidator : Validator {
    override fun getErrors(puzzle: Puzzle): List<Tile> {
        val tiles = puzzle.getTiles();
        val columns = tiles.groupBy({ it.first }, { it.third })
        val rows = tiles.groupBy({ it.second }, { it.third })
        val groups = tiles.groupBy({ it.third.group }, { it.third })

        return tiles.filter { (x, y, tile) ->
            if (tile.value == null) {
                return@filter false
            }

            invalid(tile, columns[x]) || invalid(tile, rows[y]) || invalid(tile, groups[tile.group])
        }.map { it.third }
    }

    private fun invalid(tile: Tile, list: List<Tile>?) = list?.count { it.value == tile.value } ?: 0 > 1
}
