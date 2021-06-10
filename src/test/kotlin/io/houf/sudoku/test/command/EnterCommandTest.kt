package io.houf.sudoku.test.command

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.command.impl.EnterCommand
import io.houf.sudoku.model.tile.Position
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import kotlin.test.Test

internal class EnterCommandTest {
    private fun arrange(): Pair<EnterCommand, GameData> {
        val data = mock<GameData> {
            on { state } doReturn mock()
        }
        val command = EnterCommand(Position(0, 0), '0')

        return command to data
    }

    @Test
    fun testExecute() {
        val (command, data) = arrange()

        command.execute(data)

        verify(data.state).enter(data, Position(0, 0), '0')
    }

    @Test
    fun testRollback() {
        val (command, data) = arrange()

        command.rollback(data)

        verify(data.state).enter(data, Position(0, 0), null)
    }
}
