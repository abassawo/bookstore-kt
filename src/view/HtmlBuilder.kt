package view

import data.Book
import org.w3c.dom.HTMLElement

interface HtmlBuilder {
    fun build(book: Book): HTMLElement
}
