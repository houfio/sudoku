package io.houf.sudoku.model.puzzle

import io.houf.sudoku.model.solver.Solver
import io.houf.sudoku.model.tile.Tile
import io.houf.sudoku.model.tile.TileVisitor

class Puzzle(val size: Int, private val solver: Solver) {
    private val grid = Array(size) {
        arrayOfNulls<Tile>(size)
    }

    fun setTile(x: Int, y: Int, tile: Tile) {
        if (x < 0 || y < 0 || x >= size || y >= size) {
            return
        }

        grid[x][y] = tile
    }

    fun getTile(x: Int, y: Int): Tile? {
        if (x < 0 || y < 0 || x >= size || y >= size) {
            return null
        }

        return grid[x][y]
    }

    fun getTiles() = grid.flatMapIndexed { x, columns ->
        columns.mapIndexedNotNull { y, tile ->
            if (tile == null) null else Triple(x, y, tile)
        }
    }

    fun getErrors() = solver.getErrors(this)

    fun reset() {
        getTiles().forEach {
            it.third.enterValue(null)
        }
    }

    fun solve() {
        reset()
        solver.trySolve(this)
    }

    fun visitTiles(visitor: TileVisitor) {
        getTiles().forEach { (_, _, tile) ->
            tile.accept(visitor)
        }
    }
}
