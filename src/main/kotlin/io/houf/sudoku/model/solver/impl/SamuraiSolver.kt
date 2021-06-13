package io.houf.sudoku.model.solver.impl

import io.houf.sudoku.model.tile.Position
import io.houf.sudoku.model.tile.PositionedTile

class SamuraiSolver : DefaultSolver() {
    override fun getErrors(tiles: List<PositionedTile>): List<Position> {
        val groups = tiles.map { it.tile.group[0] }.distinct().map { group ->
            tiles.filter { (tile) ->
                val (a, b) = tile.group.split(',')

                a == group.toString() || b == group.toString()
            }
        }

        return groups.flatMap { super.getErrors(it) }.distinct()
    }
}
