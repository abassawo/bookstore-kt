package view

import data.Book
import BookStoreContract.*
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement
import kotlin.browser.document

class BookStorePage(private val presenter: Presenter) : View {
    private val cardBuilder = CardBuilder()
    private val loader by lazy {  document.getElementById("loader") as HTMLDivElement }
    private val content by lazy {  document.getElementById("content") as HTMLDivElement }

    override fun showLoader() = loader.setVisible(true)
    override fun hideLoader() = loader.setVisible(false)

    fun show() {
        presenter.attach(this)
        presenter.loadBooks()
    }

    override fun showBooks(books: List<Book>) {
        books.forEach { book ->
            println(book.title)
            val card = cardBuilder.build(book)
            content.appendChild(card)
        }
    }
}

private fun HTMLElement.setVisible(visible: Boolean) =
        if (visible) {
            this.style.visibility = "visible"
        } else {
            style.visibility = "hidden"
        }
