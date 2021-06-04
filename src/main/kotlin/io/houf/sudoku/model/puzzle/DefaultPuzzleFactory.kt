package io.houf.sudoku.model.puzzle

import io.houf.sudoku.model.Puzzle
import io.houf.sudoku.model.PuzzleCandidate
import io.houf.sudoku.model.tile.DefaultTile
import io.houf.sudoku.model.validator.DefaultValidator
import io.houf.sudoku.model.validator.Validator

class DefaultPuzzleFactory : PuzzleFactory {
    override fun createPuzzle(candidate: PuzzleCandidate): Puzzle {
        val size = Character.getNumericValue(candidate.type[0])
        val puzzle = Puzzle(size)
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

            puzzle.setTile(x, y, DefaultTile(if (character == '0') null else character, "${groupX + groupY}"))
        }

        return puzzle
    }

    override fun createValidator(): Validator {
        return DefaultValidator()
    }
}
