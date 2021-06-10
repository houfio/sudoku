package io.houf.sudoku.model.puzzle

import io.houf.sudoku.model.solver.Solver
import io.houf.sudoku.model.tile.Position
import io.houf.sudoku.model.tile.PositionedTile
import io.houf.sudoku.model.tile.Tile
import io.houf.sudoku.model.tile.TileVisitor

class Puzzle(val size: Int, private val solver: Solver) {
    private val grid = Array(size) {
        arrayOfNulls<Tile>(size)
    }

    fun setTile(position: Position, tile: Tile) {
        if (!position.inside(size)) {
            return
        }

        grid[position.x][position.y] = tile
    }

    fun getTile(position: Position): Tile? {
        if (!position.inside(size)) {
            return null
        }

        return grid[position.x][position.y]
    }

    fun getTiles() = grid.flatMapIndexed { x, columns ->
        columns.mapIndexedNotNull { y, tile ->
            if (tile == null) null else PositionedTile(tile, Position(x, y))
        }
    }

    fun getErrors() = solver.getErrors(this)

    fun reset() {
        getTiles().forEach { (tile) ->
            tile.enterValue(null)
        }
    }

    fun solve() {
        reset()
        solver.trySolve(this)
    }

    fun visitTiles(visitor: TileVisitor) {
        getTiles().forEach { (tile) ->
            tile.accept(visitor)
        }
    }
}
