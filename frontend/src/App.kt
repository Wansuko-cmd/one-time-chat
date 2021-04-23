import kotlinx.browser.document
import react.dom.render
import router

fun main(args: Array<String>) {
    render(document.getElementById("root")) {
        router()
    }
}
