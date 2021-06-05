package io.houf.sudoku.model.validator.impl

import io.houf.sudoku.model.puzzle.Puzzle
import io.houf.sudoku.model.tile.Tile
import io.houf.sudoku.model.validator.Validator

class SamuraiValidator : Validator {
    override fun getErrors(puzzle: Puzzle): List<Pair<Int, Int>> {
        val tiles = puzzle.getTiles();
        val groups = tiles.groupBy({ it.third.group }, { it.third })

        return tiles.filter { (_, _, tile) ->
            if (tile.value == null) {
                return@filter false
            }

            invalid(tile, groups[tile.group])
        }.map { Pair(it.first, it.second) }
    }

    private fun invalid(tile: Tile, list: List<Tile>?) = list?.count { it.value == tile.value } ?: 0 > 1
}
