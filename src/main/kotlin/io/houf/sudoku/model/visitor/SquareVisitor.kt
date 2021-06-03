package io.houf.sudoku.model.visitor

import io.houf.sudoku.model.square.DefaultSquare

interface SquareVisitor {
    fun visitDefault(square: DefaultSquare)
}
