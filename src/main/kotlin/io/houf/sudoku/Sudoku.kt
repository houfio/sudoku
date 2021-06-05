package io.houf.sudoku

import io.houf.sudoku.controller.Controller
import io.houf.sudoku.controller.impl.OverviewController
import io.houf.sudoku.model.Game
import io.houf.sudoku.util.Loop
import io.houf.sudoku.util.widget.Fonts
import io.houf.sudoku.util.widget.Gray0
import io.houf.sudoku.util.widget.Gray500
import io.houf.sudoku.widget.Widget
import java.awt.*
import java.awt.event.WindowEvent
import java.util.*
import javax.swing.JFrame
import javax.swing.JPanel

class Sudoku(private val frame: JFrame) : JPanel() {
    private val loop = Loop.start(
        30 to { update() },
        120 to { repaint() }
    )
    var widget: Widget? = null
        private set
    private val controllers = Stack<Controller<*>>()
    val game = Game()

    init {
        foreground = Gray500
        background = Gray0
        isFocusable = true
        focusTraversalKeysEnabled = false
        isDoubleBuffered = true

        val listener = InputListener(frame, this)

        addMouseListener(listener)
        addMouseMotionListener(listener)
        addMouseWheelListener(listener)
        addKeyListener(listener)

        push(OverviewController::class.java)
    }

    fun stop() {
        loop.stop()
        frame.dispatchEvent(WindowEvent(frame, WindowEvent.WINDOW_CLOSING))
    }

    fun <T : Controller<T>> push(cls: Class<out T>, replace: Boolean = false) {
        try {
            val controller = cls.getConstructor(Sudoku::class.java).newInstance(this)

            if (replace) {
                controllers.clear()
            }

            controllers.push(controller)
            widget = controller.createView()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    fun pop() {
        if (!canPop()) {
            return
        }

        controllers.pop()
        widget = controllers.peek().createView()
    }

    fun canPop(): Boolean {
        return controllers.size > 1
    }

    override fun paintComponent(graphics: Graphics) {
        super.paintComponent(graphics)

        val g = graphics as Graphics2D

        g.font = Fonts.Normal
        g.stroke = BasicStroke(2.0f)
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);

        widget?.draw(g)
    }

    fun tabFocus(reverse: Boolean) {
        val tree = widget?.toList() ?: return
        val targets = tree.filter { it.canFocus() }
        val current = tree.firstOrNull { it.focused }
        var index = targets.indexOf(current) + if (reverse) -1 else 1

        if (index < 0) {
            index = targets.size - 1
        } else if (index > targets.size - 1) {
            index = 0
        }

        targets[index].requestFocus()
    }

    private fun update() {
        widget?.update()

        val tree = widget?.toList() ?: return
        val cursor = tree.map { it.getCursor() }.lastOrNull { it != null } ?: Cursor.DEFAULT_CURSOR

        frame.cursor = Cursor.getPredefinedCursor(cursor)

        val requested = tree.lastOrNull { it.requestingFocus } ?: return

        tree.forEach { it.setFocus(false) }
        requested.setFocus(true)
    }
}
