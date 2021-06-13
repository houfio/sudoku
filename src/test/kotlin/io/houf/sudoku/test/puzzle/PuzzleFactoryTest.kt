package io.houf.sudoku.test.puzzle

import io.houf.sudoku.model.puzzle.PuzzleFactory
import io.houf.sudoku.model.puzzle.impl.DefaultPuzzleFactory
import io.houf.sudoku.model.puzzle.impl.JigsawPuzzleFactory
import io.houf.sudoku.model.puzzle.impl.SamuraiPuzzleFactory
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertIs

internal class PuzzleFactoryTest {
    @Test
    fun testDefault4x4() {
        assertIs<DefaultPuzzleFactory>(PuzzleFactory.get("4x4"))
    }
    @Test
    fun testDefault6x6() {
        assertIs<DefaultPuzzleFactory>(PuzzleFactory.get("6x6"))
    }
    @Test
    fun testDefault9x9() {
        assertIs<DefaultPuzzleFactory>(PuzzleFactory.get("9x9"))
    }

    @Test
    fun testJigsaw() {
        assertIs<JigsawPuzzleFactory>(PuzzleFactory.get("jigsaw"))
    }

    @Test
    fun testSamurai() {
        assertIs<SamuraiPuzzleFactory>(PuzzleFactory.get("samurai"))
    }

    @Test
    fun testUnknown() {
        assertThrows<IllegalArgumentException> { PuzzleFactory.get("unknown") }
    }
}
