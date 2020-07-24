package screens.home

import data.Book
import org.w3c.dom.*
import view.RowBuilder
import kotlin.browser.document
import kotlin.dom.appendElement
import kotlin.dom.appendText

class HomePage(private val presenter: HomePagePresenter) : BookStoreContract.View {
    private val table: HTMLTableElement by lazy { document.getElementById("home_books_table") as HTMLTableElement }
    private val rowBuilder: RowBuilder = RowBuilder()

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

            val book = Book(
                    title = title,
                    genre = genre,
                    author = author,
                    price = "free",
                    description = genre,
                    url = "",
                    coverUrl = ""
            )
            appendBook(book)
        })
    }


    private fun appendBook(book: Book) {
        println(book.title)
        table.apply {
            val count = this.rows.length
            val row = insertRow(count)
            row.insertCell(0)
            row.insertCell(1)
            row.insertCell(2)
            row.cells.get(0)?.textContent = book.title
            row.cells.get(1)?.textContent = book.author
            row.cells.get(2)?.textContent = book.description
        }
    }

    override fun showBooks(books: List<Book>) = books.forEach(::appendBook)

    override fun showLoader() = Unit
    override fun hideLoader() = Unit
}