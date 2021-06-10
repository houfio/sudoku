package command

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.command.impl.EnterCommand
import io.houf.sudoku.model.tile.Position
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import kotlin.test.Test

internal class EnterCommandTest {
    private fun arrange(): Pair<GameData, EnterCommand> {
        val data = mock<GameData> {
            on { state } doReturn mock()
        }
        val context = EnterCommand(Position(0, 0), '0')

        return data to context
    }

    @Test
    fun testExecute() {
        val (data, command) = arrange()

        command.execute(data)

        verify(data.state).enter(data, Position(0, 0), '0')
    }

    @Test
    fun testRollback() {
        val (data, command) = arrange()

        command.rollback(data)

        verify(data.state).enter(data, Position(0, 0), null)
    }
}
