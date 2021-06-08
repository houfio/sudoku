package command

import io.houf.sudoku.model.command.Command
import io.houf.sudoku.model.command.CommandExecutor
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class CommandExecutorTest {
    private fun arrange(): Pair<ExecutorContext, CommandExecutor<ExecutorContext>> {
        val context = ExecutorContext()
        val executor = CommandExecutor(context)

        return context to executor
    }

    @Test
    fun testExecute() {
        val (context, executor) = arrange()

        executor.execute(ExecutorCommand())

        assertEquals(context.data, 1)
    }

    @Test
    fun testRollback() {
        val (context, executor) = arrange()

        executor.execute(ExecutorCommand())
        executor.rollback()
        executor.rollback()

        assertEquals(context.data, 0)
    }

    @Test
    fun testEmpty() {
        val (_, executor) = arrange()
        val before = executor.empty()

        executor.execute(ExecutorCommand())

        assertTrue { before }
        assertFalse { executor.empty() }
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
