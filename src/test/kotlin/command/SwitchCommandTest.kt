package command

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.command.impl.SwitchCommand
import io.houf.sudoku.model.state.impl.NoteState
import io.houf.sudoku.model.state.impl.PlayState
import org.junit.jupiter.api.Test
import org.koin.core.component.getScopeName
import kotlin.test.assertEquals

internal class SwitchCommandTest {
    private fun arrange(): Pair<GameData, SwitchCommand> {
        val data = GameData()
        data.state = PlayState()

        val context = SwitchCommand()

        return data to context
    }

    @Test
    fun testExecute() {
        val (data, command) = arrange()

        command.execute(data)

        assertEquals(data.state.getScopeName(), NoteState().getScopeName())
    }

    @Test
    fun testRollback() {
        val (data, command) = arrange()

        command.execute(data)
        command.rollback(data)

        assertEquals(data.state.getScopeName(), PlayState().getScopeName())
    }
}
