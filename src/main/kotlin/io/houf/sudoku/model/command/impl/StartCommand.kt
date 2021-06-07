package io.houf.sudoku.model.command.impl

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.command.Command
import io.houf.sudoku.model.puzzle.PuzzleFactory

class StartCommand : Command<GameData> {
    override fun execute(context: GameData): Boolean {
        context.candidate?.let {
            context.puzzle = PuzzleFactory.get(it.type).createPuzzle(it)
        }

        return false
    }
}
