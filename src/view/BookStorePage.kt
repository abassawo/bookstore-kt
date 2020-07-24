package view

import data.Book
import BookStoreContract.*
import org.w3c.dom.*
import kotlin.browser.document
import kotlin.browser.window
import kotlin.dom.clear

class BookStorePage(private val presenter: Presenter) : View {
    private val cardBuilder = CardBuilder()
    private val loader by lazy { document.getElementById("loader") as HTMLDivElement }
    private val content by lazy { document.getElementById("content") as HTMLDivElement }
    override fun showLoader() = loader.setVisible(true)
    override fun hideLoader() = loader.setVisible(false)

    fun show() {
        presenter.attach(this)
        initButtonListener(document.getElementById("add_new_book_btn") as HTMLButtonElement)
    }

    private fun initButtonListener(button: HTMLButtonElement) {
        button.addEventListener("click", {
            val fTitle = document.getElementById("fTitle") as HTMLInputElement
            val fAuthor = document.getElementById("fAuthor") as HTMLInputElement
            val fGenre = document.getElementById("fGenre") as HTMLInputElement

            val title = fTitle.value.also { fTitle.value = "" }
            val author = fAuthor.value.also { fAuthor.value = "" }
            val genre = fGenre.value.also { fGenre.value = "" }

            println("Submitting $title $author $genre")

            val book = Book(title, "free", author, genre, "https://image.flaticon.com/icons/png/512/130/130304.png")
            appendBook(book)
        })
    }

    override fun showBooks(books: List<Book>) = books.forEach(::appendBook)

    private fun appendBook(book: Book) {
        println(book.title)
        val card = cardBuilder.build(book)
        content.appendChild(card)
    }
}


private fun HTMLElement.setVisible(visible: Boolean) =
        if (visible) {
            this.style.visibility = "visible"
        } else {
            style.visibility = "hidden"
        }
