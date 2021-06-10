package command

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.command.impl.SwitchCommand
import io.houf.sudoku.model.state.impl.NoteState
import io.houf.sudoku.model.state.impl.PlayState
import kotlin.test.Test
import kotlin.test.assertIs

internal class SwitchCommandTest {
    private fun arrange(): Pair<SwitchCommand, GameData> {
        val data = GameData()
        val command = SwitchCommand()

        return command to data
    }

    @Test
    fun testExecute() {
        val (command, data) = arrange()

        command.execute(data)

        assertIs<NoteState>(data.state)
    }

    @Test
    fun testRollback() {
        val (command, data) = arrange()

        command.execute(data)
        command.rollback(data)

        assertIs<PlayState>(data.state)
    }
}
