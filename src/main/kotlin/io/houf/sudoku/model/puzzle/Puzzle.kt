package io.houf.sudoku.model.puzzle

import io.houf.sudoku.model.tile.Tile

class Puzzle(val size: Int) {
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
}
