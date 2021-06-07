package io.houf.sudoku.util.state

import io.houf.sudoku.Sudoku

interface State  {
    fun enter(sudoku: Sudoku, x: Int, y: Int, char: Char?);
}
