package io.houf.sudoku.util

import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

class Loop private constructor(private val futures: List<ScheduledFuture<*>>) {
    fun stop() {
        futures.forEach { it.cancel(true) }
    }

    companion object {
        fun start(vararg loops: Pair<Int, () -> Unit>): Loop {
            val pool = Executors.newScheduledThreadPool(loops.size)
            val executors = loops.map { (key, value) ->
                pool.scheduleAtFixedRate(value, 0, (1000 / key).toLong(), TimeUnit.MILLISECONDS)
            }

            return Loop(executors)
        }
    }
}
