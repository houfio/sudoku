package command

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.command.impl.StartCommand
import io.houf.sudoku.model.puzzle.PuzzleCandidate
import kotlin.test.Test
import kotlin.test.assertNotNull

internal class StartCommandTest {
    private fun arrange(): Pair<StartCommand, GameData> {
        val data = GameData().apply {
            candidate = PuzzleCandidate("test", "4x4", "0000000000000000")
        }
        val command = StartCommand()

        return command to data
    }

    @Test
    fun testExecute() {
        val (command, data) = arrange()

        command.execute(data)

        assertNotNull(data.puzzle)
    }
}
