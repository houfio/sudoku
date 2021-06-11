package io.houf.sudoku.test.puzzle

import io.houf.sudoku.test.createCandidate
import kotlin.test.Test
import kotlin.test.assertEquals

internal class PuzzleCandidateTest {
    @Test
    fun testFullName() {
        val candidate =  createCandidate("4x4", 16)

        assertEquals(candidate.fullName, "test.4x4")
    }
}
