package io.houf.sudoku.model.command.impl

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.command.Command
import io.houf.sudoku.model.puzzle.PuzzleCandidate
import io.houf.sudoku.model.puzzle.PuzzleFactory

class StartCommand(private val candidate: PuzzleCandidate) : Command<GameData> {
    override fun execute(context: GameData): Boolean {
        context.puzzle = PuzzleFactory.get(candidate.type).createPuzzle(candidate)

        return false
    }
}
