package state

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.state.impl.PlayState
import io.houf.sudoku.model.tile.Position
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*

internal class PlayStateTest {
    private fun arrange(): Pair<PlayState, GameData> {
        val state = PlayState()
        val data = mock<GameData> {
            on { puzzle } doReturn mock()
        }

        whenever(data.puzzle?.getTile(any())).thenReturn(mock())

        return state to data
    }

    @Test
    fun testEnter() {
        val (state, data) = arrange()
        val position = Position(1,1)

        state.enter(data, position, '0')

        verify(data.puzzle)?.getTile(position)
        verify(data.puzzle?.getTile(position))?.enterValue('0')
    }
}
