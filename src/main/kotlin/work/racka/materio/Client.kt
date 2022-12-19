package work.racka.materio

import browser.document
import dom.html.HTML.div
import dom.html.createElement
import react.create
import react.dom.client.createRoot

fun main() {
    val container = document.createElement(div)
        .also { document.body.appendChild(it) }

    val welcome = Welcome.create {
        name = "Kotlin/JS"
    }
    createRoot(container).render(welcome)
}