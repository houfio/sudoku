package io.houf.sudoku.model

import io.houf.sudoku.model.tile.Tile

class Puzzle(val size: Int) {
    private val grid = Array(size) {
        arrayOfNulls<Tile>(size)
    }

    fun setTile(x: Int, y: Int, tile: Tile) {
        if (grid[x][y] != null) {
            throw IllegalArgumentException()
        }

        grid[x][y] = tile
    }

    fun getTile(x: Int, y: Int): Tile? {
        if (x < 0 || y < 0 || x >= size || y >= size) {
            return null
        }

        return grid[x][y]
    }

    fun forEachTile(fn: (Int, Int, Tile) -> Unit) {
        grid.forEachIndexed { x, rows ->
            rows.forEachIndexed { y, tile ->
                if (tile != null) {
                    fn(x, y, tile)
                }
            }
        }
    }
}
