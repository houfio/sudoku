package io.houf.sudoku.util

import java.awt.Font
import java.awt.GraphicsEnvironment

object Fonts {
    val Small: Font
    val Normal: Font
    val Big: Font

    init {
        val font = Font.createFont(Font.TRUETYPE_FONT, Fonts::class.java.getResourceAsStream("/fonts/RobotoMono.ttf"))

        Small = font.deriveFont(10.0f)
        Normal = font.deriveFont(16.0f)
        Big = font.deriveFont(Font.BOLD, 24.0f)

        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font)
    }
}
