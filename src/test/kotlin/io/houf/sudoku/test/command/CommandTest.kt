package io.houf.sudoku.test.command

import io.houf.sudoku.model.command.Command
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

internal class CommandTest {
    @Test
    fun testRollback() {
        val command = TestCommand()

        assertThrows<UnsupportedOperationException> { command.rollback({}) }
    }

    class TestCommand : Command<Any> {
        override fun execute(context: Any): Boolean {
            return false
        }
    }
}
