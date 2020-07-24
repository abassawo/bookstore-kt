import presenter.BookStorePresenter
import screens.home.HomePage
import screens.home.HomePagePresenter
import view.BookStorePage

val API_URL = js("getApiUrl()") as String

fun main(args: Array<String>) {
//    val bookStorePresenter = BookStorePresenter()
//    val bookStorePage = BookStorePage(bookStorePresenter)
//    bookStorePage.show()

    val homePresenter = HomePagePresenter()
    val homePage = HomePage(homePresenter)
    homePage.show()
}