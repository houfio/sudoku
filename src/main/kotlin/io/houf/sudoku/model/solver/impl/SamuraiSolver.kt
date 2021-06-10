package io.houf.sudoku.model.solver.impl

import io.houf.sudoku.model.puzzle.Puzzle
import io.houf.sudoku.model.tile.PositionedTile

class SamuraiSolver : DefaultSolver() {
    override fun getErrors(puzzle: Puzzle) = getGroups(puzzle.getTiles()).flatMap { getErrors(it) }.distinct()

    override fun getTileCandidates(tiles: List<PositionedTile>) = getGroups(tiles).firstOrNull { value ->
        value.any { it.tile.value == null }
    } ?: listOf()

    private fun getGroups(tiles: List<PositionedTile>) = tiles.map { it.tile.group[0] }.distinct().map { group ->
        tiles.filter { (tile) ->
            val (a, b) = tile.group.split(',')

            a == group.toString() || b == group.toString()
        }
    }
}
