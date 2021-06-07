package io.houf.sudoku.model.puzzle.impl

import io.houf.sudoku.model.puzzle.Puzzle
import io.houf.sudoku.model.puzzle.PuzzleCandidate
import io.houf.sudoku.model.puzzle.PuzzleFactory
import io.houf.sudoku.model.solver.impl.DefaultSolver
import io.houf.sudoku.model.tile.impl.DefaultTile

class DefaultPuzzleFactory : PuzzleFactory {
    override fun createPuzzle(candidate: PuzzleCandidate): Puzzle {
        val size = Character.getNumericValue(candidate.type[0])
        val puzzle = Puzzle(size, DefaultSolver())
        val rows = when (size) {
            4 -> 2
            else -> 3
        }
        val columns = when (size) {
            4, 6 -> 2
            else -> 3
        }

        candidate.content.trim().forEachIndexed { index, character ->
            val x = index % puzzle.size
            val y = index / puzzle.size
            val groupX = x / rows
            val groupY = y / columns * columns

            puzzle.setTile(x, y, DefaultTile(puzzle.size, character, "${groupX + groupY}"))
        }

        return puzzle
    }
}
