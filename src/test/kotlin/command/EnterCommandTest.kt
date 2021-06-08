package command

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.command.impl.EnterCommand
import io.houf.sudoku.model.puzzle.Puzzle
import io.houf.sudoku.model.solver.impl.DefaultSolver
import io.houf.sudoku.model.state.State
import io.houf.sudoku.model.state.impl.PlayState
import kotlin.test.Test
import kotlin.test.assertTrue

internal class EnterCommandTest {
    @Test
    fun executeTest() {
        val data = GameData()
        val context = EnterCommand(0, 0, '0')

        data.puzzle = Puzzle(9, DefaultSolver())

        context.execute(data)

        
    }
}
