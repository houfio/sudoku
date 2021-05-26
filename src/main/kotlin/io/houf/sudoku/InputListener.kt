package io.houf.sudoku

import java.awt.Point
import java.awt.event.*
import javax.swing.JFrame

class InputListener(
    private val frame: JFrame,
    private val sudoku: Sudoku
) : MouseListener, MouseMotionListener, KeyListener {
    private var dragPoint: Point? = null

    override fun mouseClicked(event: MouseEvent) {
        sudoku.widget?.mouseClick(event.x, event.y)
    }

    override fun mousePressed(event: MouseEvent) {
        if (event.y <= TaskbarSize) {
            dragPoint = event.point
        }

        sudoku.widget?.mousePress(event.x, event.y)
    }

    override fun mouseReleased(event: MouseEvent) {
        dragPoint = null

        sudoku.widget?.mouseRelease(event.x, event.y)
    }

    override fun mouseEntered(event: MouseEvent) {
    }

    override fun mouseExited(event: MouseEvent) {
    }

    override fun mouseDragged(event: MouseEvent) {
        if (dragPoint != null) {
            frame.setLocation(event.locationOnScreen.x - dragPoint!!.x, event.locationOnScreen.y - dragPoint!!.y);

            return
        }

        sudoku.widget?.mouseDrag(event.x, event.y)
    }

    override fun mouseMoved(event: MouseEvent) {
        sudoku.widget?.mouseMove(event.x, event.y)
    }

    override fun keyTyped(event: KeyEvent) {
        sudoku.widget?.keyType(event.keyChar)
    }

    override fun keyPressed(event: KeyEvent) {
        if (event.extendedKeyCode == KeyEvent.VK_TAB) {
            sudoku.tabFocus(event.isShiftDown)

            return
        } else if (event.extendedKeyCode == KeyEvent.VK_ESCAPE) {
            sudoku.widget?.requestFocus()

            return
        }

        sudoku.widget?.keyPress(event.extendedKeyCode, event.modifiersEx)
    }

    override fun keyReleased(event: KeyEvent) {
    }
}
