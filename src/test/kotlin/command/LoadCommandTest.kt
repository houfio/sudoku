package command

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.command.impl.LoadCommand
import io.houf.sudoku.model.puzzle.PuzzleCandidate
import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

internal class LoadCommandTest {
    private fun arrange(): Pair<GameData, LoadCommand> {

        val data = GameData()
        val candidate = PuzzleCandidate("test","4x4", "1123123")

        val context = LoadCommand(candidate)

        return data to context
    }

    @Test
    fun testExecute(){
        val (data, context) = arrange()

        context.execute(data)

        assertNotNull(data.candidate)
    }
}
