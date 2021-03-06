package io.houf.sudoku.test.tile

import io.houf.sudoku.model.tile.impl.DefaultTile
import io.houf.sudoku.model.visitor.TileVisitor
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import kotlin.test.Test

internal class DefaultTileTest {
    private fun arrange(): Pair<DefaultTile, TileVisitor> {
        val tile = DefaultTile(6, "")
        val visitor = mock<TileVisitor>()

        return tile to visitor
    }

    @Test
    fun testValidChars() {
        val (tile) = arrange()

        assertArrayEquals(arrayOf('1', '2', '3', '4', '5', '6'), tile.validChars)
    }

    @Test
    fun testAccept() {
        val (tile, visitor) = arrange()

        tile.accept(visitor)

        verify(visitor).visit(tile)
    }
}
