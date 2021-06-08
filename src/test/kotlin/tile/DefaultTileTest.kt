package tile

import io.houf.sudoku.model.tile.impl.DefaultTile
import org.junit.jupiter.api.Assertions.assertArrayEquals
import kotlin.test.Test
import kotlin.test.assertEquals

internal class DefaultTileTest {
    @Test
    fun testValidChars() {
        val tile = DefaultTile(6, '0', "")

        assertEquals(tile.validChars.size, 6)
        assertArrayEquals(tile.validChars, arrayOf('1', '2', '3', '4', '5', '6'))
    }
}
