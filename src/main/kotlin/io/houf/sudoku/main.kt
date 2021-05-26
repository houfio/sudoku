package io.houf.sudoku

import javax.swing.JFrame
import javax.swing.WindowConstants

const val FrameSize = 768
const val TaskbarSize = 32

fun main() {
    val frame = JFrame()

    frame.title = "Sudoku"
    frame.setSize(FrameSize, FrameSize)
    frame.setLocationRelativeTo(null)
    frame.isResizable = false
    frame.isUndecorated = true
    frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    frame.add(Sudoku(frame))
    frame.isVisible = true
}
