package io.houf.sudoku.model.command.impl

import io.houf.sudoku.model.Game
import io.houf.sudoku.model.command.Command
import io.houf.sudoku.model.puzzle.PuzzleFactory

class StartCommand : Command<Game> {
    override fun execute(context: Game): Boolean {
        context.puzzleCandidate?.let {
            context.puzzle = PuzzleFactory.get(it.type).createPuzzle(it)
        }

        return false
    }
}
