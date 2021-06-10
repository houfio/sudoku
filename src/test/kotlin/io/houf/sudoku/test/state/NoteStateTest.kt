package io.houf.sudoku.test.state

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.state.impl.NoteState
import io.houf.sudoku.model.tile.Position
import org.mockito.kotlin.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class NoteStateTest {
    private fun arrange(): Pair<NoteState, GameData> {
        val state = NoteState()
        val data = mock<GameData> {
            on { puzzle } doReturn mock()
        }

        whenever(data.puzzle?.getTile(any())).thenReturn(mock())

        return state to data
    }

    @Test
    fun testEnterChar() {
        val (state, data) = arrange()
        val position = Position(1, 1)
        val value = state.enter(data, position, '0')

        assertEquals('0', value)
        verify(data.puzzle)?.getTile(position)
        verify(data.puzzle?.getTile(position))?.enterNote('0')
    }

    @Test
    fun testEnterNull() {
        val (state, data) = arrange()
        val value = state.enter(data, Position(1, 1), null)

        assertNull(value)
        verify(data.puzzle, times(0))?.getTile(any())
    }
}
