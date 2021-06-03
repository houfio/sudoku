package io.houf.sudoku.model

import io.houf.sudoku.model.tile.Tile

class Puzzle(val size: Int) {
    private val grid = Array(size) {
        arrayOfNulls<Tile>(size)
    }

    fun setTile(x: Int, y: Int, tile: Tile) {
        if (grid[x][y] != null) {
            throw  IllegalArgumentException()
        }

        grid[x][y] = tile
    }
}
