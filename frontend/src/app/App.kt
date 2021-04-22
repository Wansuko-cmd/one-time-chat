package app

import kotlinx.browser.document
import react.dom.*
import router

fun main(args: Array<String>) {
    render(document.getElementById("root")) {
        router()
    }
}
