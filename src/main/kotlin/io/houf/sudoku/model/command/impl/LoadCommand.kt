package io.houf.sudoku.model.command.impl

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.command.Command
import io.houf.sudoku.model.puzzle.PuzzleCandidate

class LoadCommand(private val candidate: PuzzleCandidate) : Command<GameData> {
    override fun execute(context: GameData): Boolean {
        context.candidate = candidate

        return false
    }
}
