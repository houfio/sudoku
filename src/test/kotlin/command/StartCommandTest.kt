package command

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.command.impl.StartCommand
import io.houf.sudoku.model.puzzle.PuzzleCandidate
import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

internal class StartCommandTest {
    private fun arrange(): Pair<GameData, StartCommand> {

        val data = GameData()
        data.candidate = PuzzleCandidate("test","4x4", "1123123")
        val context = StartCommand()

        return data to context
    }

    @Test
    fun testExecute(){
        val (data, context) = arrange()

        context.execute(data)

        assertNotNull(data.puzzle)
    }

}
