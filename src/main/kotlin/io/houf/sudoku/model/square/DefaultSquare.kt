package io.houf.sudoku.model.square

import io.houf.sudoku.model.visitor.SquareVisitor

class DefaultSquare : Square() {
    override fun accept(visitor: SquareVisitor) {
        visitor.visitDefault(this)
    }
}
