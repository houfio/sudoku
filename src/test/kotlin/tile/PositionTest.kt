package tile

import io.houf.sudoku.model.tile.Position
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class PositionTest {

    fun arrange(): Position {
        val position = Position(5,5)
        return position
    }
    @Test
    fun topTest(){
        val position = arrange()

        val value: Position = position.top()

        assertTrue { value == Position(5,4) }
    }

    @Test
    fun bottomTest(){
        val position = arrange()

        val value: Position = position.bottom()

        println(value)
        assertTrue { value == Position(5,6) }
    }

    @Test
    fun leftTest(){
        val position = arrange()

        val value: Position = position.left()

        println(value)
        assertTrue { value == Position(4,5) }
    }

    @Test
    fun rightTest(){
        val position = arrange()

        val value: Position = position.right()

        println(value)
        assertTrue { value == Position(6,5) }
    }
}
