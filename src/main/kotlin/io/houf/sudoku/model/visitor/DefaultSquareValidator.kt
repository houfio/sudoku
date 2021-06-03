package io.houf.sudoku.model.visitor

import io.houf.sudoku.model.square.DefaultSquare

class DefaultSquareValidator : SquareVisitor {
    override fun visitDefault(square: DefaultSquare) {
        println(square)
    }
}
