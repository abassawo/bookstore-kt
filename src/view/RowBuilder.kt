package view

import data.Book
import org.w3c.dom.*
import kotlin.browser.document

class RowBuilder : HtmlBuilder {

    private fun bind(book: Book,
                     titleElement: HTMLDivElement,
                     authorElement: HTMLDivElement,
                     genreElement: HTMLImageElement,
                     descriptionElement: HTMLDivElement,
                     viewDetailsButtonElement: HTMLButtonElement) {

        // 1
//        imageElement.src = book.coverUrl
//
//        // 2
        titleElement.innerHTML = book.title
//        priceElement.innerHTML = book.price
//        descriptionElement.innerHTML = book.description
//        viewDetailsButtonElement.innerHTML = "view details"
//
//        // 3
//        viewDetailsButtonElement.addEventListener("click", {
//            window.open(book.url)
//        })
    }

    override fun build(book: Book): HTMLElement {
        val containerElement = document.createElement("div") as HTMLDivElement
        val imageElement = document.createElement("img") as HTMLImageElement
        val titleElement = document.createElement("div") as HTMLDivElement
        val priceElement = document.createElement("div") as HTMLDivElement
        val descriptionElement = document.createElement("div") as HTMLDivElement
        val viewDetailsButtonElement = document.createElement("button") as HTMLButtonElement

        // 2
        bind(book = book,
                authorElement = priceElement,
                titleElement = titleElement,
                genreElement = imageElement,
                descriptionElement = descriptionElement,
                viewDetailsButtonElement = viewDetailsButtonElement)

        // 3

        containerElement.appendChild(titleElement)
        // 5
        return containerElement
    }
}