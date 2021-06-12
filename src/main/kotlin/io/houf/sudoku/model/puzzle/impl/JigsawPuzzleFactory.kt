package io.houf.sudoku.model.puzzle.impl

import io.houf.sudoku.model.puzzle.Puzzle
import io.houf.sudoku.model.puzzle.PuzzleCandidate
import io.houf.sudoku.model.puzzle.PuzzleFactory
import io.houf.sudoku.model.solver.impl.DefaultSolver
import io.houf.sudoku.model.tile.Position
import io.houf.sudoku.model.tile.impl.DefaultTile
import io.houf.sudoku.model.tile.impl.StaticTile

class JigsawPuzzleFactory : PuzzleFactory {
    override fun createPuzzle(candidate: PuzzleCandidate): Puzzle? {
        val puzzle = Puzzle(9, DefaultSolver())
        val content = candidate.content.substring(10).trim().split("=")

        if (content.size != puzzle.size * puzzle.size) {
            return null
        }

        content.forEachIndexed { index, raw ->
            val x = index % puzzle.size
            val y = index / puzzle.size
            val group = raw[2].toString()
            val tile = if (raw[0] == '0') DefaultTile(puzzle.size, group) else StaticTile(raw[0], group)

            puzzle.setTile(Position(x, y), tile)
        }

        return puzzle
    }
}
