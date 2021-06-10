package io.houf.sudoku.model.solver.impl

import io.houf.sudoku.model.puzzle.Puzzle
import io.houf.sudoku.model.solver.Solver
import io.houf.sudoku.model.tile.Position
import io.houf.sudoku.model.tile.PositionedTile
import io.houf.sudoku.model.tile.Tile

open class DefaultSolver : Solver {
    override fun trySolve(puzzle: Puzzle): Boolean {
        val tiles = getTileCandidates(puzzle.getTiles())
        val (tile) = tiles.firstOrNull { it.tile.value == null } ?: return true

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

    protected open fun getTileCandidates(tiles: List<PositionedTile>) = tiles

    protected fun getErrors(tiles: List<PositionedTile>): List<Position> {
        val columns = tiles.groupBy({ it.position.x }) { it.tile }
        val rows = tiles.groupBy({ it.position.y }) { it.tile }
        val groups = tiles.groupBy({ it.tile.group }) { it.tile }

        return tiles.filter { (tile, position) ->
            if (tile.value == null) {
                return@filter false
            }

            invalid(tile, columns[position.x]) || invalid(tile, rows[position.y]) || invalid(tile, groups[tile.group])
        }.map { it.position }
    }

    private fun invalid(tile: Tile, list: List<Tile>?) = list?.count { it.value == tile.value } ?: 0 > 1
}
