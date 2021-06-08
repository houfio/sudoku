import io.houf.sudoku.model.tile.impl.DefaultTile
import kotlin.test.Test
import kotlin.test.assertEquals

internal class DefaultTileTest {
    @Test
    fun testSum() {
        val tile = DefaultTile(9, '0', "")

        assertEquals(tile.validChars.size, 9)
    }
}
