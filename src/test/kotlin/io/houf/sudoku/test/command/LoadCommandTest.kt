package io.houf.sudoku.test.command

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.command.impl.LoadCommand
import io.houf.sudoku.model.puzzle.PuzzleCandidate
import kotlin.test.Test
import kotlin.test.assertNotNull

internal class LoadCommandTest {
    private fun arrange(): Pair<LoadCommand, GameData> {
        val data = GameData()
        val command = LoadCommand(PuzzleCandidate("test", "4x4", "1123123"))

        return command to data
    }

    @Test
    fun testExecute() {
        val (command, data) = arrange()

        command.execute(data)

        assertNotNull(data.candidate)
    }
}
