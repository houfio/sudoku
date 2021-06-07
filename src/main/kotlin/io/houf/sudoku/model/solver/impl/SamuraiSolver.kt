package io.houf.sudoku.model.solver.impl

import io.houf.sudoku.model.tile.Tile

class SamuraiSolver : DefaultSolver() {
    override fun getTileCandidates(tiles: List<Triple<Int, Int, Tile>>): List<Triple<Int, Int, Tile>> {
        val groups = tiles.map { it.third.group[0] }.distinct()
        val grouped = groups.map {
            tiles.filter { (_, _, tile) ->
                val (a, b) = tile.group.split(',')

                a == it.toString() || b == it.toString()
            }
        }

        return grouped.firstOrNull { value ->
            value.any { it.third.value == null }
        } ?: listOf()
    }
}
