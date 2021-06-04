package io.houf.sudoku.model.factory

import io.houf.sudoku.model.Puzzle
import io.houf.sudoku.model.PuzzleCandidate
import io.houf.sudoku.model.tile.DefaultTile
import io.houf.sudoku.model.visitor.DefaultTileVisitor
import io.houf.sudoku.model.visitor.TileVisitor

class DefaultPuzzleFactory : PuzzleFactory {
    override fun createPuzzle(candidate: PuzzleCandidate): Puzzle {
        val size = Character.getNumericValue(candidate.type[0])
        val puzzle = Puzzle(size)

        candidate.content.trim().forEachIndexed { index, character ->
            val rows = when (size) {
                4 -> 2
                else -> 3
            }
            val columns = when (size) {
                4, 6 -> 2
                else -> 3
            }

            val x = index % puzzle.size
            val y = index / puzzle.size
            val groupX = x / rows
            val groupY = y / columns * columns

            puzzle.setTile(x, y, DefaultTile(if (character == '0') null else character, "${groupX + groupY}"))
        }

        return puzzle
    }

    override fun createValidator(): TileVisitor {
        return DefaultTileVisitor()
    }
}
