package command

import io.houf.sudoku.model.command.Command
import io.houf.sudoku.model.command.CommandExecutor
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class CommandExecutorTest {
    private fun arrange(): Pair<CommandExecutor<ExecutorContext>, ExecutorContext> {
        val context = ExecutorContext()
        val executor = CommandExecutor(context)

        return executor to context
    }

    @Test
    fun testExecute() {
        val (executor, context) = arrange()

        executor.execute(ExecutorCommand())

        assertEquals(1, context.data)
    }

    @Test
    fun testRollback() {
        val (executor, context) = arrange()

        executor.execute(ExecutorCommand())
        executor.rollback()
        executor.rollback()

        assertEquals(0, context.data)
    }

    @Test
    fun testEmpty() {
        val (executor) = arrange()
        val before = executor.empty()

        executor.execute(ExecutorCommand())

        assertTrue(before)
        assertFalse(executor.empty())
    }

    data class ExecutorContext(
        var data: Int = 0
    )

    class ExecutorCommand : Command<ExecutorContext> {
        override fun execute(context: ExecutorContext): Boolean {
            context.data++

            return true
        }

        override fun rollback(context: ExecutorContext) {
            context.data--
        }
    }
}
