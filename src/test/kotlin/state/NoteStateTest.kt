package state

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.command.impl.EnterCommand
import io.houf.sudoku.model.state.impl.NoteState
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import kotlin.test.assertEquals
import kotlin.test.assertNull

class NoteStateTest {
    private fun arrange(): GameData {
        val data = mock<GameData> {
            on { state } doReturn NoteState()
        }

        return data
    }

    @Test
    fun testExecuteWithChar(){
        val data = arrange()
        val char = '1'

        var returns =  data.state.enter(data,1,1, char)

        assertEquals(returns, char)
    }
    @Test
    fun testExecuteNoChar() {
        val data = arrange()

        var returns =  data.state.enter(data,1,1,null)

       assertNull(returns)
    }
}
