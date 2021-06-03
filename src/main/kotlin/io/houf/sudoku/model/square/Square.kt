package io.houf.sudoku.model.square

import io.houf.sudoku.model.visitor.SquareVisitor

abstract class Square {
    abstract fun accept(visitor: SquareVisitor)
}
