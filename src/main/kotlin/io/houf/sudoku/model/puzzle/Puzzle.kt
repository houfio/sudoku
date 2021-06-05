package io.houf.sudoku.model.puzzle

import io.houf.sudoku.model.tile.Tile
import io.houf.sudoku.model.tile.TileVisitor
import io.houf.sudoku.model.validator.Validator

class Puzzle(val size: Int, private val validator: Validator) {
    private val grid = Array(size) {
        arrayOfNulls<Tile>(size)
    }

    fun setTile(x: Int, y: Int, tile: Tile) {
        if (grid[x][y] != null) {
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

    fun getErrors() = validator.getErrors(this)

    fun solve() {
        getTiles().forEach {
            it.third.enterChar(null)
        }

        trySolve()
    }

    private fun trySolve(): Boolean {
        val (_, _, tile) = getTiles().firstOrNull { it.third.value == null } ?: return true

        tile.validChars.forEach {
            tile.enterChar(it)

            if (getErrors().isEmpty() && trySolve()) {
                return true
            }

            tile.enterChar(null)
        }

        return false
    }

    fun visitTiles(visitor: TileVisitor) {
        getTiles().forEach { (_, _, tile) ->
            tile.accept(visitor)
        }
    }
}
