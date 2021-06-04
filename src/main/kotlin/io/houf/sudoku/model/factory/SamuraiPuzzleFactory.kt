package io.houf.sudoku.model.factory

import io.houf.sudoku.model.Puzzle
import io.houf.sudoku.model.PuzzleCandidate
import io.houf.sudoku.model.tile.DefaultTile
import io.houf.sudoku.model.visitor.DefaultTileVisitor
import io.houf.sudoku.model.visitor.TileVisitor

class SamuraiPuzzleFactory : PuzzleFactory {
    override fun createPuzzle(candidate: PuzzleCandidate): Puzzle {
        val puzzle = Puzzle(21)
        val grids = candidate.content.split("\n", "\r\n")

        grids.forEachIndexed { id, grid ->
            val offsetX = when (id) {
                0, 3 -> 0
                1, 4 -> 12
                else -> 6
            }
            val offsetY = when (id) {
                0, 1 -> 0
                3, 4 -> 12
                else -> 6
            }

            grid.forEachIndexed { index, character ->
                val x = index % 9
                val y = index / 9
                val groupX = x / 3
                val groupY = y / 3 * 3

                puzzle.setTile(x + offsetX, y + offsetY, DefaultTile(if (character == '0') null else character, "$id${groupX + groupY}"))
            }
        }

        return puzzle
    }

    override fun createValidator(): TileVisitor {
        return DefaultTileVisitor()
    }
}
