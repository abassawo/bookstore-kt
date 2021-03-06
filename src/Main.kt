import presenter.BookStorePresenter
import view.BookStorePage

val API_URL = js("getApiUrl()") as String

fun main(args: Array<String>) {
    val bookStorePresenter = BookStorePresenter()
    val bookStorePage = BookStorePage(bookStorePresenter)
    bookStorePage.show()
}