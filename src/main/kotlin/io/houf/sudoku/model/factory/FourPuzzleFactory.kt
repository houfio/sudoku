package io.houf.sudoku.model.factory

import io.houf.sudoku.model.Puzzle
import io.houf.sudoku.model.PuzzleCandidate
import io.houf.sudoku.model.tile.DefaultTile
import io.houf.sudoku.model.visitor.DefaultTileVisitor
import io.houf.sudoku.model.visitor.TileVisitor

class FourPuzzleFactory : PuzzleFactory() {
    override fun createPuzzle(candidate: PuzzleCandidate): Puzzle {
        val puzzle = Puzzle(4)

        candidate.content.filter { it.isDigit() }.forEachIndexed { index, character ->
            val x = index / puzzle.size
            val y = index % puzzle.size

            val groupX = x / 4
            val groupY = y / 4 * 2

            puzzle.setTile(x, y, DefaultTile(if (character == '0') null else character, groupX + groupY))
        }

        return puzzle
    }

    override fun createValidator(): TileVisitor {
        return DefaultTileVisitor()
    }
}
