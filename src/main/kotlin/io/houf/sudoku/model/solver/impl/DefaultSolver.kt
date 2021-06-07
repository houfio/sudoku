package io.houf.sudoku.model.solver.impl

import io.houf.sudoku.model.puzzle.Puzzle
import io.houf.sudoku.model.solver.Solver
import io.houf.sudoku.model.tile.Tile

open class DefaultSolver : Solver {
    override fun trySolve(puzzle: Puzzle): Boolean {
        val tiles = getTileCandidates(puzzle.getTiles())
        val (_, _, tile) = tiles.firstOrNull { it.third.value == null } ?: return true

        tile.validChars.forEach {
            tile.enterValue(it)

            if (getErrors(tiles).isEmpty() && trySolve(puzzle)) {
                return true
            }

            tile.enterValue(null)
        }

        return false
    }

    override fun getErrors(puzzle: Puzzle) = getErrors(puzzle.getTiles())

    protected open fun getTileCandidates(tiles: List<Triple<Int, Int, Tile>>) = tiles

    private fun getErrors(tiles: List<Triple<Int, Int, Tile>>): List<Pair<Int, Int>> {
        val columns = tiles.groupBy({ it.first }, { it.third })
        val rows = tiles.groupBy({ it.second }, { it.third })
        val groups = tiles.groupBy({ it.third.group }, { it.third })

        return tiles.filter { (x, y, tile) ->
            if (tile.value == null) {
                return@filter false
            }

            invalid(tile, columns[x]) || invalid(tile, rows[y]) || invalid(tile, groups[tile.group])
        }.map { Pair(it.first, it.second) }
    }

    private fun invalid(tile: Tile, list: List<Tile>?) = list?.count { it.value == tile.value } ?: 0 > 1
}
