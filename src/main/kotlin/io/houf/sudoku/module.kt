package io.houf.sudoku

import io.houf.sudoku.service.PuzzleReader
import io.houf.sudoku.service.impl.DefaultPuzzleReader
import org.koin.dsl.module

val module = module {
    single<PuzzleReader> {
        DefaultPuzzleReader()
    }
}
