package tile

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.tile.TileVisitor
import io.houf.sudoku.model.tile.impl.DefaultTile
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.mockito.Mock
import org.mockito.kotlin.*
import kotlin.test.Test
import kotlin.test.assertEquals

internal class DefaultTileTest {

    private fun arrange(): DefaultTile {
        val tile = DefaultTile(6, '0', "")

        return tile
    }

    @Test
    fun testValidChars() {

        val tile = arrange()

        assertEquals(tile.validChars.size, 6)
        assertArrayEquals(tile.validChars, arrayOf('1', '2', '3', '4', '5', '6'))
    }

    @Test
    fun testAccept(){

        val tile = arrange()
        val visitor = mock<TileVisitor>()

        tile.accept(visitor)

        verify(visitor).visitDefault(tile)
    }
}
