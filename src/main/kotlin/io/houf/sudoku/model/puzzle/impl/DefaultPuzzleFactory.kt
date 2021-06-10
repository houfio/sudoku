package io.houf.sudoku.model.puzzle.impl

import io.houf.sudoku.model.puzzle.Puzzle
import io.houf.sudoku.model.puzzle.PuzzleCandidate
import io.houf.sudoku.model.puzzle.PuzzleFactory
import io.houf.sudoku.model.solver.impl.DefaultSolver
import io.houf.sudoku.model.tile.Position
import io.houf.sudoku.model.tile.impl.DefaultTile

class DefaultPuzzleFactory : PuzzleFactory {
    override fun createPuzzle(candidate: PuzzleCandidate): Puzzle? {
        val first = candidate.type[0]

        if (!first.isDigit()) {
            return null
        }

        val size = Character.getNumericValue(first)

        if (size != 4 && size != 6 && size != 9) {
            return null
        }

        val puzzle = Puzzle(size, DefaultSolver())
        val rows = when (size) {
            4 -> 2
            else -> 3
        }
        val columns = when (size) {
            4, 6 -> 2
            else -> 3
        }
        val content = candidate.content.trim()

        if (content.length != size * size) {
            return null
        }

        content.forEachIndexed { index, character ->
            val x = index % puzzle.size
            val y = index / puzzle.size
            val groupX = x / rows
            val groupY = y / columns * columns

            puzzle.setTile(Position(x, y), DefaultTile(puzzle.size, character, "${groupX + groupY}"))
        }

        return puzzle
    }
}
