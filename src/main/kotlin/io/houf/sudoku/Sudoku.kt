package io.houf.sudoku

import io.houf.sudoku.controller.Controller
import io.houf.sudoku.controller.impl.OverviewController
import io.houf.sudoku.util.Fonts
import io.houf.sudoku.util.Gray0
import io.houf.sudoku.util.Gray500
import io.houf.sudoku.util.Loop
import io.houf.sudoku.widget.Widget
import io.houf.sudoku.widget.impl.FrameWidget
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

    init {
        foreground = Gray500
        background = Gray0
        isFocusable = true
        focusTraversalKeysEnabled = false
        isDoubleBuffered = true

        val listener = InputListener(frame, this)

        addMouseListener(listener)
        addMouseMotionListener(listener)
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
            reloadView()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    fun pop() {
        if (!canPop()) {
            return
        }

        controllers.pop()
        reloadView()
    }

    fun canPop(): Boolean {
        return controllers.size > 1
    }

    private fun reloadView() {
        widget = controllers.peek().createView()
        widget?.addChild(FrameWidget(this))
    }

    override fun paintComponent(graphics: Graphics) {
        super.paintComponent(graphics)

        val g = graphics as Graphics2D

        g.font = Fonts.Normal
        g.stroke = BasicStroke(2.0f)
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)

        widget?.draw(g)
    }

    private fun getWidgets(): List<Widget> {
        val list = mutableListOf<Widget>()

        widget?.forEach { list.add(it) }

        return list
    }

    fun tabFocus(reverse: Boolean) {
        val widgets = getWidgets()
        val targets = widgets.filter { it.canFocus() }
        val current = widgets.firstOrNull { it.focused }
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

        val widgets = getWidgets()
        val cursor = widgets.map { it.getCursor() }.lastOrNull { it != null } ?: Cursor.DEFAULT_CURSOR

        frame.cursor = Cursor.getPredefinedCursor(cursor)

        val requested = widgets.lastOrNull { it.requestingFocus } ?: return

        widgets.forEach { it.setFocus(false) }
        requested.setFocus(true)
    }
}
