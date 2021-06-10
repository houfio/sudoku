package tile

import io.houf.sudoku.model.tile.Position
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class PositionTest {
    fun arrange() = Position(5, 5)

    @Test
    fun testTop() {
        val position = arrange()

        assertEquals(Position(5, 4), position.top())
    }

    @Test
    fun testBottom() {
        val position = arrange()

        assertEquals(Position(5, 6), position.bottom())
    }

    @Test
    fun testLeft() {
        val position = arrange()

        assertEquals(Position(4, 5), position.left())
    }

    @Test
    fun testRight() {
        val position = arrange()

        assertEquals(Position(6, 5), position.right())
    }

    @Test
    fun testInside() {
        val position = arrange()

        assertFalse { position.inside(5) }
        assertTrue { position.inside(6) }
    }
}
