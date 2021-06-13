package io.houf.sudoku.model.puzzle.impl

import io.houf.sudoku.model.puzzle.Puzzle
import io.houf.sudoku.model.puzzle.PuzzleCandidate
import io.houf.sudoku.model.puzzle.PuzzleFactory
import io.houf.sudoku.model.solver.impl.SamuraiSolver
import io.houf.sudoku.model.tile.Position
import io.houf.sudoku.model.tile.impl.DefaultTile
import io.houf.sudoku.model.tile.impl.StaticTile

class SamuraiPuzzleFactory : PuzzleFactory {
    override fun createPuzzle(candidate: PuzzleCandidate): Puzzle? {
        val puzzle = Puzzle(21, SamuraiSolver())
        val size = 9
        val grids = candidate.content.trim().split("\n", "\r\n")

        if (grids.size != 5) {
            return null
        }

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
            val content = grid.trim()

            if (content.length != size * size) {
                return null
            }

            content.forEachIndexed { index, character ->
                val x = index % size
                val y = index / size
                val groupX = x / 3
                val groupY = y / 3 * 3
                val position = Position(x + offsetX, y + offsetY)
                val current = puzzle.getTile(position)?.group?.get(0)
                val group = "$id,${current ?: ""},${groupX + groupY}"
                val tile = if (character == '0') DefaultTile(puzzle.size, group) else StaticTile(character, group)

                puzzle.setTile(position, tile)
            }
        }

        return puzzle
    }
}
