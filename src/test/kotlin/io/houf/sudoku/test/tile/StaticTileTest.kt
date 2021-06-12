package io.houf.sudoku.test.tile

import io.houf.sudoku.model.tile.impl.StaticTile
import io.houf.sudoku.model.visitor.TileVisitor
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class StaticTileTest {
    private fun arrange(): Pair<StaticTile, TileVisitor> {
        val tile = StaticTile('1', "")
        val visitor = mock<TileVisitor>()

        return tile to visitor
    }

    @Test
    fun testValidChars() {
        val (tile) = arrange()

        assertTrue(tile.validChars.isEmpty())
    }

    @Test
    fun testValidChar() {
        val (tile) = arrange()

        assertFalse(tile.validCharacter(null))
        assertFalse(tile.validCharacter('1'))
    }

    @Test
    fun testAccept() {
        val (tile, visitor) = arrange()

        tile.accept(visitor)

        verify(visitor).visit(tile)
    }
}
