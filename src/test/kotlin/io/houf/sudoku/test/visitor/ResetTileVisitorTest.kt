package io.houf.sudoku.test.visitor

import io.houf.sudoku.model.tile.impl.DefaultTile
import io.houf.sudoku.model.visitor.impl.ResetTileVisitor
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertNull

internal class ResetTileVisitorTest {
    private fun arrange(): Pair<ResetTileVisitor, DefaultTile> {
        val visitor = ResetTileVisitor()
        val tile = DefaultTile(4, "")

        tile.enterValue('1')
        tile.enterNote('1')

        return visitor to tile
    }

    @Test
    fun testValue() {
        val (visitor, tile) = arrange()

        tile.accept(visitor)

        assertNull(tile.value)
    }

    @Test
    fun testNote() {
        val (visitor, tile) = arrange()

        tile.accept(visitor)

        assertFalse(tile.isNoted('1'))
    }
}
