package io.houf.sudoku.model.puzzle.impl

import io.houf.sudoku.model.puzzle.Puzzle
import io.houf.sudoku.model.puzzle.PuzzleCandidate
import io.houf.sudoku.model.puzzle.PuzzleFactory
import io.houf.sudoku.model.solver.impl.SamuraiSolver
import io.houf.sudoku.model.tile.impl.DefaultTile

class SamuraiPuzzleFactory : PuzzleFactory {
    override fun createPuzzle(candidate: PuzzleCandidate): Puzzle {
        val puzzle = Puzzle(21, SamuraiSolver())
        val size = 9
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
                val x = index % size
                val y = index / size
                val groupX = x / 3
                val groupY = y / 3 * 3
                val current = puzzle.getTile(x + offsetX, y + offsetY)?.group?.get(0)

                puzzle.setTile(x + offsetX, y + offsetY, DefaultTile(size, character, "$id,${current ?: ""},${groupX + groupY}"))
            }
        }

        return puzzle
    }
}
