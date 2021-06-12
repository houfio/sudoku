package io.houf.sudoku.test.tile

import io.houf.sudoku.model.tile.Tile
import io.houf.sudoku.model.visitor.TileVisitor
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class TileTest {
    fun arrange(static: Boolean = false) = TestTile(if (static) '2' else null)

    @Test
    fun valueTest() {
        val tile = arrange()

        tile.enterValue('1')

        assertEquals('1', tile.value)
    }

    @Test
    fun invalidValueTest() {
        val tile = arrange()

        tile.enterValue('2')

        assertEquals(null, tile.value)
    }

    @Test
    fun noteTest() {
        val tile = arrange()

        tile.enterNote('1')

        assertTrue(tile.isNoted('1'))
    }

    @Test
    fun invalidNoteTest() {
        val tile = arrange()

        tile.enterNote('2')
        assertFalse(tile.isNoted('2'))
    }

    @Test
    fun noteToggleTest() {
        val tile = arrange()

        tile.enterNote('1')
        tile.enterNote('1')

        assertFalse(tile.isNoted('1'))
    }

    class TestTile(char: Char?) : Tile(char, "") {
        override val validChars = arrayOf('1')

        override fun accept(visitor: TileVisitor) {
        }
    }
}
