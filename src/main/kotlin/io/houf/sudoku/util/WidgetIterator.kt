package io.houf.sudoku.util

import io.houf.sudoku.widget.Widget
import io.houf.sudoku.widget.WidgetGroup

class WidgetIterator(widget: Widget) : Iterator<Widget> {
    private val widgets = mutableListOf<Widget>()

    init {
        widgets.add(widget)
    }

    override fun hasNext(): Boolean {
        return widgets.isNotEmpty()
    }

    override fun next(): Widget {
        if (widgets.isEmpty()) {
            throw NoSuchElementException()
        }

        val widget = widgets.removeFirst()

        if (widget is WidgetGroup) {
            widgets.addAll(widget.getChildren())
        }

        return widget
    }
}
