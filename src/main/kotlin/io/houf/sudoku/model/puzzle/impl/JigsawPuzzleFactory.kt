package io.houf.sudoku.model.puzzle.impl

import io.houf.sudoku.model.puzzle.Puzzle
import io.houf.sudoku.model.puzzle.PuzzleCandidate
import io.houf.sudoku.model.puzzle.PuzzleFactory
import io.houf.sudoku.model.tile.impl.DefaultTile
import io.houf.sudoku.model.validator.impl.DefaultValidator

class JigsawPuzzleFactory : PuzzleFactory {
    override fun createPuzzle(candidate: PuzzleCandidate): Puzzle {
        val puzzle = Puzzle(9, DefaultValidator())

        candidate.content.substring(10).trim().split("=").forEachIndexed { index, tile ->
            val x = index % puzzle.size
            val y = index / puzzle.size

            puzzle.setTile(x, y, DefaultTile(puzzle.size, tile[0], tile[2].toString()))
        }

        return puzzle
    }
}
