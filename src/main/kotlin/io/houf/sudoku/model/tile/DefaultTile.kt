package io.houf.sudoku.model.tile

class DefaultTile(value: Char?, group: String) : Tile(value, group) {
    override fun accept(visitor: TileVisitor) {
        visitor.visitDefault(this)
    }
}
