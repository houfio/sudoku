package io.houf.sudoku.model.solver.impl

import io.houf.sudoku.model.tile.PositionedTile

class SamuraiSolver : DefaultSolver() {
    override fun getTileCandidates(tiles: List<PositionedTile>): List<PositionedTile> {
        val groups = tiles.map { it.tile.group[0] }.distinct()
        val grouped = groups.map {
            tiles.filter { (tile) ->
                val (a, b) = tile.group.split(',')

                a == it.toString() || b == it.toString()
            }
        }

        return grouped.firstOrNull { value ->
            value.any { it.tile.value == null }
        } ?: listOf()
    }
}
