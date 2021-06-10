package tile

import io.houf.sudoku.model.tile.Tile
import io.houf.sudoku.model.tile.TileVisitor
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import kotlin.test.*

class TileTest {

    fun arrange(): Tile {
        val tile = TestTile()
        return tile

    }

    @Test
    fun enterValueTest() {
        val tile = arrange()

        tile.enterValue('2')

        assertEquals('2', tile.value)
    }

    @Test
    fun enterInvalidValueTest() {
        val tile = arrange()

        tile.enterValue('3')

        assertEquals(null, tile.value)
    }

    @Test
    fun enterNoteTest(){
        val tile = arrange()

        tile.enterNote('2')

        assertTrue { tile.isNoted('2') }
    }
    @Test
    fun enterInvalidNoteTest(){
        val tile = arrange()

        tile.enterNote('3')
        assertFalse { tile.isNoted('3') }
    }

    @Test
    fun enterNoteTwiceTest(){
        val tile = arrange()

        tile.enterNote('2')
        tile.enterNote('2')
        
        assertFalse { tile.isNoted('2') }
    }
    class TestTile : Tile('0', "") {
        override val validChars = arrayOf('2')

        override fun accept(visitor: TileVisitor) {
        }
    }
}

