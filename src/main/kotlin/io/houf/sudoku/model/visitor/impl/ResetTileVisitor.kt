package io.houf.sudoku.model.visitor.impl

import io.houf.sudoku.model.tile.impl.DefaultTile
import io.houf.sudoku.model.tile.impl.StaticTile
import io.houf.sudoku.model.visitor.TileVisitor

class ResetTileVisitor : TileVisitor {
    override fun visit(tile: DefaultTile) {
        tile.enterValue(null)

        tile.validChars.forEach { char ->
            while (tile.isNoted(char)) {
                tile.enterNote(char)
            }
        }
    }

    override fun visit(tile: StaticTile) {
    }
}
