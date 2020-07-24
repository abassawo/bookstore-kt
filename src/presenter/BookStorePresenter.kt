package presenter

import API_URL
import BookStoreContract
import data.Book
import org.w3c.xhr.XMLHttpRequest

class BookStorePresenter : BookStoreContract.Presenter {
    private lateinit var view: BookStoreContract.View

    override fun attach(view: BookStoreContract.View) {
        this.view = view
        loadBooks()
    }

    override fun loadBooks() {
        view.showLoader()
        getBooks(API_URL, ::parseAndShowBooks)
    }

    private fun parseAndShowBooks(response: String) {
//        val books = JSON.parse<Array<Book>>(response)
        val books = emptyList<Book>()
        view.hideLoader()
        view.showBooks(books.toList())
    }

    private fun getBooks(url: String, callback: (String) -> Unit) {
        val xmlHttp = XMLHttpRequest()
        xmlHttp.open("GET", url)
        xmlHttp.onload = {
            if (xmlHttp.readyState == 4.toShort() && xmlHttp.status == 200.toShort()) {
                callback.invoke(xmlHttp.responseText)
            }
        }
        xmlHttp.send()
    }
}