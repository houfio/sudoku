package io.houf.sudoku.util.widget

import java.awt.Graphics2D

fun Graphics2D.drawCenteredString(string: String, x: Int, y: Int, width: Int, height: Int) {
    drawCenteredString(string, x, y + (height - fontMetrics.height) / 2 + fontMetrics.ascent, width)
}

fun Graphics2D.drawCenteredString(string: String, x: Int, y: Int, width: Int) {
    drawString(string, x + (width - fontMetrics.stringWidth(string)) / 2, y)
}
