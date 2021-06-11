package io.houf.sudoku.test.command

import io.houf.sudoku.model.GameData
import io.houf.sudoku.model.command.impl.StartCommand
import io.houf.sudoku.test.createCandidate
import kotlin.test.Test
import kotlin.test.assertNotNull

internal class StartCommandTest {
    private fun arrange(): Pair<StartCommand, GameData> {
        val data = GameData()
        val command = StartCommand(createCandidate("4x4", 16))

        return command to data
    }

    @Test
    fun testExecute() {
        val (command, data) = arrange()

        command.execute(data)

        assertNotNull(data.puzzle)
    }
}
